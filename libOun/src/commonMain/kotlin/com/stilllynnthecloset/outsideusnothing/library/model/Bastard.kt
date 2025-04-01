package com.stilllynnthecloset.outsideusnothing.library.model

import com.stilllynnthecloset.outsideusnothing.library.interfaces.UniversallyUnique
import kotlinx.serialization.Serializable
import kotlin.uuid.ExperimentalUuidApi
import kotlin.uuid.Uuid

/**
 * Bastard - TODO: Documentation
 *
 * Created by Lynn on 5/1/23
 */
@OptIn(ExperimentalUuidApi::class)
@Serializable
public data class Bastard constructor(
    val name: String,
    val description: String,
    override val uuid: String = "bastard_" + Uuid.random().toString(),
) : UniversallyUnique
