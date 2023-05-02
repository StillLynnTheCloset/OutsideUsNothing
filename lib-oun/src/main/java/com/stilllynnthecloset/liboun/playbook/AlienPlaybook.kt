package com.stilllynnthecloset.liboun.playbook

import com.stilllynnthecloset.liboun.model.Action
import com.stilllynnthecloset.liboun.model.ChoiceSpecification
import com.stilllynnthecloset.liboun.model.Option
import com.stilllynnthecloset.liboun.model.PlaySheetSpecification
import com.stilllynnthecloset.liboun.model.Question

/**
 * AlienPlaybook - TODO: Documentation
 *
 * Created by Lynn on 5/1/23
 */
public object AlienPlaybook {
    public val aliens: List<PlaySheetSpecification> = listOf(
        PlaySheetSpecification(
            name = "Terre",
            description = "“Earth? No, never heard of it. Is that one of those bits of corporate propaganda? That we all came from one world before slow generation ships? Prelapsarian BS.”\n" +
                    "\t-From an interview of a psychogogic manipulation addict in corporate space\n" +
                    "The terre are all people descended from humanity, and from us here and now. But after their long, long time traveling through the dark to this part of the universe, in vast generation ships, some have changed.\n",
            choices = listOf(
                ChoiceSpecification(
                    options = setOf(
                        Option("Spaceborne, adapted for null-G, fragile yet nimble on the float"),
                        Option("Genehacked, altered cosmetically, a different atmosphere, or anything"),
                        Option("Cybernetically enhanced, an added limb, galvanic thoughts, or anything"),
                        Option("Raised among exoterre, aliens, of your choice, adapting their culture"),
                        Option("Vampiric, lycanthropic, or afflicted by other magical alteration"),
                        Option("Baseline human, after everything"),
                    ),
                    questions = listOf(
                        Question(
                            question = "One your were and describe the way it has changed your life",
                            answers = 1,
                        ),
                    ),
                ),
            ),
            actions = listOf(
                Action(
                    description = "Make an incorrect assumption about something technical",
                    diceOffset = 1,
                ),
                Action(
                    description = "Accidentally minorly insult an exoterre",
                    diceOffset = 1,
                ),
                Action(
                    description = "Not know some bit of common knowledge about the wider universe",
                    diceOffset = 1,
                ),
                Action(
                    description = "Be unable to to do something because of whatever you picked above",
                    diceOffset = 1,
                ),
                Action(
                    description = "Think about the ancient people of Earth and what they might have thought about what is happening to you",
                    diceOffset = 1,
                ),
                Action(
                    description = "Do something else related to long ago lost Earth or the uniquely human",
                    diceOffset = 0,
                ),
                Action(
                    description = "Get another terre to work with you, play along",
                    diceOffset = -1,
                ),
                Action(
                    description = "Make an effort to bond with an exoterre",
                    diceOffset = -1,
                ),
                Action(
                    description = "Use whatever you picked above to physically solve a problem",
                    diceOffset = -1,
                ),
                Action(
                    description = "Use some knowledge of Earth to solve a problem",
                    diceOffset = -1,
                ),
            ),
        ),
        PlaySheetSpecification(
            name = "Angel",
            description = "“Lo brethren! We are cast out in this universe of dark! Rise up! Rise together for the glory of all angel-kind! Become the light that will pierce creation!”\n" +
                    "\t-Horizon Light, propaganda video released by Her Angelic Highness\n" +
                    "Something from outside the universe wrote you into this universe’s skin alone and without instruction. As a being of pure energy you are indestructible. But to interact with everything else, to have an identity, most angels, including you, have commissioned carved bodies for themselves. Fragile and fallible bodies that now shelter and identify you.",
            choices = listOf(
                ChoiceSpecification(
                    options = setOf(
                        Option("It’s made of clay and stone"),
                        Option("It’s made of metal and plastic"),
                        Option("It’s made of glass and crystal"),
                        Option("It’s utterly unique in the universe"),
                        Option("It looks common and boring"),
                        Option("It looks almost organic"),
                        Option("It has multiple wings"),
                    ),
                    questions = listOf(
                        Question(
                            question = "Two qualities of your physical body",
                            answers = 2,
                        ),
                    ),
                ),
                ChoiceSpecification(
                    options = setOf(
                        Option("You’re a man or masculine"),
                        Option("You’re a woman or feminine"),
                        Option("Your body will age and decay"),
                        Option("You’re bound to one location"),
                        Option("Your body’s mind can be wrong"),
                        Option("Your body cannot do some things"),
                        Option("Other people judge your body"),
                        Option("You have altered your body"),
                        Option("You have altered your body"),
                        Option("Your body cannot do some things"),
                    ),
                    questions = listOf(
                        Question(
                            question = "Three limits given to you by your body, and decide if you love them or wish you could get rid of them",
                            answers = 3,
                        ),
                    ),
                ),
            ),
            actions = listOf(
                Action(
                    description = "Have your body be unable to do something",
                    diceOffset = 1,
                ),
                Action(
                    description = "Have your body hurt or break",
                    diceOffset = 1,
                ),
                Action(
                    description = "Mourn for when you were immortal energy",
                    diceOffset = 1,
                ),
                Action(
                    description = "Do something else as a being written into the skin of the universe",
                    diceOffset = 0,
                ),
                Action(
                    description = "Momentarily have your energy leave your body to solve a problem",
                    diceOffset = -1,
                ),
                Action(
                    description = "Move impossibly quick, be impossibly strong, defy the laws of physics, or otherwise break limits",
                    diceOffset = -3,
                ),
                Action(
                    description = "If possible, modify your body",
                    diceOffset = -5,
                ),
            ),
        ),
    )
}
