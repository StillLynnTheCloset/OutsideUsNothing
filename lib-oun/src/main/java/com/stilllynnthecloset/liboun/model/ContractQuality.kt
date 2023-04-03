package com.stilllynnthecloset.liboun.model

/**
 * ContractQuality - TODO: Documentation
 *
 * Created by Lynn on 3/26/23
 */
public enum class ContractQuality constructor(public val fuelDice: Int, public val suppliesDice: Int, public val itemDifficultly: Int) {
    VERY_SUBPAR(1, 2, 6),
    SUBPAR(1, 2, 6),
    AVERAGE(1, 3, 6),
    GOOD(2, 3, 5),
    EXCELLENT(2, 4, 4),
}
