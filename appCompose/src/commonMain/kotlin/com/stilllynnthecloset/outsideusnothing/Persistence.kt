package com.stilllynnthecloset.outsideusnothing

import com.stilllynnthecloset.outsideusnothing.library.model.Player
import com.stilllynnthecloset.outsideusnothing.library.map.HexGridMap
import com.stilllynnthecloset.outsideusnothing.library.model.PlayersList
import com.stilllynnthecloset.outsideusnothing.library.tools.SerializerTools
import org.jetbrains.compose.resources.ExperimentalResourceApi
import outsideusnothing.appcompose.generated.resources.Res

/**
 * Persistence - TODO: Documentation
 *
 * Created by Lynn on 3/24/23
 */
public class Persistence {
    private var currentMap: HexGridMap = HexGridMap(emptyList(), emptyList())

    public suspend fun loadCurrentMap(): HexGridMap {
        return currentMap
    }

    public suspend fun saveCurrentMap(newMap: HexGridMap) {
        currentMap = newMap
    }

    @OptIn(ExperimentalResourceApi::class)
    public suspend fun getPlayers(): List<Player> {
        return SerializerTools.serializer.decodeFromString<PlayersList>(Res.readBytes("files/players.json").decodeToString()).players
    }

    public suspend fun getActivePlayer(): Player? {
        TODO("Not yet implemented")
    }

    public suspend fun updatePlayer(newPlayer: Player) {
        TODO("Not yet implemented")
    }

    public suspend fun updateActivePlayer(newActivePlayer: Player) {
        TODO("Not yet implemented")
    }

    private fun getPlatformSpecificDataFolder(): String {

        // Windows: C:\Users\Username\AppData\outsideUsNothing
        // Linux: System.getenv("XDG_DATA_HOME") + "/outsideUsNothing
        // Mac: ~/Library/Application Support/outsideUsNothing

        return ""
    }
}
