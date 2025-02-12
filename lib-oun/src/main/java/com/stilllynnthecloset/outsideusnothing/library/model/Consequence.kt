package com.stilllynnthecloset.outsideusnothing.library.model

import com.stilllynnthecloset.outsideusnothing.library.interfaces.UniversallyUnique
import kotlinx.serialization.Serializable
import java.util.UUID

/**
 * Consequence - TODO: Documentation
 *
 * Created by Lynn on 5/1/23
 */
@Serializable
public sealed class Consequence : UniversallyUnique {
    public abstract val specification: ConsequenceSpecification
}

@Serializable
public data class DiceConsequence constructor(
    override val specification: DiceConsequenceSpecification,
    val roll: Int,
    override val uuid: String = "consequence_" + UUID.randomUUID().toString(),
) : Consequence()

@Serializable
public data class TextConsequence constructor(
    override val specification: TextConsequenceSpecification,
    override val uuid: String = "consequence_" + UUID.randomUUID().toString(),
) : Consequence()