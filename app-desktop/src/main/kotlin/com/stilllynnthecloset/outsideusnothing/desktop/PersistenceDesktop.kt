package com.stilllynnthecloset.outsideusnothing.desktop

import com.stilllynnthecloset.outsideusnothing.library.model.Player
import com.stilllynnthecloset.outsideusnothing.library.model.PortOfCall
import com.stilllynnthecloset.outsideusnothing.library.model.PortOfCallSpecification
import com.stilllynnthecloset.outsideusnothing.Persistence
import com.stilllynnthecloset.outsideusnothing.library.tools.SerializerTools
import com.stilllynnthecloset.outsideusnothing.library.map.HexGridCoordinate
import com.stilllynnthecloset.outsideusnothing.library.map.HexGridEdge
import com.stilllynnthecloset.outsideusnothing.library.map.HexGridMap
import com.stilllynnthecloset.outsideusnothing.library.map.PlaceholderNode
import com.stilllynnthecloset.outsideusnothing.library.map.PortNode
import com.stilllynnthecloset.outsideusnothing.library.model.FlavorText
import com.stilllynnthecloset.outsideusnothing.library.model.PlayersList
import kotlinx.serialization.decodeFromString

/**
 * PersistenceDesktop - TODO: Documentation
 *
 * Created by Lynn on 5/11/23
 */
public class PersistenceDesktop : Persistence {
    private val portOfCall = PortOfCall(PortOfCallSpecification("", FlavorText("", ""), "", listOf(), listOf(), 0), "", emptyList(), emptyList())
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

    private val escape1 = PortNode(HexGridCoordinate(2,2), portOfCall.copy(name = "Escape 1"))
    private val escape2 = PortNode(HexGridCoordinate(2,-3), portOfCall.copy(name = "Escape 2"))
    private val demesne = PortNode(HexGridCoordinate(0,0), portOfCall.copy(name = "Demesne"))
    private val hell = PortNode(HexGridCoordinate(-1,-1), portOfCall.copy(name = "Hell"))
    private val emptySystem = PortNode(HexGridCoordinate(1,-1), portOfCall.copy(name = "Empty System\nX-04351-A"))
    private val well073 = PortNode(HexGridCoordinate(0,-1), portOfCall.copy(name = "Well 073"))
    private val minefield43 = PortNode(HexGridCoordinate(-2,0), portOfCall.copy(name = "Minefield 43"))
    private val researchSite = PortNode(HexGridCoordinate(-2,-1), portOfCall.copy(name = "Research Site\nA-Star"))
    private val hotZone = PortNode(HexGridCoordinate(-3,-1), portOfCall.copy(name = "The Hot Zone"))
    private val unknownA = PortNode(HexGridCoordinate(-3,-2), portOfCall.copy(name = "???"))
    private val unknownB = PortNode(HexGridCoordinate(-3,0), portOfCall.copy(name = "???"))

    private val publicDemesne = HexGridMap(
        nodes = listOf(
            escape1,
            escape2,
            demesne,
            hell,
            emptySystem,
            well073,
            minefield43,
            researchSite,
            hotZone,
            unknownA,
            unknownB,
        ),
        edges = listOf(
            HexGridEdge(escape1.coordinate, demesne.coordinate, 7),
            HexGridEdge(escape2.coordinate, well073.coordinate, 7),
            HexGridEdge(demesne.coordinate, hell.coordinate, 1),
            HexGridEdge(demesne.coordinate, emptySystem.coordinate, 1),
            HexGridEdge(demesne.coordinate, well073.coordinate, 2),
            HexGridEdge(well073.coordinate, emptySystem.coordinate, 1),
            HexGridEdge(well073.coordinate, hell.coordinate, 1),

            HexGridEdge(well073.coordinate, researchSite.coordinate, 2),
            HexGridEdge(hell.coordinate, researchSite.coordinate, 2),
            HexGridEdge(hell.coordinate, minefield43.coordinate, 2),
            HexGridEdge(demesne.coordinate, minefield43.coordinate, 3),
            HexGridEdge(researchSite.coordinate, hotZone.coordinate, 4),
            HexGridEdge(minefield43.coordinate, hotZone.coordinate, 6),

            HexGridEdge(researchSite.coordinate, unknownA.coordinate, 4),
            HexGridEdge(unknownA.coordinate, hotZone.coordinate, 6),
            HexGridEdge(unknownB.coordinate, hotZone.coordinate, 6),
            HexGridEdge(minefield43.coordinate, unknownB.coordinate, 2),
        ),
    )

    private var currentMap: HexGridMap = publicDemesne
    override fun loadCurrentMap(): HexGridMap {
        return currentMap
    }

    override fun saveCurrentMap(newMap: HexGridMap) {
        currentMap = newMap
    }

    override fun getPlayers(): List<Player> {
        return SerializerTools.serializer.decodeFromString<PlayersList>(readFile("players.json")).players
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


    private fun getPlatformSpecificDataFolder(): String {

        // Windows: C:\Users\Username\AppData\outsideUsNothing
        // Linux: System.getenv("XDG_DATA_HOME") + "/outsideUsNothing
        // Mac: ~/Library/Application Support/outsideUsNothing

        return ""
    }
}
