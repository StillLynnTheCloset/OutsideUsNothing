package com.stilllynnthecloset.outsideusnothing.map

import com.stilllynnthecloset.hexgridcompose.Edge
import com.stilllynnthecloset.hexgridcompose.Node
import com.stilllynnthecloset.liboun.model.PortOfCall
import kotlinx.serialization.Serializable

/**
 * Map - TODO: Documentation
 *
 * Created by Lynn on 5/9/23
 */
@Serializable
public data class Map constructor(
    val nodes: List<Node>,
    val edges: List<Edge>,
)
