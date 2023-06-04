package com.stilllynnthecloset.outsideusnothing.library.model

import kotlinx.serialization.Serializable
import java.util.UUID

/**
 * PortOfCall - TODO: Documentation
 *
 * Created by Lynn on 4/14/23
 */
@Serializable
public data class PortOfCall constructor(
    val specification: PortOfCallSpecification,
    val name: String,
    val choices: Collection<Choice>,
    val contracts: Collection<Contract>,
    override val uuid: String = UUID.randomUUID().toString(),
) : UniversallyUnique
