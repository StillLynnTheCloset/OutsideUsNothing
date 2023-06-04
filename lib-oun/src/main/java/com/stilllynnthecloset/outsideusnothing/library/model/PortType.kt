package com.stilllynnthecloset.outsideusnothing.library.model

import kotlinx.serialization.Serializable
import java.util.UUID

/**
 * PortType - TODO: Documentation
 *
 * Created by Lynn on 5/7/23
 */
@Serializable
public data class PortType constructor(
    val text: String,
    override val uuid: String = UUID.randomUUID().toString(),
) : UniversallyUnique
