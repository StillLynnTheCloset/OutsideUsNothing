package com.stilllynnthecloset.outsideusnothing.library.model

import kotlinx.serialization.Serializable
import java.util.UUID

/**
 * UsefulItem - TODO: Documentation
 *
 * Created by Lynn on 5/1/23
 */
@Serializable
public data class UsefulItem constructor(
    val name: String,
    val action: Action,
    val uuid: String = UUID.randomUUID().toString(),
)
