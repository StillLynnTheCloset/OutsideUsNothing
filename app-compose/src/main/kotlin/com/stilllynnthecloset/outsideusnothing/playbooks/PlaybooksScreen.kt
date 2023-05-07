package com.stilllynnthecloset.outsideusnothing.playbooks

import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.material3.Checkbox
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.ColorFilter
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.stilllynnthecloset.liboun.model.Playbook
import com.stilllynnthecloset.outsideusnothing.MainDataModel
import com.stilllynnthecloset.outsideusnothing.Platform
import com.stilllynnthecloset.outsideusnothing.WindowDataModel
import com.stilllynnthecloset.outsideusnothing.compose
import com.stilllynnthecloset.outsideusnothing.indentPadding
import com.stilllynnthecloset.outsideusnothing.theme.ImageReference
import java.util.UUID

/**
 * PlaybooksScreen - TODO: Documentation
 *
 * Created by Lynn on 5/5/23
 */
@Composable
internal fun PlaybooksScreen(
    mainDataModel: MainDataModel,
    windowDataModel: WindowDataModel,
    dataModel: PlaybooksViewModel,
    platform: Platform,
) {
    Column {
        Row {
            Text(
                text = "Play Books",
                fontSize = 32.sp,
            )

            Image(
                painter = platform.imagePainter.getPainter(ImageReference.Add),
                colorFilter = ColorFilter.tint(MaterialTheme.colorScheme.onSurface),
                contentDescription = "Add",
                modifier = Modifier
                    .width(24.dp)
                    .align(Alignment.Top)
                    .clickable {
                        val playbook = Playbook(
                            name = "",
                            description = "",
                            authors = listOf(),
                            uuid = UUID.randomUUID().toString()
                        )
                        mainDataModel.addPlaybook(playbook)
                        windowDataModel.openEditPlaybook(playbook)
                    },
            )
        }
        dataModel.mainDataModel.playbooks.forEach { playbook ->
            Row(
                modifier = Modifier.padding(start = indentPadding),
            ) {
                Checkbox(
                    checked = playbook.active,
                    enabled = playbook.uuid != Playbook.defaultPlaybook.uuid,
                    onCheckedChange = { dataModel.changePlaybookState(playbook, it) },
                )
                playbook.compose(platform, true)

                Image(
                    painter = platform.imagePainter.getPainter(ImageReference.Edit),
                    colorFilter = ColorFilter.tint(MaterialTheme.colorScheme.onSurface),
                    alpha = if (playbook.uuid != Playbook.defaultPlaybook.uuid) 1f else 0f,
                    contentDescription = "Edit",
                    modifier = Modifier
                        .width(24.dp)
                        .align(Alignment.Top)
                        .clickable(
                            enabled = playbook.uuid != Playbook.defaultPlaybook.uuid,
                        ) {
                            windowDataModel.openEditPlaybook(playbook)
                        },
                )

                Image(
                    painter = platform.imagePainter.getPainter(ImageReference.Delete),
                    colorFilter = ColorFilter.tint(MaterialTheme.colorScheme.onSurface),
                    alpha = if (playbook.uuid != Playbook.defaultPlaybook.uuid) 1f else 0f,
                    contentDescription = "Delete",
                    modifier = Modifier
                        .width(24.dp)
                        .align(Alignment.Top)
                        .clickable(
                            enabled = playbook.uuid != Playbook.defaultPlaybook.uuid,
                        ) {
                            mainDataModel.removePlaybook(playbook)
                        },
                )
            }
        }
    }
}
