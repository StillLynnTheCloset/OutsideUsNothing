package com.stilllynnthecloset.outsideusnothing.library.model

import com.stilllynnthecloset.outsideusnothing.library.interfaces.UniversallyUnique
import kotlinx.serialization.Serializable
import kotlin.uuid.ExperimentalUuidApi
import kotlin.uuid.Uuid

/**
 * Choice - TODO: Documentation
 *
 * Created by Lynn on 3/26/23
 */
@OptIn(ExperimentalUuidApi::class)
@Serializable
public data class Choice constructor(
    val specification: ChoiceSpecification,
    val answeredQuestions: Collection<AnsweredQuestion>,
    override val uuid: String = "choice_" + Uuid.random().toString(),
) : UniversallyUnique
