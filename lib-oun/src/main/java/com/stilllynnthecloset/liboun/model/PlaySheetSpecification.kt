package com.stilllynnthecloset.liboun.model

/**
 * PlaySheet - TODO: Documentation
 *
 * Created by Lynn on 3/31/23
 */
public data class PlaySheetSpecification constructor(
    val name: String,
    val description: String,
    val choices: List<ChoiceSpecification>,
    val actions: List<Action>,
) {
    public fun randomize(): PlaySheet = PlaySheet(this, choices = choices.map { it.randomize() })
}
