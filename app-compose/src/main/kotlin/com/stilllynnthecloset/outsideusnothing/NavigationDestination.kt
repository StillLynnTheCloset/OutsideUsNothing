package com.stilllynnthecloset.outsideusnothing

import com.stilllynnthecloset.outsideusnothing.createplayer.CreatePlayerViewModel
import com.stilllynnthecloset.outsideusnothing.dice.DiceRollerDataModel
import com.stilllynnthecloset.outsideusnothing.edit.EditViewModel
import com.stilllynnthecloset.outsideusnothing.generator.GeneratorDataModel
import com.stilllynnthecloset.outsideusnothing.map.MapDataModel
import com.stilllynnthecloset.outsideusnothing.playbooks.PlaybooksViewModel
import com.stilllynnthecloset.outsideusnothing.reference.ReferenceDataModel

internal sealed class NavigationDestination constructor(val description: String) {
    override fun toString(): String = description

    class DiceRoller constructor(val dataModel: DiceRollerDataModel) : NavigationDestination("DiceRoller")
    class Generator constructor(val dataModel: GeneratorDataModel) : NavigationDestination("Generator")
    class CreatePlayer constructor(val dataModel: CreatePlayerViewModel) : NavigationDestination("CreatePlayer")
    class Map constructor(val dataModel: MapDataModel) : NavigationDestination("Map")
    class Playbooks constructor(val dataModel: PlaybooksViewModel) : NavigationDestination("Playbooks")
    class Reference constructor(val dataModel: ReferenceDataModel) : NavigationDestination("Reference")
    class EditPlaybook constructor(val dataModel: EditViewModel) : NavigationDestination("EditPlaybook")
}
