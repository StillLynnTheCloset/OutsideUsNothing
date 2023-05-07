package com.stilllynnthecloset.liboun.model

import kotlinx.serialization.Serializable
import java.util.UUID

/**
 * NpcAdjective - TODO: Documentation
 *
 * Created by Lynn on 5/7/23
 */
@Serializable
public data class NpcAdjective constructor(
    val text: String,
    val uuid: String = UUID.randomUUID().toString(),
)
