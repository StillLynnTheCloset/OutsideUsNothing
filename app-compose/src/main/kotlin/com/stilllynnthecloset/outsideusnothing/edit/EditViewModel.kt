package com.stilllynnthecloset.outsideusnothing.edit

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import com.stilllynnthecloset.liboun.model.Author
import com.stilllynnthecloset.liboun.model.Playbook
import com.stilllynnthecloset.liboun.model.PortOfCall
import com.stilllynnthecloset.liboun.weightedRandom
import com.stilllynnthecloset.outsideusnothing.MainDataModel

/**
 * EditViewModel - TODO: Documentation
 *
 * Created by Lynn on 5/5/23
 */
internal class EditViewModel constructor(val mainDataModel: MainDataModel, playbook: Playbook) {
    var currentPlaybook: Playbook by mutableStateOf(playbook)
        private set

    fun onNameChanged(newValue: String) {
        currentPlaybook = currentPlaybook.copy(name = newValue)
        mainDataModel.updatePlaybook(currentPlaybook)
    }
    fun onDescriptionChanged(newValue: String) {
        currentPlaybook = currentPlaybook.copy(description = newValue)
        mainDataModel.updatePlaybook(currentPlaybook)
    }
    fun onAuthorsChanged(newValue: String) {
        currentPlaybook = currentPlaybook.copy(authors = newValue.split(",").map { Author(it.trim()) }.toSet())
        mainDataModel.updatePlaybook(currentPlaybook)
    }

}
