package com.stilllynnthecloset.liboun.model

import com.stilllynnthecloset.liboun.pickN

/**
 * PlaySheetChoice - TODO: Documentation
 *
 * Created by Lynn on 3/26/23
 */
public data class PlaySheetChoice constructor(
    val question: String,
    val options: Set<String>,
    val numberOfPositiveSelections: Int,
    val numberOfNegativeSelections: Int,
    val positiveSelections: Set<String>? = null,
    val negativeSelections: Set<String>? = null,
) {
    public fun withRandomAnswers(): PlaySheetChoice {
        val positiveSelections = options.pickN(numberOfPositiveSelections)
        val negativeSelections = options.minus(positiveSelections).pickN(numberOfNegativeSelections)
        return this.copy(positiveSelections = positiveSelections, negativeSelections = negativeSelections)
    }
}
