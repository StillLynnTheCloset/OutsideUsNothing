package com.stilllynnthecloset.outsideusnothing.library.model

import com.stilllynnthecloset.outsideusnothing.library.interfaces.UniversallyUnique
import kotlinx.serialization.Serializable
import java.util.UUID

/**
 * Bastard - TODO: Documentation
 *
 * Created by Lynn on 5/1/23
 */
@Serializable
public data class Bastard constructor(
    val name: String,
    val description: String,
    override val uuid: String = "bastard_" + UUID.randomUUID().toString(),
) : UniversallyUnique
