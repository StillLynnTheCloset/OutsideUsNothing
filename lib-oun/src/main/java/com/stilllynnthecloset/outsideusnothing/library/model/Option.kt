package com.stilllynnthecloset.outsideusnothing.library.model

import kotlinx.serialization.Serializable
import java.util.UUID

/**
 * Option - TODO: Documentation
 *
 * Created by Lynn on 5/2/23
 */
@Serializable
public data class Option constructor(
    val text: String,
    override val uuid: String = UUID.randomUUID().toString(),
) : UniversallyUnique, Latexible {
    public override fun toLatex(builder: StringBuilder) {
        builder.appendLine("\\optiontext{$text}")
    }
}
