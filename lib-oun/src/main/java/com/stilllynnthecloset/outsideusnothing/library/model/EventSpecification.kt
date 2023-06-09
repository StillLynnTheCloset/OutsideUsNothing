package com.stilllynnthecloset.outsideusnothing.library.model

import kotlinx.serialization.Serializable
import java.util.UUID

/**
 * EventSpecification - TODO: Documentation
 *
 * Created by Lynn on 5/1/23
 */
@Serializable
public data class EventSpecification constructor(
    val name: String,
    val description: String,
    val choices: Collection<ChoiceSpecification>,
    val consequences: Collection<ConsequenceSpecification>,
    override val uuid: String = UUID.randomUUID().toString(),
) : UniversallyUnique {
    public fun randomize(): Event {
        return Event(
            specification = this,
            choices = this.choices.map { it.randomize() },
            consequences = this.consequences.map { it.randomize() },
        )
    }
}
