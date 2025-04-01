package com.stilllynnthecloset.outsideusnothing.library.model

import com.stilllynnthecloset.outsideusnothing.library.interfaces.UniversallyUnique
import kotlinx.serialization.Serializable
import kotlin.uuid.ExperimentalUuidApi
import kotlin.uuid.Uuid

/**
 * ContractItem - TODO: Documentation
 *
 * Created by Lynn on 5/1/23
 */
@OptIn(ExperimentalUuidApi::class)
@Serializable
public data class ContractItem constructor(
    val name: String,
    override val uuid: String = "contractitem_" + Uuid.random().toString(),
) : UniversallyUnique
