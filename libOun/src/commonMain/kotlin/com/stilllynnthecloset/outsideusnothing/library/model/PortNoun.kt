package com.stilllynnthecloset.outsideusnothing.library.model

import com.stilllynnthecloset.outsideusnothing.library.interfaces.UniversallyUnique
import kotlinx.serialization.Serializable
import kotlin.uuid.ExperimentalUuidApi
import kotlin.uuid.Uuid

/**
 * PortType - TODO: Documentation
 *
 * Created by Lynn on 5/7/23
 */
@OptIn(ExperimentalUuidApi::class)
@Serializable
public data class PortNoun constructor(
    val text: String,
    override val uuid: String = "portnoun_" + Uuid.random().toString(),
) : UniversallyUnique
