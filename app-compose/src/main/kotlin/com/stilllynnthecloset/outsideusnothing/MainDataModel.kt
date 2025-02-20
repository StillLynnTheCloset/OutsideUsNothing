package com.stilllynnthecloset.outsideusnothing

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import com.stilllynnthecloset.outsideusnothing.library.model.Playbook
import com.stilllynnthecloset.outsideusnothing.dice.DiceRollerDataModel
import com.stilllynnthecloset.outsideusnothing.library.model.Player

public class MainDataModel public constructor(private val platform: Platform) {
    public var isDarkTheme: Boolean by mutableStateOf(true)
        private set

    internal var mergedPlaybook: Playbook by mutableStateOf(Playbook.defaultPlaybook)
        private set

    private var playbooks: List<Playbook> by mutableStateOf(emptyList())

    public var windows: List<WindowViewModel> by mutableStateOf(listOf(WindowViewModel(this, NavigationDestination.DiceRoller(DiceRollerDataModel()), platform)))
        private set

    init {
        updatePlaybooks(
            // TODO: Replace with load from DB.
            listOf(
                Playbook.lynnsPlaybook,
                Playbook.wolf,
                Playbook.emptyPlaybook,
            ),
        )
    }

    public fun updateIsDarkTheme(isDarkTheme: Boolean) {
        this.isDarkTheme = isDarkTheme
    }

    internal fun updatePlaybooks(playbooks: List<Playbook>) {
        this.playbooks = playbooks
        this.mergedPlaybook = getPlaybooks().mapNotNull { if (it.active) it else null }.reduce { a, b -> a + b }
    }

    internal fun setPlaybookState(playbook: Playbook, active: Boolean) {
        updatePlaybooks(
            playbooks.map {
                if (it.uuid == playbook.uuid) {
                    it.copy(active = active)
                } else {
                    it
                }
            },
        )
    }

    internal fun updatePlaybook(playbook: Playbook) {
        updatePlaybooks(
            playbooks.map {
                if (it.uuid == playbook.uuid) {
                    playbook
                } else {
                    it
                }
            },
        )
    }

    internal fun addPlaybook(playbook: Playbook) {
        updatePlaybooks(
            playbooks + playbook,
        )
    }

    internal fun removePlaybook(playbook: Playbook) {
        updatePlaybooks(
            playbooks.mapNotNull {
                if (it.uuid == playbook.uuid) {
                    null
                } else {
                    it
                }
            },
        )
    }

    internal fun getPlaybooks(): Collection<Playbook> {
        return listOf(Playbook.defaultPlaybook) + playbooks
    }

    public fun getPlayers(): Collection<Player> {
        return platform.persistence.getPlayers()
    }

    public fun openWindow() {
        this.windows += WindowViewModel(
            this,
            NavigationDestination.DiceRoller(DiceRollerDataModel()),
            platform
        )
    }

    public fun closeWindow(window: WindowViewModel) {
        this.windows -= window
    }
}
