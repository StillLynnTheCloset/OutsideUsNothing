package com.stilllynnthecloset.outsideusnothing.playbooks

import com.stilllynnthecloset.liboun.model.Playbook
import com.stilllynnthecloset.outsideusnothing.MainDataModel

/**
 * PlaybooksViewModel - TODO: Documentation
 *
 * Created by Lynn on 5/5/23
 */
internal class PlaybooksViewModel constructor(val mainDataModel: MainDataModel) {
    fun changePlaybookState(playbook: Playbook, active: Boolean) {
        mainDataModel.setPlaybookState(playbook, active)
    }
}
