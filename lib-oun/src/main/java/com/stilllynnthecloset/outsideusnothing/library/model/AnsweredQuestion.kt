package com.stilllynnthecloset.outsideusnothing.library.model

import kotlinx.serialization.Serializable
import java.util.UUID

/**
 * AnsweredQuestion - TODO: Documentation
 *
 * Created by Lynn on 5/2/23
 */
@Serializable
public data class AnsweredQuestion constructor(
    val question: Question,
    val answers: Collection<Option>,
    override val uuid: String = "answeredquestion_" + UUID.randomUUID().toString(),
) : UniversallyUnique
