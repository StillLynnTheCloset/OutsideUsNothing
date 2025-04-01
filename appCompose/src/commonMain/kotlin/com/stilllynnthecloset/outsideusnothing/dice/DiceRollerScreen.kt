package com.stilllynnthecloset.outsideusnothing.dice

import androidx.compose.foundation.gestures.Orientation
import androidx.compose.foundation.gestures.draggable
import androidx.compose.foundation.gestures.rememberDraggableState
import androidx.compose.foundation.gestures.scrollBy
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
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Alignment.Companion.Center
import androidx.compose.ui.Alignment.Companion.CenterHorizontally
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import com.stilllynnthecloset.outsideusnothing.FlowCrossAxisAlignment
import com.stilllynnthecloset.outsideusnothing.FlowMainAxisAlignment
import com.stilllynnthecloset.outsideusnothing.FlowRow
import com.stilllynnthecloset.outsideusnothing.Platform
import com.stilllynnthecloset.outsideusnothing.library.tools.toString
import com.stilllynnthecloset.outsideusnothing.theme.dieRoll
import com.stilllynnthecloset.outsideusnothing.theme.incrementInput
import com.stilllynnthecloset.outsideusnothing.theme.outlinedButton
import com.stilllynnthecloset.outsideusnothing.theme.text
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

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
        val scope = rememberCoroutineScope { Dispatchers.Default }
        Column(
            modifier = Modifier
                .align(Center)
                .fillMaxSize()
                .draggable(rememberDraggableState { delta ->
                    scope.launch {
                        scrollState.scrollBy(-delta)
                    }
                }, orientation = Orientation.Vertical)
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
                text = "Odds of success are ${dataModel.odds?.toString(10)}",
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
                    dieRoll(
                        dieRoll = roll.first,
                        color = if (roll.second) Color.Green else Color.Red,
                        platform = platform,
                        modifier = Modifier.width(48.dp).height(48.dp),
                    )
                }
            }
        }
    }
}
