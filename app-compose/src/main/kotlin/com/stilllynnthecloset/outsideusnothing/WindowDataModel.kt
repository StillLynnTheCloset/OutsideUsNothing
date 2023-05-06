package com.stilllynnthecloset.outsideusnothing

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import com.stilllynnthecloset.outsideusnothing.dice.DiceRollerDataModel
import com.stilllynnthecloset.outsideusnothing.generator.GeneratorDataModel
import com.stilllynnthecloset.outsideusnothing.map.MapDataModel
import com.stilllynnthecloset.outsideusnothing.playbooks.PlaybooksViewModel
import com.stilllynnthecloset.outsideusnothing.reference.ReferenceDataModel

/**
 * WindowDataModel - TODO: Documentation
 *
 * Created by Lynn on 4/14/23
 */
public class WindowDataModel constructor(private val mainDataModel: MainDataModel) {
    private val backstack = ArrayDeque<NavigationDestination>(5)
    internal var currentScreen: NavigationDestination by mutableStateOf(NavigationDestination.DiceRoller(DiceRollerDataModel()))
        private set

    public fun popBackStack() {
        navigate(NavigationAction.PopBackStack)
    }

    public fun isThereBackstack(): Boolean = backstack.isNotEmpty()

    public fun openDiceRoller() {
        navigate(NavigationAction.NavigateTo(NavigationDestination.DiceRoller(DiceRollerDataModel())))
    }

    internal fun updateCurrentTab(newTab: NavigationTabImpl) {
        backstack.clear()
        currentScreen = when (newTab) {
            NavigationTabImpl.DiceRoller -> NavigationDestination.DiceRoller(DiceRollerDataModel())
            NavigationTabImpl.Generator -> NavigationDestination.Generator(GeneratorDataModel(mainDataModel.mergedPlaybook))
            NavigationTabImpl.Map -> NavigationDestination.Map(MapDataModel(mainDataModel.mergedPlaybook))
            NavigationTabImpl.Playbooks -> NavigationDestination.Playbook(PlaybooksViewModel(mainDataModel))
            NavigationTabImpl.Reference -> NavigationDestination.Reference(ReferenceDataModel(mainDataModel.mergedPlaybook))
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
