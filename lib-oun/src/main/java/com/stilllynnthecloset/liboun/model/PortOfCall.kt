package com.stilllynnthecloset.liboun.model

/**
 * PortOfCallSpecification - TODO: Documentation
 *
 * Created by Lynn on 4/14/23
 */
public data class PortOfCall constructor(
    val specification: PortOfCallSpecification,
    val choices: Collection<Choice>,
    val contracts: Collection<Contract>,
)
