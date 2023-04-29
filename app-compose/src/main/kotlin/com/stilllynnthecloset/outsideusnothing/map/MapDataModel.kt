package com.stilllynnthecloset.outsideusnothing.map

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.text.AnnotatedString
import com.stilllynnthecloset.hexgridcompose.Edge
import com.stilllynnthecloset.hexgridcompose.Node

/**
 * OrganizerDataModel - TODO: Documentation
 *
 * Created by Lynn on 4/14/23
 */
public class MapDataModel {
    private val orbitalDescent = Node(0, -1, AnnotatedString("Orbital Descent"))
    private val hesperion = Node(0, 0, AnnotatedString("Hesperion"))
    private val machineHeaven = Node(2, 1, AnnotatedString("Machine Heaven"))
    private val well409 = Node(-1, 0, AnnotatedString("Well 409"))
    private val freeholdNone = Node(1, -1, AnnotatedString("Freehold None"))
    private val harfast = Node(1, 0, AnnotatedString("Harfast"))
    private val mirandumsHideout = Node(1, 1, AnnotatedString("Mirandum's\nHideout"))
    private val newParabuteo = Node(0, 1, AnnotatedString("New Parabuteo"))
    private val a = Node(-1, -1, AnnotatedString(""))
    private val b = Node(-1, 1, AnnotatedString(""))
    private val c = Node(-2, 0, AnnotatedString(""))
    private val d = Node(-2, 1, AnnotatedString(""))

    public val nodeList: List<Node> = listOf(
        hesperion,
        well409,
        freeholdNone,
        harfast,
        mirandumsHideout,
        machineHeaven,
        newParabuteo,
        orbitalDescent,
        a,
        b,
        c,
        d,
    )

    public val edgeList: List<Edge> = listOf(
        Edge(well409, newParabuteo, 2),
        Edge(well409, a, null), // Cost Unknown
        Edge(well409, b, null), // Cost Unknown
        Edge(well409, c, null), // Cost Unknown
        Edge(well409, d, null), // Cost Unknown
        Edge(well409, hesperion, 1),
        Edge(freeholdNone, hesperion, 3),
        Edge(freeholdNone, orbitalDescent, 2),
        Edge(freeholdNone, harfast, 1),
        Edge(harfast, hesperion, 4),
        Edge(harfast, mirandumsHideout, 6),
        Edge(harfast, machineHeaven, 2),
    )

    public var zoomLevel: Float by mutableStateOf(1f)

    public fun onZoomLevelChanged(newZoom: Float) {
        zoomLevel = newZoom
    }

    public var offset: Offset by mutableStateOf(Offset(0f, 0f))

    public fun onOffsetChanged(newOffset: Offset) {
        offset = newOffset
    }
}
