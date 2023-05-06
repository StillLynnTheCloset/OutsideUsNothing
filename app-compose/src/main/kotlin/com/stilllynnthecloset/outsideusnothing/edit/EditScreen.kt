package com.stilllynnthecloset.outsideusnothing.edit

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Checkbox
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.stilllynnthecloset.liboun.model.Playbook
import com.stilllynnthecloset.outsideusnothing.Platform
import com.stilllynnthecloset.outsideusnothing.compose
import com.stilllynnthecloset.outsideusnothing.theme.textInputWidget

/**
 * EditScreen - TODO: Documentation
 *
 * Created by Lynn on 5/5/23
 */
@Composable
internal fun EditScreen(dataModel: EditViewModel, platform: Platform) {
    val scrollState = rememberScrollState()
    Column(
        modifier = Modifier
            .verticalScroll(scrollState),
    ) {
        textInputWidget(
            value = dataModel.currentPlaybook.name,
            label = "Name",
            modifier = Modifier.padding(8.dp),
            onValueChange = dataModel::onNameChanged,
        )
        textInputWidget(
            value = dataModel.currentPlaybook.description,
            label = "Description",
            modifier = Modifier.padding(8.dp),
            onValueChange = dataModel::onDescriptionChanged,
        )
        textInputWidget(
            value = dataModel.currentPlaybook.authors.joinToString(",") { it.name },
            label = "Authors",
            modifier = Modifier.padding(8.dp),
            onValueChange = dataModel::onAuthorsChanged,
        )
    }
}
