package com.stilllynnthecloset.liboun.model

/**
 * PlaySheet - TODO: Documentation
 *
 * Created by Lynn on 3/31/23
 */
public data class PlaySheet constructor(
    val specification: PlaySheetSpecification,
    val choices: Collection<Choice>,
)
