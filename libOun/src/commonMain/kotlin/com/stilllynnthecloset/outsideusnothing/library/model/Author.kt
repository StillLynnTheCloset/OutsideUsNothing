package com.stilllynnthecloset.outsideusnothing.library.model

import com.stilllynnthecloset.outsideusnothing.library.interfaces.UniversallyUnique
import kotlinx.serialization.Serializable
import kotlin.uuid.ExperimentalUuidApi
import kotlin.uuid.Uuid

/**
 * Author - TODO: Documentation
 *
 * Created by Lynn on 5/5/23
 */
@OptIn(ExperimentalUuidApi::class)
@Serializable
public data class Author constructor(
    val name: String,
    override val uuid: String = "author_" + Uuid.random().toString(),
) : UniversallyUnique
