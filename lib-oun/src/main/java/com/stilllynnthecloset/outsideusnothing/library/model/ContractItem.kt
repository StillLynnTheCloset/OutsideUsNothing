package com.stilllynnthecloset.outsideusnothing.library.model

import kotlinx.serialization.Serializable
import java.util.UUID

/**
 * ContractItem - TODO: Documentation
 *
 * Created by Lynn on 5/1/23
 */
@Serializable
public data class ContractItem constructor(
    val name: String,
    override val uuid: String = UUID.randomUUID().toString(),
) : UniversallyUnique
