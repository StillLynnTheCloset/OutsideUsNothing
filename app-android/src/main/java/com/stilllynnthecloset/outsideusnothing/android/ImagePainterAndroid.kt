package com.stilllynnthecloset.outsideusnothing.android

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
internal object ImagePainterAndroid : ImagePainter {
    @Composable
    override fun getPainter(image: ImageReference): Painter = when (image) {
        ImageReference.Dice1 -> painterResource(id = R.drawable.ic_dice1)
        ImageReference.Dice2 -> painterResource(id = R.drawable.ic_dice2)
        ImageReference.Dice3 -> painterResource(id = R.drawable.ic_dice3)
        ImageReference.Dice4 -> painterResource(id = R.drawable.ic_dice4)
        ImageReference.Dice5 -> painterResource(id = R.drawable.ic_dice5)
        ImageReference.Dice6 -> painterResource(id = R.drawable.ic_dice6)
        ImageReference.LightMode -> painterResource(id = R.drawable.ic_light_mode)
        ImageReference.DarkMode -> painterResource(id = R.drawable.ic_dark_mode)
        ImageReference.ChevronLeft -> painterResource(id = R.drawable.ic_chevron_left)
        ImageReference.ChevronRight -> painterResource(id = R.drawable.ic_chevron_right)
        ImageReference.Add -> painterResource(id = R.drawable.ic_add)
        ImageReference.Remove -> painterResource(id = R.drawable.ic_remove)
        ImageReference.Book -> painterResource(id = R.drawable.ic_book)
        ImageReference.Fuel -> painterResource(id = R.drawable.ic_fuel)
        ImageReference.Food -> painterResource(id = R.drawable.ic_food)
        ImageReference.Swords -> painterResource(id = R.drawable.ic_swords)
        ImageReference.Map -> painterResource(id = R.drawable.ic_map)
        ImageReference.Factory -> painterResource(id = R.drawable.ic_factory)
        ImageReference.RadioButtonUnchecked -> painterResource(id = R.drawable.ic_radio_button_unchecked)
        ImageReference.RadioButtonChecked -> painterResource(id = R.drawable.ic_radio_button_checked)
    }
}
