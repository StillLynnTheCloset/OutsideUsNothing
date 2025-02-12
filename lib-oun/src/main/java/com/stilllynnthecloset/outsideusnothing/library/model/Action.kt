package com.stilllynnthecloset.outsideusnothing.library.model

import com.stilllynnthecloset.outsideusnothing.library.interfaces.Latexible
import com.stilllynnthecloset.outsideusnothing.library.interfaces.UniversallyUnique
import kotlinx.serialization.Serializable
import java.util.UUID

/**
 * Action - TODO: Documentation
 *
 * Created by Lynn on 3/26/23
 */
@Serializable
public data class Action constructor(
    val description: String,
    val diceOffset: Int,
    override val uuid: String = "action_" + UUID.randomUUID().toString(),
) : UniversallyUnique, Latexible {
    override fun toLatex(builder: StringBuilder) {
        builder.appendLine("\\action($diceOffset,$description)")
    }
}
