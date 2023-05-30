package com.stilllynnthecloset.outsideusnothing.edit

import com.stilllynnthecloset.outsideusnothing.library.model.Author
import com.stilllynnthecloset.outsideusnothing.library.model.Bastard
import com.stilllynnthecloset.outsideusnothing.library.model.ContractDestination
import com.stilllynnthecloset.outsideusnothing.library.model.ContractItem
import com.stilllynnthecloset.outsideusnothing.library.model.FlavorText
import com.stilllynnthecloset.outsideusnothing.library.model.NpcAdjective
import com.stilllynnthecloset.outsideusnothing.library.model.NpcType
import com.stilllynnthecloset.outsideusnothing.library.model.Playbook
import com.stilllynnthecloset.outsideusnothing.library.model.PortAdjective
import com.stilllynnthecloset.outsideusnothing.library.model.PortType
import com.stilllynnthecloset.outsideusnothing.library.model.Threat
import com.stilllynnthecloset.outsideusnothing.library.model.Weighted
import com.stilllynnthecloset.outsideusnothing.MainDataModel
import com.stilllynnthecloset.outsideusnothing.PlaybookPage
import com.stilllynnthecloset.outsideusnothing.WindowDataModel

/**
 * EditViewModel - TODO: Documentation
 *
 * Created by Lynn on 5/5/23
 */
internal class EditViewModel constructor(private val mainDataModel: MainDataModel, private val windowDataModel: WindowDataModel, val currentPage: PlaybookPage, val playbookUuid: String) {
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
        mainDataModel.updatePlaybook(
            currentPlaybook.copy(
                threats = currentPlaybook.threats.map {
                    if (it.value.uuid == new.value.uuid) {
                        Weighted(new.weight, it.value.copy(name = new.value.name))
                    } else {
                        it
                    }
                },
            ),
        )
    }

    fun addThreat(new: Weighted<Threat>) {
        mainDataModel.updatePlaybook(
            currentPlaybook.copy(
                threats = currentPlaybook.threats + new,
            ),
        )
    }

    fun removeThreat(new: Weighted<Threat>) {
        mainDataModel.updatePlaybook(
            currentPlaybook.copy(
                threats = currentPlaybook.threats - new,
            ),
        )
    }

    fun updatePortAdjective(new: Weighted<PortAdjective>) {
        mainDataModel.updatePlaybook(
            currentPlaybook.copy(
                portAdjectives = currentPlaybook.portAdjectives.map {
                    if (it.value.uuid == new.value.uuid) {
                        new
                    } else {
                        it
                    }
                },
            ),
        )
    }

    fun addPortAdjective(new: Weighted<PortAdjective>) {
        mainDataModel.updatePlaybook(
            currentPlaybook.copy(
                portAdjectives = currentPlaybook.portAdjectives + new,
            ),
        )
    }

    fun removePortAdjective(new: Weighted<PortAdjective>) {
        mainDataModel.updatePlaybook(
            currentPlaybook.copy(
                portAdjectives = currentPlaybook.portAdjectives - new,
            ),
        )
    }

    fun updatePortType(new: Weighted<PortType>) {
        mainDataModel.updatePlaybook(
            currentPlaybook.copy(
                portTypes = currentPlaybook.portTypes.map {
                    if (it.value.uuid == new.value.uuid) {
                        new
                    } else {
                        it
                    }
                },
            ),
        )
    }

    fun addPortType(new: Weighted<PortType>) {
        mainDataModel.updatePlaybook(
            currentPlaybook.copy(
                portTypes = currentPlaybook.portTypes + new,
            ),
        )
    }

    fun removePortType(new: Weighted<PortType>) {
        mainDataModel.updatePlaybook(
            currentPlaybook.copy(
                portTypes = currentPlaybook.portTypes - new,
            ),
        )
    }

    fun updateNpcAdjective(new: Weighted<NpcAdjective>) {
        mainDataModel.updatePlaybook(
            currentPlaybook.copy(
                npcAdjectives = currentPlaybook.npcAdjectives.map {
                    if (it.value.uuid == new.value.uuid) {
                        new
                    } else {
                        it
                    }
                },
            ),
        )
    }

    fun addNpcAdjective(new: Weighted<NpcAdjective>) {
        mainDataModel.updatePlaybook(
            currentPlaybook.copy(
                npcAdjectives = currentPlaybook.npcAdjectives + new,
            ),
        )
    }

    fun removeNpcAdjective(new: Weighted<NpcAdjective>) {
        mainDataModel.updatePlaybook(
            currentPlaybook.copy(
                npcAdjectives = currentPlaybook.npcAdjectives - new,
            ),
        )
    }

    fun updateNpcName(new: Weighted<NpcType>) {
        mainDataModel.updatePlaybook(
            currentPlaybook.copy(
                npcTypes = currentPlaybook.npcTypes.map {
                    if (it.value.uuid == new.value.uuid) {
                        new
                    } else {
                        it
                    }
                },
            ),
        )
    }

    fun addNpcName(new: Weighted<NpcType>) {
        mainDataModel.updatePlaybook(
            currentPlaybook.copy(
                npcTypes = currentPlaybook.npcTypes + new,
            ),
        )
    }

    fun removeNpcName(new: Weighted<NpcType>) {
        mainDataModel.updatePlaybook(
            currentPlaybook.copy(
                npcTypes = currentPlaybook.npcTypes - new,
            ),
        )
    }

    fun updateContractItem(new: Weighted<ContractItem>) {
        mainDataModel.updatePlaybook(
            currentPlaybook.copy(
                contractItems = currentPlaybook.contractItems.map {
                    if (it.value.uuid == new.value.uuid) {
                        new
                    } else {
                        it
                    }
                },
            ),
        )
    }

    fun addContractItem(new: Weighted<ContractItem>) {
        mainDataModel.updatePlaybook(
            currentPlaybook.copy(
                contractItems = currentPlaybook.contractItems + new,
            ),
        )
    }

    fun removeContractItem(new: Weighted<ContractItem>) {
        mainDataModel.updatePlaybook(
            currentPlaybook.copy(
                contractItems = currentPlaybook.contractItems - new,
            ),
        )
    }

    fun updateContractDestination(new: Weighted<ContractDestination>) {
        mainDataModel.updatePlaybook(
            currentPlaybook.copy(
                contractDestinations = currentPlaybook.contractDestinations.map {
                    if (it.value.uuid == new.value.uuid) {
                        new
                    } else {
                        it
                    }
                },
            ),
        )
    }

    fun addContractDestination(new: Weighted<ContractDestination>) {
        mainDataModel.updatePlaybook(
            currentPlaybook.copy(
                contractDestinations = currentPlaybook.contractDestinations + new,
            ),
        )
    }

    fun removeContractDestination(new: Weighted<ContractDestination>) {
        mainDataModel.updatePlaybook(
            currentPlaybook.copy(
                contractDestinations = currentPlaybook.contractDestinations - new,
            ),
        )
    }

    fun updateFlavorText(new: Weighted<FlavorText>) {
        mainDataModel.updatePlaybook(
            currentPlaybook.copy(
                flavorTexts = currentPlaybook.flavorTexts.map {
                    if (it.value.uuid == new.value.uuid) {
                        new
                    } else {
                        it
                    }
                },
            ),
        )
    }

    fun addFlavorText(new: Weighted<FlavorText>) {
        mainDataModel.updatePlaybook(
            currentPlaybook.copy(
                flavorTexts = currentPlaybook.flavorTexts + new,
            ),
        )
    }

    fun removeFlavorText(new: Weighted<FlavorText>) {
        mainDataModel.updatePlaybook(
            currentPlaybook.copy(
                flavorTexts = currentPlaybook.flavorTexts - new,
            ),
        )
    }

    fun updateBastard(new: Weighted<Bastard>) {
        mainDataModel.updatePlaybook(
            currentPlaybook.copy(
                bastards = currentPlaybook.bastards.map {
                    if (it.value.uuid == new.value.uuid) {
                        new
                    } else {
                        it
                    }
                },
            ),
        )
    }

    fun addBastard(new: Weighted<Bastard>) {
        mainDataModel.updatePlaybook(
            currentPlaybook.copy(
                bastards = currentPlaybook.bastards + new,
            ),
        )
    }

    fun removeBastard(new: Weighted<Bastard>) {
        mainDataModel.updatePlaybook(
            currentPlaybook.copy(
                bastards = currentPlaybook.bastards - new,
            ),
        )
    }
}
