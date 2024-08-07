package com.stilllynnthecloset.outsideusnothing.desktop

import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.res.painterResource
import com.stilllynnthecloset.outsideusnothing.theme.ImagePainter
import com.stilllynnthecloset.outsideusnothing.theme.ImageReference

/**
 * ImagePainter - TODO: Documentation
 *
 * Created by Lynn on 3/25/23
 */
internal object ImagePainterDesktop : ImagePainter {
    @Composable
    override fun getPainter(image: ImageReference): Painter = when (image) {
        ImageReference.Dice1 -> painterResource("image/dice1.svg")
        ImageReference.Dice2 -> painterResource("image/dice2.svg")
        ImageReference.Dice3 -> painterResource("image/dice3.svg")
        ImageReference.Dice4 -> painterResource("image/dice4.svg")
        ImageReference.Dice5 -> painterResource("image/dice5.svg")
        ImageReference.Dice6 -> painterResource("image/dice6.svg")
        ImageReference.LightMode -> painterResource("image/light_mode.svg")
        ImageReference.DarkMode -> painterResource("image/dark_mode.svg")
        ImageReference.Add -> painterResource("image/add.svg")
        ImageReference.Remove -> painterResource("image/remove.svg")
        ImageReference.ChevronLeft -> painterResource("image/chevron-left.svg")
        ImageReference.ChevronRight -> painterResource("image/chevron-right.svg")
        ImageReference.Book -> painterResource("image/book.svg")
        ImageReference.Fuel -> painterResource("image/fuel.svg")
        ImageReference.Food -> painterResource("image/food.svg")
        ImageReference.Swords -> painterResource("image/swords.svg")
        ImageReference.Map -> painterResource("image/map.svg")
        ImageReference.Factory -> painterResource("image/factory.svg")
        ImageReference.RadioButtonUnchecked -> painterResource("image/radio_button_unchecked.svg")
        ImageReference.RadioButtonChecked -> painterResource("image/radio_button_checked.svg")
        ImageReference.Save -> painterResource("image/save.svg")
        ImageReference.Document -> painterResource("image/document.svg")
        ImageReference.Edit -> painterResource("image/edit.svg")
        ImageReference.History -> painterResource("image/history.svg")
        ImageReference.Delete -> painterResource("image/delete.svg")
        ImageReference.Person -> painterResource("image/person.svg")
        ImageReference.PersonAdd -> painterResource("image/person_add.svg")
        ImageReference.PersonRemove -> painterResource("image/person_remove.svg")
        ImageReference.Group -> painterResource("image/group.svg")
        ImageReference.GroupAdd -> painterResource("image/group_add.svg")
        ImageReference.GroupRemove -> painterResource("image/group_remove.svg")
        ImageReference.Ship -> painterResource("image/ship.svg")
        ImageReference.Clock -> painterResource("image/clock.svg")
        ImageReference.CircleDie -> painterResource("image/regularCircle.svg")
        ImageReference.TriangleDie -> painterResource("image/regularTriangle.svg")
        ImageReference.SquareDie -> painterResource("image/regularSquare.svg")
        ImageReference.DiamondDie -> painterResource("image/regularDiamond.svg")
        ImageReference.PentagonDie -> painterResource("image/regularPentagon.svg")
    }
}
