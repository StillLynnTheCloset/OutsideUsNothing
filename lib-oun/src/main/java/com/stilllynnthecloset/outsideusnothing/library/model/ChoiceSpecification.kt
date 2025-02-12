package com.stilllynnthecloset.outsideusnothing.library.model

import com.stilllynnthecloset.outsideusnothing.library.interfaces.Latexible
import com.stilllynnthecloset.outsideusnothing.library.interfaces.Mergable
import com.stilllynnthecloset.outsideusnothing.library.interfaces.Randomizable
import com.stilllynnthecloset.outsideusnothing.library.interfaces.UniversallyUnique
import com.stilllynnthecloset.outsideusnothing.library.tools.pickN
import kotlinx.serialization.Serializable
import java.util.UUID

/**
 * ChoiceSpecification - TODO: Documentation
 *
 * Created by Lynn on 3/26/23
 */
@Serializable
public data class ChoiceSpecification constructor(
    val options: Collection<Option>,
    val questions: Collection<Question>,
    override val uuid: String = "choicespec_" + UUID.randomUUID().toString(),
) : UniversallyUnique, Latexible, Randomizable<Choice>, Mergable<ChoiceSpecification> {
    public override fun randomize(playbook: Playbook): Choice {
        val accumulatedSelections = mutableSetOf<Option>()
        val optionsSet = options.toSet()
        return Choice(
            specification = this,
            answeredQuestions = questions.map {
                val picks = optionsSet.minus(accumulatedSelections).pickN(it.answers)
                accumulatedSelections.addAll(picks)
                AnsweredQuestion(
                    question = it,
                    answers = picks,
                )
            },
        )
    }

    public override fun toLatex(builder: StringBuilder) {
        questions.forEach { it.toLatex(builder) }
        options.forEach { it.toLatex(builder) }
    }

    public override fun merge(other: ChoiceSpecification): ChoiceSpecification {
        if (other.uuid != this.uuid) {
            throw IllegalArgumentException("Cannot merge different UUIDs")
        }
        return ChoiceSpecification(
            options = this.options.toSet() + other.options,
            questions = this.questions.toSet() + other.questions,
            uuid = this.uuid
        )
    }
}
