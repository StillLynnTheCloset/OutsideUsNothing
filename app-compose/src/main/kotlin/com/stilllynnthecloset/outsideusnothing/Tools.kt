package com.stilllynnthecloset.outsideusnothing

import okio.buffer
import okio.source


public fun readFile(path: String): String {
    val file = Thread.currentThread().contextClassLoader.getResourceAsStream(path)
    return file?.source()?.buffer()?.readUtf8().orEmpty()
}
