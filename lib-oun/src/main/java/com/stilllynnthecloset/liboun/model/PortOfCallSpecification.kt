package com.stilllynnthecloset.liboun.model

import com.stilllynnthecloset.liboun.pickAtLeastN
import com.stilllynnthecloset.liboun.rollDie

/**
 * PortOfCallSpecification - TODO: Documentation
 *
 * Created by Lynn on 4/14/23
 */
public data class PortOfCallSpecification constructor(
    val name: String,
    val description: String,
    val customizations: Set<PlaySheetChoiceSpecification>,
    val contracts: Set<ContractSpecification>,
    val minContracts: Int,
) {
    public fun randomize(): PortOfCall {
        return PortOfCall(
            specification = this,
            customizations = customizations.map { it.randomize() },
            contracts = contracts.pickAtLeastN(minContracts).map { it.randomize() },
        )
    }
}
