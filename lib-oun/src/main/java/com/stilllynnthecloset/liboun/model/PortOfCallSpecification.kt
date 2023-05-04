package com.stilllynnthecloset.liboun.model

import com.stilllynnthecloset.liboun.pickAtLeastN

/**
 * PortOfCallSpecification - TODO: Documentation
 *
 * Created by Lynn on 4/14/23
 */
public data class PortOfCallSpecification constructor(
    val name: String,
    val description: String,
    val choices: Collection<ChoiceSpecification>,
    val contracts: Collection<ContractSpecification>,
    val minContracts: Int,
) {
    public fun randomize(): PortOfCall {
        return PortOfCall(
            specification = this,
            choices = choices.map { it.randomize() },
            contracts = contracts.toSet().pickAtLeastN(minContracts).map { it.randomize() },
        )
    }
}
