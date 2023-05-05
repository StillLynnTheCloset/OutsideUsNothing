package com.stilllynnthecloset.liboun.model

import kotlinx.serialization.Serializable

/**
 * PlaySheet - TODO: Documentation
 *
 * Created by Lynn on 3/31/23
 */
@Serializable
public data class PlaySheet constructor(
    val specification: PlaySheetSpecification,
    val choices: Collection<Choice>,
)
