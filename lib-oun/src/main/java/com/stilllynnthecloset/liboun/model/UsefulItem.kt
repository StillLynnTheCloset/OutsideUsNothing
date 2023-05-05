package com.stilllynnthecloset.liboun.model

import kotlinx.serialization.Serializable

/**
 * UsefulItem - TODO: Documentation
 *
 * Created by Lynn on 5/1/23
 */
@Serializable
public data class UsefulItem constructor(
    val name: String,
    val action: Action,
)
