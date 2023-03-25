package com.stilllynnthecloset.outsideusnothing.theme

import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.painter.Painter

/**
 * ImagePainter - TODO: Documentation
 *
 * Created by Lynn on 3/25/23
 */
public interface ImagePainter {
    @Composable
    public fun getPainter(image: ImageReference): Painter
}
