package com.stilllynnthecloset.liboun.playbook

import com.stilllynnthecloset.liboun.model.Action
import com.stilllynnthecloset.liboun.model.ChoiceSpecification
import com.stilllynnthecloset.liboun.model.PlaySheetSpecification

/**
 * BackgroundPlaybook - TODO: Documentation
 *
 * Created by Lynn on 5/1/23
 */
public object BackgroundPlaybook {
    public val backgrounds: List<PlaySheetSpecification> = listOf(
        PlaySheetSpecification(
            name = "The Corporate Citoyen",
            description = "“Relativation 189 DiemBucks per period, air 177 DiemBucks, food 480, water 230, medical 1060, heat 108, light 98. They have a station tax too, of course.”\n" +
                    "\t-Resident quoting DiemCo policy for life on station Calypso Transcend\n" +
                    "You used to be someone rich enough to afford citizenship from one of the big interstellar corporations. Life was different back then. You had healthcare. Knew where the next meal was coming from. And were always watched and controlled.\n",
            choices = listOf(
                ChoiceSpecification(
                    question = "Choose one thing you still carry with you from your corporation",
                    options = setOf(
                        "A stapler",
                        "A banking access",
                        "A debt",
                        "A badge",
                        "A lingering sense of someone watching you",
                        "A piece of proprietary tech or important intel",
                        "An idea something was taken from you",
                    ),
                    numberOfPositiveSelections = 1,
                    numberOfNegativeSelections = 0,
                ),
                ChoiceSpecification(
                    question = "Choose one thing your corporation asked you to be that you will never be again",
                    options = setOf(
                        "A man",
                        "A woman",
                        "Quiet",
                        "Professional or respectful",
                        "A good, punctual, studious worker",
                    ),
                    numberOfPositiveSelections = 1,
                    numberOfNegativeSelections = 0,
                ),
            ),
            actions = listOf(
                Action(
                    description = "Brag insensitively about how you used to live",
                    diceOffset = 1,
                ),
                Action(
                    description = "Struggle to handle being poor",
                    diceOffset = 1,
                ),
                Action(
                    description = "Make a mistake about how much something costs",
                    diceOffset = 1,
                ),
                Action(
                    description = "Think about how far you have fallen",
                    diceOffset = 1,
                ),
                Action(
                    description = "Do something related to your former employment",
                    diceOffset = 0,
                ),
                Action(
                    description = "Play on insecurities, play people against each other",
                    diceOffset = -1,
                ),
                Action(
                    description = "Realize a hidden power dynamic",
                    diceOffset = -1,
                ),
                Action(
                    description = "Use your former corporate position or corporate knowledge to solve a problem",
                    diceOffset = -1,
                ),
            ),
        ),
    )
}
