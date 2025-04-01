package com.stilllynnthecloset.outsideusnothing.library.model

import com.stilllynnthecloset.outsideusnothing.library.interfaces.Flavored
import com.stilllynnthecloset.outsideusnothing.library.interfaces.Randomizable
import com.stilllynnthecloset.outsideusnothing.library.interfaces.UniversallyUnique
import kotlinx.serialization.Serializable
import kotlin.uuid.ExperimentalUuidApi
import kotlin.uuid.Uuid

/**
 * EventSpecification - TODO: Documentation
 *
 * Created by Lynn on 5/1/23
 */
@OptIn(ExperimentalUuidApi::class)
@Serializable
public data class EventSpecification constructor(
    val name: String,
    override val flavorText: FlavorText,
    val description: String,
    val choices: Collection<ChoiceSpecification>,
    val consequences: Collection<ConsequenceSpecification>,
    override val uuid: String = "eventspec_" + Uuid.random().toString(),
) : UniversallyUnique, Flavored, Randomizable<Event> {
    public override fun randomize(playbook: Playbook): Event {
        return Event(
            specification = this,
            choices = this.choices.map { it.randomize(playbook) },
            consequences = this.consequences.map { it.randomize(playbook) },
        )
    }
}
