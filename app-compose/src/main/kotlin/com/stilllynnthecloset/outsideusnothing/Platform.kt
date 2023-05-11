package com.stilllynnthecloset.outsideusnothing

import com.stilllynnthecloset.outsideusnothing.theme.ImagePainter

/**
 * Platform - TODO: Documentation
 *
 * Created by Lynn on 3/25/23
 */
public interface Platform {
    public val imagePainter: ImagePainter
    public val persistence: Persistence
}
