package com.stilllynnthecloset.liboun.model

/**
 * AnsweredQuestion - TODO: Documentation
 *
 * Created by Lynn on 5/2/23
 */
public data class AnsweredQuestion constructor(
    val question: Question,
    val answers: Collection<Option>,
)
