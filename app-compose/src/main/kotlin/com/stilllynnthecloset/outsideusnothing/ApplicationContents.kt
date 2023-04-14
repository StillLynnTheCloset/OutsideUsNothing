package com.stilllynnthecloset.outsideusnothing

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.runtime.Composable
import androidx.compose.ui.ExperimentalComposeUiApi
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.DpSize
import com.stilllynnthecloset.outsideusnothing.dice.DiceRollerScreen
import com.stilllynnthecloset.outsideusnothing.theme.ImageReference
import com.stilllynnthecloset.outsideusnothing.theme.NavigationTab
import com.stilllynnthecloset.outsideusnothing.theme.navigationContainer

@Composable
@ExperimentalComposeUiApi
public fun applicationContents(windowSize: DpSize, dataModel: MainDataModel, windowDataModel: WindowDataModel, platform: Platform) {
    navigationContainer(
        windowSize = windowSize,
        currentTab = NavigationTabImpl.values()
            .find { it.description == windowDataModel.currentScreen.description },
        tabs = NavigationTabImpl.values().toList(),
        isThereBackButton = windowDataModel.isThereBackstack(),
        onNavigationClick = { windowDataModel.updateCurrentTab(it) },
        onBackClick = { windowDataModel.popBackStack() },
        platform = platform,
    ) { bottomPadding ->
        Column(
            modifier = Modifier
                .padding(bottom = bottomPadding),
        ) {
            when (val currentScreen = windowDataModel.currentScreen) {
                is NavigationDestination.DiceRoller -> DiceRollerScreen(
                    dataModel = currentScreen.dataModel,
                    platform = platform,
                )
            }
        }
    }
}
