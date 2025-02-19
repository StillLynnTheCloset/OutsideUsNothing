package com.stilllynnthecloset.outsideusnothing.playbooks

import androidx.compose.foundation.gestures.Orientation
import androidx.compose.foundation.gestures.draggable
import androidx.compose.foundation.gestures.rememberDraggableState
import androidx.compose.foundation.gestures.scrollBy
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.sp
import com.stilllynnthecloset.outsideusnothing.library.model.Playbook
import com.stilllynnthecloset.outsideusnothing.MainDataModel
import com.stilllynnthecloset.outsideusnothing.Platform
import com.stilllynnthecloset.outsideusnothing.WindowViewModel
import com.stilllynnthecloset.outsideusnothing.compose
import com.stilllynnthecloset.outsideusnothing.indentPadding
import com.stilllynnthecloset.outsideusnothing.theme.ImageReference
import com.stilllynnthecloset.outsideusnothing.theme.imageButton
import kotlinx.coroutines.runBlocking
import java.util.UUID

/**
 * PlaybooksScreen - TODO: Documentation
 *
 * Created by Lynn on 5/5/23
 */
@Composable
internal fun PlaybooksScreen(
    mainDataModel: MainDataModel,
    windowViewModel: WindowViewModel,
    dataModel: PlaybooksViewModel,
    platform: Platform,
) {
    val scrollState = rememberScrollState()
    Column(
        modifier = Modifier
            .fillMaxSize()
            .draggable(rememberDraggableState { delta ->
                runBlocking {
                    scrollState.scrollBy(-delta)
                }
            }, orientation = Orientation.Vertical)
            .verticalScroll(scrollState)
            .padding(indentPadding),
    ) {
        Row {
            Text(
                text = "Play Books",
                fontSize = 32.sp,
            )

            imageButton(
                onClick = {
                    val playbook = Playbook(
                        name = "",
                        description = "",
                        authors = listOf(),
                        uuid = UUID.randomUUID().toString(),
                    )
                    mainDataModel.addPlaybook(playbook)
                    windowViewModel.openEditPlaybook(playbook.uuid)
                },
                contentDescription = "Add",
                imageReference = ImageReference.Add,
                platform = platform,
            )
        }
        dataModel.mainDataModel.getPlaybooks().forEach { playbook ->
            Row(
                modifier = Modifier.padding(start = indentPadding),
            ) {
                imageButton(
                    onClick = {
                        dataModel.changePlaybookState(playbook, !playbook.active)
                    },
                    enabled = playbook.uuid != Playbook.defaultPlaybook.uuid,
                    contentDescription = "Active",
                    imageReference = if (playbook.active) ImageReference.RadioButtonChecked else ImageReference.RadioButtonUnchecked,
                    platform = platform,
                )

                imageButton(
                    onClick = {
                        windowViewModel.openEditPlaybook(playbook.uuid)
                    },
                    contentDescription = "Edit",
                    imageReference = ImageReference.Edit,
                    platform = platform,
                )

                imageButton(
                    onClick = {
                        mainDataModel.removePlaybook(playbook)
                    },
                    enabled = playbook.uuid != Playbook.defaultPlaybook.uuid,
                    contentDescription = "Delete",
                    imageReference = ImageReference.Delete,
                    platform = platform,
                )

                playbook.compose(platform, true, modifier = Modifier.padding(start = indentPadding))
            }
        }
    }
}
