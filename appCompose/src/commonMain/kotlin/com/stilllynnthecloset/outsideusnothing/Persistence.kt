package com.stilllynnthecloset.outsideusnothing

import com.stilllynnthecloset.outsideusnothing.library.model.Player
import com.stilllynnthecloset.outsideusnothing.library.map.HexGridMap
import com.stilllynnthecloset.outsideusnothing.library.model.Playbook
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

    public fun loadCurrentMap(): HexGridMap {
        return currentMap
    }

    public fun saveCurrentMap(newMap: HexGridMap) {
        currentMap = newMap
    }

    public suspend fun getPlayers(): List<Player> {
        return SerializerTools.serializer.decodeFromString<PlayersList>(readFile("players.json")).players
    }

    public fun getActivePlayer(): Player? {
        TODO("Not yet implemented")
    }

    public fun updatePlayer(newPlayer: Player) {
        TODO("Not yet implemented")
    }

    public fun updateActivePlayer(newActivePlayer: Player) {
        TODO("Not yet implemented")
    }

    public suspend fun getPlaybooks(): Collection<Playbook> {
        return listOf(
            getPlaybook("playbook_vanillaOuN.json"),
            getPlaybook("playbook_wolf.json"),
            getPlaybook("playbook_lynnHomebrew.json"),
            getPlaybook("playbook_empty.json"),
        )
    }

    private suspend fun getPlaybook(name: String): Playbook {
        return SerializerTools.serializer.decodeFromString<Playbook>(readFile(name))
    }

    @OptIn(ExperimentalResourceApi::class)
    private suspend fun readFile(name: String): String {
        return Res.readBytes("files/$name").decodeToString()
    }
}
