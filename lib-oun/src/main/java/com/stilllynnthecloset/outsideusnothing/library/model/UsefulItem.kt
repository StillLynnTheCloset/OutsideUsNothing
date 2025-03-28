package com.stilllynnthecloset.outsideusnothing.library.model

import com.stilllynnthecloset.outsideusnothing.library.interfaces.UniversallyUnique
import kotlinx.serialization.Serializable
import java.util.UUID

/**
 * UsefulItem - TODO: Documentation
 *
 * Created by Lynn on 5/1/23
 */
@Serializable
public data class UsefulItem constructor(
    val name: String,
    val action: Action,
    override val uuid: String = "item_" + UUID.randomUUID().toString(),
) : UniversallyUnique
