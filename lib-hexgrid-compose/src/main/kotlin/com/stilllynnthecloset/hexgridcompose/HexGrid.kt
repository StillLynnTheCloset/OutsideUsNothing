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
import androidx.compose.ui.graphics.StrokeCap
import androidx.compose.ui.graphics.StrokeJoin
import androidx.compose.ui.graphics.drawscope.DrawScope
import androidx.compose.ui.graphics.drawscope.Fill
import androidx.compose.ui.graphics.drawscope.Stroke
import androidx.compose.ui.input.pointer.PointerEventType
import androidx.compose.ui.input.pointer.onPointerEvent
import androidx.compose.ui.text.AnnotatedString
import androidx.compose.ui.text.ExperimentalTextApi
import androidx.compose.ui.text.TextMeasurer
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.drawText
import androidx.compose.ui.text.rememberTextMeasurer
import androidx.compose.ui.text.style.TextAlign
import kotlinx.serialization.Polymorphic
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable
import kotlinx.serialization.Transient
import kotlin.math.cos
import kotlin.math.sin

@Polymorphic
public interface Node {
    public val coordinate: GridCoordinate
    public val label: AnnotatedString
}

@Serializable
@SerialName("placeholder")
public data class PlaceholderNode constructor(
    override val coordinate: GridCoordinate,
) : Node {
    @Transient
    override val label: AnnotatedString = AnnotatedString("")
}

@Serializable
public data class Edge constructor(
    val node1: GridCoordinate,
    val node2: GridCoordinate,
    val cost: Int?,
)

@Serializable
public data class GridCoordinate constructor(
    val row: Int,
    val col: Int,
)

@Composable
@OptIn(ExperimentalTextApi::class, ExperimentalComposeUiApi::class)
public fun <T : Node> hexGrid(
    modifier: Modifier,
    nodes: List<T>,
    edges: List<Edge>,
    nodeSize: Float,
    nodeSpacing: Float,
    offset: Offset,
    onOffsetChanged: (Offset) -> Unit,
    scale: Float,
    onScaleChanged: (Float) -> Unit,
    selectedNode: T?,
    onNodeSelected: (T) -> Unit,
) {
    val textMeasurer = rememberTextMeasurer()
    val textColor = MaterialTheme.colorScheme.onPrimary
    val gridColor = MaterialTheme.colorScheme.primary
    val placeholderColor = MaterialTheme.colorScheme.outlineVariant
    val unitDistance = (nodeSize + nodeSpacing) * scale

    Canvas(
        modifier = modifier
            .onPointerEvent(PointerEventType.Scroll) {
                val scrollChange = it.changes.firstOrNull()?.scrollDelta?.y ?: 0f
                val newScale = (scale + scrollChange / 10f).coerceAtLeast(0.1f).coerceAtMost(5f)
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

        nodes.forEach {
            val color = if (it is PlaceholderNode) placeholderColor else gridColor
            drawHexagon(
                node = it,
                offset = this.center + (offset * unitDistance),
                textMeasurer = textMeasurer,
                fillColor = color,
                textColor = textColor,
                nodeSize = nodeSize * scale,
                nodeSpacing = nodeSpacing * scale,
                selected = it == selectedNode,
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

public fun <T : Node> findAndCheckNeighbors(node: T, allNodes: List<T>, allEdges: List<Edge>) {
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

public fun <T : Node> findExistingConnections(node: T, allEdges: List<Edge>): List<Edge> {
    return allEdges.filter { it.node1 == node.coordinate || it.node2 == node.coordinate }
}

public fun <T : Node> findExistingNeighbors(node: T, allNodes: List<T>): List<Node> {
    val neighborCoords = findAllNeighborCoords(node)

    return allNodes.filter { neighbor -> neighborCoords.any { it.row == neighbor.coordinate.row && it.col == neighbor.coordinate.col } }
}

public fun <T : Node> findEmptyNeighbors(node: T, allNodes: List<T>): List<GridCoordinate> {
    val neighborCoords = findAllNeighborCoords(node)

    return neighborCoords.filter { neighbor -> allNodes.none { it.coordinate.row == neighbor.row && it.coordinate.col == neighbor.col } }
}

public fun <T : Node> findAllNeighborCoords(node: T): List<GridCoordinate> {
    return (0 until 6).map { direction ->
        findNeighborCoords(node, direction)
    }
}

/**
 * [direction] is the selection of a neighbor, starting at 0 at 3:00, and going CCW
 */
public fun <T : Node> findNeighborCoords(node: T, direction: Int): GridCoordinate {
    val parity = node.coordinate.row and 1 // 1 if odd, 0 if even
    val diff = neighborDeltas[parity][direction]
    return GridCoordinate(node.coordinate.row + diff[1], node.coordinate.col + diff[0])
}

private fun <T : Node> nodeScreenBounds(
    nodes: List<T>,
    offset: Offset,
    nodeSize: Float,
    nodeSpacing: Float,
): List<Pair<T, List<Offset>>> {
    return nodes.map { it to hexagonOffsets(offsetOfNode(offset, it.coordinate, nodeSize, nodeSpacing), nodeSize) }
}

@OptIn(ExperimentalTextApi::class)
private fun <T : Node> DrawScope.drawHexagon(
    node: T,
    offset: Offset,
    textMeasurer: TextMeasurer,
    fillColor: Color,
    textColor: Color,
    nodeSize: Float,
    nodeSpacing: Float,
    selected: Boolean,
) {
    val center = offsetOfNode(offset, node.coordinate, nodeSize, nodeSpacing)
    val hexagonPoints = hexagonOffsets(center, nodeSize)
    val path = Path()
    path.moveTo(hexagonPoints[0].x, hexagonPoints[0].y)
    hexagonPoints.forEach {
        path.lineTo(it.x, it.y)
    }
    this.drawPath(path, fillColor, style = Fill)
    if (selected) {
        val borderWidth = nodeSize / 15f
        this.drawPath(
            path = path,
            color = textColor,
            style = Stroke(
                width = borderWidth,
                miter = borderWidth,
                cap = StrokeCap.Round,
                join = StrokeJoin.Miter,
            ),
        )
    }

    val measureResult = textMeasurer.measure(node.label, style = TextStyle(textAlign = TextAlign.Center))

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

private fun findAngle(fraction: Double): Double {
    return fraction * Math.PI * 2 + Math.toRadians(270.0)
}

private fun offsetOfNode(screenOrigin: Offset, coordinate: GridCoordinate, nodeSize: Float, nodeSpacing: Float): Offset {
    val ang30 = Math.toRadians(30.0)
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
