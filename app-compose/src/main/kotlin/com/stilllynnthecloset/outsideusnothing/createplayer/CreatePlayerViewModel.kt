package com.stilllynnthecloset.outsideusnothing.createplayer

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.compose.ui.geometry.Offset
import com.stilllynnthecloset.outsideusnothing.MainDataModel
import com.stilllynnthecloset.outsideusnothing.WindowDataModel
import com.stilllynnthecloset.outsideusnothing.library.model.AnsweredQuestion
import com.stilllynnthecloset.outsideusnothing.library.model.Choice
import com.stilllynnthecloset.outsideusnothing.library.model.ChoiceSpecification
import com.stilllynnthecloset.outsideusnothing.library.model.HealthCondition
import com.stilllynnthecloset.outsideusnothing.library.model.Option
import com.stilllynnthecloset.outsideusnothing.library.model.PlaySheet
import com.stilllynnthecloset.outsideusnothing.library.model.PlaySheetSpecification
import com.stilllynnthecloset.outsideusnothing.library.model.Playbook
import com.stilllynnthecloset.outsideusnothing.library.model.Player
import com.stilllynnthecloset.outsideusnothing.library.model.Question

/**
 * CreatePlayerViewModel - TODO: Documentation
 *
 * Created by Lynn on 5/5/23
 */
internal class CreatePlayerViewModel constructor(private val mainDataModel: MainDataModel) {
    private val dropdownDefault = PlaySheetSpecification(
        name = "Select a playsheet",
        description = "",
        flavorText = null,
        choices = emptyList(),
        actions = emptyList(),
    )
    val currentPlaybook: Playbook
        get() = mainDataModel.mergedPlaybook

    var player: Player by mutableStateOf(Player("", 0, HealthCondition.HEALTHY, emptyList(), emptyList()))
        private set

    fun onNameChanged(newName: String) {
        player = player.copy(name = newName)
    }

    var selectedAlien: PlaySheetSpecification by mutableStateOf(dropdownDefault)
        private set

    var alienChoices: List<Choice> by mutableStateOf(emptyList())
        private set

    fun onAlienChanged(newAlien: PlaySheetSpecification) {
        selectedAlien = newAlien
        alienChoices = emptyList()
        buildPlayer()
    }

    fun onAlienChoiceMade(choiceSpecification: ChoiceSpecification, question: Question, optionSelected: Option) {
        alienChoices = updateChoices(alienChoices, choiceSpecification, question, optionSelected)
        buildPlayer()
    }

    var selectedBackground: PlaySheetSpecification by mutableStateOf(dropdownDefault)
        private set

    var backgroundChoices: List<Choice> by mutableStateOf(emptyList())
        private set

    fun onBackgroundChanged(newBackground: PlaySheetSpecification) {
        selectedBackground = newBackground
        backgroundChoices = emptyList()
        buildPlayer()
    }

    fun onBackgroundChoiceMade(choiceSpecification: ChoiceSpecification, question: Question, optionSelected: Option) {
        backgroundChoices = updateChoices(backgroundChoices, choiceSpecification, question, optionSelected)
        buildPlayer()
    }

    var selectedRole: PlaySheetSpecification by mutableStateOf(dropdownDefault)
        private set

    var roleChoices: List<Choice> by mutableStateOf(emptyList())
        private set

    fun onRoleChanged(newRole: PlaySheetSpecification) {
        selectedRole = newRole
        roleChoices = emptyList()
        buildPlayer()
    }

    fun onRoleChoiceMade(choiceSpecification: ChoiceSpecification, question: Question, optionSelected: Option) {
        roleChoices = updateChoices(roleChoices, choiceSpecification, question, optionSelected)
        buildPlayer()
    }

    private fun updateChoices(prevChoices: List<Choice>, choiceSpecification: ChoiceSpecification, question: Question, optionSelected: Option): List<Choice> {
        println("Before: $prevChoices")
        val choice = prevChoices.firstOrNull { it.specification == choiceSpecification }
        val result = if (choice == null) {
            // No choice has been made here before, we can just add a new choice to the list.
            prevChoices + Choice(choiceSpecification, listOf(AnsweredQuestion(question, listOf(optionSelected))))
        } else {
            // Mutate the existing choice, either adding or removing the selection
            val answeredQuestion = choice.answeredQuestions.firstOrNull { it.question == question }
            if (answeredQuestion == null) {
                // This question has not been answered before, we can just add a new answer.
                prevChoices.map {
                    if (it == choice) {
                        it.copy(answeredQuestions = it.answeredQuestions + AnsweredQuestion(question, listOf(optionSelected)))
                    } else {
                        it
                    }
                }
            } else {
                // This question has been answered before, we need to mutate it
                val selectedOptions = answeredQuestion.answers
                val newOptions = if (optionSelected in selectedOptions) {
                    // This option was previously selected, deselect it.
                    selectedOptions - optionSelected
                } else {
                    // This option was not previously selected, select it.
                    selectedOptions + optionSelected
                }
                prevChoices.map {
                    if (it == choice) {
                        val newAnswers = it.answeredQuestions.map {
                            if (it.question == answeredQuestion.question) {
                                AnsweredQuestion(question, newOptions)
                            } else {
                                it
                            }
                        }
                        it.copy(answeredQuestions = newAnswers)
                    } else {
                        it
                    }
                }
            }
        }
        println("After: $result")
        return result
    }

    private fun buildPlayer() {
        val newPlayer = player.copy(
            playSheets = listOfNotNull(
                selectedAlien.takeIf { it != dropdownDefault }?.let {
                    PlaySheet(
                        specification = selectedAlien,
                        choices = alienChoices,
                    )
                },
                selectedBackground.takeIf { it != dropdownDefault }?.let {
                    PlaySheet(
                        specification = selectedBackground,
                        choices = backgroundChoices,
                    )
                },
                selectedRole.takeIf { it != dropdownDefault }?.let {
                    PlaySheet(
                        specification = selectedRole,
                        choices = roleChoices,
                    )
                },
            )
        )
        player = newPlayer
        println(newPlayer)
        println(newPlayer.toJson())
    }
}
