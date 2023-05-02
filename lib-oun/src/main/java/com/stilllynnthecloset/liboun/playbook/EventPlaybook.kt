package com.stilllynnthecloset.liboun.playbook

import com.stilllynnthecloset.liboun.model.ChoiceSpecification
import com.stilllynnthecloset.liboun.model.Consequence
import com.stilllynnthecloset.liboun.model.EventSpecification
import com.stilllynnthecloset.liboun.model.Option
import com.stilllynnthecloset.liboun.model.Question

/**
 * EventPlaybook - TODO: Documentation
 *
 * Created by Lynn on 5/1/23
 */
public object EventPlaybook {
    public val events: List<EventSpecification> = listOf(
        EventSpecification(
            name = "Machine Killing Field",
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
                Consequence(
                    name = "Crew needs strong rolls or help to escape the field",
                ),
                Consequence(
                    name = "Crew escapes the field, ship continues",
                ),
            ),
        ),
        EventSpecification(
            name = "System Failure for the Masses...",
            description = "TODO",
            choices = setOf(),
            consequences = listOf(),
        ),
        EventSpecification(
            name = "…Antimatter for the Master Plan",
            description = "TODO",
            choices = setOf(),
            consequences = listOf(),
        ),
        EventSpecification(
            name = "Slipping Through My Fingers",
            description = "TODO",
            choices = setOf(),
            consequences = listOf(),
        ),
        EventSpecification(
            name = "MF’ing Rats on a MF’ing Spaceship",
            description = "TODO",
            choices = setOf(),
            consequences = listOf(),
        ),
        EventSpecification(
            name = "Deadliest Son of a Gun in Space",
            description = "TODO",
            choices = setOf(),
            consequences = listOf(),
        ),
        EventSpecification(
            name = "Minkowski Commanding",
            description = "TODO",
            choices = setOf(),
            consequences = listOf(),
        ),
        EventSpecification(
            name = "Doors and Corners",
            description = "TODO",
            choices = setOf(),
            consequences = listOf(),
        ),
        EventSpecification(
            name = "No Disintegrations",
            description = "TODO",
            choices = setOf(),
            consequences = listOf(),
        ),
        EventSpecification(
            name = "Bad Fellas",
            description = "TODO",
            choices = setOf(),
            consequences = listOf(),
        ),
        EventSpecification(
            name = "CQB",
            description = "TODO",
            choices = setOf(),
            consequences = listOf(),
        ),
        EventSpecification(
            name = "Hard Burn",
            description = "TODO",
            choices = setOf(),
            consequences = listOf(),
        ),
        EventSpecification(
            name = "Varren STD",
            description = "TODO",
            choices = setOf(),
            consequences = listOf(),
        ),
        EventSpecification(
            name = "Wibbly Wobbly",
            description = "TODO",
            choices = setOf(),
            consequences = listOf(),
        ),
        EventSpecification(
            name = "A Flat Circle",
            description = "TODO",
            choices = setOf(),
            consequences = listOf(),
        ),
        EventSpecification(
            name = "A Fistful of Datas",
            description = "TODO",
            choices = setOf(),
            consequences = listOf(),
        ),
        EventSpecification(
            name = "Space Predators",
            description = "TODO",
            choices = setOf(),
            consequences = listOf(),
        ),
        EventSpecification(
            name = "Space Worm",
            description = "TODO",
            choices = setOf(),
            consequences = listOf(),
        ),
        EventSpecification(
            name = "Ancient Guardian",
            description = "TODO",
            choices = setOf(),
            consequences = listOf(),
        ),
        EventSpecification(
            name = "A More Elegant Weapon…",
            description = "TODO",
            choices = setOf(),
            consequences = listOf(),
        ),
        EventSpecification(
            name = "Some sort of star gate…",
            description = "TODO",
            choices = setOf(),
            consequences = listOf(),
        ),
        EventSpecification(
            name = "Hellgate",
            description = "TODO",
            choices = setOf(),
            consequences = listOf(),
        ),
        EventSpecification(
            name = "I Saw Him at the Crossroads but…",
            description = "TODO",
            choices = setOf(),
            consequences = listOf(),
        ),
        EventSpecification(
            name = "Absolute Immortal",
            description = "TODO",
            choices = setOf(),
            consequences = listOf(),
        ),
        EventSpecification(
            name = "Everything, Everywhere",
            description = "TODO",
            choices = setOf(),
            consequences = listOf(),
        ),
        EventSpecification(
            name = "Evil Twin",
            description = "TODO",
            choices = setOf(),
            consequences = listOf(),
        ),
        EventSpecification(
            name = "First Person Singular",
            description = "TODO",
            choices = setOf(),
            consequences = listOf(),
        ),
        EventSpecification(
            name = "The Corporate Event",
            description = "TODO",
            choices = setOf(),
            consequences = listOf(),
        ),
        EventSpecification(
            name = "The Religion Event",
            description = "TODO",
            choices = setOf(),
            consequences = listOf(),
        ),
        EventSpecification(
            name = "The Fascism Event",
            description = "TODO",
            choices = setOf(),
            consequences = listOf(),
        ),
        EventSpecification(
            name = "On The Float - Spaceborn Terre",
            description = "TODO",
            choices = setOf(),
            consequences = listOf(),
        ),
        EventSpecification(
            name = "To Be Taught if Fortunate - Genehacked Terre",
            description = "TODO",
            choices = setOf(),
            consequences = listOf(),
        ),
        EventSpecification(
            name = "I Never Asked For This - Cybernetic Terre",
            description = "TODO",
            choices = setOf(),
            consequences = listOf(),
        ),
        EventSpecification(
            name = "By the Stars We Hope - Terre Raised by Exoterre",
            description = "TODO",
            choices = setOf(),
            consequences = listOf(),
        ),
        EventSpecification(
            name = "A Miserable Pile of Secrets - Vampiric Terre",
            description = "TODO",
            choices = setOf(),
            consequences = listOf(),
        ),
        EventSpecification(
            name = "Howl - Lycanthropic Terre",
            description = "TODO",
            choices = setOf(),
            consequences = listOf(),
        ),
        EventSpecification(
            name = "From Earth, For Earth - Baseline Terre",
            description = "TODO",
            choices = setOf(),
            consequences = listOf(),
        ),
        EventSpecification(
            name = "Caught a Bug - Z-Machine",
            description = "TODO",
            choices = setOf(),
            consequences = listOf(),
        ),
        EventSpecification(
            name = "Choir Eternal - Angel",
            description = "TODO",
            choices = setOf(),
            consequences = listOf(),
        ),
        EventSpecification(
            name = "Anafabula - Devil",
            description = "TODO",
            choices = setOf(),
            consequences = listOf(),
        ),
        EventSpecification(
            name = "Molt - Bawalangasi",
            description = "TODO",
            choices = setOf(),
            consequences = listOf(),
        ),
        EventSpecification(
            name = "Cavern Tune - Harrisi",
            description = "TODO",
            choices = setOf(),
            consequences = listOf(),
        ),
        EventSpecification(
            name = "Swarm Collapse Disorder - Zph",
            description = "TODO",
            choices = setOf(),
            consequences = listOf(),
        ),
        EventSpecification(
            name = "The Ties That Bind - Teuth",
            description = "TODO",
            choices = setOf(),
            consequences = listOf(),
        ),
        EventSpecification(
            name = "A Spectre, Haunting",
            description = "TODO",
            choices = setOf(),
            consequences = listOf(),
        ),
        EventSpecification(
            name = "True Trans",
            description = "TODO",
            choices = setOf(),
            consequences = listOf(),
        ),
        EventSpecification(
            name = "The Social Contract",
            description = "TODO",
            choices = setOf(),
            consequences = listOf(),
        ),
        EventSpecification(
            name = "Burial at C",
            description = "TODO",
            choices = setOf(),
            consequences = listOf(),
        ),
        EventSpecification(
            name = "Signal Haze",
            description = "TODO",
            choices = setOf(),
            consequences = listOf(),
        ),
        EventSpecification(
            name = "A Little More Light",
            description = "TODO",
            choices = setOf(),
            consequences = listOf(),
        ),
        EventSpecification(
            name = "Space Whales",
            description = "TODO",
            choices = setOf(),
            consequences = listOf(),
        ),
        EventSpecification(
            name = "Ma Nishtana",
            description = "TODO",
            choices = setOf(),
            consequences = listOf(),
        ),
        EventSpecification(
            name = "A System of Messages, 1281",
            description = "TODO",
            choices = setOf(),
            consequences = listOf(),
        ),
        EventSpecification(
            name = "Slow Burn",
            description = "TODO",
            choices = setOf(),
            consequences = listOf(),
        ),
        EventSpecification(
            name = "As The Stars Start to Align",
            description = "TODO",
            choices = setOf(),
            consequences = listOf(),
        ),
        EventSpecification(
            name = "Alien Spiders Are No Joke",
            description = "TODO",
            choices = setOf(),
            consequences = listOf(),
        ),
        EventSpecification(
            name = "Banned From Argo",
            description = "TODO",
            choices = setOf(),
            consequences = listOf(),
        ),
        EventSpecification(
            name = "Whalefall",
            description = "TODO",
            choices = setOf(),
            consequences = listOf(),
        ),
        EventSpecification(
            name = "The Point",
            description = "TODO",
            choices = setOf(),
            consequences = listOf(),
        ),
        EventSpecification(
            name = "Outside us",
            description = "TODO",
            choices = setOf(),
            consequences = listOf(),
        ),
    )

    private val template = EventSpecification(
        name = "asdf",
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
            Consequence(
                name = "asdf",
            ),
        ),
    )
}
