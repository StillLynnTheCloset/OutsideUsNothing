package com.stilllynnthecloset.outsideusnothing.library.map

import kotlinx.serialization.Serializable

/**
 * HexGridCoordinate - TODO: Documentation
 *
 * Created by Lynn on 5/30/23
 */
@Serializable
public data class HexGridCoordinate constructor(
    val row: Int,
    val col: Int,
)