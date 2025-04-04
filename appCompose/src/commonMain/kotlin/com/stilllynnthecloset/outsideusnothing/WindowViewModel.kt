package com.stilllynnthecloset.outsideusnothing

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import com.stilllynnthecloset.outsideusnothing.createplayer.CreatePlayerViewModel
import com.stilllynnthecloset.outsideusnothing.dice.DiceRollerDataModel
import com.stilllynnthecloset.outsideusnothing.edit.EditViewModel
import com.stilllynnthecloset.outsideusnothing.generator.GeneratorViewModel
import com.stilllynnthecloset.outsideusnothing.map.MapViewModel
import com.stilllynnthecloset.outsideusnothing.playbooks.PlaybooksViewModel
import com.stilllynnthecloset.outsideusnothing.reference.ReferenceViewModel
import com.stilllynnthecloset.outsideusnothing.timeconverter.TimeConverterDataModel
import com.stilllynnthecloset.outsideusnothing.viewplayers.ViewPlayersViewModel

/**
 * WindowDataModel - TODO: Documentation
 *
 * Created by Lynn on 4/14/23
 */
public class WindowViewModel internal constructor(
    private val mainDataModel: MainDataModel,
    private val screen: NavigationDestination,
    private val persistence: Persistence,
) {
    private val backstack = ArrayDeque<NavigationDestination>(5)
    internal var currentScreen: NavigationDestination by mutableStateOf(screen)
        private set

    private val diceDM = DiceRollerDataModel()
    private val generatorDM = GeneratorViewModel(mainDataModel)
    private val playerDM = CreatePlayerViewModel(mainDataModel)
    private val playersDM = ViewPlayersViewModel(mainDataModel)
    private val mapDM = MapViewModel(mainDataModel, persistence)
    private val playbooksDM = PlaybooksViewModel(mainDataModel)
    private val referenceDM = ReferenceViewModel(mainDataModel)
    private val timeDM = TimeConverterDataModel()

    internal fun popBackStack() {
        navigate(NavigationAction.PopBackStack)
    }

    internal fun isThereBackstack(): Boolean = backstack.isNotEmpty()

    internal fun openEditPlaybook(playbookUuid: String, page: PlaybookPage = PlaybookPage.PLAYBOOK) {
        navigate(NavigationAction.NavigateTo(NavigationDestination.EditPlaybook(EditViewModel(mainDataModel, this, page, playbookUuid))))
    }

    internal fun updateCurrentTab(newTab: NavigationTabImpl) {
        backstack.clear()
        currentScreen = when (newTab) {
            NavigationTabImpl.DiceRoller -> NavigationDestination.DiceRoller(diceDM)
            NavigationTabImpl.Generator -> NavigationDestination.Generator(generatorDM)
            NavigationTabImpl.Player -> NavigationDestination.CreatePlayer(playerDM)
            NavigationTabImpl.Players -> NavigationDestination.ViewPlayers(playersDM)
            NavigationTabImpl.Map -> NavigationDestination.Map(mapDM)
            NavigationTabImpl.Playbooks -> NavigationDestination.Playbooks(playbooksDM)
            NavigationTabImpl.Reference -> NavigationDestination.Reference(referenceDM)
            NavigationTabImpl.TimeConverter -> NavigationDestination.TimeConverter(timeDM)
        }
    }

    private fun navigate(action: NavigationAction) {
        when (action) {
            NavigationAction.PopBackStack -> {
                if (backstack.isNotEmpty()) {
                    currentScreen = backstack.removeLast()
                }
            }

            is NavigationAction.NavigateTo -> {
                backstack.addLast(currentScreen)
                currentScreen = action.destination
            }
        }
        println("Current screen is: $currentScreen")
        println("Backstack is: $backstack")
    }
}
