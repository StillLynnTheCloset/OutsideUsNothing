package com.stilllynnthecloset.outsideusnothing.edit

import com.stilllynnthecloset.liboun.model.Author
import com.stilllynnthecloset.liboun.model.ContractDestination
import com.stilllynnthecloset.liboun.model.ContractItem
import com.stilllynnthecloset.liboun.model.NpcAdjective
import com.stilllynnthecloset.liboun.model.NpcType
import com.stilllynnthecloset.liboun.model.Playbook
import com.stilllynnthecloset.liboun.model.PortAdjective
import com.stilllynnthecloset.liboun.model.PortType
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
        get() = mainDataModel.getPlaybooks().first { it.uuid == playbookUuid }

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

    fun updateThreat(new: Weighted<Threat>) {
        mainDataModel.updatePlaybook(currentPlaybook.copy(
            threats = currentPlaybook.threats.map {
                if (it.value.uuid == new.value.uuid) {
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

    fun updatePortAdjective(new: Weighted<PortAdjective>) {
        mainDataModel.updatePlaybook(currentPlaybook.copy(
            portAdjectives = currentPlaybook.portAdjectives.map {
                if (it.value.uuid == new.value.uuid) {
                    new
                } else {
                    it
                }
            }
        ))
    }

    fun addPortAdjective(new: Weighted<PortAdjective>) {
        mainDataModel.updatePlaybook(
            currentPlaybook.copy(
                portAdjectives = currentPlaybook.portAdjectives + new
            )
        )
    }

    fun removePortAdjective(new: Weighted<PortAdjective>) {
        mainDataModel.updatePlaybook(
            currentPlaybook.copy(
                portAdjectives = currentPlaybook.portAdjectives - new
            )
        )
    }

    fun updatePortType(new: Weighted<PortType>) {
        mainDataModel.updatePlaybook(currentPlaybook.copy(
            portTypes = currentPlaybook.portTypes.map {
                if (it.value.uuid == new.value.uuid) {
                    new
                } else {
                    it
                }
            }
        ))
    }

    fun addPortType(new: Weighted<PortType>) {
        mainDataModel.updatePlaybook(
            currentPlaybook.copy(
                portTypes = currentPlaybook.portTypes + new
            )
        )
    }

    fun removePortType(new: Weighted<PortType>) {
        mainDataModel.updatePlaybook(
            currentPlaybook.copy(
                portTypes = currentPlaybook.portTypes - new
            )
        )
    }

    fun updateNpcAdjective(new: Weighted<NpcAdjective>) {
        mainDataModel.updatePlaybook(currentPlaybook.copy(
            npcAdjectives = currentPlaybook.npcAdjectives.map {
                if (it.value.uuid == new.value.uuid) {
                    new
                } else {
                    it
                }
            }
        ))
    }

    fun addNpcAdjective(new: Weighted<NpcAdjective>) {
        mainDataModel.updatePlaybook(
            currentPlaybook.copy(
                npcAdjectives = currentPlaybook.npcAdjectives + new
            )
        )
    }

    fun removeNpcAdjective(new: Weighted<NpcAdjective>) {
        mainDataModel.updatePlaybook(
            currentPlaybook.copy(
                npcAdjectives = currentPlaybook.npcAdjectives - new
            )
        )
    }

    fun updateNpcName(new: Weighted<NpcType>) {
        mainDataModel.updatePlaybook(currentPlaybook.copy(
            npcTypes = currentPlaybook.npcTypes.map {
                if (it.value.uuid == new.value.uuid) {
                    new
                } else {
                    it
                }
            }
        ))
    }

    fun addNpcName(new: Weighted<NpcType>) {
        mainDataModel.updatePlaybook(
            currentPlaybook.copy(
                npcTypes = currentPlaybook.npcTypes + new
            )
        )
    }

    fun removeNpcName(new: Weighted<NpcType>) {
        mainDataModel.updatePlaybook(
            currentPlaybook.copy(
                npcTypes = currentPlaybook.npcTypes - new
            )
        )
    }

    fun updateContractItem(new: Weighted<ContractItem>) {
        mainDataModel.updatePlaybook(currentPlaybook.copy(
            contractItems = currentPlaybook.contractItems.map {
                if (it.value.uuid == new.value.uuid) {
                    new
                } else {
                    it
                }
            }
        ))
    }

    fun addContractItem(new: Weighted<ContractItem>) {
        mainDataModel.updatePlaybook(
            currentPlaybook.copy(
                contractItems = currentPlaybook.contractItems + new
            )
        )
    }

    fun removeContractItem(new: Weighted<ContractItem>) {
        mainDataModel.updatePlaybook(
            currentPlaybook.copy(
                contractItems = currentPlaybook.contractItems - new
            )
        )
    }

    fun updateContractDestination(new: Weighted<ContractDestination>) {
        mainDataModel.updatePlaybook(currentPlaybook.copy(
            contractDestinations = currentPlaybook.contractDestinations.map {
                if (it.value.uuid == new.value.uuid) {
                    new
                } else {
                    it
                }
            }
        ))
    }

    fun addContractDestination(new: Weighted<ContractDestination>) {
        mainDataModel.updatePlaybook(
            currentPlaybook.copy(
                contractDestinations = currentPlaybook.contractDestinations + new
            )
        )
    }

    fun removeContractDestination(new: Weighted<ContractDestination>) {
        mainDataModel.updatePlaybook(
            currentPlaybook.copy(
                contractDestinations = currentPlaybook.contractDestinations - new
            )
        )
    }
}
