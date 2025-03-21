package com.stilllynnthecloset.outsideusnothing.library.tools

import com.stilllynnthecloset.outsideusnothing.library.interfaces.UniversallyUnique
import kotlinx.serialization.Serializable

/**
 * Weighted - TODO: Documentation
 *
 * Created by Lynn on 5/4/23
 */
@Serializable
public data class Weighted<T> constructor(
    val weight: Int,
    val value: T,
)

@Serializable //(with = WeightedSetSerializer::class)
public data class WeightedSet<T> constructor(
    private val set: Set<Weighted<T>>,
) : Set<Weighted<T>> by set {
    public constructor(vararg pairs: Pair<T, Int>) : this(pairs.map {
        Weighted(
            it.second,
            it.first
        )
    }.toSet())

    public constructor(vararg weighteds: Weighted<T>) : this(weighteds.toSet())

    public operator fun plus(other: WeightedSet<T>): WeightedSet<T> {
        return WeightedSet(this.set + other.set)
    }

    public operator fun plus(other: Weighted<T>): WeightedSet<T> {
        return WeightedSet(this.set + other)
    }

    public operator fun minus(other: Weighted<T>): WeightedSet<T> {
        return WeightedSet(this.set - other)
    }
}

public fun <T : UniversallyUnique> WeightedSet<T>.replace(item: Weighted<T>): WeightedSet<T> = WeightedSet(
    map {
        if (it.value.uuid == item.value.uuid) {
            item
        } else {
            it
        }
    }.toSet()
)

public fun <T : UniversallyUnique> Collection<T>.replace(item: T): Collection<T> = map {
    if (it.uuid == item.uuid) {
        item
    } else {
        it
    }
}

public fun <T> emptyWeightedSet(): WeightedSet<T> = WeightedSet(emptySet())
