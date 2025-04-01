package com.stilllynnthecloset.outsideusnothing.library.model

import com.stilllynnthecloset.outsideusnothing.library.interfaces.Latexible
import com.stilllynnthecloset.outsideusnothing.library.interfaces.UniversallyUnique
import kotlinx.serialization.Serializable
import kotlin.uuid.ExperimentalUuidApi
import kotlin.uuid.Uuid

/**
 * Question - TODO: Documentation
 *
 * Created by Lynn on 5/2/23
 */
@OptIn(ExperimentalUuidApi::class)
@Serializable
public data class Question constructor(
    val question: String,
    val answers: Int,
    override val uuid: String = "questionspec_" + Uuid.random().toString(),
) : UniversallyUnique, Latexible {
    public override fun toLatex(builder: StringBuilder) {
        builder.appendLine("\\question{$question}")
    }
}
