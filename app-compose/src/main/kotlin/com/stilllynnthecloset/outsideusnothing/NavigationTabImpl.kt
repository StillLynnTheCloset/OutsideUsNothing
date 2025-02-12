package com.stilllynnthecloset.outsideusnothing

import com.stilllynnthecloset.outsideusnothing.theme.ImageReference
import com.stilllynnthecloset.outsideusnothing.theme.NavigationTab

/**
 * NavigarionTabImpl - TODO: Documentation
 *
 * Created by Lynn on 3/25/23
 */
internal enum class NavigationTabImpl constructor(
    override val description: String,
    override val imageReference: ImageReference,
    override val label: String,
) : NavigationTab {
    DiceRoller("DiceRoller", ImageReference.Dice5, "Dice"),
    Generator("Generator", ImageReference.Factory, "Generator"),
    Player("Player", ImageReference.Person, "Player"),
    Players("Players", ImageReference.Group, "Players"),
    Map("Map", ImageReference.Map, "Map"),
    Reference("Reference", ImageReference.Document, "Reference"),
    Playbooks("Playbooks", ImageReference.Book, "Playbooks"),
    TimeConverter("Time", ImageReference.Clock, "Time"),
}
