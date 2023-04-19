package com.stilllynnthecloset.outsideusnothing

import com.stilllynnthecloset.outsideusnothing.dice.DiceRollerDataModel
import com.stilllynnthecloset.outsideusnothing.organizer.OrganizerDataModel

internal sealed class NavigationDestination constructor(val description: String) {
    override fun toString(): String = description

    class DiceRoller constructor(val dataModel: DiceRollerDataModel) : NavigationDestination("DiceRoller")
    class Organizer constructor(val dataModel: OrganizerDataModel) : NavigationDestination("Organizer")
}
