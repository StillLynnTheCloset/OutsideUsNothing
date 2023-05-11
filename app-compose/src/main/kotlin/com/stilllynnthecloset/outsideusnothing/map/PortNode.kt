package com.stilllynnthecloset.outsideusnothing.map

import androidx.compose.ui.text.AnnotatedString
import com.stilllynnthecloset.hexgridcompose.GridCoordinate
import com.stilllynnthecloset.hexgridcompose.Node
import com.stilllynnthecloset.liboun.model.PortOfCall
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable
import kotlinx.serialization.Transient

/**
 * PortNode - TODO: Documentation
 *
 * Created by Lynn on 5/11/23
 */
@Serializable
@SerialName("portNode")
public data class PortNode constructor(
    override val coordinate: GridCoordinate,
    val portOfCall: PortOfCall,
) : Node {
    @Transient
    override val label: AnnotatedString = AnnotatedString(portOfCall.name)
}
