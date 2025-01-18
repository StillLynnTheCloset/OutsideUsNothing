package com.stilllynnthecloset.outsideusnothing.library.model

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
    override val uuid: String = UUID.randomUUID().toString(),
) : UniversallyUnique, Latexible, Randomizable<Choice> {
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
}
