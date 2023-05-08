package com.stilllynnthecloset.outsideusnothing.edit

import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.ColumnScope
import androidx.compose.foundation.layout.IntrinsicSize
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
import com.stilllynnthecloset.liboun.model.ContractDestination
import com.stilllynnthecloset.liboun.model.ContractItem
import com.stilllynnthecloset.liboun.model.NpcAdjective
import com.stilllynnthecloset.liboun.model.NpcType
import com.stilllynnthecloset.liboun.model.Playbook
import com.stilllynnthecloset.liboun.model.PortAdjective
import com.stilllynnthecloset.liboun.model.PortType
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
import com.stilllynnthecloset.outsideusnothing.theme.textInputWidget

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
private fun ColumnScope.threats(dataModel: EditViewModel, playbook: Playbook, platform: Platform) {
    outlinedButton(
        onClick = { dataModel.addThreat(Weighted(1, Threat(""))) },
        modifier = Modifier
            .align(Alignment.CenterHorizontally),
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
                text = "Add Threat",
                color = MaterialTheme.colorScheme.onSurface,
            )
        },
    )
    playbook.threats.forEach { weighted ->
        Row(
            modifier = Modifier
                .padding(vertical = 4.dp)
                .align(Alignment.CenterHorizontally),
        ) {
            textInputWidget(
                value = weighted.value.name,
                label = "Threat",
                onValueChange = {
                    dataModel.updateThreat(Weighted(weighted.weight, Threat(it, weighted.value.uuid)))
                },
                modifier = Modifier
                    .weight(1f)
                    .align(Alignment.CenterVertically),
            )
            incrementInput(
                label = "weight",
                modifier = Modifier
                    .align(Alignment.CenterVertically)
                    .padding(horizontal = 4.dp),
                value = weighted.weight.toLong(),
                width = 100.dp,
                onValueChange = {
                    dataModel.updateThreat(weighted.copy(weight = it?.toInt() ?: 1))
                },
                platform = platform,
            )
            imageButton(
                onClick = {
                    dataModel.removeThreat(weighted)
                },
                modifier = Modifier
                    .align(Alignment.CenterVertically),
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
            outlinedButton(
                onClick = { dataModel.addPortAdjective(Weighted(1, PortAdjective(""))) },
                modifier = Modifier
                    .align(Alignment.CenterHorizontally),
                content = {
                    Image(
                        painter = platform.imagePainter.getPainter(ImageReference.Add),
                        colorFilter = ColorFilter.tint(MaterialTheme.colorScheme.onSurface),
                        contentDescription = "Add Port Adjective",
                        modifier = Modifier
                            .width(24.dp)
                            .align(Alignment.CenterVertically),
                    )
                    Text(
                        text = "Add Port Adjective",
                        color = MaterialTheme.colorScheme.onSurface,
                    )
                },
            )
            playbook.portAdjectives.forEach { weighted ->
                Row(
                    modifier = Modifier
                        .padding(vertical = 4.dp)
                        .align(Alignment.CenterHorizontally),
                ) {
                    textInputWidget(
                        value = weighted.value.text,
                        label = "Adjective",
                        onValueChange = {
                            dataModel.updatePortAdjective(Weighted(weighted.weight, weighted.value.copy(text = it)))
                        },
                        modifier = Modifier
                            .weight(1f)
                            .align(Alignment.CenterVertically),
                    )
                    incrementInput(
                        label = "weight",
                        modifier = Modifier
                            .align(Alignment.CenterVertically)
                            .padding(horizontal = 4.dp),
                        value = weighted.weight.toLong(),
                        width = 100.dp,
                        onValueChange = {
                            dataModel.updatePortAdjective(weighted.copy(weight = it?.toInt() ?: 1))
                        },
                        platform = platform,
                    )

                    imageButton(
                        onClick = {
                            dataModel.removePortAdjective(weighted)
                        },
                        modifier = Modifier
                            .align(Alignment.CenterVertically),
                        imageReference = ImageReference.Delete,
                        contentDescription = "Delete",
                        platform = platform
                    )
                }
            }
        }
        Column(
            modifier = Modifier.weight(1f),
        ) {
            outlinedButton(
                onClick = { dataModel.addPortType(Weighted(1, PortType(""))) },
                modifier = Modifier
                    .align(Alignment.CenterHorizontally),
                content = {
                    Image(
                        painter = platform.imagePainter.getPainter(ImageReference.Add),
                        colorFilter = ColorFilter.tint(MaterialTheme.colorScheme.onSurface),
                        contentDescription = "Add Port Name",
                        modifier = Modifier
                            .width(24.dp)
                            .align(Alignment.CenterVertically),
                    )
                    Text(
                        text = "Add Name",
                        color = MaterialTheme.colorScheme.onSurface,
                    )
                },
            )
            playbook.portTypes.forEach { weighted ->
                Row(
                    modifier = Modifier
                        .padding(vertical = 4.dp)
                        .align(Alignment.CenterHorizontally),
                ) {
                    textInputWidget(
                        value = weighted.value.text,
                        label = "Name",
                        onValueChange = {
                            dataModel.updatePortType(Weighted(weighted.weight, weighted.value.copy(text = it)))
                        },
                        modifier = Modifier
                            .weight(1f)
                            .padding(horizontal = 4.dp),
                    )
                    incrementInput(
                        label = "weight",
                        modifier = Modifier
                            .align(Alignment.CenterVertically)
                            .padding(horizontal = 4.dp),
                        value = weighted.weight.toLong(),
                        width = 100.dp,
                        onValueChange = {
                            dataModel.updatePortType(weighted.copy(weight = it?.toInt() ?: 1))
                        },
                        platform = platform,
                    )

                    imageButton(
                        onClick = {
                            dataModel.removePortType(weighted)
                        },
                        modifier = Modifier
                            .align(Alignment.CenterVertically),
                        imageReference = ImageReference.Delete,
                        contentDescription = "Delete",
                        platform = platform
                    )
                }
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
            outlinedButton(
                onClick = { dataModel.addNpcAdjective(Weighted(1, NpcAdjective(""))) },
                modifier = Modifier
                    .align(Alignment.CenterHorizontally),
                content = {
                    Image(
                        painter = platform.imagePainter.getPainter(ImageReference.Add),
                        colorFilter = ColorFilter.tint(MaterialTheme.colorScheme.onSurface),
                        contentDescription = "Add NPC Adjective",
                        modifier = Modifier
                            .width(24.dp)
                            .align(Alignment.CenterVertically),
                    )
                    Text(
                        text = "Add NPC Adjective",
                        color = MaterialTheme.colorScheme.onSurface,
                    )
                },
            )
            playbook.npcAdjectives.forEach { weighted ->
                Row(
                    modifier = Modifier
                        .padding(vertical = 4.dp)
                        .align(Alignment.CenterHorizontally),
                ) {
                    textInputWidget(
                        value = weighted.value.text,
                        label = "Adjective",
                        onValueChange = {
                            dataModel.updateNpcAdjective(Weighted(weighted.weight, weighted.value.copy(text = it)))
                        },
                        modifier = Modifier
                            .weight(1f)
                            .align(Alignment.CenterVertically),
                    )
                    incrementInput(
                        label = "weight",
                        modifier = Modifier
                            .align(Alignment.CenterVertically)
                            .padding(horizontal = 4.dp),
                        value = weighted.weight.toLong(),
                        width = 100.dp,
                        onValueChange = {
                            dataModel.updateNpcAdjective(weighted.copy(weight = it?.toInt() ?: 1))
                        },
                        platform = platform,
                    )

                    imageButton(
                        onClick = {
                            dataModel.removeNpcAdjective(weighted)
                        },
                        modifier = Modifier
                            .align(Alignment.CenterVertically),
                        imageReference = ImageReference.Delete,
                        contentDescription = "Delete",
                        platform = platform
                    )
                }
            }
        }
        Column(
            modifier = Modifier.weight(1f),
        ) {
            outlinedButton(
                onClick = { dataModel.addNpcName(Weighted(1, NpcType(""))) },
                modifier = Modifier
                    .align(Alignment.CenterHorizontally),
                content = {
                    Image(
                        painter = platform.imagePainter.getPainter(ImageReference.Add),
                        colorFilter = ColorFilter.tint(MaterialTheme.colorScheme.onSurface),
                        contentDescription = "Add NPC Type",
                        modifier = Modifier
                            .width(24.dp)
                            .align(Alignment.CenterVertically),
                    )
                    Text(
                        text = "Add NPC Type",
                        color = MaterialTheme.colorScheme.onSurface,
                    )
                },
            )
            playbook.npcTypes.forEach { weighted ->
                Row(
                    modifier = Modifier
                        .padding(vertical = 4.dp)
                        .align(Alignment.CenterHorizontally),
                ) {
                    textInputWidget(
                        value = weighted.value.text,
                        label = "Type",
                        onValueChange = {
                            dataModel.updateNpcName(Weighted(weighted.weight, weighted.value.copy(text = it)))
                        },
                        modifier = Modifier
                            .weight(1f)
                            .align(Alignment.CenterVertically),
                    )
                    incrementInput(
                        label = "weight",
                        modifier = Modifier
                            .align(Alignment.CenterVertically)
                            .padding(horizontal = 4.dp),
                        value = weighted.weight.toLong(),
                        width = 100.dp,
                        onValueChange = {
                            dataModel.updateNpcName(weighted.copy(weight = it?.toInt() ?: 1))
                        },
                        platform = platform,
                    )

                    imageButton(
                        onClick = {
                            dataModel.removeNpcName(weighted)
                        },
                        modifier = Modifier
                            .align(Alignment.CenterVertically),
                        imageReference = ImageReference.Delete,
                        contentDescription = "Delete",
                        platform = platform
                    )
                }
            }
        }
    }
}

@Composable
@OptIn(ExperimentalMaterial3Api::class)
private fun contractItems(dataModel: EditViewModel, playbook: Playbook, platform: Platform) {
    Row {
        Column(
            modifier = Modifier.weight(1f),
        ) {
            outlinedButton(
                onClick = { dataModel.addContractItem(Weighted(1, ContractItem(""))) },
                modifier = Modifier
                    .align(Alignment.CenterHorizontally),
                content = {
                    Image(
                        painter = platform.imagePainter.getPainter(ImageReference.Add),
                        colorFilter = ColorFilter.tint(MaterialTheme.colorScheme.onSurface),
                        contentDescription = "Add Contract Item",
                        modifier = Modifier
                            .width(24.dp)
                            .align(Alignment.CenterVertically),
                    )
                    Text(
                        text = "Add Contract Item",
                        color = MaterialTheme.colorScheme.onSurface,
                    )
                },
            )
            playbook.contractItems.forEach { weighted ->
                Row(
                    modifier = Modifier
                        .padding(vertical = 4.dp)
                        .align(Alignment.CenterHorizontally),
                ) {
                    textInputWidget(
                        value = weighted.value.name,
                        label ="Item",
                        onValueChange = {
                            dataModel.updateContractItem(Weighted(weighted.weight, weighted.value.copy(name = it)))
                        },
                        modifier = Modifier
                            .weight(1f)
                            .align(Alignment.CenterVertically),
                    )
                    incrementInput(
                        label = "weight",
                        modifier = Modifier
                            .align(Alignment.CenterVertically)
                            .padding(horizontal = 4.dp),
                        value = weighted.weight.toLong(),
                        width = 100.dp,
                        onValueChange = {
                            dataModel.updateContractItem(weighted.copy(weight = it?.toInt() ?: 1))
                        },
                        platform = platform,
                    )

                    imageButton(
                        onClick = {
                            dataModel.removeContractItem(weighted)
                        },
                        modifier = Modifier
                            .align(Alignment.CenterVertically),
                        imageReference = ImageReference.Delete,
                        contentDescription = "Delete",
                        platform = platform
                    )
                }
            }
        }
        Column(
            modifier = Modifier.weight(1f),
        ) {
            outlinedButton(
                onClick = { dataModel.addContractDestination(Weighted(1, ContractDestination(""))) },
                modifier = Modifier
                    .align(Alignment.CenterHorizontally),
                content = {
                    Image(
                        painter = platform.imagePainter.getPainter(ImageReference.Add),
                        colorFilter = ColorFilter.tint(MaterialTheme.colorScheme.onSurface),
                        contentDescription = "Add Contract Destination",
                        modifier = Modifier
                            .width(24.dp)
                            .align(Alignment.CenterVertically),
                    )
                    Text(
                        text = "Add Contract Destination",
                        color = MaterialTheme.colorScheme.onSurface,
                    )
                },
            )
            playbook.contractDestinations.forEach { weighted ->
                Row(
                    modifier = Modifier
                        .padding(vertical = 4.dp)
                        .align(Alignment.CenterHorizontally),
                ) {
                    textInputWidget(
                        value = weighted.value.name,
                        label = "Destination",
                        onValueChange = {
                            dataModel.updateContractDestination(Weighted(weighted.weight, weighted.value.copy(name = it)))
                        },
                        modifier = Modifier
                            .weight(1f)
                            .align(Alignment.CenterVertically),
                    )
                    incrementInput(
                        label = "weight",
                        modifier = Modifier
                            .align(Alignment.CenterVertically)
                            .padding(horizontal = 4.dp),
                        value = weighted.weight.toLong(),
                        width = 100.dp,
                        onValueChange = {
                            dataModel.updateContractDestination(weighted.copy(weight = it?.toInt() ?: 1))
                        },
                        platform = platform,
                    )

                    imageButton(
                        onClick = {
                            dataModel.removeContractDestination(weighted)
                        },
                        modifier = Modifier
                            .align(Alignment.CenterVertically),
                        imageReference = ImageReference.Delete,
                        contentDescription = "Delete",
                        platform = platform
                    )
                }
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
