package com.stilllynnthecloset.outsideusnothing.library.model

import com.stilllynnthecloset.outsideusnothing.library.interfaces.UniversallyUnique
import kotlinx.serialization.Serializable
import java.util.UUID

/**
 * NpcType - TODO: Documentation
 *
 * Created by Lynn on 5/7/23
 */
@Serializable
public data class NpcNoun constructor(
    val text: String,
    override val uuid: String = "npcnoun_" + UUID.randomUUID().toString(),
) : UniversallyUnique
