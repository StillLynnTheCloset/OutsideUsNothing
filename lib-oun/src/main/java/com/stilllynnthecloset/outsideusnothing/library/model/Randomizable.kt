package com.stilllynnthecloset.outsideusnothing.library.model

public fun interface Randomizable<T> {
    public fun randomize(playbook: Playbook): T
}