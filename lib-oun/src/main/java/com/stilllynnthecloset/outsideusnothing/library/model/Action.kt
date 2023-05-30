package com.stilllynnthecloset.outsideusnothing.library.model

import kotlinx.serialization.Serializable

/**
 * Action - TODO: Documentation
 *
 * Created by Lynn on 3/26/23
 */
@Serializable
public data class Action constructor(
    val description: String,
    val diceOffset: Int,
)
