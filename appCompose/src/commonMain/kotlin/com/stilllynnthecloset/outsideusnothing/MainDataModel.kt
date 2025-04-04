package com.stilllynnthecloset.outsideusnothing

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import com.stilllynnthecloset.outsideusnothing.library.model.Playbook
import com.stilllynnthecloset.outsideusnothing.dice.DiceRollerDataModel
import com.stilllynnthecloset.outsideusnothing.library.model.Player
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

public class MainDataModel public constructor(private val persistence: Persistence) {
    private val coroutineScope = CoroutineScope(Dispatchers.Default)
    public var isDarkTheme: Boolean by mutableStateOf(true)
        private set

    internal var defaultPlaybook: Playbook? by mutableStateOf(null)

    internal var mergedPlaybook: Playbook by mutableStateOf(Playbook.mergedPlaybook)
        private set

    private var dynamicPlaybooks: List<Playbook> by mutableStateOf(emptyList())

    public var windows: List<WindowViewModel> by mutableStateOf(listOf(WindowViewModel(this, NavigationDestination.DiceRoller(DiceRollerDataModel()), persistence)))
        private set

    init {
        coroutineScope.launch {
            defaultPlaybook = persistence.getDefaultPlaybook()
            updatePlaybooks(
                persistence.getPlaybooks().toList()
            )
        }
    }

    public fun updateIsDarkTheme(isDarkTheme: Boolean) {
        this.isDarkTheme = isDarkTheme
    }

    internal fun updatePlaybooks(playbooks: List<Playbook>) {
        this.dynamicPlaybooks = playbooks
        this.mergedPlaybook = getPlaybooks().mapNotNull { if (it.active) it else null }.reduce { a, b -> a + b }
    }

    internal fun setPlaybookState(playbook: Playbook, active: Boolean) {
        updatePlaybooks(
            dynamicPlaybooks.map {
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
            dynamicPlaybooks.map {
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
            dynamicPlaybooks + playbook,
        )
    }

    internal fun removePlaybook(playbook: Playbook) {
        updatePlaybooks(
            dynamicPlaybooks.mapNotNull {
                if (it.uuid == playbook.uuid) {
                    null
                } else {
                    it
                }
            },
        )
    }

    internal fun getPlaybooks(): Collection<Playbook> {
        return listOf(defaultPlaybook ?: Playbook.mergedPlaybook) + dynamicPlaybooks
    }

    public suspend fun getPlayers(): Collection<Player> {
        return persistence.getPlayers()
    }

    public fun openWindow() {
        this.windows += WindowViewModel(
            this,
            NavigationDestination.DiceRoller(DiceRollerDataModel()),
            persistence
        )
    }

    public fun closeWindow(window: WindowViewModel) {
        this.windows -= window
    }
}
