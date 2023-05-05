package com.stilllynnthecloset.liboun.model

import com.stilllynnthecloset.liboun.pickAtLeastN
import com.stilllynnthecloset.liboun.rollDie
import com.stilllynnthecloset.liboun.weightedRandom
import kotlinx.serialization.Serializable

/**
 * PortOfCallSpecification - TODO: Documentation
 *
 * Created by Lynn on 4/14/23
 */
@Serializable
public data class PortOfCallSpecification constructor(
    val name: String,
    val description: String,
    val choices: Collection<ChoiceSpecification>,
    val contracts: Collection<ContractSpecification>,
    val minContracts: Int,
) {
    public fun randomize(playbook: Playbook): PortOfCall {
        return PortOfCall(
            specification = this,
            choices = choices.map { it.randomize() },
            contracts = contracts.toSet().pickAtLeastN(minContracts).map {
                if (it.description == "GENERATE_REPLACEMENT") {
                    val npc = "${playbook.npcAdjectives.weightedRandom()} ${playbook.npcTypes.weightedRandom()}"
                    val item = playbook.contractItems.weightedRandom().name
                    val destination = if (rollDie(2) == 1) {
                        playbook.contractDestinations.weightedRandom().name
                    } else {
                        "to ${playbook.portAdjectives.weightedRandom()} ${playbook.portNames.weightedRandom()}"
                    }
                    val quality = ContractQuality.values().random()
                    it.copy(
                        description = "A $npc is offering $quality pay to deliver $item $destination",
                        quality = quality,
                    )
                } else {
                    it
                }.randomize()
            },
        )
    }
}
