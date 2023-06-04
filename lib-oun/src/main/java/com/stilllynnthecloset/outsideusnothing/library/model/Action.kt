package com.stilllynnthecloset.outsideusnothing.library.model

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
    override val uuid: String = UUID.randomUUID().toString(),
) : UniversallyUnique
