package com.stilllynnthecloset.outsideusnothing.library.model

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
    override val uuid: String = "destination_" + UUID.randomUUID().toString(),
) : UniversallyUnique
