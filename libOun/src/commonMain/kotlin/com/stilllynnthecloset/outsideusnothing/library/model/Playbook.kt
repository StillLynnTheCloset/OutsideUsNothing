package com.stilllynnthecloset.outsideusnothing.library.model

import com.stilllynnthecloset.outsideusnothing.library.interfaces.Latexible
import com.stilllynnthecloset.outsideusnothing.library.interfaces.UniversallyUnique
import com.stilllynnthecloset.outsideusnothing.library.playbook.AlienPlaybook
import com.stilllynnthecloset.outsideusnothing.library.playbook.BackgroundPlaybook
import com.stilllynnthecloset.outsideusnothing.library.playbook.BastardPlaybook
import com.stilllynnthecloset.outsideusnothing.library.playbook.ContractItemPlaybook
import com.stilllynnthecloset.outsideusnothing.library.playbook.EventPlaybook
import com.stilllynnthecloset.outsideusnothing.library.playbook.FlavorTextPlaybook
import com.stilllynnthecloset.outsideusnothing.library.playbook.NamePlaybook
import com.stilllynnthecloset.outsideusnothing.library.playbook.PortPlaybook
import com.stilllynnthecloset.outsideusnothing.library.playbook.RolePlaybook
import com.stilllynnthecloset.outsideusnothing.library.playbook.ThreatPlaybook
import com.stilllynnthecloset.outsideusnothing.library.playbook.UsefulItemPlaybook
import com.stilllynnthecloset.outsideusnothing.library.tools.Weighted
import com.stilllynnthecloset.outsideusnothing.library.tools.WeightedSet
import com.stilllynnthecloset.outsideusnothing.library.tools.emptyWeightedSet
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
    val authors: List<Author>,
    override val uuid: String,
    val active: Boolean = false,
    val aliens: WeightedSet<PlaySheetSpecification> = emptyWeightedSet(),
    val backgrounds: WeightedSet<PlaySheetSpecification> = emptyWeightedSet(),
    val roles: WeightedSet<PlaySheetSpecification> = emptyWeightedSet(),
    val bastards: WeightedSet<Bastard> = emptyWeightedSet(),
    val events: WeightedSet<EventSpecification> = emptyWeightedSet(),
    val flavorTexts: WeightedSet<FlavorText> = emptyWeightedSet(),
    val ports: WeightedSet<PortOfCallSpecification> = emptyWeightedSet(),
    val threats: WeightedSet<Threat> = emptyWeightedSet(),
    val usefulItems: WeightedSet<UsefulItem> = emptyWeightedSet(),
    val npcAdjectives: WeightedSet<NpcAdjective> = emptyWeightedSet(),
    val npcNouns: WeightedSet<NpcNoun> = emptyWeightedSet(),
    val portAdjectives: WeightedSet<PortAdjective> = emptyWeightedSet(),
    val portNouns: WeightedSet<PortNoun> = emptyWeightedSet(),
    val contractItems: WeightedSet<ContractItem> = emptyWeightedSet(),
    val contractDestinations: WeightedSet<ContractDestination> = emptyWeightedSet(),
) : UniversallyUnique, Latexible {
    public companion object {
        public const val DEFAULT_PLAYBOOK_UUID: String = "playbook_bd656fa0-b460-4cf3-852a-d5c7730d0028"
        private const val MERGED_PLAYBOOKS_UUID: String = "playbook_5c63c40a-05c9-49ff-acfd-2a933c4b2c6f"
        private const val MERGED_PLAYBOOKS_NAME: String = "Merged Playbook"
        private const val MERGED_PLAYBOOKS_DESCRIPTION: String = "A playbook that is the merger of all active playbooks"

        // Used as a default while the vanilla book loads.
        public val mergedPlaybook: Playbook = Playbook(
            name = MERGED_PLAYBOOKS_NAME,
            description = MERGED_PLAYBOOKS_DESCRIPTION,
            authors = listOf(),
            active = true,
            uuid = MERGED_PLAYBOOKS_UUID,
        )

        // Commented so you can't use it, but still here for when I need to re-generate the contents
        // public val defaultPlaybook: Playbook = Playbook(
        //     name = "Vanilla Outside Us Nothing",
        //     description = "The default playbook of Outside Us Nothing",
        //     authors = listOf(Author("Sable Sy")),
        //     uuid = DEFAULT_PLAYBOOK_UUID,
        //     active = true,
        //     aliens = AlienPlaybook.aliens,
        //     backgrounds = BackgroundPlaybook.backgrounds,
        //     roles = RolePlaybook.roles,
        //     bastards = BastardPlaybook.bastards,
        //     events = EventPlaybook.events,
        //     flavorTexts = FlavorTextPlaybook.flavorTexts,
        //     ports = PortPlaybook.ports,
        //     threats = ThreatPlaybook.threats,
        //     usefulItems = UsefulItemPlaybook.items,
        //     npcAdjectives = NamePlaybook.npcAdjectives,
        //     npcNouns = NamePlaybook.npcNouns,
        //     portAdjectives = NamePlaybook.portAdjectives,
        //     portNouns = NamePlaybook.portNouns,
        //     contractItems = ContractItemPlaybook.contractItems,
        //     contractDestinations = ContractItemPlaybook.contractDestinations,
        // )
    }

    public operator fun plus(other: Playbook): Playbook {
        return Playbook(
            name = MERGED_PLAYBOOKS_NAME,
            description = MERGED_PLAYBOOKS_DESCRIPTION,
            authors = (this.authors.toSet() + other.authors).toList(),
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
            npcNouns = this.npcNouns + other.npcNouns,
            portAdjectives = this.portAdjectives + other.portAdjectives,
            portNouns = this.portNouns + other.portNouns,
            contractItems = this.contractItems + other.contractItems,
            contractDestinations = this.contractDestinations + other.contractDestinations,
        )
    }

    public override fun toLatex(builder: StringBuilder) {
        aliens.forEach { it.value.toLatex(builder) }
        backgrounds.forEach { it.value.toLatex(builder) }
        roles.forEach { it.value.toLatex(builder) }
    }
}
