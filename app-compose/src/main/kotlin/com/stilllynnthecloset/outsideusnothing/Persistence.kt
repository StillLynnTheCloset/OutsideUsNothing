package com.stilllynnthecloset.outsideusnothing

import com.stilllynnthecloset.outsideusnothing.dice.DiceRollerState
import com.stilllynnthecloset.outsideusnothing.map.Map

/**
 * Persistence - TODO: Documentation
 *
 * Created by Lynn on 3/24/23
 */
public interface Persistence {
    public fun loadCurrentData(): DiceRollerState
    public fun saveCurrentData(data: DiceRollerState)
    public fun loadCurrentMap(): Map
}
