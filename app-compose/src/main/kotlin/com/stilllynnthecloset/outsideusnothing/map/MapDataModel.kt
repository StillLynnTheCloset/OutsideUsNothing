package com.stilllynnthecloset.outsideusnothing.map

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.text.AnnotatedString
import com.stilllynnthecloset.hexgridcompose.Edge
import com.stilllynnthecloset.hexgridcompose.GridCoordinate
import com.stilllynnthecloset.hexgridcompose.Node
import com.stilllynnthecloset.hexgridcompose.findEmptyNeighbors
import com.stilllynnthecloset.hexgridcompose.findExistingConnections
import com.stilllynnthecloset.hexgridcompose.findExistingNeighbors
import com.stilllynnthecloset.liboun.generateWeightedList
import com.stilllynnthecloset.liboun.model.PortOfCall
import com.stilllynnthecloset.liboun.pickN
import com.stilllynnthecloset.liboun.playbook.companyPort
import com.stilllynnthecloset.liboun.playbook.portWeightings
import com.stilllynnthecloset.liboun.rollDie

/**
 * OrganizerDataModel - TODO: Documentation
 *
 * Created by Lynn on 4/14/23
 */
public class MapDataModel {
    private val portOfCall = PortOfCall(companyPort, emptyList(), emptyList())
    private val orbitalDescent = Node(GridCoordinate(0, -1), AnnotatedString("Orbital Descent"), portOfCall)
    private val hesperion = Node(GridCoordinate(0, 0), AnnotatedString("Hesperion"), portOfCall)
    private val machineHeaven = Node(GridCoordinate(2, 1), AnnotatedString("Machine Heaven"), portOfCall)
    private val well409 = Node(GridCoordinate(-1, 0), AnnotatedString("Well 409"), portOfCall)
    private val freeholdNone = Node(GridCoordinate(1, -1), AnnotatedString("Freehold None"), portOfCall)
    private val harfast = Node(GridCoordinate(1, 0), AnnotatedString("Harfast"), portOfCall)
    private val mirandumsHideout = Node(GridCoordinate(1, 1), AnnotatedString("Mirandum's\nHideout"), portOfCall)
    private val newParabuteo = Node(GridCoordinate(0, 1), AnnotatedString("New Parabuteo"), portOfCall)
    private val a = Node<PortOfCall>(GridCoordinate(-1, -1), AnnotatedString(""), null)
    private val b = Node<PortOfCall>(GridCoordinate(-1, 1), AnnotatedString(""), null)
    private val c = Node<PortOfCall>(GridCoordinate(-2, 0), AnnotatedString(""), null)
    private val d = Node<PortOfCall>(GridCoordinate(-2, 1), AnnotatedString(""), null)
    private val blankStarter = Node<PortOfCall>(GridCoordinate(0, 0), AnnotatedString(""), null)

    public var nodeList: List<Node<PortOfCall>> by mutableStateOf(
        listOf(
            blankStarter,
//            hesperion,
//            well409,
//            freeholdNone,
//            harfast,
//            mirandumsHideout,
//            machineHeaven,
//            newParabuteo,
//            orbitalDescent,
//            a,
//            b,
//            c,
//            d,
        )
    )

    public var edgeList: List<Edge> by mutableStateOf(
        listOf(
//            Edge(well409.coordinate, newParabuteo.coordinate, 2),
//            Edge(well409.coordinate, a.coordinate, null), // Cost Unknown
//            Edge(well409.coordinate, b.coordinate, null), // Cost Unknown
//            Edge(well409.coordinate, c.coordinate, null), // Cost Unknown
//            Edge(well409.coordinate, d.coordinate, null), // Cost Unknown
//            Edge(well409.coordinate, hesperion.coordinate, 1),
//            Edge(freeholdNone.coordinate, hesperion.coordinate, 3),
//            Edge(freeholdNone.coordinate, orbitalDescent.coordinate, 2),
//            Edge(freeholdNone.coordinate, harfast.coordinate, 1),
//            Edge(harfast.coordinate, hesperion.coordinate, 4),
//            Edge(harfast.coordinate, mirandumsHideout.coordinate, 6),
//            Edge(harfast.coordinate, machineHeaven.coordinate, 2),
        )
    )

    public var zoomLevel: Float by mutableStateOf(1f)

    public fun onZoomLevelChanged(newZoom: Float) {
        zoomLevel = newZoom
    }

    public var offset: Offset by mutableStateOf(Offset(0f, 0f))

    public fun onOffsetChanged(newOffset: Offset) {
        offset = newOffset
    }

    public var selectedNode: Node<PortOfCall>? by mutableStateOf(null)

    public fun onNodeSelected(node: Node<PortOfCall>?) {
        selectedNode = node
    }

    public var generatePortNameEntry: String? by mutableStateOf(null)

    public fun updatePortNameEntry(value: String?) {
        generatePortNameEntry = value
    }

    public fun generatePort(node: Node<PortOfCall>) {
        val name = generatePortNameEntry
        if (name.isNullOrBlank()) {
            return
        }
        generatePortNameEntry = null

        // Replace existing node with new node with name and generated info.
        val generatedPortOfCall = portWeightings.generateWeightedList().random().randomize()
        val newCopy = node.copy(
            label = AnnotatedString(name),
            value = generatedPortOfCall,
        )
        nodeList = (nodeList - node) + newCopy
        selectedNode = newCopy


        // Three types of neighbor:
        // 1. Completely empty (create placeholder and edge)
        // 2. Has blank placeholder (create edge)
        // 3. Has actual port (don't create anything)

        val existingConnections = findExistingConnections(node, nodeList, edgeList)

        val neighborsToConnectTo = rollDie(6)
        println("Connecting to $neighborsToConnectTo neighbors")

        val newConnectionsNeeded = neighborsToConnectTo - existingConnections.size
        if (newConnectionsNeeded > 0) {
            val emptyNeighbors = findEmptyNeighbors(node, nodeList, edgeList)
            val blankNeighbors = findExistingNeighbors(node, nodeList, edgeList).filter { it.value == null }.map { it.coordinate }
            val availableNeighbors = emptyNeighbors + blankNeighbors

            availableNeighbors
                .toSet()
                .pickN(newConnectionsNeeded)
                .forEach { newNeighbor ->
                    if (newNeighbor in emptyNeighbors) {
                        // We need to make a new placeholder node for it.
                        println("Creating new node at $newNeighbor")
                        nodeList = nodeList + Node(newNeighbor, AnnotatedString(""), null)
                    }
                    if (edgeList.none { (it.node1 == node.coordinate && it.node2 == newNeighbor) || (it.node1 == newNeighbor && it.node2 == node.coordinate) }) {
                        // We need to make a new edge connecting these nodes
                        println("Creating new edge from ${node.coordinate} to $newNeighbor")
                        edgeList = edgeList + Edge(node.coordinate, newNeighbor, rollDie(6))
                    }
                }
        }
    }
}
