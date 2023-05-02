package com.stilllynnthecloset.liboun.model

import com.stilllynnthecloset.liboun.playbook.PlayerPlaybook

/**
 * PlayerState - TODO: Documentation
 *
 * Created by Lynn on 3/26/23
 */

public data class Player constructor(
    val dicePool: Int,
    val condition: HealthCondition,
    val playSheets: List<PlaySheet>,
) {
    val actions: List<Action> = (playSheets.flatMap { it.specification.actions } + PlayerPlaybook.standardActions).sortedByDescending { it.diceOffset }
}
