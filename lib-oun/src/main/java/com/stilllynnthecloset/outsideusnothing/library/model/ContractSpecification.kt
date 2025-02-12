package com.stilllynnthecloset.outsideusnothing.library.model

import com.stilllynnthecloset.outsideusnothing.library.interfaces.Latexible
import com.stilllynnthecloset.outsideusnothing.library.interfaces.Randomizable
import com.stilllynnthecloset.outsideusnothing.library.interfaces.UniversallyUnique
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
    override val uuid: String = "contractspec_" + UUID.randomUUID().toString(),
) : UniversallyUnique, Randomizable<Contract>, Latexible {
    public companion object {
        internal const val GENERATED_DESCRIPTION: String = "GENERATE_REPLACEMENT"
        public val generatedContract: ContractSpecification = ContractSpecification(
            description = GENERATED_DESCRIPTION,
            quality = ContractQuality.AVERAGE,
        )
        internal val wildernessContract: ContractSpecification = ContractSpecification(
            description = "There may or may not be fuel, supplies, or powerful items here. Along with traps and monsters.",
            quality = ContractQuality.AVERAGE,
        )

        public fun generateGenericContract(playbook: Playbook): ContractSpecification {
            val npc = "${playbook.npcAdjectives.weightedRandom().text} ${playbook.npcNouns.weightedRandom().text}"
            val item = playbook.contractItems.weightedRandom().name
            val destination = if (rollDie(2) == 1) {
                playbook.contractDestinations.weightedRandom().name
            } else {
                "to ${playbook.portAdjectives.weightedRandom().text} ${playbook.portNouns.weightedRandom().text}"
            }
            val quality = ContractQuality.values().random()
            return Companion.generatedContract.copy(
                description = "A $npc is offering $quality pay to deliver $item $destination",
                quality = quality,
            )
        }
    }

    public override fun randomize(playbook: Playbook): Contract {
        return if (this == wildernessContract) {
            Contract(
                contractSpecification = this,
                fuelReward = rollDice(ContractQuality.values().random().fuelDice).sumOf { it.value },
                suppliesReward = rollDice(ContractQuality.values().random().suppliesDice).sumOf { it.value },
                itemReward = checkSuccess(2, ContractQuality.values().random().itemDifficultly, rollDice(2)),
            )
        } else {
            Contract(
                contractSpecification = this,
                fuelReward = rollDice(quality.fuelDice).sumOf { it.value },
                suppliesReward = rollDice(quality.suppliesDice).sumOf { it.value },
                itemReward = checkSuccess(2, quality.itemDifficultly, rollDice(2)),
            )
        }
    }

    public override fun toLatex(builder: StringBuilder) {
        builder.appendLine("\\contractspecification{$description}")
    }
}
