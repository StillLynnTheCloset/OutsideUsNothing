package com.stilllynnthecloset.outsideusnothing.android

import com.stilllynnthecloset.outsideusnothing.library.model.Player
import com.stilllynnthecloset.outsideusnothing.Persistence
import com.stilllynnthecloset.outsideusnothing.library.map.HexGridCoordinate
import com.stilllynnthecloset.outsideusnothing.library.map.HexGridEdge
import com.stilllynnthecloset.outsideusnothing.library.map.HexGridMap
import com.stilllynnthecloset.outsideusnothing.library.map.PlaceholderNode
import com.stilllynnthecloset.outsideusnothing.library.map.PortNode
import com.stilllynnthecloset.outsideusnothing.library.model.FlavorText
import com.stilllynnthecloset.outsideusnothing.library.model.PortOfCall
import com.stilllynnthecloset.outsideusnothing.library.model.PortOfCallSpecification

/**
 * PersistenceAndroid - TODO: Documentation
 *
 * Created by Lynn on 5/11/23
 */
public class PersistenceAndroid : Persistence {
    private var currentMap: HexGridMap = HexGridMap(emptyList(), emptyList())
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
        return null // TODO("Not yet implemented")
    }

    override fun updatePlayer(newPlayer: Player) {
        // TODO("Not yet implemented")
    }

    override fun updateActivePlayer(newActivePlayer: Player) {
        // TODO("Not yet implemented")
    }
}
