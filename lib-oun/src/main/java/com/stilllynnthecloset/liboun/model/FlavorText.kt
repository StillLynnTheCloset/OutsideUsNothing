package com.stilllynnthecloset.liboun.model

import kotlinx.serialization.Serializable

/**
 * FlavorText - TODO: Documentation
 *
 * Created by Lynn on 5/2/23
 */
@Serializable
public data class FlavorText constructor(
    val text: String,
    val attribution: String,
)
