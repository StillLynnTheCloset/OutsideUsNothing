package com.stilllynnthecloset.outsideusnothing.library.model

import com.stilllynnthecloset.outsideusnothing.library.interfaces.Latexible
import com.stilllynnthecloset.outsideusnothing.library.interfaces.UniversallyUnique
import kotlinx.serialization.Serializable
import java.util.UUID

/**
 * FlavorText - TODO: Documentation
 *
 * Created by Lynn on 5/2/23
 */
@Serializable
public data class FlavorText constructor(
    val text: String,
    val attribution: String,
    override val uuid: String = "flavor_" + UUID.randomUUID().toString(),
) : UniversallyUnique, Latexible {
    public override fun toLatex(builder: StringBuilder) {
        builder.appendLine("\\flavortext{${this.text}}")
        builder.appendLine("\\flavorattribution{${this.attribution}}")
    }
}
