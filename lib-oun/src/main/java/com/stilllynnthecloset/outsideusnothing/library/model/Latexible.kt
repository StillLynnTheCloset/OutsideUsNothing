package com.stilllynnthecloset.outsideusnothing.library.model

internal fun interface Latexible {
    fun toLatex(builder: StringBuilder)
}