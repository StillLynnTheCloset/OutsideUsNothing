package com.stilllynnthecloset.outsideusnothing.map

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
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
import com.stilllynnthecloset.outsideusnothing.library.map.PortNode
import com.stilllynnthecloset.outsideusnothing.theme.ImageReference
import com.stilllynnthecloset.outsideusnothing.theme.textInputWidget
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.SupervisorJob
import kotlinx.coroutines.launch

/**
 * MapScreen - TODO: Documentation
 *
 * Created by Lynn on 4/14/23
 */
@Composable
internal fun MapScreen(dataModel: MapViewModel, platform: Platform) {
    Column(
        modifier = Modifier
            .fillMaxSize(),
    ) {
        Box(
            modifier = Modifier
                .fillMaxSize()
                .weight(1f),
        ) {
            hexGrid(
                modifier = Modifier
                    .fillMaxSize(),
                nodes = dataModel.nodeList,
                edges = dataModel.edgeList,
                nodeSize = 70f,
                nodeSpacing = 20f,
                offset = dataModel.offset,
                onOffsetChanged = dataModel::onOffsetChanged,
                scale = dataModel.zoomLevel,
                onScaleChanged = dataModel::onZoomLevelChanged,
                highlightedNodes = dataModel.highlightedNodes.map {
                    it.first to when (it.second) {
                        MapViewModel.NodeHighlight.SELECTED -> MaterialTheme.colorScheme.onPrimary
                        MapViewModel.NodeHighlight.SHIP_LOCATION -> MaterialTheme.colorScheme.error
                        MapViewModel.NodeHighlight.ON_PATH -> MaterialTheme.colorScheme.tertiary
                    }
                },
                onNodeSelected = dataModel::onNodeSelected,
            )

            Image(
                painter = platform.imagePainter.getPainter(ImageReference.Delete),
                colorFilter = ColorFilter.tint(MaterialTheme.colorScheme.onSurfaceVariant),
                contentDescription = "Close",
                modifier = Modifier
                    .align(Alignment.TopEnd)
                    .size(24.dp)
                    .clickable {
                        dataModel.clearMap()
                    },
            )

        }

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
                    Text("Selected Node: ${selectedNode.label.replace(Regex("\\s"), " ")}")

                    Spacer(
                        modifier = Modifier
                            .weight(1f),
                    )

                    Text(
                        text = "Travel Here for ${dataModel.currentPathCost}\nAverage events: ${dataModel.currentPathEventOdds}",
                        modifier = Modifier
                            .clickable {
                                dataModel.onShipLocationChanged(selectedNode)
                            }
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

                    Image(
                        painter = platform.imagePainter.getPainter(ImageReference.Delete),
                        colorFilter = ColorFilter.tint(MaterialTheme.colorScheme.onSurfaceVariant),
                        contentDescription = "Close",
                        modifier = Modifier
                            .align(Alignment.CenterVertically)
                            .size(24.dp)
                            .clickable {
                                dataModel.deleteNode(selectedNode)
                            },
                    )
                }
                if (selectedNode !is PortNode) {
                    Row {
                        textInputWidget(
                            value = dataModel.generatePortNameEntry.orEmpty(),
                            label = "Enter name of port",
                            modifier = Modifier,
                            onValueChange = dataModel::updatePortNameEntry,
                        )

                        Text(
                            text = "Generate a bunch more ports",
                            modifier = Modifier
                                .clickable {
                                    CoroutineScope(Dispatchers.IO + SupervisorJob()).launch {
                                        val startTime = System.nanoTime()
                                        dataModel.generateDegrees(selectedNode, 20)
                                        println("There are now ${dataModel.nodeList.size} nodes")
                                        val endTime = System.nanoTime()
                                        val duration = (endTime - startTime) / 1_000_000
                                        println("Took $duration ms")
                                    }
                                },
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
                    selectedNode.portOfCall.compose(platform)
                }
            }
        }
    }
}
