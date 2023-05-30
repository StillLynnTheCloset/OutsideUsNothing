package com.stilllynnthecloset.outsideusnothing.library.playbook

import com.stilllynnthecloset.outsideusnothing.library.model.Action

/**
 * PlayerPlaybook - TODO: Documentation
 *
 * Created by Lynn on 5/1/23
 */
public object PlayerPlaybook {
    public val standardActions: List<Action> = listOf(
        Action(
            description = "Describe something you can see, touch, taste or feel around you.",
            diceOffset = 1,
        ),
        Action(
            description = "Describe how you feel about something another player described. Tell how something made you feel.",
            diceOffset = 1,
        ),
        Action(
            description = "Inconvenience yourself for someone else or help them without any other reason but helping",
            diceOffset = 1,
        ),
        Action(
            description = "Ask someone else to talk and listen to and consider their their opinion",
            diceOffset = 1,
        ),
        Action(
            description = "Say no, ask to talk about something else or move on, veto a decision",
            diceOffset = 0,
        ),
        Action(
            description = "Ask to make a decision as a crew or to talk it out",
            diceOffset = 0,
        ),
        Action(
            description = "Ask for more details or an explanation",
            diceOffset = 0,
        ),
        Action(
            description = "Attack, talk, repair, suggest, fly, solve, or do other general that isn’t on your playsheets for any cheaper dice cost",
            diceOffset = -4,
        ),
        Action(
            description = "Provided you have some way of practicing it, have the time, and have a teacher, learn a second ship role. Add that new playsheet ‘s actions to your own",
            diceOffset = -10,
        ),
    )
}
