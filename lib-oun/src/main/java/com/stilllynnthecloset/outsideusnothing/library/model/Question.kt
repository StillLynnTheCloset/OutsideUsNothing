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
    override val uuid: String = "questionspec_" + UUID.randomUUID().toString(),
) : UniversallyUnique, Latexible {
    public override fun toLatex(builder: StringBuilder) {
        builder.appendLine("\\question{$question}")
    }
}
