package com.stilllynnthecloset.outsideusnothing.library.model

import kotlinx.serialization.Serializable

/**
 * Event - TODO: Documentation
 *
 * Created by Lynn on 5/1/23
 */
@Serializable
public data class Event constructor(
    val specification: EventSpecification,
    val choices: Collection<Choice>,
    val consequences: Collection<Consequence>,
)
