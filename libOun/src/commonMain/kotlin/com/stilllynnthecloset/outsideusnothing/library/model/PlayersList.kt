package com.stilllynnthecloset.outsideusnothing.library.model

import com.stilllynnthecloset.outsideusnothing.library.tools.SerializerTools
import kotlinx.serialization.Serializable
import kotlinx.serialization.decodeFromString
import kotlinx.serialization.encodeToString

/**
 * PlayersList - TODO: Documentation
 *
 * Created by Lynn on 6/4/23
 */
@Serializable
public data class PlayersList constructor(
    val players: List<Player>,
) {
    public companion object {
        public fun fromJson(string: String): PlayersList = SerializerTools.serializer.decodeFromString(string)
    }
    public fun toJson(): String = SerializerTools.serializer.encodeToString(this)
}
