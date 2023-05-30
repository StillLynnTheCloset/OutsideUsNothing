package com.stilllynnthecloset.outsideusnothing.library.model

import kotlinx.serialization.Serializable

/**
 * Contract - TODO: Documentation
 *
 * Created by Lynn on 3/26/23
 */
@Serializable
public data class Contract constructor(
    val contractSpecification: ContractSpecification,
    val fuelReward: Int,
    val suppliesReward: Int,
    val itemReward: Boolean,
)