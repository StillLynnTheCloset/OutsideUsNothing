package com.stilllynnthecloset.liboun.model

import kotlinx.serialization.Serializable
import java.util.UUID

/**
 * ContractDestination - TODO: Documentation
 *
 * Created by Lynn on 5/1/23
 */
@Serializable
public data class ContractDestination constructor(
    val name: String,
    val uuid: String = UUID.randomUUID().toString(),
)
