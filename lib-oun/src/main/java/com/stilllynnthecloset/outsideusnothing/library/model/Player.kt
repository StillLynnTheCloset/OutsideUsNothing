package com.stilllynnthecloset.outsideusnothing.library.model

import com.stilllynnthecloset.outsideusnothing.library.SerializerTools
import com.stilllynnthecloset.outsideusnothing.library.playbook.PlayerPlaybook
import kotlinx.serialization.Serializable
import kotlinx.serialization.decodeFromString
import kotlinx.serialization.encodeToString

/**
 * Player - TODO: Documentation
 *
 * Created by Lynn on 3/26/23
 */
@Serializable
public data class Player constructor(
    val name: String,
    val dicePool: Int,
    val condition: HealthCondition,
    val playSheets: Collection<PlaySheet>,
    val items: Collection<UsefulItem>,
) {
    public companion object {
        public fun fromJson(string: String): Player = SerializerTools.serializer.decodeFromString(string)
    }
    public fun toJson(): String = SerializerTools.serializer.encodeToString(this)
    val actions: Collection<Action> = (playSheets.flatMap { it.specification.actions } + PlayerPlaybook.standardActions).sortedByDescending { it.diceOffset }
}
