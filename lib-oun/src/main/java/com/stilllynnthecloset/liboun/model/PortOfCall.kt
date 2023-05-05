package com.stilllynnthecloset.liboun.model

import kotlinx.serialization.Serializable

/**
 * PortOfCall - TODO: Documentation
 *
 * Created by Lynn on 4/14/23
 */
@Serializable
public data class PortOfCall constructor(
    val specification: PortOfCallSpecification,
    val choices: Collection<Choice>,
    val contracts: Collection<Contract>,
)
