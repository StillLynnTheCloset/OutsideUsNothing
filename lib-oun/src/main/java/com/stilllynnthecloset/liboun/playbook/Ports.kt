package com.stilllynnthecloset.liboun.playbook

import com.stilllynnthecloset.liboun.model.ContractQuality
import com.stilllynnthecloset.liboun.model.ContractSpecification
import com.stilllynnthecloset.liboun.model.PlaySheetChoiceSpecification
import com.stilllynnthecloset.liboun.model.PortOfCallSpecification

/**
 * Ports - TODO: Documentation
 *
 * Created by Lynn on 4/14/23
 */

public val companyPort: PortOfCallSpecification = PortOfCallSpecification(
    name = "The Company Port",
    description = "It’s the top of a space elevator, a station in the void, perhaps even (shockingly) on a planet itself. But wherever it is physically the construction is all the same. The brands the same. The shops the same. The floor utilitarian. The walls to clean. The people too quiet. The cops everywhere. Remember to pay your docking fee.",
    customizations = setOf(
        PlaySheetChoiceSpecification(
            question = "Two things you look for and can’t find here",
            options = setOf(
                "Color",
                "Music",
                "Crowds",
                "Bars or dancing",
                "Religion",
                "Anything old",
                "A place to stay",
                "A place to serve you",
                "Other freetravelers",
                "Gambling",
                "Families",
            ),
            numberOfPositiveSelections = 2,
            numberOfNegativeSelections = 0,
        )
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
        PlaySheetChoiceSpecification(
            question = "Who is keeping the lights on and the air breathable here",
            options = setOf(
                "A powerful, ancient z-machine left behind by the builders",
                "A worker’s collective",
                "Some might call it a gang",
                "One rich family don, no one asks where they get their money",
                "Dumb a-machines still spinning",
                "Retired Freetravelers",
                "No one knows",
                "Everyone chips in",
            ),
            numberOfPositiveSelections = 1,
            numberOfNegativeSelections = 0,
        )
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
        PlaySheetChoiceSpecification(
            question = "What was this place before the world moved on",
            options = setOf(
                "An asteroid mine",
                "A corporate port",
                "A dark matter well",
                "A space elevator",
                "An exocolony",
                "A monastery",
                "A huge spacecraft",
                "A military outpost",
            ),
            numberOfPositiveSelections = 1,
            numberOfNegativeSelections = 0,
        ),
        PlaySheetChoiceSpecification(
            question = "Two goods that pass through here",
            options = setOf(
                "Abandoned salvage",
                "Stolen tech",
                "Dangerous weapons",
                "Food and medicine meant for elsewhere",
                "Life-ruining drugs",
                "People",
                "Ships",
                "Forbidden magic",
            ),
            numberOfPositiveSelections = 2,
            numberOfNegativeSelections = 0,
        )
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
        PlaySheetChoiceSpecification(
            question = "Something about this place",
            options = setOf(
                "This place is actively under fire",
                "This place is supplying the front",
                "This place has not seen action in decaperiods",
                "This place is secret",
                "This place is occupying captured territory",
                "This place is a prison",
            ),
            numberOfPositiveSelections = 1,
            numberOfNegativeSelections = 0,
        ),
        PlaySheetChoiceSpecification(
            question = "What military holds this port",
            options = setOf(
                "Corporate security",
                "A fascist, expansionist cult",
                "Psmanthics",
                "Anti-company rebels",
                "An isolated force claimed to defend a species",
                "Synarch secret rulers",
                "An Angelic Kingdom",
                "Religious sects",
                "A single hivemind",
                "One of the devil factions",
            ),
            numberOfPositiveSelections = 1,
            numberOfNegativeSelections = 0,
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
        PlaySheetChoiceSpecification(
            question = "Whose fascist rule holds here",
            options = setOf(
                "The Constabulary of Man",
                "A queerphobic splinter group",
                "The Psmanthic Choir",
                "A post-revolutionary police state",
                "One of the Angelic Kingdoms",
                "This place is a prison",
            ),
            numberOfPositiveSelections = 1,
            numberOfNegativeSelections = 0,
        ),
        PlaySheetChoiceSpecification(
            question = "Two ways this port is policed and controlled",
            options = setOf(
                "Orbital defenses",
                "Omnipresent surveillance",
                "Police presence",
                "Drone swarms",
                "Magical limiters",
                "Mind control",
                "Regular purges",
                "Scapegoating aliens, others",
                "Hateful rallies",
                "Arresting Freetravelers and others strangers",
                "Liberal complacency",
                "Not-so-secret corporate sponsorship",
            ),
            numberOfPositiveSelections = 2,
            numberOfNegativeSelections = 0,
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
        PlaySheetChoiceSpecification(
            question = "What this signal portends",
            options = setOf(
                "Dark matter tears",
                "Ethermatter reefs",
                "Another port of call",
                "The way through the dark, a way home",
                "Orbital radiation belts",
                "Actual planetary ocean hazards and storms",
            ),
            numberOfPositiveSelections = 1,
            numberOfNegativeSelections = 0,
        ),
        PlaySheetChoiceSpecification(
            question = "Three things this lighthouse has",
            options = setOf(
                "A light pulsing through the dark",
                "A view from a great height",
                "A splash of waves, a taste of salt",
                "A circle of wheeling creatures",
                "A high and lonely isolation",
                "A torturous approach",
                "A haunted, eldritch air",
                "A quiet serenity",
                "A wind, etheric or atmospheric",
                "A team maintaining it",
                "A secretive, solitary guardian",
                "A shrine, hollows, bones",
                "A light, the sun, the sun, the sun",
            ),
            numberOfPositiveSelections = 3,
            numberOfNegativeSelections = 0,
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
        PlaySheetChoiceSpecification(
            question = "What is this place studying",
            options = setOf(
                "Astroneering events",
                "Deep history",
                "Psychokinetics",
                "Etheric magic science",
                "Organic biospherics",
                "Orbital oddities",
                "Big universal laws",
                "Bigger explosions",
            ),
            numberOfPositiveSelections = 1,
            numberOfNegativeSelections = 0,
        ),
        PlaySheetChoiceSpecification(
            question = "Who is running this place",
            options = setOf(
                "Earnest underfunded academics",
                "Stern military scientists",
                "Black ops spooks",
                "An autonomous z-machine god",
                "A national jingoistic agency",
                "Strangely, the mob",
                "Spooky, brainwashed mumblers",
                "Something outside the universe",
                "Single-minded megalomaniacs",
            ),
            numberOfPositiveSelections = 1,
            numberOfNegativeSelections = 0,
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
        PlaySheetChoiceSpecification(
            question = "Who operates this place polluting the etheric sea",
            options = setOf(
                "DiemCo, ApotheosInc, TianCo, or another company",
                "Ghosts",
                "A national or polity entity",
                "A military supplier",
                "Synarchs",
                "The Psmanthic Choir",
                "A worker’s collective",
            ),
            numberOfPositiveSelections = 1,
            numberOfNegativeSelections = 0,
        ),
        PlaySheetChoiceSpecification(
            question = "Two things inescapably wrong and damaged about this place",
            options = setOf(
                "Time skips, starts, flow backward",
                "Tech doesn’t work, or works oddly",
                "The shadows make weird patterns",
                "Anyone staying too long gets sick",
                "Workers talk about seeing things",
                "There’s a song with no source",
                "Dimensions contract, expand",
            ),
            numberOfPositiveSelections = 2,
            numberOfNegativeSelections = 0,
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







public val template: PortOfCallSpecification = PortOfCallSpecification(
    name = "Template",
    description = "Template",
    customizations = setOf(
        PlaySheetChoiceSpecification(
            question = "Template",
            options = setOf(
                "Template",
            ),
            numberOfPositiveSelections = 0,
            numberOfNegativeSelections = 0,
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
)


//public val listOfPorts: List<Pair<String, Int>> = listOf(
//    "Company Port" to 5,
//    "Freeport" to 4,
//    "Pirate Port" to 3,
//    "Military Port" to 3,
//    "Authoritarian Port" to 3,
//    "Pharos" to 3,
//    "Research Base" to 3,
//    "Dark Matter Well" to 3,
//    "Asteroid Mine" to 3,
//    "Shipyard" to 3,
//    "Ambiguous Utopia" to 2,
//    "Exocolony" to 2,
//    "Uncontacted World" to 2,
//    "Derelict" to 2,
//    "Ruins" to 2,
//    "Dump" to 2,
//    "Hive" to 2,
//    "Extradimensional Pocket" to 2,
//    "Academy" to 2,
//    "Monastery" to 2,
//    "Quarantined Port" to 2,
//    "Resort" to 2,
//    "Lonely Planet" to 1,
//    "Anomaly" to 1,
//    "Meeting" to 1,
//)
//
//
//
//public val weightedListOfPorts: List<String> = listOfPorts.generateWeightedList()
