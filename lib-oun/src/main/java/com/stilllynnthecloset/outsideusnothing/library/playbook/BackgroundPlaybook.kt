package com.stilllynnthecloset.outsideusnothing.library.playbook

import com.stilllynnthecloset.outsideusnothing.library.model.Action
import com.stilllynnthecloset.outsideusnothing.library.model.ChoiceSpecification
import com.stilllynnthecloset.outsideusnothing.library.model.FlavorText
import com.stilllynnthecloset.outsideusnothing.library.model.Option
import com.stilllynnthecloset.outsideusnothing.library.model.PlaySheetSpecification
import com.stilllynnthecloset.outsideusnothing.library.model.Question
import com.stilllynnthecloset.outsideusnothing.library.model.Weighted

/**
 * BackgroundPlaybook - TODO: Documentation
 *
 * Created by Lynn on 5/1/23
 */
internal object BackgroundPlaybook {
    val corpoCitoyen: PlaySheetSpecification = PlaySheetSpecification(
        name = "The Corpo Citoyen",
        description = "You used to be someone rich enough to afford citizenship from one of the big interstellar corporations. Life was different. You had healthcare. Knew where the next meal was coming from. Were always watched and controlled.",
        flavorText = FlavorText(
            text = "Relativation 189 DiemBucks per period, air 177 DiemBucks, food 480, water 230, medical 1060, heat 108, light 98. They have a station tax too.",
            attribution = "Resident quoting DiemCo policy for life on station Calypso Transcend",
        ),
        choices = listOf(
            ChoiceSpecification(
                questions = listOf(
                    Question(
                        question = "Choose one you still carry from the corp",
                        answers = 1,
                    ),
                ),
                options = setOf(
                    Option("A stapler or badge"),
                    Option("A debt or bank access"),
                    Option("A sense of surveillance"),
                    Option("Important intel or tech"),
                    Option("A sense of loss, theft"),
                ),
            ),
            ChoiceSpecification(
                questions = listOf(
                    Question(
                        question = "Choose one your corp asked you to be you will never be again",
                        answers = 1,
                    ),
                ),
                options = setOf(
                    Option("A man"),
                    Option("A woman"),
                    Option("Quiet"),
                    Option("Professional or respectful"),
                    Option("A good, punctual, studious worker"),
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
                description = "Realize a hidden or concealed power dynamic",
                diceOffset = -1,
            ),
            Action(
                description = "Use your former corporate position or corporate knowledge to solve a problem",
                diceOffset = -1,
            ),
        ),
    )

    val indenture: PlaySheetSpecification = PlaySheetSpecification(
        name = "The Indenture",
        description = "Debt, hunger, or desperation. For some reason you signed your freedom to a corporation, agreeing to hard labor in exchange for some theoretical future payment. You realized there was no way out of the contract. So you ran.",
        flavorText = FlavorText(
            text = "“DiemCo threatened to space me from Transcend Calypso for not paying the relativation fee. Relativation, artificial gravity, that was dangerously cheap.",
            attribution = "Indenture in a orichalcum mine, explaining why he signed his contract",
        ),
        choices = listOf(
            ChoiceSpecification(
                questions = listOf(
                    Question(
                        question = "Choose what the corp had you working on",
                        answers = 1,
                    ),
                ),
                options = setOf(
                    Option("Engine repair"),
                    Option("Ship scrapping"),
                    Option("Asteroid mining"),
                    Option("Scrap dump diving"),
                    Option("Intensive stack farming"),
                    Option("Crust cracking worlds"),
                    Option("Space sweeping"),
                    Option("Crowd control"),
                ),
            ),
            ChoiceSpecification(
                questions = listOf(
                    Question(
                        question = "Choose your escape",
                        answers = 1,
                    ),
                ),
                options = setOf(
                    Option("Smuggled out"),
                    Option("Stowed away"),
                    Option("Someone helped you"),
                    Option("Rioted, fought your way"),
                ),
            ),
        ),
        actions = listOf(
            Action(
                description = "Ache from the physical toll of labor",
                diceOffset = 1,
            ),
            Action(
                description = "Miss what your life had been before your contract",
                diceOffset = 1,
            ),
            Action(
                description = "Loathe the company and what they did to you and your body",
                diceOffset = 1,
            ),
            Action(
                description = "Loathe yourself for ever signing that damned contract at all",
                diceOffset = 1,
            ),
            Action(
                description = "Do something you only do because of your old debts, your old labor",
                diceOffset = 0,
            ),
            Action(
                description = "Endure, persist through something that should have hurt you",
                diceOffset = -1,
            ),
            Action(
                description = "Use one of the things you worked on to solve a problem",
                diceOffset = -1,
            ),
            Action(
                description = "Use something of how you escaped to solve a problem",
                diceOffset = -1,
            ),
            Action(
                description = "Fight the company or any ingrained power structure",
                diceOffset = -2,
            ),
            Action(
                description = "Go back to something of your old life from before",
                diceOffset = -3,
            ),
        ),
    )

    val bornWanderer: PlaySheetSpecification = PlaySheetSpecification(
        name = "The Born Wanderer",
        description = "You're the rare specimen born into Freetraveling. Maybe you're young, maybe you're experienced, maybe your story started on a different ship, maybe you left and came back. But you know this life between the stars out in the black like nothing else.",
        flavorText = FlavorText(
            text = "“Freetravelers? Yeah, few million of us. Scattered across megalightperiods of space at minimum. Na many. Most live it ‘til find-su world to settle in.",
            attribution = "Freetraveler, an Alternative, bootleg documentary banned in most polities",
        ),
        choices = listOf(
            ChoiceSpecification(
                questions = listOf(
                    Question(
                        question = "Choose one you still carry with you from your first Freetraveling ship",
                        answers = 1,
                    ),
                ),
                options = setOf(
                    Option("Something from your parents, sibling, family"),
                    Option("Something of the physical ship itself"),
                    Option("Something from someone who died"),
                    Option("Something of a friend"),
                    Option("Something of a mentor"),
                    Option("Something worth a lot of money"),
                    Option("Something intangible in your memory"),
                ),
            ),
            ChoiceSpecification(
                questions = listOf(
                    Question(
                        question = "Choose what happened to your first ship",
                        answers = 1,
                    ),
                ),
                options = setOf(
                    Option("It's still sailing"),
                    Option("It's there, just not home"),
                    Option("It won't let you back"),
                    Option("It was destroyed"),
                    Option("It was sold"),
                ),
            ),
        ),
        actions = listOf(
            Action(
                description = "Be confused by planets or the people who live on them",
                diceOffset = 1,
            ),
            Action(
                description = "Speak the cant and the slang so someone can't understand",
                diceOffset = 1,
            ),
            Action(
                description = "Tell too many stories about what it was like growing up",
                diceOffset = 1,
            ),
            Action(
                description = "Do something Freetravelers in all their wondrous diversity do",
                diceOffset = 0,
            ),
            Action(
                description = "Try to get diverse people to reach consensus and work together",
                diceOffset = -1,
            ),
            Action(
                description = "Try to get someone to help someone in need altruistically",
                diceOffset = -1,
            ),
            Action(
                description = "Meet someone from your past at a good time",
                diceOffset = -1,
            ),
            Action(
                description = "Have someone from your past help you",
                diceOffset = -2,
            ),
        ),
    )

    val veteran: PlaySheetSpecification = PlaySheetSpecification(
        name = "The Veteran",
        description = "The universe is not calm. Corporations vie for control of worlds, aliens clash, old prejudices and angers reappear. You used to fight in one of these many conflicts. But you did something not all can. You walked away",
        flavorText = FlavorText(
            text = "“Her Angelic Highness' crusades push on the Psmanthics, push on DiemCo, pushes on the fascist Constabulary of Humanity, who fight the unions",
            attribution = "Syndicalist partisan on planetary Winnipeg, as quoted by Sri Marmolejo",
        ),
        choices = listOf(
            ChoiceSpecification(
                questions = listOf(
                    Question(
                        question = "Choose two you still carry with you",
                        answers = 2,
                    ),
                ),
                options = setOf(
                    Option("A hatred of being ordered around"),
                    Option("A certain way you hold your body"),
                    Option("A way you talk, act, make your bed"),
                    Option("A memory of something done to you"),
                    Option("A memory of something you did"),
                    Option("A photo of the dead"),
                    Option("A scar or five"),
                    Option("A flinch, night terrors"),
                    Option("An old uniform"),
                    Option("An old weapon"),
                ),
            ),
        ),
        actions = listOf(
            Action(
                description = "Be unable to do something because of what you did",
                diceOffset = 1,
            ),
            Action(
                description = "Feel guilt you can't speak of, close up",
                diceOffset = 1,
            ),
            Action(
                description = "Distrust someone or lash out in anger without reason",
                diceOffset = 1,
            ),
            Action(
                description = "Be too jumpy at something that's not a danger",
                diceOffset = 1,
            ),
            Action(
                description = "Do something else related to what you did, related to trauma",
                diceOffset = 0,
            ),
            Action(
                description = "Use your military training to solve a problem",
                diceOffset = -1,
            ),
            Action(
                description = "Use what you still carry with you from back then",
                diceOffset = -1,
            ),
            Action(
                description = "Protect someone else, even if it hurts you",
                diceOffset = -1,
            ),
            Action(
                description = "Open up, move on",
                diceOffset = -5,
            ),
        ),
    )

    val exile: PlaySheetSpecification = PlaySheetSpecification(
        name = "The Exile",
        description = "Most people can return. You can't. Because of the law, or family, or a person out to get you. Something dangerous keeps you from returning. Or maybe just a guilty conscience. You did the only thing you could. You ran. You escaped.",
        flavorText = FlavorText(
            text = "I am from Transcend Calypso. DiemCo banned me after I released Freetraveler, an Alternative. Special operative Xis was sent to kill me. Trained killer. I escaped.",
            attribution = "In My Own Words, by Sri Marmolejo banned in DiemCo trading polities",
        ),
        choices = listOf(
            ChoiceSpecification(
                questions = listOf(
                    Question(
                        question = "Choose what you did",
                        answers = 1,
                    ),
                ),
                options = setOf(
                    Option("Killed someone"),
                    Option("Stole something"),
                    Option("Broke tradition"),
                    Option("Insulted someone"),
                    Option("Broke tradition"),
                    Option("Challenged authority"),
                    Option("Nothing (a lie)"),
                    Option("Nothing (the truth)"),
                ),
            ),
            ChoiceSpecification(
                questions = listOf(
                    Question(
                        question = "Choose one you carry from your lost home",
                        answers = 1,
                    ),
                ),
                options = setOf(
                    Option("Something painful"),
                    Option("Something to protect yourself with"),
                    Option("Something that doesn't exist anywhere else"),
                    Option("Something worth killing or dying for"),
                    Option("Something happy"),
                    Option("Something secret"),
                    Option("Something alive"),
                ),
            ),
        ),
        actions = listOf(
            Action(
                description = "Run into someone or something hunting you, or maybe it's all just in your head",
                diceOffset = 3,
            ),
            Action(
                description = "Be unable to do something, because you are exiled, or because you simply refuse",
                diceOffset = 1,
            ),
            Action(
                description = "Look behind you for someone chasing, maybe it's just guilt",
                diceOffset = 1,
            ),
            Action(
                description = "Refuse to settle down and want to keep running at the worst time",
                diceOffset = 1,
            ),
            Action(
                description = "Do something that won't save you from what is chasing you",
                diceOffset = 0,
            ),
            Action(
                description = "Lash out how they think you do",
                diceOffset = -1,
            ),
            Action(
                description = "Realize someone is going to hurt you, stop them before they can",
                diceOffset = -1,
            ),
            Action(
                description = "Use whatever you did or did not do to your advantage, be the feared killer",
                diceOffset = -3,
            ),
            Action(
                description = "Go home. Return. Deal with the consequences, up to death",
                diceOffset = -5,
            ),
        ),
    )

    val runaway: PlaySheetSpecification = PlaySheetSpecification(
        name = "The Runaway",
        description = "You used to live on a planet. A nice little world. A nice group of people around you. A home. Then one found nearby a space port one day and went Freetraveler. No one chased you away, no one is hunting you. You left. Why?",
        flavorText = FlavorText(
            text = "“Was birthwise of frontier moon. Nice little indotribe. Will na speak ill of family. Just walked-la off the farm, found the nearest spaceport & waited.",
            attribution = "Bawalang Freetraveler, as quoted by Freetraveler, an Alternative",
        ),
        choices = listOf(
            ChoiceSpecification(
                questions = listOf(
                    Question(
                        question = "Choose one you still carry with your from your distant home",
                        answers = 1,
                    ),
                ),
                options = setOf(
                    Option("A pocket watch"),
                    Option("A family picture or letter"),
                    Option("A hat, sock or boots"),
                    Option("A locket or toy"),
                    Option("A handful of dirt"),
                    Option("A special rock or plant"),
                ),
            ),
            ChoiceSpecification(
                questions = listOf(
                    Question(
                        question = "Choose how you explain why you left to yourself, change it frequently",
                        answers = 1,
                    ),
                ),
                options = setOf(
                    Option("Too quiet"),
                    Option("Too small"),
                    Option("Too safe"),
                    Option("Too controlled"),
                    Option("Too crowded"),
                    Option("Too lonely"),
                    Option("Too familiar"),
                    Option("Too provincial"),
                ),
            ),
        ),
        actions = listOf(
            Action(
                description = "Get excited about something new to distract yourself from missing home",
                diceOffset = 1,
            ),
            Action(
                description = "Change the story you tell yourself to explain why you left",
                diceOffset = 1,
            ),
            Action(
                description = "Be naive about something new to you",
                diceOffset = 1,
            ),
            Action(
                description = "Find something painfully nostalgic",
                diceOffset = 1,
            ),
            Action(
                description = "Do something, remembering what you chose to leave far away behind you",
                diceOffset = 0,
            ),
            Action(
                description = "Get someone to explain something they normally wouldn't",
                diceOffset = -1,
            ),
            Action(
                description = "Do something you learned at home to solve a problem",
                diceOffset = -1,
            ),
            Action(
                description = "Send a message back home, tell them why you left",
                diceOffset = -5,
            ),
        ),
    )

    val abductee: PlaySheetSpecification = PlaySheetSpecification(
        name = "The Abductee",
        description = "One day a spaceship showed up on your uncontacted, backwater world and carried you away. Maybe you were in danger. Maybe there was a misunderstanding. Maybe it was a kidnapping. It's an old story. Abduction, for whatever reason.",
        flavorText = FlavorText(
            text = "I was contemplating The Broken God, and his ways, when the spaceship arrived. Black and glistening with void menace over me. I was afraid.",
            attribution = "Nnedi ban'Xi, as quoted by Freetravelers, a Subversive Folk",
        ),
        choices = listOf(
            ChoiceSpecification(
                questions = listOf(
                    Question(
                        question = "Choose one you still carry with you from your homeworld ",
                        answers = 1,
                    ),
                    Question(
                        question = "Choose one that was taken from you",
                        answers = 1,
                    ),
                ),
                options = setOf(
                    Option("Your name or your family's name"),
                    Option("A language no one else speaks"),
                    Option("A bit of tech no one else understands"),
                    Option("A bunch of pop culture references"),
                    Option("A pet"),
                    Option("A sense of alienation"),
                    Option("Your world's location"),
                    Option("A little analogue song player"),
                    Option("A hobby everyone else thinks is weird"),
                    Option("A single piece of preserved food for a special occurrence"),
                ),
            ),
        ),
        actions = listOf(
            Action(
                description = "Annoy people with references they don't understand",
                diceOffset = 1,
            ),
            Action(
                description = "Ask about ways to return home when it isn't the right time",
                diceOffset = 1,
            ),
            Action(
                description = "Declare that despite everything, you are superior",
                diceOffset = 1,
            ),
            Action(
                description = "Do something normal in the place where you were taken from",
                diceOffset = 0,
            ),
            Action(
                description = "Hatch a crazy plan using something low-tech from your world",
                diceOffset = -1,
            ),
            Action(
                description = "Know how to do something simple when space tech breaks",
                diceOffset = -1,
            ),
            Action(
                description = "Find information that might help lead you home eventually",
                diceOffset = -4,
            ),
            Action(
                description = "Stop looking for your lost homeworld",
                diceOffset = -5,
            ),
        ),
    )

    val apprentice: PlaySheetSpecification = PlaySheetSpecification(
        name = "The Apprentice",
        description = "You used to be a monk. Or an acolyte. A disciple. People were trying to teach you deep, arcane, magical things. Maybe you finished and became a witch or a wizard, maybe not. But whatever the answer you still carry your early days with you now.",
        flavorText = FlavorText(
            text = "“That hack job documentary took me entirely out of context. I chose to leave that cloister, and the heresiarchs that ran it. Put my name on it.",
            attribution = "Nnedi ban'Xi, as quoted by Sri Marmolejo, In Rebuttal",
        ),
        choices = listOf(
            ChoiceSpecification(
                questions = listOf(
                    Question(
                        question = "Choose one you still carry with you from your master, teacher, school, who or whatever tried to teach you",
                        answers = 1,
                    ),
                ),
                options = setOf(
                    Option("A way you flinch away"),
                    Option("A sense of wasted potential"),
                    Option("A way you cast spells"),
                    Option("A bit of etheric vocabulary you use"),
                    Option("A way you prepare food"),
                    Option("A way you don't like your reflection"),
                    Option("A spellbook"),
                    Option("A wand or staff"),
                ),
            ),
            ChoiceSpecification(
                questions = listOf(
                    Question(
                        question = "Choose who taught you",
                        answers = 1,
                    ),
                ),
                options = setOf(
                    Option("A college of professors"),
                    Option("A temple of monks"),
                    Option("A Vomyodosi or wizard"),
                    Option("A coven of witches"),
                    Option("God, nature, spirits"),
                ),
            ),
        ),
        actions = listOf(
            Action(
                description = "Have a small flashback about your teachers pushing you far too hard for one so young",
                diceOffset = 1,
            ),
            Action(
                description = "Do a little ritual they taught you how to do",
                diceOffset = 1,
            ),
            Action(
                description = "Do something else from the childhood you never had",
                diceOffset = 0,
            ),
            Action(
                description = "Change the material a small object is made of",
                diceOffset = -1,
            ),
            Action(
                description = "Fool someone with a small illusion for a few seconds",
                diceOffset = -1,
            ),
            Action(
                description = "Heat up or cool down a small object by some degrees",
                diceOffset = -1,
            ),
            Action(
                description = "Exert enough force to lift or push a small nearby object",
                diceOffset = -1,
            ),
            Action(
                description = "Do something normal younger you would have wanted to do",
                diceOffset = -3,
            ),
        ),
    )

    val snapcaster: PlaySheetSpecification = PlaySheetSpecification(
        name = "The Snapcaster",
        description = "A snapcaster is someone who normally wouldn't have magic, etheric powers, someone who was never apprenticed. But snapcasters grew up or spent a lot of time around a black hole, a black matter wall, in the deep wild dark, or similar. You got this way, and got your powers, through accidental exposure.",
        flavorText = FlavorText(
            text = "“Subject's flesh begins to increase dramatically in mass, likely towards nuclear degenerate matter. Isolation lost just after. Location unknown.",
            attribution = "Intercepted communique, Psmanthic Choir, RE Sinner Sun event",
        ),
        choices = listOf(
            ChoiceSpecification(
                questions = listOf(
                    Question(
                        question = "Choose how your power was inflicted on you",
                        answers = 1,
                    ),
                ),
                options = setOf(
                    Option("Industrial accident"),
                    Option("Unknown science"),
                    Option("Freak coincidence"),
                    Option("Unethical experiments"),
                    Option("Etheric pollution"),
                    Option("Temporal anomalies"),
                    Option("Spacetime distortions"),
                ),
            ),
            ChoiceSpecification(
                questions = listOf(
                    Question(
                        question = "Choose one you carry in you from your exposure",
                        answers = 1,
                    ),
                ),
                options = setOf(
                    Option("Pains in your mind"),
                    Option("Visions of the past"),
                    Option("Uncanncy prescience"),
                    Option("Echos of your voice"),
                    Option("A fear, terror of magic"),
                    Option("A tremor in your hands"),
                ),
            ),
        ),
        actions = listOf(
            Action(
                description = "Have the power and damage you carry in your body keep you from doing something",
                diceOffset = 1,
            ),
            Action(
                description = "Flinch from something that reminds you of how you got your powers",
                diceOffset = 1,
            ),
            Action(
                description = "Be afraid or averse from magic and etheric sciences",
                diceOffset = 1,
            ),
            Action(
                description = "Do something related to what was done to you, remind people it does not make you a witch or a wizard",
                diceOffset = 0,
            ),
            Action(
                description = "Try to copy something supernatural one of your crewmates did, no matter how powerful",
                diceOffset = -1,
            ),
            Action(
                description = "Try to manifest some small part of how you got your powers",
                diceOffset = -1,
            ),
            Action(
                description = "Try to manifest how you got your powers, how it was inflicted, hurt yourself in the process",
                diceOffset = -2,
            ),
            Action(
                description = "Break your bonds, be a terror",
                diceOffset = -4,
            ),
        ),
    )

    val reformed: PlaySheetSpecification = PlaySheetSpecification(
        name = "The Reformed",
        description = "Wherever there's civilization there's crime. Wherever there's crime there's people organizing it. Let's just say it didn't go well for you. Names change, you move on with your particular skills. Hope it's for the best.",
        flavorText = FlavorText(
            text = "“The Shroud Syndicate is raiding this establishment tomorrow. Please have protection tax ready at time of raid.",
            attribution = "Pamphlet drop from planetary Winnipeg, after Syndicate take over",
        ),
        choices = listOf(
            ChoiceSpecification(
                questions = listOf(
                    Question(
                        question = "Choose two you still carry from your gang, family or syndicate",
                        answers = 2,
                    ),
                ),
                options = setOf(
                    Option("One old tattoo"),
                    Option("One revolver"),
                    Option("One unopened bottle"),
                    Option("One passcode"),
                    Option("One special bullet"),
                    Option("One good suit"),
                    Option("One good memory"),
                    Option("One damning secret"),
                    Option("One lingering grudge"),
                    Option("One unhealthy habit you can't kick"),
                    Option("One person you still miss or love"),
                    Option("One person who will still answer your calls"),
                ),
            ),
        ),
        actions = listOf(
            Action(
                description = "Run into someone from your past at the worst time",
                diceOffset = 1,
            ),
            Action(
                description = "Do something rash, and bad for your health, possibly addictive",
                diceOffset = 1,
            ),
            Action(
                description = "Take a dangerous, unnecessary risk",
                diceOffset = 1,
            ),
            Action(
                description = "Do something from your sleazy past, or contrary to it",
                diceOffset = 0,
            ),
            Action(
                description = "Make it up a plan to solve a problem on the fly",
                diceOffset = -1,
            ),
            Action(
                description = "Keep a cool under pressure",
                diceOffset = -1,
            ),
            Action(
                description = "Use your criminal knowledge to solve a problem",
                diceOffset = -1,
            ),
            Action(
                description = "Shoot first, even if only metaphorically",
                diceOffset = -1,
            ),
            Action(
                description = "Call in one last favor, for old times sake",
                diceOffset = -4,
            ),
        ),
    )

    val prophesied: PlaySheetSpecification = PlaySheetSpecification(
        name = "The Prophesied",
        description = "A product of the chosen one industry, born to greatness, specifically bred for one thing, circumstances of creation and youth all controlled to produce an end product. Yet here you are Freetraveling. Not doing that. Why?",
        flavorText = FlavorText(
            text = "“Welcome to Winnipeg! Leading the way in the chosen one industry with our patented corp oracles! If you're here, it's because we foretold it.",
            attribution = "Planetary Winnipeg slogan, prior to the Constabulary ousting SaintsCo",
        ),
        choices = listOf(
            ChoiceSpecification(
                questions = listOf(
                    Question(
                        question = "Choose what you were meant to do",
                        answers = 1,
                    ),
                ),
                options = setOf(
                    Option("Conquer or free a world"),
                    Option("Kill or serve a king"),
                    Option("Die or live for someone"),
                    Option("Burn everything down"),
                    Option("Preserve memory"),
                ),
            ),
            ChoiceSpecification(
                questions = listOf(
                    Question(
                        question = "Choose what horror was done to make you",
                        answers = 1,
                    ),
                ),
                options = setOf(
                    Option("Brutal training"),
                    Option("Mass sacrifice"),
                    Option("Unholy magic"),
                    Option("Prophecy manipulation"),
                    Option("Bloodline bullshit"),
                    Option("Mad science"),
                ),
            ),
        ),
        actions = listOf(
            Action(
                description = "Hide why you left, why you can't be what you were born to be",
                diceOffset = 1,
            ),
            Action(
                description = "Feel pressure to do something, achieve greatness, save the day",
                diceOffset = 1,
            ),
            Action(
                description = "Push yourself into a situation that does not need you to be there",
                diceOffset = 1,
            ),
            Action(
                description = "Have flashbacks, fear you aren't doing what you were meant to",
                diceOffset = 1,
            ),
            Action(
                description = "Do something neither embracing nor rejecting to your supposed great, glorious destiny",
                diceOffset = 0,
            ),
            Action(
                description = "Be vulnerable, and with that vulnerability have someone else help you",
                diceOffset = -1,
            ),
            Action(
                description = "Use a thing they forced you to do to actually solve a problem",
                diceOffset = -1,
            ),
            Action(
                description = "Have someone help you because they believe your supposed destiny",
                diceOffset = -3,
            ),
            Action(
                description = "Intimidate someone into helping you because of what you are",
                diceOffset = -3,
            ),
            Action(
                description = "Break prophecy, reject the past, explain why you left",
                diceOffset = 5,
            ),
        ),
    )

    val amnesiac: PlaySheetSpecification = PlaySheetSpecification(
        name = "The Amnesiac",
        description = "Not everyone is lucky enough to have a coherent past. Sometimes you just wake up and have to guess if you're a construct, a reanimated corpse, a victim of psychogogic manipulation, or what.",
        flavorText = FlavorText(
            text = "I–for what purpose?",
            attribution = "Maybe Xis, as overheard by a crewmate and reported to Sri Marmolejo",
        ),
        choices = listOf(
            ChoiceSpecification(
                questions = listOf(
                    Question(
                        question = "Choose one you have that might clue you into your previous identity",
                        answers = 1,
                    ),
                ),
                options = setOf(
                    Option("The memory of a name"),
                    Option("The memory of pain"),
                    Option("The memory of a hug"),
                    Option("The memory of hurting someone else"),
                    Option("A set of coordinates"),
                    Option("Instructions from a past self"),
                    Option("Old video of yourself as a child"),
                    Option("A piece of tech you can't use"),
                    Option("A key"),
                ),
            ),
        ),
        actions = listOf(
            Action(
                description = "Not know something basic",
                diceOffset = 1,
            ),
            Action(
                description = "Not know what you can do",
                diceOffset = 1,
            ),
            Action(
                description = "Do something, could be anything since you don't have past",
                diceOffset = 0,
            ),
            Action(
                description = "Having already found new old skill, use it again to solve a problem",
                diceOffset = -1,
            ),
            Action(
                description = "Discover a new old skill to save the day",
                diceOffset = -3,
            ),
            Action(
                description = "Discover a secret leading you towards your past",
                diceOffset = -3,
            ),
            Action(
                description = "Once you have found at least three secrets, have your memories return. If you accept your previous identity pick a new background",
                diceOffset = -5,
            ),
            Action(
                description = "Reject who you were before, declare yourself a new person",
                diceOffset = -5,
            ),
        ),
    )

    val backgrounds: List<Weighted<PlaySheetSpecification>> = listOf(
        Weighted(1, corpoCitoyen),
        Weighted(1, indenture),
        Weighted(1, bornWanderer),
        Weighted(1, veteran),
        Weighted(1, exile),
        Weighted(1, runaway),
        Weighted(1, abductee),
        Weighted(1, apprentice),
        Weighted(1, snapcaster),
        Weighted(1, reformed),
        Weighted(1, prophesied),
        Weighted(1, amnesiac),
    )
}
