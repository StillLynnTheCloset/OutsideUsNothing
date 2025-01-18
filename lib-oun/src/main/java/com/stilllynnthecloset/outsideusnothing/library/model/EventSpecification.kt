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
    override val flavorText: FlavorText,
    val description: String,
    val choices: Collection<ChoiceSpecification>,
    val consequences: Collection<ConsequenceSpecification>,
    override val uuid: String = "eventspec_" + UUID.randomUUID().toString(),
) : UniversallyUnique, Flavored, Randomizable<Event> {
    public override fun randomize(playbook: Playbook): Event {
        return Event(
            specification = this,
            choices = this.choices.map { it.randomize(playbook) },
            consequences = this.consequences.map { it.randomize(playbook) },
        )
    }
}
