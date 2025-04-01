package com.stilllynnthecloset.outsideusnothing.library.model

import com.stilllynnthecloset.outsideusnothing.library.interfaces.UniversallyUnique
import kotlinx.serialization.Serializable
import kotlin.uuid.ExperimentalUuidApi
import kotlin.uuid.Uuid

/**
 * Ship - TODO: Documentation
 *
 * Created by Lynn on 3/26/23
 */
@OptIn(ExperimentalUuidApi::class)
@Serializable
public data class Ship constructor(
    val name: String,
    val fuel: Int = 4,
    val supplies: Int = 8,
    val condition: HealthCondition = HealthCondition.HEALTHY,
    val playSheet: PlaySheet,
    override val uuid: String = "ship_" + Uuid.random().toString(),
) : UniversallyUnique
