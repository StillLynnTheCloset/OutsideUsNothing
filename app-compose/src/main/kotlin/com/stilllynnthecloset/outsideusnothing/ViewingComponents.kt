package com.stilllynnthecloset.outsideusnothing

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
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
import com.stilllynnthecloset.liboun.calculateDiceOdds
import com.stilllynnthecloset.liboun.model.Action
import com.stilllynnthecloset.liboun.model.AnsweredQuestion
import com.stilllynnthecloset.liboun.model.Bastard
import com.stilllynnthecloset.liboun.model.Choice
import com.stilllynnthecloset.liboun.model.ChoiceSpecification
import com.stilllynnthecloset.liboun.model.Consequence
import com.stilllynnthecloset.liboun.model.Contract
import com.stilllynnthecloset.liboun.model.ContractDestination
import com.stilllynnthecloset.liboun.model.ContractDetail
import com.stilllynnthecloset.liboun.model.ContractItem
import com.stilllynnthecloset.liboun.model.ContractQuality
import com.stilllynnthecloset.liboun.model.ContractSpecification
import com.stilllynnthecloset.liboun.model.Event
import com.stilllynnthecloset.liboun.model.EventSpecification
import com.stilllynnthecloset.liboun.model.FlavorText
import com.stilllynnthecloset.liboun.model.Option
import com.stilllynnthecloset.liboun.model.PlaySheet
import com.stilllynnthecloset.liboun.model.PlaySheetSpecification
import com.stilllynnthecloset.liboun.model.Playbook
import com.stilllynnthecloset.liboun.model.Player
import com.stilllynnthecloset.liboun.model.PortOfCall
import com.stilllynnthecloset.liboun.model.PortOfCallSpecification
import com.stilllynnthecloset.liboun.model.Question
import com.stilllynnthecloset.liboun.model.Ship
import com.stilllynnthecloset.liboun.model.Threat
import com.stilllynnthecloset.liboun.model.UsefulItem
import com.stilllynnthecloset.outsideusnothing.theme.ImageReference

public val indentPadding: Dp = 32.dp
public val separatorPadding: Dp = 16.dp

@Composable
internal fun PortOfCallSpecification.compose(platform: Platform, modifier: Modifier = Modifier) {
    Column(
        modifier = modifier,
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
        Spacer(
            modifier = Modifier.height(separatorPadding),
        )
        choices.forEach { it.compose(platform) }
        Spacer(
            modifier = Modifier.height(separatorPadding),
        )
        Text(
            text = "Available Contracts:",
        )
        contracts.sortedBy { it.quality }.forEach { it.compose(platform, Modifier.padding(start = indentPadding)) }
    }
}

@Composable
internal fun PortOfCall.compose(platform: Platform, modifier: Modifier = Modifier) {
    Column(
        modifier = modifier,
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
        Spacer(
            modifier = Modifier.height(separatorPadding),
        )
        choices.forEach { it.compose(platform) }
        Spacer(
            modifier = Modifier.height(separatorPadding),
        )
        Text(
            text = "Available Contracts:",
        )
        contracts.forEach { it.compose(platform) }
    }
}

@Composable
internal fun ChoiceSpecification.compose(platform: Platform, modifier: Modifier = Modifier) {
    Column(
        modifier = modifier,
    ) {
        questions.forEach { it.compose(platform) }
        options.forEach { it.compose(platform, Modifier.padding(start = indentPadding)) }
    }
}

@Composable
internal fun Choice.compose(platform: Platform, modifier: Modifier = Modifier) {
    Column(
        modifier = modifier,
    ) {
        answeredQuestions.forEach { it.compose(platform) }
    }
}

@Composable
internal fun Question.compose(platform: Platform, modifier: Modifier = Modifier) {
    Column(
        modifier = modifier,
    ) {
        Text(
            text = question,
        )
    }
}

@Composable
internal fun AnsweredQuestion.compose(platform: Platform, modifier: Modifier = Modifier) {
    Column(
        modifier = modifier,
    ) {
        Text(
            text = question.question,
        )
        answers.forEach {
            it.compose(
                platform = platform,
                modifier = Modifier.padding(start = indentPadding),
            )
        }
    }
}

@Composable
internal fun ContractSpecification.compose(platform: Platform, modifier: Modifier = Modifier) {
    Row(
        modifier = modifier,
    ) {
        Text(
            text = quality.toString(),
            color = when (quality) {
                ContractQuality.VERY_SUBPAR -> Color(0xFFFF0000)
                ContractQuality.SUBPAR -> Color(0xFFea9999)
                ContractQuality.AVERAGE -> Color(0xFFFFFFFF)
                ContractQuality.GOOD -> Color(0xFFb6d7a8)
                ContractQuality.EXCELLENT -> Color(0xFF00ff00)
            },
            modifier = Modifier
                .align(Alignment.CenterVertically)
                .width(128.dp),
        )

        Text(
            text = "(",
            modifier = Modifier
                .align(Alignment.CenterVertically),
        )
        Image(
            painter = platform.imagePainter.getPainter(ImageReference.Food),
            colorFilter = ColorFilter.tint(MaterialTheme.colorScheme.onSurface),
            contentDescription = "Supplies",
            modifier = Modifier
                .width(24.dp)
                .align(Alignment.CenterVertically),
        )
        Image(
            painter = platform.imagePainter.getPainter(ImageReference.Dice5),
            colorFilter = ColorFilter.tint(MaterialTheme.colorScheme.onSurface),
            contentDescription = "Supplies Dice",
            modifier = Modifier
                .width(24.dp)
                .align(Alignment.CenterVertically),
        )
        Text(
            text = quality.suppliesDice.toString(),
            modifier = Modifier
                .width(32.dp)
                .align(Alignment.CenterVertically),
        )

        Image(
            painter = platform.imagePainter.getPainter(ImageReference.Fuel),
            colorFilter = ColorFilter.tint(MaterialTheme.colorScheme.onSurface),
            contentDescription = "Fuel",
            modifier = Modifier
                .width(24.dp)
                .align(Alignment.CenterVertically),
        )
        Image(
            painter = platform.imagePainter.getPainter(ImageReference.Dice5),
            colorFilter = ColorFilter.tint(MaterialTheme.colorScheme.onSurface),
            contentDescription = "Fuel Dice",
            modifier = Modifier
                .width(24.dp)
                .align(Alignment.CenterVertically),
        )
        Text(
            text = quality.fuelDice.toString(),
            modifier = Modifier
                .width(32.dp)
                .align(Alignment.CenterVertically),
        )

        Image(
            painter = platform.imagePainter.getPainter(ImageReference.Swords),
            colorFilter = ColorFilter.tint(MaterialTheme.colorScheme.onSurface),
            contentDescription = "Item",
            modifier = Modifier
                .width(24.dp)
                .align(Alignment.CenterVertically),
        )
        Image(
            painter = platform.imagePainter.getPainter(ImageReference.Dice5),
            colorFilter = ColorFilter.tint(MaterialTheme.colorScheme.onSurface),
            contentDescription = "Item Difficulty",
            modifier = Modifier
                .width(24.dp)
                .align(Alignment.CenterVertically),
        )
        Text(
            text = String.format("%.1f%%)", calculateDiceOdds(2, quality.itemDifficultly, 2) * 100),
            modifier = Modifier
                .width(96.dp)
                .align(Alignment.CenterVertically),
        )

        Text(
            text = description,
            modifier = Modifier
                .align(Alignment.CenterVertically),
        )
    }
}

@Composable
internal fun EventSpecification.compose(platform: Platform, modifier: Modifier = Modifier) {
    Column(
        modifier = modifier,
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
            choices.forEach { it.compose(platform) }
        }
        if (consequences.isNotEmpty()) {
            Spacer(
                modifier = Modifier.height(separatorPadding),
            )
            Text(
                text = "Consequences:",
            )
            consequences.forEach {
                it.compose(platform, Modifier.padding(start = indentPadding))
            }
        }
    }
}

@Composable
internal fun Event.compose(platform: Platform, modifier: Modifier = Modifier) {
    Column(
        modifier = modifier,
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
            choices.forEach { it.compose(platform) }
        }
        if (specification.consequences.isNotEmpty()) {
            Spacer(
                modifier = Modifier.height(separatorPadding),
            )
            Text(
                text = "Consequences:",
            )
            specification.consequences.forEach {
                it.compose(platform, Modifier.padding(start = indentPadding))
            }
        }
    }
}

@Composable
internal fun PlaySheetSpecification.compose(platform: Platform, modifier: Modifier = Modifier) {
    Column(
        modifier = modifier,
    ) {
        Text(
            text = name,
            fontSize = 32.sp,
        )
        flavorText?.compose(platform, Modifier.padding(start = indentPadding))
        Text(
            text = description,
            fontSize = 12.sp,
            modifier = Modifier.padding(start = indentPadding),
        )
        if (choices.isNotEmpty()) {
            Spacer(
                modifier = Modifier.height(separatorPadding),
            )
            choices.forEach { it.compose(platform, Modifier.padding(start = indentPadding)) }
        }

        if (actions.isNotEmpty()) {
            Text(
                text = "Actions:",
                Modifier.padding(top = separatorPadding, start = indentPadding),
            )
            actions.forEach { it.compose(platform, Modifier.padding(start = indentPadding * 2)) }
        }
    }
}

@Composable
internal fun PlaySheet.compose(platform: Platform, showActions: Boolean, modifier: Modifier = Modifier) {
    Column(
        modifier = modifier,
    ) {
        Text(
            text = specification.name,
            fontSize = 32.sp,
        )
        specification.flavorText?.compose(platform, Modifier.padding(start = indentPadding))
        Text(
            text = specification.description,
            fontSize = 12.sp,
            modifier = Modifier.padding(start = indentPadding),
        )
        if (choices.isNotEmpty()) {
            Spacer(
                modifier = Modifier.height(separatorPadding),
            )
            choices.forEach { it.compose(platform) }
        }

        if (specification.actions.isNotEmpty() && showActions) {
            Text(
                text = "Actions:",
                Modifier.padding(top = separatorPadding),
            )
            specification.actions.forEach { it.compose(platform, Modifier.padding(start = indentPadding)) }
        }
    }
}

@Composable
internal fun Ship.compose(platform: Platform, modifier: Modifier = Modifier) {
    Column(
        modifier = modifier,
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
            playSheet.choices.forEach { it.compose(platform) }
        }
    }
}

@Composable
internal fun FlavorText.compose(platform: Platform, modifier: Modifier = Modifier) {
    Column(
        modifier = modifier,
    ) {
        Text(
            text = text,
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
internal fun Option.compose(platform: Platform, modifier: Modifier = Modifier) {
    Row(
        modifier = modifier,
    ) {
        Image(
            painter = platform.imagePainter.getPainter(ImageReference.RadioButtonUnchecked),
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
internal fun Contract.compose(platform: Platform, modifier: Modifier = Modifier) {
    Row(
        modifier = modifier,
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
            text = suppliesReward.toString(),
            modifier = Modifier
                .width(32.dp)
                .align(Alignment.CenterVertically),
        )

        Image(
            painter = platform.imagePainter.getPainter(ImageReference.Fuel),
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
            painter = platform.imagePainter.getPainter(ImageReference.Swords),
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
internal fun Bastard.compose(platform: Platform, modifier: Modifier = Modifier) {
    Column(
        modifier = modifier,
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
internal fun ContractItem.compose(platform: Platform, modifier: Modifier = Modifier) {
    Row(
        modifier = modifier,
    ) {
        Text(
            text = name,
            modifier = Modifier
                .align(Alignment.CenterVertically),
        )
    }
}

@Composable
internal fun ContractDestination.compose(platform: Platform, modifier: Modifier = Modifier) {
    Row(
        modifier = modifier,
    ) {
        Text(
            text = name,
            modifier = Modifier
                .align(Alignment.CenterVertically),
        )
    }
}

@Composable
internal fun ContractDetail.compose(platform: Platform, modifier: Modifier = Modifier) {
    Row(
        modifier = modifier,
    ) {
        Text(
            text = "Deliver ${item.name} ${destination.name}",
            modifier = Modifier
                .align(Alignment.CenterVertically),
        )
    }
}

@Composable
internal fun Threat.compose(platform: Platform, modifier: Modifier = Modifier) {
    Row(
        modifier = modifier,
    ) {
        Text(
            text = name,
            modifier = Modifier
                .align(Alignment.CenterVertically),
        )
    }
}

@Composable
internal fun Consequence.compose(platform: Platform, modifier: Modifier = Modifier) {
    Row(
        modifier = modifier,
    ) {
        Text(
            text = name,
            modifier = Modifier
                .align(Alignment.CenterVertically),
        )
    }
}

@Composable
internal fun UsefulItem.compose(platform: Platform, modifier: Modifier = Modifier) {
    Column(
        modifier = modifier,
    ) {
        Text("$name:")
        action.compose(platform, Modifier.padding(start = indentPadding))
    }
}

@Composable
internal fun Action.compose(platform: Platform, modifier: Modifier = Modifier) {
    Row(
        modifier = modifier,
    ) {
        if (diceOffset > 0) {
            Text(
                text = "+$diceOffset ",
                color = Color.Green,
            )
        } else if (diceOffset < 0) {
            Text(
                text = "$diceOffset ",
                color = Color.Red,
            )
        } else {
            Text(
                text = " * ",
                color = Color.White,
            )
        }
        Text(description)
    }
}

@Composable
internal fun Player.compose(platform: Platform, modifier: Modifier = Modifier) {
    Column(
        modifier = modifier,
    ) {
        Text(
            text = "Dice: $dicePool",
        )
        Text(
            text = "Condition: $condition",
        )
        Text(
            text = "Playsheets:",
        )
        playSheets.forEach { it.compose(platform, showActions = false, modifier = Modifier.padding(start = indentPadding)) }
        Text(
            text = "Actions:",
        )
        actions.forEach { it.compose(platform, modifier = Modifier.padding(start = indentPadding)) }
    }
}

@Composable
internal fun Playbook.compose(platform: Platform, listContents: Boolean, modifier: Modifier = Modifier) {
    Column(
        modifier = modifier,
    ) {
        Text(
            text = name,
            fontSize = 32.sp,
        )

        Text(
            text ="By: ${authors.joinToString { it.name }}",
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

            if (npcTypes.isNotEmpty()) {
                Text(
                    text = "${npcTypes.size}: NPC types",
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

            if (portNames.isNotEmpty()) {
                Text(
                    text = "${portNames.size}: Port names",
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
