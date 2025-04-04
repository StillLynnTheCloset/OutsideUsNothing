package com.stilllynnthecloset.outsideusnothing.reference

import androidx.compose.foundation.clickable
import androidx.compose.foundation.gestures.Orientation
import androidx.compose.foundation.gestures.draggable
import androidx.compose.foundation.gestures.rememberDraggableState
import androidx.compose.foundation.gestures.scrollBy
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.ColumnScope
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.text.selection.SelectionContainer
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.stilllynnthecloset.outsideusnothing.library.model.Playbook
import com.stilllynnthecloset.outsideusnothing.PlaybookPage
import com.stilllynnthecloset.outsideusnothing.compose
import com.stilllynnthecloset.outsideusnothing.indentPadding
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

/**
 * ReferenceScreen - TODO: Documentation
 *
 * Created by Lynn on 5/3/23
 */
@Composable
internal fun ReferenceScreen(dataModel: ReferenceViewModel) {
    val scrollState = rememberScrollState()
    val scope = rememberCoroutineScope { Dispatchers.Default }
    Column(
        modifier = Modifier
            .fillMaxSize()
            .draggable(rememberDraggableState { delta ->
                scope.launch {
                    scrollState.scrollBy(-delta)
                }
            }, orientation = Orientation.Vertical)
            .verticalScroll(scrollState)
            .padding(indentPadding),
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
            PlaybookPage.PLAYBOOK -> tableOfContents(
                dataModel,
                dataModel.mainDataModel.mergedPlaybook
            )
            PlaybookPage.ALIEN -> alien(dataModel, dataModel.mainDataModel.mergedPlaybook)
            PlaybookPage.BACKGROUND -> background(dataModel, dataModel.mainDataModel.mergedPlaybook)
            PlaybookPage.ROLE -> role(dataModel, dataModel.mainDataModel.mergedPlaybook)
            PlaybookPage.PORT -> port(dataModel, dataModel.mainDataModel.mergedPlaybook)
            PlaybookPage.EVENT -> event(dataModel, dataModel.mainDataModel.mergedPlaybook)
            PlaybookPage.CONTRACT_ITEM -> contractItem(
                dataModel,
                dataModel.mainDataModel.mergedPlaybook
            )
            PlaybookPage.USEFUL_ITEM -> usefulItem(
                dataModel,
                dataModel.mainDataModel.mergedPlaybook
            )
            PlaybookPage.BASTARD -> bastard(dataModel, dataModel.mainDataModel.mergedPlaybook)
            PlaybookPage.THREAT -> threat(dataModel, dataModel.mainDataModel.mergedPlaybook)
            PlaybookPage.PORT_NAME -> portName(dataModel, dataModel.mainDataModel.mergedPlaybook)
            PlaybookPage.NPC_LABEL -> npcLabel(dataModel, dataModel.mainDataModel.mergedPlaybook)
            PlaybookPage.FLAVOR_TEXT -> flavorText(
                dataModel,
                dataModel.mainDataModel.mergedPlaybook
            )
        }
    }
}

@Composable
private fun ColumnScope.tableOfContents(dataModel: ReferenceViewModel, playbook: Playbook) {
    PlaybookPage.entries.forEach {
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
private fun alien(dataModel: ReferenceViewModel, playbook: Playbook) {
    Button(
        onClick = { dataModel.setPage(PlaybookPage.PLAYBOOK) },
    ) {
        Text(
            text = "Back",
        )
    }
    playbook.aliens.forEach {
        SelectionContainer {
            it.value.compose(Modifier.padding(start = indentPadding))
        }
    }
}

@Composable
private fun background(dataModel: ReferenceViewModel, playbook: Playbook) {
    Button(
        onClick = { dataModel.setPage(PlaybookPage.PLAYBOOK) },
    ) {
        Text(
            text = "Back",
        )
    }
    playbook.backgrounds.forEach {
        SelectionContainer {
            it.value.compose(Modifier.padding(start = indentPadding))
        }
    }
}

@Composable
private fun role(dataModel: ReferenceViewModel, playbook: Playbook) {
    Button(
        onClick = { dataModel.setPage(PlaybookPage.PLAYBOOK) },
    ) {
        Text(
            text = "Back",
        )
    }
    playbook.roles.forEach {
        SelectionContainer {
            it.value.compose(Modifier.padding(start = indentPadding))
        }
    }
}

@Composable
private fun port(dataModel: ReferenceViewModel, playbook: Playbook) {
    Button(
        onClick = { dataModel.setPage(PlaybookPage.PLAYBOOK) },
    ) {
        Text(
            text = "Back",
        )
    }
    playbook.ports.forEach {
        SelectionContainer {
            it.value.compose(Modifier.padding(start = indentPadding))
        }
    }
}

@Composable
private fun event(dataModel: ReferenceViewModel, playbook: Playbook) {
    Button(
        onClick = { dataModel.setPage(PlaybookPage.PLAYBOOK) },
    ) {
        Text(
            text = "Back",
        )
    }
    playbook.events.forEach {
        SelectionContainer {
            it.value.compose(Modifier.padding(start = indentPadding))
        }
    }
}

@Composable
private fun contractItem(dataModel: ReferenceViewModel, playbook: Playbook) {
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
                SelectionContainer {
                    it.value.compose(Modifier.padding(start = indentPadding))
                }
            }
        }
        Column(
            modifier = Modifier.weight(1f),
        ) {
            Text(
                text = "here:",
            )
            playbook.contractDestinations.forEach {
                SelectionContainer {
                    it.value.compose(Modifier.padding(start = indentPadding))
                }
            }
        }
    }
}

@Composable
private fun usefulItem(dataModel: ReferenceViewModel, playbook: Playbook) {
    Button(
        onClick = { dataModel.setPage(PlaybookPage.PLAYBOOK) },
    ) {
        Text(
            text = "Back",
        )
    }
    playbook.usefulItems.forEach {
        SelectionContainer {
            it.value.compose(Modifier.padding(start = indentPadding))
        }
    }
}

@Composable
private fun bastard(dataModel: ReferenceViewModel, playbook: Playbook) {
    Button(
        onClick = { dataModel.setPage(PlaybookPage.PLAYBOOK) },
    ) {
        Text(
            text = "Back",
        )
    }
    playbook.bastards.forEach {
        SelectionContainer {
            it.value.compose(Modifier.padding(start = indentPadding))
        }
    }
}

@Composable
private fun threat(dataModel: ReferenceViewModel, playbook: Playbook) {
    Button(
        onClick = { dataModel.setPage(PlaybookPage.PLAYBOOK) },
    ) {
        Text(
            text = "Back",
        )
    }
    playbook.threats.forEach {
        SelectionContainer {
            it.value.compose(Modifier.padding(start = indentPadding))
        }
    }
}

@Composable
private fun portName(dataModel: ReferenceViewModel, playbook: Playbook) {
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
            playbook.portAdjectives.forEach {
                SelectionContainer {
                    Text(
                        text = it.value.text,
                        modifier = Modifier.padding(start = indentPadding),
                    )
                }
            }
        }
        Column(
            modifier = Modifier.weight(1f),
        ) {
            Text(
                text = "here:",
            )
            playbook.portNouns.forEach {
                SelectionContainer {
                    Text(
                        text = it.value.text,
                        modifier = Modifier.padding(start = indentPadding),
                    )
                }
            }
        }
    }
}

@Composable
private fun npcLabel(dataModel: ReferenceViewModel, playbook: Playbook) {
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
            playbook.npcAdjectives.forEach {
                SelectionContainer {
                    Text(
                        text = it.value.text,
                        modifier = Modifier.padding(start = indentPadding),
                    )
                }
            }
        }
        Column(
            modifier = Modifier.weight(1f),
        ) {
            Text(
                text = "here:",
            )
            playbook.npcNouns.forEach {
                SelectionContainer {
                    Text(
                        text = it.value.text,
                        modifier = Modifier.padding(start = indentPadding),
                    )
                }
            }
        }
    }
}

@Composable
private fun flavorText(dataModel: ReferenceViewModel, playbook: Playbook) {
    Button(
        onClick = { dataModel.setPage(PlaybookPage.PLAYBOOK) },
    ) {
        Text(
            text = "Back",
        )
    }
    playbook.flavorTexts.forEach {
        SelectionContainer {
            it.value.compose(Modifier.padding(start = indentPadding))
        }
    }
}
