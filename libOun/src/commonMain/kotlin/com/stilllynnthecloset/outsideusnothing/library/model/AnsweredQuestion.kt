package com.stilllynnthecloset.outsideusnothing.library.model

import com.stilllynnthecloset.outsideusnothing.library.interfaces.UniversallyUnique
import kotlinx.serialization.Serializable
import kotlin.uuid.ExperimentalUuidApi
import kotlin.uuid.Uuid

/**
 * AnsweredQuestion - TODO: Documentation
 *
 * Created by Lynn on 5/2/23
 */
@OptIn(ExperimentalUuidApi::class)
@Serializable
public data class AnsweredQuestion constructor(
    val question: Question,
    val answers: Collection<Option>,
    override val uuid: String = "answeredquestion_" + Uuid.random().toString(),
) : UniversallyUnique
