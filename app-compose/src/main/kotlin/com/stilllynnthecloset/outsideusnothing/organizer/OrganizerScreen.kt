package com.stilllynnthecloset.outsideusnothing.organizer

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import com.stilllynnthecloset.outsideusnothing.Platform
import com.stilllynnthecloset.outsideusnothing.compose
import com.stilllynnthecloset.outsideusnothing.indentPadding

/**
 * OrganizerScreen - TODO: Documentation
 *
 * Created by Lynn on 4/14/23
 */

@Composable
internal fun OrganizerScreen(dataModel: OrganizerDataModel, platform: Platform) {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .verticalScroll(rememberScrollState())
            .padding(indentPadding),
    ) {
        Row(
            modifier = Modifier.align(Alignment.CenterHorizontally)
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

        dataModel.generatedPort?.compose(platform)


        Row(
            modifier = Modifier.align(Alignment.CenterHorizontally)
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

        dataModel.generatedBastard?.compose(platform)



        Row(
            modifier = Modifier.align(Alignment.CenterHorizontally)
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

        dataModel.generatedContractItem?.compose(platform)



        Row(
            modifier = Modifier.align(Alignment.CenterHorizontally)
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

        dataModel.generatedEvent?.compose(platform)




        Row(
            modifier = Modifier.align(Alignment.CenterHorizontally)
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

        dataModel.generatedThreat?.compose(platform)




        Row(
            modifier = Modifier.align(Alignment.CenterHorizontally)
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

        dataModel.generatedUsefulItem?.compose(platform)


        Row(
            modifier = Modifier.align(Alignment.CenterHorizontally)
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

        dataModel.generatedShip?.compose(platform)


        Row(
            modifier = Modifier.align(Alignment.CenterHorizontally)
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

        dataModel.generatedPlayer?.compose(platform)

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

        dataModel.generatedFlavorText?.compose(platform)
    }
}
