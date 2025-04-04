package com.stilllynnthecloset.outsideusnothing

import com.stilllynnthecloset.outsideusnothing.theme.NavigationTab
import org.jetbrains.compose.resources.DrawableResource
import outsideusnothing.appcompose.generated.resources.Res
import outsideusnothing.appcompose.generated.resources.ic_book
import outsideusnothing.appcompose.generated.resources.ic_dice5
import outsideusnothing.appcompose.generated.resources.ic_document
import outsideusnothing.appcompose.generated.resources.ic_factory
import outsideusnothing.appcompose.generated.resources.ic_group
import outsideusnothing.appcompose.generated.resources.ic_map
import outsideusnothing.appcompose.generated.resources.ic_person

/**
 * NavigarionTabImpl - TODO: Documentation
 *
 * Created by Lynn on 3/25/23
 */
internal enum class NavigationTabImpl constructor(
    override val description: String,
    override val imageReference: DrawableResource,
    override val label: String,
) : NavigationTab {
    DiceRoller("DiceRoller", Res.drawable.ic_dice5, "Dice"),
    Generator("Generator", Res.drawable.ic_factory, "Generator"),
    Player("Player", Res.drawable.ic_person, "Player"),
    Players("Players", Res.drawable.ic_group, "Players"),
    Map("Map", Res.drawable.ic_map, "Map"),
    Reference("Reference", Res.drawable.ic_document, "Reference"),
    Playbooks("Playbooks", Res.drawable.ic_book, "Playbooks"),
    TimeConverter("Time", Res.drawable.ic_dice5, "Time"),
}
