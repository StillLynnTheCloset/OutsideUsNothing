package com.stilllynnthecloset.outsideusnothing.library.model

import com.stilllynnthecloset.outsideusnothing.library.interfaces.UniversallyUnique
import kotlinx.serialization.Serializable
import kotlin.uuid.ExperimentalUuidApi
import kotlin.uuid.Uuid

/**
 * Consequence - TODO: Documentation
 *
 * Created by Lynn on 5/1/23
 */
@Serializable
public sealed class Consequence : UniversallyUnique {
    public abstract val specification: ConsequenceSpecification
}

@OptIn(ExperimentalUuidApi::class)
@Serializable
public data class DiceConsequence constructor(
    override val specification: DiceConsequenceSpecification,
    val roll: Int,
    override val uuid: String = "consequence_" + Uuid.random().toString(),
) : Consequence()

@OptIn(ExperimentalUuidApi::class)
@Serializable
public data class TextConsequence constructor(
    override val specification: TextConsequenceSpecification,
    override val uuid: String = "consequence_" + Uuid.random().toString(),
) : Consequence()