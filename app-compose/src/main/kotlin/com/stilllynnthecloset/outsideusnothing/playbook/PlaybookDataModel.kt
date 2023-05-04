package com.stilllynnthecloset.outsideusnothing.playbook

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import com.stilllynnthecloset.liboun.generateWeightedList
import com.stilllynnthecloset.liboun.model.Bastard
import com.stilllynnthecloset.liboun.model.ContractItem
import com.stilllynnthecloset.liboun.model.Event
import com.stilllynnthecloset.liboun.model.FlavorText
import com.stilllynnthecloset.liboun.model.HealthCondition
import com.stilllynnthecloset.liboun.model.Player
import com.stilllynnthecloset.liboun.model.PortOfCall
import com.stilllynnthecloset.liboun.model.Ship
import com.stilllynnthecloset.liboun.model.Threat
import com.stilllynnthecloset.liboun.model.UsefulItem
import com.stilllynnthecloset.liboun.playbook.AlienPlaybook
import com.stilllynnthecloset.liboun.playbook.BackgroundPlaybook
import com.stilllynnthecloset.liboun.playbook.BastardPlaybook
import com.stilllynnthecloset.liboun.playbook.ContractItemPlaybook
import com.stilllynnthecloset.liboun.playbook.EventPlaybook
import com.stilllynnthecloset.liboun.playbook.FlavorTextPlaybook
import com.stilllynnthecloset.liboun.playbook.PortPlaybook
import com.stilllynnthecloset.liboun.playbook.RolePlaybook
import com.stilllynnthecloset.liboun.playbook.ShipPlaybook
import com.stilllynnthecloset.liboun.playbook.ThreatPlaybook
import com.stilllynnthecloset.liboun.playbook.UsefulItemPlaybook

/**
 * PlaybookDataModel - TODO: Documentation
 *
 * Created by Lynn on 4/14/23
 */
public class PlaybookDataModel {
    public var currentPage: PlaybookPage by mutableStateOf(PlaybookPage.TABLE_OF_CONTENTS)
        private set

    public fun setPage(newPage: PlaybookPage) {
        currentPage = newPage
    }
}
