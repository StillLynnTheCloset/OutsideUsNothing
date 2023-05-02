package com.stilllynnthecloset.liboun.model

/**
 * Event - TODO: Documentation
 *
 * Created by Lynn on 5/1/23
 */
public data class Event constructor(
    val specification: EventSpecification,
    val choices: Collection<Choice>,
)
