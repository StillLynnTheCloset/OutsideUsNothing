package com.stilllynnthecloset.outsideusnothing.organizer

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import com.stilllynnthecloset.liboun.generateWeightedList
import com.stilllynnthecloset.liboun.model.Bastard
import com.stilllynnthecloset.liboun.model.ContractItem
import com.stilllynnthecloset.liboun.model.Event
import com.stilllynnthecloset.liboun.model.HealthCondition
import com.stilllynnthecloset.liboun.model.Player
import com.stilllynnthecloset.liboun.model.UsefulItem
import com.stilllynnthecloset.liboun.model.PortOfCall
import com.stilllynnthecloset.liboun.model.Ship
import com.stilllynnthecloset.liboun.model.Threat
import com.stilllynnthecloset.liboun.playbook.AlienPlaybook
import com.stilllynnthecloset.liboun.playbook.BackgroundPlaybook
import com.stilllynnthecloset.liboun.playbook.BastardPlaybook
import com.stilllynnthecloset.liboun.playbook.ContractItemPlaybook
import com.stilllynnthecloset.liboun.playbook.EventPlaybook
import com.stilllynnthecloset.liboun.playbook.PortPlaybook
import com.stilllynnthecloset.liboun.playbook.RolePlaybook
import com.stilllynnthecloset.liboun.playbook.ShipPlaybook
import com.stilllynnthecloset.liboun.playbook.ThreatPlaybook
import com.stilllynnthecloset.liboun.playbook.UsefulItemPlaybook

/**
 * OrganizerDataModel - TODO: Documentation
 *
 * Created by Lynn on 4/14/23
 */
public class OrganizerDataModel {
    public var generatedPort: PortOfCall? by mutableStateOf(null)
        private set

    public fun generatePort() {
        generatedPort = PortPlaybook.portWeightings.generateWeightedList().random().randomize()
    }

    public fun clearPort() {
        generatedPort = null
    }

    public var generatedContractItem: ContractItem? by mutableStateOf(null)
        private set

    public fun generateContractItem() {
        generatedContractItem = ContractItemPlaybook.items.random()
    }

    public fun clearContractItem() {
        generatedContractItem = null
    }

    public var generatedBastard: Bastard? by mutableStateOf(null)
        private set

    public fun generateBastard() {
        generatedBastard = BastardPlaybook.bastards.random()
    }

    public fun clearBastard() {
        generatedBastard = null
    }

    public var generatedEvent: Event? by mutableStateOf(null)
        private set

    public fun generateEvent() {
        generatedEvent = EventPlaybook.events.random().randomize()
    }

    public fun clearEvent() {
        generatedEvent = null
    }

    public var generatedThreat: Threat? by mutableStateOf(null)
        private set

    public fun generateThreat() {
        generatedThreat = ThreatPlaybook.threats.random()
    }

    public fun clearThreat() {
        generatedThreat = null
    }

    public var generatedUsefulItem: UsefulItem? by mutableStateOf(null)
        private set

    public fun generateUsefulItem() {
        generatedUsefulItem = UsefulItemPlaybook.items.random()
    }

    public fun clearUsefulItem() {
        generatedUsefulItem = null
    }

    public var generatedShip: Ship? by mutableStateOf(null)
        private set

    public fun generateShip() {
        generatedShip = Ship(
            name = "Ship name here",
            fuel = (0..20).random(),
            supplies = (0..20).random(),
            condition = HealthCondition.values().random(),
            playSheet = ShipPlaybook.shipPlaySheetSpecification.randomize(),
        )
    }

    public fun clearShip() {
        generatedShip = null
    }

    public var generatedPlayer: Player? by mutableStateOf(null)
        private set

    public fun generatePlayer() {
        generatedPlayer = Player(
            dicePool = (0..20).random(),
            condition = HealthCondition.values().random(),
            playSheets = listOf(
                AlienPlaybook.aliens.random().randomize(),
                BackgroundPlaybook.backgrounds.random().randomize(),
                RolePlaybook.roles.random().randomize(),
            ),
        )
    }

    public fun clearPlayer() {
        generatedPlayer = null
    }
}
