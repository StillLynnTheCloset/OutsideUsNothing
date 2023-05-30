package com.stilllynnthecloset.outsideusnothing

import com.stilllynnthecloset.outsideusnothing.library.model.Player
import com.stilllynnthecloset.outsideusnothing.library.map.HexGridMap

/**
 * Persistence - TODO: Documentation
 *
 * Created by Lynn on 3/24/23
 */
public interface Persistence {
    public fun loadCurrentMap(): HexGridMap
    public fun saveCurrentMap(newMap: HexGridMap)
    public fun getPlayers(): List<Player>
    public fun getActivePlayer(): Player?
    public fun updatePlayer(newPlayer: Player)
    public fun updateActivePlayer(newActivePlayer: Player)
}
