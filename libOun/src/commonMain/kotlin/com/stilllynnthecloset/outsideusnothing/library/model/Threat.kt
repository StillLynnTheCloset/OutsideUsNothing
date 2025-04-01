package com.stilllynnthecloset.outsideusnothing.library.model

import com.stilllynnthecloset.outsideusnothing.library.interfaces.UniversallyUnique
import kotlinx.serialization.Serializable
import kotlin.uuid.ExperimentalUuidApi
import kotlin.uuid.Uuid

/**
 * Threat - TODO: Documentation
 *
 * Created by Lynn on 5/1/23
 */
@OptIn(ExperimentalUuidApi::class)
@Serializable
public data class Threat constructor(
    val name: String,
    override val uuid: String = "threat_" + Uuid.random().toString(),
) : UniversallyUnique
