package com.stilllynnthecloset.outsideusnothing

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.IntrinsicSize
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.material3.TooltipBox
import androidx.compose.material3.TooltipDefaults
import androidx.compose.material3.rememberTooltipState
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.alpha
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.ColorFilter
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.stilllynnthecloset.outsideusnothing.library.model.Action
import com.stilllynnthecloset.outsideusnothing.library.model.AnsweredQuestion
import com.stilllynnthecloset.outsideusnothing.library.model.Bastard
import com.stilllynnthecloset.outsideusnothing.library.model.Choice
import com.stilllynnthecloset.outsideusnothing.library.model.ChoiceSpecification
import com.stilllynnthecloset.outsideusnothing.library.model.Consequence
import com.stilllynnthecloset.outsideusnothing.library.model.ConsequenceSpecification
import com.stilllynnthecloset.outsideusnothing.library.model.Contract
import com.stilllynnthecloset.outsideusnothing.library.model.ContractDestination
import com.stilllynnthecloset.outsideusnothing.library.model.ContractDetail
import com.stilllynnthecloset.outsideusnothing.library.model.ContractItem
import com.stilllynnthecloset.outsideusnothing.library.model.ContractQuality
import com.stilllynnthecloset.outsideusnothing.library.model.ContractSpecification
import com.stilllynnthecloset.outsideusnothing.library.model.Event
import com.stilllynnthecloset.outsideusnothing.library.model.EventSpecification
import com.stilllynnthecloset.outsideusnothing.library.model.FlavorText
import com.stilllynnthecloset.outsideusnothing.library.model.Option
import com.stilllynnthecloset.outsideusnothing.library.model.PlaySheet
import com.stilllynnthecloset.outsideusnothing.library.model.PlaySheetSpecification
import com.stilllynnthecloset.outsideusnothing.library.model.Playbook
import com.stilllynnthecloset.outsideusnothing.library.model.Player
import com.stilllynnthecloset.outsideusnothing.library.model.PortOfCall
import com.stilllynnthecloset.outsideusnothing.library.model.PortOfCallSpecification
import com.stilllynnthecloset.outsideusnothing.library.model.Question
import com.stilllynnthecloset.outsideusnothing.library.model.Ship
import com.stilllynnthecloset.outsideusnothing.library.model.Threat
import com.stilllynnthecloset.outsideusnothing.library.model.UsefulItem
import com.stilllynnthecloset.outsideusnothing.library.tools.calculateDiceOdds
import com.stilllynnthecloset.outsideusnothing.library.tools.getMaximumRollSum
import com.stilllynnthecloset.outsideusnothing.library.tools.getMinimumRollSum
import com.stilllynnthecloset.outsideusnothing.library.tools.toString
import com.stilllynnthecloset.outsideusnothing.theme.Colors.negative
import com.stilllynnthecloset.outsideusnothing.theme.Colors.neutral
import com.stilllynnthecloset.outsideusnothing.theme.Colors.positive
import org.jetbrains.compose.resources.painterResource
import outsideusnothing.appcompose.generated.resources.Res
import outsideusnothing.appcompose.generated.resources.ic_add
import outsideusnothing.appcompose.generated.resources.ic_food
import outsideusnothing.appcompose.generated.resources.ic_fuel
import outsideusnothing.appcompose.generated.resources.ic_radio_button_unchecked
import outsideusnothing.appcompose.generated.resources.ic_remove
import outsideusnothing.appcompose.generated.resources.ic_swords
import kotlin.math.absoluteValue

internal val indentPadding: Dp = 32.dp
internal val separatorPadding: Dp = 16.dp
internal val betweenItemPadding: Dp = 4.dp
internal val tooltipPadding: Dp = 4.dp

@Composable
internal fun PortOfCallSpecification.compose(modifier: Modifier = Modifier) {
    Column(
        modifier = modifier
            .padding(vertical = betweenItemPadding),
    ) {
        Text(
            text = name.replace(Regex("\\s"), " "),
            fontSize = 32.sp,
        )
        Text(
            text = description,
            fontSize = 12.sp,
            modifier = Modifier.padding(start = indentPadding),
        )
        Spacer(
            modifier = Modifier.height(separatorPadding),
        )
        choices.forEach { it.compose() }
        Spacer(
            modifier = Modifier.height(separatorPadding),
        )
        Text(
            text = "Available Contracts:",
        )
        contracts
            .filterNot { it == ContractSpecification.generatedContract }
            .sortedBy { it.quality }
            .forEach {
                it.compose(Modifier.padding(start = indentPadding))
            }
    }
}

@Composable
internal fun PortOfCall.compose(modifier: Modifier = Modifier) {
    Column(
        modifier = modifier
            .padding(vertical = betweenItemPadding),
    ) {
        Text(
            text = specification.name.replace(Regex("\\s"), " "),
            fontSize = 32.sp,
        )
        Text(
            text = specification.description,
            fontSize = 12.sp,
            modifier = Modifier.padding(start = indentPadding),
        )
        Spacer(
            modifier = Modifier.height(separatorPadding),
        )
        choices.forEach { it.compose() }
        Spacer(
            modifier = Modifier.height(separatorPadding),
        )
        if (contracts.isNotEmpty()) {
            Text(
                text = "Available Contracts:",
            )
            contracts.forEach { it.compose() }
        }
    }
}

@Composable
internal fun ChoiceSpecification.compose(modifier: Modifier = Modifier) {
    Column(
        modifier = modifier
            .padding(vertical = betweenItemPadding),
    ) {
        questions.forEach { it.compose() }
        options.forEach { it.compose(Modifier.padding(start = indentPadding)) }
    }
}

@Composable
internal fun Choice.compose(modifier: Modifier = Modifier) {
    Column(
        modifier = modifier
            .padding(vertical = betweenItemPadding),
    ) {
        answeredQuestions.forEach { it.compose() }
    }
}

@Composable
internal fun Question.compose(modifier: Modifier = Modifier) {
    Column(
        modifier = modifier
            .padding(vertical = betweenItemPadding),
    ) {
        Text(
            text = question,
        )
    }
}

@Composable
internal fun AnsweredQuestion.compose(modifier: Modifier = Modifier) {
    Column(
        modifier = modifier
            .padding(vertical = betweenItemPadding),
    ) {
        Text(
            text = question.question,
        )
        answers.forEach {
            it.compose(
                modifier = Modifier.padding(start = indentPadding),
            )
        }
    }
}

@Composable
internal fun ContractSpecification.compose(modifier: Modifier = Modifier) {
    Row(
        modifier = modifier
            .padding(vertical = betweenItemPadding),
    ) {
        quality.compose(
            modifier = Modifier
                .align(Alignment.CenterVertically)
                .width(128.dp),
        )

        Text(
            text = description,
            modifier = Modifier
                .align(Alignment.CenterVertically),
        )
    }
}

@Composable
@OptIn(ExperimentalMaterial3Api::class)
internal fun ContractQuality.compose(modifier: Modifier = Modifier) {
    TooltipBox(
        positionProvider = TooltipDefaults.rememberRichTooltipPositionProvider(),
        state = rememberTooltipState(),
        tooltip = {
            Column(
                modifier = Modifier
                    .background(MaterialTheme.colorScheme.surfaceVariant)
                    .padding(tooltipPadding)
                    .width(IntrinsicSize.Max)
            ) {
                Row(
                    modifier = Modifier
                        .fillMaxWidth(),
                ) {
                    Text(
                        text = "(${getMinimumRollSum(suppliesDice)} - ${getMaximumRollSum(suppliesDice)})",
                        modifier = Modifier
                            .align(Alignment.CenterVertically),
                    )
                    Spacer(
                        modifier = Modifier
                            .weight(1f),
                    )
                    Image(
                        painter = painterResource(Res.drawable.ic_food),
                        colorFilter = ColorFilter.tint(MaterialTheme.colorScheme.onSurface),
                        contentDescription = "Supplies",
                        modifier = Modifier
                            .width(24.dp)
                            .align(Alignment.CenterVertically),
                    )
                }
                Row(
                    modifier = Modifier
                        .fillMaxWidth(),
                ) {
                    Text(
                        text = "(${getMinimumRollSum(fuelDice)} - ${getMaximumRollSum(fuelDice)})",
                        modifier = Modifier
                            .align(Alignment.CenterVertically),
                    )
                    Spacer(
                        modifier = Modifier
                            .weight(1f),
                    )
                    Image(
                        painter = painterResource(Res.drawable.ic_fuel),
                        colorFilter = ColorFilter.tint(MaterialTheme.colorScheme.onSurface),
                        contentDescription = "Fuel",
                        modifier = Modifier
                            .width(24.dp)
                            .align(Alignment.CenterVertically),
                    )
                }
                Row(
                    modifier = Modifier
                        .fillMaxWidth(),
                ) {
                    Text(
                        text = (calculateDiceOdds(2, itemDifficultly, 2) * 100).toString(1) + "%",
                        modifier = Modifier
                            .align(Alignment.CenterVertically),
                    )
                    Spacer(
                        modifier = Modifier
                            .weight(1f),
                    )
                    Image(
                        painter = painterResource(Res.drawable.ic_swords),
                        colorFilter = ColorFilter.tint(MaterialTheme.colorScheme.onSurface),
                        contentDescription = "Item",
                        modifier = Modifier
                            .width(24.dp)
                            .align(Alignment.CenterVertically),
                    )
                }
            }
        },
        modifier = modifier,
        content = {
            Row {
                Text(
                    text = humanReadable,
                    color = when (this@compose) {
                        ContractQuality.VERY_SUBPAR -> Color(0xFFFF0000)
                        ContractQuality.SUBPAR -> Color(0xFFea9999)
                        ContractQuality.AVERAGE -> Color(0xFFFFFFFF)
                        ContractQuality.GOOD -> Color(0xFFb6d7a8)
                        ContractQuality.EXCELLENT -> Color(0xFF00ff00)
                    },
                    modifier = Modifier
                        .align(Alignment.CenterVertically),
                )
            }
        }
    )
}

@Composable
internal fun EventSpecification.compose(modifier: Modifier = Modifier) {
    Column(
        modifier = modifier
            .padding(vertical = betweenItemPadding),
    ) {
        Text(
            text = name,
            fontSize = 32.sp,
        )
        Text(
            text = description,
            fontSize = 12.sp,
            modifier = Modifier.padding(start = indentPadding),
        )
        if (choices.isNotEmpty()) {
            Spacer(
                modifier = Modifier.height(separatorPadding),
            )
            choices.forEach { it.compose() }
        }
        if (consequences.isNotEmpty()) {
            Spacer(
                modifier = Modifier.height(separatorPadding),
            )
            Text(
                text = "Consequences:",
            )
            consequences.forEach {
                it.compose(Modifier.padding(start = indentPadding))
            }
        }
    }
}

@Composable
internal fun Event.compose(modifier: Modifier = Modifier) {
    Column(
        modifier = modifier
            .padding(vertical = betweenItemPadding),
    ) {
        Text(
            text = specification.name,
            fontSize = 32.sp,
        )
        Text(
            text = specification.description,
            fontSize = 12.sp,
            modifier = Modifier.padding(start = indentPadding),
        )
        if (choices.isNotEmpty()) {
            Spacer(
                modifier = Modifier.height(separatorPadding),
            )
            choices.forEach { it.compose() }
        }
        if (consequences.isNotEmpty()) {
            Spacer(
                modifier = Modifier.height(separatorPadding),
            )
            Text(
                text = "Consequences:",
            )
            consequences.forEach {
                it.compose(Modifier.padding(start = indentPadding))
            }
        }
    }
}

@Composable
internal fun PlaySheetSpecification.compose(modifier: Modifier = Modifier) {
    Column(
        modifier = modifier
            .padding(vertical = betweenItemPadding),
    ) {
        Text(
            text = name,
            fontSize = 32.sp,
        )
        flavorText.compose(Modifier.padding(start = indentPadding))
        Text(
            text = description,
            fontSize = 12.sp,
            modifier = Modifier.padding(start = indentPadding),
        )
        if (choices.isNotEmpty()) {
            Spacer(
                modifier = Modifier.height(separatorPadding),
            )
            choices.forEach { it.compose(Modifier.padding(start = indentPadding)) }
        }

        if (actions.isNotEmpty()) {
            Text(
                text = "Actions:",
                Modifier.padding(top = separatorPadding, start = indentPadding),
            )
            actions.forEach { it.compose(Modifier.padding(start = indentPadding * 2)) }
        }
    }
}

@Composable
internal fun PlaySheet.compose(showActions: Boolean, modifier: Modifier = Modifier) {
    Column(
        modifier = modifier
            .padding(vertical = betweenItemPadding),
    ) {
        Text(
            text = specification.name,
            fontSize = 32.sp,
        )
        specification.flavorText.compose(Modifier.padding(start = indentPadding))
        Text(
            text = specification.description,
            fontSize = 12.sp,
            modifier = Modifier.padding(start = indentPadding),
        )
        if (choices.isNotEmpty()) {
            Spacer(
                modifier = Modifier.height(separatorPadding),
            )
            choices.forEach { it.compose() }
        }

        if (specification.actions.isNotEmpty() && showActions) {
            Text(
                text = "Actions:",
                Modifier.padding(top = separatorPadding),
            )
            specification.actions.forEach { it.compose(Modifier.padding(start = indentPadding)) }
        }
    }
}

@Composable
internal fun Ship.compose(modifier: Modifier = Modifier) {
    Column(
        modifier = modifier
            .padding(vertical = betweenItemPadding),
    ) {
        Text(
            text = name,
            fontSize = 32.sp,
        )
        Text(
            text = "Fuel: $fuel",
            fontSize = 12.sp,
            modifier = Modifier.padding(start = indentPadding),
        )
        Text(
            text = "Supplies: $supplies",
            fontSize = 12.sp,
            modifier = Modifier.padding(start = indentPadding),
        )
        Text(
            text = "Health Condition: $condition",
            fontSize = 12.sp,
            modifier = Modifier.padding(start = indentPadding),
        )
        if (playSheet.choices.isNotEmpty()) {
            Spacer(
                modifier = Modifier.height(separatorPadding),
            )
            playSheet.choices.forEach { it.compose() }
        }
    }
}

@Composable
internal fun FlavorText.compose(modifier: Modifier = Modifier) {
    Column(
        modifier = modifier
            .padding(vertical = betweenItemPadding),
    ) {
        Text(
            text = "\"$text\"",
            fontSize = 12.sp,
            style = TextStyle(fontStyle = FontStyle.Italic),
        )
        Text(
            text = "- $attribution",
            fontSize = 12.sp,
            modifier = Modifier.padding(start = indentPadding),
        )
    }
}

@Composable
internal fun Option.compose(modifier: Modifier = Modifier) {
    Row(
        modifier = modifier
            .padding(vertical = betweenItemPadding),
    ) {
        Image(
            painter = painterResource(Res.drawable.ic_radio_button_unchecked),
            colorFilter = ColorFilter.tint(MaterialTheme.colorScheme.onSurface),
            contentDescription = "Radio Button",
            modifier = Modifier
                .padding(end = indentPadding)
                .width(16.dp)
                .align(Alignment.CenterVertically),
        )
        Text(
            text = text,
            modifier = Modifier
                .align(Alignment.CenterVertically),
        )
    }
}

@Composable
internal fun Contract.compose(modifier: Modifier = Modifier) {
    Row(
        modifier = modifier
            .padding(vertical = betweenItemPadding),
    ) {
        Image(
            painter = painterResource(Res.drawable.ic_food),
            colorFilter = ColorFilter.tint(MaterialTheme.colorScheme.onSurface),
            contentDescription = "Supplies",
            modifier = Modifier
                .width(24.dp)
                .align(Alignment.CenterVertically),
        )
        Text(
            text = suppliesReward.toString(),
            modifier = Modifier
                .width(32.dp)
                .align(Alignment.CenterVertically),
        )

        Image(
            painter = painterResource(Res.drawable.ic_fuel),
            colorFilter = ColorFilter.tint(MaterialTheme.colorScheme.onSurface),
            contentDescription = "Fuel",
            modifier = Modifier
                .width(24.dp)
                .align(Alignment.CenterVertically),
        )
        Text(
            text = fuelReward.toString(),
            modifier = Modifier
                .width(32.dp)
                .align(Alignment.CenterVertically),
        )

        Image(
            painter = painterResource(Res.drawable.ic_swords),
            colorFilter = ColorFilter.tint(MaterialTheme.colorScheme.onSurface),
            contentDescription = "Item",
            modifier = Modifier
                .width(24.dp)
                .alpha(if (itemReward) 1.0F else 0.0F)
                .align(Alignment.CenterVertically),
        )
        Spacer(
            modifier = Modifier.width(separatorPadding),
        )
        Text(
            text = contractSpecification.description,
            modifier = Modifier
                .align(Alignment.CenterVertically),
        )
    }
}

@Composable
internal fun Bastard.compose(modifier: Modifier = Modifier) {
    Column(
        modifier = modifier
            .padding(vertical = betweenItemPadding),
    ) {
        Text(
            text = name,
            fontSize = 32.sp,
        )
        Text(
            text = description,
            fontSize = 12.sp,
            modifier = Modifier.padding(start = indentPadding),
        )
    }
}

@Composable
internal fun ContractItem.compose(modifier: Modifier = Modifier) {
    Row(
        modifier = modifier
            .padding(vertical = betweenItemPadding),
    ) {
        Text(
            text = name,
            modifier = Modifier
                .align(Alignment.CenterVertically),
        )
    }
}

@Composable
internal fun ContractDestination.compose(modifier: Modifier = Modifier) {
    Row(
        modifier = modifier
            .padding(vertical = betweenItemPadding),
    ) {
        Text(
            text = name,
            modifier = Modifier
                .align(Alignment.CenterVertically),
        )
    }
}

@Composable
internal fun ContractDetail.compose(modifier: Modifier = Modifier) {
    Row(
        modifier = modifier
            .padding(vertical = betweenItemPadding),
    ) {
        Text(
            text = "Deliver ${item.name} ${destination.name}",
            modifier = Modifier
                .align(Alignment.CenterVertically),
        )
    }
}

@Composable
internal fun Threat.compose(modifier: Modifier = Modifier) {
    Row(
        modifier = modifier
            .padding(vertical = betweenItemPadding),
    ) {
        Text(
            text = name,
            modifier = Modifier
                .align(Alignment.CenterVertically),
        )
    }
}

@Composable
internal fun Consequence.compose(modifier: Modifier = Modifier) {
    Row(
        modifier = modifier
            .padding(vertical = betweenItemPadding),
    ) {
        Text(
            text = specification.name,
            modifier = Modifier
                .align(Alignment.CenterVertically),
        )
    }
}

@Composable
internal fun ConsequenceSpecification.compose(modifier: Modifier = Modifier) {
    Row(
        modifier = modifier
            .padding(vertical = betweenItemPadding),
    ) {
        Text(
            text = name,
            modifier = Modifier
                .align(Alignment.CenterVertically),
        )
    }
}

@Composable
internal fun UsefulItem.compose(modifier: Modifier = Modifier) {
    Column(
        modifier = modifier
            .padding(vertical = betweenItemPadding),
    ) {
        Text("$name:")
        action.compose(Modifier.padding(start = indentPadding))
    }
}

@Composable
internal fun Action.compose(modifier: Modifier = Modifier) {
    Row(
        modifier = modifier
            .padding(vertical = betweenItemPadding),
    ) {
        val prefix = if (diceOffset.absoluteValue >= 10) {
            ""
        } else {
            " "
        }
        if (diceOffset > 0) {
            Image(
                painter = painterResource(Res.drawable.ic_add),
                colorFilter = ColorFilter.tint(MaterialTheme.colorScheme.positive),
                contentDescription = "Positive",
                modifier = Modifier
                    .padding(end = indentPadding / 2)
                    .width(16.dp)
                    .align(Alignment.CenterVertically),
            )
            Text(
                text = "$prefix$diceOffset ",
                color = MaterialTheme.colorScheme.positive,
                modifier = Modifier
                    .align(Alignment.CenterVertically),
            )
        } else if (diceOffset < 0) {
            Image(
                painter = painterResource(Res.drawable.ic_remove),
                colorFilter = ColorFilter.tint(MaterialTheme.colorScheme.negative),
                contentDescription = "Negative",
                modifier = Modifier
                    .padding(end = indentPadding / 2)
                    .width(16.dp)
                    .align(Alignment.CenterVertically),
            )
            Text(
                text = "$prefix${diceOffset.absoluteValue} ",
                color = MaterialTheme.colorScheme.negative,
                modifier = Modifier
                    .align(Alignment.CenterVertically),
            )
        } else {
            Image(
                painter = painterResource(Res.drawable.ic_radio_button_unchecked),
                colorFilter = ColorFilter.tint(MaterialTheme.colorScheme.neutral),
                contentDescription = "Radio Button",
                modifier = Modifier
                    .padding(end = indentPadding / 2)
                    .width(16.dp)
                    .align(Alignment.CenterVertically),
            )
            Text(
                text = "   ",
                color = MaterialTheme.colorScheme.negative,
                modifier = Modifier
                    .align(Alignment.CenterVertically),
            )
        }
        Text(
            text = description,
            modifier = Modifier
                .align(Alignment.CenterVertically),
        )
    }
}

@Composable
internal fun Player.compose(modifier: Modifier = Modifier) {
    Column(
        modifier = modifier
            .padding(vertical = betweenItemPadding),
    ) {
        Text(
            text = "Name: $name",
        )

        Text(
            text = "Dice: $dicePool",
        )

        Text(
            text = "Condition: $condition",
        )

        Text(
            text = "Playsheets:",
        )
        playSheets.forEach { it.compose(
            showActions = false,
            modifier = Modifier.padding(start = indentPadding)
        ) }

        Text(
            text = "Actions:",
        )
        actions.forEach { it.compose(modifier = Modifier.padding(start = indentPadding)) }

        if (items.isNotEmpty()) {
            Text(
                text = "Items:",
            )
            items.forEach { it.compose(modifier = Modifier.padding(start = indentPadding)) }
        }
    }
}

@Composable
internal fun Playbook.compose(listContents: Boolean, modifier: Modifier = Modifier) {
    Column(
        modifier = modifier
            .padding(vertical = betweenItemPadding),
    ) {
        Text(
            text = name,
            fontSize = 32.sp,
        )

        Text(
            text = "By: ${authors.joinToString { it.name }}",
            fontSize = 24.sp,
        )

        Text(
            text = description,
            fontSize = 16.sp,
        )

        if (listContents) {
            Text(
                text = "This playbook contains",
                fontSize = 12.sp,
                modifier = Modifier.padding(start = indentPadding),
            )
            var wasAnythingShown = false

            if (aliens.isNotEmpty()) {
                Text(
                    text = "${aliens.size}: Alien playsheets",
                    fontSize = 12.sp,
                    modifier = Modifier.padding(start = indentPadding * 2),
                )
                wasAnythingShown = true
            }

            if (backgrounds.isNotEmpty()) {
                Text(
                    text = "${backgrounds.size}: Background playsheets",
                    fontSize = 12.sp,
                    modifier = Modifier.padding(start = indentPadding * 2),
                )
                wasAnythingShown = true
            }

            if (roles.isNotEmpty()) {
                Text(
                    text = "${roles.size}: Role playsheets",
                    fontSize = 12.sp,
                    modifier = Modifier.padding(start = indentPadding * 2),
                )
                wasAnythingShown = true
            }

            if (bastards.isNotEmpty()) {
                Text(
                    text = "${bastards.size}: Bastards",
                    fontSize = 12.sp,
                    modifier = Modifier.padding(start = indentPadding * 2),
                )
                wasAnythingShown = true
            }

            if (events.isNotEmpty()) {
                Text(
                    text = "${events.size}: Events",
                    fontSize = 12.sp,
                    modifier = Modifier.padding(start = indentPadding * 2),
                )
                wasAnythingShown = true
            }

            if (ports.isNotEmpty()) {
                Text(
                    text = "${ports.size}: Ports",
                    fontSize = 12.sp,
                    modifier = Modifier.padding(start = indentPadding * 2),
                )
                wasAnythingShown = true
            }

            if (threats.isNotEmpty()) {
                Text(
                    text = "${threats.size}: Threats",
                    fontSize = 12.sp,
                    modifier = Modifier.padding(start = indentPadding * 2),
                )
                wasAnythingShown = true
            }

            if (usefulItems.isNotEmpty()) {
                Text(
                    text = "${usefulItems.size}: Useful items",
                    fontSize = 12.sp,
                    modifier = Modifier.padding(start = indentPadding * 2),
                )
                wasAnythingShown = true
            }

            if (npcAdjectives.isNotEmpty()) {
                Text(
                    text = "${npcAdjectives.size}: NPC adjectives",
                    fontSize = 12.sp,
                    modifier = Modifier.padding(start = indentPadding * 2),
                )
                wasAnythingShown = true
            }

            if (npcNouns.isNotEmpty()) {
                Text(
                    text = "${npcNouns.size}: NPC types",
                    fontSize = 12.sp,
                    modifier = Modifier.padding(start = indentPadding * 2),
                )
                wasAnythingShown = true
            }

            if (portAdjectives.isNotEmpty()) {
                Text(
                    text = "${portAdjectives.size}: Port adjectives",
                    fontSize = 12.sp,
                    modifier = Modifier.padding(start = indentPadding * 2),
                )
                wasAnythingShown = true
            }

            if (portNouns.isNotEmpty()) {
                Text(
                    text = "${portNouns.size}: Port names",
                    fontSize = 12.sp,
                    modifier = Modifier.padding(start = indentPadding * 2),
                )
                wasAnythingShown = true
            }

            if (contractItems.isNotEmpty()) {
                Text(
                    text = "${contractItems.size}: Contract items",
                    fontSize = 12.sp,
                    modifier = Modifier.padding(start = indentPadding * 2),
                )
                wasAnythingShown = true
            }

            if (contractDestinations.isNotEmpty()) {
                Text(
                    text = "${contractDestinations.size}: Contract destinations",
                    fontSize = 12.sp,
                    modifier = Modifier.padding(start = indentPadding * 2),
                )
                wasAnythingShown = true
            }

            if (flavorTexts.isNotEmpty()) {
                Text(
                    text = "${flavorTexts.size}: Flavor texts",
                    fontSize = 12.sp,
                    modifier = Modifier.padding(start = indentPadding * 2),
                )
                wasAnythingShown = true
            }

            if (!wasAnythingShown) {
                Text(
                    text = "NOTHING!",
                    fontSize = 12.sp,
                    modifier = Modifier.padding(start = indentPadding * 2),
                )
            }
        }
    }
}
