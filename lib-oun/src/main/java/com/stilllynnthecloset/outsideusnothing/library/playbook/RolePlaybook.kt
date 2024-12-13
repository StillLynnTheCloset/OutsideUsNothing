package com.stilllynnthecloset.outsideusnothing.library.playbook

import com.stilllynnthecloset.outsideusnothing.library.model.Action
import com.stilllynnthecloset.outsideusnothing.library.model.ChoiceSpecification
import com.stilllynnthecloset.outsideusnothing.library.model.FlavorText
import com.stilllynnthecloset.outsideusnothing.library.model.Option
import com.stilllynnthecloset.outsideusnothing.library.model.PlaySheetSpecification
import com.stilllynnthecloset.outsideusnothing.library.model.Question
import com.stilllynnthecloset.outsideusnothing.library.tools.WeightedSet

/**
 * RolePlaybook - TODO: Documentation
 *
 * Created by Lynn on 5/1/23
 */
internal object RolePlaybook {
    val wizard: PlaySheetSpecification = PlaySheetSpecification(
        name = "Space Wizard",
        description = "Wizards have long studied the many magics of the etheric sea. The all black everything. Space. And you are no different. Your mind explodes with arcane knowledge and anywhere in the universe will recognize your mastery of the art!",
        flavorText = FlavorText(
            text = "“Wonder before the universe. Then understand it. And then, through understanding, master it.",
            attribution = "Traditional Vomyodosoi saying",
        ),
        choices = listOf(
            ChoiceSpecification(
                questions = listOf(
                    Question(
                        question = "Two words that describe your magic",
                        answers = 2,
                    ),
                ),
                options = setOf(
                    Option("Dark"),
                    Option("Stellar"),
                    Option("Void"),
                    Option("Temporal"),
                    Option("Tentacular"),
                    Option("Distant"),
                    Option("Eldritch"),
                    Option("Primal"),
                    Option("Gravitational"),
                    Option("Precise"),
                    Option("Fiery"),
                    Option("Cold"),
                    Option("Technological"),
                    Option("Contractual"),
                    Option("Cursed"),
                    Option("Frantic"),
                    Option("Bloody"),
                ),
            ),
        ),
        actions = listOf(
            Action(
                description = "Accidentally cast one spell you've learned and hurt yourself or others. When you do this roll a d6 to randomize your spells",
                diceOffset = 1,
            ),
            Action(
                description = "Be very overconfident or do something else wizardous",
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
                description = "Combine two spells into one",
                diceOffset = -3,
            ),
            Action(
                description = "Forget a spell from the list",
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
    )

    val witch: PlaySheetSpecification = PlaySheetSpecification(
        name = "Planetary Witch",
        description = "Witchways are the ways of stories and stories normally have a place about them. So unlike wizards, gallivanting about, witches normally stay in one place. But out here in the black you must carry your stories with you.",
        flavorText = FlavorText(
            text = "“Give up sweet, idyllic ideas. Witches tell stories and the story we will tell is this: DiemCo moves in, takes over.",
            attribution = "DiemCo's witch work program",
        ),
        choices = listOf(
            ChoiceSpecification(
                questions = listOf(
                    Question(
                        question = "Tell four details about where your story began",
                        answers = 4,
                    ),
                ),
                options = setOf(
                    Option("It's quiet or musical"),
                    Option("It's cool or warm"),
                    Option("It's growing or decaying"),
                    Option("It's alive or dead"),
                    Option("It's dirty or clean"),
                    Option("It's sleepy or bracing"),
                    Option("It's ancient or new"),
                    Option("It's watery or dry"),
                    Option("It's light or shadowed"),
                    Option("It's haunted or holy"),
                    Option("It has spirits"),
                    Option("It has quiet gods"),
                    Option("It heals who stays there"),
                    Option("It has necessary rituals"),
                    Option("It still remembers you"),
                    Option("Its fearful power is just now waking up"),
                ),
            ),
        ),
        actions = listOf(
            Action(
                description = "Tell a story about the place your story began",
                diceOffset = 1,
            ),
            Action(
                description = "Tell a random, made up story",
                diceOffset = 1,
            ),
            Action(
                description = "Admit you don't know",
                diceOffset = 1,
            ),
            Action(
                description = "Have nostalgia or do something else witchy and storied",
                diceOffset = 0,
            ),
            Action(
                description = "Learn all the nuances of a place you have never been before",
                diceOffset = -1,
            ),
            Action(
                description = "Carefully look at something you've seen many times before",
                diceOffset = -1,
            ),
            Action(
                description = "Give advice from your story more right than wrong",
                diceOffset = -1,
            ),
            Action(
                description = "Draw a detail from your story that heals more than hurt",
                diceOffset = -1,
            ),
            Action(
                description = "Tell of a person from your story that inspires more than alarms",
                diceOffset = -1,
            ),
            Action(
                description = "Recall a detail from your story that rests more than wakens",
                diceOffset = -1,
            ),
            Action(
                description = "Pull something from your story that protects more than attack",
                diceOffset = -1,
            ),
            Action(
                description = "Imagine being someone in your story who sees more than most",
                diceOffset = -1,
            ),
            Action(
                description = "Begin a new story where you are now, leaving behind the old",
                diceOffset = -6,
            ),
        ),
    )

    val pilot: PlaySheetSpecification = PlaySheetSpecification(
        name = "Pilot",
        description = "Everyone on board knows your ship, of course. Perhaps they could even fly it in a pinch. Many ships without pilots make do with low level a-machine, or someone far, far less skilled. But not so long as you are here. No one could replace you. No one else would be able to fly it like you. Sail it like you. You bring it to life like no one else could, you think.",
        flavorText = FlavorText(
            text = "“Barque was old, old. Antique. Ceramic. Like a teapot. Built by a species that died afore terre came to this reach. But I could see the pilot could still make it dance.",
            attribution = "Khwezi, birthwise of DiemCo, about a ship destroyed in the Pale Incident",
        ),
        choices = listOf(
            ChoiceSpecification(
                questions = listOf(
                    Question(
                        question = "Choose one you know about the ship that no one else does",
                        answers = 1,
                    ),
                ),
                options = setOf(
                    Option("How to make it dance, twirl, leap, fly just right"),
                    Option("All the many hiding holes, the out of the way corners, the unique bits"),
                    Option("The way it feels when its hurting and keens just before it breaks"),
                    Option("The loves that keeps it in the air"),
                ),
            ),
        ),
        actions = listOf(
            Action(
                description = "Hate being confined, trapped",
                diceOffset = 1,
            ),
            Action(
                description = "Feel lost and be useless when you aren't at the helm",
                diceOffset = 1,
            ),
            Action(
                description = "Freak out, panic, or get angry whenever someone else is at the helm",
                diceOffset = 1,
            ),
            Action(
                description = "Want to slip the jesses, the bonds of earth, do something else pilot-y",
                diceOffset = 0,
            ),
            Action(
                description = "Do something with quick reflexes, react before others",
                diceOffset = -1,
            ),
            Action(
                description = "Do something with an intuitive leap, before others can worry",
                diceOffset = -1,
            ),
            Action(
                description = "Leave some place in a hurry",
                diceOffset = -1,
            ),
            Action(
                description = "Escape from something holding your or your ship down",
                diceOffset = -1,
            ),
            Action(
                description = "Fly through risky obstacles",
                diceOffset = -2,
            ),
            Action(
                description = "Fly to outrace danger",
                diceOffset = -2,
            ),
            Action(
                description = "Fly to outrace another ship",
                diceOffset = -3,
            ),
            Action(
                description = "Fly to dodge some fast weapon",
                diceOffset = -3,
            ),
            Action(
                description = "Sacrifice yourself to save the ship",
                diceOffset = 0,
            ),
            Action(
                description = "Sacrifice the ship to save the crew",
                diceOffset = 0,
            ),
        ),
    )

    val liaison: PlaySheetSpecification = PlaySheetSpecification(
        name = "Social Liaison",
        description = "People think that every door will open automatically. But docking berths, port tariffs, repairs, refueling, resupplies, new contracts, these things don't just take care of themselves. Someone needs to know how to talk to people.",
        flavorText = FlavorText(
            text = "Devils far away from the fabula learn to shift to all sorts. Shift-la to be whatever people want me to be. I open the doors & I talk. People like me.",
            attribution = "Devilish Freetraveler, the night after sleeping with Sri Marmolejo",
        ),
        choices = listOf(
            ChoiceSpecification(
                questions = listOf(
                    Question(
                        question = "Choose two groups you wouldn't think you'd be popular with yet are",
                        answers = 2,
                    ),
                ),
                options = setOf(
                    Option("A different alien species of your choice"),
                    Option("A different background of your choice"),
                    Option("Laborers, dockworkers"),
                    Option("Sex workers, survivors"),
                    Option("Untraveled locals"),
                    Option("Corporate types"),
                    Option("Religious types"),
                    Option("Apathetic types"),
                    Option("Paranoid types"),
                    Option("The normally annoying people who valorize Freetravelers"),
                ),
            ),
        ),
        actions = listOf(
            Action(
                description = "Introduce yourself awkwardly",
                diceOffset = 1,
            ),
            Action(
                description = "Give a little bit too much information",
                diceOffset = 1,
            ),
            Action(
                description = "Ask embarrassingly forward questions",
                diceOffset = 1,
            ),
            Action(
                description = "Put yourself out there or do something else confidently",
                diceOffset = 0,
            ),
            Action(
                description = "Be confident just when you need it in a social situation",
                diceOffset = -1,
            ),
            Action(
                description = "Remind someone of a local obligation, custom, tradition that helps you",
                diceOffset = -1,
            ),
            Action(
                description = "Realize something about a place just before you in trouble",
                diceOffset = -1,
            ),
            Action(
                description = "Anticipate a local challenge or difficulty and make a plan to avoid it",
                diceOffset = -1,
            ),
            Action(
                description = "Strike a mutually beneficial deal with one of the listed groups",
                diceOffset = -1,
            ),
            Action(
                description = "Strike a mutually beneficial deal with one of the unlisted groups",
                diceOffset = -3,
            ),
            Action(
                description = "Learn all about some new group you come in contact with and add them to the list on the left",
                diceOffset = -5,
            ),
        ),
    )

    val navigator: PlaySheetSpecification = PlaySheetSpecification(
        name = "Etheric Navigator",
        description = "You've been everywhere, all throughout the big nothing. You've probably been a Freetraveler the longest. You know the orbits, the dark and the ports. If you've never been there before, you likely know how to get there.",
        flavorText = FlavorText(
            text = "911,322 kerama points transited, 899 worlds visited, 8708 stations, 232 asteroids, 98 dark matter wells, 39 space elevators, 2 gods. Been a life.",
            attribution = "Freetraveler of unidentified species on Orbital Descant",
        ),
        choices = listOf(
            ChoiceSpecification(
                questions = listOf(
                    Question(
                        question = "Choose two you're more knowledgeable about than other Freetravelers",
                        answers = 2,
                    ),
                ),
                options = setOf(
                    Option("The docks you sail towards"),
                    Option("The bars you frequent"),
                    Option("The myths of ether beasts and gods you tell"),
                    Option("The rumors you spread"),
                    Option("The charts you study"),
                    Option("The ships you spot"),
                    Option("The stars you reckon and pray and hope by"),
                    Option("The Cant you speak"),
                    Option("The wrecks you salvage and repair"),
                    Option("The help you rely on"),
                ),
            ),
        ),
        actions = listOf(
            Action(
                description = "Give inaccurate information",
                diceOffset = 1,
            ),
            Action(
                description = "Be confident, charming, wrong",
                diceOffset = 1,
            ),
            Action(
                description = "Brood if you're in one place too long or do something else restless",
                diceOffset = 0,
            ),
            Action(
                description = "Lie about where you've been or otherwise trick someone",
                diceOffset = -1,
            ),
            Action(
                description = "Get in a brawl about some emotional subject",
                diceOffset = -1,
            ),
            Action(
                description = "Browbeat someone into give you something",
                diceOffset = -1,
            ),
            Action(
                description = "Figure out how to get there fast",
                diceOffset = -1,
            ),
            Action(
                description = "Use a yarn to escape a bind",
                diceOffset = -1,
            ),
            Action(
                description = "Use something from far away as a bargaining chip",
                diceOffset = -1,
            ),
            Action(
                description = "Solve a problem using knowledge of a place you've been before",
                diceOffset = -1,
            ),
            Action(
                description = "Solve a problem using one of the things you chose above",
                diceOffset = -1,
            ),
            Action(
                description = "Solve a problem by making a guess at one of the things on the list you didn't choose above",
                diceOffset = -3,
            ),
            Action(
                description = "Admit you were wrong, and learn something new from the left",
                diceOffset = -5,
            ),
        ),
    )

    val mechanic: PlaySheetSpecification = PlaySheetSpecification(
        name = "Metallurgic Mechanic",
        description = "You aren't like a pilot, thinking that feelings make ships fly. People project onto ships, see them as all one thing. But you know that a big piece of equipment is made up of many, many smaller pieces. These are the machines that are second nature to you.",
        flavorText = FlavorText(
            text = "Khwezi said that ‘bout the Russell? Thing was a piece of shit & barely keep running. ‘Course still loved it.",
            attribution = "Em, birthwise of Constabulary of Humanity, Freetraveler",
        ),
        choices = listOf(
            ChoiceSpecification(
                questions = listOf(
                    Question(
                        question = "Choose two machines you have mastered",
                        answers = 2,
                    ),
                    Question(
                        question = "Choose one you are useless with",
                        answers = 1,
                    ),
                ),
                options = setOf(
                    Option("Engines"),
                    Option("Airscrubbers"),
                    Option("Common a-machines"),
                    Option("Sophont z-machines"),
                    Option("Drones"),
                    Option("Missiles"),
                    Option("Rail guns"),
                    Option("Armor plating"),
                    Option("Shields"),
                    Option("Sensors"),
                    Option("Plumbing"),
                    Option("Material, food printers"),
                    Option("Dockclamps, grapplers"),
                    Option("Relativation, fake grav"),
                ),
            ),
        ),
        actions = listOf(
            Action(
                description = "Fail at something social with organic things",
                diceOffset = 1,
            ),
            Action(
                description = "Be distracted by machines",
                diceOffset = 1,
            ),
            Action(
                description = "Get covered in grease and grime or do something else tinkering",
                diceOffset = 0,
            ),
            Action(
                description = "Threaten, attack someone, something with tools for repairing",
                diceOffset = -1,
            ),
            Action(
                description = "Talk to those who will listen about machines, exchange useful info",
                diceOffset = -1,
            ),
            Action(
                description = "Boost a working machine, make it work better than it already was",
                diceOffset = -1,
            ),
            Action(
                description = "Diagnose what's broken with a machine",
                diceOffset = -1,
            ),
            Action(
                description = "Fix a mastered machine",
                diceOffset = -1,
            ),
            Action(
                description = "Fix a machine you weren't familiar with if",
                diceOffset = -2,
            ),
            Action(
                description = "Fix a machines you never wanted to touch again",
                diceOffset = -4,
            ),
            Action(
                description = "Choose a new machine to master from the list on the left",
                diceOffset = -5,
            ),
            Action(
                description = "Completely repair a wholly broken ship",
                diceOffset = -6,
            ),
            Action(
                description = "Build a new ship",
                diceOffset = -9,
            ),
        ),
    )

    val explorer: PlaySheetSpecification = PlaySheetSpecification(
        name = "Intrepid Explorer",
        description = "Someone needs to try the boundaries. Test the theories. Push the buttons. The universe is a big place and whenever your crew finds something they don't grok there you are. Perhaps not understanding either, but trying",
        flavorText = FlavorText(
            text = "I think we should investigate the fabula. It is kinda invading our reality. Growing into. We know devils are parts of it, but does it want anything?",
            attribution = "Binti Khouri, explaining why she was in a devil forest eating a world",
        ),
        choices = listOf(
            ChoiceSpecification(
                questions = listOf(
                    Question(
                        question = "Choose a field of research you are an expert in",
                        answers = 1,
                    ),
                    Question(
                        question = "Choose one you are an apprentice in",
                        answers = 1,
                    ),
                ),
                options = setOf(
                    Option("History of the universe"),
                    Option("Xenopsychology, the mind"),
                    Option("Medicine, healing"),
                    Option("Xenobiology, diseases"),
                    Option("Dark matter, black holes"),
                    Option("Arcane, etheric theories"),
                    Option("Theoretical, experimental tech"),
                    Option("Stellar dynamics, light itself"),
                    Option("Orbital, planetary paths"),
                    Option("Relativation, gravitation"),
                ),
            ),
        ),
        actions = listOf(
            Action(
                description = "Ask for advice from someone more knowledgeable than you",
                diceOffset = 1,
            ),
            Action(
                description = "Admit you don't know",
                diceOffset = 1,
            ),
            Action(
                description = "Lose focus, talk too fast",
                diceOffset = 1,
            ),
            Action(
                description = "Focus, fret, lose yourself in thought or do something else while distracted",
                diceOffset = 0,
            ),
            Action(
                description = "Make someone else think you're the smartest person in the room",
                diceOffset = -1,
            ),
            Action(
                description = "Befriend someone else you respect or think is smart",
                diceOffset = -1,
            ),
            Action(
                description = "Learn a new fact about your apprentice field, write it down",
                diceOffset = -1,
            ),
            Action(
                description = "Wow someone with a fact you learned in your apprentice field",
                diceOffset = -1,
            ),
            Action(
                description = "Solve a problem with the field of research you are an expert in",
                diceOffset = -1,
            ),
            Action(
                description = "Wildly hypothesize about your apprentice field. be oddly right",
                diceOffset = -3,
            ),
            Action(
                description = "When you have seven facts about the field you think you know about, use them to actually learn about it and become an expert, then pick a new field to apprentice in. In addition to the seven facts, this also costs",
                diceOffset = -4,
            ),
        ),
    )

    val gardener: PlaySheetSpecification = PlaySheetSpecification(
        name = "Astral Gardener",
        description = "We're all systems. Emergent computer networks, emergent biospheres, ecosystems, biotech, biology, bodies. From the personal all the way to the planetary. You tend those gardens.",
        flavorText = FlavorText(
            text = "Bodies contain ecosystems, which are contained in ships, such. Ecosystems. Which move in capitalism, kingdoms, cults, dimensions. Ecosystems.",
            attribution = "Rogue terraforming z-machine found floating in Deep Wild Dark",
        ),
        choices = listOf(
            ChoiceSpecification(
                questions = listOf(
                    Question(
                        question = "Choose a scale of biology you operate on",
                        answers = 1,
                    ),
                ),
                options = setOf(
                    Option("Microbiology"),
                    Option("Personal biology"),
                    Option("Planetary Ecosystems"),
                ),
            ),
            ChoiceSpecification(
                questions = listOf(
                    Question(
                        question = "Choose one stem line",
                        answers = 1,
                    ),
                ),
                options = setOf(
                    Option("Healed injuries"),
                    Option("Cancerous growth"),
                    Option("Accelerated processes"),
                    Option("Blighted biology"),
                    Option("Shifted homeostasis"),
                ),
            ),
        ),
        actions = listOf(
            Action(
                description = "Be unable to deal with something artificial, or technological",
                diceOffset = 1,
            ),
            Action(
                description = "Scare someone when you interact with and change biology",
                diceOffset = 1,
            ),
            Action(
                description = "Look over your tools, syringes, knives, vials, and instruments",
                diceOffset = 1,
            ),
            Action(
                description = "Admire an emergent system",
                diceOffset = 1,
            ),
            Action(
                description = "Study something organic, or do something disgusting, you can write it down if you want",
                diceOffset = 0,
            ),
            Action(
                description = "Solve a small problem with an organic thing",
                diceOffset = -1,
            ),
            Action(
                description = "Using something on your scale of biology preemptively warn of danger from an organic thing",
                diceOffset = -1,
            ),
            Action(
                description = "Using something from on scale of biology supply a need",
                diceOffset = -1,
            ),
            Action(
                description = "Using a tool, take away your stem line from an organic thing",
                diceOffset = -2,
            ),
            Action(
                description = "Using a tool, add your stem line to an organic thing",
                diceOffset = -2,
            ),
            Action(
                description = "Using something you have previously studied, make new tools and say what they do",
                diceOffset = -2,
            ),
            Action(
                description = "If you have new tools, change the scale of biology you operate on",
                diceOffset = -4,
            ),
            Action(
                description = "If you have new tools, change the way you interact with biology",
                diceOffset = -4,
            ),
        ),
    )

    val tough: PlaySheetSpecification = PlaySheetSpecification(
        name = "Muscled Tough",
        description = "It's all well and good to magic, fly, science, and talk your way out of problems but let's be honest, the universe isn't always going to play nice. You're here for when it doesn't, for when people would threaten you, your ship, and the people you love.",
        flavorText = FlavorText(
            text = "Yes, I fought on Winnipeg. Fought for SaintsCo when the Constabulary invaded, fought for the union when the Shrouds moved in, took over.",
            attribution = "Planetary Winnipeg slogan, prior to the Constabulary ousting SaintsCo",
        ),
        choices = listOf(
            ChoiceSpecification(
                questions = listOf(
                    Question(
                        question = "Choose two you keep on you at all times",
                        answers = 2,
                    ),
                    Question(
                        question = "Choose two that always scare you",
                        answers = 2,
                    ),
                ),
                options = setOf(
                    Option("A pistol"),
                    Option("A rifle"),
                    Option("A knife"),
                    Option("A sword"),
                    Option("A polearm"),
                    Option("Brass knuckles"),
                    Option("Boots for kicking"),
                    Option("A steady hand"),
                    Option("A head on a swivel"),
                    Option("A defiant stare"),
                    Option("A chip on a shoulder"),
                    Option("A too-casual posture"),
                    Option("First aid at the ready"),
                ),
            ),
        ),
        actions = listOf(
            Action(
                description = "Hurt someone on accident",
                diceOffset = 3,
            ),
            Action(
                description = "Have a false alarm thinking you see a thing that scares you",
                diceOffset = 1,
            ),
            Action(
                description = "Panic when you do really see one of the things that scares you",
                diceOffset = 1,
            ),
            Action(
                description = "Be too anxious to do function",
                diceOffset = 1,
            ),
            Action(
                description = "Scan surroundings, check yourself, or do something else warily",
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
                description = "Intimidate someone with a thing you always keep on you",
                diceOffset = -1,
            ),
            Action(
                description = "Spot a thing that scares you before it becomes a threat",
                diceOffset = -1,
            ),
            Action(
                description = "Use a thing you always keep on you for something new",
                diceOffset = -1,
            ),
            Action(
                description = "Use a thing you always keep on you to protect someone else",
                diceOffset = -2,
            ),
            Action(
                description = "Learn to live with one of the things that scare you",
                diceOffset = -5,
            ),
            Action(
                description = "Let go of one thing you hold onto, pick up something new",
                diceOffset = -5,
            ),
        ),
    )

    val voidworker: PlaySheetSpecification = PlaySheetSpecification(
        name = "Orbital Voidworker",
        description = "Superstitions abound about those that brave the out. Shipbreakers, hull patchers, spacing survivors. Not wise to look so long at void, dark things there, they say. Some fear you, others think you lucky, ethertouched.",
        flavorText = FlavorText(
            text = "Drink vacuum, never fear the gods. Albatross, albatross, albatross again.",
            attribution = "The Shipyard Worker's Song, traditional",
        ),
        choices = listOf(
            ChoiceSpecification(
                questions = listOf(
                    Question(
                        question = "Choose one practical skill you bring with you",
                        answers = 1,
                    ),
                ),
                options = setOf(
                    Option("Null-G repair, work"),
                    Option("Ship boarding, combat"),
                    Option("EVA survival, invention"),
                    Option("Something else"),
                ),
            ),
            ChoiceSpecification(
                questions = listOf(
                    Question(
                        question = "Choose one odd skill you bring with you",
                        answers = 1,
                    ),
                ),
                options = setOf(
                    Option("Light and shadow bends near you"),
                    Option("Orbits and ether are quiet near you"),
                    Option("Sound deadens to silence near you"),
                    Option("Some say Deep Wild Dark itself watches you"),
                    Option("Some say dark deities lure you towards destiny"),
                ),
            ),
        ),
        actions = listOf(
            Action(
                description = "Have a dark god, void monster, or other etheric entity attack you",
                diceOffset = 5,
            ),
            Action(
                description = "Have your luck fail you at the worst possible times",
                diceOffset = 2,
            ),
            Action(
                description = "Feel claustrophobic inside stations and ships",
                diceOffset = 1,
            ),
            Action(
                description = "Unnerve more normal people",
                diceOffset = 1,
            ),
            Action(
                description = "Look peculiar, behave oddly, or do something else absentminded",
                diceOffset = 0,
            ),
            Action(
                description = "Move through space easily",
                diceOffset = -1,
            ),
            Action(
                description = "Accidentally intimidate someone with how you look",
                diceOffset = -1,
            ),
            Action(
                description = "Accidentally have someone superstitious or fearful help you",
                diceOffset = -1,
            ),
            Action(
                description = "Use your practical skill above to solve an vacuum problem",
                diceOffset = -1,
            ),
            Action(
                description = "Use your more odd skill above to solve a small problem",
                diceOffset = -1,
            ),
            Action(
                description = "Have luck help in a pinch",
                diceOffset = -1,
            ),
            Action(
                description = "Do something in ether no one else on the crew can do",
                diceOffset = -2,
            ),
            Action(
                description = "Invoke the dark, the out",
                diceOffset = -3,
            ),
            Action(
                description = "Go into the black, embrace whatever happens",
                diceOffset = -6,
            ),
        ),
    )

    val newbie: PlaySheetSpecification = PlaySheetSpecification(
        name = "Fresh-Faced Newbie",
        description = "Almost no one is born into this life. Even those that are are not born with skills. Still you are welcomed, as long as you show the promise of things to come. You are newer, or less seasoned maybe, but everything is ahead of you.",
        flavorText = FlavorText(
            text = "Cosmetician? Is new. Grab a mop. & grab a bucket. Start cleaning floors.",
            attribution = "Recollection of Freetraveler, psychogogic manipulative capture",
        ),
        choices = listOf(
            ChoiceSpecification(
                questions = listOf(
                    Question(
                        question = "Chose 5 things from your background",
                        answers = 5,
                    ),
                ),
                options = setOf(
                    Option("lorem"),
                    Option("lorem"),
                    Option("lorem"),
                    Option("lorem"),
                    Option("lorem"),
                ),
            ),
        ),
        actions = listOf(
            Action(
                description = "Make an incorrect assumption about one of your crewmates",
                diceOffset = 1,
            ),
            Action(
                description = "Not know Freetraveling things",
                diceOffset = 1,
            ),
            Action(
                description = "Ask a dumb question",
                diceOffset = 1,
            ),
            Action(
                description = "Ask nosy question",
                diceOffset = 1,
            ),
            Action(
                description = "Stumble over cant, or do something else awkward",
                diceOffset = 0,
            ),
            Action(
                description = "Learn a new thing just in time",
                diceOffset = -1,
            ),
            Action(
                description = "Learn how to get along with someone else better",
                diceOffset = -1,
            ),
            Action(
                description = "Help a crew mate",
                diceOffset = -1,
            ),
            Action(
                description = "Ask an insightful question",
                diceOffset = -1,
            ),
            Action(
                description = "Surprise someone with what you do know",
                diceOffset = -2,
            ),
            Action(
                description = "Choose a new playsheet. Put this one aside. Part with most of your things. Choose one other action here, add it to the new sheet.",
                diceOffset = -5,
            ),
        ),
    )

    val roles: WeightedSet<PlaySheetSpecification> = WeightedSet(
        wizard to 1,
        witch to 1,
        pilot to 1,
        liaison to 1,
        navigator to 1,
        mechanic to 1,
        explorer to 1,
        gardener to 1,
        tough to 1,
        voidworker to 1,
        newbie to 1,
    )
}
