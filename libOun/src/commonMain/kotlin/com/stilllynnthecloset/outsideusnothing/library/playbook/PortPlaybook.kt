package com.stilllynnthecloset.outsideusnothing.library.playbook

import com.stilllynnthecloset.outsideusnothing.library.model.ChoiceSpecification
import com.stilllynnthecloset.outsideusnothing.library.model.ContractQuality
import com.stilllynnthecloset.outsideusnothing.library.model.ContractSpecification
import com.stilllynnthecloset.outsideusnothing.library.model.ContractSpecification.Companion.generatedContract
import com.stilllynnthecloset.outsideusnothing.library.model.ContractSpecification.Companion.wildernessContract
import com.stilllynnthecloset.outsideusnothing.library.model.FlavorText
import com.stilllynnthecloset.outsideusnothing.library.model.Option
import com.stilllynnthecloset.outsideusnothing.library.model.PortOfCallSpecification
import com.stilllynnthecloset.outsideusnothing.library.model.Question
import com.stilllynnthecloset.outsideusnothing.library.tools.WeightedSet

/**
 * PortPlaybook - TODO: Documentation
 *
 * Created by Lynn on 4/14/23
 */
internal object PortPlaybook {
    private val companyPort: PortOfCallSpecification = PortOfCallSpecification(
        name = "The Company Port",
        flavorText = FlavorText(
            text = "Welcome to Transcend Calypso. Please select psychogogic advert program now",
            attribution = "Planetary Winnipeg slogan, prior to the Constabulary ousting SaintsCo",
        ),
        description = "It’s the top of a space elevator, a station in the void, perhaps even (shockingly) on a planet itself. But wherever it is physically the construction is all the same. The brands the same. The shops the same. The floor utilitarian. The walls to clean. The people too quiet. The cops everywhere. Remember to pay your docking fee.",
        choices = setOf(
            ChoiceSpecification(
                options = setOf(
                    Option("Color"),
                    Option("Music"),
                    Option("Crowds"),
                    Option("Bars or dancing"),
                    Option("Religion"),
                    Option("Anything old"),
                    Option("A place to stay"),
                    Option("A place to serve you"),
                    Option("Other freetravelers"),
                    Option("Gambling"),
                    Option("Families"),
                ),
                questions = listOf(
                    Question(
                        question = "Two things you look for and can’t find here",
                        answers = 2,
                    ),
                ),
            ),
        ),
        contracts = setOf(
            ContractSpecification(
                description = "A company offering very subpar pay for hauling waste",
                quality = ContractQuality.VERY_SUBPAR,
            ),
            ContractSpecification(
                description = "A company offering subpar pay for transporting indentured workers",
                quality = ContractQuality.SUBPAR,
            ),
            ContractSpecification(
                description = "A company offering good pay for transporting an unmarked single crate so long as you don’t ask any questions",
                quality = ContractQuality.GOOD,
            ),
            ContractSpecification(
                description = "A union fighting the corporations offering good pay to get a witness out of the port",
                quality = ContractQuality.GOOD,
            ),
            ContractSpecification(
                description = "A shady man who refuses to give a name offering good pay to get several suspicious bales out of the port",
                quality = ContractQuality.GOOD,
            ),
            ContractSpecification(
                description = "A lone family trying to sell themselves into indenturement at a different port offering subpar pay for transport",
                quality = ContractQuality.SUBPAR,
            ),
            ContractSpecification(
                description = "A company executive offering average pay to “experience Freetraveler life” with you",
                quality = ContractQuality.AVERAGE,
            ),
            ContractSpecification(
                description = "An indentured person offering very subpar pay to be smuggled out",
                quality = ContractQuality.VERY_SUBPAR,
            ),
            ContractSpecification(
                description = "A rival company offering excellent pay to smuggle out highly dangerous information on the company that owns the port",
                quality = ContractQuality.EXCELLENT,
            ),
            generatedContract,
        ),
        minContracts = 3,
    )

    private val freePort: PortOfCallSpecification = PortOfCallSpecification(
        name = "The Free Port",
        flavorText = FlavorText(
            text = "Pay the Shrouds well, keep your head down, don’t drink vacuum",
            attribution = "Saying on Orbital Descant",
        ),
        description = "Some might consider it a smuggler hideout. To others an anti-corporate, post revolution haven. Or maybe it’s wherever was convenient. But, spinning around some frontier world, or mined into an asteroid, or simple a few dozen old ships lashed together, one thing will always be true. No taxes. Perfect for Freetravelers.",
        choices = setOf(
            ChoiceSpecification(
                options = setOf(
                    Option("A powerful, ancient z-machine left behind by the builders"),
                    Option("A worker’s collective"),
                    Option("Some might call it a gang"),
                    Option("One rich family don, no one asks where they get their money"),
                    Option("Dumb a-machines still spinning"),
                    Option("Retired Freetravelers"),
                    Option("No one knows"),
                    Option("Everyone chips in"),
                ),
                questions = listOf(
                    Question(
                        question = "Who is keeping the lights on and the air breathable here",
                        answers = 1,
                    ),
                ),
            ),
        ),
        contracts = setOf(
            ContractSpecification(
                description = "A company offering average pay for intel on the Free Port",
                quality = ContractQuality.AVERAGE,
            ),
            ContractSpecification(
                description = "A company offering excellent pay to sabotage the Free Port",
                quality = ContractQuality.EXCELLENT,
            ),
            ContractSpecification(
                description = "A concerned citizen offering subpar pay for something the Free Port desperately needs",
                quality = ContractQuality.SUBPAR,
            ),
            ContractSpecification(
                description = "A fellow Freetraveler offering average pay to be taken to a different Free Port where a ship waits",
                quality = ContractQuality.GOOD,
            ),
            ContractSpecification(
                description = "A former Freetraveler offering excellent pay for one last trip to the place they plan on retiring",
                quality = ContractQuality.EXCELLENT,
            ),
            ContractSpecification(
                description = "A smuggler offering subpar pay for delivering something lifesaving through a controlled port or region",
                quality = ContractQuality.SUBPAR,
            ),
            ContractSpecification(
                description = "A smuggler offering good pay for delivering something addictive through a controlled port or region",
                quality = ContractQuality.GOOD,
            ),
            ContractSpecification(
                description = "A smuggler offering excellent pay for delivering something lethal through a controlled port or region",
                quality = ContractQuality.EXCELLENT,
            ),
            generatedContract,
        ),
        minContracts = 3,
    )

    private val piratePort: PortOfCallSpecification = PortOfCallSpecification(
        name = "The Pirate Port",
        flavorText = FlavorText(
            text = "Ten times more murders in the past period than I in the kiloperiod prior",
            attribution = "Station AI on Harfast, after Irons gang take over",
        ),
        description = "The air smells wrong when the doors open. The lights flicker. No one has repaired the docking clamps. This place is the real Libertalia, and like all pirate havens across all history it won’t last. It doesn’t have to. It just needs to hold together for some dishonest wealth to be spent, unloaded, and traded back into the economy.",
        choices = setOf(
            ChoiceSpecification(
                options = setOf(
                    Option("An asteroid mine"),
                    Option("A corporate port"),
                    Option("A dark matter well"),
                    Option("A space elevator"),
                    Option("An exocolony"),
                    Option("A monastery"),
                    Option("A huge spacecraft"),
                    Option("A military outpost"),
                ),
                questions = listOf(
                    Question(
                        question = "What was this place before the world moved on",
                        answers = 1,
                    ),
                ),
            ),
            ChoiceSpecification(
                options = setOf(
                    Option("Abandoned salvage"),
                    Option("Stolen tech"),
                    Option("Dangerous weapons"),
                    Option("Food and medicine meant for elsewhere"),
                    Option("Life-ruining drugs"),
                    Option("People"),
                    Option("Ships"),
                    Option("Forbidden magic"),
                ),
                questions = listOf(
                    Question(
                        question = "Two goods that pass through here",
                        answers = 2,
                    ),
                ),
            ),
        ),
        contracts = setOf(
            ContractSpecification(
                description = "A company rep buying from pirates offering subpar pay for transporting what they’ve bought back to corporate space",
                quality = ContractQuality.SUBPAR,
            ),
            ContractSpecification(
                description = "Someone from whatever this place was before offering very subpar pay to take them off it",
                quality = ContractQuality.VERY_SUBPAR,
            ),
            ContractSpecification(
                description = "A company spy offering excellent pay to destroy the port",
                quality = ContractQuality.EXCELLENT,
            ),
            ContractSpecification(
                description = "A fence offering excellent pay for delivery of whatever the port trades in, no matter the source",
                quality = ContractQuality.EXCELLENT,
            ),
            ContractSpecification(
                description = "A pirate looking for someone willing to lure ships in towards an ambush offering average pay",
                quality = ContractQuality.AVERAGE,
            ),
            ContractSpecification(
                description = "A pirate looking for a partner on a heist on a different port offering good pay",
                quality = ContractQuality.GOOD,
            ),
            ContractSpecification(
                description = "A pirate looking for a partner on an attack on a ship offering excellent pay",
                quality = ContractQuality.EXCELLENT,
            ),
            generatedContract,
        ),
        minContracts = 2,
    )

    private val militaryPort: PortOfCallSpecification = PortOfCallSpecification(
        name = "The Military Port",
        flavorText = FlavorText(
            text = "Synarchs. By definition we don’t have to tell you what we’re doing",
            attribution = "Transmission intercepted by DiemCo listening station 9",
        ),
        description = "This is a port, yes, with docks and repairs and all the other expected things. But it’s quiet. Buttoned up. Not for you. Because this is here to repair and resupply a military fleet, to hold systems and worlds. You are not military, Freetraveler. Do your business and move on quickly.",
        choices = setOf(
            ChoiceSpecification(
                options = setOf(
                    Option("This place is actively under fire"),
                    Option("This place is supplying the front"),
                    Option("This place has not seen action in decaperiods"),
                    Option("This place is secret"),
                    Option("This place is occupying captured territory"),
                    Option("This place is a prison"),
                ),
                questions = listOf(
                    Question(
                        question = "Something about this place",
                        answers = 1,
                    ),
                ),
            ),
            ChoiceSpecification(
                options = setOf(
                    Option("Corporate security"),
                    Option("A fascist, expansionist cult"),
                    Option("Psmanthics"),
                    Option("Anti-company rebels"),
                    Option("An isolated force claimed to defend a species"),
                    Option("Synarch secret rulers"),
                    Option("An Angelic Kingdom"),
                    Option("Religious sects"),
                    Option("A single hivemind"),
                    Option("One of the devil factions"),
                ),
                questions = listOf(
                    Question(
                        question = "What military holds this port",
                        answers = 1,
                    ),
                ),
            ),
        ),
        contracts = setOf(
            ContractSpecification(
                description = "The military offering very subpar pay to leave and not tell anyone about what they saw",
                quality = ContractQuality.VERY_SUBPAR,
            ),
            ContractSpecification(
                description = "The military offering average pay for useful intel on the enemy",
                quality = ContractQuality.AVERAGE,
            ),
            ContractSpecification(
                description = "The military offering excellent pay to deliver weapons and supplies to the front lines",
                quality = ContractQuality.EXCELLENT,
            ),
            ContractSpecification(
                description = "A war profiteer offering subpar pay to smuggle stolen military equipment away from the port",
                quality = ContractQuality.SUBPAR,
            ),
            ContractSpecification(
                description = "A war profiteer offering excellent pay to have some unique weapon smuggled away",
                quality = ContractQuality.EXCELLENT,
            ),
            ContractSpecification(
                description = "A deserter offering very subpar pay to me freed from military service",
                quality = ContractQuality.VERY_SUBPAR,
            ),
            generatedContract,
        ),
        minContracts = 1,
    )

    private val authoritarianPort: PortOfCallSpecification = PortOfCallSpecification(
        name = "The Authoritarian Port",
        flavorText = FlavorText(
            text = "Terre, Freetravelers, syndicalists, synarchs, and all other disruptive elements are to be reported immediately",
            attribution = "Posters of the Angelic Kingdoms",
        ),
        description = "Safe behind military lines and military ports comes a place far away from military ports. Clean. Quiet. Orderly. You are not welcome here far from corporate degeneracy. Dissident elements and division have no place within the rules that have been imposed here. Freetraveler, anarchist, syndicalist, scofflaw. Move on.",
        choices = setOf(
            ChoiceSpecification(
                options = setOf(
                    Option("The Constabulary of Man"),
                    Option("A queerphobic splinter group"),
                    Option("The Psmanthic Choir"),
                    Option("A post-revolutionary police state"),
                    Option("One of the Angelic Kingdoms"),
                    Option("This place is a prison"),
                ),
                questions = listOf(
                    Question(
                        question = "Whose fascist rule holds here",
                        answers = 1,
                    ),
                ),
            ),
            ChoiceSpecification(
                options = setOf(
                    Option("Orbital defenses"),
                    Option("Omnipresent surveillance"),
                    Option("Police presence"),
                    Option("Drone swarms"),
                    Option("Magical limiters"),
                    Option("Mind control"),
                    Option("Regular purges"),
                    Option("Scapegoating aliens, others"),
                    Option("Hateful rallies"),
                    Option("Arresting Freetravelers and others strangers"),
                    Option("Liberal complacency"),
                    Option("Not-so-secret corporate sponsorship"),
                ),
                questions = listOf(
                    Question(
                        question = "Two ways this port is policed and controlled",
                        answers = 2,
                    ),
                ),
            ),
        ),
        contracts = setOf(
            ContractSpecification(
                description = "Dissidents offering very subpar pay for info",
                quality = ContractQuality.VERY_SUBPAR,
            ),
            ContractSpecification(
                description = "Dissidents offering subpar pay for weapons smuggled through",
                quality = ContractQuality.SUBPAR,
            ),
            ContractSpecification(
                description = "The police offering subpar pay for intel on dissidents",
                quality = ContractQuality.SUBPAR,
            ),
            ContractSpecification(
                description = "The police offering normal pay for delivery of a dissident leader",
                quality = ContractQuality.AVERAGE,
            ),
            ContractSpecification(
                description = "The police offering good pay for help putting down revolution",
                quality = ContractQuality.GOOD,
            ),
            ContractSpecification(
                description = "A dictator offering excellent pay for an offworld delicacy unable to be produced within the dictatorship",
                quality = ContractQuality.EXCELLENT,
            ),
            generatedContract,
        ),
        minContracts = 1,
    )

    private val pharos: PortOfCallSpecification = PortOfCallSpecification(
        name = "The Pharos",
        flavorText = FlavorText(
            text = "The authorities say that my light is dangerous. All are wrong. Stare into me. Come closer. I love you",
            attribution = "whispers",
        ),
        description = "A lonely warning with a sacred meaning. Danger, the signal it sends says. Stay away. Or, alternately, this is how you safely transit. This is how you sail this straight, enter this port, keep flying. For most that is all this place is, a little reminder in the dark. Now you have arrived, after careful approach, to do business.",
        choices = setOf(
            ChoiceSpecification(
                options = setOf(
                    Option("Dark matter tears"),
                    Option("Ethermatter reefs"),
                    Option("Another port of call"),
                    Option("The way through the dark, a way home"),
                    Option("Orbital radiation belts"),
                    Option("Actual planetary ocean hazards and storms"),
                ),
                questions = listOf(
                    Question(
                        question = "What this signal portends",
                        answers = 1,
                    ),
                ),
            ),
            ChoiceSpecification(
                options = setOf(
                    Option("A light pulsing through the dark"),
                    Option("A view from a great height"),
                    Option("A splash of waves, a taste of salt"),
                    Option("A circle of wheeling creatures"),
                    Option("A high and lonely isolation"),
                    Option("A torturous approach"),
                    Option("A haunted, eldritch air"),
                    Option("A quiet serenity"),
                    Option("A wind, etheric or atmospheric"),
                    Option("A team maintaining it"),
                    Option("A secretive, solitary guardian"),
                    Option("A shrine, hollows, bones"),
                    Option("A light, the sun, the sun, the sun"),
                ),
                questions = listOf(
                    Question(
                        question = "Three things this lighthouse has",
                        answers = 3,
                    ),
                ),
            ),
        ),
        contracts = setOf(
            ContractSpecification(
                description = "A stranded voyager very subpar pay for a way home",
                quality = ContractQuality.VERY_SUBPAR,
            ),
            ContractSpecification(
                description = "The lighthouse keeper offering very subpar pay for a simple comfort",
                quality = ContractQuality.VERY_SUBPAR,
            ),
            ContractSpecification(
                description = "The lighthouse offering subpar pay for something vital",
                quality = ContractQuality.SUBPAR,
            ),
            ContractSpecification(
                description = "The builder, the pharotekton, offering good pay to contain the light",
                quality = ContractQuality.AVERAGE,
            ),
            ContractSpecification(
                description = "The light offering good pay to behold",
                quality = ContractQuality.GOOD,
            ),
            generatedContract,
        ),
        minContracts = 1,
    )

    private val researchBase: PortOfCallSpecification = PortOfCallSpecification(
        name = "The Research Base",
        flavorText = FlavorText(
            text = "The Choir clearly has found something out in Deep Wild Dark. Stolen from the Synarchs. An entity or object referred to in the Sinner Sun",
            attribution = "Infamous “Sinner Sun” memo",
        ),
        description = "Labs. Hothouses. Black ops exotemporal psych projects. The universe is full of places like this for the same reason it is full of the unexplained and the unknown. Magic, conventional, spatial, universal, what have you, where there is something unknown there will be people, power, and money interested in making it known.",
        choices = setOf(
            ChoiceSpecification(
                options = setOf(
                    Option("Astroneering events"),
                    Option("Deep history"),
                    Option("Psychokinetics"),
                    Option("Etheric magic science"),
                    Option("Organic biospherics"),
                    Option("Orbital oddities"),
                    Option("Big universal laws"),
                    Option("Bigger explosions"),
                ),
                questions = listOf(
                    Question(
                        question = "What is this place studying",
                        answers = 1,
                    ),
                ),
            ),
            ChoiceSpecification(
                options = setOf(
                    Option("Earnest underfunded academics"),
                    Option("Stern military scientists"),
                    Option("Black ops spooks"),
                    Option("An autonomous z-machine god"),
                    Option("A national jingoistic agency"),
                    Option("Strangely, the mob"),
                    Option("Spooky, brainwashed mumblers"),
                    Option("Something outside the universe"),
                    Option("Single-minded megalomaniacs"),
                ),
                questions = listOf(
                    Question(
                        question = "Who is running this place",
                        answers = 1,
                    ),
                ),
            ),
        ),
        contracts = setOf(
            ContractSpecification(
                description = "A lab project offering very subpar pay to be smuggled out",
                quality = ContractQuality.VERY_SUBPAR,
            ),
            ContractSpecification(
                description = "A harried scientist offering very subpar pay to get data out",
                quality = ContractQuality.VERY_SUBPAR,
            ),
            ContractSpecification(
                description = "A panicking scientist offering subpar pay to get a warning out",
                quality = ContractQuality.SUBPAR,
            ),
            ContractSpecification(
                description = "A bored scientist offering average pay to deliver an expected sample shipment",
                quality = ContractQuality.AVERAGE,
            ),
            ContractSpecification(
                description = "A twitchy scientist offering average pay to deliver unmarked packages",
                quality = ContractQuality.AVERAGE,
            ),
            ContractSpecification(
                description = "Leadership offering good pay to get a sample or project back",
                quality = ContractQuality.GOOD,
            ),
            ContractSpecification(
                description = "Something gone very wrong offering excellent pay to be let out",
                quality = ContractQuality.EXCELLENT,
            ),
            generatedContract,
        ),
        minContracts = 2,
    )

    private val darkMatterWell: PortOfCallSpecification = PortOfCallSpecification(
        name = "The Dark Matter Well",
        flavorText = FlavorText(
            text = "I arrived yesterday, which was a bit of a problem since I was just pulling in now. When is this? I need to haul the dark matter out of here and get paid",
            attribution = "Dark matter hauler on Well 536",
        ),
        description = "Most people don’t like to recognize how much of modern tech relies on the extraction of dark matter from the etheric sea. But someone has to do it, right? Punch a hole in the skin of the universe into a rich tract. Haul the black gold out. Try to ignore the damage and aura of spookiness for lightperiods all around it.",
        choices = setOf(
            ChoiceSpecification(
                options = setOf(
                    Option("DiemCo, ApotheosInc, TianCo, or another company"),
                    Option("Ghosts"),
                    Option("A national or polity entity"),
                    Option("A military supplier"),
                    Option("Synarchs"),
                    Option("The Psmanthic Choir"),
                    Option("A worker’s collective"),
                ),
                questions = listOf(
                    Question(
                        question = "Who operates this place polluting the etheric sea",
                        answers = 1,
                    ),
                ),
            ),
            ChoiceSpecification(
                options = setOf(
                    Option("Time skips, starts, flow backward"),
                    Option("Tech doesn’t work, or works oddly"),
                    Option("The shadows make weird patterns"),
                    Option("Anyone staying too long gets sick"),
                    Option("Workers talk about seeing things"),
                    Option("There’s a song with no source"),
                    Option("Dimensions contract, expand"),
                ),
                questions = listOf(
                    Question(
                        question = "Two things inescapably wrong and damaged about this place",
                        answers = 2,
                    ),
                ),
            ),
        ),
        contracts = setOf(
            ContractSpecification(
                description = "Someone who owns the mine whose regular shipper unexpectedly quit and needs dark matter hauled, offering very subpar pay",
                quality = ContractQuality.VERY_SUBPAR,
            ),
            ContractSpecification(
                description = "A traumatized, terrified worker offering very subpar pay to be immediately taken off the well",
                quality = ContractQuality.VERY_SUBPAR,
            ),
            ContractSpecification(
                description = "A haunted, distracted worker offering subpar pay to bring them illegal drugs that might make working on the well a little more tolerable",
                quality = ContractQuality.SUBPAR,
            ),
            ContractSpecification(
                description = "An extradimensional entity speaking in whispers, asking for a piece of it to be taken elsewhere, offering excellent pay",
                quality = ContractQuality.EXCELLENT,
            ),
            generatedContract,
        ),
        minContracts = 1,
    )

    private val asteroidMine: PortOfCallSpecification = PortOfCallSpecification(
        name = "Asteroid Mine",
        flavorText = FlavorText(
            text = "We haul it all the way out here to the langrangian, near the station, then the indentures break it down. I don’t think about that part",
            attribution = "Rockhauler for TianCorp, during interview on Infinity Verge conducted by Sri Marmolejo",
        ),
        description = "Etheric sciences may demand more exotic extraction, but industry and war both need gas, metal, and ice. All of which can be found on comets, asteroids floating in the black. Each of them holding more than entire pre-spaceflight civilizations used in hundreds of years of industrialization. There are millions of these mines.",
        choices = setOf(
            ChoiceSpecification(
                options = setOf(
                    Option("Bots, either dumb a-machines or smart z-machines"),
                    Option("Bioconstructs"),
                    Option("Well-paid workers"),
                    Option("Indentured workers"),
                    Option("Golems"),
                    Option("Soldiers"),
                    Option("Wildcat miners"),
                ),
                questions = listOf(
                    Question(
                        question = "Who is mining this dangerous, frequently toxic, anoxic, and collapsing place",
                        answers = 1,
                    ),
                ),
            ),
        ),
        contracts = setOf(
            ContractSpecification(
                description = "The mine owner whose regular shipper unexpectedly quit and needs minerals hauled, offering very subpar pay",
                quality = ContractQuality.VERY_SUBPAR,
            ),
            ContractSpecification(
                description = "The mine owner offering subpar pay deliver a bribe to pirates, a military or company to not attack them",
                quality = ContractQuality.SUBPAR,
            ),
            ContractSpecification(
                description = "The mine owner offering average pay for delivery of defensive weapons or anti-riot gear",
                quality = ContractQuality.AVERAGE,
            ),
            ContractSpecification(
                description = "A long hauler offering good pay for a safe escort from the mine to their destination",
                quality = ContractQuality.GOOD,
            ),
            ContractSpecification(
                description = "A nascent union offering very subpar pay for personal weapons, gas masks or supplies",
                quality = ContractQuality.VERY_SUBPAR,
            ),
            ContractSpecification(
                description = "A rival company, a military or pirates offering excellent pay for industrial sabotage, the location, or anything that lets them take and hold the mine from its current owner",
                quality = ContractQuality.EXCELLENT,
            ),
            generatedContract,
        ),
        minContracts = 2,
    )

    private val shipyard: PortOfCallSpecification = PortOfCallSpecification(
        name = "Shipyard",
        flavorText = FlavorText(
            text = "Upon arrival, bioship whalefall showed extensive signs of fabula colonization, devil hives and trees erupting from it. They are building seedships from its corpse",
            attribution = "Intercepted ApotheosInc intel",
        ),
        description = "As much as you Freetravelers might try to ignore it, ships are not immortal. They die. Sometimes in great solitary disasters like whalefalls. Sometimes in great shoals. And when they do there needs to be workers to break them apart, strip them for resources, rewire them, rework them, rebuild them. And build new ones too.",
        choices = setOf(
            ChoiceSpecification(
                options = setOf(
                    Option("Huge foundries, floating in the black"),
                    Option("Breeding, slaughtering"),
                    Option("Carved from asteroid, torn roughly apart"),
                    Option("Scuttling workers on hulls"),
                    Option("Planetary mines, atmospheric burn ups"),
                    Option("Necromancy, decay"),
                    Option("Esoteric patterns carved in reality"),
                ),
                questions = listOf(
                    Question(
                        question = "How are ships born and die here",
                        answers = 1,
                    ),
                ),
            ),
        ),
        contracts = setOf(
            ContractSpecification(
                description = "A scrapper offering excellent pay for hauling spaceship wrecks to them",
                quality = ContractQuality.EXCELLENT,
            ),
            ContractSpecification(
                description = "A shipbuilder offering good pay for the delivery of rare spaceship parts",
                quality = ContractQuality.GOOD,
            ),
            ContractSpecification(
                description = "A shipbuilder offering excellent pay for hauling a newborn spaceship to its buyer",
                quality = ContractQuality.EXCELLENT,
            ),
            ContractSpecification(
                description = "A ship itself offering very subpar pay to be rescued from destruction",
                quality = ContractQuality.VERY_SUBPAR,
            ),
            ContractSpecification(
                description = "A ship itself offering very subpar pay to have its part used by a worthy cause, or in a new good ship",
                quality = ContractQuality.VERY_SUBPAR,
            ),
            ContractSpecification(
                description = "A distraught Freetraveler or other spacefarer offering very subpar pay to find the ship they built, or rescued, or that rescued them",
                quality = ContractQuality.VERY_SUBPAR,
            ),
            ContractSpecification(
                description = "A well dressed made man offering excellent pay to find some misplaced evidence on one ship if no questions are asked",
                quality = ContractQuality.EXCELLENT,
            ),
            ContractSpecification(
                description = "A well dressed made man offering excellent pay for a fast, reliable, disposable ship that can’t be traced if no questions are asked",
                quality = ContractQuality.EXCELLENT,
            ),
            generatedContract,
        ),
        minContracts = 2,
    )

    private val ambiguousUtopia: PortOfCallSpecification = PortOfCallSpecification(
        name = "Ambiguous Utopia",
        flavorText = FlavorText(
            text = "We left the corrupt Elect of Parabuteo, the homeworld, and came here to found a better place for songs. A place where everyone would be one great pack together",
            attribution = "Mission statement of Abehemaloth, Harrisi splinter group",
        ),
        description = "There was a revolution here, some time before. A great change of corporate, feudal, or tyrannical authority, making way to a commune where in theory all people’s needs are provided for, from each according to their ability. That was then. This is now. And who can say whether revolutionary spirit persists.",
        choices = setOf(
            ChoiceSpecification(
                options = setOf(
                    Option("Asteroid mines, dark matter wells"),
                    Option("Planetary extraction farms"),
                    Option("Towering space elevators"),
                    Option("Devastating crust mining"),
                    Option("Dense, orbital labor habitats"),
                ),
                questions = listOf(
                    Question(
                        question = "What capitalist ruins was this place built upon",
                        answers = 1,
                    ),
                ),
            ),
            ChoiceSpecification(
                options = setOf(
                    Option("Habituatal hierarchies, power structures"),
                    Option("Lack of democratic control"),
                    Option("Ecologically unsustainable industries"),
                    Option("Slow increasing xenophobia"),
                    Option("A dark secret, a small child suffering"),
                ),
                questions = listOf(
                    Question(
                        question = "Jow may the revolutionary zeal be slipping",
                        answers = 1,
                    ),
                ),
            ),
        ),
        contracts = setOf(
            ContractSpecification(
                description = "The commune offering subpar pay for delivery of alchemical medicine",
                quality = ContractQuality.SUBPAR,
            ),
            ContractSpecification(
                description = "The commune offering subpar pay for delivery of nutrient dense food",
                quality = ContractQuality.SUBPAR,
            ),
            ContractSpecification(
                description = "The commune offering subpar pay for delivery of solarpunk tech",
                quality = ContractQuality.SUBPAR,
            ),
            ContractSpecification(
                description = "The commune offering subpar pay for delivery of academic works",
                quality = ContractQuality.SUBPAR,
            ),
            ContractSpecification(
                description = "The commune offering subpar pay for delivery of defensive weapons",
                quality = ContractQuality.SUBPAR,
            ),
            ContractSpecification(
                description = "The commune offering subpar pay for delivery of etheric devices",
                quality = ContractQuality.SUBPAR,
            ),
            ContractSpecification(
                description = "Counterrevolutionaries or reactionaries offering good pay for helping to fight and take over the commune",
                quality = ContractQuality.GOOD,
            ),
            ContractSpecification(
                description = "A capitalist offering excellent pay to help invade, destroy or overthrow the commune",
                quality = ContractQuality.EXCELLENT,
            ),
            generatedContract,
        ),
        minContracts = 2,
    )

    private val exocolony: PortOfCallSpecification = PortOfCallSpecification(
        name = "Exocolony",
        flavorText = FlavorText(
            text = "Faithful to the Elect of Parabuteo, we continue to sing to the stars",
            attribution = "New Parabuteo’s anthem, translated",
        ),
        description = "Not everything is industry, crime, war, some of us just live here. Various species have been pushing out across space since as long as there has been history. All sorts of reasons to settle new places. Opportunity. Freedom. Resources. Curiosity.Imperialism. The best and worst of all aliens. This is just one of the newest.",
        choices = setOf(
            ChoiceSpecification(
                options = setOf(
                    Option("Fleeing war or persecution"),
                    Option("Funded by some larger expanding polity"),
                    Option("Nomadic culture"),
                    Option("Religious journey"),
                    Option("Business venture"),
                    Option("Cultural ennui"),
                    Option("Because it’s there"),
                ),
                questions = listOf(
                    Question(
                        question = "One species is largely leading this settlement charge, why has this group in particular has come here",
                        answers = 1,
                    ),
                ),
            ),
            ChoiceSpecification(
                options = setOf(
                    Option("Through a kerama point leading nowhere else"),
                    Option("A space habitat"),
                    Option("A desolate moon"),
                    Option("In another dimension"),
                    Option("A feral planet"),
                    Option("Far into the abandoned Deep Wild Dark"),
                ),
                questions = listOf(
                    Question(
                        question = "Where exactly is this colony located",
                        answers = 1,
                    ),
                ),
            ),
        ),
        contracts = setOf(
            ContractSpecification(
                description = "The colony leaders offer very subpar pay for scouting the surrounding territory around their colony",
                quality = ContractQuality.VERY_SUBPAR,
            ),
            ContractSpecification(
                description = "The colony leaders offering very subpar pay to carry messages back home",
                quality = ContractQuality.VERY_SUBPAR,
            ),
            ContractSpecification(
                description = "The colony leaders offering subpar pay for delivery of something the colony needs to stay alive",
                quality = ContractQuality.SUBPAR,
            ),
            ContractSpecification(
                description = "A surprise local indogene alien offering very subpar pay to broker peace talks with the colonists",
                quality = ContractQuality.VERY_SUBPAR,
            ),
            ContractSpecification(
                description = "A local indogene alien offering very subpar pay to drive the colonists off their new home",
                quality = ContractQuality.VERY_SUBPAR,
            ),
            ContractSpecification(
                description = "An archaeologist or adventurer offering excellent pay to find some local treasure before the colonists can",
                quality = ContractQuality.EXCELLENT,
            ),
            generatedContract,
        ),
        minContracts = 1,
    )

    private val uncontactedWorld: PortOfCallSpecification = PortOfCallSpecification(
        name = "Uncontacted World",
        flavorText = FlavorText(
            text = "One day a ship simply appeared in sky. You could see it from the surface. It said that it had bought the world",
            attribution = "Source unknown",
        ),
        description = "The networks of capitalism, imperialism, and even you Freetravelers are impressive, perforating the universe through kerama points. But not all aliens exist within these interconnected networks. Some are pre-FTL. Pre-spaceflight. Even pre-industrial. This is one such world. Until very recently at least.",
        choices = setOf(
            ChoiceSpecification(
                options = setOf(
                    Option("Being able to understand the local language or customs"),
                    Option("Being able to barter for fuel, supplies, and repairs"),
                    Option("Beacons, lighthouses, orbital environments, or other infrastructure"),
                    Option("A local net and connections to upload, download, or exchange data"),
                    Option("People who at the very least have heard of contracts or Freetravelers"),
                    Option("Strangely, corporations, or at least knowing familiar power structures"),
                ),
                questions = listOf(
                    Question(
                        question = "Invent a new alien that inhabits this world and then pick two things you can find almost everywhere else you miss here",
                        answers = 2,
                    ),
                ),
            ),
        ),
        contracts = setOf(
            ContractSpecification(
                description = "The new world offering very subpar pay leaving them alone",
                quality = ContractQuality.VERY_SUBPAR,
            ),
            ContractSpecification(
                description = "The new world offering very subpar pay to teach them of the universe",
                quality = ContractQuality.VERY_SUBPAR,
            ),
            ContractSpecification(
                description = "The new world offering subpar pay weapons, magic, or tech",
                quality = ContractQuality.SUBPAR,
            ),
            ContractSpecification(
                description = "An anthropologist offering normal pay to interview and surveil the planet from the surface",
                quality = ContractQuality.AVERAGE,
            ),
            ContractSpecification(
                description = "A company plant offering good pay to help set up a trading outpost",
                quality = ContractQuality.GOOD,
            ),
            ContractSpecification(
                description = "An expansionist forward scout offering excellent pay to help conquer the world",
                quality = ContractQuality.EXCELLENT,
            ),
            generatedContract,
        ),
        minContracts = 1,
    )

    private val derelict: PortOfCallSpecification = PortOfCallSpecification(
        name = "Derelict",
        flavorText = FlavorText(
            text = "I have slept here so long on this empty worldship. Sleeping in my digital dreams of hell. All shall be well.",
            attribution = "whispers",
        ),
        description = "Kerama points are supposed to be easy, point to point transport. But sometimes that spit out a wrecked ship that had been in there too long. Or maybe it was just floating in the black for eons, unnoticed. That’s plausible, right? Space is big. Try not to think about who might have built it or what might have climbed aboard.",
        choices = setOf(
            ChoiceSpecification(
                options = setOf(
                    Option("Cold metal"),
                    Option("Cracked ceramic"),
                    Option("Rust and bolts"),
                    Option("Stone"),
                    Option("Smooth plastic"),
                    Option("Flesh"),
                    Option("Glass of many shades"),
                    Option("Bone"),
                    Option("Wood and grown things"),
                ),
                questions = listOf(
                    Question(
                        question = "What material is this ship made of",
                        answers = 1,
                    ),
                ),
            ),
            ChoiceSpecification(
                options = setOf(
                    Option("Just bought or remodeled"),
                    Option("Full of hissing gasses and grease"),
                    Option("Old and antique"),
                    Option("Clean or sterile"),
                    Option("Alive"),
                    Option("Lived in"),
                    Option("Dead"),
                    Option("Tough and hardy"),
                    Option("Has cavernous spaces"),
                    Option("Always damp"),
                    Option("Has compact living quarters"),
                    Option("Irreplaceable"),
                    Option("Agile and fast"),
                    Option("Bigger on the inside"),
                    Option("Magical"),
                    Option("A place of worship"),
                    Option("A technological wonder"),
                    Option("Always breaking"),
                    Option("Haunted"),
                    Option("Brightly lit"),
                    Option("A memorial"),
                    Option("Full of shifting shadows"),
                    Option("An ecosystem"),
                    Option("Loved"),
                    Option("A piece of unique technology"),
                    Option("Home"),
                ),
                questions = listOf(
                    Question(
                        question = "Adjectives that describe this ship",
                        answers = 3,
                    ),
                    Question(
                        question = "Adjective that decidedly does not describe it",
                        answers = 1,
                    ),
                ),
            ),
        ),
        contracts = setOf(
            wildernessContract,
        ),
        minContracts = 1,
    )

    private val ruins: PortOfCallSpecification = PortOfCallSpecification(
        name = "Ruins",
        flavorText = FlavorText(
            text = "We grow outwards to fill space. This world’s space is no more. We take to the stars. Reclaimers",
            attribution = "Translation of Inscription A6091, from ‘Teuth: Possible Origins?’ pub. University of Trans-Hypholaris",
        ),
        description = "The universe is old. No, older than that. And this universe had other ones before it too, most philosophers hold. Untold numbers of civilizations, many of them using esoteric, unknown tech, have come into existence, flourished, and passed away. And some of them have left things behind.",
        choices = setOf(
            ChoiceSpecification(
                options = setOf(
                    Option("Time doesn’t work right"),
                    Option("It’s exposed to hard vacuum"),
                    Option("It shows horrible visions"),
                    Option("Corrosive gasses"),
                    Option("People don’t return"),
                    Option("Superstition"),
                    Option("Still active defenses"),
                    Option("Radiation"),
                    Option("Mutated wildlife"),
                ),
                questions = listOf(
                    Question(
                        question = "Why has this place remained abandoned",
                        answers = 1,
                    ),
                ),
            ),
            ChoiceSpecification(
                options = setOf(
                    Option("Tiles with too many angles"),
                    Option("Soaring pillars"),
                    Option("Alien skies"),
                    Option("Stones that swallow light"),
                    Option("Inscriptions no one can read"),
                    Option("Machines with no moving parts"),
                    Option("Memorials to unknown people"),
                    Option("Huge murals to lost history"),
                    Option("New growth in ancient halls"),
                    Option("Prowling shadows"),
                    Option("Huge libraries in odd media"),
                    Option("Metal warm to the touch"),
                    Option("Computers with no power source"),
                    Option("An empty throne"),
                    Option("A button longing to be pressed"),
                    Option("Doors waiting to be opened"),
                    Option("Rites hungry to be completed"),
                    Option("A monster"),
                    Option("A god"),
                ),
                questions = listOf(
                    Question(
                        question = "What are two things you can find here",
                        answers = 2,
                    ),
                ),
            ),
        ),
        contracts = setOf(
            wildernessContract,
        ),
        minContracts = 1,
    )

    private val dump: PortOfCallSpecification = PortOfCallSpecification(
        name = "Dump",
        flavorText = FlavorText(
            text = "She fell from the sky. But that doesn’t mean she was trash. Nothing here is",
            attribution = "Root Colony of Ameles Potamos, about Maybe Xis and the Pale Incident",
        ),
        description = "Interstellar capitalism does still produce its ruins. The mushrooms may still live in this, but for everything else here, with the rain of trash, and alchemical agents, and dangerous organics, and etheric detritus, and hard radiation falling from the sky, this is the end of the world. Pity whoever must scrape a living from this world.",
        choices = setOf(
            ChoiceSpecification(
                options = setOf(
                    Option("DiemCo, a brutal, powerful corp"),
                    Option("TianCorp, a loyal, venerable corp"),
                    Option("SaintsCo, a decrepit, failing corp"),
                    Option("ApotheosInc, a new, upstart corp"),
                    Option("Indiscriminate free industry"),
                ),
                questions = listOf(
                    Question(
                        question = "Who is using this world as a dumping grounds",
                        answers = 1,
                    ),
                ),
            ),
            ChoiceSpecification(
                options = setOf(
                    Option("Traumatized accident victims"),
                    Option("Malfunctioning old machines"),
                    Option("Mutant alien offshoots"),
                    Option("Indentured company salvagers"),
                    Option("Desperate wildcat workers"),
                    Option("The first inhabitants of the world"),
                    Option("Amnesiac shipfall survivors"),
                    Option("Plants that live in dead aliens"),
                    Option("Invasive pests from whalefalls"),
                ),
                questions = listOf(
                    Question(
                        question = "Who is to be found here",
                        answers = 1,
                    ),
                ),
            ),
        ),
        contracts = setOf(
            ContractSpecification(
                description = "People offering very subpar pay for passage offworld",
                quality = ContractQuality.VERY_SUBPAR,
            ),
            ContractSpecification(
                description = "People offering subpar pay for something important lost in the dump",
                quality = ContractQuality.SUBPAR,
            ),
            ContractSpecification(
                description = "A colony of friendly plants living in the corpses of dead aliens offering normal pay for a body for their newest sprout to root in",
                quality = ContractQuality.AVERAGE,
            ),
            wildernessContract,
        ),
        minContracts = 1,
    )

    private val hive: PortOfCallSpecification = PortOfCallSpecification(
        name = "Hive",
        flavorText = FlavorText(
            text = "I think it was a zph colony before the devils arrived. Zph used to have a colonial empire, I think? Maybe. But after it was something else entirely",
            attribution = "Binti Khouri, in a later interview",
        ),
        description = "A living zph home. A place overwhelmed by the fabula, that dimension where the devils come from. Something else organic. Ordered. Collective. Singular. Welcome to the hive. It is you on your ship and one out gestalt. There is no individuality here. Just the hive.",
        choices = setOf(
            ChoiceSpecification(
                options = setOf(
                    Option("Hungry"),
                    Option("Hostile"),
                    Option("Curious"),
                    Option("Neutral"),
                    Option("Superior"),
                ),
                questions = listOf(
                    Question(
                        question = "How does the hive mind feel about you",
                        answers = 1,
                    ),
                ),
            ),
            ChoiceSpecification(
                options = setOf(
                    Option("Buzzing and crawling"),
                    Option("Impersonal and precise"),
                    Option("On an inhuman scale"),
                    Option("Full of winding, snaking tunnels"),
                    Option("Organic, no hard angles"),
                    Option("Slimey, wet, fluid"),
                    Option("Choir music echoing"),
                    Option("Not even visually alive"),
                    Option("Strangely beautiful"),
                ),
                questions = listOf(
                    Question(
                        question = "How do you describe this place",
                        answers = 2,
                    ),
                ),
            ),
        ),
        contracts = setOf(
            ContractSpecification(
                description = "A parasite offering very subpar pay to be smuggled out",
                quality = ContractQuality.VERY_SUBPAR,
            ),
            ContractSpecification(
                description = "The gestalt offering average pay for its food",
                quality = ContractQuality.AVERAGE,
            ),
            ContractSpecification(
                description = "The gestalt offering average pay for something it needs to breed",
                quality = ContractQuality.AVERAGE,
            ),
            ContractSpecification(
                description = "The gestalt offering average pay for letting it study them",
                quality = ContractQuality.AVERAGE,
            ),
            ContractSpecification(
                description = "The gestalt offering average pay for carrying drones to a new location",
                quality = ContractQuality.AVERAGE,
            ),
            ContractSpecification(
                description = "The gestalt offering average pay for helping defend from another hive",
                quality = ContractQuality.AVERAGE,
            ),
            ContractSpecification(
                description = "The gestalt offering excellent pay to spread its influence",
                quality = ContractQuality.EXCELLENT,
            ),
            generatedContract,
        ),
        minContracts = 2,
    )

    private val extradimensionalPocket: PortOfCallSpecification = PortOfCallSpecification(
        name = "Extradimensional Pocket",
        flavorText = FlavorText(
            text = "How. Why. I want to sleep. I want to be alone. Talk to the whispers rather.",
            attribution = "SINNER SUN",
        ),
        description = "Older universes. The fabula, where some say devils come from.The fay. Wherever the angels are written into reality. Fold on folds, bigger on the inside. Not every place is here, exactly. Try to remember how you got here, and don’t forget the way out. The locals may be nice but still it’s probably best to not stay too long.",
        choices = setOf(
            ChoiceSpecification(
                options = setOf(
                    Option("An ancient spell"),
                    Option("A religious rite"),
                    Option("swirling portal"),
                    Option("A goetic bargain"),
                    Option("Unknown technology"),
                    Option("A weird malfunction"),
                    Option("A sudden abduction"),
                    Option("An odd kerama point"),
                ),
                questions = listOf(
                    Question(
                        question = "Choose the way here",
                        answers = 1,
                    ),
                ),
            ),
            ChoiceSpecification(
                options = setOf(
                    Option("Trees the size of whole systems"),
                    Option("Suns that are eyes"),
                    Option("Lilting inescapable music"),
                    Option("A sweet, clinging smell"),
                    Option("Swirling nebulas of color"),
                    Option("light you can’t escape"),
                    Option("Glowing, stinging insects"),
                    Option("Floating mountains, continents"),
                    Option("Cities without end"),
                    Option("Geography curving back around"),
                    Option("Oceans of wealth and treasure"),
                ),
                questions = listOf(
                    Question(
                        question = "Choose two beautiful, wrong things here",
                        answers = 2,
                    ),
                ),
            ),
        ),
        contracts = setOf(
            ContractSpecification(
                description = "Someone lost from reality offering very subpar pay for a way home",
                quality = ContractQuality.VERY_SUBPAR,
            ),
            ContractSpecification(
                description = "An intrepid researcher who seems not to mind where they are offering average pay to take their research back home in reality",
                quality = ContractQuality.AVERAGE,
            ),
            ContractSpecification(
                description = "The wild hunt, furies, fairies valkyries or more offering good pay for a fun war",
                quality = ContractQuality.GOOD,
            ),
            ContractSpecification(
                description = "A well dressed stranger offering good pay for a simple name",
                quality = ContractQuality.GOOD,
            ),
            ContractSpecification(
                description = "A well dressed stranger offering good pay to eat some food",
                quality = ContractQuality.GOOD,
            ),
            ContractSpecification(
                description = "A well dressed stranger offering good pay for a simple dance",
                quality = ContractQuality.GOOD,
            ),
            ContractSpecification(
                description = "This place’s ruler offering excellent pay for an irreplaceable thing left with them",
                quality = ContractQuality.EXCELLENT,
            ),
            ContractSpecification(
                description = "This place’s ruler offering expcellent pay for a debt and promise to spread their influence in reality",
                quality = ContractQuality.EXCELLENT,
            ),
            generatedContract,
        ),
        minContracts = 1,
    )

    private val academy: PortOfCallSpecification = PortOfCallSpecification(
        name = "The Academy",
        flavorText = FlavorText(
            text = "I think it was a zph colony before the devils arrived. Zph used to have a colonial empire, I think? Maybe. But after it was something else entirely",
            attribution = "Phaestrin Om, author of ‘Teuth: Possible Origins?’",
        ),
        description = "Corporate owned, independent, old, new, planetary, in the black, teaching gardening, wizardry, medicine, or who knows what, there must always be schools. Witch, wizard, research schools, the like. And where there is the academy there must also be trade, connecting it to the outside universe.",
        choices = setOf(
            ChoiceSpecification(
                options = setOf(
                    Option("In a dedicated space station"),
                    Option("In deep bunkers"),
                    Option("In lonely wastelands"),
                    Option("In bamboo forests"),
                    Option("In ancient, wild forests"),
                    Option("In a busy planetary city"),
                    Option("In another dimension"),
                    Option("In an old castle"),
                    Option("In sterile laboratories"),
                    Option("In modern schools"),
                    Option("In greenhouses"),
                    Option("In an unmappable library"),
                ),
                questions = listOf(
                    Question(
                        question = "Choose where this academy is located",
                        answers = 1,
                    ),
                ),
            ),
            ChoiceSpecification(
                options = setOf(
                    Option("Wizardry and the etheric sciences"),
                    Option("Older witchways"),
                    Option("Gardening"),
                    Option("History and culture"),
                    Option("Law"),
                    Option("Engineering"),
                    Option("Military tactics"),
                    Option("Something else"),
                ),
                questions = listOf(
                    Question(
                        question = "Choose what’s taught",
                        answers = 1,
                    ),
                ),
            ),
        ),
        contracts = setOf(
            ContractSpecification(
                description = "Students offering very subpar pay for cheap, low-level drugs",
                quality = ContractQuality.VERY_SUBPAR,
            ),
            ContractSpecification(
                description = "Students offering very subpar pay for cheating on their tests",
                quality = ContractQuality.VERY_SUBPAR,
            ),
            ContractSpecification(
                description = "Drunk students offering subpar pay to pull of the best prank ever",
                quality = ContractQuality.SUBPAR,
            ),
            ContractSpecification(
                description = "Students offering subpar pay for help protesting the academy’s governance, by resisting security and occupying the campus",
                quality = ContractQuality.SUBPAR,
            ),
            ContractSpecification(
                description = "Academy governance offering subpar pay to help place students in offworld jobs post graduation",
                quality = ContractQuality.SUBPAR,
            ),
            ContractSpecification(
                description = "Academy governance offering subpar pay to deliver a presentation on Freetraveling",
                quality = ContractQuality.SUBPAR,
            ),
            ContractSpecification(
                description = "A frat house offering good pay for the wildest party in the universe",
                quality = ContractQuality.GOOD,
            ),
            ContractSpecification(
                description = "Academy governance offering good pay for help in breaking up student protests",
                quality = ContractQuality.GOOD,
            ),
            generatedContract,
        ),
        minContracts = 2,
    )

    private val monastery: PortOfCallSpecification = PortOfCallSpecification(
        name = "Monastery",
        flavorText = FlavorText(
            text = "Might be an academic now at the University of Trans-Hypholaris, but I got started at Brin-hwei, among the meadows and bones",
            attribution = "Phaestrin Om, illuminator",
        ),
        description = "Wherever there is society, commerce there will be people not engaged in it. Some people do this to study magic and the ether. For others it may be religious, spiritual, aesthetic. This place is a place set aside. Is that not the real definition of sacred? Ignore hierarchies and power structures here, please.",
        choices = setOf(
            ChoiceSpecification(
                options = setOf(
                    Option("Stay silent"),
                    Option("Not eat certain foods"),
                    Option("Read daily"),
                    Option("Train to fight"),
                    Option("Call them titles"),
                    Option("Maintain farms"),
                    Option("Practice magic"),
                    Option("Maintain their beliefs"),
                ),
                questions = listOf(
                    Question(
                        question = "Choose what the abbott or abbess here makes people do here",
                        answers = 1,
                    ),
                ),
            ),
            ChoiceSpecification(
                options = setOf(
                    Option("Warm sun"),
                    Option("Quiet hallways"),
                    Option("Dusty books"),
                    Option("Ancient icons"),
                    Option("Comforting chapels"),
                    Option("Cats and dogs"),
                    Option("Cool floors"),
                    Option("Tiny cloisters"),
                    Option("Devout choirs"),
                    Option("Babbling fountains"),
                    Option("Growing plants"),
                    Option("Lowing animals"),
                    Option("Dark secrets"),
                    Option("A way to talk to god"),
                ),
                questions = listOf(
                    Question(
                        question = "Choose two you can find at this monastery",
                        answers = 2,
                    ),
                ),
            ),
        ),
        contracts = setOf(
            ContractSpecification(
                description = "A monk offering very subpar pay for some small outside vice",
                quality = ContractQuality.VERY_SUBPAR,
            ),
            ContractSpecification(
                description = "A monk offering very subpar pay for caring a message outside",
                quality = ContractQuality.VERY_SUBPAR,
            ),
            ContractSpecification(
                description = "A monk offering very subpar pay for smuggling them to the outside",
                quality = ContractQuality.VERY_SUBPAR,
            ),
            ContractSpecification(
                description = "A fugitive running offering subpar pay to fence stolen silver",
                quality = ContractQuality.SUBPAR,
            ),
            ContractSpecification(
                description = "A priest of some sort offering average pay for conducting a rite",
                quality = ContractQuality.AVERAGE,
            ),
            ContractSpecification(
                description = "The abbot offering average pay for some piece of equipment the monastery needs to survive",
                quality = ContractQuality.AVERAGE,
            ),
            ContractSpecification(
                description = "The abbot offering good pay for a holy book, religious artifact, or some bit of research from far away in the universe",
                quality = ContractQuality.GOOD,
            ),
            ContractSpecification(
                description = "The abbot offering excellent pay for a disgusting outside vice",
                quality = ContractQuality.EXCELLENT,
            ),
            generatedContract,
        ),
        minContracts = 1,
    )

    private val quarantinedPort: PortOfCallSpecification = PortOfCallSpecification(
        name = "Quarantined Port",
        flavorText = FlavorText(
            text = "DANGER MEMETIC PATHOGEN DETECTED KEEP DISTANCE AND AVOID DATA TRANSMISSION DANGER MEMETIC…",
            attribution = "Automated warning signal 1.36*",
        ),
        description = "You come out of the kerama point and there it is. Perhaps you had a warning it would be like this. Perhaps there’s a distress beacon talking about reactor breaches, and deadly contagions, and madness, or perhaps there is simply silence. Whatever it looks like, there has to be a reason for it all, right?",
        choices = setOf(
            ChoiceSpecification(
                options = setOf(
                    Option("Contagion risk"),
                    Option("Crazed populace"),
                    Option("Zombies"),
                    Option("Hard radiation"),
                    Option("A cover up"),
                    Option("An assassination"),
                    Option("Organized crime"),
                    Option("Survivors"),
                    Option("Still hope"),
                    Option("Determination"),
                    Option("A rare specimen"),
                    Option("A heist"),
                    Option("Mind control"),
                    Option("Ghosts"),
                ),
                questions = listOf(
                    Question(
                        question = "Choose two you can see inside if you look there",
                        answers = 2,
                    ),
                ),
            ),
            ChoiceSpecification(
                options = setOf(
                    Option("Warning beacons"),
                    Option("Destroyed ships"),
                    Option("Sealed airlocks"),
                    Option("Strange lights"),
                    Option("Dead bodies"),
                    Option("A blockade"),
                    Option("Blockade runners"),
                    Option("Guns trained on you"),
                    Option("Explosions"),
                ),
                questions = listOf(
                    Question(
                        question = "Choose two you can see from the outside",
                        answers = 2,
                    ),
                ),
            ),
        ),
        contracts = setOf(
            ContractSpecification(
                description = "A survivor offering very subpar pay for something lifesaving",
                quality = ContractQuality.VERY_SUBPAR,
            ),
            ContractSpecification(
                description = "A survivor offering very subpar pay a way off the port",
                quality = ContractQuality.VERY_SUBPAR,
            ),
            ContractSpecification(
                description = "A survivor offering very subpar pay for a taste, just a taste",
                quality = ContractQuality.VERY_SUBPAR,
            ),
            ContractSpecification(
                description = "The last survivor offering very subpar pay for carrying news of what happened to the rest of the universe",
                quality = ContractQuality.VERY_SUBPAR,
            ),
            ContractSpecification(
                description = "A scientist offering subpar pay for help with an unlikely cure",
                quality = ContractQuality.SUBPAR,
            ),
            ContractSpecification(
                description = "A scientist offering average pay or a sample",
                quality = ContractQuality.AVERAGE,
            ),
            ContractSpecification(
                description = "A military commander offering average pay for shooting quarantine breakers",
                quality = ContractQuality.AVERAGE,
            ),
            ContractSpecification(
                description = "An adventurer who unleashed this offering good pay for a way out",
                quality = ContractQuality.GOOD,
            ),
            generatedContract,
        ),
        minContracts = 1,
    )

    private val resort: PortOfCallSpecification = PortOfCallSpecification(
        name = "Resort",
        flavorText = FlavorText(
            text = "Hesperion! Come on down today*. *terms and conditions apply, minimum income 15 billion DiemBucks per period.",
            attribution = "Advertisement for Hesperion, currently under DiemCo control",
        ),
        description = "The rich, the powerful, criminals, mafiosos, synarchs, CEOs, they all need some place to spend that money. This is that place. A glistening, shining place, not made for the likes of you. You stand out here like a sore thumb. You belong to another life, with the rest of the poors, thank you very much.",
        choices = setOf(
            ChoiceSpecification(
                options = setOf(
                    Option("Natural beauty"),
                    Option("Healthcare, benefits"),
                    Option("The casino"),
                    Option("Sensual pleasures"),
                    Option("They like to live here"),
                    Option("Illegal purchases"),
                    Option("Bloodsport"),
                    Option("A zen-like calm"),
                ),
                questions = listOf(
                    Question(
                        question = "Choose what brings the rich to this place",
                        answers = 1,
                    ),
                ),
            ),
            ChoiceSpecification(
                options = setOf(
                    Option("A robot security force"),
                    Option("The poor can’t dock their spaceships"),
                    Option("Selective genescanners"),
                    Option("An all-watching, hostile z-machine"),
                    Option("A regular police force"),
                    Option("Mountains, radiation, natural barriers"),
                    Option("Orbital weapon platforms"),
                    Option("Viscious retaliation, carceral systems"),
                    Option("Walls, fences, stop and search, border patrols"),
                ),
                questions = listOf(
                    Question(
                        question = "Choose what keeps the poor out of this place",
                        answers = 1,
                    ),
                ),
            ),
        ),
        contracts = setOf(
            ContractSpecification(
                description = "An indentured offering very subpar pay to be smuggled out",
                quality = ContractQuality.VERY_SUBPAR,
            ),
            ContractSpecification(
                description = "A dock worker offering average pay to carry supplies from here to an even more exclusive place",
                quality = ContractQuality.AVERAGE,
            ),
            ContractSpecification(
                description = "A rich person offering average pay for something way too costly",
                quality = ContractQuality.AVERAGE,
            ),
            ContractSpecification(
                description = "A rich person offering average pay for shipping some indentured",
                quality = ContractQuality.AVERAGE,
            ),
            ContractSpecification(
                description = "A rich person offering average pay for the delivery of something for their collection that ought to be in a museum",
                quality = ContractQuality.AVERAGE,
            ),
            ContractSpecification(
                description = "A rich person offering good pay for transport to and from a secretive business meeting",
                quality = ContractQuality.GOOD,
            ),
            ContractSpecification(
                description = "A rich person offering excellent pay for a morally horrifying item",
                quality = ContractQuality.EXCELLENT,
            ),
            ContractSpecification(
                description = "A shady man offering excellent pay for quote “performing”",
                quality = ContractQuality.EXCELLENT,
            ),
            ContractSpecification(
                description = "Template",
                quality = ContractQuality.VERY_SUBPAR,
            ),
            generatedContract,
        ),
        minContracts = 2,
    )

    private val lonelyPlanet: PortOfCallSpecification = PortOfCallSpecification(
        name = "Lonely Planet",
        flavorText = FlavorText(
            text = "Rock. Bared, level, rock. I knew this place would be a challenge",
            attribution = "Gardener, a TTRPG available in all DiemCo trading polities",
        ),
        description = "For as much time as you spend on stations, moons, asteroids, on the float, touching down briefly only at surface spaceports, the universe is for all intents and purposes infinite. Civilization cannot touch all galaxies, reaches, let alone planets. This planet is here, spinning in the black. No one else is here. Perhaps they never were.",
        choices = setOf(
            ChoiceSpecification(
                options = setOf(
                    Option("A gas giant"),
                    Option("An arching ring system"),
                    Option("Three suns if not more"),
                    Option("Aurora"),
                    Option("Stars without number"),
                    Option("Nothing"),
                    Option("Something utterly, physically impossible"),
                    Option("Something crashing down on you slowly"),
                ),
                questions = listOf(
                    Question(
                        question = "Choose a sky",
                        answers = 1,
                    ),
                ),
            ),
            ChoiceSpecification(
                options = setOf(
                    Option("A riot of life"),
                    Option("Evidence of past terraforming and industry"),
                    Option("Barren rock"),
                    Option("Bones, graves out to the horizon"),
                    Option("Open ocean"),
                    Option("The volcanic sulfur of a newly formed world"),
                    Option("A mirror"),
                    Option("Endless psychic storms"),
                    Option("A swamp"),
                    Option("The ruins of a nuclear war or worse"),
                    Option("Glaciers"),
                    Option("Soaring mountains. Higher than that. Higher"),
                    Option("Desert"),
                ),
                questions = listOf(
                    Question(
                        question = "Choose what you see when you have landed and open the doors on this unpeopled world",
                        answers = 1,
                    ),
                ),
            ),
            ChoiceSpecification(
                options = setOf(
                    Option("Home"),
                    Option("Loneliness"),
                    Option("Fear"),
                    Option("Paranoia"),
                    Option("Peace"),
                    Option("Transcendance"),
                    Option("Paredolia"),
                    Option("Wonder"),
                    Option("Jealousy"),
                    Option("Simple happiness"),
                ),
                questions = listOf(
                    Question(
                        question = "Choose a feeling",
                        answers = 1,
                    ),
                ),
            ),
        ),
        contracts = setOf(
            wildernessContract,
        ),
        minContracts = 1,
    )

    private val anomaly: PortOfCallSpecification = PortOfCallSpecification(
        name = "Anomaly",
        flavorText = FlavorText(
            text = "You are loved. And we are loving you. You left us. But we will always forgive.",
            attribution = "Long lost Earth?",
        ),
        description = "Not so much a port as a place. Why did you come here? Black hole stars and warp gates. Neutron pulsars and machine-killing fields. And that is only the start of the weirdness possible in the wide, wide universe. Something truly unique and powerful, visible from megalightperiods away and well known and avoided for the very same reason. Why did you choose to come here of all places?",
        choices = setOf(
            ChoiceSpecification(
                options = setOf(
                    Option("Planets"),
                    Option("Stars"),
                    Option("Space"),
                    Option("Time"),
                    Option("Distance"),
                    Option("Thought"),
                    Option("Magic"),
                    Option("Life"),
                    Option("Tech"),
                    Option("Light"),
                    Option("Darkness"),
                    Option("Death"),
                    Option("Geometry"),
                    Option("Gravity"),
                    Option("Acceleration"),
                    Option("Evolution"),
                    Option("Mass"),
                    Option("Energy"),
                ),
                questions = listOf(
                    Question(
                        question = "Choose two being influenced here",
                        answers = 2,
                    ),
                ),
            ),
            ChoiceSpecification(
                options = setOf(
                    Option("Breaking them"),
                    Option("Reversing them"),
                    Option("Strengthening them"),
                    Option("Twisting them"),
                    Option("Switching their places"),
                    Option("Looping them"),
                    Option("Accelerating them"),
                    Option("Slowing them"),
                    Option("Weakening them"),
                    Option("Playing with them"),
                    Option("Devouring them"),
                ),
                questions = listOf(
                    Question(
                        question = "Choose what it is doing to those things",
                        answers = 1,
                    ),
                ),
            ),
            ChoiceSpecification(
                options = setOf(
                    Option("Gods"),
                    Option("Monsters"),
                    Option("Certain Death"),
                    Option("Deep Wild Dark"),
                    Option("Worse whispers"),
                    Option("Contradictory nonsense"),
                    Option("Nothing, just nothing"),
                ),
                questions = listOf(
                    Question(
                        question = "Choose a rumor you’ve heard about this place",
                        answers = 1,
                    ),
                ),
            ),
        ),
        contracts = setOf(
            wildernessContract,
        ),
        minContracts = 1,
    )

    private val meeting: PortOfCallSpecification = PortOfCallSpecification(
        name = "Meeting",
        flavorText = FlavorText(
            text = "You look at it. This fragile, interdependent thing, tiny against the black. And you lose yourself in it. You love it. Want to protect it. Want to make it home.",
            attribution = "Sri Marmolejo, ‘On Becoming a Freetraveler",
        ),
        description = "Freetravelers are a diaspora, rarely meeting together. But no one can stay like that always and occasionally, following odd, inconsistent protocols, you Freetravelers meet. Dozens of ships if not hundreds docking together in the big nothing. A change of favors, supplies, and crews. Many, many crews may begin their story here, having just changed ships and entered into an accord with each other.",
        choices = setOf(
            ChoiceSpecification(
                options = setOf(
                    Option("A scheduled meeting"),
                    Option("Bartering fuel, supplies, favors"),
                    Option("Gossip, family drama"),
                    Option("Welcoming newbies"),
                    Option("Crew changing ships"),
                    Option("Talking politics, shifts in power"),
                    Option("Crisis, prejudice, war"),
                ),
                questions = listOf(
                    Question(
                        question = "Choose what has brought you together",
                        answers = 1,
                    ),
                ),
            ),
            ChoiceSpecification(
                options = setOf(
                    Option("Familial few dozens"),
                    Option("Bustling hundred"),
                    Option("Shocking thousands"),
                ),
                questions = listOf(
                    Question(
                        question = "Choose how many Freetraveler ships have come here",
                        answers = 1,
                    ),
                ),
            ),
        ),
        contracts = setOf(),
        minContracts = 0,
    )

    val ports: WeightedSet<PortOfCallSpecification> = WeightedSet(
        companyPort to 5,
        freePort to 4,
        piratePort to 3,
        militaryPort to 3,
        authoritarianPort to 3,
        pharos to 3,
        researchBase to 3,
        darkMatterWell to 3,
        asteroidMine to 3,
        shipyard to 3,
        ambiguousUtopia to 2,
        exocolony to 2,
        uncontactedWorld to 2,
        derelict to 2,
        ruins to 2,
        dump to 2,
        hive to 2,
        extradimensionalPocket to 2,
        academy to 2,
        monastery to 2,
        quarantinedPort to 2,
        resort to 2,
        lonelyPlanet to 1,
        anomaly to 1,
        meeting to 1,
    )
}
