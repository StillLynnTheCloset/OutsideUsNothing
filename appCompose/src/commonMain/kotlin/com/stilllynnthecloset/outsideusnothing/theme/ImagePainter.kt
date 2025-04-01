package com.stilllynnthecloset.outsideusnothing.theme

import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.painter.Painter
import org.jetbrains.compose.resources.painterResource

import outsideusnothing.appcompose.generated.resources.Res
import outsideusnothing.appcompose.generated.resources.*

/**
 * ImagePainter - TODO: Documentation
 *
 * Created by Lynn on 3/25/23
 */
public object ImagePainter {
    @Composable
    public fun getPainter(image: ImageReference): Painter = when (image) {
        ImageReference.Dice1 -> painterResource(Res.drawable.ic_dice1)
        ImageReference.Dice2 -> painterResource(Res.drawable.ic_dice2)
        ImageReference.Dice3 -> painterResource(Res.drawable.ic_dice3)
        ImageReference.Dice4 -> painterResource(Res.drawable.ic_dice4)
        ImageReference.Dice5 -> painterResource(Res.drawable.ic_dice5)
        ImageReference.Dice6 -> painterResource(Res.drawable.ic_dice6)
        ImageReference.LightMode -> painterResource(Res.drawable.ic_light_mode)
        ImageReference.DarkMode -> painterResource(Res.drawable.ic_dark_mode)
        ImageReference.Add -> painterResource(Res.drawable.ic_add)
        ImageReference.Remove -> painterResource(Res.drawable.ic_remove)
        ImageReference.ChevronLeft -> painterResource(Res.drawable.ic_chevron_left)
        ImageReference.ChevronRight -> painterResource(Res.drawable.ic_chevron_right)
        ImageReference.Book -> painterResource(Res.drawable.ic_book)
        ImageReference.Fuel -> painterResource(Res.drawable.ic_fuel)
        ImageReference.Food -> painterResource(Res.drawable.ic_food)
        ImageReference.Swords -> painterResource(Res.drawable.ic_swords)
        ImageReference.Map -> painterResource(Res.drawable.ic_map)
        ImageReference.Factory -> painterResource(Res.drawable.ic_factory)
        ImageReference.RadioButtonUnchecked -> painterResource(Res.drawable.ic_radio_button_unchecked)
        ImageReference.RadioButtonChecked -> painterResource(Res.drawable.ic_radio_button_checked)
        ImageReference.Save -> painterResource(Res.drawable.ic_save)
        ImageReference.Document -> painterResource(Res.drawable.ic_document)
        ImageReference.Edit -> painterResource(Res.drawable.ic_edit)
        ImageReference.History -> painterResource(Res.drawable.ic_history)
        ImageReference.Delete -> painterResource(Res.drawable.ic_delete)
        ImageReference.Person -> painterResource(Res.drawable.ic_person)
        ImageReference.PersonAdd -> painterResource(Res.drawable.ic_person_add)
        ImageReference.PersonRemove -> painterResource(Res.drawable.ic_person_remove)
        ImageReference.Group -> painterResource(Res.drawable.ic_group)
        ImageReference.GroupAdd -> painterResource(Res.drawable.ic_group_add)
        ImageReference.GroupRemove -> painterResource(Res.drawable.ic_group_remove)
        ImageReference.Ship -> painterResource(Res.drawable.ic_rocket2)
        ImageReference.Clock -> painterResource(Res.drawable.ic_clock)
        ImageReference.CircleDie -> painterResource(Res.drawable.ic_regularcircle)
        ImageReference.TriangleDie -> painterResource(Res.drawable.ic_regulartriangle)
        ImageReference.SquareDie -> painterResource(Res.drawable.ic_regularsquare)
        ImageReference.DiamondDie -> painterResource(Res.drawable.ic_regulardiamond)
        ImageReference.PentagonDie -> painterResource(Res.drawable.ic_regularpentagon)
    }
}
