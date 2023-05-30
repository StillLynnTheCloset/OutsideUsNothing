package com.stilllynnthecloset.outsideusnothing.library.map

import com.stilllynnthecloset.outsideusnothing.library.SerializerTools
import kotlinx.serialization.Serializable
import kotlinx.serialization.decodeFromString
import kotlinx.serialization.encodeToString

/**
 * HexGridMap - TODO: Documentation
 *
 * Created by Lynn on 5/30/23
 */
@Serializable
public data class HexGridMap constructor(
    val nodes: List<HexGridNode>,
    val edges: List<HexGridEdge>,
) {
    public companion object {
        public fun fromJson(string: String): HexGridMap = SerializerTools.serializer.decodeFromString(string)
    }
    public fun toJson(): String = SerializerTools.serializer.encodeToString(this)
}
