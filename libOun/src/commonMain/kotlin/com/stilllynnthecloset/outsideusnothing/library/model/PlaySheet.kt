package com.stilllynnthecloset.outsideusnothing.library.model

import com.stilllynnthecloset.outsideusnothing.library.interfaces.UniversallyUnique
import kotlinx.serialization.Serializable
import kotlin.uuid.ExperimentalUuidApi
import kotlin.uuid.Uuid

/**
 * PlaySheet - TODO: Documentation
 *
 * Created by Lynn on 3/31/23
 */
@Serializable
public data class PlaySheet @OptIn(ExperimentalUuidApi::class) constructor(
    val specification: PlaySheetSpecification,
    val choices: Collection<Choice>,
    override val uuid: String = "playsheet_" + Uuid.random().toString(),
) : UniversallyUnique
