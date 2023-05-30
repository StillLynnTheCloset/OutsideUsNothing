package com.stilllynnthecloset.outsideusnothing.library.model

import kotlinx.serialization.Serializable

/**
 * ContractDestination - TODO: Documentation
 *
 * Created by Lynn on 5/1/23
 */
@Serializable
public data class ContractDetail constructor(
    val item: ContractItem,
    val destination: ContractDestination,
)
