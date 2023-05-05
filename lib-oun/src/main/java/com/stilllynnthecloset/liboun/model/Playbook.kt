package com.stilllynnthecloset.liboun.model

import com.stilllynnthecloset.liboun.playbook.AlienPlaybook
import com.stilllynnthecloset.liboun.playbook.BackgroundPlaybook
import com.stilllynnthecloset.liboun.playbook.BastardPlaybook
import com.stilllynnthecloset.liboun.playbook.ContractItemPlaybook
import com.stilllynnthecloset.liboun.playbook.EventPlaybook
import com.stilllynnthecloset.liboun.playbook.FlavorTextPlaybook
import com.stilllynnthecloset.liboun.playbook.NamePlaybook
import com.stilllynnthecloset.liboun.playbook.PortPlaybook
import com.stilllynnthecloset.liboun.playbook.RolePlaybook
import com.stilllynnthecloset.liboun.playbook.ThreatPlaybook
import com.stilllynnthecloset.liboun.playbook.UsefulItemPlaybook
import kotlinx.serialization.Serializable

/**
 * Playbook - TODO: Documentation
 *
 * Created by Lynn on 5/4/23
 */
@Serializable
public data class Playbook constructor(
    val name: String,
    val description: String,
    val authors: Set<String>,
    val uuid: String,
    val active: Boolean = true,
    val aliens: List<Weighted<PlaySheetSpecification>> = emptyList(),
    val backgrounds: List<Weighted<PlaySheetSpecification>> = emptyList(),
    val roles: List<Weighted<PlaySheetSpecification>> = emptyList(),
    val bastards: List<Weighted<Bastard>> = emptyList(),
    val events: List<Weighted<EventSpecification>> = emptyList(),
    val flavorTexts: List<Weighted<FlavorText>> = emptyList(),
    val ports: List<Weighted<PortOfCallSpecification>> = emptyList(),
    val threats: List<Weighted<Threat>> = emptyList(),
    val usefulItems: List<Weighted<UsefulItem>> = emptyList(),
    val npcAdjectives: List<Weighted<String>> = emptyList(),
    val npcTypes: List<Weighted<String>> = emptyList(),
    val portAdjectives: List<Weighted<String>> = emptyList(),
    val portNames: List<Weighted<String>> = emptyList(),
    val contractItems: List<Weighted<ContractItem>> = emptyList(),
    val contractDestinations: List<Weighted<ContractDestination>> = emptyList(),
) {
    public companion object {
        private const val DEFAULT_PLAYBOOK_UUID: String = "bd656fa0-b460-4cf3-852a-d5c7730d0028"
        private const val MERGED_PLAYBOOKS_UUID: String = "5c63c40a-05c9-49ff-acfd-2a933c4b2c6f"
        private const val MERGED_PLAYBOOKS_NAME: String = "5c63c40a-05c9-49ff-acfd-2a933c4b2c6f"
        private const val MERGED_PLAYBOOKS_DESCRIPTION: String = "5c63c40a-05c9-49ff-acfd-2a933c4b2c6f"

        public val defaultPlaybook: Playbook = Playbook(
            name = "Vanilla Outside Us Nothing",
            description = "The default playbook of Outside Us Nothing",
            authors = setOf("Sable Sy"),
            uuid = DEFAULT_PLAYBOOK_UUID,
            aliens = AlienPlaybook.aliens,
            backgrounds = BackgroundPlaybook.backgrounds.map { Weighted(it, 1) },
            roles = RolePlaybook.roles.map { Weighted(it, 1) },
            bastards = BastardPlaybook.bastards.map { Weighted(it, 1) },
            events = EventPlaybook.events.map { Weighted(it, 1) },
            flavorTexts = FlavorTextPlaybook.flavorTexts.map { Weighted(it, 1) },
            ports = PortPlaybook.ports,
            threats = ThreatPlaybook.threats.map { Weighted(it, 1) },
            usefulItems = UsefulItemPlaybook.items.map { Weighted(it, 1) },
            npcAdjectives = NamePlaybook.npcNames1.map { Weighted(it, 1) },
            npcTypes = NamePlaybook.npcNames2.map { Weighted(it, 1) },
            portAdjectives = NamePlaybook.locationNames1.map { Weighted(it, 1) },
            portNames = NamePlaybook.locationNames2.map { Weighted(it, 1) },
            contractItems = ContractItemPlaybook.contractItems.map { Weighted(it, 1) },
            contractDestinations = ContractItemPlaybook.contractDestinations.map { Weighted(it, 1) },
        )

        public val lynnsPlaybook: Playbook = Playbook(
            name = "Lynn's Cool Homebrew",
            description = "Some fun things I wanted to add",
            authors = setOf("Lynn"),
            uuid = "0d851b76-3835-4d16-8a92-fb619fe13908",
            npcAdjectives = listOf(
                Weighted("ancient", 1),
                Weighted("lost", 1),
                Weighted("punk", 1),
                Weighted("twitchy", 1),
                Weighted("strangely calm", 1),
                Weighted("extradimensional", 1),
                Weighted("anteuniversalian", 1),
                Weighted("entropic", 1),
            ),
            npcTypes = listOf(
                Weighted("cowboy", 1),
                Weighted("freetraveler", 1),
                Weighted("mafia", 1),
                Weighted("spy", 1),
                Weighted("scientist", 1),
                Weighted("ancient", 1),
            ),
            contractItems = listOf(
                Weighted(ContractItem("a gold poker chip"), 1),
                Weighted(ContractItem("a family heirloom"), 1),
                Weighted(ContractItem("a sealed envelope"), 1),
            ),
        )

        public val emptyPlaybook: Playbook = Playbook(
            name = "Empty",
            description = "An empty playbook, for testing",
            authors = setOf(),
            uuid = "2a9e7353-707f-44f1-a22d-a9687f1457d6",
        )
    }

    public operator fun plus(other: Playbook): Playbook {
        return Playbook(
            name = MERGED_PLAYBOOKS_NAME,
            description = MERGED_PLAYBOOKS_DESCRIPTION,
            authors = this.authors.toSet() + other.authors,
            uuid = MERGED_PLAYBOOKS_UUID,
            active = this.active || other.active,
            aliens = this.aliens + other.aliens,
            backgrounds = this.backgrounds + other.backgrounds,
            roles = this.roles + other.roles,
            bastards = this.bastards + other.bastards,
            events = this.events + other.events,
            flavorTexts = this.flavorTexts + other.flavorTexts,
            ports = this.ports + other.ports,
            threats = this.threats + other.threats,
            usefulItems = this.usefulItems + other.usefulItems,
            npcAdjectives = this.npcAdjectives + other.npcAdjectives,
            npcTypes = this.npcTypes + other.npcTypes,
            portAdjectives = this.portAdjectives + other.portAdjectives,
            portNames = this.portNames + other.portNames,
            contractItems = this.contractItems + other.contractItems,
            contractDestinations = this.contractDestinations + other.contractDestinations,
        )
    }
}
