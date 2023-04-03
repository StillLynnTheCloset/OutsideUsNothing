package com.stilllynnthecloset.liboun.model

/**
 * PlaySheet - TODO: Documentation
 *
 * Created by Lynn on 3/31/23
 */
public data class PlaySheet constructor(
    val name: String,
    val choices: List<PlaySheetChoice>,
    val actions: List<Action>,
) {
    public fun withRandomChoices(): PlaySheet = this.copy(choices = choices.map { it.withRandomAnswers() })
}
