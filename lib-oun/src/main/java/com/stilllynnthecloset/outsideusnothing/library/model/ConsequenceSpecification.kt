package com.stilllynnthecloset.outsideusnothing.library.model

import com.stilllynnthecloset.outsideusnothing.library.tools.rollDice
import kotlinx.serialization.Serializable
import java.util.UUID

/**
 * ConsequenceSpecification - TODO: Documentation
 *
 * Created by Lynn on 5/1/23
 */
@Serializable
public sealed class ConsequenceSpecification : UniversallyUnique {
    public abstract val name: String
    public abstract fun randomize(): Consequence
}

@Serializable
public data class DiceConsequenceSpecification constructor(
    override val name: String,
    val diceToRoll: Int = 1,
    val diceSides: Int = 6,
    override val uuid: String = UUID.randomUUID().toString(),
) : ConsequenceSpecification() {
    public override fun randomize(): DiceConsequence = DiceConsequence(this, rollDice(diceToRoll, diceSides).sumOf { it.value })
}

@Serializable
public data class TextConsequenceSpecification constructor(
    override val name: String,
    override val uuid: String = UUID.randomUUID().toString(),
) : ConsequenceSpecification() {
    public override fun randomize(): TextConsequence = TextConsequence(this)
}