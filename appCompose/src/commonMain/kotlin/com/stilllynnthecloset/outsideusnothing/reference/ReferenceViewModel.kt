package com.stilllynnthecloset.outsideusnothing.reference

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import com.stilllynnthecloset.outsideusnothing.MainDataModel
import com.stilllynnthecloset.outsideusnothing.PlaybookPage

/**
 * PlaybookDataModel - TODO: Documentation
 *
 * Created by Lynn on 4/14/23
 */
internal class ReferenceViewModel constructor(
    val mainDataModel: MainDataModel,
    val currentPage: PlaybookPage = PlaybookPage.PLAYBOOK,
    val subpage: Any? = null,
)
