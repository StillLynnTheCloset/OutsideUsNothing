package com.stilllynnthecloset.outsideusnothing.edit

import com.stilllynnthecloset.outsideusnothing.library.model.Author
import com.stilllynnthecloset.outsideusnothing.library.model.Bastard
import com.stilllynnthecloset.outsideusnothing.library.model.ContractDestination
import com.stilllynnthecloset.outsideusnothing.library.model.ContractItem
import com.stilllynnthecloset.outsideusnothing.library.model.FlavorText
import com.stilllynnthecloset.outsideusnothing.library.model.NpcAdjective
import com.stilllynnthecloset.outsideusnothing.library.model.NpcNoun
import com.stilllynnthecloset.outsideusnothing.library.model.Playbook
import com.stilllynnthecloset.outsideusnothing.library.model.PortAdjective
import com.stilllynnthecloset.outsideusnothing.library.model.PortNoun
import com.stilllynnthecloset.outsideusnothing.library.model.Threat
import com.stilllynnthecloset.outsideusnothing.library.tools.Weighted
import com.stilllynnthecloset.outsideusnothing.MainDataModel
import com.stilllynnthecloset.outsideusnothing.PlaybookPage
import com.stilllynnthecloset.outsideusnothing.WindowDataModel
import com.stilllynnthecloset.outsideusnothing.library.tools.replace

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
                threats = currentPlaybook.threats.replace(new),
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
                portAdjectives = currentPlaybook.portAdjectives.replace(new),
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

    fun updatePortType(new: Weighted<PortNoun>) {
        mainDataModel.updatePlaybook(
            currentPlaybook.copy(
                portNouns = currentPlaybook.portNouns.replace(new),
            ),
        )
    }

    fun addPortType(new: Weighted<PortNoun>) {
        mainDataModel.updatePlaybook(
            currentPlaybook.copy(
                portNouns = currentPlaybook.portNouns + new,
            ),
        )
    }

    fun removePortType(new: Weighted<PortNoun>) {
        mainDataModel.updatePlaybook(
            currentPlaybook.copy(
                portNouns = currentPlaybook.portNouns - new,
            ),
        )
    }

    fun updateNpcAdjective(new: Weighted<NpcAdjective>) {
        mainDataModel.updatePlaybook(
            currentPlaybook.copy(
                npcAdjectives = currentPlaybook.npcAdjectives.replace(new),
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

    fun updateNpcName(new: Weighted<NpcNoun>) {
        mainDataModel.updatePlaybook(
            currentPlaybook.copy(
                npcNouns = currentPlaybook.npcNouns.replace(new),
            ),
        )
    }

    fun addNpcName(new: Weighted<NpcNoun>) {
        mainDataModel.updatePlaybook(
            currentPlaybook.copy(
                npcNouns = currentPlaybook.npcNouns + new,
            ),
        )
    }

    fun removeNpcName(new: Weighted<NpcNoun>) {
        mainDataModel.updatePlaybook(
            currentPlaybook.copy(
                npcNouns = currentPlaybook.npcNouns - new,
            ),
        )
    }

    fun updateContractItem(new: Weighted<ContractItem>) {
        mainDataModel.updatePlaybook(
            currentPlaybook.copy(
                contractItems = currentPlaybook.contractItems.replace(new),
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
                contractDestinations = currentPlaybook.contractDestinations.replace(new),
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
                flavorTexts = currentPlaybook.flavorTexts.replace(new),
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
                bastards = currentPlaybook.bastards.replace(new),
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
