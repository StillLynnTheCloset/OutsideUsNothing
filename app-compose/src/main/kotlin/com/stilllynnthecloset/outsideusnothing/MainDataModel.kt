package com.stilllynnthecloset.outsideusnothing

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import com.stilllynnthecloset.outsideusnothing.NavigationAction.NavigateTo
import com.stilllynnthecloset.outsideusnothing.NavigationAction.PopBackStack
import com.stilllynnthecloset.outsideusnothing.dice.DiceRollerDataModel

public class MainDataModel constructor() {
    public var isDarkTheme: Boolean by mutableStateOf(true)
        private set
    private val backstack = ArrayDeque<NavigationDestination>(5)
    internal var currentScreen: NavigationDestination by mutableStateOf<NavigationDestination>(NavigationDestination.DiceRoller(DiceRollerDataModel()))
        private set

    public fun popBackStack() {
        navigate(PopBackStack)
    }

    public fun isThereBackstack(): Boolean = backstack.isNotEmpty()

    public fun openDiceRoller() {
        navigate(NavigateTo(NavigationDestination.DiceRoller(DiceRollerDataModel())))
    }

    internal fun updateCurrentTab(newTab: NavigationTabImpl) {
        backstack.clear()
        currentScreen = when (newTab) {
            NavigationTabImpl.DiceRoller -> NavigationDestination.DiceRoller(DiceRollerDataModel())
        }
    }

    public fun updateIsDarkTheme(isDarkTheme: Boolean) {
        this.isDarkTheme = isDarkTheme
    }

    private fun navigate(action: NavigationAction) {
        when (action) {
            PopBackStack -> {
                if (backstack.isNotEmpty()) {
                    currentScreen = backstack.removeLast()
                }
            }
            is NavigateTo -> {
                backstack.addLast(currentScreen)
                currentScreen = action.destination
            }
        }
        println("Current screen is: $currentScreen")
        println("Backstack is: $backstack")
    }
}
