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
    val authors: Set<Author>,
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
            authors = setOf(Author("Sable Sy")),
            uuid = DEFAULT_PLAYBOOK_UUID,
            aliens = AlienPlaybook.aliens,
            backgrounds = BackgroundPlaybook.backgrounds,
            roles = RolePlaybook.roles,
            bastards = BastardPlaybook.bastards,
            events = EventPlaybook.events,
            flavorTexts = FlavorTextPlaybook.flavorTexts,
            ports = PortPlaybook.ports,
            threats = ThreatPlaybook.threats,
            usefulItems = UsefulItemPlaybook.items,
            npcAdjectives = NamePlaybook.npcNames1,
            npcTypes = NamePlaybook.npcNames2,
            portAdjectives = NamePlaybook.locationNames1,
            portNames = NamePlaybook.locationNames2,
            contractItems = ContractItemPlaybook.contractItems,
            contractDestinations = ContractItemPlaybook.contractDestinations,
        )

        public val lynnsPlaybook: Playbook = Playbook(
            name = "Lynn's Cool Homebrew",
            description = "Some fun things I wanted to add",
            authors = setOf(Author("Lynn")),
            uuid = "0d851b76-3835-4d16-8a92-fb619fe13908",
            npcAdjectives = listOf(
                Weighted(value = "ancient", weight = 1),
                Weighted(value = "lost", weight = 1),
                Weighted(value = "punk", weight = 1),
                Weighted(value = "twitchy", weight = 1),
                Weighted(value = "strangely calm", weight = 1),
                Weighted(value = "extradimensional", weight = 1),
                Weighted(value = "anteuniversalian", weight = 1),
                Weighted(value = "entropic", weight = 1),
            ),
            npcTypes = listOf(
                Weighted(value = "cowboy", weight = 1),
                Weighted(value = "freetraveler", weight = 1),
                Weighted(value = "mafia", weight = 1),
                Weighted(value = "spy", weight = 1),
                Weighted(value = "scientist", weight = 1),
                Weighted(value = "ancient", weight = 1),
            ),
            contractItems = listOf(
                Weighted(value = ContractItem("a gold poker chip"), weight = 1),
                Weighted(value = ContractItem("a family heirloom"), weight = 1),
                Weighted(value = ContractItem("a sealed envelope"), weight = 1),
            ),
        )

        public val wolf: Playbook = Playbook(
            name = "Allie’s Playable Anhedonic Wolf add-on",
            description = "Be a wolf! Don't enjoy anything!",
            authors = setOf(
                Author(
                    name = "Allie",
                ),
            ),
            uuid = "8df3484f-bda9-42d7-babc-70edf9ddc667",
            aliens = listOf(
                Weighted(
                    value = PlaySheetSpecification(
                        name = "Anhedonic Wolf",
                        description = "Anhedonic Wolves are a race of large bipedal Canidae. Their origins aren't strictly known, and the story varies wildly. Depending on who you ask you might hear tales of a long lost Terre generational ship where the occupants found aboard had become far removed from their ancestors. Other's tell stories of immoral  corporate gene-splicing experiments. Whatever the truth is, the one thing we know about them for certain is their lack of positive emotions. Happiness, it seems, is lost to them.",
                        flavorText = FlavorText(
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
                                        answers = 2,
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
                    weight = 1,
                ),
            ),
            npcAdjectives = listOf(
                Weighted(1, "anhedonic"),
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