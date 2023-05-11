package com.stilllynnthecloset.outsideusnothing.map

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.compose.ui.geometry.Offset
import com.stilllynnthecloset.hexgridcompose.Edge
import com.stilllynnthecloset.hexgridcompose.GridCoordinate
import com.stilllynnthecloset.hexgridcompose.Node
import com.stilllynnthecloset.hexgridcompose.PlaceholderNode
import com.stilllynnthecloset.hexgridcompose.findEmptyNeighbors
import com.stilllynnthecloset.hexgridcompose.findExistingConnections
import com.stilllynnthecloset.hexgridcompose.findExistingNeighbors
import com.stilllynnthecloset.liboun.model.Playbook
import com.stilllynnthecloset.liboun.pickN
import com.stilllynnthecloset.liboun.rollDie
import com.stilllynnthecloset.liboun.weightedRandom

/**
 * MapDataModel - TODO: Documentation
 *
 * Created by Lynn on 4/14/23
 */
internal class MapDataModel constructor(val playbook: Playbook) {
    private val blankStarter = PlaceholderNode(GridCoordinate(0, 0))

    var nodeList: List<Node> by mutableStateOf(
        listOf(blankStarter),
    )

    var edgeList: List<Edge> by mutableStateOf(
        listOf(),
    )


    fun updateMap(map: Map) {
        nodeList = map.nodes
        edgeList = map.edges
    }

    var zoomLevel: Float by mutableStateOf(1f)

    fun onZoomLevelChanged(newZoom: Float) {
        zoomLevel = newZoom
    }

    var offset: Offset by mutableStateOf(Offset(0f, 0f))

    fun onOffsetChanged(newOffset: Offset) {
        offset = newOffset
    }

    var selectedNode: Node? by mutableStateOf(null)

    fun onNodeSelected(node: Node?) {
        selectedNode = node
    }

    var generatePortNameEntry: String? by mutableStateOf(null)

    fun updatePortNameEntry(value: String?) {
        generatePortNameEntry = value
    }

    fun pickRandomPortName() {
        generatePortNameEntry = "${playbook.portAdjectives.weightedRandom().text} ${playbook.portTypes.weightedRandom().text}"
    }

    fun generateDegrees(node: Node, degrees: Int) {
        if (degrees <= 0) {
            return
        }
        pickRandomPortName()
        val newNode: Node = generatePort(node)
        val connections = findExistingConnections(node, edgeList)
        connections.forEach {
            val neighborCoordinate = if (it.node1 == node.coordinate) it.node2 else it.node1
            val neighborNode = nodeList.firstOrNull { it.coordinate == neighborCoordinate }
            if (neighborNode != null) {
                if (neighborNode is PlaceholderNode) {
                    generateDegrees(neighborNode, degrees - 1)
                }
            } else {
                println("Couldn't find neighbor for coords: $neighborCoordinate")
            }
        }
        selectedNode = newNode
    }

    fun generatePort(node: Node): Node {
        val name = generatePortNameEntry
        if (name.isNullOrBlank()) {
            return node
        }
        generatePortNameEntry = null
        if (node is PlaceholderNode) {
            // Replace existing node with new node with name and generated info.
            val generatedPortOfCall = playbook.ports.weightedRandom().randomize(playbook)
            val newCopy = PortNode(node.coordinate, generatedPortOfCall)
            nodeList = (nodeList - node) + newCopy
            selectedNode = newCopy

            // Three types of neighbor:
            // 1. Completely empty (create placeholder and edge)
            // 2. Has blank placeholder (create edge)
            // 3. Has actual port (don't create anything)

            val existingConnections = findExistingConnections(node, edgeList)

            val neighborsToConnectTo = rollDie(6)

            val newConnectionsNeeded = neighborsToConnectTo - existingConnections.size
            if (newConnectionsNeeded > 0) {
                val emptyNeighbors = findEmptyNeighbors(node, nodeList)
                val blankNeighbors = findExistingNeighbors(node, nodeList).filter { it is PlaceholderNode }.map { it.coordinate }
                val availableNeighbors = emptyNeighbors + blankNeighbors

                availableNeighbors
                    .toSet()
                    .pickN(newConnectionsNeeded)
                    .forEach { newNeighbor ->
                        if (newNeighbor in emptyNeighbors) {
                            // We need to make a new placeholder node for it.
                            nodeList = nodeList + PlaceholderNode(newNeighbor)
                        }
                        if (edgeList.none { (it.node1 == node.coordinate && it.node2 == newNeighbor) || (it.node1 == newNeighbor && it.node2 == node.coordinate) }) {
                            // We need to make a new edge connecting these nodes
                            edgeList = edgeList + Edge(node.coordinate, newNeighbor, rollDie(6))
                        }
                    }
            }
            return newCopy
        }
        return node
    }
}
