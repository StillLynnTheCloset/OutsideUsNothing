package com.stilllynnthecloset.liboun

/**
 * Tools - TODO: Documentation
 *
 * Created by Lynn on 3/31/23
 */
public fun <T> Set<T>.pickN(count: Int): Set<T> {
    val results = mutableSetOf<T>()
    repeat(count) {
        results.add(this.minus(results).random())
    }
    return results
}