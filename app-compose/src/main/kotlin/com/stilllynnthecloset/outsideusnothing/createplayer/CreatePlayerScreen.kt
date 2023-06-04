package com.stilllynnthecloset.outsideusnothing.createplayer

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import com.stilllynnthecloset.outsideusnothing.Platform
import com.stilllynnthecloset.outsideusnothing.compose
import com.stilllynnthecloset.outsideusnothing.library.model.Choice
import com.stilllynnthecloset.outsideusnothing.theme.dropDown
import com.stilllynnthecloset.outsideusnothing.theme.radioButtons
import com.stilllynnthecloset.outsideusnothing.theme.text
import com.stilllynnthecloset.outsideusnothing.theme.textInputWidget

/**
 * CreatePlayerScreen - TODO: Documentation
 *
 * Created by Lynn on 5/5/23
 */
@Composable
internal fun CreatePlayerScreen(dataModel: CreatePlayerViewModel, platform: Platform) {
    val scrollState = rememberScrollState()
    Column(
        modifier = Modifier
            .fillMaxSize()
            .verticalScroll(scrollState),
    ) {
        textInputWidget(
            label = "Name",
            value = dataModel.player.name,
            modifier = Modifier,
            onValueChange = dataModel::onNameChanged,
        )

        dropDown(
            items = dataModel.currentPlaybook.aliens.map { it.value },
            selected = dataModel.selectedAlien,
            modifier = Modifier,
            platform = platform,
            onItemClick = dataModel::onAlienChanged,
            composeItem = { item, childModifier ->
                text(
                    text = item.name,
                    modifier = childModifier,
                )
            }
        )

        dataModel.selectedAlien.choices.forEach { choice ->
            val choicesMade: Choice? = dataModel.alienChoices.firstOrNull { it.specification == choice }
            val questionAnswers = choicesMade?.answeredQuestions.orEmpty()
            choice.questions.forEach { question ->
                text(
                    text = question.question,
                    modifier = Modifier,
                )
                val selections = questionAnswers.firstOrNull { it.question == question }?.answers.orEmpty()
                val blocked = questionAnswers.filterNot { it.question == question }.flatMap { it.answers }
                radioButtons(
                    options = choice.options,
                    blockedOptions = blocked,
                    selections = selections,
                    maximumSelections = question.answers,
                    onClick = { dataModel.onAlienChoiceMade(choice, question, it)},
                    composeItem = { item, childModifier ->
                        text(
                            text = item.text,
                            modifier = childModifier,
                        )
                    }
                )
            }
        }

        dropDown(
            items = dataModel.currentPlaybook.backgrounds.map { it.value },
            selected = dataModel.selectedBackground,
            modifier = Modifier,
            platform = platform,
            onItemClick = dataModel::onBackgroundChanged,
            composeItem = { item, childModifier ->
                text(
                    text = item.name,
                    modifier = childModifier,
                )
            }
        )

        dataModel.selectedBackground.choices.forEach { choice ->
            val choicesMade: Choice? = dataModel.backgroundChoices.firstOrNull { it.specification == choice }
            val questionAnswers = choicesMade?.answeredQuestions.orEmpty()
            choice.questions.forEach { question ->
                text(
                    text = question.question,
                    modifier = Modifier,
                )
                val selections = questionAnswers.firstOrNull { it.question == question }?.answers.orEmpty()
                val blocked = questionAnswers.filterNot { it.question == question }.flatMap { it.answers }
                radioButtons(
                    options = choice.options,
                    blockedOptions = blocked,
                    selections = selections,
                    maximumSelections = question.answers,
                    onClick = { dataModel.onBackgroundChoiceMade(choice, question, it)},
                    composeItem = { item, childModifier ->
                        text(
                            text = item.text,
                            modifier = childModifier,
                        )
                    }
                )
            }
        }

        dropDown(
            items = dataModel.currentPlaybook.roles.map { it.value },
            selected = dataModel.selectedRole,
            modifier = Modifier,
            platform = platform,
            onItemClick = dataModel::onRoleChanged,
            composeItem = { item, childModifier ->
                text(
                    text = item.name,
                    modifier = childModifier,
                )
            }
        )

        dataModel.selectedRole.choices.forEach { choice ->
            val choicesMade: Choice? = dataModel.roleChoices.firstOrNull { it.specification == choice }
            val questionAnswers = choicesMade?.answeredQuestions.orEmpty()
            choice.questions.forEach { question ->
                text(
                    text = question.question,
                    modifier = Modifier,
                )
                val selections = questionAnswers.firstOrNull { it.question == question }?.answers.orEmpty()
                val blocked = questionAnswers.filterNot { it.question == question }.flatMap { it.answers }
                radioButtons(
                    options = choice.options,
                    blockedOptions = blocked,
                    selections = selections,
                    maximumSelections = question.answers,
                    onClick = { dataModel.onRoleChoiceMade(choice, question, it)},
                    composeItem = { item, childModifier ->
                        text(
                            text = item.text,
                            modifier = childModifier,
                        )
                    }
                )
            }
        }

//        val theMurder = SerializerTools.serializer.decodeFromString<Player>(readFile("theMurder.json"))
        dataModel.player.compose(platform)
    }
}
