package com.stilllynnthecloset.liboun.model

/**
 * PlaySheetChoice - TODO: Documentation
 *
 * Created by Lynn on 3/26/23
 */
public data class PlaySheetChoice constructor(
    val specification: PlaySheetChoiceSpecification,
    val positiveSelections: Set<String>,
    val negativeSelections: Set<String>,
)
