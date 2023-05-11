package com.stilllynnthecloset.outsideusnothing.desktop

import com.stilllynnthecloset.hexgridcompose.Edge
import com.stilllynnthecloset.hexgridcompose.GridCoordinate
import com.stilllynnthecloset.hexgridcompose.PlaceholderNode
import com.stilllynnthecloset.liboun.model.PortOfCall
import com.stilllynnthecloset.liboun.model.PortOfCallSpecification
import com.stilllynnthecloset.outsideusnothing.Persistence
import com.stilllynnthecloset.outsideusnothing.dice.DiceRollerState
import com.stilllynnthecloset.outsideusnothing.map.Map
import com.stilllynnthecloset.outsideusnothing.map.PortNode

/**
 * PersistenceDesktop - TODO: Documentation
 *
 * Created by Lynn on 5/11/23
 */
public class PersistenceDesktop : Persistence {
    override fun loadCurrentData(): DiceRollerState {
        TODO("Not yet implemented")
    }

    override fun saveCurrentData(data: DiceRollerState) {
        TODO("Not yet implemented")
    }

    override fun loadCurrentMap(): Map {
        return sableMap
    }


    private val portOfCall = PortOfCall(PortOfCallSpecification("", "", listOf(), listOf(), 0), "", emptyList(), emptyList())
    private val orbitalDescant = PortNode(GridCoordinate(0, -1), portOfCall.copy(name = "Orbital Descant"))
    private val hesperion = PortNode(GridCoordinate(0, 0), portOfCall.copy(name = "Hesperion"))
    private val machineHeaven = PortNode(GridCoordinate(0, 1), portOfCall.copy(name = "Machine Heaven"))
    private val freeholdNone = PortNode(GridCoordinate(1, -1), portOfCall.copy(name = "Freehold None"))
    private val harfast = PortNode(GridCoordinate(1, 0), portOfCall.copy(name = "Harfast"))
    private val mirandumsHideout = PortNode(GridCoordinate(1, 1), portOfCall.copy(name = "Mirandum's\nHideout"))
    private val newParabuteo = PortNode(GridCoordinate(-1, 0), portOfCall.copy(name = "New Parabuteo"))
    private val well409 = PortNode(GridCoordinate(-1, -1), portOfCall.copy(name = "Well 409"))
    private val parabuteo = PortNode(GridCoordinate(-2, 1), portOfCall.copy(name = "Parabuteo"))
    private val chapel = PortNode(GridCoordinate(-1, 1), portOfCall.copy(name = "Chapel of the\nPharotekton"))
    private val a = PlaceholderNode(GridCoordinate(-1, -2))
    private val c = PlaceholderNode(GridCoordinate(-2, -1))
    private val d = PlaceholderNode(GridCoordinate(-2, 0))

    private val sableMap = Map(
        nodes = listOf(
            hesperion,
            well409,
            freeholdNone,
            harfast,
            mirandumsHideout,
            machineHeaven,
            newParabuteo,
            orbitalDescant,
            a,
            c,
            d,
            parabuteo,
            chapel,
        ),
        edges = listOf(
            Edge(well409.coordinate, newParabuteo.coordinate, 2),
            Edge(well409.coordinate, orbitalDescant.coordinate, 3),
            Edge(well409.coordinate, a.coordinate, 5),
            Edge(well409.coordinate, c.coordinate, 6),
            Edge(well409.coordinate, d.coordinate, 5),
            Edge(well409.coordinate, hesperion.coordinate, 1),
            Edge(freeholdNone.coordinate, hesperion.coordinate, 3),
            Edge(freeholdNone.coordinate, orbitalDescant.coordinate, 2),
            Edge(freeholdNone.coordinate, harfast.coordinate, 1),
            Edge(harfast.coordinate, hesperion.coordinate, 4),
            Edge(harfast.coordinate, mirandumsHideout.coordinate, 6),
            Edge(harfast.coordinate, machineHeaven.coordinate, 2),
            Edge(mirandumsHideout.coordinate, machineHeaven.coordinate, null),
            Edge(chapel.coordinate, machineHeaven.coordinate, 2),
            Edge(parabuteo.coordinate, newParabuteo.coordinate, null),
            Edge(chapel.coordinate, parabuteo.coordinate, 3),
        )
    )
}
