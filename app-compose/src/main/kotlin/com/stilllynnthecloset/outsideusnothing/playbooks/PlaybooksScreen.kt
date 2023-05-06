package com.stilllynnthecloset.outsideusnothing.playbooks

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.material3.Checkbox
import androidx.compose.runtime.Composable
import com.stilllynnthecloset.liboun.model.Playbook
import com.stilllynnthecloset.outsideusnothing.Platform
import com.stilllynnthecloset.outsideusnothing.compose

/**
 * PlaybooksScreen - TODO: Documentation
 *
 * Created by Lynn on 5/5/23
 */
@Composable
internal fun PlaybooksScreen(dataModel: PlaybooksViewModel, platform: Platform) {
    Column {
        dataModel.mainDataModel.playbooks.forEach { playbook ->
            Row {
                Checkbox(
                    checked = playbook.active,
                    enabled = playbook.uuid != Playbook.defaultPlaybook.uuid,
                    onCheckedChange = { dataModel.changePlaybookState(playbook, it) },
                )
                playbook.compose(platform, true)
            }
        }
    }
}
