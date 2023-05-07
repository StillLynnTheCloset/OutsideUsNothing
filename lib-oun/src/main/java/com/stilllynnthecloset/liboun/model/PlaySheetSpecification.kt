package com.stilllynnthecloset.liboun.model

import kotlinx.serialization.Serializable
import java.util.UUID

/**
 * PlaySheetSpecification - TODO: Documentation
 *
 * Created by Lynn on 3/31/23
 */
@Serializable
public data class PlaySheetSpecification constructor(
    val name: String,
    val description: String,
    val flavorText: FlavorText?,
    val choices: Collection<ChoiceSpecification>,
    val actions: Collection<Action>,
    val uuid: String = UUID.randomUUID().toString(),
) {
    public fun randomize(): PlaySheet = PlaySheet(this, choices = choices.map { it.randomize() })
}
