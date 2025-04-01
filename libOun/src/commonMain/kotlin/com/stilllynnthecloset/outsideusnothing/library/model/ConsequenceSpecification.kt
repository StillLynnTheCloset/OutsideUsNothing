package com.stilllynnthecloset.outsideusnothing.library.model

import com.stilllynnthecloset.outsideusnothing.library.interfaces.Randomizable
import com.stilllynnthecloset.outsideusnothing.library.interfaces.UniversallyUnique
import com.stilllynnthecloset.outsideusnothing.library.tools.rollDice
import kotlinx.serialization.Serializable
import kotlin.uuid.ExperimentalUuidApi
import kotlin.uuid.Uuid

/**
 * ConsequenceSpecification - TODO: Documentation
 *
 * Created by Lynn on 5/1/23
 */
@Serializable
public sealed class ConsequenceSpecification : UniversallyUnique, Randomizable<Consequence> {
    public abstract val name: String
}

@OptIn(ExperimentalUuidApi::class)
@Serializable
public data class DiceConsequenceSpecification constructor(
    override val name: String,
    val diceToRoll: Int = 1,
    val diceSides: Int = 6,
    override val uuid: String = "consequencespec_" + Uuid.random().toString(),
) : ConsequenceSpecification() {
    public override fun randomize(playbook: Playbook): DiceConsequence = DiceConsequence(this, rollDice(diceToRoll, diceSides).sumOf { it.value })
}

@OptIn(ExperimentalUuidApi::class)
@Serializable
public data class TextConsequenceSpecification constructor(
    override val name: String,
    override val uuid: String = "consequencespec_" + Uuid.random().toString(),
) : ConsequenceSpecification() {
    public override fun randomize(playbook: Playbook): TextConsequence = TextConsequence(this)
}