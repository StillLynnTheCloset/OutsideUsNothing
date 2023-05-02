package com.stilllynnthecloset.liboun.playbook

import com.stilllynnthecloset.liboun.model.Action
import com.stilllynnthecloset.liboun.model.ChoiceSpecification
import com.stilllynnthecloset.liboun.model.Option
import com.stilllynnthecloset.liboun.model.PlaySheetSpecification
import com.stilllynnthecloset.liboun.model.Question

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
                    options = setOf(
                        Option("A stapler"),
                        Option("A banking access"),
                        Option("A debt"),
                        Option("A badge"),
                        Option("A lingering sense of someone watching you"),
                        Option("A piece of proprietary tech or important intel"),
                        Option("An idea something was taken from you"),
                    ),
                    questions = listOf(
                        Question(
                            question = "Choose one thing you still carry with you from your corporation",
                            answers = 1,
                        ),
                    ),
                ),
                ChoiceSpecification(
                    options = setOf(
                        Option("A man"),
                        Option("A woman"),
                        Option("Quiet"),
                        Option("Professional or respectful"),
                        Option("A good, punctual, studious worker"),
                    ),
                    questions = listOf(
                        Question(
                            question = "Choose one thing your corporation asked you to be that you will never be again",
                            answers = 1,
                        ),
                    ),
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
