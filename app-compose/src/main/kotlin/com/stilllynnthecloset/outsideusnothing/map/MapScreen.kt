package com.stilllynnthecloset.outsideusnothing.map

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Button
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.ColorFilter
import androidx.compose.ui.unit.dp
import com.stilllynnthecloset.hexgridcompose.hexGrid
import com.stilllynnthecloset.outsideusnothing.Platform
import com.stilllynnthecloset.outsideusnothing.compose
import com.stilllynnthecloset.outsideusnothing.theme.ImageReference
import com.stilllynnthecloset.outsideusnothing.theme.textInputWidget

/**
 * MapScreen - TODO: Documentation
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
            nodes = dataModel.nodeList,
            edges = dataModel.edgeList,
            nodeSize = 70f,
            nodeSpacing = 20f,
            offset = dataModel.offset,
            onOffsetChanged = dataModel::onOffsetChanged,
            scale = dataModel.zoomLevel,
            onScaleChanged = dataModel::onZoomLevelChanged,
            selectedNode = dataModel.selectedNode,
            onNodeSelected = dataModel::onNodeSelected,
        )

        val selectedNode = dataModel.selectedNode

        if (selectedNode != null) {
            val scrollState = rememberScrollState()
            Column(
                modifier = Modifier
                    .fillMaxWidth()
                    .height(200.dp)
                    .verticalScroll(scrollState)
                    .background(color = MaterialTheme.colorScheme.surfaceVariant),
            ) {
                Row(
                    Modifier
                        .fillMaxWidth(),
                ) {
                    Text("Selected Node: ${selectedNode.label}")

                    Spacer(
                        modifier = Modifier
                            .weight(1f),
                    )

                    Image(
                        painter = platform.imagePainter.getPainter(ImageReference.Remove),
                        colorFilter = ColorFilter.tint(MaterialTheme.colorScheme.onSurfaceVariant),
                        contentDescription = "Close",
                        modifier = Modifier
                            .align(Alignment.CenterVertically)
                            .size(24.dp)
                            .clickable {
                                dataModel.onNodeSelected(null)
                            },
                    )
                }
                if (selectedNode.value == null) {
                    Row {
                        textInputWidget(
                            value = dataModel.generatePortNameEntry.orEmpty(),
                            label = "Enter name of port",
                            modifier = Modifier,
                            onValueChange = dataModel::updatePortNameEntry,
                        )

                        Image(
                            painter = platform.imagePainter.getPainter(ImageReference.Dice5),
                            colorFilter = ColorFilter.tint(MaterialTheme.colorScheme.onSurfaceVariant),
                            contentDescription = "Random Name",
                            modifier = Modifier
                                .align(Alignment.CenterVertically)
                                .size(24.dp)
                                .clickable {
                                    dataModel.pickRandomPortName()
                                },
                        )
                    }

                    Button(
                        onClick = {
                            dataModel.generatePort(selectedNode)
                        },
                    ) {
                        Text(
                            text = "Generate Port",
                        )
                    }
                } else {
                    selectedNode.value?.let {
                        it.compose(platform)
                    }
                }
            }
        }
    }
}
