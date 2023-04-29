package com.stilllynnthecloset.outsideusnothing.map

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import com.stilllynnthecloset.hexgridcompose.hexGrid
import com.stilllynnthecloset.outsideusnothing.Platform

/**
 * OrganizerScreen - TODO: Documentation
 *
 * Created by Lynn on 4/14/23
 */

@Composable
internal fun MapScreen(dataModel: MapDataModel, platform: Platform) {
    Column(
        modifier = Modifier
            .fillMaxSize(),
    ) {
        hexGrid(
            modifier = Modifier
                .fillMaxSize(),
            dataModel.nodeList,
            dataModel.edgeList,
            70f,
            20f,
            dataModel.offset,
            dataModel::onOffsetChanged,
            dataModel.zoomLevel,
            dataModel::onZoomLevelChanged,
        )
    }
}
