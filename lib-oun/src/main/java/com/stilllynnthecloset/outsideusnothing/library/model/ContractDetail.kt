package com.stilllynnthecloset.outsideusnothing.library.model

import com.stilllynnthecloset.outsideusnothing.library.interfaces.UniversallyUnique
import kotlinx.serialization.Serializable
import java.util.UUID

/**
 * ContractDestination - TODO: Documentation
 *
 * Created by Lynn on 5/1/23
 */
@Serializable
public data class ContractDetail constructor(
    val item: ContractItem,
    val destination: ContractDestination,
    override val uuid: String = "contractdetail_" + UUID.randomUUID().toString(),
) : UniversallyUnique
