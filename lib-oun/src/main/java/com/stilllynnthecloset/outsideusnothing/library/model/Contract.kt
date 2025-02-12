package com.stilllynnthecloset.outsideusnothing.library.model

import com.stilllynnthecloset.outsideusnothing.library.interfaces.UniversallyUnique
import kotlinx.serialization.Serializable
import java.util.UUID

/**
 * Contract - TODO: Documentation
 *
 * Created by Lynn on 3/26/23
 */
@Serializable
public data class Contract constructor(
    val contractSpecification: ContractSpecification,
    val fuelReward: Int,
    val suppliesReward: Int,
    val itemReward: Boolean,
    override val uuid: String = "contract_" + UUID.randomUUID().toString(),
) : UniversallyUnique
