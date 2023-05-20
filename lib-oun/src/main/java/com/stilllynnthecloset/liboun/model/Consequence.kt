package com.stilllynnthecloset.liboun.model

import kotlinx.serialization.Serializable

/**
 * Consequence - TODO: Documentation
 *
 * Created by Lynn on 5/1/23
 */
@Serializable
public sealed class Consequence {
    public abstract val specification: ConsequenceSpecification
}

@Serializable
public data class DiceConsequence constructor(
    override val specification: DiceConsequenceSpecification,
    val roll: Int,
) : Consequence()

@Serializable
public data class TextConsequence constructor(
    override val specification: TextConsequenceSpecification,
) : Consequence()