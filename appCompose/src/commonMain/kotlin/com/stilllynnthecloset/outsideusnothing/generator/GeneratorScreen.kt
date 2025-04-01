package com.stilllynnthecloset.outsideusnothing.generator

import androidx.compose.foundation.gestures.Orientation
import androidx.compose.foundation.gestures.draggable
import androidx.compose.foundation.gestures.rememberDraggableState
import androidx.compose.foundation.gestures.scrollBy
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.text.selection.SelectionContainer
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import com.stilllynnthecloset.outsideusnothing.Platform
import com.stilllynnthecloset.outsideusnothing.compose
import com.stilllynnthecloset.outsideusnothing.indentPadding
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

/**
 * OrganizerScreen - TODO: Documentation
 *
 * Created by Lynn on 4/14/23
 */
@Composable
internal fun GeneratorScreen(dataModel: GeneratorViewModel, platform: Platform) {
    val scrollState = rememberScrollState()
    val scope = rememberCoroutineScope { Dispatchers.Default }
    Column(
        modifier = Modifier
            .fillMaxSize()
            .draggable(rememberDraggableState { delta ->
                scope.launch {
                    scrollState.scrollBy(-delta)
                }
            }, orientation = Orientation.Vertical)
            .verticalScroll(scrollState)
            .padding(indentPadding),
    ) {
        Row(
            modifier = Modifier.align(Alignment.CenterHorizontally),
        ) {
            Button(
                onClick = dataModel::generatePort,
                modifier = Modifier,
            ) {
                Text("Generate a port of call")
            }
            Button(
                onClick = dataModel::clearPort,
                modifier = Modifier,
            ) {
                Text("Clear port of call")
            }
        }
        SelectionContainer {
            dataModel.generatedPort?.compose(platform)
        }
        Row(
            modifier = Modifier.align(Alignment.CenterHorizontally),
        ) {
            Button(
                onClick = dataModel::generateBastard,
                modifier = Modifier,
            ) {
                Text("Generate a bastard")
            }
            Button(
                onClick = dataModel::clearBastard,
                modifier = Modifier,
            ) {
                Text("Clear bastard")
            }
        }
        SelectionContainer {
            dataModel.generatedBastard?.compose(platform)
        }
        Row(
            modifier = Modifier.align(Alignment.CenterHorizontally),
        ) {
            Button(
                onClick = dataModel::generateContract,
                modifier = Modifier,
            ) {
                Text("Generate a contract")
            }
            Button(
                onClick = dataModel::clearContract,
                modifier = Modifier,
            ) {
                Text("Clear contract")
            }
        }
        SelectionContainer {
            dataModel.generatedContract?.compose(platform)
        }
        Row(
            modifier = Modifier.align(Alignment.CenterHorizontally),
        ) {
            Button(
                onClick = dataModel::generateContractItem,
                modifier = Modifier,
            ) {
                Text("Generate a contract item")
            }
            Button(
                onClick = dataModel::clearContractItem,
                modifier = Modifier,
            ) {
                Text("Clear contract item")
            }
        }
        SelectionContainer {
            dataModel.generatedContractDetail?.compose(platform)
        }
        Row(
            modifier = Modifier.align(Alignment.CenterHorizontally),
        ) {
            Button(
                onClick = dataModel::generateEvent,
                modifier = Modifier,
            ) {
                Text("Generate an event")
            }
            Button(
                onClick = dataModel::clearEvent,
                modifier = Modifier,
            ) {
                Text("Clear event")
            }
        }
        SelectionContainer {
            dataModel.generatedEvent?.compose(platform)
        }
        Row(
            modifier = Modifier.align(Alignment.CenterHorizontally),
        ) {
            Button(
                onClick = dataModel::generateThreat,
                modifier = Modifier,
            ) {
                Text("Generate a threat")
            }
            Button(
                onClick = dataModel::clearThreat,
                modifier = Modifier,
            ) {
                Text("Clear threat")
            }
        }
        SelectionContainer {
            dataModel.generatedThreat?.compose(platform)
        }
        Row(
            modifier = Modifier.align(Alignment.CenterHorizontally),
        ) {
            Button(
                onClick = dataModel::generateUsefulItem,
                modifier = Modifier,
            ) {
                Text("Generate a useful item")
            }
            Button(
                onClick = dataModel::clearUsefulItem,
                modifier = Modifier,
            ) {
                Text("Clear useful item")
            }
        }
        SelectionContainer {
            dataModel.generatedUsefulItem?.compose(platform)
        }
        Row(
            modifier = Modifier.align(Alignment.CenterHorizontally),
        ) {
            Button(
                onClick = dataModel::generateShip,
                modifier = Modifier,
            ) {
                Text("Generate a ship")
            }
            Button(
                onClick = dataModel::clearShip,
                modifier = Modifier,
            ) {
                Text("Clear ship")
            }
        }
        SelectionContainer {
            dataModel.generatedShip?.compose(platform)
        }
        Row(
            modifier = Modifier.align(Alignment.CenterHorizontally),
        ) {
            Button(
                onClick = dataModel::generatePlayer,
                modifier = Modifier,
            ) {
                Text("Generate a player")
            }
            Button(
                onClick = dataModel::clearPlayer,
                modifier = Modifier,
            ) {
                Text("Clear player")
            }
        }
        SelectionContainer {
            dataModel.generatedPlayer?.compose(platform)
        }
        Row(
            modifier = Modifier.align(Alignment.CenterHorizontally),
        ) {
            Button(
                onClick = dataModel::generateFlavorText,
                modifier = Modifier,
            ) {
                Text("Generate flavor text")
            }
            Button(
                onClick = dataModel::clearFlavorText,
                modifier = Modifier,
            ) {
                Text("Clear flavor text")
            }
        }
        SelectionContainer {
            dataModel.generatedFlavorText?.compose(platform)
        }
        Row(
            modifier = Modifier.align(Alignment.CenterHorizontally),
        ) {
            Button(
                onClick = dataModel::generateLocationName,
                modifier = Modifier,
            ) {
                Text("Generate location name")
            }
            Button(
                onClick = dataModel::clearLocationName,
                modifier = Modifier,
            ) {
                Text("Clear location name")
            }
        }
        SelectionContainer {
            dataModel.generatedLocationName?.also { Text(text = it) }
        }
        Row(
            modifier = Modifier.align(Alignment.CenterHorizontally),
        ) {
            Button(
                onClick = dataModel::generateNpc,
                modifier = Modifier,
            ) {
                Text("Generate npc")
            }
            Button(
                onClick = dataModel::clearNpc,
                modifier = Modifier,
            ) {
                Text("Clear npc")
            }
        }
        SelectionContainer {
            dataModel.generatedNpc?.also { Text(text = it) }
        }
    }
}
