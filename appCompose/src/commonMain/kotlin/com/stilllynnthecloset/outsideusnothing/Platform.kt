package com.stilllynnthecloset.outsideusnothing

import com.stilllynnthecloset.outsideusnothing.theme.ImagePainter

/**
 * Platform - TODO: Documentation
 *
 * Created by Lynn on 3/25/23
 */
public data class Platform constructor(
    val imagePainter: ImagePainter = ImagePainter,
    val persistence: Persistence = Persistence(),
)
