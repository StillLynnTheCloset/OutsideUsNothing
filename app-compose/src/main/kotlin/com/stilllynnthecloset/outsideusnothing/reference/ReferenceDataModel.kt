package com.stilllynnthecloset.outsideusnothing.reference

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import com.stilllynnthecloset.liboun.model.Playbook

/**
 * PlaybookDataModel - TODO: Documentation
 *
 * Created by Lynn on 4/14/23
 */
internal class ReferenceDataModel constructor(val playbook: Playbook) {
    var currentPage: ReferencePage by mutableStateOf(ReferencePage.TABLE_OF_CONTENTS)
        private set

    fun setPage(newPage: ReferencePage) {
        currentPage = newPage
    }
}
