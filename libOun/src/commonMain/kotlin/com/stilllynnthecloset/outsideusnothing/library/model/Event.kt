package com.stilllynnthecloset.outsideusnothing.library.model

import com.stilllynnthecloset.outsideusnothing.library.interfaces.UniversallyUnique
import kotlinx.serialization.Serializable
import kotlin.uuid.ExperimentalUuidApi
import kotlin.uuid.Uuid

/**
 * Event - TODO: Documentation
 *
 * Created by Lynn on 5/1/23
 */
@OptIn(ExperimentalUuidApi::class)
@Serializable
public data class Event constructor(
    val specification: EventSpecification,
    val choices: Collection<Choice>,
    val consequences: Collection<Consequence>,
    override val uuid: String = "event_" + Uuid.random().toString(),
) : UniversallyUnique
