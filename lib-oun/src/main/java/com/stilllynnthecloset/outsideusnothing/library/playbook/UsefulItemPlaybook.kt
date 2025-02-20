package com.stilllynnthecloset.outsideusnothing.library.playbook

import com.stilllynnthecloset.outsideusnothing.library.model.Action
import com.stilllynnthecloset.outsideusnothing.library.model.UsefulItem
import com.stilllynnthecloset.outsideusnothing.library.tools.Weighted
import com.stilllynnthecloset.outsideusnothing.library.tools.WeightedSet

/**
 * UsefulItemPlaybook - TODO: Documentation
 *
 * Created by Lynn on 5/1/23
 */
internal object UsefulItemPlaybook {
    val items: WeightedSet<UsefulItem> = WeightedSet(
        Weighted(
            weight = 1,
            value = UsefulItem(
                name = "The Book of Possible Futures",
                action = Action(
                    description = "Be paralyzed by overwhelming choices",
                    diceOffset = +3,
                ),
            ),
        ),
        Weighted(
            weight = 1,
            value = UsefulItem(
                name = "Altar of a Forgotten God",
                action = Action(
                    description = "Lose a memory, mourn for whatever it was",
                    diceOffset = +2,
                ),
            ),
        ),
        Weighted(
            weight = 1,
            value = UsefulItem(
                name = "Future Shrine",
                action = Action(
                    description = "Tell a story about what this place will be one day",
                    diceOffset = +1,
                ),
            ),
        ),
        Weighted(
            weight = 1,
            value = UsefulItem(
                name = "Shadowbox",
                action = Action(
                    description = "Look inside this and face your deep, dark fears",
                    diceOffset = +1,
                ),
            ),
        ),
        Weighted(
            weight = 1,
            value = UsefulItem(
                name = "Gram",
                action = Action(
                    description = "Be cursed by the gods most likely, defy them",
                    diceOffset = +1,
                ),
            ),
        ),
        Weighted(
            weight = 1,
            value = UsefulItem(
                name = "Brightmark",
                action = Action(
                    description = "Look at a sun ‘til you see animals writhing in it",
                    diceOffset = +1,
                ),
            ),
        ),
        Weighted(
            weight = 1,
            value = UsefulItem(
                name = "Truth bomb",
                action = Action(
                    description = "Force someone near you to face their own personal truth",
                    diceOffset = -1,
                ),
            ),
        ),
        Weighted(
            weight = 1,
            value = UsefulItem(
                name = "Slow zone staff",
                action = Action(
                    description = "Force all missiles and ships to slow slightly and briefly",
                    diceOffset = -1,
                ),
            ),
        ),
        Weighted(
            weight = 1,
            value = UsefulItem(
                name = "Bound fabula portal",
                action = Action(
                    description = "Open a door for the fabula, don’t dare lose control",
                    diceOffset = -1,
                ),
            ),
        ),
        Weighted(
            weight = 1,
            value = UsefulItem(
                name = "Angelic wing grafting",
                action = Action(
                    description = "Graft one constructed angelic body part to you",
                    diceOffset = -1,
                ),
            ),
        ),
        Weighted(
            weight = 1,
            value = UsefulItem(
                name = "Unknown Psmanthic thing",
                action = Action(
                    description = "Invade a mind, change one small opinion",
                    diceOffset = -1,
                ),
            ),
        ),
        Weighted(
            weight = 1,
            value = UsefulItem(
                name = "Corporate witch protection sigil",
                action = Action(
                    description = "Delay one attack on your ship",
                    diceOffset = -1,
                ),
            ),
        ),
        Weighted(
            weight = 1,
            value = UsefulItem(
                name = "Gravion wave emitter gun",
                action = Action(
                    description = "Shoot someone with the terror",
                    diceOffset = -1,
                ),
            ),
        ),
        Weighted(
            weight = 1,
            value = UsefulItem(
                name = "Wormhole enucleator",
                action = Action(
                    description = "Line of sight portal creation",
                    diceOffset = -1,
                ),
            ),
        ),
        Weighted(
            weight = 1,
            value = UsefulItem(
                name = "Orichalcum sai",
                action = Action(
                    description = "Drain someone’s magic",
                    diceOffset = -1,
                ),
            ),
        ),
        Weighted(
            weight = 1,
            value = UsefulItem(
                name = "Neutronium shield",
                action = Action(
                    description = "Bend bullets",
                    diceOffset = -1,
                ),
            ),
        ),
        Weighted(
            weight = 1,
            value = UsefulItem(
                name = "Stellar flail",
                action = Action(
                    description = "Light up an attack",
                    diceOffset = -1,
                ),
            ),
        ),
        Weighted(
            weight = 1,
            value = UsefulItem(
                name = "Traverse",
                action = Action(
                    description = "Slash, slice with this sword",
                    diceOffset = -1,
                ),
            ),
        ),
        Weighted(
            weight = 1,
            value = UsefulItem(
                name = "Odd sextant",
                action = Action(
                    description = "Point toward something intriguing",
                    diceOffset = -1,
                ),
            ),
        ),
        Weighted(
            weight = 1,
            value = UsefulItem(
                name = "Odder compass",
                action = Action(
                    description = "Point toward something valuable",
                    diceOffset = -2,
                ),
            ),
        ),
        Weighted(
            weight = 1,
            value = UsefulItem(
                name = "Pocket collapsar",
                action = Action(
                    description = "Open a momentary micro black hole",
                    diceOffset = -2,
                ),
            ),
        ),
        Weighted(
            weight = 1,
            value = UsefulItem(
                name = "Icon of the Sinner",
                action = Action(
                    description = "Pray to a dark matter deity for faint mercy",
                    diceOffset = -2,
                ),
            ),
        ),
        Weighted(
            weight = 1,
            value = UsefulItem(
                name = "Hydra Mindscaper",
                action = Action(
                    description = "Unleash a hydra to scrape through your mind",
                    diceOffset = -2,
                ),
            ),
        ),
        Weighted(
            weight = 1,
            value = UsefulItem(
                name = "Devouring Rat King",
                action = Action(
                    description = "Let go the rat king to spread and feed and eat",
                    diceOffset = -2,
                ),
            ),
        ),
        Weighted(
            weight = 1,
            value = UsefulItem(
                name = "[error]<%>whispers<%>",
                action = Action(
                    description = "Hush now. Let me help. I always can help",
                    diceOffset = -3,
                ),
            ),
        ),
        Weighted(
            weight = 1,
            value = UsefulItem(
                name = "Anteuniversalian Survivor",
                action = Action(
                    description = "Talk to the survivor for odd but useful advice",
                    diceOffset = -3,
                ),
            ),
        ),
        Weighted(
            weight = 1,
            value = UsefulItem(
                name = "A single fragment of Earth",
                action = Action(
                    description = "The post singularity world bridges spacetime",
                    diceOffset = -3,
                ),
            ),
        ),
        Weighted(
            weight = 1,
            value = UsefulItem(
                name = "Psmanthic choir song projector",
                action = Action(
                    description = "Warp and augment yourself into the new",
                    diceOffset = -4,
                ),
            ),
        ),
        Weighted(
            weight = 1,
            value = UsefulItem(
                name = "Exegesis On Simulation Theory",
                action = Action(
                    description = "Convince the universe it is fictional",
                    diceOffset = -5,
                ),
            ),
        ),
        Weighted(
            weight = 1,
            value = UsefulItem(
                name = "False vacuum collapse bomb",
                action = Action(
                    description = "Doom everything",
                    diceOffset = -7,
                ),
            ),
        ),
    )
}
