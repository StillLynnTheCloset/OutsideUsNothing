package com.stilllynnthecloset.liboun.model

/**
 * PlaySheet - TODO: Documentation
 *
 * Created by Lynn on 3/31/23
 */
public data class PlaySheetSpecification constructor(
    val name: String,
    val description: String,
    val choices: Collection<ChoiceSpecification>,
    val actions: Collection<Action>,
) {
    public fun randomize(): PlaySheet = PlaySheet(this, choices = choices.map { it.randomize() })
}
