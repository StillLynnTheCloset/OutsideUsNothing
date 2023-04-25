package com.stilllynnthecloset.liboun.model

/**
 * PortOfCallSpecification - TODO: Documentation
 *
 * Created by Lynn on 4/14/23
 */
public data class PortOfCall constructor(
    val specification: PortOfCallSpecification,
    val customizations: List<PlaySheetChoice>,
    val contracts: List<Contract>,
    val connectionDistances: List<Int>,
)
