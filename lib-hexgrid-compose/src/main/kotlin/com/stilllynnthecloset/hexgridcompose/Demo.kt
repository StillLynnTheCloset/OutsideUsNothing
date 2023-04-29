package com.stilllynnthecloset.hexgridcompose

import androidx.compose.foundation.Canvas
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.ExperimentalComposeUiApi
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clipToBounds
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.Path
import androidx.compose.ui.graphics.drawscope.DrawScope
import androidx.compose.ui.graphics.drawscope.Fill
import androidx.compose.ui.input.pointer.PointerEventType
import androidx.compose.ui.input.pointer.onPointerEvent
import androidx.compose.ui.text.AnnotatedString
import androidx.compose.ui.text.ExperimentalTextApi
import androidx.compose.ui.text.TextMeasurer
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.drawText
import androidx.compose.ui.text.rememberTextMeasurer
import androidx.compose.ui.text.style.TextAlign
import kotlin.math.cos
import kotlin.math.sin

public data class Node constructor(
    val row: Int,
    val col: Int,
    val label: AnnotatedString,
)

public data class Edge constructor(
    val node1: Node,
    val node2: Node,
    val cost: Int?,
)

@Composable
@OptIn(ExperimentalTextApi::class, ExperimentalComposeUiApi::class)
public fun hexGrid(
    modifier: Modifier,
    nodes: List<Node>,
    edges: List<Edge>,
    nodeSize: Float,
    nodeSpacing: Float,
    offset: Offset,
    onOffsetChanged: (Offset) -> Unit,
    scale: Float,
    onScaleChanged: (Float) -> Unit,
) {
    val textMeasurer = rememberTextMeasurer()
    val textColor = MaterialTheme.colorScheme.onPrimary
    val gridColor = MaterialTheme.colorScheme.primary
    val unitDistance = (nodeSize + nodeSpacing) * scale
    Canvas(
        modifier = modifier
            .onPointerEvent(PointerEventType.Scroll) {
                val scrollChange = it.changes.firstOrNull()?.scrollDelta?.y ?: 0f
                val newScale = (scale + scrollChange / 10f)
                    .coerceAtLeast(0.1f)
                    .coerceAtMost(5f)
                onScaleChanged(newScale)
            }
            .onPointerEvent(PointerEventType.Move) {
                if (it.changes.firstOrNull()?.pressed == true) {
                    val pixelOffset = it.changes.firstOrNull()?.let {
                        it.position - it.previousPosition
                    }

                    if (pixelOffset != null) {
                        val unitOffset = pixelOffset / unitDistance

                        onOffsetChanged(offset + unitOffset)
                    }
                }
            }
            .clipToBounds(),
    ) {
        edges.forEach {
            drawEdge(
                edge = it,
                offset = this.center + (offset * unitDistance),
                textMeasurer = textMeasurer,
                edgeColor = gridColor,
                textColor = textColor,
                nodeSize = nodeSize * scale,
                nodeSpacing = nodeSpacing * scale,
            )
        }

        nodes.forEach {
            drawHexagon(
                node = it,
                offset = this.center + (offset * unitDistance),
                textMeasurer = textMeasurer,
                fillColor = gridColor,
                textColor = textColor,
                nodeSize = nodeSize * scale,
                nodeSpacing = nodeSpacing * scale,
            )
        }
    }
}

@OptIn(ExperimentalTextApi::class)
private fun DrawScope.drawHexagon(
    node: Node,
    offset: Offset,
    textMeasurer: TextMeasurer,
    fillColor: Color,
    textColor: Color,
    nodeSize: Float,
    nodeSpacing: Float,
) {
    val center = screenCoordOfNode(offset, node, nodeSize, nodeSpacing)
    val hexagonPoints = hexagonPoints(center, nodeSize)
    val path = Path()
    path.moveTo(hexagonPoints[0].x, hexagonPoints[0].y)
    hexagonPoints.forEach {
        path.lineTo(it.x, it.y)
    }
    this.drawPath(path, fillColor, style = Fill)

    val measureResult = textMeasurer.measure(node.label, style = TextStyle(textAlign = TextAlign.Center))
    val barHorizontalCenter = center.x
    val textLeft = barHorizontalCenter - (measureResult.size.width / 2f)
    val textTop = center.y - (measureResult.size.height / 2f)
    drawText(
        textLayoutResult = measureResult,
        color = textColor,
        topLeft = Offset(textLeft, textTop),
    )
}

@OptIn(ExperimentalTextApi::class)
private fun DrawScope.drawEdge(
    edge: Edge,
    offset: Offset,
    textMeasurer: TextMeasurer,
    edgeColor: Color,
    textColor: Color,
    nodeSize: Float,
    nodeSpacing: Float,
) {
    val node1 = screenCoordOfNode(offset, edge.node1, nodeSize, nodeSpacing)
    val node2 = screenCoordOfNode(offset, edge.node2, nodeSize, nodeSpacing)

    this.drawLine(edgeColor, node1, node2, strokeWidth = 16f)

    if (edge.cost != null) {
        val x = arrayOf(node1.x, node2.x).average().toFloat()
        val y = arrayOf(node1.y, node2.y).average().toFloat()
        val measureResult = textMeasurer.measure(AnnotatedString("${edge.cost}"), style = TextStyle(textAlign = TextAlign.Center))
        val textLeft = x - (measureResult.size.width / 2f)
        val textTop = y - (measureResult.size.height / 2f)
        drawText(
            textLayoutResult = measureResult,
            color = textColor,
            topLeft = Offset(textLeft, textTop),
        )
    }
}

private fun hexagonPoints(center: Offset, r: Float): List<Offset> {
    return (0..6).map {
        val angle = findAngle(it.toDouble() / 6)
        Offset((center.x + cos(angle) * r).toFloat(), (center.y + sin(angle) * r).toFloat())
    }
}

private fun findAngle(fraction: Double): Double {
    return fraction * Math.PI * 2 + Math.toRadians(270.0)
}

private fun screenCoordOfNode(screenOrigin: Offset, node: Node, nodeSize: Float, nodeSpacing: Float): Offset {
    val ang30 = Math.toRadians(30.0)
    val rowOff = cos(ang30) * (nodeSize + nodeSpacing)
    val colOff = sin(ang30) * (nodeSize + nodeSpacing)
    val rowShift = if (node.row % 2 == 0) 0 else 1 // If the row is odd, shift it right by half of a row offset.
    val x = (screenOrigin.x + (rowOff * (node.col * 2 + rowShift))).toFloat()
    val y = (screenOrigin.y + colOff * (node.row) * 3).toFloat()
    return Offset(x, y)
}
