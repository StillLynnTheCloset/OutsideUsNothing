package com.stilllynnthecloset.outsideusnothing.library.model

import com.stilllynnthecloset.outsideusnothing.library.interfaces.Latexible
import com.stilllynnthecloset.outsideusnothing.library.interfaces.UniversallyUnique
import kotlinx.serialization.Serializable
import kotlin.uuid.ExperimentalUuidApi
import kotlin.uuid.Uuid

/**
 * Action - TODO: Documentation
 *
 * Created by Lynn on 3/26/23
 */
@OptIn(ExperimentalUuidApi::class)
@Serializable
public data class Action constructor(
    val description: String,
    val diceOffset: Int,
    override val uuid: String = "action_" + Uuid.random().toString(),
) : UniversallyUnique, Latexible {
    override fun toLatex(builder: StringBuilder) {
        builder.appendLine("\\action($diceOffset,$description)")
    }
}
