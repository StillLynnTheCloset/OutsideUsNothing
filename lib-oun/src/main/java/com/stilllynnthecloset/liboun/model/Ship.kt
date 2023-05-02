package com.stilllynnthecloset.liboun.model

/**
 * Ship - TODO: Documentation
 *
 * Created by Lynn on 3/26/23
 */
public data class Ship constructor(
    val name: String,
    val fuel: Int = 4,
    val supplies: Int = 8,
    val condition: HealthCondition = HealthCondition.HEALTHY,
    val playSheet: PlaySheet,
)
