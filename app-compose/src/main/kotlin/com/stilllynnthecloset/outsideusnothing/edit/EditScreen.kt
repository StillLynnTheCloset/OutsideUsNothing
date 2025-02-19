package com.stilllynnthecloset.outsideusnothing.edit

import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.gestures.Orientation
import androidx.compose.foundation.gestures.draggable
import androidx.compose.foundation.gestures.rememberDraggableState
import androidx.compose.foundation.gestures.scrollBy
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.ColumnScope
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.ColorFilter
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.stilllynnthecloset.outsideusnothing.library.model.Bastard
import com.stilllynnthecloset.outsideusnothing.library.model.ContractDestination
import com.stilllynnthecloset.outsideusnothing.library.model.ContractItem
import com.stilllynnthecloset.outsideusnothing.library.model.FlavorText
import com.stilllynnthecloset.outsideusnothing.library.model.NpcAdjective
import com.stilllynnthecloset.outsideusnothing.library.model.NpcNoun
import com.stilllynnthecloset.outsideusnothing.library.model.Playbook
import com.stilllynnthecloset.outsideusnothing.library.model.PortAdjective
import com.stilllynnthecloset.outsideusnothing.library.model.PortNoun
import com.stilllynnthecloset.outsideusnothing.library.model.Threat
import com.stilllynnthecloset.outsideusnothing.library.tools.Weighted
import com.stilllynnthecloset.outsideusnothing.Platform
import com.stilllynnthecloset.outsideusnothing.PlaybookPage
import com.stilllynnthecloset.outsideusnothing.compose
import com.stilllynnthecloset.outsideusnothing.indentPadding
import com.stilllynnthecloset.outsideusnothing.theme.ImageReference
import com.stilllynnthecloset.outsideusnothing.theme.imageButton
import com.stilllynnthecloset.outsideusnothing.theme.incrementInput
import com.stilllynnthecloset.outsideusnothing.theme.outlinedButton
import com.stilllynnthecloset.outsideusnothing.theme.textInputWidget
import kotlinx.coroutines.runBlocking

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
            .draggable(rememberDraggableState { delta ->
                runBlocking {
                    scrollState.scrollBy(-delta)
                }
            }, orientation = Orientation.Vertical)
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
private fun ColumnScope.playbookPage(dataModel: EditViewModel, platform: Platform) {
    textInputWidget(
        value = dataModel.currentPlaybook.name,
        label = "Name",
        modifier = Modifier.padding(8.dp),
        onValueChange = dataModel::onNameChanged,
    )
    textInputWidget(
        value = dataModel.currentPlaybook.description,
        label = "Description",
        modifier = Modifier.padding(8.dp),
        onValueChange = dataModel::onDescriptionChanged,
    )
    textInputWidget(
        value = dataModel.currentPlaybook.authors.joinToString(",") { it.name },
        label = "Authors",
        modifier = Modifier.padding(8.dp),
        onValueChange = dataModel::onAuthorsChanged,
    )

    PlaybookPage.values().forEach {
        if (it != PlaybookPage.PLAYBOOK) {
            Text(
                text = "${it.humanReadable}: ${getCountForPage(dataModel.currentPlaybook, it)}",
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

private fun getCountForPage(playbook: Playbook, page: PlaybookPage): Int {
    return when (page) {
        PlaybookPage.PLAYBOOK -> 0
        PlaybookPage.ALIEN -> playbook.aliens.size
        PlaybookPage.BACKGROUND -> playbook.backgrounds.size
        PlaybookPage.ROLE -> playbook.roles.size
        PlaybookPage.PORT -> playbook.ports.size
        PlaybookPage.EVENT -> playbook.events.size
        PlaybookPage.CONTRACT_ITEM -> playbook.contractItems.size + playbook.contractDestinations.size
        PlaybookPage.USEFUL_ITEM -> playbook.usefulItems.size
        PlaybookPage.BASTARD -> playbook.bastards.size
        PlaybookPage.THREAT -> playbook.threats.size
        PlaybookPage.PORT_NAME -> playbook.portAdjectives.size + playbook.portNouns.size
        PlaybookPage.NPC_LABEL -> playbook.npcAdjectives.size + playbook.npcNouns.size
        PlaybookPage.FLAVOR_TEXT -> playbook.flavorTexts.size
    }
}

@Composable
private fun aliens(dataModel: EditViewModel, playbook: Playbook, platform: Platform) {
    playbook.aliens.forEach {
        it.value.compose(platform, Modifier.padding(start = indentPadding))
    }
}

@Composable
private fun backgrounds(dataModel: EditViewModel, playbook: Playbook, platform: Platform) {
    playbook.backgrounds.forEach {
        it.value.compose(platform, Modifier.padding(start = indentPadding))
    }
}

@Composable
private fun roles(dataModel: EditViewModel, playbook: Playbook, platform: Platform) {
    playbook.roles.forEach {
        it.value.compose(platform, Modifier.padding(start = indentPadding))
    }
}

@Composable
private fun ports(dataModel: EditViewModel, playbook: Playbook, platform: Platform) {
    playbook.ports.forEach {
        it.value.compose(platform, Modifier.padding(start = indentPadding))
    }
}

@Composable
private fun events(dataModel: EditViewModel, playbook: Playbook, platform: Platform) {
    playbook.events.forEach {
        it.value.compose(platform, Modifier.padding(start = indentPadding))
    }
}

@Composable
private fun usefulItems(dataModel: EditViewModel, playbook: Playbook, platform: Platform) {
    playbook.usefulItems.forEach {
        it.value.compose(platform, Modifier.padding(start = indentPadding))
    }
}

@Composable
private fun ColumnScope.bastards(dataModel: EditViewModel, playbook: Playbook, platform: Platform) {
    outlinedButton(
        onClick = { dataModel.addBastard(Weighted(1, Bastard("", ""))) },
        modifier = Modifier
            .align(Alignment.CenterHorizontally),
        content = {
            Image(
                painter = platform.imagePainter.getPainter(ImageReference.Add),
                colorFilter = ColorFilter.tint(MaterialTheme.colorScheme.onSurface),
                contentDescription = "Add Bastard",
                modifier = Modifier
                    .width(24.dp)
                    .align(Alignment.CenterVertically),
            )
            Text(
                text = "Add Bastard",
                color = MaterialTheme.colorScheme.onSurface,
            )
        },
    )
    playbook.bastards.forEach { weighted ->
        Row(
            modifier = Modifier
                .padding(vertical = 4.dp)
                .align(Alignment.CenterHorizontally),
        ) {
            Column(
                modifier = Modifier
                    .align(Alignment.CenterVertically)
                    .weight(1f),
            ) {
                textInputWidget(
                    value = weighted.value.name,
                    label = "Name",
                    onValueChange = {
                        dataModel.updateBastard(Weighted(weighted.weight, weighted.value.copy(name = it)))
                    },
                    modifier = Modifier
                        .fillMaxWidth(),
                )
                textInputWidget(
                    value = weighted.value.description,
                    label = "Description",
                    onValueChange = {
                        dataModel.updateBastard(Weighted(weighted.weight, weighted.value.copy(description = it)))
                    },
                    modifier = Modifier
                        .fillMaxWidth(),
                )
            }
            incrementInput(
                label = "weight",
                modifier = Modifier
                    .align(Alignment.CenterVertically)
                    .padding(horizontal = 4.dp),
                value = weighted.weight.toLong(),
                width = 100.dp,
                onValueChange = {
                    dataModel.updateBastard(weighted.copy(weight = it?.toInt() ?: 1))
                },
                platform = platform,
            )
            imageButton(
                onClick = {
                    dataModel.removeBastard(weighted)
                },
                modifier = Modifier
                    .align(Alignment.CenterVertically),
                imageReference = ImageReference.Delete,
                contentDescription = "Delete",
                platform = platform,
            )
        }
    }
}

@Composable
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
                platform = platform,
            )
        }
    }
}

@Composable
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
                        platform = platform,
                    )
                }
            }
        }
        Column(
            modifier = Modifier.weight(1f),
        ) {
            outlinedButton(
                onClick = { dataModel.addPortType(Weighted(1, PortNoun(""))) },
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
            playbook.portNouns.forEach { weighted ->
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
                        platform = platform,
                    )
                }
            }
        }
    }
}

@Composable
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
                        platform = platform,
                    )
                }
            }
        }
        Column(
            modifier = Modifier.weight(1f),
        ) {
            outlinedButton(
                onClick = { dataModel.addNpcName(Weighted(1, NpcNoun(""))) },
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
            playbook.npcNouns.forEach { weighted ->
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
                        platform = platform,
                    )
                }
            }
        }
    }
}

@Composable
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
                        label = "Item",
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
                        platform = platform,
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
                        platform = platform,
                    )
                }
            }
        }
    }
}

@Composable
private fun ColumnScope.flavorTexts(dataModel: EditViewModel, playbook: Playbook, platform: Platform) {
    outlinedButton(
        onClick = { dataModel.addFlavorText(Weighted(1, FlavorText("", ""))) },
        modifier = Modifier
            .align(Alignment.CenterHorizontally),
        content = {
            Image(
                painter = platform.imagePainter.getPainter(ImageReference.Add),
                colorFilter = ColorFilter.tint(MaterialTheme.colorScheme.onSurface),
                contentDescription = "Add Flavor Text",
                modifier = Modifier
                    .width(24.dp)
                    .align(Alignment.CenterVertically),
            )
            Text(
                text = "Add Flavor Text",
                color = MaterialTheme.colorScheme.onSurface,
            )
        },
    )
    playbook.flavorTexts.forEach { weighted ->
        Row(
            modifier = Modifier
                .padding(vertical = 4.dp)
                .align(Alignment.CenterHorizontally),
        ) {
            Column(
                modifier = Modifier
                    .align(Alignment.CenterVertically)
                    .weight(1f),
            ) {
                textInputWidget(
                    value = weighted.value.text,
                    label = "Text",
                    onValueChange = {
                        dataModel.updateFlavorText(Weighted(weighted.weight, weighted.value.copy(text = it)))
                    },
                    modifier = Modifier
                        .fillMaxWidth(),
                )
                textInputWidget(
                    value = weighted.value.attribution,
                    label = "Attribution",
                    onValueChange = {
                        dataModel.updateFlavorText(Weighted(weighted.weight, weighted.value.copy(attribution = it)))
                    },
                    modifier = Modifier
                        .fillMaxWidth(),
                )
            }
            incrementInput(
                label = "weight",
                modifier = Modifier
                    .align(Alignment.CenterVertically)
                    .padding(horizontal = 4.dp),
                value = weighted.weight.toLong(),
                width = 100.dp,
                onValueChange = {
                    dataModel.updateFlavorText(weighted.copy(weight = it?.toInt() ?: 1))
                },
                platform = platform,
            )
            imageButton(
                onClick = {
                    dataModel.removeFlavorText(weighted)
                },
                modifier = Modifier
                    .align(Alignment.CenterVertically),
                imageReference = ImageReference.Delete,
                contentDescription = "Delete",
                platform = platform,
            )
        }
    }
}
