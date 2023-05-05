package com.stilllynnthecloset.liboun.model

import kotlinx.serialization.Serializable

/**
 * AnsweredQuestion - TODO: Documentation
 *
 * Created by Lynn on 5/2/23
 */
@Serializable
public data class AnsweredQuestion constructor(
    val question: Question,
    val answers: Collection<Option>,
)
