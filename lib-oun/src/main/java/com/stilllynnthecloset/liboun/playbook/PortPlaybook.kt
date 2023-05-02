package com.stilllynnthecloset.liboun.playbook

import com.stilllynnthecloset.liboun.model.ChoiceSpecification
import com.stilllynnthecloset.liboun.model.ContractQuality
import com.stilllynnthecloset.liboun.model.ContractSpecification
import com.stilllynnthecloset.liboun.model.Option
import com.stilllynnthecloset.liboun.model.PortOfCallSpecification
import com.stilllynnthecloset.liboun.model.Question

/**
 * PortPlaybook - TODO: Documentation
 *
 * Created by Lynn on 4/14/23
 */

public object PortPlaybook {
    public val companyPort: PortOfCallSpecification = PortOfCallSpecification(
        name = "The Company Port",
        description = "It’s the top of a space elevator, a station in the void, perhaps even (shockingly) on a planet itself. But wherever it is physically the construction is all the same. The brands the same. The shops the same. The floor utilitarian. The walls to clean. The people too quiet. The cops everywhere. Remember to pay your docking fee.",
        customizations = setOf(
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
        ),
        minContracts = 3,
    )
    public val freePort: PortOfCallSpecification = PortOfCallSpecification(
        name = "The Free Port",
        description = "Some might consider it a smuggler hideout. To others an anti-corporate, post revolution haven. Or maybe it’s wherever was convenient. But, spinning around some frontier world, or mined into an asteroid, or simple a few dozen old ships lashed together, one thing will always be true. No taxes. Perfect for Freetravelers.",
        customizations = setOf(
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
        ),
        minContracts = 3,
    )

    public val piratePort: PortOfCallSpecification = PortOfCallSpecification(
        name = "The Pirate Port",
        description = "The air smells wrong when the doors open. The lights flicker. No one has repaired the docking clamps. This place is the real Libertalia, and like all pirate havens across all history it won’t last. It doesn’t have to. It just needs to hold together for some dishonest wealth to be spent, unloaded, and traded back into the economy.",
        customizations = setOf(
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
        ),
        minContracts = 2,
    )

    public val militaryPort: PortOfCallSpecification = PortOfCallSpecification(
        name = "The Military Port",
        description = "This is a port, yes, with docks and repairs and all the other expected things. But it’s quiet. Buttoned up. Not for you. Because this is here to repair and resupply a military fleet, to hold systems and worlds. You are not military, Freetraveler. Do your business and move on quickly.",
        customizations = setOf(
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
        ),
        minContracts = 1,
    )

    public val authoritarianPort: PortOfCallSpecification = PortOfCallSpecification(
        name = "The Authoritarian Port",
        description = "Safe behind military lines and military ports comes a place far away from military ports. Clean. Quiet. Orderly. You are not welcome here far from corporate degeneracy. Dissident elements and division have no place within the rules that have been imposed here. Freetraveler, anarchist, syndicalist, scofflaw. Move on.",
        customizations = setOf(
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
        ),
        minContracts = 1,
    )

    public val pharos: PortOfCallSpecification = PortOfCallSpecification(
        name = "The Pharos",
        description = "A lonely warning with a sacred meaning. Danger, the signal it sends says. Stay away. Or, alternately, this is how you safely transit. This is how you sail this straight, enter this port, keep flying. For most that is all this place is, a little reminder in the dark. Now you have arrived, after careful approach, to do business.",
        customizations = setOf(
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
        ),
        minContracts = 1,
    )

    public val researchBase: PortOfCallSpecification = PortOfCallSpecification(
        name = "The Research Base",
        description = "Labs. Hothouses. Black ops exotemporal psych projects. The universe is full of places like this for the same reason it is full of the unexplained and the unknown. Magic, conventional, spatial, universal, what have you, where there is something unknown there will be people, power, and money interested in making it known.",
        customizations = setOf(
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
        ),
        minContracts = 2,
    )

    public val darkMatterWell: PortOfCallSpecification = PortOfCallSpecification(
        name = "The Dark Matter Well",
        description = "Most people don’t like to recognize how much of modern tech relies on the extraction of dark matter from the etheric sea. But someone has to do it, right? Punch a hole in the skin of the universe into a rich tract. Haul the black gold out. Try to ignore the damage and aura of spookiness for lightperiods all around it.",
        customizations = setOf(
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
        ),
        minContracts = 1,
    )

    public val asteroidMine: PortOfCallSpecification = PortOfCallSpecification(
        name = "Asteroid Mine",
        description = "TODO",
        customizations = setOf(),
        contracts = setOf(),
        minContracts = 0,
    )

    public val shipyard: PortOfCallSpecification = PortOfCallSpecification(
        name = "Shipyard",
        description = "TODO",
        customizations = setOf(),
        contracts = setOf(),
        minContracts = 0,
    )

    public val ambiguousUtopia: PortOfCallSpecification = PortOfCallSpecification(
        name = "Ambiguous Utopia",
        description = "TODO",
        customizations = setOf(),
        contracts = setOf(),
        minContracts = 0,
    )

    public val exocolony: PortOfCallSpecification = PortOfCallSpecification(
        name = "Exocolony",
        description = "TODO",
        customizations = setOf(),
        contracts = setOf(),
        minContracts = 0,
    )

    public val uncontactedWorld: PortOfCallSpecification = PortOfCallSpecification(
        name = "Uncontacted World",
        description = "TODO",
        customizations = setOf(),
        contracts = setOf(),
        minContracts = 0,
    )

    public val derelict: PortOfCallSpecification = PortOfCallSpecification(
        name = "Derelict",
        description = "TODO",
        customizations = setOf(),
        contracts = setOf(),
        minContracts = 0,
    )

    public val ruins: PortOfCallSpecification = PortOfCallSpecification(
        name = "Ruins",
        description = "TODO",
        customizations = setOf(),
        contracts = setOf(),
        minContracts = 0,
    )

    public val dump: PortOfCallSpecification = PortOfCallSpecification(
        name = "Dump",
        description = "TODO",
        customizations = setOf(),
        contracts = setOf(),
        minContracts = 0,
    )

    public val hive: PortOfCallSpecification = PortOfCallSpecification(
        name = "Hive",
        description = "TODO",
        customizations = setOf(),
        contracts = setOf(),
        minContracts = 0,
    )

    public val extradimensionalPocket: PortOfCallSpecification = PortOfCallSpecification(
        name = "Extradimensional Pocket",
        description = "TODO",
        customizations = setOf(),
        contracts = setOf(),
        minContracts = 0,
    )

    public val academy: PortOfCallSpecification = PortOfCallSpecification(
        name = "Academy",
        description = "TODO",
        customizations = setOf(),
        contracts = setOf(),
        minContracts = 0,
    )

    public val monastery: PortOfCallSpecification = PortOfCallSpecification(
        name = "Monastery",
        description = "TODO",
        customizations = setOf(),
        contracts = setOf(),
        minContracts = 0,
    )

    public val quarantinedPort: PortOfCallSpecification = PortOfCallSpecification(
        name = "Quarantined Port",
        description = "TODO",
        customizations = setOf(),
        contracts = setOf(),
        minContracts = 0,
    )

    public val resort: PortOfCallSpecification = PortOfCallSpecification(
        name = "Resort",
        description = "TODO",
        customizations = setOf(),
        contracts = setOf(),
        minContracts = 0,
    )

    public val lonelyPlanet: PortOfCallSpecification = PortOfCallSpecification(
        name = "Lonely Planet",
        description = "TODO",
        customizations = setOf(),
        contracts = setOf(),
        minContracts = 0,
    )

    public val anomaly: PortOfCallSpecification = PortOfCallSpecification(
        name = "Anomaly",
        description = "TODO",
        customizations = setOf(),
        contracts = setOf(),
        minContracts = 0,
    )

    public val meeting: PortOfCallSpecification = PortOfCallSpecification(
        name = "Meeting",
        description = "TODO",
        customizations = setOf(),
        contracts = setOf(),
        minContracts = 0,
    )

    public val template: PortOfCallSpecification = PortOfCallSpecification(
        name = "Template",
        description = "Template",
        customizations = setOf(
            ChoiceSpecification(
                options = setOf(
                    Option("Template"),
                ),
                questions = listOf(
                    Question(
                        question = "Template",
                        answers = 1,
                    ),
                ),
            ),
        ),
        contracts = setOf(
            ContractSpecification(
                description = "Template",
                quality = ContractQuality.VERY_SUBPAR,
            ),
        ),
        minContracts = 0,
    )

    public val portWeightings: Map<PortOfCallSpecification, Int> = mapOf(
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
