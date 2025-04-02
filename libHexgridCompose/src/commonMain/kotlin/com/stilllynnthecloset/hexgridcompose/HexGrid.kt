package com.stilllynnthecloset.hexgridcompose

import androidx.compose.foundation.Canvas
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.rememberUpdatedState
import androidx.compose.ui.Modifier
import androidx.compose.ui.composed
import androidx.compose.ui.draw.clipToBounds
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.Path
import androidx.compose.ui.graphics.StrokeCap
import androidx.compose.ui.graphics.StrokeJoin
import androidx.compose.ui.graphics.drawscope.DrawScope
import androidx.compose.ui.graphics.drawscope.Fill
import androidx.compose.ui.graphics.drawscope.Stroke
import androidx.compose.ui.input.pointer.AwaitPointerEventScope
import androidx.compose.ui.input.pointer.PointerEvent
import androidx.compose.ui.input.pointer.PointerEventPass
import androidx.compose.ui.input.pointer.PointerEventType
import androidx.compose.ui.input.pointer.pointerInput
import androidx.compose.ui.text.AnnotatedString
import androidx.compose.ui.text.TextMeasurer
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.drawText
import androidx.compose.ui.text.rememberTextMeasurer
import androidx.compose.ui.text.style.TextAlign
import com.stilllynnthecloset.outsideusnothing.library.map.HexGridCoordinate
import com.stilllynnthecloset.outsideusnothing.library.map.HexGridEdge
import com.stilllynnthecloset.outsideusnothing.library.map.HexGridNode
import com.stilllynnthecloset.outsideusnothing.library.map.PlaceholderNode
import kotlin.math.PI
import kotlin.math.cos
import kotlin.math.sin

private const val COORDINATE_DEBUG = true


public fun Modifier.onPointerEvent(
    eventType: PointerEventType,
    pass: PointerEventPass = PointerEventPass.Main,
    onEvent: AwaitPointerEventScope.(event: PointerEvent) -> Unit
): Modifier = composed {
    val currentEventType by rememberUpdatedState(eventType)
    val currentOnEvent by rememberUpdatedState(onEvent)
    pointerInput(pass) {
        awaitPointerEventScope {
            while (true) {
                val event = awaitPointerEvent(pass)
                if (event.type == currentEventType) {
                    currentOnEvent(event)
                }
            }
        }
    }
}

@Composable
public fun <T : HexGridNode> hexGrid(
    modifier: Modifier,
    nodes: List<T>,
    edges: List<HexGridEdge>,
    nodeSize: Float,
    nodeSpacing: Float,
    offset: Offset,
    onOffsetChanged: (Offset) -> Unit,
    scale: Float,
    onScaleChanged: (Float) -> Unit,
    highlightedNodes: List<Pair<HexGridCoordinate, Color>>,
    onNodeSelected: (T) -> Unit,
) {
    val textMeasurer = rememberTextMeasurer()
    val textColor = MaterialTheme.colorScheme.onPrimary
    val gridColor = MaterialTheme.colorScheme.primary
    val placeholderColor = MaterialTheme.colorScheme.outlineVariant
    val unitDistance = (nodeSize + nodeSpacing) * scale

    Canvas(
        modifier = modifier
            // web scroll changes by 138 per step
            // desktop scroll changes by 1 per step
            .onPointerEvent(PointerEventType.Scroll) {
                val scrollChange = it.changes.firstOrNull()?.scrollDelta?.y?.coerceIn(-1f..1f) ?: 0f
                val newScale = (scale + scrollChange / 10f).coerceIn(0.1f..5f)
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
            .onPointerEvent(PointerEventType.Release) {
                it.changes.firstOrNull()?.also { change ->
                    val timeDelta = change.uptimeMillis - change.previousUptimeMillis
                    println("timeDelta: $timeDelta")
                    if (timeDelta in 1..300) {
                        // Short click.
                        println("Short click at ${change.position}")

                        val viewCenter = this.size.let { Offset(it.width / 2f, it.height / 2f) }

                        val nodesBounds = nodeScreenBounds(
                            nodes,
                            viewCenter + (offset * unitDistance),
                            nodeSize * scale,
                            nodeSpacing * scale,
                        )

                        val node = nodesBounds.firstOrNull { offsetInPolygon(change.position, it.second) }?.first
                        if (node != null) {
                            println("Click in node: $node")
                            findAndCheckNeighbors(node, nodes, edges)
                            onNodeSelected(node)
                        }
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

        nodes.forEach { node ->
            val color = if (node is PlaceholderNode) placeholderColor else gridColor
            val selectedColor = highlightedNodes.firstOrNull { it.first == node.coordinate }?.second
            drawHexagon(
                node = node,
                offset = this.center + (offset * unitDistance),
                textMeasurer = textMeasurer,
                fillColor = color,
                textColor = textColor,
                nodeSize = nodeSize * scale,
                nodeSpacing = nodeSpacing * scale,
                selectedColor = selectedColor,
            )
        }
    }
}

private val neighborDeltas = listOf(
    // even rows
    listOf(
        listOf(1, 0),
        listOf(0, -1),
        listOf(-1, -1),
        listOf(-1, 0),
        listOf(-1, 1),
        listOf(0, 1),
    ),
    // odd rows
    listOf(
        listOf(1, 0),
        listOf(1, -1),
        listOf(0, -1),
        listOf(-1, 0),
        listOf(0, 1),
        listOf(1, 1),
    ),
)

public fun <T : HexGridNode> findAndCheckNeighbors(node: T, allNodes: List<T>, allEdges: List<HexGridEdge>) {
    println("Existing Connections:")
    findExistingConnections(node, allEdges).forEach {
        println("    ${it.cost} fuel to ${if (it.node1 == node.coordinate) it.node2 else it.node1}")
    }

    println("Existing Neighbors:")
    findExistingNeighbors(node, allNodes).forEach {
        println("    ${it.label.replace(Regex("\\s"), " ")}")
    }

    println("Empty Neighbors:")
    findEmptyNeighbors(node, allNodes).forEach {
        println("    (${it.row}, ${it.col})")
    }
}

public fun <T : HexGridNode> findExistingConnections(node: T, allEdges: List<HexGridEdge>): List<HexGridEdge> {
    return allEdges.filter { it.node1 == node.coordinate || it.node2 == node.coordinate }
}

public fun <T : HexGridNode> findExistingNeighbors(node: T, allNodes: List<T>): List<HexGridNode> {
    val neighborCoords = findAllNeighborCoords(node)

    return allNodes.filter { neighbor -> neighborCoords.any { it.row == neighbor.coordinate.row && it.col == neighbor.coordinate.col } }
}

public fun <T : HexGridNode> findEmptyNeighbors(node: T, allNodes: List<T>): List<HexGridCoordinate> {
    val neighborCoords = findAllNeighborCoords(node)

    return neighborCoords.filter { neighbor -> allNodes.none { it.coordinate.row == neighbor.row && it.coordinate.col == neighbor.col } }
}

public fun <T : HexGridNode> findAllNeighborCoords(node: T): List<HexGridCoordinate> {
    return (0 until 6).map { direction ->
        findNeighborCoords(node, direction)
    }
}

/**
 * [direction] is the selection of a neighbor, starting at 0 at 3:00, and going CCW
 */
public fun <T : HexGridNode> findNeighborCoords(node: T, direction: Int): HexGridCoordinate {
    val parity = node.coordinate.row and 1 // 1 if odd, 0 if even
    val diff = neighborDeltas[parity][direction]
    return HexGridCoordinate(node.coordinate.row + diff[1], node.coordinate.col + diff[0])
}

private fun <T : HexGridNode> nodeScreenBounds(
    nodes: List<T>,
    offset: Offset,
    nodeSize: Float,
    nodeSpacing: Float,
): List<Pair<T, List<Offset>>> {
    return nodes.map { it to hexagonOffsets(offsetOfNode(offset, it.coordinate, nodeSize, nodeSpacing), nodeSize) }
}

private fun <T : HexGridNode> DrawScope.drawHexagon(
    node: T,
    offset: Offset,
    textMeasurer: TextMeasurer,
    fillColor: Color,
    textColor: Color,
    nodeSize: Float,
    nodeSpacing: Float,
    selectedColor: Color?,
) {
    val center = offsetOfNode(offset, node.coordinate, nodeSize, nodeSpacing)
    val hexagonPoints = hexagonOffsets(center, nodeSize)
    val path = Path()
    path.moveTo(hexagonPoints[0].x, hexagonPoints[0].y)
    hexagonPoints.forEach {
        path.lineTo(it.x, it.y)
    }
    this.drawPath(path, fillColor, style = Fill)
    if (selectedColor != null) {
        val borderWidth = nodeSize / 15f
        this.drawPath(
            path = path,
            color = selectedColor,
            style = Stroke(
                width = borderWidth,
                miter = borderWidth,
                cap = StrokeCap.Round,
                join = StrokeJoin.Miter,
            ),
        )
    }

    val text = if (COORDINATE_DEBUG) {
        node.label + AnnotatedString("\n(${node.coordinate.row},${node.coordinate.col})")
    } else {
        node.label
    }

    val measureResult = textMeasurer.measure(text, style = TextStyle(textAlign = TextAlign.Center))

    if (measureResult.size.width <= nodeSize * 1.8) {
        val barHorizontalCenter = center.x
        val textLeft = barHorizontalCenter - (measureResult.size.width / 2f)
        val textTop = center.y - (measureResult.size.height / 2f)
        drawText(
            textLayoutResult = measureResult,
            color = textColor,
            topLeft = Offset(textLeft, textTop),
        )
    }

    if (node is PlaceholderNode) {
        drawLine(
            color = textColor,
            start = center.copy(y = center.y - nodeSize / 4),
            end = center.copy(y = center.y + nodeSize / 4),
            strokeWidth = nodeSize / 15,
            cap = StrokeCap.Round,
        )
        drawLine(
            color = textColor,
            start = center.copy(x = center.x - nodeSize / 4),
            end = center.copy(x = center.x + nodeSize / 4),
            strokeWidth = nodeSize / 15,
            cap = StrokeCap.Round,
        )
    }
}

private fun DrawScope.drawEdge(
    edge: HexGridEdge,
    offset: Offset,
    textMeasurer: TextMeasurer,
    edgeColor: Color,
    textColor: Color,
    nodeSize: Float,
    nodeSpacing: Float,
) {
    val node1 = offsetOfNode(offset, edge.node1, nodeSize, nodeSpacing)
    val node2 = offsetOfNode(offset, edge.node2, nodeSize, nodeSpacing)

    this.drawLine(edgeColor, node1, node2, strokeWidth = nodeSize / 5)

    if (edge.cost != null) {
        val x = arrayOf(node1.x, node2.x).average().toFloat()
        val y = arrayOf(node1.y, node2.y).average().toFloat()
        val measureResult = textMeasurer.measure(AnnotatedString("${edge.cost}"), style = TextStyle(textAlign = TextAlign.Center))

        if (measureResult.size.width <= nodeSpacing * 2) {
            val textLeft = x - (measureResult.size.width / 2f)
            val textTop = y - (measureResult.size.height / 2f)
            drawText(
                textLayoutResult = measureResult,
                color = textColor,
                topLeft = Offset(textLeft, textTop),
            )
        }
    }
}

private fun hexagonOffsets(center: Offset, size: Float): List<Offset> {
    return (0..6).map {
        val angle = findAngle(it.toDouble() / 6.0)
        Offset(
            x = (center.x + cos(angle) * size).toFloat(),
            y = (center.y + sin(angle) * size).toFloat(),
        )
    }
}

private fun toRadians(deg: Double): Double = deg / 180.0 * PI

private fun toDegrees(rad: Double): Double = rad * 180.0 / PI

private fun findAngle(fraction: Double): Double {
    return fraction * PI * 2 + toRadians(270.0)
}

private fun offsetOfNode(screenOrigin: Offset, coordinate: HexGridCoordinate, nodeSize: Float, nodeSpacing: Float): Offset {
    val ang30 = toRadians(30.0)
    val rowOff = cos(ang30) * (nodeSize + nodeSpacing)
    val colOff = sin(ang30) * (nodeSize + nodeSpacing)
    val rowShift = if (coordinate.row % 2 == 0) 0 else 1 // If the row is odd, shift it right by half of a row offset.
    val x = (screenOrigin.x + (rowOff * (coordinate.col * 2 + rowShift))).toFloat()
    val y = (screenOrigin.y + colOff * (coordinate.row) * 3).toFloat()
    return Offset(x, y)
}

public fun offsetInPolygon(test: Offset, positions: List<Offset>): Boolean {
    var result = false
    var index1 = 0
    var index2 = positions.size - 1
    while (index1 < positions.size) {
        if (positions[index1].x > test.x != positions[index2].x > test.x &&
            test.y < (positions[index2].y - positions[index1].y) * (test.x - positions[index1].x) / (positions[index2].x - positions[index1].x) + positions[index1].y
        ) {
            result = !result
        }
        index2 = index1++
    }
    return result
}
