package com.stilllynnthecloset.outsideusnothing

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import com.stilllynnthecloset.outsideusnothing.dice.DiceRollerDataModel
import com.stilllynnthecloset.outsideusnothing.edit.EditViewModel
import com.stilllynnthecloset.outsideusnothing.generator.GeneratorDataModel
import com.stilllynnthecloset.outsideusnothing.map.MapDataModel
import com.stilllynnthecloset.outsideusnothing.playbooks.PlaybooksViewModel
import com.stilllynnthecloset.outsideusnothing.reference.ReferenceDataModel

/**
 * WindowDataModel - TODO: Documentation
 *
 * Created by Lynn on 4/14/23
 */
public class WindowDataModel internal constructor(private val mainDataModel: MainDataModel, screen: NavigationDestination) {
    private val backstack = ArrayDeque<NavigationDestination>(5)
    internal var currentScreen: NavigationDestination by mutableStateOf(screen)
        private set

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
            NavigationTabImpl.DiceRoller -> NavigationDestination.DiceRoller(DiceRollerDataModel())
            NavigationTabImpl.Generator -> NavigationDestination.Generator(GeneratorDataModel(mainDataModel.mergedPlaybook))
            NavigationTabImpl.Map -> NavigationDestination.Map(MapDataModel(mainDataModel.mergedPlaybook))
            NavigationTabImpl.Playbooks -> NavigationDestination.Playbooks(PlaybooksViewModel(mainDataModel))
            NavigationTabImpl.Reference -> NavigationDestination.Reference(ReferenceDataModel(mainDataModel))
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
