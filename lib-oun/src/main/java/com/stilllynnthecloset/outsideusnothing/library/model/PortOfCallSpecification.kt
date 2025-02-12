package com.stilllynnthecloset.outsideusnothing.library.model

import com.stilllynnthecloset.outsideusnothing.library.interfaces.Flavored
import com.stilllynnthecloset.outsideusnothing.library.interfaces.Latexible
import com.stilllynnthecloset.outsideusnothing.library.interfaces.Randomizable
import com.stilllynnthecloset.outsideusnothing.library.interfaces.UniversallyUnique
import com.stilllynnthecloset.outsideusnothing.library.tools.pickN
import com.stilllynnthecloset.outsideusnothing.library.tools.weightedRandom
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
    override val flavorText: FlavorText,
    val description: String,
    val choices: Collection<ChoiceSpecification>,
    val contracts: Collection<ContractSpecification>,
    val minContracts: Int,
    override val uuid: String = "portspec_" + UUID.randomUUID().toString(),
) : UniversallyUnique, Latexible, Flavored, Randomizable<PortOfCall> {
    public override fun randomize(playbook: Playbook): PortOfCall {
        return PortOfCall(
            specification = this,
            name = "${playbook.portAdjectives.weightedRandom().text} ${playbook.portNouns.weightedRandom().text}",
            choices = choices.map { it.randomize(playbook) },
            contracts = contracts.toSet().pickN(minContracts).map {
                if (it.description == ContractSpecification.GENERATED_DESCRIPTION) {
                    ContractSpecification.generateGenericContract(playbook)
                } else {
                    it
                }.randomize(playbook)
            },
        )
    }

    public override fun toLatex(builder: StringBuilder) {
        builder.appendLine("\\portname{$name}")
        flavorText.toLatex(builder)
        builder.appendLine("\\description{$description}")
        choices.forEach { it.toLatex(builder) }
        builder.appendLine("Choose at least $minContracts")
        contracts.forEach { it.toLatex(builder) }
    }
}
