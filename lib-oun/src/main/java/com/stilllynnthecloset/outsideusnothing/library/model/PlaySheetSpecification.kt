package com.stilllynnthecloset.outsideusnothing.library.model

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
    override val uuid: String = UUID.randomUUID().toString(),
) : UniversallyUnique {
    public fun randomize(): PlaySheet = PlaySheet(this, choices = choices.map { it.randomize() })
}
