package com.stilllynnthecloset.outsideusnothing.library.model

import com.stilllynnthecloset.outsideusnothing.library.interfaces.UniversallyUnique
import kotlinx.serialization.Serializable
import kotlin.uuid.ExperimentalUuidApi
import kotlin.uuid.Uuid

/**
 * NpcType - TODO: Documentation
 *
 * Created by Lynn on 5/7/23
 */
@OptIn(ExperimentalUuidApi::class)
@Serializable
public data class NpcNoun constructor(
    val text: String,
    override val uuid: String = "npcnoun_" + Uuid.random().toString(),
) : UniversallyUnique
