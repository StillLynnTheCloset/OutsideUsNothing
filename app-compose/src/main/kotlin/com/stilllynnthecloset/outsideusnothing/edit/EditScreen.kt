package com.stilllynnthecloset.outsideusnothing.edit

import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.ColumnScope
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.ColorFilter
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.stilllynnthecloset.liboun.model.Playbook
import com.stilllynnthecloset.liboun.model.Threat
import com.stilllynnthecloset.liboun.model.Weighted
import com.stilllynnthecloset.outsideusnothing.Platform
import com.stilllynnthecloset.outsideusnothing.PlaybookPage
import com.stilllynnthecloset.outsideusnothing.compose
import com.stilllynnthecloset.outsideusnothing.indentPadding
import com.stilllynnthecloset.outsideusnothing.theme.ImageReference
import com.stilllynnthecloset.outsideusnothing.theme.imageButton
import com.stilllynnthecloset.outsideusnothing.theme.incrementInput
import com.stilllynnthecloset.outsideusnothing.theme.outlinedButton

/**
 * EditScreen - TODO: Documentation
 *
 * Created by Lynn on 5/5/23
 */
@Composable
internal fun EditScreen(dataModel: EditViewModel, platform: Platform) {
    val scrollState = rememberScrollState()
    Column(
        modifier = Modifier
            .fillMaxSize()
            .verticalScroll(scrollState),
    ) {
        Text(
            text = dataModel.currentPage.humanReadable,
            fontSize = 48.sp,
            fontWeight = FontWeight.Bold,
            modifier = Modifier
                .align(Alignment.CenterHorizontally)
                .padding(bottom = 16.dp),
        )
        when (dataModel.currentPage) {
            PlaybookPage.PLAYBOOK -> playbookPage(dataModel, platform)
            PlaybookPage.ALIEN -> aliens(dataModel, dataModel.currentPlaybook, platform)
            PlaybookPage.BACKGROUND -> backgrounds(dataModel, dataModel.currentPlaybook, platform)
            PlaybookPage.ROLE -> roles(dataModel, dataModel.currentPlaybook, platform)
            PlaybookPage.PORT -> ports(dataModel, dataModel.currentPlaybook, platform)
            PlaybookPage.EVENT -> events(dataModel, dataModel.currentPlaybook, platform)
            PlaybookPage.CONTRACT_ITEM -> contractItems(dataModel, dataModel.currentPlaybook, platform)
            PlaybookPage.USEFUL_ITEM -> usefulItems(dataModel, dataModel.currentPlaybook, platform)
            PlaybookPage.BASTARD -> bastards(dataModel, dataModel.currentPlaybook, platform)
            PlaybookPage.THREAT -> threats(dataModel, dataModel.currentPlaybook, platform)
            PlaybookPage.PORT_NAME -> portNames(dataModel, dataModel.currentPlaybook, platform)
            PlaybookPage.NPC_LABEL -> npcLabels(dataModel, dataModel.currentPlaybook, platform)
            PlaybookPage.FLAVOR_TEXT -> flavorTexts(dataModel, dataModel.currentPlaybook, platform)
        }
    }
}

@Composable
@OptIn(ExperimentalMaterial3Api::class)
private fun ColumnScope.playbookPage(dataModel: EditViewModel, platform: Platform) {
    TextField(
        value = dataModel.currentPlaybook.name,
        label = { Text("Name") },
        modifier = Modifier.padding(8.dp),
        onValueChange = dataModel::onNameChanged,
    )
    TextField(
        value = dataModel.currentPlaybook.description,
        label = { Text("Description") },
        modifier = Modifier.padding(8.dp),
        onValueChange = dataModel::onDescriptionChanged,
    )
    TextField(
        value = dataModel.currentPlaybook.authors.joinToString(",") { it.name },
        label = { Text("Authors") },
        modifier = Modifier.padding(8.dp),
        onValueChange = dataModel::onAuthorsChanged,
    )

    PlaybookPage.values().forEach {
        if (it != PlaybookPage.PLAYBOOK) {
            Text(
                text = it.humanReadable,
                fontSize = 32.sp,
                modifier = Modifier
                    .align(Alignment.Start)
                    .padding(8.dp)
                    .clickable {
                        dataModel.setPage(it)
                    },
            )
        }
    }
}

@Composable
@OptIn(ExperimentalMaterial3Api::class)
private fun aliens(dataModel: EditViewModel, playbook: Playbook, platform: Platform) {
    playbook.aliens.forEach {
        it.value.compose(platform, Modifier.padding(start = indentPadding))
    }
}

@Composable
@OptIn(ExperimentalMaterial3Api::class)
private fun backgrounds(dataModel: EditViewModel, playbook: Playbook, platform: Platform) {
    playbook.backgrounds.forEach {
        it.value.compose(platform, Modifier.padding(start = indentPadding))
    }
}

@Composable
@OptIn(ExperimentalMaterial3Api::class)
private fun roles(dataModel: EditViewModel, playbook: Playbook, platform: Platform) {
    playbook.roles.forEach {
        it.value.compose(platform, Modifier.padding(start = indentPadding))
    }
}

@Composable
@OptIn(ExperimentalMaterial3Api::class)
private fun ports(dataModel: EditViewModel, playbook: Playbook, platform: Platform) {
    playbook.ports.forEach {
        it.value.compose(platform, Modifier.padding(start = indentPadding))
    }
}

@Composable
@OptIn(ExperimentalMaterial3Api::class)
private fun events(dataModel: EditViewModel, playbook: Playbook, platform: Platform) {
    playbook.events.forEach {
        it.value.compose(platform, Modifier.padding(start = indentPadding))
    }
}

@Composable
@OptIn(ExperimentalMaterial3Api::class)
private fun contractItems(dataModel: EditViewModel, playbook: Playbook, platform: Platform) {
    Row {
        Column(
            modifier = Modifier.weight(1f),
        ) {
            Text(
                text = "Items:",
            )
            playbook.contractItems.forEach {
                it.value.compose(platform, Modifier.padding(start = indentPadding))

            }
        }
        Column(
            modifier = Modifier.weight(1f),
        ) {
            Text(
                text = "Destinations:",
            )
            playbook.contractDestinations.forEach {
                it.value.compose(platform, Modifier.padding(start = indentPadding))

            }
        }
    }
}

@Composable
@OptIn(ExperimentalMaterial3Api::class)
private fun usefulItems(dataModel: EditViewModel, playbook: Playbook, platform: Platform) {
    playbook.usefulItems.forEach {
        it.value.compose(platform, Modifier.padding(start = indentPadding))

    }
}

@Composable
@OptIn(ExperimentalMaterial3Api::class)
private fun bastards(dataModel: EditViewModel, playbook: Playbook, platform: Platform) {
    playbook.bastards.forEach {
        it.value.compose(platform, Modifier.padding(start = indentPadding))

    }
}

@Composable
@OptIn(ExperimentalMaterial3Api::class)
private fun threats(dataModel: EditViewModel, playbook: Playbook, platform: Platform) {
    outlinedButton(
        onClick = { dataModel.addThreat(Weighted(1, Threat(""))) },
        modifier = Modifier,
        content = {
            Image(
                painter = platform.imagePainter.getPainter(ImageReference.Add),
                colorFilter = ColorFilter.tint(MaterialTheme.colorScheme.onSurface),
                contentDescription = "Add Threat",
                modifier = Modifier
                    .width(24.dp)
                    .align(Alignment.CenterVertically),
            )
            Text(
                "Add Threat",
                color = MaterialTheme.colorScheme.onSurface,
            )
        },
    )
    playbook.threats.forEach { weighted ->
        Row {
            TextField(
                value = weighted.value.name,
                label = { Text(text = "Threat") },
                onValueChange = {
                    dataModel.updateThreat(weighted, Weighted(weighted.weight, Threat(it, weighted.value.uuid)))
                },
                modifier = Modifier,
            )
            incrementInput(
                label = "weight",
                modifier = Modifier,
                value = weighted.weight.toLong(),
                onValueChange = {
                    dataModel.updateThreat(weighted, weighted.copy(weight = it?.toInt() ?: 1))
                },
                platform = platform,
            )
            imageButton(
                onClick = {
                    dataModel.removeThreat(weighted)
                },
                imageReference = ImageReference.Delete,
                contentDescription = "Delete",
                platform = platform
            )
        }
    }
}

@Composable
@OptIn(ExperimentalMaterial3Api::class)
private fun portNames(dataModel: EditViewModel, playbook: Playbook, platform: Platform) {
    Row {
        Column(
            modifier = Modifier.weight(1f),
        ) {
            Text(
                text = "Part 1:",
            )
            playbook.portAdjectives.forEach {
                Text(
                    text = it.value,
                    modifier = Modifier.padding(start = indentPadding),
                )
            }
        }
        Column(
            modifier = Modifier.weight(1f),
        ) {
            Text(
                text = "Part 2:",
            )
            playbook.portNames.forEach {
                Text(
                    text = it.value,
                    modifier = Modifier.padding(start = indentPadding),
                )
            }
        }
    }
}

@Composable
@OptIn(ExperimentalMaterial3Api::class)
private fun npcLabels(dataModel: EditViewModel, playbook: Playbook, platform: Platform) {
    Row {
        Column(
            modifier = Modifier.weight(1f),
        ) {
            Text(
                text = "Part 1:",
            )
            playbook.npcAdjectives.forEach {
                Text(
                    text = it.value,
                    modifier = Modifier.padding(start = indentPadding),
                )
            }
        }
        Column(
            modifier = Modifier.weight(1f),
        ) {
            Text(
                text = "Part 2:",
            )
            playbook.npcTypes.forEach {
                Text(
                    text = it.value,
                    modifier = Modifier.padding(start = indentPadding),
                )
            }
        }
    }
}

@Composable
@OptIn(ExperimentalMaterial3Api::class)
private fun flavorTexts(dataModel: EditViewModel, playbook: Playbook, platform: Platform) {
    playbook.flavorTexts.forEach {
        it.value.compose(platform, Modifier.padding(start = indentPadding))
    }
}
