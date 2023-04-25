package com.stilllynnthecloset.outsideusnothing.organizer

import androidx.compose.foundation.Image
import androidx.compose.foundation.gestures.Orientation
import androidx.compose.foundation.gestures.scrollable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Button
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.alpha
import androidx.compose.ui.graphics.ColorFilter
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.stilllynnthecloset.liboun.generateWeightedList
import com.stilllynnthecloset.liboun.model.Contract
import com.stilllynnthecloset.liboun.model.PlaySheetChoice
import com.stilllynnthecloset.liboun.model.PortOfCall
import com.stilllynnthecloset.liboun.playbook.portWeightings
import com.stilllynnthecloset.liboun.rollDie
import com.stilllynnthecloset.outsideusnothing.Platform
import com.stilllynnthecloset.outsideusnothing.theme.ImageReference

/**
 * OrganizerScreen - TODO: Documentation
 *
 * Created by Lynn on 4/14/23
 */

@Composable
internal fun OrganizerScreen(dataModel: OrganizerDataModel, platform: Platform) {
    val scrollState = rememberScrollState()

    Column(
        modifier = Modifier
            .fillMaxSize()
            .verticalScroll(rememberScrollState())
            .padding(startPadding),
    ) {
        Button(
            onClick = {
                dataModel.generatePort()
            },
            modifier = Modifier.align(Alignment.CenterHorizontally),
        ) {
            Text("Click me to generate a port of call")
        }

        val res = dataModel.generatedPort
        if (res != null) {
            displayPortOfCall(res, platform)
        }
    }
}

private val startPadding = 32.dp

@Composable
internal fun displayPortOfCall(port: PortOfCall, platform: Platform) {
    Column {
        Text(
            text = port.specification.name,
            fontSize = 32.sp,
        )
        Text(
            text = port.specification.description,
            fontSize = 12.sp,
            modifier = Modifier.padding(start = startPadding),
        )
        Spacer(
            modifier = Modifier.height(startPadding),
        )
        port.customizations.forEach { customization(it, platform) }
        Spacer(
            modifier = Modifier.height(startPadding),
        )
        Text(
            text ="Available Contracts:",
        )
        port.contracts.forEach { contract(it, platform) }
        Spacer(
            modifier = Modifier.height(startPadding),
        )
        Text(
            text = "Distances to neighboring ports are: ${port.connectionDistances.joinToString()}",
        )
    }
}

@Composable
internal fun customization(customization: PlaySheetChoice, platform: Platform) {
    Column (
        modifier = Modifier
            .padding(top = 8.dp),
    )  {
        Text("${customization.specification.question}:")
        if (customization.positiveSelections.isNotEmpty()) {
            Text(
                text = customization.positiveSelections.joinToString(),
                modifier = Modifier.padding(start = startPadding),
            )
        }
        if (customization.negativeSelections.isNotEmpty()) {
            Text(
                text = "But not: ${customization.negativeSelections.joinToString()}",
                modifier = Modifier.padding(start = startPadding),
            )
        }
    }
}

@Composable
internal fun contract(contract: Contract, platform: Platform) {
    Row(
        modifier = Modifier
            .padding(top = 8.dp),
    ) {
        Image(
            painter = platform.imagePainter.getPainter(ImageReference.Food),
            colorFilter = ColorFilter.tint(MaterialTheme.colorScheme.onSurface),
            contentDescription = "Supplies",
            modifier = Modifier
                .width(24.dp)
                .align(Alignment.CenterVertically),
        )
        Text(
            text = contract.suppliesReward.toString(),
            modifier = Modifier
                .width(32.dp)
                .align(Alignment.CenterVertically),
        )

        Image(
            painter = platform.imagePainter.getPainter(ImageReference.Gas),
            colorFilter = ColorFilter.tint(MaterialTheme.colorScheme.onSurface),
            contentDescription = "Fuel",
            modifier = Modifier
                .width(24.dp)
                .align(Alignment.CenterVertically),
        )
        Text(
            text = contract.fuelReward.toString(),
            modifier = Modifier
                .width(32.dp)
                .align(Alignment.CenterVertically),
        )

            Image(
                painter = platform.imagePainter.getPainter(ImageReference.Swords),
                colorFilter = ColorFilter.tint(MaterialTheme.colorScheme.onSurface),
                contentDescription = "Fuel",
                modifier = Modifier
                    .width(24.dp)
                    .alpha(if (contract.itemReward) 1.0F else 0.0F)
                    .align(Alignment.CenterVertically),
            )
        Spacer(
            modifier = Modifier.width(startPadding),
        )
        Text(
            text = contract.contractSpecification.description,
            modifier = Modifier
                .align(Alignment.CenterVertically),
        )
    }
}
