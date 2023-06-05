package com.stilllynnthecloset.outsideusnothing.generator

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import com.stilllynnthecloset.outsideusnothing.library.model.Bastard
import com.stilllynnthecloset.outsideusnothing.library.model.ContractDetail
import com.stilllynnthecloset.outsideusnothing.library.model.Event
import com.stilllynnthecloset.outsideusnothing.library.model.FlavorText
import com.stilllynnthecloset.outsideusnothing.library.model.HealthCondition
import com.stilllynnthecloset.outsideusnothing.library.model.Playbook
import com.stilllynnthecloset.outsideusnothing.library.model.Player
import com.stilllynnthecloset.outsideusnothing.library.model.PortOfCall
import com.stilllynnthecloset.outsideusnothing.library.model.Ship
import com.stilllynnthecloset.outsideusnothing.library.model.Threat
import com.stilllynnthecloset.outsideusnothing.library.model.UsefulItem
import com.stilllynnthecloset.outsideusnothing.library.playbook.ShipPlaybook
import com.stilllynnthecloset.outsideusnothing.library.tools.weightedRandom

/**
 * GeneratorDataModel - TODO: Documentation
 *
 * Created by Lynn on 4/14/23
 */
internal class GeneratorDataModel constructor(private val playbook: Playbook) {
    var generatedPort: PortOfCall? by mutableStateOf(null)
        private set

    fun generatePort() {
        generatedPort = playbook.ports.weightedRandom().randomize(playbook)
    }

    fun clearPort() {
        generatedPort = null
    }

    var generatedContractDetail: ContractDetail? by mutableStateOf(null)
        private set

    fun generateContractItem() {
        generatedContractDetail = ContractDetail(playbook.contractItems.weightedRandom(), playbook.contractDestinations.weightedRandom())
    }

    fun clearContractItem() {
        generatedContractDetail = null
    }

    var generatedBastard: Bastard? by mutableStateOf(null)
        private set

    fun generateBastard() {
        generatedBastard = playbook.bastards.weightedRandom()
    }

    fun clearBastard() {
        generatedBastard = null
    }

    var generatedEvent: Event? by mutableStateOf(null)
        private set

    fun generateEvent() {
        generatedEvent = playbook.events.weightedRandom().randomize()
    }

    fun clearEvent() {
        generatedEvent = null
    }

    var generatedThreat: Threat? by mutableStateOf(null)
        private set

    fun generateThreat() {
        generatedThreat = playbook.threats.weightedRandom()
    }

    fun clearThreat() {
        generatedThreat = null
    }

    var generatedUsefulItem: UsefulItem? by mutableStateOf(null)
        private set

    fun generateUsefulItem() {
        generatedUsefulItem = playbook.usefulItems.weightedRandom()
    }

    fun clearUsefulItem() {
        generatedUsefulItem = null
    }

    var generatedShip: Ship? by mutableStateOf(null)
        private set

    fun generateShip() {
        generatedShip = Ship(
            name = "Ship name here",
            fuel = (0..20).random(),
            supplies = (0..20).random(),
            condition = HealthCondition.values().random(),
            playSheet = ShipPlaybook.shipPlaySheetSpecification.randomize(),
        )
    }

    fun clearShip() {
        generatedShip = null
    }

    var generatedPlayer: Player? by mutableStateOf(null)
        private set

    fun generatePlayer() {
        generatedPlayer = Player(
            name = "Lorem",
            dicePool = (0..20).random(),
            condition = HealthCondition.values().random(),
            playSheets = listOf(
                playbook.aliens.weightedRandom().randomize(),
                playbook.backgrounds.weightedRandom().randomize(),
                playbook.roles.weightedRandom().randomize(),
            ),
            items = emptyList(),
        )
    }

    fun clearPlayer() {
        generatedPlayer = null
    }

    var generatedFlavorText: FlavorText? by mutableStateOf(null)
        private set

    fun generateFlavorText() {
        generatedFlavorText = playbook.flavorTexts.weightedRandom()
    }

    fun clearFlavorText() {
        generatedFlavorText = null
    }

    var generatedLocationName: String? by mutableStateOf(null)
        private set

    fun generateLocationName() {
        generatedLocationName = "${playbook.portAdjectives.weightedRandom().text} ${playbook.portTypes.weightedRandom().text}"
    }

    fun clearLocationName() {
        generatedLocationName = null
    }

    var generatedNpc: String? by mutableStateOf(null)
        private set

    fun generateNpc() {
        generatedNpc = "${playbook.npcAdjectives.weightedRandom().text} ${playbook.npcTypes.weightedRandom().text}"
    }

    fun clearNpc() {
        generatedNpc = null
    }
}
