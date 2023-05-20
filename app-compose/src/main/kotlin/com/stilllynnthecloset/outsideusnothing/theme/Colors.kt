package com.stilllynnthecloset.outsideusnothing.theme

import androidx.compose.material3.darkColorScheme
import androidx.compose.material3.lightColorScheme
import androidx.compose.ui.graphics.Color

internal object Colors {
    // primary
    private val niceMagenta = Color(0xFF690069)
    private val fadedMagenta = Color(0xFF750d75)

    // secondary
    private val poppyRed = Color(0xFFFF5727)

    // tertiary
    private val gren = Color(0xFF0D750D)

    // neutral
    private val blackCoal = Color(0xFF1D1D1D)
    private val slate = Color(0xFF2D2D2D)
    private val slate_variant = Color(0xFF3D3D3D)
    private val darkClouds = Color(0xFF626262)
    private val silver = Color(0xFFE1E3E4)
    private val washed = Color(0xFFEEEEEE)
    private val marshmallow = Color(0xFFFFFFFF)

    val lightColors = lightColorScheme(
        primary = niceMagenta,
        onPrimary = marshmallow,
//        primaryContainer = ,
//        onPrimaryContainer = ,
//        inversePrimary = ,

        secondary = niceMagenta,
        onSecondary = marshmallow,
        secondaryContainer = niceMagenta,
        onSecondaryContainer = marshmallow,

        tertiary = gren,
        onTertiary = marshmallow,
//        tertiaryContainer = ,
//        onTertiaryContainer = ,

        background = washed,
        onBackground = blackCoal,

        surface = marshmallow,
        onSurface = blackCoal,
        surfaceVariant = washed,
        onSurfaceVariant = blackCoal,
//        surfaceTint = ,
//        inverseSurface = ,
//        inverseOnSurface = ,

        error = poppyRed,
        onError = blackCoal,
//        errorContainer = ,
//        onErrorContainer = ,
//
        outline = niceMagenta,
        outlineVariant = silver,
//        scrim = ,
    )

    val darkColors = darkColorScheme(
        primary = niceMagenta,
        onPrimary = marshmallow,
//        primaryContainer = ,
//        onPrimaryContainer = ,
//        inversePrimary = ,

        secondary = niceMagenta,
        onSecondary = marshmallow,
        secondaryContainer = niceMagenta,
        onSecondaryContainer = marshmallow,

        tertiary = gren,
        onTertiary = marshmallow,
//        tertiaryContainer = ,
//        onTertiaryContainer = ,

        background = slate,
        onBackground = washed,

        surface = slate,
        onSurface = washed,
        surfaceVariant = slate_variant,
        onSurfaceVariant = washed,
//        surfaceTint = ,
//        inverseSurface = ,
//        inverseOnSurface = ,

        error = poppyRed,
        onError = blackCoal,
//        errorContainer = ,
//        onErrorContainer = ,
//
        outline = niceMagenta,
        outlineVariant = darkClouds,
//        scrim = ,
    )
}
