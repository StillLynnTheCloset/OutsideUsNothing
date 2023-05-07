package com.stilllynnthecloset.liboun.model

import kotlinx.serialization.Serializable
import java.util.UUID

/**
 * PortAdjective - TODO: Documentation
 *
 * Created by Lynn on 5/7/23
 */
@Serializable
public data class PortAdjective constructor(
    val text: String,
    val uuid: String = UUID.randomUUID().toString(),
)
