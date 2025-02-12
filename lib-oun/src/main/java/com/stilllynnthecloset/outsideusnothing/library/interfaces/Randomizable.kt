package com.stilllynnthecloset.outsideusnothing.library.interfaces

import com.stilllynnthecloset.outsideusnothing.library.model.Playbook

public fun interface Randomizable<T> {
    public fun randomize(playbook: Playbook): T
}