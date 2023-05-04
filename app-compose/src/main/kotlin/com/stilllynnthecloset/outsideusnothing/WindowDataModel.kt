package com.stilllynnthecloset.outsideusnothing

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import com.stilllynnthecloset.outsideusnothing.dice.DiceRollerDataModel
import com.stilllynnthecloset.outsideusnothing.map.MapDataModel
import com.stilllynnthecloset.outsideusnothing.organizer.OrganizerDataModel
import com.stilllynnthecloset.outsideusnothing.playbook.PlaybookDataModel

/**
 * WindowDataModel - TODO: Documentation
 *
 * Created by Lynn on 4/14/23
 */
public class WindowDataModel {
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
            NavigationTabImpl.Organizer -> NavigationDestination.Organizer(OrganizerDataModel())
            NavigationTabImpl.Map -> NavigationDestination.Map(MapDataModel())
            NavigationTabImpl.Playbook -> NavigationDestination.Playbook(PlaybookDataModel())
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
