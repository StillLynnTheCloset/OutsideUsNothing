package com.stilllynnthecloset.outsideusnothing.organizer

import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import com.stilllynnthecloset.liboun.generateWeightedList
import com.stilllynnthecloset.liboun.playbook.portWeightings
import com.stilllynnthecloset.liboun.rollDie
import com.stilllynnthecloset.outsideusnothing.Platform

/**
 * OrganizerScreen - TODO: Documentation
 *
 * Created by Lynn on 4/14/23
 */

private var resultText by mutableStateOf<String>("")

@Composable
internal fun OrganizerScreen(dataModel: OrganizerDataModel, platform: Platform) {
    Button(
        onClick = {
            val port = portWeightings.generateWeightedList().random().randomize()
            val builder = StringBuilder()
            builder.appendLine(port.specification.name)
            builder.appendLine(port.specification.description)
            port.customizations.forEach { playSheetChoice ->
                builder.appendLine("    ${playSheetChoice.specification.question}:")
                if (playSheetChoice.positiveSelections.isNotEmpty()) {
                    builder.appendLine("        ${playSheetChoice.positiveSelections}")
                }
                if (playSheetChoice.negativeSelections.isNotEmpty()) {
                    builder.appendLine("        But not: ${playSheetChoice.negativeSelections}")
                }
            }
            builder.appendLine("    Available Contracts:")
            port.contracts.forEach {
                builder.appendLine("        ${it.contractSpecification.description}")
                builder.appendLine("            ${it.fuelReward} fuel")
                builder.appendLine("            ${it.suppliesReward} supplies")
                if (it.itemReward) {
                    builder.appendLine("            And an item")
                }
            }
            val connections = rollDie(6)
            builder.append("It has $connections connected points with distances:")
            repeat(connections) {
                builder.append(" ${rollDie(6)},")
            }

            builder.appendLine()
            resultText = builder.toString()
        }
    ) {
        Text("Click me")
    }
    Text(
        text = resultText,
    )
}