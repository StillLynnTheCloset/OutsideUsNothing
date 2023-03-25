package com.stilllynnthecloset.outsideusnothing

internal sealed class NavigationAction {
    object PopBackStack : NavigationAction()
    data class NavigateTo constructor(val destination: NavigationDestination) : NavigationAction()
}
