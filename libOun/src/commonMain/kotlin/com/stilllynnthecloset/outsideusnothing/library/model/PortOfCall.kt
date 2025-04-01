package com.stilllynnthecloset.outsideusnothing.library.model

import com.stilllynnthecloset.outsideusnothing.library.interfaces.UniversallyUnique
import kotlinx.serialization.Serializable
import kotlin.uuid.ExperimentalUuidApi
import kotlin.uuid.Uuid

/**
 * PortOfCall - TODO: Documentation
 *
 * Created by Lynn on 4/14/23
 */
@OptIn(ExperimentalUuidApi::class)
@Serializable
public data class PortOfCall constructor(
    val specification: PortOfCallSpecification,
    val name: String,
    val choices: Collection<Choice>,
    val contracts: Collection<Contract>,
    override val uuid: String = "port_" + Uuid.random().toString(),
) : UniversallyUnique
