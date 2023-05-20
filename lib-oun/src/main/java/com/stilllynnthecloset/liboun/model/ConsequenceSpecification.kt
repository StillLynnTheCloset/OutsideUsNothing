package com.stilllynnthecloset.liboun.model

import com.stilllynnthecloset.liboun.rollDice
import kotlinx.serialization.Serializable

/**
 * ConsequenceSpecification - TODO: Documentation
 *
 * Created by Lynn on 5/1/23
 */
@Serializable
public sealed class ConsequenceSpecification {
    public abstract val name: String
    public abstract fun randomize(): Consequence
}

@Serializable
public data class DiceConsequenceSpecification constructor(
    override val name: String,
    val diceToRoll: Int = 1,
    val diceSides: Int = 6,
) : ConsequenceSpecification() {
    public override fun randomize(): DiceConsequence = DiceConsequence(this, rollDice(diceToRoll, diceSides).sum())
}

@Serializable
public data class TextConsequenceSpecification constructor(
    override val name: String,
) : ConsequenceSpecification() {
    public override fun randomize(): TextConsequence = TextConsequence(this)
}