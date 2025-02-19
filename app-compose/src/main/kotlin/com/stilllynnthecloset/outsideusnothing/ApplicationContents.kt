package com.stilllynnthecloset.outsideusnothing

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.runtime.Composable
import androidx.compose.ui.ExperimentalComposeUiApi
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.DpSize
import com.stilllynnthecloset.outsideusnothing.createplayer.CreatePlayerScreen
import com.stilllynnthecloset.outsideusnothing.dice.DiceRollerScreen
import com.stilllynnthecloset.outsideusnothing.edit.EditScreen
import com.stilllynnthecloset.outsideusnothing.generator.GeneratorScreen
import com.stilllynnthecloset.outsideusnothing.map.MapScreen
import com.stilllynnthecloset.outsideusnothing.playbooks.PlaybooksScreen
import com.stilllynnthecloset.outsideusnothing.reference.ReferenceScreen
import com.stilllynnthecloset.outsideusnothing.theme.navigationContainer
import com.stilllynnthecloset.outsideusnothing.timeconverter.TimeConverterScreen
import com.stilllynnthecloset.outsideusnothing.viewplayers.ViewPlayersScreen

@Composable
@ExperimentalComposeUiApi
public fun applicationContents(windowSize: DpSize, dataModel: MainDataModel, windowViewModel: WindowViewModel, platform: Platform) {
    navigationContainer(
        windowSize = windowSize,
        currentTab = NavigationTabImpl.values()
            .find { it.description == windowViewModel.currentScreen.description },
        tabs = NavigationTabImpl.values().toList(),
        isThereBackButton = windowViewModel.isThereBackstack(),
        onNavigationClick = { windowViewModel.updateCurrentTab(it) },
        onBackClick = { windowViewModel.popBackStack() },
        platform = platform,
    ) { bottomPadding ->
        Column(
            modifier = Modifier
                .padding(bottom = bottomPadding),
        ) {
            when (val currentScreen = windowViewModel.currentScreen) {
                is NavigationDestination.DiceRoller -> DiceRollerScreen(
                    dataModel = currentScreen.dataModel,
                    platform = platform,
                )

                is NavigationDestination.Generator -> GeneratorScreen(
                    dataModel = currentScreen.dataModel,
                    platform = platform,
                )

                is NavigationDestination.CreatePlayer -> CreatePlayerScreen(
                    dataModel = currentScreen.dataModel,
                    platform = platform,
                )

                is NavigationDestination.ViewPlayers -> ViewPlayersScreen(
                    dataModel = currentScreen.dataModel,
                    platform = platform,
                )

                is NavigationDestination.Map -> MapScreen(
                    dataModel = currentScreen.dataModel,
                    platform = platform,
                )

                is NavigationDestination.Playbooks -> PlaybooksScreen(
                    mainDataModel = dataModel,
                    windowViewModel = windowViewModel,
                    dataModel = currentScreen.dataModel,
                    platform = platform,
                )

                is NavigationDestination.Reference -> ReferenceScreen(
                    dataModel = currentScreen.dataModel,
                    platform = platform,
                )

                is NavigationDestination.EditPlaybook -> EditScreen(
                    dataModel = currentScreen.dataModel,
                    platform = platform,
                )

                is NavigationDestination.TimeConverter -> TimeConverterScreen(
                    dataModel = currentScreen.dataModel,
                    platform = platform,
                )
            }
        }
    }
}
