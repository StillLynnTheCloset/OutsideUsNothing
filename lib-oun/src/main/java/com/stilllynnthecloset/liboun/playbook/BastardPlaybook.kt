package com.stilllynnthecloset.liboun.playbook

import com.stilllynnthecloset.liboun.model.Bastard
import com.stilllynnthecloset.liboun.model.Weighted

/**
 * BastardPlaybook - TODO: Documentation
 *
 * Created by Lynn on 5/1/23
 */
internal object BastardPlaybook {
    val bastards: List<Weighted<Bastard>> = listOf(
        Weighted(
            weight = 1,
            value = Bastard(
                name = "DiemCo",
                description = "An old, and well-established corporation, extending from the Reachfall system out across space. Nothing escapes their predator ships and special operatives.",
            ),
        ),
        Weighted(
            weight = 1,
            value = Bastard(
                name = "TianCorp",
                description = "A brutal corp demanding absolute loyalty from all employees. It considers all people who live within any of the many systems it owns to be employees, be aware.",
            ),
        ),
        Weighted(
            weight = 1,
            value = Bastard(
                name = "SaintsCo",
                description = "An ancient, decrepit, and largely defunct corporation, but the last few assets that have not been swooped up by newer players in the game may still pose a threat.",
            ),
        ),
        Weighted(
            weight = 1,
            value = Bastard(
                name = "ApotheosInc",
                description = "One of the youngests corps, eager to expand across the black and write its name on the universe.",
            ),
        ),
        Weighted(
            weight = 1,
            value = Bastard(
                name = "The Psmanthic Choir",
                description = "For most the Choir is a fleet of silent black. No one has seen their pilots, if they even have them. But woe betide anyone who is captured by them, or hears them singing.",
            ),
        ),
        Weighted(
            weight = 1,
            value = Bastard(
                name = "The Angelic Kingdoms",
                description = "Several fiefdoms ruled largely by angelic sovereigns known for their xenophobia.",
            ),
        ),
        Weighted(
            weight = 1,
            value = Bastard(
                name = "The Fabula",
                description = "A dimension that originated devils. It is known to be alive and at least somewhat intelligent, but what its true aims are remain elusive.",
            ),
        ),
        Weighted(
            weight = 1,
            value = Bastard(
                name = "The Shroud Syndicate",
                description = "A union in theory, a crime family in law, and an independent polity in practice.",
            ),
        ),
        Weighted(
            weight = 1,
            value = Bastard(
                name = "The Irons Gang",
                description = "A petty gang of space pirates, hungry for Freetraveler tech.",
            ),
        ),
        Weighted(
            weight = 1,
            value = Bastard(
                name = "The Constabulary of Humanity",
                description = "A fascist, cloner cult of human traditionalists bent on finding and reclaiming the long lost terre home.",
            ),
        ),
        Weighted(
            weight = 1,
            value = Bastard(
                name = "Reclaim The Stars",
                description = "Alien tech. Origin unknown. Spreading machine. Reclamation. Devouring.",
            ),
        ),
        Weighted(
            weight = 1,
            value = Bastard(
                name = "SINNER SUN",
                description = "Won’t leave me alone? Then BURN",
            ),
        ),
        Weighted(
            weight = 1,
            value = Bastard(
                name = "[error]whispers",
                description = "What? Why am I on this list,  I’m your friend! This is a mistake!",
            ),
        ),
    )
}
