package com.stilllynnthecloset.outsideusnothing.library.map

import com.stilllynnthecloset.outsideusnothing.library.model.PortOfCall
import kotlinx.serialization.Polymorphic
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable
import kotlinx.serialization.Transient

/**
 * HexGridNode - TODO: Documentation
 *
 * Created by Lynn on 5/30/23
 */

@Polymorphic
public interface HexGridNode {
    public val coordinate: HexGridCoordinate
    public val label: String
}

@Serializable
@SerialName("placeholder")
public data class PlaceholderNode constructor(
    override val coordinate: HexGridCoordinate,
) : HexGridNode {
    @Transient
    override val label: String = ""
}

@Serializable
@SerialName("portNode")
public data class PortNode constructor(
    override val coordinate: HexGridCoordinate,
    val portOfCall: PortOfCall,
) : HexGridNode {
    @Transient
    override val label: String = portOfCall.name
}
