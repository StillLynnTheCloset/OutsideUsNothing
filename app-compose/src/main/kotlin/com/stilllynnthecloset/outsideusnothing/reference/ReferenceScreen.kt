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
import androidx.compose.ui.unit.sp
import com.stilllynnthecloset.outsideusnothing.Platform
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
        when (dataModel.currentPage) {
            ReferencePage.TABLE_OF_CONTENTS -> tableOfContents(dataModel, platform)
            ReferencePage.ALIEN -> alien(dataModel, platform)
            ReferencePage.BACKGROUND -> background(dataModel, platform)
            ReferencePage.ROLE -> role(dataModel, platform)
            ReferencePage.PORT -> port(dataModel, platform)
            ReferencePage.EVENT -> event(dataModel, platform)
            ReferencePage.CONTRACT_ITEM -> contractItem(dataModel, platform)
            ReferencePage.USEFUL_ITEM -> usefulItem(dataModel, platform)
            ReferencePage.BASTARD -> bastard(dataModel, platform)
            ReferencePage.THREAT -> threat(dataModel, platform)
        }
    }
}

@Composable
private fun ColumnScope.tableOfContents(dataModel: ReferenceDataModel, platform: Platform) {
    Text(
        text = "Aliens",
        fontSize = 32.sp,
        modifier = Modifier
            .align(Alignment.CenterHorizontally)
            .clickable {
                dataModel.setPage(ReferencePage.ALIEN)
            },
    )
    Text(
        text = "Backgrounds",
        fontSize = 32.sp,
        modifier = Modifier
            .align(Alignment.CenterHorizontally)
            .clickable {
                dataModel.setPage(ReferencePage.BACKGROUND)
            },
    )
    Text(
        text = "Ship Roles",
        fontSize = 32.sp,
        modifier = Modifier
            .align(Alignment.CenterHorizontally)
            .clickable {
                dataModel.setPage(ReferencePage.ROLE)
            },
    )
    Text(
        text = "Ports of Call",
        fontSize = 32.sp,
        modifier = Modifier
            .align(Alignment.CenterHorizontally)
            .clickable {
                dataModel.setPage(ReferencePage.PORT)
            },
    )
    Text(
        text = "Events",
        fontSize = 32.sp,
        modifier = Modifier
            .align(Alignment.CenterHorizontally)
            .clickable {
                dataModel.setPage(ReferencePage.EVENT)
            },
    )
    Text(
        text = "Contract Items",
        fontSize = 32.sp,
        modifier = Modifier
            .align(Alignment.CenterHorizontally)
            .clickable {
                dataModel.setPage(ReferencePage.CONTRACT_ITEM)
            },
    )
    Text(
        text = "Useful Items",
        fontSize = 32.sp,
        modifier = Modifier
            .align(Alignment.CenterHorizontally)
            .clickable {
                dataModel.setPage(ReferencePage.USEFUL_ITEM)
            },
    )
    Text(
        text = "Bastards",
        fontSize = 32.sp,
        modifier = Modifier
            .align(Alignment.CenterHorizontally)
            .clickable {
                dataModel.setPage(ReferencePage.BASTARD)
            },
    )
    Text(
        text = "Threats",
        fontSize = 32.sp,
        modifier = Modifier
            .align(Alignment.CenterHorizontally)
            .clickable {
                dataModel.setPage(ReferencePage.THREAT)
            },
    )
}

@Composable
private fun alien(dataModel: ReferenceDataModel, platform: Platform) {
    Button(
        onClick = { dataModel.setPage(ReferencePage.TABLE_OF_CONTENTS) },
    ) {
        Text(
            text = "Back",
        )
    }
    dataModel.playbook.aliens.forEach {
        it.value.compose(platform, Modifier.padding(start = indentPadding))
    }
}

@Composable
private fun background(dataModel: ReferenceDataModel, platform: Platform) {
    Button(
        onClick = { dataModel.setPage(ReferencePage.TABLE_OF_CONTENTS) },
    ) {
        Text(
            text = "Back",
        )
    }
    dataModel.playbook.backgrounds.forEach {
        it.value.compose(platform, Modifier.padding(start = indentPadding))
    }
}

@Composable
private fun role(dataModel: ReferenceDataModel, platform: Platform) {
    Button(
        onClick = { dataModel.setPage(ReferencePage.TABLE_OF_CONTENTS) },
    ) {
        Text(
            text = "Back",
        )
    }
    dataModel.playbook.roles.forEach {
        it.value.compose(platform, Modifier.padding(start = indentPadding))
    }
}

@Composable
private fun port(dataModel: ReferenceDataModel, platform: Platform) {
    Button(
        onClick = { dataModel.setPage(ReferencePage.TABLE_OF_CONTENTS) },
    ) {
        Text(
            text = "Back",
        )
    }
    dataModel.playbook.ports.forEach {
        it.value.compose(platform, Modifier.padding(start = indentPadding))
    }
}

@Composable
private fun event(dataModel: ReferenceDataModel, platform: Platform) {
    Button(
        onClick = { dataModel.setPage(ReferencePage.TABLE_OF_CONTENTS) },
    ) {
        Text(
            text = "Back",
        )
    }
    dataModel.playbook.events.forEach {
        it.value.compose(platform, Modifier.padding(start = indentPadding))
    }
}

@Composable
private fun contractItem(dataModel: ReferenceDataModel, platform: Platform) {
    Button(
        onClick = { dataModel.setPage(ReferencePage.TABLE_OF_CONTENTS) },
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
            dataModel.playbook.contractItems.forEach {
                it.value.compose(platform, Modifier.padding(start = indentPadding))
            }
        }
        Column(
            modifier = Modifier.weight(1f),
        ) {
            Text(
                text = "here:",
            )
            dataModel.playbook.contractDestinations.forEach {
                it.value.compose(platform, Modifier.padding(start = indentPadding))
            }
        }
    }
}

@Composable
private fun usefulItem(dataModel: ReferenceDataModel, platform: Platform) {
    Button(
        onClick = { dataModel.setPage(ReferencePage.TABLE_OF_CONTENTS) },
    ) {
        Text(
            text = "Back",
        )
    }
    dataModel.playbook.usefulItems.forEach {
        it.value.compose(platform, Modifier.padding(start = indentPadding))
    }
}

@Composable
private fun bastard(dataModel: ReferenceDataModel, platform: Platform) {
    Button(
        onClick = { dataModel.setPage(ReferencePage.TABLE_OF_CONTENTS) },
    ) {
        Text(
            text = "Back",
        )
    }
    dataModel.playbook.bastards.forEach {
        it.value.compose(platform, Modifier.padding(start = indentPadding))
    }
}

@Composable
private fun threat(dataModel: ReferenceDataModel, platform: Platform) {
    Button(
        onClick = { dataModel.setPage(ReferencePage.TABLE_OF_CONTENTS) },
    ) {
        Text(
            text = "Back",
        )
    }
    dataModel.playbook.threats.forEach {
        it.value.compose(platform, Modifier.padding(start = indentPadding))
    }
}
