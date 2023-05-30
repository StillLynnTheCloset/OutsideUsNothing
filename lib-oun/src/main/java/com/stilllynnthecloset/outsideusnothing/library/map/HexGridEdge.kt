package com.stilllynnthecloset.outsideusnothing.library.map

import kotlinx.serialization.Serializable

/**
 * Edge - TODO: Documentation
 *
 * Created by Lynn on 5/30/23
 */
@Serializable
public data class HexGridEdge constructor(
    val node1: HexGridCoordinate,
    val node2: HexGridCoordinate,
    val cost: Int?,
)
