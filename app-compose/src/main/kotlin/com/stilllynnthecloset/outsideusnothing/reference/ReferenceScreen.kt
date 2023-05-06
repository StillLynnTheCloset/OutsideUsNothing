package com.stilllynnthecloset.outsideusnothing.reference

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.ColumnScope
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
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.stilllynnthecloset.liboun.model.Playbook
import com.stilllynnthecloset.outsideusnothing.Platform
import com.stilllynnthecloset.outsideusnothing.PlaybookPage
import com.stilllynnthecloset.outsideusnothing.compose
import com.stilllynnthecloset.outsideusnothing.indentPadding

/**
 * ReferenceScreen - TODO: Documentation
 *
 * Created by Lynn on 5/3/23
 */
@Composable
internal fun ReferenceScreen(dataModel: ReferenceDataModel, platform: Platform) {
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
            PlaybookPage.PLAYBOOK -> tableOfContents(dataModel, dataModel.mainDataModel.mergedPlaybook, platform)
            PlaybookPage.ALIEN -> alien(dataModel, dataModel.mainDataModel.mergedPlaybook, platform)
            PlaybookPage.BACKGROUND -> background(dataModel, dataModel.mainDataModel.mergedPlaybook, platform)
            PlaybookPage.ROLE -> role(dataModel, dataModel.mainDataModel.mergedPlaybook, platform)
            PlaybookPage.PORT -> port(dataModel, dataModel.mainDataModel.mergedPlaybook, platform)
            PlaybookPage.EVENT -> event(dataModel, dataModel.mainDataModel.mergedPlaybook, platform)
            PlaybookPage.CONTRACT_ITEM -> contractItem(dataModel, dataModel.mainDataModel.mergedPlaybook, platform)
            PlaybookPage.USEFUL_ITEM -> usefulItem(dataModel, dataModel.mainDataModel.mergedPlaybook, platform)
            PlaybookPage.BASTARD -> bastard(dataModel, dataModel.mainDataModel.mergedPlaybook, platform)
            PlaybookPage.THREAT -> threat(dataModel, dataModel.mainDataModel.mergedPlaybook, platform)
        }
    }
}

@Composable
private fun ColumnScope.tableOfContents(dataModel: ReferenceDataModel, playbook: Playbook, platform: Platform) {
    PlaybookPage.values().forEach {
        if (it != PlaybookPage.PLAYBOOK) {
            Text(
                text = it.humanReadable,
                fontSize = 32.sp,
                modifier = Modifier
                    .align(Alignment.CenterHorizontally)
                    .clickable {
                        dataModel.setPage(it)
                    },
            )
        }
    }
}

@Composable
private fun alien(dataModel: ReferenceDataModel, playbook: Playbook, platform: Platform) {
    Button(
        onClick = { dataModel.setPage(PlaybookPage.PLAYBOOK) },
    ) {
        Text(
            text = "Back",
        )
    }
    playbook.aliens.forEach {
        it.value.compose(platform, Modifier.padding(start = indentPadding))
    }
}

@Composable
private fun background(dataModel: ReferenceDataModel, playbook: Playbook, platform: Platform) {
    Button(
        onClick = { dataModel.setPage(PlaybookPage.PLAYBOOK) },
    ) {
        Text(
            text = "Back",
        )
    }
    playbook.backgrounds.forEach {
        it.value.compose(platform, Modifier.padding(start = indentPadding))
    }
}

@Composable
private fun role(dataModel: ReferenceDataModel, playbook: Playbook, platform: Platform) {
    Button(
        onClick = { dataModel.setPage(PlaybookPage.PLAYBOOK) },
    ) {
        Text(
            text = "Back",
        )
    }
    playbook.roles.forEach {
        it.value.compose(platform, Modifier.padding(start = indentPadding))
    }
}

@Composable
private fun port(dataModel: ReferenceDataModel, playbook: Playbook, platform: Platform) {
    Button(
        onClick = { dataModel.setPage(PlaybookPage.PLAYBOOK) },
    ) {
        Text(
            text = "Back",
        )
    }
    playbook.ports.forEach {
        it.value.compose(platform, Modifier.padding(start = indentPadding))
    }
}

@Composable
private fun event(dataModel: ReferenceDataModel, playbook: Playbook, platform: Platform) {
    Button(
        onClick = { dataModel.setPage(PlaybookPage.PLAYBOOK) },
    ) {
        Text(
            text = "Back",
        )
    }
    playbook.events.forEach {
        it.value.compose(platform, Modifier.padding(start = indentPadding))
    }
}

@Composable
private fun contractItem(dataModel: ReferenceDataModel, playbook: Playbook, platform: Platform) {
    Button(
        onClick = { dataModel.setPage(PlaybookPage.PLAYBOOK) },
    ) {
        Text(
            text = "Back",
        )
    }
    Row {
        Column(
            modifier = Modifier.weight(1f),
        ) {
            Text(
                text = "Deliver this:",
            )
            playbook.contractItems.forEach {
                it.value.compose(platform, Modifier.padding(start = indentPadding))
            }
        }
        Column(
            modifier = Modifier.weight(1f),
        ) {
            Text(
                text = "here:",
            )
            playbook.contractDestinations.forEach {
                it.value.compose(platform, Modifier.padding(start = indentPadding))
            }
        }
    }
}

@Composable
private fun usefulItem(dataModel: ReferenceDataModel, playbook: Playbook, platform: Platform) {
    Button(
        onClick = { dataModel.setPage(PlaybookPage.PLAYBOOK) },
    ) {
        Text(
            text = "Back",
        )
    }
    playbook.usefulItems.forEach {
        it.value.compose(platform, Modifier.padding(start = indentPadding))
    }
}

@Composable
private fun bastard(dataModel: ReferenceDataModel, playbook: Playbook, platform: Platform) {
    Button(
        onClick = { dataModel.setPage(PlaybookPage.PLAYBOOK) },
    ) {
        Text(
            text = "Back",
        )
    }
    playbook.bastards.forEach {
        it.value.compose(platform, Modifier.padding(start = indentPadding))
    }
}

@Composable
private fun threat(dataModel: ReferenceDataModel, playbook: Playbook, platform: Platform) {
    Button(
        onClick = { dataModel.setPage(PlaybookPage.PLAYBOOK) },
    ) {
        Text(
            text = "Back",
        )
    }
    playbook.threats.forEach {
        it.value.compose(platform, Modifier.padding(start = indentPadding))
    }
}

