package com.stilllynnthecloset.outsideusnothing.library.model

import com.stilllynnthecloset.outsideusnothing.library.checkSuccess
import com.stilllynnthecloset.outsideusnothing.library.rollDice
import kotlinx.serialization.Serializable

/**
 * ContractSpecification - TODO: Documentation
 *
 * Created by Lynn on 4/14/23
 */
@Serializable
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
