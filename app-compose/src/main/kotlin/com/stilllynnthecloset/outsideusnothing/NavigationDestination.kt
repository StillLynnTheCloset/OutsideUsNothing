package com.stilllynnthecloset.outsideusnothing

import com.stilllynnthecloset.outsideusnothing.dice.DiceRollerDataModel
import com.stilllynnthecloset.outsideusnothing.map.MapDataModel
import com.stilllynnthecloset.outsideusnothing.organizer.OrganizerDataModel
import com.stilllynnthecloset.outsideusnothing.playbooks.PlaybooksViewModel
import com.stilllynnthecloset.outsideusnothing.reference.ReferenceDataModel

internal sealed class NavigationDestination constructor(val description: String) {
    override fun toString(): String = description

    class DiceRoller constructor(val dataModel: DiceRollerDataModel) : NavigationDestination("DiceRoller")
    class Organizer constructor(val dataModel: OrganizerDataModel) : NavigationDestination("Organizer")
    class Map constructor(val dataModel: MapDataModel) : NavigationDestination("Map")
    class Playbook constructor(val dataModel: PlaybooksViewModel) : NavigationDestination("Playbook")
    class Reference constructor(val dataModel: ReferenceDataModel) : NavigationDestination("Playbook")
}
