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
    private var currentMap: HexGridMap = HexGridMap(emptyList(), emptyList())
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
