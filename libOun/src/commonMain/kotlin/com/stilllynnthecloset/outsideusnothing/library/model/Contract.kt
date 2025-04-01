package com.stilllynnthecloset.outsideusnothing.library.model

import com.stilllynnthecloset.outsideusnothing.library.interfaces.UniversallyUnique
import kotlinx.serialization.Serializable
import kotlin.uuid.ExperimentalUuidApi
import kotlin.uuid.Uuid

/**
 * Contract - TODO: Documentation
 *
 * Created by Lynn on 3/26/23
 */
@OptIn(ExperimentalUuidApi::class)
@Serializable
public data class Contract constructor(
    val contractSpecification: ContractSpecification,
    val fuelReward: Int,
    val suppliesReward: Int,
    val itemReward: Boolean,
    override val uuid: String = "contract_" + Uuid.random().toString(),
) : UniversallyUnique
