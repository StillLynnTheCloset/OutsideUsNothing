package com.stilllynnthecloset.outsideusnothing.map

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.size
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.ColorFilter
import androidx.compose.ui.unit.dp
import com.stilllynnthecloset.hexgridcompose.hexGrid
import com.stilllynnthecloset.outsideusnothing.Platform
import com.stilllynnthecloset.outsideusnothing.theme.ImageReference

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
                .fillMaxSize()
                .weight(1f),
            dataModel.nodeList,
            dataModel.edgeList,
            70f,
            20f,
            dataModel.offset,
            dataModel::onOffsetChanged,
            dataModel.zoomLevel,
            dataModel::onZoomLevelChanged,
            dataModel.selectedNode,
            dataModel::onNodeSelected,
        )

        val selectedNode = dataModel.selectedNode

        if (selectedNode != null) {
            println("Selected Node $selectedNode")
            Box(
                modifier = Modifier
                    .fillMaxWidth()
                    .height(200.dp)
                    .background(color = MaterialTheme.colorScheme.surfaceVariant),
            ) {
                Text("Selected Node $selectedNode")

                Image(
                    painter = platform.imagePainter.getPainter(ImageReference.Minus),
                    colorFilter = ColorFilter.tint(MaterialTheme.colorScheme.onSurfaceVariant),
                    contentDescription = "Close",
                    modifier = Modifier
                        .align(Alignment.TopEnd)
                        .size(24.dp)
                        .clickable {
                            dataModel.onNodeSelected(null)
                        },
                )
            }
        }
    }
}
