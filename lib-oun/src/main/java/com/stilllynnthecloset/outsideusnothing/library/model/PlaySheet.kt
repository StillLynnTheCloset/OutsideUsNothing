package com.stilllynnthecloset.outsideusnothing.library.model

import com.stilllynnthecloset.outsideusnothing.library.interfaces.UniversallyUnique
import kotlinx.serialization.Serializable
import java.util.UUID

/**
 * PlaySheet - TODO: Documentation
 *
 * Created by Lynn on 3/31/23
 */
@Serializable
public data class PlaySheet constructor(
    val specification: PlaySheetSpecification,
    val choices: Collection<Choice>,
    override val uuid: String = "playsheet_" + UUID.randomUUID().toString(),
) : UniversallyUnique
