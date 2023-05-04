package com.stilllynnthecloset.outsideusnothing.playbook

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import com.stilllynnthecloset.liboun.playbook.AlienPlaybook
import com.stilllynnthecloset.liboun.playbook.BackgroundPlaybook
import com.stilllynnthecloset.liboun.playbook.BastardPlaybook
import com.stilllynnthecloset.liboun.playbook.ContractItemPlaybook
import com.stilllynnthecloset.liboun.playbook.EventPlaybook
import com.stilllynnthecloset.liboun.playbook.PortPlaybook
import com.stilllynnthecloset.liboun.playbook.RolePlaybook
import com.stilllynnthecloset.liboun.playbook.ThreatPlaybook
import com.stilllynnthecloset.liboun.playbook.UsefulItemPlaybook
import com.stilllynnthecloset.outsideusnothing.Platform
import com.stilllynnthecloset.outsideusnothing.compose
import com.stilllynnthecloset.outsideusnothing.indentPadding

/**
 * PlaybookScreen - TODO: Documentation
 *
 * Created by Lynn on 5/3/23
 */
@Composable
internal fun playbookScreen(dataModel: PlaybookDataModel, platform: Platform) {
    val scrollState = rememberScrollState()

    Column(
        modifier = Modifier
            .verticalScroll(scrollState)
    ) {
        when (dataModel.currentPage) {
            PlaybookPage.TABLE_OF_CONTENTS -> tableOfContents(dataModel, platform)
            PlaybookPage.ALIEN -> alien(dataModel, platform)
            PlaybookPage.BACKGROUND -> background(dataModel, platform)
            PlaybookPage.ROLE -> role(dataModel, platform)
            PlaybookPage.PORT -> port(dataModel, platform)
            PlaybookPage.EVENT -> event(dataModel, platform)
            PlaybookPage.CONTRACT_ITEM -> contractItem(dataModel, platform)
            PlaybookPage.USEFUL_ITEM -> usefulItem(dataModel, platform)
            PlaybookPage.BASTARD -> bastard(dataModel, platform)
            PlaybookPage.THREAT -> threat(dataModel, platform)
        }
    }
}

@Composable
private fun tableOfContents(dataModel: PlaybookDataModel, platform: Platform) {
    Text(
        text = "Aliens",
        modifier = Modifier.clickable {
            dataModel.setPage(PlaybookPage.ALIEN)
        }
    )
    Text(
        text = "Backgrounds",
        modifier = Modifier.clickable {
            dataModel.setPage(PlaybookPage.BACKGROUND)
        }
    )
    Text(
        text = "Ship Roles",
        modifier = Modifier.clickable {
            dataModel.setPage(PlaybookPage.ROLE)
        }
    )
    Text(
        text = "Ports of Call",
        modifier = Modifier.clickable {
            dataModel.setPage(PlaybookPage.PORT)
        }
    )
    Text(
        text = "Events",
        modifier = Modifier.clickable {
            dataModel.setPage(PlaybookPage.EVENT)
        }
    )
    Text(
        text = "Contract Items",
        modifier = Modifier.clickable {
            dataModel.setPage(PlaybookPage.CONTRACT_ITEM)
        }
    )
    Text(
        text = "Useful Items",
        modifier = Modifier.clickable {
            dataModel.setPage(PlaybookPage.USEFUL_ITEM)
        }
    )
    Text(
        text = "Bastards",
        modifier = Modifier.clickable {
            dataModel.setPage(PlaybookPage.BASTARD)
        }
    )
    Text(
        text = "Threats",
        modifier = Modifier.clickable {
            dataModel.setPage(PlaybookPage.THREAT)
        }
    )
}

@Composable
private fun alien(dataModel: PlaybookDataModel, platform: Platform) {
    Button(
        onClick = { dataModel.setPage(PlaybookPage.TABLE_OF_CONTENTS) },
    ) {
        Text(
            text = "Back"
        )
    }
    AlienPlaybook.aliens.forEach {
        it.compose(platform, Modifier.padding(start = indentPadding))
    }
}

@Composable
private fun background(dataModel: PlaybookDataModel, platform: Platform) {
    Button(
        onClick = { dataModel.setPage(PlaybookPage.TABLE_OF_CONTENTS) },
    ) {
        Text(
            text = "Back"
        )
    }
    BackgroundPlaybook.backgrounds.forEach {
        it.compose(platform, Modifier.padding(start = indentPadding))
    }
}

@Composable
private fun role(dataModel: PlaybookDataModel, platform: Platform) {
    Button(
        onClick = { dataModel.setPage(PlaybookPage.TABLE_OF_CONTENTS) },
    ) {
        Text(
            text = "Back"
        )
    }
    RolePlaybook.roles.forEach {
        it.compose(platform, Modifier.padding(start = indentPadding))
    }
}

@Composable
private fun port(dataModel: PlaybookDataModel, platform: Platform) {
    Button(
        onClick = { dataModel.setPage(PlaybookPage.TABLE_OF_CONTENTS) },
    ) {
        Text(
            text = "Back"
        )
    }
    PortPlaybook.portWeightings.forEach {
        it.key.compose(platform, Modifier.padding(start = indentPadding))
    }
}

@Composable
private fun event(dataModel: PlaybookDataModel, platform: Platform) {
    Button(
        onClick = { dataModel.setPage(PlaybookPage.TABLE_OF_CONTENTS) },
    ) {
        Text(
            text = "Back"
        )
    }
    EventPlaybook.events.forEach {
        it.compose(platform, Modifier.padding(start = indentPadding))
    }
}

@Composable
private fun contractItem(dataModel: PlaybookDataModel, platform: Platform) {
    Button(
        onClick = { dataModel.setPage(PlaybookPage.TABLE_OF_CONTENTS) },
    ) {
        Text(
            text = "Back"
        )
    }
    ContractItemPlaybook.items.forEach {
        it.compose(platform, Modifier.padding(start = indentPadding))
    }
}

@Composable
private fun usefulItem(dataModel: PlaybookDataModel, platform: Platform) {
    Button(
        onClick = { dataModel.setPage(PlaybookPage.TABLE_OF_CONTENTS) },
    ) {
        Text(
            text = "Back"
        )
    }
    UsefulItemPlaybook.items.forEach {
        it.compose(platform, Modifier.padding(start = indentPadding))
    }
}

@Composable
private fun bastard(dataModel: PlaybookDataModel, platform: Platform) {
    Button(
        onClick = { dataModel.setPage(PlaybookPage.TABLE_OF_CONTENTS) },
    ) {
        Text(
            text = "Back"
        )
    }
    BastardPlaybook.bastards.forEach {
        it.compose(platform, Modifier.padding(start = indentPadding))
    }
}

@Composable
private fun threat(dataModel: PlaybookDataModel, platform: Platform) {
    Button(
        onClick = { dataModel.setPage(PlaybookPage.TABLE_OF_CONTENTS) },
    ) {
        Text(
            text = "Back"
        )
    }
    ThreatPlaybook.threats.forEach {
        it.compose(platform, Modifier.padding(start = indentPadding))
    }
}