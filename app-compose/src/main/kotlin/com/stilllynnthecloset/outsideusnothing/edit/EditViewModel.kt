package com.stilllynnthecloset.outsideusnothing.edit

import com.stilllynnthecloset.liboun.model.Playbook
import com.stilllynnthecloset.outsideusnothing.MainDataModel

/**
 * EditViewModel - TODO: Documentation
 *
 * Created by Lynn on 5/5/23
 */
internal class EditViewModel constructor(val mainDataModel: MainDataModel) {
    fun changePlaybookState(playbook: Playbook, active: Boolean) {
        mainDataModel.setPlaybookState(playbook, active)
    }
}
