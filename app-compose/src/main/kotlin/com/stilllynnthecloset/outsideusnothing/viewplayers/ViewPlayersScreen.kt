package com.stilllynnthecloset.outsideusnothing.viewplayers

import androidx.compose.foundation.gestures.Orientation
import androidx.compose.foundation.gestures.draggable
import androidx.compose.foundation.gestures.rememberDraggableState
import androidx.compose.foundation.gestures.scrollBy
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import com.stilllynnthecloset.outsideusnothing.Platform
import com.stilllynnthecloset.outsideusnothing.compose
import com.stilllynnthecloset.outsideusnothing.theme.dropDown
import com.stilllynnthecloset.outsideusnothing.theme.text
import kotlinx.coroutines.runBlocking

/**
 * ViewPlayersScreen - TODO: Documentation
 *
 * Created by Lynn on 2/12/25
 */
@Composable
internal fun ViewPlayersScreen(dataModel: ViewPlayersViewModel, platform: Platform) {
    val scrollState = rememberScrollState()
    Column(
        modifier = Modifier
            .fillMaxSize()
            .draggable(rememberDraggableState { delta ->
                runBlocking {
                    scrollState.scrollBy(-delta)
                }
            }, orientation = Orientation.Vertical)
            .verticalScroll(scrollState),
    ) {
        dropDown(
            items = dataModel.players,
            selected = dataModel.selectedPlayer,
            modifier = Modifier,
            platform = platform,
            onItemClick = dataModel::onPlayerChanged,
            composeItem = { item, childModifier ->
                text(
                    text = item.name,
                    modifier = childModifier,
                )
            }
        )

        dataModel.selectedPlayer.compose(platform)
    }
}
