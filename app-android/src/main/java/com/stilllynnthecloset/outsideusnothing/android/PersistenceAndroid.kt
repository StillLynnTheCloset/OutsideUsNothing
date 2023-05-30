package com.stilllynnthecloset.outsideusnothing.android

import com.stilllynnthecloset.outsideusnothing.library.model.Player
import com.stilllynnthecloset.outsideusnothing.Persistence
import com.stilllynnthecloset.outsideusnothing.library.map.HexGridMap

/**
 * PersistenceAndroid - TODO: Documentation
 *
 * Created by Lynn on 5/11/23
 */
public class PersistenceAndroid : Persistence {
    override fun loadCurrentMap(): HexGridMap {
        TODO("Not yet implemented")
    }

    override fun saveCurrentMap(newMap: HexGridMap) {
        TODO("Not yet implemented")
    }

    override fun getPlayers(): List<Player> {
        TODO("Not yet implemented")
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
