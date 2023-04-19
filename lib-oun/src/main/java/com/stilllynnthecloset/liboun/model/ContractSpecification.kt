package com.stilllynnthecloset.liboun.model

import com.stilllynnthecloset.liboun.checkSuccess
import com.stilllynnthecloset.liboun.rollDice

/**
 * ContractSpecification - TODO: Documentation
 *
 * Created by Lynn on 4/14/23
 */
public data class ContractSpecification constructor(
    val description: String,
    val quality: ContractQuality,
) {
    public fun randomize(): Contract {
        return Contract(
            contractSpecification = this,
            fuelReward = rollDice(quality.fuelDice).sum(),
            suppliesReward = rollDice(quality.suppliesDice).sum(),
            itemReward = checkSuccess(2, quality.itemDifficultly, rollDice(2)),
        )
    }
}
