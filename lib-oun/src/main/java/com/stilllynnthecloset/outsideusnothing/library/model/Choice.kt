package com.stilllynnthecloset.outsideusnothing.library.model

import kotlinx.serialization.Serializable
import java.util.UUID

/**
 * Choice - TODO: Documentation
 *
 * Created by Lynn on 3/26/23
 */
@Serializable
public data class Choice constructor(
    val specification: ChoiceSpecification,
    val answeredQuestions: Collection<AnsweredQuestion>,
    override val uuid: String = "choice_" + UUID.randomUUID().toString(),
) : UniversallyUnique
