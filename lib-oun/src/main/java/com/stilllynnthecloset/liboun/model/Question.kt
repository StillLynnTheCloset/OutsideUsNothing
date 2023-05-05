package com.stilllynnthecloset.liboun.model

import kotlinx.serialization.Serializable

/**
 * Question - TODO: Documentation
 *
 * Created by Lynn on 5/2/23
 */
@Serializable
public data class Question constructor(
    val question: String,
    val answers: Int,
)
