package com.stilllynnthecloset.outsideusnothing.library.model

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
