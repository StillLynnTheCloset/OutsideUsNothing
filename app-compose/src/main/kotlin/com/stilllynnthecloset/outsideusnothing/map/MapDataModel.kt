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
import com.stilllynnthecloset.liboun.getOddsOfEvents
import com.stilllynnthecloset.liboun.model.Playbook
import com.stilllynnthecloset.liboun.pickN
import com.stilllynnthecloset.liboun.rollDie
import com.stilllynnthecloset.liboun.weightedRandom
import com.stilllynnthecloset.outsideusnothing.Platform
import java.util.PriorityQueue

/**
 * MapDataModel - TODO: Documentation
 *
 * Created by Lynn on 4/14/23
 */
internal class MapDataModel constructor(
    val playbook: Playbook,
    val platform: Platform,
) {
    private val blankStarter = PlaceholderNode(GridCoordinate(0, 0))

    var nodeList: List<Node> by mutableStateOf(
        listOf(blankStarter),
    )

    var edgeList: List<Edge> by mutableStateOf(
        listOf(),
    )

    var highlightedNodes: List<Pair<GridCoordinate, NodeHighlight>> by mutableStateOf(
        listOf(),
    )

    var currentPathCost: Int by mutableStateOf(0)
    var currentPathEventOdds: Double by mutableStateOf(0.0)

    init {
        updateMap(platform.persistence.loadCurrentMap())
    }

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
        updateHighlightedNodes()
    }

    var shipLocation: Node? by mutableStateOf(null)

    fun onShipLocationChanged(node: Node?) {
        shipLocation = node
        updateHighlightedNodes()
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

    private fun updateHighlightedNodes() {
        highlightedNodes = mutableListOf<Pair<GridCoordinate, NodeHighlight>>().apply {
            val selectedNodeLocal = selectedNode
            if (selectedNodeLocal != null) {
                add(selectedNodeLocal.coordinate to NodeHighlight.SELECTED)
            }
            val shipLocationLocal = shipLocation
            if (shipLocationLocal != null) {
                add(shipLocationLocal.coordinate to NodeHighlight.SHIP_LOCATION)
            }

            if (shipLocationLocal != null && selectedNodeLocal != null) {
                val path = findShortestPath(shipLocationLocal.coordinate, selectedNodeLocal.coordinate)
                println("Found path $path")
                path.forEach {
                    add(it to NodeHighlight.ON_PATH)
                }
                val edges = path.windowed(2).map {
                    val node1 = it[0]
                    val node2 = it[1]
                    edgeList.firstOrNull { (it.node1 == node1 && it.node2 == node2) || (it.node1 == node2 && it.node2 == node1) }
                }
                println("Traverses edges $edges")
                val totalCost = edges.sumOf { it?.cost ?: 0 }
                println("Costs $totalCost")
                currentPathCost = totalCost
                currentPathEventOdds = getOddsOfEvents(edges.mapNotNull { it?.cost })
            }
        }
    }

    private fun findShortestPath(startCoordinate: GridCoordinate, endCoordinate: GridCoordinate): List<GridCoordinate> {
        return Graph(edgeList).dijkstra(startCoordinate).getPath(endCoordinate)
    }

    enum class NodeHighlight {
        SELECTED,
        SHIP_LOCATION,
        ON_PATH,
    }
}

private data class Vertex(
    val coordinate: GridCoordinate,
    val dist: Int = Int.MAX_VALUE,
    val previous: Vertex? = null,
    val neighbors: kotlin.collections.Map<GridCoordinate, Int?> = emptyMap()
) : Comparable<Vertex> {
    override fun compareTo(other: Vertex): Int {
        return dist.compareTo(other.dist)
    }
}

private class Graph constructor(
    edges: List<Edge>,
) {
    // mapping of vertex names to Vertex objects, built from a set of Edges
    private val graph = HashMap<GridCoordinate, Vertex>(edges.size)

    init {
        val filteredEdges = edges.filter { it.cost != null }
        // one pass to find all vertices
        for (e in filteredEdges) {
            if (!graph.containsKey(e.node1)) {
                graph[e.node1] = Vertex(e.node1)
            }
            if (!graph.containsKey(e.node2)) {
                graph[e.node2] = Vertex(e.node2)
            }
        }

        // another pass to set neighbouring vertices
        for (e in filteredEdges) {
            val vert1 = graph[e.node1]!!
            val vert2 = graph[e.node2]!!
            graph[e.node1] = vert1.copy(neighbors = vert1.neighbors.toMutableMap().also { it[vert2.coordinate] = e.cost })
            graph[e.node2] = vert2.copy(neighbors = vert2.neighbors.toMutableMap().also { it[vert1.coordinate] = e.cost })
        }
    }

    fun dijkstra(startCoordinate: GridCoordinate): Graph {
        if (!graph.containsKey(startCoordinate)) {
            println("Graph doesn't contain start vertex '$startCoordinate'")
            return this
        }
        println(graph)
        val source = graph[startCoordinate]

        graph[startCoordinate] = source!!.copy(previous = source, dist = 0)

        val q = PriorityQueue(graph.values)

        dijkstra(q)
        return this
    }

    private fun dijkstra(q: PriorityQueue<Vertex>): Graph {
        while (q.isNotEmpty()) {
            // vertex with shortest distance (first iteration will return source)
            val currentNode = q.remove() ?: break

            // if distance is infinite we can ignore 'u' (and any other remaining vertices)
            // since they are unreachable
            if (currentNode.dist == Int.MAX_VALUE) break

            //look at distances to each neighbour
            for (a in currentNode.neighbors) {
                val neighborCoordinate = a.key // the neighbour in this iteration
                val neighborVertex = graph[neighborCoordinate]!!

                val alternateDist = currentNode.dist + (a.value ?: Int.MAX_VALUE)
                if (alternateDist < neighborVertex.dist) { // shorter path to neighbour found
                    q.remove(neighborVertex)
                    val updatedVertex = neighborVertex.copy(previous = currentNode, dist = alternateDist)
                    graph[neighborCoordinate] = updatedVertex
                    q.add(updatedVertex)
                }
            }
        }
        return this
    }

    fun getPath(endCoordinate: GridCoordinate): List<GridCoordinate> {
        val current = graph[endCoordinate] ?: return emptyList()
        val prev = current.previous ?: return emptyList()
        if (current.coordinate == prev.coordinate) {
            return listOf(current.coordinate)
        }
        return getPath(prev.coordinate) + endCoordinate
    }
}
