package com.stilllynnthecloset.outsideusnothing.android

import com.stilllynnthecloset.outsideusnothing.library.model.Player
import com.stilllynnthecloset.outsideusnothing.Persistence
import com.stilllynnthecloset.outsideusnothing.library.map.HexGridCoordinate
import com.stilllynnthecloset.outsideusnothing.library.map.HexGridEdge
import com.stilllynnthecloset.outsideusnothing.library.map.HexGridMap
import com.stilllynnthecloset.outsideusnothing.library.map.PlaceholderNode
import com.stilllynnthecloset.outsideusnothing.library.map.PortNode
import com.stilllynnthecloset.outsideusnothing.library.model.PortOfCall
import com.stilllynnthecloset.outsideusnothing.library.model.PortOfCallSpecification

/**
 * PersistenceAndroid - TODO: Documentation
 *
 * Created by Lynn on 5/11/23
 */
public class PersistenceAndroid : Persistence {
    private val portOfCall = PortOfCall(PortOfCallSpecification("", "", listOf(), listOf(), 0), "", emptyList(), emptyList())
    private val orbitalDescant = PortNode(HexGridCoordinate(0, -1), portOfCall.copy(name = "Orbital Descant"))
    private val hesperion = PortNode(HexGridCoordinate(0, 0), portOfCall.copy(name = "Hesperion"))
    private val machineHeaven = PortNode(HexGridCoordinate(0, 1), portOfCall.copy(name = "Machine Heaven"))
    private val freeholdNone = PortNode(HexGridCoordinate(1, -1), portOfCall.copy(name = "Freehold None"))
    private val harfast = PortNode(HexGridCoordinate(1, 0), portOfCall.copy(name = "Harfast"))
    private val mirandumsHideout = PortNode(HexGridCoordinate(1, 1), portOfCall.copy(name = "Mirandum's\nHideout"))
    private val newParabuteo = PortNode(HexGridCoordinate(-1, 0), portOfCall.copy(name = "New Parabuteo"))
    private val well409 = PortNode(HexGridCoordinate(-1, -1), portOfCall.copy(name = "Well 409"))
    private val parabuteo = PortNode(HexGridCoordinate(-2, 1), portOfCall.copy(name = "Parabuteo"))
    private val chapel = PortNode(HexGridCoordinate(-1, 1), portOfCall.copy(name = "Chapel of the\nPharotekton"))
    private val gentleJill = PortNode(HexGridCoordinate(-2, 2), portOfCall.copy(name = "Gentle Jill"))
    private val rockField = PortNode(HexGridCoordinate(-3, 0), portOfCall.copy(name = "Rock field"))
    private val bakunin = PortNode(HexGridCoordinate(-3, 1), portOfCall.copy(name = "Bakunin"))
    private val a = PlaceholderNode(HexGridCoordinate(-1, -2))
    private val b = PlaceholderNode(HexGridCoordinate(-2, -1))
    private val c = PlaceholderNode(HexGridCoordinate(-2, 0))

    private val sableMap = HexGridMap(
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
            b,
            c,
            parabuteo,
            chapel,
            gentleJill,
            rockField,
            bakunin,
        ),
        edges = listOf(
            HexGridEdge(well409.coordinate, newParabuteo.coordinate, 2),
            HexGridEdge(well409.coordinate, orbitalDescant.coordinate, 3),
            HexGridEdge(well409.coordinate, a.coordinate, 5),
            HexGridEdge(well409.coordinate, b.coordinate, 6),
            HexGridEdge(well409.coordinate, c.coordinate, 5),
            HexGridEdge(well409.coordinate, hesperion.coordinate, 1),
            HexGridEdge(freeholdNone.coordinate, hesperion.coordinate, 3),
            HexGridEdge(freeholdNone.coordinate, orbitalDescant.coordinate, 2),
            HexGridEdge(freeholdNone.coordinate, harfast.coordinate, 1),
            HexGridEdge(harfast.coordinate, hesperion.coordinate, 4),
            HexGridEdge(harfast.coordinate, mirandumsHideout.coordinate, 6),
            HexGridEdge(harfast.coordinate, machineHeaven.coordinate, 2),
            HexGridEdge(mirandumsHideout.coordinate, machineHeaven.coordinate, 5),
            HexGridEdge(chapel.coordinate, machineHeaven.coordinate, 2),
            HexGridEdge(parabuteo.coordinate, newParabuteo.coordinate, 4),
            HexGridEdge(chapel.coordinate, parabuteo.coordinate, 3),
            HexGridEdge(gentleJill.coordinate, parabuteo.coordinate, 6),
            HexGridEdge(rockField.coordinate, parabuteo.coordinate, 1),
            HexGridEdge(bakunin.coordinate, parabuteo.coordinate, 4),
            HexGridEdge(gentleJill.coordinate, parabuteo.coordinate, 6),
            HexGridEdge(newParabuteo.coordinate, machineHeaven.coordinate, 6),
            HexGridEdge(newParabuteo.coordinate, hesperion.coordinate, 3),
        )
    )

    private var currentMap: HexGridMap = sableMap
    override fun loadCurrentMap(): HexGridMap {
        return currentMap
    }

    override fun saveCurrentMap(newMap: HexGridMap) {
        currentMap = newMap
    }

    override fun getPlayers(): List<Player> {
        return emptyList()
    }

    override fun getActivePlayer(): Player? {
        TODO("Not yet implemented")
    }

    override fun updatePlayer(newPlayer: Player) {
        TODO("Not yet implemented")
    }

    override fun updateActivePlayer(newActivePlayer: Player) {
        TODO("Not yet implemented")
    }
}
