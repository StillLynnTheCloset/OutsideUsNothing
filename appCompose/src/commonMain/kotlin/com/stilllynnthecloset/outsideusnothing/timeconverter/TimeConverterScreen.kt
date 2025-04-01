package com.stilllynnthecloset.outsideusnothing.timeconverter

import androidx.compose.foundation.gestures.Orientation
import androidx.compose.foundation.gestures.draggable
import androidx.compose.foundation.gestures.rememberDraggableState
import androidx.compose.foundation.gestures.scrollBy
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.runtime.Composable
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Alignment.Companion.Center
import androidx.compose.ui.Alignment.Companion.CenterHorizontally
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.stilllynnthecloset.outsideusnothing.Platform
import com.stilllynnthecloset.outsideusnothing.indentPadding
import com.stilllynnthecloset.outsideusnothing.library.tools.toString
import com.stilllynnthecloset.outsideusnothing.theme.doubleInputWidget
import com.stilllynnthecloset.outsideusnothing.theme.text
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

/**
 * DiceRollerScreen - TODO: Documentation
 *
 * Created by Lynn on 3/22/23
 */
@Composable
internal fun TimeConverterScreen(dataModel: TimeConverterDataModel, platform: Platform) {
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
                .verticalScroll(scrollState)
                .padding(indentPadding),
        ) {
            doubleInputWidget(
                label = "Periods",
                modifier = Modifier
                    .align(CenterHorizontally)
                    .padding(8.dp),
                value = dataModel.state.periodsInput,
                onValueChange = dataModel::updatePeriodsInput,
            )

            text(
                text = "${dataModel.millisecondsOutput?.toString(10)} milliseconds",
                modifier = Modifier
                    .align(CenterHorizontally),
            )
        }
    }
}
