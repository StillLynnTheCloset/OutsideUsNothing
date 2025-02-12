package com.stilllynnthecloset.outsideusnothing.library.model

import com.stilllynnthecloset.outsideusnothing.library.interfaces.UniversallyUnique
import kotlinx.serialization.Serializable
import java.util.UUID

/**
 * Author - TODO: Documentation
 *
 * Created by Lynn on 5/5/23
 */
@Serializable
public data class Author constructor(
    val name: String,
    override val uuid: String = "author_" + UUID.randomUUID().toString(),
) : UniversallyUnique
