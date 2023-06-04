package com.stilllynnthecloset.outsideusnothing.desktop

import com.stilllynnthecloset.outsideusnothing.library.SerializerTools
import com.stilllynnthecloset.outsideusnothing.library.model.Player
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
