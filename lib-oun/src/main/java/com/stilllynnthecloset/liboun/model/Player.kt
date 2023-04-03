package com.stilllynnthecloset.liboun.model

/**
 * PlayerState - TODO: Documentation
 *
 * Created by Lynn on 3/26/23
 */

public data class Player constructor(
    val dicePool: Int,
    val condition: HealthCondition,
    val playSheets: List<PlaySheet>,
)
