package com.stilllynnthecloset.outsideusnothing.library.model

import com.stilllynnthecloset.outsideusnothing.library.pickAtLeastN
import com.stilllynnthecloset.outsideusnothing.library.rollDie
import com.stilllynnthecloset.outsideusnothing.library.weightedRandom
import kotlinx.serialization.Serializable
import java.util.UUID

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
    override val uuid: String = UUID.randomUUID().toString(),
) : UniversallyUnique {
    public fun randomize(playbook: Playbook): PortOfCall {
        return PortOfCall(
            specification = this,
            name = "${playbook.portAdjectives.weightedRandom().text} ${playbook.portTypes.weightedRandom().text}",
            choices = choices.map { it.randomize() },
            contracts = contracts.toSet().pickAtLeastN(minContracts).map {
                if (it.description == "GENERATE_REPLACEMENT") {
                    val npc = "${playbook.npcAdjectives.weightedRandom().text} ${playbook.npcTypes.weightedRandom().text}"
                    val item = playbook.contractItems.weightedRandom().name
                    val destination = if (rollDie(2) == 1) {
                        playbook.contractDestinations.weightedRandom().name
                    } else {
                        "to ${playbook.portAdjectives.weightedRandom().text} ${playbook.portTypes.weightedRandom().text}"
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
