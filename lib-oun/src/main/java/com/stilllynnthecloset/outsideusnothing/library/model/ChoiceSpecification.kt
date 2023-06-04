package com.stilllynnthecloset.outsideusnothing.library.model

import com.stilllynnthecloset.outsideusnothing.library.pickN
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
) : UniversallyUnique {
    public fun randomize(): Choice {
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
}
