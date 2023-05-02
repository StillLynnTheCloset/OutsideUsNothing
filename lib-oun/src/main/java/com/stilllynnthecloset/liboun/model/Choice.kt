package com.stilllynnthecloset.liboun.model

/**
 * Choice - TODO: Documentation
 *
 * Created by Lynn on 3/26/23
 */
public data class Choice constructor(
    val specification: ChoiceSpecification,
    val positiveSelections: Set<String>,
    val negativeSelections: Set<String>,
)
