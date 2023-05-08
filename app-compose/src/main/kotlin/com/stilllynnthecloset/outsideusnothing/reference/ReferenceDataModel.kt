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
internal class ReferenceDataModel constructor(val mainDataModel: MainDataModel) {
    var currentPage: PlaybookPage by mutableStateOf(PlaybookPage.PLAYBOOK)
        private set

    fun setPage(newPage: PlaybookPage) {
        currentPage = newPage
    }
}
