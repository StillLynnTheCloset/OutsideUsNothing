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
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.stilllynnthecloset.outsideusnothing.PlaybookPage
import com.stilllynnthecloset.outsideusnothing.WindowViewModel
import com.stilllynnthecloset.outsideusnothing.compose
import com.stilllynnthecloset.outsideusnothing.indentPadding
import com.stilllynnthecloset.outsideusnothing.library.model.EventSpecification
import com.stilllynnthecloset.outsideusnothing.library.model.PlaySheetSpecification
import com.stilllynnthecloset.outsideusnothing.library.model.Playbook
import com.stilllynnthecloset.outsideusnothing.library.model.PortOfCallSpecification
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

/**
 * ReferenceScreen - TODO: Documentation
 *
 * Created by Lynn on 5/3/23
 */
@Composable
internal fun ReferenceScreen(windowViewModel: WindowViewModel, dataModel: ReferenceViewModel) {
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
        if (dataModel.subpage == null) {
            when (dataModel.currentPage) {
                PlaybookPage.PLAYBOOK -> tableOfContents(windowViewModel)
                PlaybookPage.ALIEN -> alien(windowViewModel, dataModel.mainDataModel.mergedPlaybook)
                PlaybookPage.BACKGROUND -> background(
                    windowViewModel,
                    dataModel.mainDataModel.mergedPlaybook
                )

                PlaybookPage.ROLE -> role(windowViewModel, dataModel.mainDataModel.mergedPlaybook)
                PlaybookPage.PORT -> port(windowViewModel, dataModel.mainDataModel.mergedPlaybook)
                PlaybookPage.EVENT -> event(windowViewModel, dataModel.mainDataModel.mergedPlaybook)
                PlaybookPage.CONTRACT_ITEM -> contractItem(dataModel.mainDataModel.mergedPlaybook)
                PlaybookPage.USEFUL_ITEM -> usefulItem(dataModel.mainDataModel.mergedPlaybook)
                PlaybookPage.BASTARD -> bastard(dataModel.mainDataModel.mergedPlaybook)
                PlaybookPage.THREAT -> threat(dataModel.mainDataModel.mergedPlaybook)
                PlaybookPage.PORT_NAME -> portName(dataModel.mainDataModel.mergedPlaybook)
                PlaybookPage.NPC_LABEL -> npcLabel(dataModel.mainDataModel.mergedPlaybook)
                PlaybookPage.FLAVOR_TEXT -> flavorText(dataModel.mainDataModel.mergedPlaybook)
            }
        } else {
            when (dataModel.currentPage) {
                PlaybookPage.ALIEN -> alienSpecific(dataModel.subpage as PlaySheetSpecification)
                PlaybookPage.BACKGROUND -> backgroundSpecific(dataModel.subpage as PlaySheetSpecification)
                PlaybookPage.ROLE -> roleSpecific(dataModel.subpage as PlaySheetSpecification)
                PlaybookPage.PORT -> portSpecific(dataModel.subpage as PortOfCallSpecification)
                PlaybookPage.EVENT -> eventSpecific(dataModel.subpage as EventSpecification)
                else -> {
                    throw IllegalArgumentException("${dataModel.currentPage} does not support subpages, but subpage is ${dataModel.subpage}")
                }
            }
        }
    }
}

@Composable
private fun ColumnScope.tableOfContents(windowViewModel: WindowViewModel) {
    PlaybookPage.entries.forEach {
        if (it != PlaybookPage.PLAYBOOK) {
            Text(
                text = it.humanReadable,
                fontSize = 32.sp,
                modifier = Modifier
                    .align(Alignment.CenterHorizontally)
                    .clickable {
                        windowViewModel.openReferencePlaybook(it)
                    },
            )
        }
    }
}

@Composable
private fun ColumnScope.alien(windowViewModel: WindowViewModel, playbook: Playbook) {
    playbook.aliens.forEach {
        Text(
            text = it.value.name,
            fontSize = 32.sp,
            modifier = Modifier
                .align(Alignment.CenterHorizontally)
                .clickable {
                    windowViewModel.openReferencePlaybook(PlaybookPage.ALIEN, it.value)
                },
        )
    }
}

@Composable
private fun ColumnScope.alienSpecific(subPage: PlaySheetSpecification) {
    SelectionContainer {
        subPage.compose(Modifier.padding(start = indentPadding))
    }
}

@Composable
private fun ColumnScope.background(windowViewModel: WindowViewModel, playbook: Playbook) {
    playbook.backgrounds.forEach {
        Text(
            text = it.value.name,
            fontSize = 32.sp,
            modifier = Modifier
                .align(Alignment.CenterHorizontally)
                .clickable {
                    windowViewModel.openReferencePlaybook(PlaybookPage.BACKGROUND, it.value)
                },
        )
    }
}

@Composable
private fun ColumnScope.backgroundSpecific(subPage: PlaySheetSpecification) {
    SelectionContainer {
        subPage.compose(Modifier.padding(start = indentPadding))
    }
}

@Composable
private fun ColumnScope.role(windowViewModel: WindowViewModel, playbook: Playbook) {
    playbook.roles.forEach {
        Text(
            text = it.value.name,
            fontSize = 32.sp,
            modifier = Modifier
                .align(Alignment.CenterHorizontally)
                .clickable {
                    windowViewModel.openReferencePlaybook(PlaybookPage.ROLE, it.value)
                },
        )
    }
}

@Composable
private fun ColumnScope.roleSpecific(subPage: PlaySheetSpecification) {
    SelectionContainer {
        subPage.compose(Modifier.padding(start = indentPadding))
    }
}

@Composable
private fun ColumnScope.port(windowViewModel: WindowViewModel, playbook: Playbook) {
    playbook.ports.forEach {
        Text(
            text = it.value.name,
            fontSize = 32.sp,
            modifier = Modifier
                .align(Alignment.CenterHorizontally)
                .clickable {
                    windowViewModel.openReferencePlaybook(PlaybookPage.PORT, it.value)
                },
        )
    }
}

@Composable
private fun ColumnScope.portSpecific(subPage: PortOfCallSpecification) {
    SelectionContainer {
        subPage.compose(Modifier.padding(start = indentPadding))
    }
}

@Composable
private fun ColumnScope.event(windowViewModel: WindowViewModel, playbook: Playbook) {
    playbook.events.forEach {
        Text(
            text = it.value.name,
            fontSize = 32.sp,
            modifier = Modifier
                .align(Alignment.CenterHorizontally)
                .clickable {
                    windowViewModel.openReferencePlaybook(PlaybookPage.EVENT, it.value)
                },
        )
    }
}

@Composable
private fun ColumnScope.eventSpecific(subPage: EventSpecification) {
    SelectionContainer {
        subPage.compose(Modifier.padding(start = indentPadding))
    }
}

@Composable
private fun ColumnScope.contractItem(playbook: Playbook) {
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
private fun ColumnScope.usefulItem(playbook: Playbook) {
    playbook.usefulItems.forEach {
        SelectionContainer {
            it.value.compose(Modifier.padding(start = indentPadding))
        }
    }
}

@Composable
private fun ColumnScope.bastard(playbook: Playbook) {
    playbook.bastards.forEach {
        SelectionContainer {
            it.value.compose(Modifier.padding(start = indentPadding))
        }
    }
}

@Composable
private fun ColumnScope.threat(playbook: Playbook) {
    playbook.threats.forEach {
        SelectionContainer {
            it.value.compose(Modifier.padding(start = indentPadding))
        }
    }
}

@Composable
private fun ColumnScope.portName(playbook: Playbook) {
    Row {
        Column(
            modifier = Modifier.weight(1f),
        ) {
            Text(
                text = "Adjective:",
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
                text = "Noun:",
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
private fun ColumnScope.npcLabel(playbook: Playbook) {
    Row {
        Column(
            modifier = Modifier.weight(1f),
        ) {
            Text(
                text = "Adjective:",
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
                text = "Noun:",
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
private fun ColumnScope.flavorText(playbook: Playbook) {
    playbook.flavorTexts.forEach {
        SelectionContainer {
            it.value.compose(Modifier.padding(start = indentPadding))
        }
    }
}
