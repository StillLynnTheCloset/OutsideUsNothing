package com.stilllynnthecloset.outsideusnothing.library.model

import com.stilllynnthecloset.outsideusnothing.library.interfaces.UniversallyUnique
import kotlinx.serialization.Serializable
import java.util.UUID

/**
 * PortAdjective - TODO: Documentation
 *
 * Created by Lynn on 5/7/23
 */
@Serializable
public data class PortAdjective constructor(
    val text: String,
    override val uuid: String = "portadj_" + UUID.randomUUID().toString(),
) : UniversallyUnique
