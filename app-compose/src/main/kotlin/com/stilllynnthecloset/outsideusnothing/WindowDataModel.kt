package com.stilllynnthecloset.outsideusnothing

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import com.stilllynnthecloset.outsideusnothing.createplayer.CreatePlayerViewModel
import com.stilllynnthecloset.outsideusnothing.dice.DiceRollerDataModel
import com.stilllynnthecloset.outsideusnothing.edit.EditViewModel
import com.stilllynnthecloset.outsideusnothing.generator.GeneratorDataModel
import com.stilllynnthecloset.outsideusnothing.map.MapDataModel
import com.stilllynnthecloset.outsideusnothing.playbooks.PlaybooksViewModel
import com.stilllynnthecloset.outsideusnothing.reference.ReferenceDataModel
import com.stilllynnthecloset.outsideusnothing.timeconverter.TimeConverterDataModel

/**
 * WindowDataModel - TODO: Documentation
 *
 * Created by Lynn on 4/14/23
 */
public class WindowDataModel internal constructor(
    private val mainDataModel: MainDataModel,
    private val screen: NavigationDestination,
    private val platform: Platform,
) {
    private val backstack = ArrayDeque<NavigationDestination>(5)
    internal var currentScreen: NavigationDestination by mutableStateOf(screen)
        private set

    private val diceDM = DiceRollerDataModel()
    private val generatorDM = GeneratorDataModel(mainDataModel.mergedPlaybook)
    private val playerDM = CreatePlayerViewModel(mainDataModel)
    private val mapDM = MapDataModel(mainDataModel.mergedPlaybook, platform)
    private val playbooksDM = PlaybooksViewModel(mainDataModel)
    private val referenceDM = ReferenceDataModel(mainDataModel)
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
            NavigationTabImpl.Players -> NavigationDestination.CreatePlayer(playerDM)
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
