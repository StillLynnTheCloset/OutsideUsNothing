package com.stilllynnthecloset.outsideusnothing.library.map

import kotlinx.serialization.Serializable

/**
 * HexGridMap - TODO: Documentation
 *
 * Created by Lynn on 5/30/23
 */
@Serializable
public data class HexGridMap constructor(
    val nodes: List<HexGridNode>,
    val edges: List<HexGridEdge>,
)
