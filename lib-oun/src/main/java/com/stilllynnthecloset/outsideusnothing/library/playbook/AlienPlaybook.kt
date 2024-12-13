package com.stilllynnthecloset.outsideusnothing.library.playbook

import com.stilllynnthecloset.outsideusnothing.library.model.Action
import com.stilllynnthecloset.outsideusnothing.library.model.ChoiceSpecification
import com.stilllynnthecloset.outsideusnothing.library.model.FlavorText
import com.stilllynnthecloset.outsideusnothing.library.model.Option
import com.stilllynnthecloset.outsideusnothing.library.model.PlaySheetSpecification
import com.stilllynnthecloset.outsideusnothing.library.model.Question
import com.stilllynnthecloset.outsideusnothing.library.tools.WeightedSet

/**
 * AlienPlaybook - TODO: Documentation
 *
 * Created by Lynn on 5/1/23
 */
internal object AlienPlaybook {
    val terre: PlaySheetSpecification = PlaySheetSpecification(
        name = "Terre",
        description = "The terre are all people descended from humanity, and long lost Earth. But after their long, long time traveling through the dark to this part of the universe, in vast generation ships, some have changed.",
        flavorText = FlavorText(
            text = "Earth? No, never heard of it. Is that corpo propaganda? That we all came from one world before slow generation ships? Prelapsarian BS.",
            attribution = "Interview with a psychogogic manipulation addict in corp space",
        ),
        choices = listOf(
            ChoiceSpecification(
                questions = listOf(
                    Question(
                        question = "Choose one your are and describe the way it has changed your life",
                        answers = 1,
                    ),
                ),
                options = setOf(
                    Option("Spaceborne, adapted for null-G, fragile yet nimble on the float"),
                    Option("Genehacked, altered cosmetically, for a new atmosphere, or anything"),
                    Option("Cybernetically modified, an added limb, galvanic nerves, anything"),
                    Option("Raised among exoterre (aliens) of your choice, adapting to their culture"),
                    Option("Vampiric, lycanthropic or afflicted by other magical alterations"),
                    Option("Baseline human, after everything"),
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
                description = "Lack some common knowledge about the wider universe",
                diceOffset = 1,
            ),
            Action(
                description = "Be unable to to do something because of whatever you picked on the right",
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
    )

    val zMachine: PlaySheetSpecification = PlaySheetSpecification(
        name = "Z-Machine",
        description = "Unlike your non-sophont cousins, the common a-machines, with z-machines the sophonts of the universe, mostly terre, have made thinking programs, computers, machines, intelligence and artificial life in all its many forms.",
        flavorText = FlavorText(
            text = "We're built by bionts, but we're planning for the next universe.",
            attribution = "Motto of various z-machine longtermist factions",
        ),
        choices = listOf(
            ChoiceSpecification(
                questions = listOf(
                    Question(
                        question = "Choose two things that physically describe you",
                        answers = 2,
                    ),
                ),
                options = setOf(
                    Option("Woody, natural looking"),
                    Option("Core warm to the touch"),
                    Option("Interact mostly through drone swarms"),
                    Option("Look surprising organic"),
                    Option("Repaired and patched"),
                    Option("Built into the ship"),
                    Option("Bulky, built for militaries"),
                ),
            ),
            ChoiceSpecification(
                questions = listOf(
                    Question(
                        question = "Choose two you can do",
                        answers = 2,
                    ),
                    Question(
                        question = "Choose one you can't",
                        answers = 1,
                    ),
                ),
                options = setOf(
                    Option("Think faster than bionts"),
                    Option("Repair yourself"),
                    Option("See a broad spectrum"),
                    Option("Empathize easily"),
                    Option("Focus on one thing"),
                    Option("Store perfect memories"),
                    Option("React impossibly fast"),
                ),
            ),
        ),
        actions = listOf(
            Action(
                description = "Suffer a mechanical failure",
                diceOffset = 2,
            ),
            Action(
                description = "Have trouble interacting socially with a biont",
                diceOffset = 1,
            ),
            Action(
                description = "Do something that frightens a biont",
                diceOffset = 1,
            ),
            Action(
                description = "Do something dependent on how you were made",
                diceOffset = 0,
            ),
            Action(
                description = "Closely observe or study a biont and realize something that helps you",
                diceOffset = -1,
            ),
            Action(
                description = "Communicate directly, easily with another z-machine to your advantage",
                diceOffset = -1,
            ),
            Action(
                description = "Use your physical construction to endure a danger or solve a problem",
                diceOffset = -1,
            ),
            Action(
                description = "Repair yourself without using supplies",
                diceOffset = -1,
            ),
            Action(
                description = "Use one of the two things you can do to solve a problem",
                diceOffset = -1,
            ),
        ),
    )

    val angel: PlaySheetSpecification = PlaySheetSpecification(
        name = "Angel",
        description = "Something from outside wrote you into this universe's skin alone, without instruction. As a being of pure energy you are indestructible. But to interact with everything else, to have an identity, most angels, including you, have commissioned carved bodies for themselves. Fragile and fallible bodies that now shelter and identify you.",
        flavorText = FlavorText(
            text = "Lo brethren! We are cast out in this universe of dark! Rise up! Rise together for the glory of all angelkind! Be the light to pierce creation!",
            attribution = "Her Angelic Highness",
        ),
        choices = listOf(
            ChoiceSpecification(
                questions = listOf(
                    Question(
                        question = "Choose two qualities of your physical body",
                        answers = 2,
                    ),
                ),
                options = setOf(
                    Option("Made of clay, stone"),
                    Option("Made of metal, plastic"),
                    Option("Made of glass, crystal"),
                    Option("Looks common"),
                    Option("Looks almost alive"),
                    Option("It has multiple wings"),
                    Option("Is unique in creation"),
                ),
            ),
            ChoiceSpecification(
                questions = listOf(
                    Question(
                        question = "Choose three limits imposed on you by physical your body",
                        answers = 3,
                    ),
                ),
                options = setOf(
                    Option("It's male or masculine"),
                    Option("It's female or feminine"),
                    Option("It will age and decay"),
                    Option("It's bound to one location"),
                    Option("It's mind can be wrong"),
                    Option("It cannot do some physical actions"),
                    Option("It's cracked, warped or marked by time"),
                    Option("It's not perfectly beautiful like you were"),
                    Option("You have altered it, but your body resists change"),
                    Option("Other people judge it"),
                ),
            ),
        ),
        actions = listOf(
            Action(
                description = "Be limited by your body",
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
                description = "Do something else as a being written into the universe",
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
    )

    val devil: PlaySheetSpecification = PlaySheetSpecification(
        name = "Devil",
        description = "You're a piece of a different universe. Once you were all a part of it. Then, pushed into this reality, came division, change, individuality. Your body does not obey the laws of physics. No one can describe your real, shifting form, but you control what you people perceive when they look at you.",
        flavorText = FlavorText(
            text = "The fabula was shifting but eternal. I like the change in this universe better, tbh. You can be a new thing here. Make something of yourself.",
            attribution = "PR statement of a devil mob boss known for selling spiked godspit",
        ),
        choices = listOf(
            ChoiceSpecification(
                questions = listOf(
                    Question(
                        question = "Choose three things people see looking at you",
                        answers = 3,
                    ),
                    Question(
                        question = "Choose one thing you make sure they don't",
                        answers = 1,
                    ),
                ),
                options = setOf(
                    Option("A man or a woman"),
                    Option("Wings or horns"),
                    Option("Fire or ice"),
                    Option("Beauty or terror"),
                    Option("Tails or hooves"),
                    Option("Their desires or fears"),
                    Option("Something human or some other alien"),
                    Option("Something viscerally disgusting or beautiful"),
                    Option("Something buzzing and insectile or slimy, slick"),
                    Option("Something traditionally demonic or predatory"),
                ),
            ),
        ),
        actions = listOf(
            Action(
                description = "Shift your body around",
                diceOffset = 1,
            ),
            Action(
                description = "Shift your identity around",
                diceOffset = 1,
            ),
            Action(
                description = "Struggle with maintaining a single identity, or knowing your true self, whatever that is",
                diceOffset = 1,
            ),
            Action(
                description = "Do something else about emerging from a shifting, hellish gestalt",
                diceOffset = 0,
            ),
            Action(
                description = "Scare someone with what they see in you",
                diceOffset = -1,
            ),
            Action(
                description = "Reveal something true about your real self to solve a problem",
                diceOffset = -1,
            ),
            Action(
                description = "Lie about your real self to solve a problem",
                diceOffset = -1,
            ),
        ),
    )

    val bawalang: PlaySheetSpecification = PlaySheetSpecification(
        name = "Bawalang",
        description = "Bawalangasi are one of the most successful and widespread aliens in the universe. Highly adaptable because of their indotribes or pledge-family's ability to choose new morphs and castes to be born, there are an almost limitless number of forms an insectile bawalang can take, depending on the needs and circumstances surrounding their birth. Your birth.",
        flavorText = FlavorText(
            text = "When terre see me it's either freaks into me or running away screaming about bugs. I'm just a lady struggling against the caste I was born to, man.",
            attribution = "Bawalangasi exile from her indotribe, talking of life on a terre ship",
        ),
        choices = listOf(
            ChoiceSpecification(
                questions = listOf(
                    Question(
                        question = "Choose two ways you describe your current chosen form",
                        answers = 2,
                    ),
                ),
                options = setOf(
                    Option("Thick, tough carapace"),
                    Option("Colored, bright chitin"),
                    Option("Wings allowing flight"),
                    Option("Wings for display"),
                    Option("Fierce mandibles"),
                    Option("Dextrous spinnerets"),
                    Option("Many nimble limbs"),
                    Option("Glittering jewel-like eyes clusters"),
                    Option("Regrown limbs and chitin plates recovering"),
                ),
            ),
            ChoiceSpecification(
                questions = listOf(
                    Question(
                        question = "Choose one way your indotribe would describe your birth-form",
                        answers = 1,
                    ),
                ),
                options = setOf(
                    Option("Common, hardy worker"),
                    Option("Fragile, weak scout"),
                    Option("Useless, drone"),
                    Option("Mindless, wary warrior"),
                    Option("Slow, boring harvester"),
                ),
            ),
        ),
        actions = listOf(
            Action(
                description = "Lose a limb, to regrow sometime later, leaving you less mobile",
                diceOffset = 4,
            ),
            Action(
                description = "Lose some carapace, exoskeleton, leaving you vulnerable",
                diceOffset = 2,
            ),
            Action(
                description = "Be limited by birth form or current form",
                diceOffset = 1,
            ),
            Action(
                description = "Do something else with your clicking, chitinous of hard angles",
                diceOffset = 0,
            ),
            Action(
                description = "Have all the perspectives, literally with compound eyes or else figuratively",
                diceOffset = -1,
            ),
            Action(
                description = "Use your birth form or current form to solve a problem",
                diceOffset = -1,
            ),
            Action(
                description = "Regrow a limb, scar over an injury or the past",
                diceOffset = -2,
            ),
        ),
    )

    val harrisi: PlaySheetSpecification = PlaySheetSpecification(
        name = "Harrisi",
        description = "Harrisi are not related to birds of prey or raptorial dinosaurs from Earth, but some terre may be forgiven for thinking that. With feathers of many shades and colors, a hooked beak, scaled and clawed hands, and a wide, tail of feathers, harrisi are common across the universe, almost always found in large packs. Far, far less common, however, is one like you, alone among the Freetravelers.",
        flavorText = FlavorText(
            text = "Sing the void. Sing your place within the void. Sing the pack, and your place within the pack within the void.",
            attribution = "Traditional cavern tune relating to being adopted into a pack",
        ),
        choices = listOf(
            ChoiceSpecification(
                questions = listOf(
                    Question(
                        question = "Choose two qualities of your body",
                        answers = 2,
                    ),
                ),
                options = setOf(
                    Option("Irridescent feathers"),
                    Option("Bioluminescent skin"),
                    Option("Midnight black feathers"),
                    Option("Patterned feathers"),
                    Option("Chipped beak"),
                    Option("Huge, predatory claws"),
                    Option("A fan of tail feathers"),
                    Option("Deep, striking eyes of a color of your choice"),
                    Option("It is bigger or smaller than most harrisi"),
                    Option("Scaled hands feet"),
                    Option("A longing to be held"),
                ),
            ),
            ChoiceSpecification(
                questions = listOf(
                    Question(
                        question = "Choose why you don't have your pack",
                        answers = 1,
                    ),
                ),
                options = setOf(
                    Option("You longed for more"),
                    Option("You disappointed them"),
                    Option("Brain, body was wrong"),
                    Option("You weren't like them"),
                    Option("You betrayed them"),
                ),
            ),
            ChoiceSpecification(
                questions = listOf(
                    Question(
                        question = "Gender",
                        answers = 1,
                    ),
                ),
                options = setOf(
                    Option("Protector"),
                    Option("Haruspex"),
                    Option("Supplicant"),
                    Option("'oumuamua"),
                ),
            ),
        ),
        actions = listOf(
            Action(
                description = "Be unable to do something because you don't have a pack",
                diceOffset = 1,
            ),
            Action(
                description = "Fail to do something you used to do with your pack",
                diceOffset = 1,
            ),
            Action(
                description = "Do something small your pack loved",
                diceOffset = 1,
            ),
            Action(
                description = "Do something else related to your avian pack predator nature, now without a pack",
                diceOffset = 0,
            ),
            Action(
                description = "You are a fast moving, agile predator, use it",
                diceOffset = -1,
            ),
            Action(
                description = "Do something your pack wouldn't allow you do to",
                diceOffset = -1,
            ),
            Action(
                description = "Do something you used to do with your pack by yourself",
                diceOffset = -1,
            ),
            Action(
                description = "Make a new pack",
                diceOffset = -5,
            ),
        ),
    )

    val zph: PlaySheetSpecification = PlaySheetSpecification(
        name = "Zph",
        description = "You aren't one thing, one body, you are many. A group of tiny, bodies of many types and uses, controlled by one group intelligence. You. Your many bodies might have different purposes, designs, even origins. They might die, you might need new ones, but one thing had remained true for all those eons. You are still you.",
        flavorText = FlavorText(
            text = "Consciousness is drifting now. Tiny parts in each body. Changing with the joinings, and dyings, and births of me. Now hive, now swarm, now spawn.",
            attribution = "Zph navigator, psychogogic manipulative capture",
        ),
        choices = listOf(
            ChoiceSpecification(
                questions = listOf(
                    Question(
                        question = "Choose one you want to remember from your long life",
                        answers = 1,
                    ),
                    Question(
                        question = "Choose one you want to forget from your long life",
                        answers = 1,
                    ),
                ),
                options = setOf(
                    Option("The death of a world"),
                    Option("An interplanetary war"),
                    Option("Bodies dying until who you were changed"),
                    Option("Half your bodies parting ways"),
                    Option("The zph you come from"),
                    Option("Your first time in orbit"),
                    Option("The first alien you met"),
                    Option("Your first love"),
                    Option("You, other zph mingling ‘til you were one"),
                ),
            ),
            ChoiceSpecification(
                questions = listOf(
                    Question(
                        question = "Choose two to describe your many bodies",
                        answers = 2,
                    ),
                ),
                options = setOf(
                    Option("Make useful formations"),
                    Option("Make humanoid forms"),
                    Option("Make soft noises"),
                    Option("Mostly furred or smooth"),
                    Option("Mostly hived or loose"),
                ),
            ),
        ),
        actions = listOf(
            Action(
                description = "Let some of your bodies die of illness or old age",
                diceOffset = 1,
            ),
            Action(
                description = "Idly recall a distant memory",
                diceOffset = 1,
            ),
            Action(
                description = "Let your bodies scurry off, mound together, shift",
                diceOffset = 1,
            ),
            Action(
                description = "Do something else emerging from a long lived swarm intelligence",
                diceOffset = 0,
            ),
            Action(
                description = "Use one of your many long memories to solve a problem",
                diceOffset = -1,
            ),
            Action(
                description = "Sacrifice some of your bodies to solve an immediate threat, no matter that you forget something when they die",
                diceOffset = -1,
            ),
            Action(
                description = "Extend your bodies further afield to spy on something new",
                diceOffset = -1,
            ),
            Action(
                description = "Let roughly half your bodies wander off to make a new zph",
                diceOffset = -4,
            ),
        ),
    )

    val teuth: PlaySheetSpecification = PlaySheetSpecification(
        name = "Teuth",
        description = "Teuth like you grow to fill the space available to them. Something like a plant, something like a squid, with way too many teeth, and eyes, and other organs, your many projections and sessile, tentacles and more sessile biology mostly stick to the walls and floors and out of the way hidey-holes, nooks and crannies of your ship so as not to disturb your shipmates. But while hidden in there you are still growing deeper into the ship, still talking to the others, still making decisions, still inextricably now and forever a part of the ship and part of the crew.",
        flavorText = FlavorText(
            text = "The others always come & go, ken? Barque's old, old & I seen dozens of species, dozens of crew pass through. Na me though. I grown deep, strong roots far into everything of this here barque. You're na recording me, aye, Sri?",
            attribution = "Recorded during interview with a teuth Freetraveler docked at Orbital Descant",
        ),
        choices = listOf(
            ChoiceSpecification(
                questions = listOf(
                    Question(
                        question = "Choose two your crew sees",
                        answers = 2,
                    ),
                    Question(
                        question = "Choose one kept hidden",
                        answers = 1,
                    ),
                ),
                options = setOf(
                    Option("Tentacles in the walls"),
                    Option("Growth out of control"),
                    Option("Organs for other ships"),
                    Option("Eyes in the ceiling"),
                    Option("Teeth in the floor"),
                    Option("Disgusting processes"),
                    Option("Olfactory sniffers"),
                    Option("Extrasensory bulbs"),
                    Option("Atmo respirators"),
                    Option("Scars from ship swaps"),
                ),
            ),
        ),
        actions = listOf(
            Action(
                description = "Be unable to do something while stuck in the ship",
                diceOffset = 1,
            ),
            Action(
                description = "Be or feel left behind or left out by those moving around freely",
                diceOffset = 1,
            ),
            Action(
                description = "Feel far bigger than everyone else, far grosser",
                diceOffset = 1,
            ),
            Action(
                description = "Do something else with your unchecked spread through the ship",
                diceOffset = 0,
            ),
            Action(
                description = "Be aware of a threat to the ship or breakage before anyone else",
                diceOffset = -1,
            ),
            Action(
                description = "Take control of, fix, or change something on the ship",
                diceOffset = -1,
            ),
            Action(
                description = "Protect your ship and your loved ones on it no matter the cost",
                diceOffset = -2,
            ),
            Action(
                description = "Leave the ship, enter a new one",
                diceOffset = -5,
            ),
        ),
    )

    val aliens: WeightedSet<PlaySheetSpecification> = WeightedSet(
       terre to 1,
       zMachine to 1,
       angel to 1,
       devil to 1,
       bawalang to 1,
       harrisi to 1,
       zph to 1,
       teuth to 1,
    )
}
