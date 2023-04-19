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
        ImageReference.Dice1 -> painterResource("image/menu/dice1.svg")
        ImageReference.Dice2 -> painterResource("image/menu/dice2.svg")
        ImageReference.Dice3 -> painterResource("image/menu/dice3.svg")
        ImageReference.Dice4 -> painterResource("image/menu/dice4.svg")
        ImageReference.Dice5 -> painterResource("image/menu/dice5.svg")
        ImageReference.Dice6 -> painterResource("image/menu/dice6.svg")
        ImageReference.Sun -> painterResource("image/menu/sun.svg")
        ImageReference.Moon -> painterResource("image/menu/moon.svg")
        ImageReference.Plus -> painterResource("image/actions/plus.svg")
        ImageReference.Minus -> painterResource("image/actions/minus.svg")
        ImageReference.ChevronLeft -> painterResource("image/arrows/chevron-left.svg")
        ImageReference.ChevronRight -> painterResource("image/arrows/chevron-right.svg")
        ImageReference.Book -> painterResource("image/menu/book.svg")
        ImageReference.Gas -> painterResource("image/menu/gas.svg")
    }
}
