package com.stilllynnthecloset.outsideusnothing.library.model

import com.stilllynnthecloset.outsideusnothing.library.interfaces.Latexible
import com.stilllynnthecloset.outsideusnothing.library.interfaces.UniversallyUnique
import kotlinx.serialization.Serializable
import kotlin.uuid.ExperimentalUuidApi
import kotlin.uuid.Uuid

/**
 * FlavorText - TODO: Documentation
 *
 * Created by Lynn on 5/2/23
 */
@OptIn(ExperimentalUuidApi::class)
@Serializable
public data class FlavorText constructor(
    val text: String,
    val attribution: String,
    override val uuid: String = "flavor_" + Uuid.random().toString(),
) : UniversallyUnique, Latexible {
    public override fun toLatex(builder: StringBuilder) {
        builder.appendLine("\\flavortext{${this.text}}")
        builder.appendLine("\\flavorattribution{${this.attribution}}")
    }
}
