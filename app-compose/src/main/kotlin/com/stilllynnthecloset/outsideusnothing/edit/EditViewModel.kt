package com.stilllynnthecloset.outsideusnothing.edit

import com.stilllynnthecloset.liboun.model.Author
import com.stilllynnthecloset.liboun.model.Playbook
import com.stilllynnthecloset.liboun.model.Threat
import com.stilllynnthecloset.liboun.model.Weighted
import com.stilllynnthecloset.outsideusnothing.MainDataModel
import com.stilllynnthecloset.outsideusnothing.PlaybookPage
import com.stilllynnthecloset.outsideusnothing.WindowDataModel

/**
 * EditViewModel - TODO: Documentation
 *
 * Created by Lynn on 5/5/23
 */
internal class EditViewModel constructor(val mainDataModel: MainDataModel, val windowDataModel: WindowDataModel, val currentPage: PlaybookPage, val playbookUuid: String) {
    val currentPlaybook: Playbook
        get() = mainDataModel.playbooks.first { it.uuid == playbookUuid }

    fun onNameChanged(newValue: String) {
        mainDataModel.updatePlaybook(currentPlaybook.copy(name = newValue))
    }

    fun onDescriptionChanged(newValue: String) {
        mainDataModel.updatePlaybook(currentPlaybook.copy(description = newValue))
    }

    fun onAuthorsChanged(newValue: String) {
        mainDataModel.updatePlaybook(currentPlaybook.copy(authors = newValue.split(",").map { Author(it.trim()) }))
    }

    fun setPage(page: PlaybookPage) {
        windowDataModel.openEditPlaybook(playbookUuid, page)
    }

    fun updateThreat(current: Weighted<Threat>, new: Weighted<Threat>) {
        mainDataModel.updatePlaybook(currentPlaybook.copy(
            threats = currentPlaybook.threats.map {
                if (it.value.uuid == current.value.uuid) {
                    Weighted(new.weight, it.value.copy(name = new.value.name))
                } else {
                    it
                }
            }
        ))
    }

    fun addThreat(new: Weighted<Threat>) {
        mainDataModel.updatePlaybook(
            currentPlaybook.copy(
                threats = currentPlaybook.threats + new
            )
        )
    }

    fun removeThreat(new: Weighted<Threat>) {
        mainDataModel.updatePlaybook(
            currentPlaybook.copy(
                threats = currentPlaybook.threats - new
            )
        )
    }

    fun updatePortAdjective(current: Weighted<String>, new: Weighted<String>) {
        mainDataModel.updatePlaybook(currentPlaybook.copy(
            portAdjectives = currentPlaybook.portAdjectives.map {
                if (it.value == current.value) {
                    new
                } else {
                    it
                }
            }
        ))
    }

    fun addPortAdjective(new: Weighted<String>) {
        mainDataModel.updatePlaybook(
            currentPlaybook.copy(
                portAdjectives = currentPlaybook.portAdjectives + new
            )
        )
    }

    fun removePortAdjective(new: Weighted<String>) {
        mainDataModel.updatePlaybook(
            currentPlaybook.copy(
                portAdjectives = currentPlaybook.portAdjectives - new
            )
        )
    }


    fun updatePortNames(current: Weighted<String>, new: Weighted<String>) {
        mainDataModel.updatePlaybook(currentPlaybook.copy(
            portNames = currentPlaybook.portNames.map {
                if (it.value == current.value) {
                    new
                } else {
                    it
                }
            }
        ))
    }

    fun addPortNames(new: Weighted<String>) {
        mainDataModel.updatePlaybook(
            currentPlaybook.copy(
                portNames = currentPlaybook.portNames + new
            )
        )
    }

    fun removePortNames(new: Weighted<String>) {
        mainDataModel.updatePlaybook(
            currentPlaybook.copy(
                portNames = currentPlaybook.portNames - new
            )
        )
    }

}
