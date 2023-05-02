package com.stilllynnthecloset.liboun.model

import com.stilllynnthecloset.liboun.pickN

/**
 * ChoiceSpecification - TODO: Documentation
 *
 * Created by Lynn on 3/26/23
 */
public data class ChoiceSpecification constructor(
    val question: String,
    val options: Set<String>,
    val numberOfPositiveSelections: Int,
    val numberOfNegativeSelections: Int,
) {
    public fun randomize(): Choice {
        val positiveSelections = options.pickN(numberOfPositiveSelections)
        val negativeSelections = options.minus(positiveSelections).pickN(numberOfNegativeSelections)
        return Choice(
            specification = this,
            positiveSelections = positiveSelections,
            negativeSelections = negativeSelections,
        )
    }
}
