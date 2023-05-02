package com.stilllynnthecloset.liboun.playbook

import com.stilllynnthecloset.liboun.model.Action
import com.stilllynnthecloset.liboun.model.ChoiceSpecification
import com.stilllynnthecloset.liboun.model.PlaySheetSpecification

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
                    question = "Choose one your were and describe the way it has changed your life",
                    options = setOf(
                        "Spaceborne, adapted for null-G, fragile yet nimble on the float",
                        "Genehacked, altered cosmetically, a different atmosphere, or anything",
                        "Cybernetically enhanced, an added limb, galvanic thoughts, or anything",
                        "Raised among exoterre, aliens, of your choice, adapting their culture",
                        "Vampiric, lycanthropic, or afflicted by other magical alteration",
                        "Baseline human, after everything",
                    ),
                    numberOfPositiveSelections = 1,
                    numberOfNegativeSelections = 0,
                )
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
                    question = "Choose two qualities of your physical body",
                    options = setOf(
                        "It’s made of clay and stone",
                        "It’s made of metal and plastic",
                        "It’s made of glass and crystal",
                        "It’s utterly unique in the universe",
                        "It looks common and boring",
                        "It looks almost organic",
                        "It has multiple wings",
                    ),
                    numberOfPositiveSelections = 2,
                    numberOfNegativeSelections = 0,
                ),
                ChoiceSpecification(
                    question = "Choose three limits given to you by your body, and decide if you love them or wish you could get rid of them:",
                    options = setOf(
                        "You’re a man or masculine",
                        "You’re a woman or feminine",
                        "Your body will age and decay",
                        "You’re bound to one location",
                        "Your body’s mind can be wrong",
                        "Your body cannot do some things",
                        "Other people judge your body",
                        "You have altered your body",
                        "You have altered your body",
                        "Your body cannot do some things",
                    ),
                    numberOfPositiveSelections = 3,
                    numberOfNegativeSelections = 0,
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
