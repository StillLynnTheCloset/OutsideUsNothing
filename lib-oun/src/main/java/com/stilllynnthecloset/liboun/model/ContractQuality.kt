package com.stilllynnthecloset.liboun.model

import kotlinx.serialization.Serializable

/**
 * ContractQuality - TODO: Documentation
 *
 * Created by Lynn on 3/26/23
 */
@Serializable
public enum class ContractQuality constructor(public val fuelDice: Int, public val suppliesDice: Int, public val itemDifficultly: Int, public val humanReadable: String) {
    VERY_SUBPAR(1, 2, 6, "very subpar"),
    SUBPAR(1, 2, 6, "subpar"),
    AVERAGE(1, 3, 6, "average"),
    GOOD(2, 3, 5, "good"),
    EXCELLENT(2, 4, 4, "excellent"),
    ;

    override fun toString(): String {
        return humanReadable
    }
}
