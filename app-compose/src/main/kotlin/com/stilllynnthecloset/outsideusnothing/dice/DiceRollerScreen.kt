package com.stilllynnthecloset.outsideusnothing.dice

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment.Companion.Center
import androidx.compose.ui.Alignment.Companion.CenterHorizontally
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.ColorFilter
import androidx.compose.ui.unit.dp
import com.stilllynnthecloset.outsideusnothing.FlowCrossAxisAlignment
import com.stilllynnthecloset.outsideusnothing.FlowMainAxisAlignment
import com.stilllynnthecloset.outsideusnothing.FlowRow
import com.stilllynnthecloset.outsideusnothing.Platform
import com.stilllynnthecloset.outsideusnothing.theme.ImageReference
import com.stilllynnthecloset.outsideusnothing.theme.incrementInput
import com.stilllynnthecloset.outsideusnothing.theme.outlinedButton
import com.stilllynnthecloset.outsideusnothing.theme.text

/**
 * DiceRollerScreen - TODO: Documentation
 *
 * Created by Lynn on 3/22/23
 */
@Composable
internal fun DiceRollerScreen(dataModel: DiceRollerDataModel, platform: Platform) {
    Box(
        modifier = Modifier
            .fillMaxSize()
            .padding(10.dp),
    ) {
        val scrollState = rememberScrollState()
        Column(
            modifier = Modifier
                .align(Center)
                .fillMaxSize()
                .verticalScroll(scrollState),
        ) {
            incrementInput(
                label = "Action Cost",
                modifier = Modifier
                    .align(CenterHorizontally)
                    .padding(8.dp),
                value = dataModel.state.actionCost,
                onValueChange = dataModel::updateActionCost,
                platform = platform,
            )
            incrementInput(
                label = "Action Difficulty",
                modifier = Modifier
                    .align(CenterHorizontally)
                    .padding(8.dp),
                value = dataModel.state.actionDifficulty,
                onValueChange = dataModel::updateActionDifficulty,
                platform = platform,
            )
            incrementInput(
                label = "Dice to Roll",
                modifier = Modifier
                    .align(CenterHorizontally)
                    .padding(8.dp),
                value = dataModel.state.diceToRoll,
                onValueChange = dataModel::updateDiceToRoll,
                platform = platform,
            )
            incrementInput(
                label = "Dice Sides",
                modifier = Modifier
                    .align(CenterHorizontally)
                    .padding(8.dp),
                value = dataModel.state.diceSides,
                onValueChange = dataModel::updateDiceSides,
                platform = platform,
            )

            text(
                text = "Odds of success are ${String.format("%.10f", dataModel.odds)}",
                modifier = Modifier
                    .align(CenterHorizontally),
            )

            Spacer(
                modifier = Modifier.height(30.dp),
            )

            incrementInput(
                label = "Dice Pool",
                modifier = Modifier
                    .align(CenterHorizontally)
                    .padding(8.dp),
                value = dataModel.state.dicePool,
                onValueChange = dataModel::updateDicePool,
                platform = platform,
            )

            outlinedButton(
                onClick = dataModel::roll,
                modifier = Modifier
                    .align(CenterHorizontally),
            ) {
                text(
                    text = "Roll Dice",
                    modifier = Modifier,
                )
            }

            val success = dataModel.lastRollSuccessful
            if (success != null) {
                Text(
                    text = if (success) "Success!" else "Failed.",
                    color = if (success) Color.Green else Color.Red,
                    modifier = Modifier
                        .align(CenterHorizontally),
                )
            }

            FlowRow(
                modifier = Modifier.align(CenterHorizontally),
                mainAxisAlignment = FlowMainAxisAlignment.Center,
                crossAxisAlignment = FlowCrossAxisAlignment.Center,
            ) {
                dataModel.lastRoll?.forEach { roll ->
                    Image(
                        painter = platform.imagePainter.getPainter(
                            image = when (roll.first) {
                                1 -> ImageReference.Dice1
                                2 -> ImageReference.Dice2
                                3 -> ImageReference.Dice3
                                4 -> ImageReference.Dice4
                                5 -> ImageReference.Dice5
                                6 -> ImageReference.Dice6
                                else -> ImageReference.Dice6
                            },
                        ),
                        colorFilter = ColorFilter.tint(if (roll.second) Color.Green else Color.Red),
                        contentDescription = "$roll",
                        modifier = Modifier
                            .width(48.dp),
                    )
                }
            }
        }
    }
}
