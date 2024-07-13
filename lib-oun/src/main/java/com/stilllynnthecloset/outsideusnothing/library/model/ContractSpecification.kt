package com.stilllynnthecloset.outsideusnothing.library.model

import com.stilllynnthecloset.outsideusnothing.library.tools.checkSuccess
import com.stilllynnthecloset.outsideusnothing.library.tools.rollDice
import com.stilllynnthecloset.outsideusnothing.library.tools.rollDie
import com.stilllynnthecloset.outsideusnothing.library.tools.weightedRandom
import kotlinx.serialization.Serializable
import java.util.UUID

/**
 * ContractSpecification - TODO: Documentation
 *
 * Created by Lynn on 4/14/23
 */
@Serializable
public data class ContractSpecification constructor(
    val description: String,
    val quality: ContractQuality,
    override val uuid: String = UUID.randomUUID().toString(),
) : UniversallyUnique {
    public companion object {
        public val generatedContract: ContractSpecification = ContractSpecification(
            description = "GENERATE_REPLACEMENT",
            quality = ContractQuality.AVERAGE,
        )

        public fun generateGenericContract(playbook: Playbook): ContractSpecification {
            val npc = "${playbook.npcAdjectives.weightedRandom().text} ${playbook.npcTypes.weightedRandom().text}"
            val item = playbook.contractItems.weightedRandom().name
            val destination = if (rollDie(2) == 1) {
                playbook.contractDestinations.weightedRandom().name
            } else {
                "to ${playbook.portAdjectives.weightedRandom().text} ${playbook.portTypes.weightedRandom().text}"
            }
            val quality = ContractQuality.values().random()
            return Companion.generatedContract.copy(
                description = "A $npc is offering $quality pay to deliver $item $destination",
                quality = quality,
            )
        }
    }
    public fun randomize(): Contract {
        return Contract(
            contractSpecification = this,
            fuelReward = rollDice(quality.fuelDice).sumOf { it.value },
            suppliesReward = rollDice(quality.suppliesDice).sumOf { it.value },
            itemReward = checkSuccess(2, quality.itemDifficultly, rollDice(2)),
        )
    }
}
