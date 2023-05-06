package com.stilllynnthecloset.outsideusnothing.edit

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.material3.Checkbox
import androidx.compose.runtime.Composable
import com.stilllynnthecloset.liboun.model.Playbook
import com.stilllynnthecloset.outsideusnothing.Platform
import com.stilllynnthecloset.outsideusnothing.compose

/**
 * EditScreen - TODO: Documentation
 *
 * Created by Lynn on 5/5/23
 */
@Composable
internal fun EditScreen(dataModel: EditViewModel, platform: Platform) {
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
