package com.stilllynnthecloset.outsideusnothing.library.model

import com.stilllynnthecloset.outsideusnothing.library.interfaces.Latexible
import com.stilllynnthecloset.outsideusnothing.library.interfaces.UniversallyUnique
import kotlinx.serialization.Serializable
import kotlin.uuid.ExperimentalUuidApi
import kotlin.uuid.Uuid

/**
 * Option - TODO: Documentation
 *
 * Created by Lynn on 5/2/23
 */
@OptIn(ExperimentalUuidApi::class)
@Serializable
public data class Option constructor(
    val text: String,
    override val uuid: String = "option_" + Uuid.random().toString(),
) : UniversallyUnique, Latexible {
    public override fun toLatex(builder: StringBuilder) {
        builder.appendLine("\\optiontext{$text}")
    }
}
