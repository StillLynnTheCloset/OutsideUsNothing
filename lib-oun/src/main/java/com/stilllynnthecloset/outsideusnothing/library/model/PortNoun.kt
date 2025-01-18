package com.stilllynnthecloset.outsideusnothing.library.model

import kotlinx.serialization.Serializable
import java.util.UUID

/**
 * PortType - TODO: Documentation
 *
 * Created by Lynn on 5/7/23
 */
@Serializable
public data class PortNoun constructor(
    val text: String,
    override val uuid: String = "portnoun_" + UUID.randomUUID().toString(),
) : UniversallyUnique
