package com.stilllynnthecloset.outsideusnothing.android

import com.stilllynnthecloset.outsideusnothing.Platform
import com.stilllynnthecloset.outsideusnothing.theme.ImagePainter

/**
 * PlatformAndroid - TODO: Documentation
 *
 * Created by Lynn on 3/25/23
 */
internal data class PlatformAndroid constructor(
    override val imagePainter: ImagePainter = ImagePainterAndroid,
) : Platform
