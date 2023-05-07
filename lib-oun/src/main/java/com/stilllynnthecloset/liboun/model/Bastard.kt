package com.stilllynnthecloset.liboun.model

import kotlinx.serialization.Serializable
import java.util.UUID

/**
 * Bastard - TODO: Documentation
 *
 * Created by Lynn on 5/1/23
 */
@Serializable
public data class Bastard constructor(
    val name: String,
    val description: String,
    val uuid: String = UUID.randomUUID().toString(),
)
