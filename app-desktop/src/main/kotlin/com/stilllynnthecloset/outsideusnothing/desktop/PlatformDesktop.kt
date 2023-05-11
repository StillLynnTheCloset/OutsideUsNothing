package com.stilllynnthecloset.outsideusnothing.desktop

import com.stilllynnthecloset.outsideusnothing.Persistence
import com.stilllynnthecloset.outsideusnothing.Platform
import com.stilllynnthecloset.outsideusnothing.theme.ImagePainter

/**
 * PlatformDesktop - TODO: Documentation
 *
 * Created by Lynn on 3/25/23
 */
internal data class PlatformDesktop constructor(
    override val imagePainter: ImagePainter = ImagePainterDesktop,
    override val persistence: Persistence = PersistenceDesktop(),
) : Platform
