package com.stilllynnthecloset.liboun.model

/**
 * EventSpecification - TODO: Documentation
 *
 * Created by Lynn on 5/1/23
 */
public data class EventSpecification constructor(
    val name: String,
    val description: String,
    val choices: Set<ChoiceSpecification>,
    val consequences: List<Consequence>,
) {
    public fun randomize(): Event {
        return Event(
            specification = this,
            choices = this.choices.map { it.randomize() },
        )
    }
}
