package com.stilllynnthecloset.outsideusnothing

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import com.stilllynnthecloset.liboun.model.Playbook

public class MainDataModel constructor() {
    public var isDarkTheme: Boolean by mutableStateOf(true)
        private set

    internal var mergedPlaybook: Playbook by mutableStateOf(Playbook.defaultPlaybook)
        private set

    internal var playbooks: List<Playbook> by mutableStateOf(emptyList())
        private set

    public var windows: List<WindowDataModel> by mutableStateOf(listOf(WindowDataModel(this)))
        private set

    init {
        updatePlaybooks( // TODO: Replace with load from DB.
            listOf(
                Playbook.defaultPlaybook,
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
        this.mergedPlaybook = playbooks.mapNotNull { if (it.active) it else null }.reduce { a, b -> a + b }
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
                if (it.uuid == playbook.uuid) { playbook } else { it }
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
                if (it.uuid == playbook.uuid) { null } else { it }
            },
        )
    }

    public fun openWindow() {
        this.windows = windows + WindowDataModel(this)
    }

    public fun closeWindow(window: WindowDataModel) {
        this.windows = windows - window
    }
}
