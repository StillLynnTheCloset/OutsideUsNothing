package com.stilllynnthecloset.outsideusnothing.organizer

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import com.stilllynnthecloset.liboun.generateWeightedList
import com.stilllynnthecloset.liboun.model.PortOfCall
import com.stilllynnthecloset.liboun.playbook.portWeightings

/**
 * OrganizerDataModel - TODO: Documentation
 *
 * Created by Lynn on 4/14/23
 */
public class OrganizerDataModel {
    public var generatedPort: PortOfCall? by mutableStateOf(null)
        private set

    public fun generatePort() {
        generatedPort = portWeightings.generateWeightedList().random().randomize()
    }
}
