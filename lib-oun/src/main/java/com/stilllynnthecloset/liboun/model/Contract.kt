package com.stilllynnthecloset.liboun.model

/**
 * Contract - TODO: Documentation
 *
 * Created by Lynn on 3/26/23
 */
public data class Contract constructor(
    val contractSpecification: ContractSpecification,
    val fuelReward: Int,
    val suppliesReward: Int,
    val itemReward: Boolean,
)
