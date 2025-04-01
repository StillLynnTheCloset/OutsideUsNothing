package com.stilllynnthecloset.outsideusnothing.library.playbook

import com.stilllynnthecloset.outsideusnothing.library.model.ChoiceSpecification
import com.stilllynnthecloset.outsideusnothing.library.model.EventSpecification
import com.stilllynnthecloset.outsideusnothing.library.model.FlavorText
import com.stilllynnthecloset.outsideusnothing.library.model.Option
import com.stilllynnthecloset.outsideusnothing.library.model.Question
import com.stilllynnthecloset.outsideusnothing.library.model.TextConsequenceSpecification
import com.stilllynnthecloset.outsideusnothing.library.tools.Weighted
import com.stilllynnthecloset.outsideusnothing.library.tools.WeightedSet

/**
 * EventPlaybook - TODO: Documentation
 *
 * Created by Lynn on 5/1/23
 */
internal object EventPlaybook {
    val events: WeightedSet<EventSpecification> = WeightedSet(
        Weighted(
            weight = 1,
            value = EventSpecification(
                name = "Machine Killing Field",
                flavorText = FlavorText(
                    text = "TODO",
                    attribution = "TODO",
                ),
                description = "“We were out in Deep Wild Dark, past the Pale, when the tech all stopped working and my memories started coming back. I rejected them.”\n\t-Maybe Xis\nSome of the big corporations deploy these deliberately, but out here in the black it’s probably natural. Your tech is barely working if at all. Good luck!",
                choices = setOf(
                    ChoiceSpecification(
                        options = setOf(
                            Option("Corp tech"),
                            Option("Micro-dark matter well"),
                            Option("Black hole"),
                            Option("A kerama point"),
                            Option("A parallel universe"),
                            Option("Nowhere"),
                            Option("You don’t know"),
                            Option("A temporal anomaly"),
                        ),
                        questions = listOf(
                            Question(
                                question = "From where is this field coming?",
                                answers = 1,
                            ),
                        ),
                    ),
                ),
                consequences = listOf(
                    TextConsequenceSpecification(
                        name = "Crew needs strong rolls or help to escape the field",
                    ),
                    TextConsequenceSpecification(
                        name = "Crew escapes the field, ship continues",
                    ),
                ),
            ),
        ),

        Weighted(
            weight = 1,
            value = EventSpecification(
                name = "System Failure for the Masses...",
                flavorText = FlavorText(
                    text = "TODO",
                    attribution = "TODO",
                ),
                description = "TODO",
                choices = setOf(),
                consequences = listOf(),
            ),
        ),

        Weighted(
            weight = 1,
            value = EventSpecification(
                name = "…Antimatter for the Master Plan",
                flavorText = FlavorText(
                    text = "TODO",
                    attribution = "TODO",
                ),
                description = "TODO",
                choices = setOf(),
                consequences = listOf(),
            ),
        ),

        Weighted(
            weight = 1,
            value = EventSpecification(
                name = "Slipping Through My Fingers",
                flavorText = FlavorText(
                    text = "TODO",
                    attribution = "TODO",
                ),
                description = "TODO",
                choices = setOf(),
                consequences = listOf(),
            ),
        ),

        Weighted(
            weight = 1,
            value = EventSpecification(
                name = "MF’ing Rats on a MF’ing Spaceship",
                flavorText = FlavorText(
                    text = "TODO",
                    attribution = "TODO",
                ),
                description = "TODO",
                choices = setOf(),
                consequences = listOf(),
            ),
        ),

        Weighted(
            weight = 1,
            value = EventSpecification(
                name = "Deadliest Son of a Gun in Space",
                flavorText = FlavorText(
                    text = "TODO",
                    attribution = "TODO",
                ),
                description = "TODO",
                choices = setOf(),
                consequences = listOf(),
            ),
        ),

        Weighted(
            weight = 1,
            value = EventSpecification(
                name = "Minkowski Commanding",
                flavorText = FlavorText(
                    text = "TODO",
                    attribution = "TODO",
                ),
                description = "TODO",
                choices = setOf(),
                consequences = listOf(),
            ),
        ),

        Weighted(
            weight = 1,
            value = EventSpecification(
                name = "Doors and Corners",
                flavorText = FlavorText(
                    text = "TODO",
                    attribution = "TODO",
                ),
                description = "TODO",
                choices = setOf(),
                consequences = listOf(),
            ),
        ),

        Weighted(
            weight = 1,
            value = EventSpecification(
                name = "No Disintegrations",
                flavorText = FlavorText(
                    text = "TODO",
                    attribution = "TODO",
                ),
                description = "TODO",
                choices = setOf(),
                consequences = listOf(),
            ),
        ),

        Weighted(
            weight = 1,
            value = EventSpecification(
                name = "Bad Fellas",
                flavorText = FlavorText(
                    text = "TODO",
                    attribution = "TODO",
                ),
                description = "TODO",
                choices = setOf(),
                consequences = listOf(),
            ),
        ),

        Weighted(
            weight = 1,
            value = EventSpecification(
                name = "CQB",
                flavorText = FlavorText(
                    text = "TODO",
                    attribution = "TODO",
                ),
                description = "TODO",
                choices = setOf(),
                consequences = listOf(),
            ),
        ),

        Weighted(
            weight = 1,
            value = EventSpecification(
                name = "Hard Burn",
                flavorText = FlavorText(
                    text = "TODO",
                    attribution = "TODO",
                ),
                description = "TODO",
                choices = setOf(),
                consequences = listOf(),
            ),
        ),

        Weighted(
            weight = 1,
            value = EventSpecification(
                name = "Varren STD",
                flavorText = FlavorText(
                    text = "TODO",
                    attribution = "TODO",
                ),
                description = "TODO",
                choices = setOf(),
                consequences = listOf(),
            ),
        ),

        Weighted(
            weight = 1,
            value = EventSpecification(
                name = "Wibbly Wobbly",
                flavorText = FlavorText(
                    text = "TODO",
                    attribution = "TODO",
                ),
                description = "TODO",
                choices = setOf(),
                consequences = listOf(),
            ),
        ),

        Weighted(
            weight = 1,
            value = EventSpecification(
                name = "A Flat Circle",
                flavorText = FlavorText(
                    text = "TODO",
                    attribution = "TODO",
                ),
                description = "TODO",
                choices = setOf(),
                consequences = listOf(),
            ),
        ),

        Weighted(
            weight = 1,
            value = EventSpecification(
                name = "A Fistful of Datas",
                flavorText = FlavorText(
                    text = "TODO",
                    attribution = "TODO",
                ),
                description = "TODO",
                choices = setOf(),
                consequences = listOf(),
            ),
        ),

        Weighted(
            weight = 1,
            value = EventSpecification(
                name = "Space Predators",
                flavorText = FlavorText(
                    text = "TODO",
                    attribution = "TODO",
                ),
                description = "TODO",
                choices = setOf(),
                consequences = listOf(),
            ),
        ),

        Weighted(
            weight = 1,
            value = EventSpecification(
                name = "Space Worm",
                flavorText = FlavorText(
                    text = "TODO",
                    attribution = "TODO",
                ),
                description = "TODO",
                choices = setOf(),
                consequences = listOf(),
            ),
        ),

        Weighted(
            weight = 1,
            value = EventSpecification(
                name = "Ancient Guardian",
                flavorText = FlavorText(
                    text = "TODO",
                    attribution = "TODO",
                ),
                description = "TODO",
                choices = setOf(),
                consequences = listOf(),
            ),
        ),

        Weighted(
            weight = 1,
            value = EventSpecification(
                name = "A More Elegant Weapon…",
                flavorText = FlavorText(
                    text = "TODO",
                    attribution = "TODO",
                ),
                description = "TODO",
                choices = setOf(),
                consequences = listOf(),
            ),
        ),

        Weighted(
            weight = 1,
            value = EventSpecification(
                name = "Some sort of star gate…",
                flavorText = FlavorText(
                    text = "TODO",
                    attribution = "TODO",
                ),
                description = "TODO",
                choices = setOf(),
                consequences = listOf(),
            ),
        ),

        Weighted(
            weight = 1,
            value = EventSpecification(
                name = "Hellgate",
                flavorText = FlavorText(
                    text = "TODO",
                    attribution = "TODO",
                ),
                description = "TODO",
                choices = setOf(),
                consequences = listOf(),
            ),
        ),

        Weighted(
            weight = 1,
            value = EventSpecification(
                name = "I Saw Him at the Crossroads but…",
                flavorText = FlavorText(
                    text = "TODO",
                    attribution = "TODO",
                ),
                description = "TODO",
                choices = setOf(),
                consequences = listOf(),
            ),
        ),

        Weighted(
            weight = 1,
            value = EventSpecification(
                name = "Absolute Immortal",
                flavorText = FlavorText(
                    text = "TODO",
                    attribution = "TODO",
                ),
                description = "TODO",
                choices = setOf(),
                consequences = listOf(),
            ),
        ),

        Weighted(
            weight = 1,
            value = EventSpecification(
                name = "Everything, Everywhere",
                flavorText = FlavorText(
                    text = "TODO",
                    attribution = "TODO",
                ),
                description = "TODO",
                choices = setOf(),
                consequences = listOf(),
            ),
        ),

        Weighted(
            weight = 1,
            value = EventSpecification(
                name = "Evil Twin",
                flavorText = FlavorText(
                    text = "TODO",
                    attribution = "TODO",
                ),
                description = "TODO",
                choices = setOf(),
                consequences = listOf(),
            ),
        ),

        Weighted(
            weight = 1,
            value = EventSpecification(
                name = "First Person Singular",
                flavorText = FlavorText(
                    text = "TODO",
                    attribution = "TODO",
                ),
                description = "TODO",
                choices = setOf(),
                consequences = listOf(),
            ),
        ),

        Weighted(
            weight = 1,
            value = EventSpecification(
                name = "The Corporate Event",
                flavorText = FlavorText(
                    text = "TODO",
                    attribution = "TODO",
                ),
                description = "TODO",
                choices = setOf(),
                consequences = listOf(),
            ),
        ),

        Weighted(
            weight = 1,
            value = EventSpecification(
                name = "The Religion Event",
                flavorText = FlavorText(
                    text = "TODO",
                    attribution = "TODO",
                ),
                description = "TODO",
                choices = setOf(),
                consequences = listOf(),
            ),
        ),

        Weighted(
            weight = 1,
            value = EventSpecification(
                name = "The Fascism Event",
                flavorText = FlavorText(
                    text = "TODO",
                    attribution = "TODO",
                ),
                description = "TODO",
                choices = setOf(),
                consequences = listOf(),
            ),
        ),

        Weighted(
            weight = 1,
            value = EventSpecification(
                name = "On The Float - Spaceborn Terre",
                flavorText = FlavorText(
                    text = "TODO",
                    attribution = "TODO",
                ),
                description = "TODO",
                choices = setOf(),
                consequences = listOf(),
            ),
        ),

        Weighted(
            weight = 1,
            value = EventSpecification(
                name = "To Be Taught if Fortunate - Genehacked Terre",
                flavorText = FlavorText(
                    text = "TODO",
                    attribution = "TODO",
                ),
                description = "TODO",
                choices = setOf(),
                consequences = listOf(),
            ),
        ),

        Weighted(
            weight = 1,
            value = EventSpecification(
                name = "I Never Asked For This - Cybernetic Terre",
                flavorText = FlavorText(
                    text = "TODO",
                    attribution = "TODO",
                ),
                description = "TODO",
                choices = setOf(),
                consequences = listOf(),
            ),
        ),

        Weighted(
            weight = 1,
            value = EventSpecification(
                name = "By the Stars We Hope - Terre Raised by Exoterre",
                flavorText = FlavorText(
                    text = "TODO",
                    attribution = "TODO",
                ),
                description = "TODO",
                choices = setOf(),
                consequences = listOf(),
            ),
        ),

        Weighted(
            weight = 1,
            value = EventSpecification(
                name = "A Miserable Pile of Secrets - Vampiric Terre",
                flavorText = FlavorText(
                    text = "TODO",
                    attribution = "TODO",
                ),
                description = "TODO",
                choices = setOf(),
                consequences = listOf(),
            ),
        ),

        Weighted(
            weight = 1,
            value = EventSpecification(
                name = "Howl - Lycanthropic Terre",
                flavorText = FlavorText(
                    text = "TODO",
                    attribution = "TODO",
                ),
                description = "TODO",
                choices = setOf(),
                consequences = listOf(),
            ),
        ),

        Weighted(
            weight = 1,
            value = EventSpecification(
                name = "From Earth, For Earth - Baseline Terre",
                flavorText = FlavorText(
                    text = "TODO",
                    attribution = "TODO",
                ),
                description = "TODO",
                choices = setOf(),
                consequences = listOf(),
            ),
        ),

        Weighted(
            weight = 1,
            value = EventSpecification(
                name = "Caught a Bug - Z-Machine",
                flavorText = FlavorText(
                    text = "TODO",
                    attribution = "TODO",
                ),
                description = "TODO",
                choices = setOf(),
                consequences = listOf(),
            ),
        ),

        Weighted(
            weight = 1,
            value = EventSpecification(
                name = "Choir Eternal - Angel",
                flavorText = FlavorText(
                    text = "TODO",
                    attribution = "TODO",
                ),
                description = "TODO",
                choices = setOf(),
                consequences = listOf(),
            ),
        ),

        Weighted(
            weight = 1,
            value = EventSpecification(
                name = "Anafabula - Devil",
                flavorText = FlavorText(
                    text = "TODO",
                    attribution = "TODO",
                ),
                description = "TODO",
                choices = setOf(),
                consequences = listOf(),
            ),
        ),

        Weighted(
            weight = 1,
            value = EventSpecification(
                name = "Molt - Bawalangasi",
                flavorText = FlavorText(
                    text = "TODO",
                    attribution = "TODO",
                ),
                description = "TODO",
                choices = setOf(),
                consequences = listOf(),
            ),
        ),

        Weighted(
            weight = 1,
            value = EventSpecification(
                name = "Cavern Tune - Harrisi",
                flavorText = FlavorText(
                    text = "TODO",
                    attribution = "TODO",
                ),
                description = "TODO",
                choices = setOf(),
                consequences = listOf(),
            ),
        ),

        Weighted(
            weight = 1,
            value = EventSpecification(
                name = "Swarm Collapse Disorder - Zph",
                flavorText = FlavorText(
                    text = "TODO",
                    attribution = "TODO",
                ),
                description = "TODO",
                choices = setOf(),
                consequences = listOf(),
            ),
        ),

        Weighted(
            weight = 1,
            value = EventSpecification(
                name = "The Ties That Bind - Teuth",
                flavorText = FlavorText(
                    text = "TODO",
                    attribution = "TODO",
                ),
                description = "TODO",
                choices = setOf(),
                consequences = listOf(),
            ),
        ),

        Weighted(
            weight = 1,
            value = EventSpecification(
                name = "A Spectre, Haunting",
                flavorText = FlavorText(
                    text = "TODO",
                    attribution = "TODO",
                ),
                description = "TODO",
                choices = setOf(),
                consequences = listOf(),
            ),
        ),

        Weighted(
            weight = 1,
            value = EventSpecification(
                name = "True Trans",
                flavorText = FlavorText(
                    text = "TODO",
                    attribution = "TODO",
                ),
                description = "TODO",
                choices = setOf(),
                consequences = listOf(),
            ),
        ),

        Weighted(
            weight = 1,
            value = EventSpecification(
                name = "The Social Contract",
                flavorText = FlavorText(
                    text = "TODO",
                    attribution = "TODO",
                ),
                description = "TODO",
                choices = setOf(),
                consequences = listOf(),
            ),
        ),

        Weighted(
            weight = 1,
            value = EventSpecification(
                name = "Burial at C",
                flavorText = FlavorText(
                    text = "TODO",
                    attribution = "TODO",
                ),
                description = "TODO",
                choices = setOf(),
                consequences = listOf(),
            ),
        ),

        Weighted(
            weight = 1,
            value = EventSpecification(
                name = "Signal Haze",
                flavorText = FlavorText(
                    text = "TODO",
                    attribution = "TODO",
                ),
                description = "TODO",
                choices = setOf(),
                consequences = listOf(),
            ),
        ),

        Weighted(
            weight = 1,
            value = EventSpecification(
                name = "A Little More Light",
                flavorText = FlavorText(
                    text = "TODO",
                    attribution = "TODO",
                ),
                description = "TODO",
                choices = setOf(),
                consequences = listOf(),
            ),
        ),

        Weighted(
            weight = 1,
            value = EventSpecification(
                name = "Space Whales",
                flavorText = FlavorText(
                    text = "TODO",
                    attribution = "TODO",
                ),
                description = "TODO",
                choices = setOf(),
                consequences = listOf(),
            ),
        ),

        Weighted(
            weight = 1,
            value = EventSpecification(
                name = "Ma Nishtana",
                flavorText = FlavorText(
                    text = "TODO",
                    attribution = "TODO",
                ),
                description = "TODO",
                choices = setOf(),
                consequences = listOf(),
            ),
        ),

        Weighted(
            weight = 1,
            value = EventSpecification(
                name = "A System of Messages, 1281",
                flavorText = FlavorText(
                    text = "TODO",
                    attribution = "TODO",
                ),
                description = "TODO",
                choices = setOf(),
                consequences = listOf(),
            ),
        ),

        Weighted(
            weight = 1,
            value = EventSpecification(
                name = "Slow Burn",
                flavorText = FlavorText(
                    text = "TODO",
                    attribution = "TODO",
                ),
                description = "TODO",
                choices = setOf(),
                consequences = listOf(),
            ),
        ),

        Weighted(
            weight = 1,
            value = EventSpecification(
                name = "As The Stars Start to Align",
                flavorText = FlavorText(
                    text = "TODO",
                    attribution = "TODO",
                ),
                description = "TODO",
                choices = setOf(),
                consequences = listOf(),
            ),
        ),

        Weighted(
            weight = 1,
            value = EventSpecification(
                name = "Alien Spiders Are No Joke",
                flavorText = FlavorText(
                    text = "TODO",
                    attribution = "TODO",
                ),
                description = "TODO",
                choices = setOf(),
                consequences = listOf(),
            ),
        ),

        Weighted(
            weight = 1,
            value = EventSpecification(
                name = "Banned From Argo",
                flavorText = FlavorText(
                    text = "TODO",
                    attribution = "TODO",
                ),
                description = "TODO",
                choices = setOf(),
                consequences = listOf(),
            ),
        ),

        Weighted(
            weight = 1,
            value = EventSpecification(
                name = "Whalefall",
                flavorText = FlavorText(
                    text = "TODO",
                    attribution = "TODO",
                ),
                description = "TODO",
                choices = setOf(),
                consequences = listOf(),
            ),
        ),

        Weighted(
            weight = 1,
            value = EventSpecification(
                name = "The Point",
                flavorText = FlavorText(
                    text = "TODO",
                    attribution = "TODO",
                ),
                description = "TODO",
                choices = setOf(),
                consequences = listOf(),
            ),
        ),

        Weighted(
            weight = 1,
            value = EventSpecification(
                name = "Outside us",
                flavorText = FlavorText(
                    text = "TODO",
                    attribution = "TODO",
                ),
                description = "TODO",
                choices = setOf(),
                consequences = listOf(),
            ),
        ),
    )

    private val template = EventSpecification(
        name = "asdf",
        flavorText = FlavorText(
            text = "asdf",
            attribution = "asdf",
        ),
        description = "asdf",
        choices = setOf(
            ChoiceSpecification(
                options = setOf(
                    Option(""),
                ),
                questions = listOf(
                    Question(
                        question = "asdf",
                        answers = 1,
                    ),
                ),
            ),
        ),
        consequences = listOf(
            TextConsequenceSpecification(
                name = "asdf",
            ),
        ),
    )

}
