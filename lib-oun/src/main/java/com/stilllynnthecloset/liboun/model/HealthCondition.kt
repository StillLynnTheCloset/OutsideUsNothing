package com.stilllynnthecloset.liboun.model

import kotlinx.serialization.Serializable

/**
 * HealthCondition - TODO: Documentation
 *
 * Created by Lynn on 3/26/23
 */
@Serializable
public enum class HealthCondition {
    HEALTHY,
    IMPAIRED,
    STRICKEN,
    INCAPACITATED,
}
