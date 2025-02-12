package com.stilllynnthecloset.outsideusnothing.library.interfaces

public interface Mergable<T : Mergable<T>> {
    public fun merge(other: T): T
}