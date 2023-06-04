package com.stilllynnthecloset.outsideusnothing.library.model

import kotlinx.serialization.Serializable
import java.util.UUID

/**
 * Question - TODO: Documentation
 *
 * Created by Lynn on 5/2/23
 */
@Serializable
public data class Question constructor(
    val question: String,
    val answers: Int,
    override val uuid: String = UUID.randomUUID().toString(),
) : UniversallyUnique
