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
        private const val DEFAULT_PLAYBOOK_UUID: String = "playbook_bd656fa0-b460-4cf3-852a-d5c7730d0028"
        private const val MERGED_PLAYBOOKS_UUID: String = "playbook_5c63c40a-05c9-49ff-acfd-2a933c4b2c6f"
        private const val MERGED_PLAYBOOKS_NAME: String = "Merged Playbook"
        private const val MERGED_PLAYBOOKS_DESCRIPTION: String = "A playbook that is the merger of all active playbooks"

        public val defaultPlaybook: Playbook = Playbook(
            name = "Vanilla Outside Us Nothing",
            description = "The default playbook of Outside Us Nothing",
            authors = listOf(Author("Sable Sy")),
            uuid = DEFAULT_PLAYBOOK_UUID,
            active = true,
            aliens = AlienPlaybook.aliens,
            backgrounds = BackgroundPlaybook.backgrounds,
            roles = RolePlaybook.roles,
            bastards = BastardPlaybook.bastards,
            events = EventPlaybook.events,
            flavorTexts = FlavorTextPlaybook.flavorTexts,
            ports = PortPlaybook.ports,
            threats = ThreatPlaybook.threats,
            usefulItems = UsefulItemPlaybook.items,
            npcAdjectives = NamePlaybook.npcAdjectives,
            npcNouns = NamePlaybook.npcNouns,
            portAdjectives = NamePlaybook.portAdjectives,
            portNouns = NamePlaybook.portNouns,
            contractItems = ContractItemPlaybook.contractItems,
            contractDestinations = ContractItemPlaybook.contractDestinations,
        )

        public val lynnsPlaybook: Playbook = Playbook(
            name = "Lynn's Cool Homebrew",
            description = "Some fun things I wanted to add",
            authors = listOf(Author("Lynn")),
            uuid = "playbook_0d851b76-3835-4d16-8a92-fb619fe13908",
            active = false,
            npcAdjectives = WeightedSet(
                NpcAdjective("ancient") to 1,
                NpcAdjective("lost") to 1,
                NpcAdjective("punk") to 1,
                NpcAdjective("twitchy") to 1,
                NpcAdjective("strangely calm") to 1,
                NpcAdjective("extradimensional") to 1,
                NpcAdjective("anteuniversalian") to 1,
                NpcAdjective("entropic") to 1,
                NpcAdjective("memetic") to 1,
            ),
            npcNouns = WeightedSet(
                NpcNoun("cowboy") to 1,
                NpcNoun("freetraveler") to 1,
                NpcNoun("mafia") to 1,
                NpcNoun("spy") to 1,
                NpcNoun("scientist") to 1,
                NpcNoun("ancient") to 1,
            ),
            contractItems = WeightedSet(
                ContractItem("a platinum poker chip") to 1,
                ContractItem("a family heirloom") to 1,
                ContractItem("a sealed envelope") to 1,
            ),
            contractDestinations = WeightedSet(
                ContractDestination("a casino") to 1,
            ),
        )

        public val wolf: Playbook = Playbook(
            name = "Allie’s Playable Anhedonic Wolf add-on",
            description = "Be a wolf! Don't enjoy anything!",
            authors = listOf(
                Author(
                    name = "Allie",
                ),
            ),
            active = false,
            uuid = "playbook_8df3484f-bda9-42d7-babc-70edf9ddc667",
            aliens = WeightedSet(
                Weighted(
                    weight = 1,
                    value = PlaySheetSpecification(
                        name = "Anhedonic Wolf",
                        description = "Anhedonic Wolves are a race of large bipedal Canidae. Their origins aren't strictly known, and the story varies wildly. Depending on who you ask you might hear tales of a long lost Terre generational ship where the occupants found aboard had become far removed from their ancestors. Other's tell stories of immoral  corporate gene-splicing experiments. Whatever the truth is, the one thing we know about them for certain is their lack of positive emotions. Happiness, it seems, is lost to them.",
                        flavorText = com.stilllynnthecloset.outsideusnothing.library.model.FlavorText(
                            text = "\"Oh but you misunderstand my friend, feelings of happiness are thoroughly unavailable to me yes, but rage is quite accessible.\"",
                            attribution = "recording of a syndicate enforcer known as “Laughter” during a DiemCo sting operation",
                        ),
                        choices = listOf(
                            ChoiceSpecification(
                                questions = listOf(
                                    Question(
                                        question = "Choose one or two colors that your coat is",
                                        answers = 2,
                                    ),
                                ),
                                options = listOf(
                                    Option("Black"),
                                    Option("Grey"),
                                    Option("Brown"),
                                    Option("White"),
                                    Option("Red"),
                                ),
                            ),
                            ChoiceSpecification(
                                questions = listOf(
                                    Question(
                                        question = "Choose two things that you are",
                                        answers = 2,
                                    ),
                                    Question(
                                        question = "Choose one that you're not",
                                        answers = 1,
                                    ),
                                ),
                                options = listOf(
                                    Option("Tall"),
                                    Option("Strong"),
                                    Option("Sickly"),
                                    Option("Losing fur"),
                                    Option("Witty"),
                                    Option("Pessimistic"),
                                    Option("Angry"),
                                    Option("Elderly"),
                                    Option("Youthful"),
                                    Option("Devoted to the pack"),
                                    Option("Alone"),
                                    Option("Afraid"),
                                    Option("Numb"),
                                    Option("Resigned"),
                                    Option("Positive"),
                                    Option("Vicious"),
                                ),
                            ),
                        ),
                        actions = listOf(
                            Action(
                                description = "Be pessimistic about the current situation to the detriment of you and your crew",
                                diceOffset = 3,
                            ),
                            Action(
                                description = "Howl at an inappropriate moment",
                                diceOffset = 1,
                            ),
                            Action(
                                description = "Struggle with your lack of positive emotions in a society that enjoys them",
                                diceOffset = 1,
                            ),
                            Action(
                                description = "Complain about your lack of positive emotions",
                                diceOffset = 0,
                            ),
                            Action(
                                description = "Express an emotion that you can feel, regardless of whether it's appropriate for the moment",
                                diceOffset = -1,
                            ),
                            Action(
                                description = "Attack someone or something, or generally try to solve a problem with your claws and/or teeth",
                                diceOffset = -2,
                            ),
                            Action(
                                description = "Reclaim your feelings of happiness and other positive emotions. be it by medical, magical, or spiritual means",
                                diceOffset = -6,
                            ),
                        ),
                    ),
                ),
            ),
            npcAdjectives = WeightedSet(
                NpcAdjective("anhedonic") to 1,
            ),
            npcNouns = WeightedSet(
                NpcNoun("wolf") to 1,
            ),
        )

        public val emptyPlaybook: Playbook = Playbook(
            name = "Empty",
            description = "An empty playbook, for testing",
            authors = listOf(),
            active = false,
            uuid = "playbook_2a9e7353-707f-44f1-a22d-a9687f1457d6",
        )
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
