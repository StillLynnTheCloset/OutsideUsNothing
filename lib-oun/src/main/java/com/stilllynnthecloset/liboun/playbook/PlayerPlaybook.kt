package com.stilllynnthecloset.liboun.playbook

import com.stilllynnthecloset.liboun.model.Action

/**
 * PlayerPlaybook - TODO: Documentation
 *
 * Created by Lynn on 5/1/23
 */
public object PlayerPlaybook {
    public val standardActions: List<Action> = listOf(
        Action(
            description = "Describe something around you. Describe how you feel about something another player described. Tell how something made you feel",
            diceOffset = 1,
        ),
        Action(
            description = "Inconvenience yourself for someone else or help them without reason",
            diceOffset = 1,
        ),
        Action(
            description = "Ask someone else to talk and listen to their opinion",
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
            description = "Attack, talk, repair, suggest, fly, solve, or do something else that isn’t on your playsheets for a cheaper cost",
            diceOffset = -4,
        ),
        Action(
            description = "Provided you have some way of practicing it, have the time, and have a teacher, learn a second role. Add that playsheet to your own",
            diceOffset = -10,
        ),
    )
}
