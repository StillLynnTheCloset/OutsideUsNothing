package com.stilllynnthecloset.liboun.playbook

import com.stilllynnthecloset.liboun.model.Action
import com.stilllynnthecloset.liboun.model.ChoiceSpecification
import com.stilllynnthecloset.liboun.model.PlaySheetSpecification

/**
 * BackgroundPlaybook - TODO: Documentation
 *
 * Created by Lynn on 5/1/23
 */
public object RolePlaybook {
    public val roles: List<PlaySheetSpecification> = listOf(
        PlaySheetSpecification(
            name = "Space Wizard",
            description = "“Wonder before the universe. Then understand it. And then, through understanding, master it.”\n" +
                    "\t-Traditional Vomyodosoi saying\n" +
                    "Wizards have long studied the many magics of the etheric sea. The all black everything. Space. And you are no different. Your mind explodes with arcane knowledge and anywhere in the universe will recognize your mastery of the art!\n",
            choices = listOf(
                ChoiceSpecification(
                    question = "Choose two words that describe your magic",
                    options = setOf(
                        "Dark",
                        "Tentacular",
                        "Gravitational",
                        "Mechanical",
                        "Frantic",
                        "Stellar",
                        "Distant",
                        "Precise",
                        "Crystalline",
                        "Bloody",
                        "Void",
                        "Eldritch",
                        "Fiery",
                        "Contractual",
                        "Mathematical",
                        "Temporal",
                        "Primal",
                        "Cold",
                        "Cursed",
                    ),
                    numberOfPositiveSelections = 2,
                    numberOfNegativeSelections = 0,
                )
            ),
            actions = listOf(
                Action(
                    description = "Accidentally cast one spell you’ve learned and hurt yourself or others. When you do this roll a d6 to randomize your spells",
                    diceOffset = 1,
                ),
                Action(
                    description = "Be very confident, study the arcane or do something else wizardous",
                    diceOffset = 1,
                ),
                Action(
                    description = "Craft a theoretical spell based on the adjectives you chose above. Convince the table your adjectives apply. Describe the theory.",
                    diceOffset = 0,
                ),
                Action(
                    description = "Learn that spell by asking the table if you can, then write it down. Describe how you learn it and what it feels like. Learn up to six spells this way.",
                    diceOffset = -1,
                ),
                Action(
                    description = "Cast a spell that you have previously learned",
                    diceOffset = -1,
                ),
                Action(
                    description = "Solve a problem through your arcane knowledge",
                    diceOffset = -1,
                ),
                Action(
                    description = "Combine two learned spells into one",
                    diceOffset = -3,
                ),
                Action(
                    description = "Forget a spell, erase it from your list",
                    diceOffset = -3,
                ),
                Action(
                    description = "Add a new adjective to your magic",
                    diceOffset = -5,
                ),
                Action(
                    description = "Learn a seventh spell, break the limits",
                    diceOffset = -7,
                ),
            ),
        ),
        PlaySheetSpecification(
            name = "Muscled Tough",
            description = "“Yes, I fought on Winnipeg. Fought for SaintsCo when the Constabulary invaded, fought for the union when the Shrouds moved in, took over. Still fighting.”\n" +
                    "\t-Former Syndicalist partisan, on a follow up interview\n" +
                    "It’s all well and good to magic, fly, science, and talk your way out of problems but let’s be honest, the universe isn’t always going to play nice. You’re here for when it doesn’t, for when people would threaten you, your ship, and the people you love.",
            choices = listOf(
                ChoiceSpecification(
                    question = "Choose two things you keep on you at all times, and two things that always scare you when you see them",
                    options = setOf(
                        "A pistol",
                        "A polearm",
                        "Brass knuckles",
                        "A head on a swivel",
                        "A too-casual posture",
                        "A knife",
                        "A rifle",
                        "Boots for kicking",
                        "A defiant stare",
                        "First aid at the ready",
                        "A sword",
                        "A shock-stick",
                        "A steady hand",
                        "A chip on a shoulder",
                    ),
                    numberOfPositiveSelections = 2,
                    numberOfNegativeSelections = 2,
                )
            ),
            actions = listOf(
                Action(
                    description = "Hurt someone on accident",
                    diceOffset = 3,
                ),
                Action(
                    description = "Have a false alarm thinking you see one of the things that scares you",
                    diceOffset = 1,
                ),
                Action(
                    description = "Panic when you do really see one of the things that scares you",
                    diceOffset = 1,
                ),
                Action(
                    description = "Be too anxious to do something",
                    diceOffset = 1,
                ),
                Action(
                    description = "Scan your surroundings, check yourself, or do something else warily",
                    diceOffset = 0,
                ),
                Action(
                    description = "Endure a threat or avoid harm",
                    diceOffset = -1,
                ),
                Action(
                    description = "Hurt someone nearby you on purpose",
                    diceOffset = -1,
                ),
                Action(
                    description = "Intimidate someone with something you always keep on you",
                    diceOffset = -1,
                ),
                Action(
                    description = "Spot one of the things that scares you before it becomes a threat",
                    diceOffset = -1,
                ),
                Action(
                    description = "Use one of the things you always keep on you for something new",
                    diceOffset = -1,
                ),
                Action(
                    description = "Use one of the thing you always keep on you to protect someone else",
                    diceOffset = -2,
                ),
                Action(
                    description = "Learn to live with one of the things that scare you, pick something new",
                    diceOffset = -5,
                ),
                Action(
                    description = "Let go of one of the things you hold onto, pick up something new",
                    diceOffset = -5,
                ),
            ),
        ),
    )
}
