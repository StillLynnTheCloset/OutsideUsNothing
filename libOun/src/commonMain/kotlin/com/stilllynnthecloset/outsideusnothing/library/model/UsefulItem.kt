package com.stilllynnthecloset.outsideusnothing.library.model

import com.stilllynnthecloset.outsideusnothing.library.interfaces.UniversallyUnique
import kotlinx.serialization.Serializable
import kotlin.uuid.ExperimentalUuidApi
import kotlin.uuid.Uuid

/**
 * UsefulItem - TODO: Documentation
 *
 * Created by Lynn on 5/1/23
 */
@OptIn(ExperimentalUuidApi::class)
@Serializable
public data class UsefulItem constructor(
    val name: String,
    val action: Action,
    override val uuid: String = "item_" + Uuid.random().toString(),
) : UniversallyUnique
