package com.stilllynnthecloset.outsideusnothing

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import com.stilllynnthecloset.liboun.model.Playbook

public class MainDataModel constructor() {
    public var isDarkTheme: Boolean by mutableStateOf(true)
        private set

    public var mergedPlaybook: Playbook by mutableStateOf(Playbook.defaultPlaybook)
        private set

    public var playbooks: List<Playbook> by mutableStateOf(emptyList())
        private set

    public var windows: List<WindowDataModel> by mutableStateOf(listOf(WindowDataModel(this)))
        private set

    init {
        updatePlaybooks(
            listOf(
                Playbook.defaultPlaybook,
                Playbook.lynnsPlaybook,
                Playbook.emptyPlaybook,
            )
        )
    }

    public fun updateIsDarkTheme(isDarkTheme: Boolean) {
        this.isDarkTheme = isDarkTheme
    }

    public fun updatePlaybooks(playbooks: List<Playbook>) {
        this.playbooks = playbooks
        this.mergedPlaybook = playbooks.mapNotNull { if (it.active) it else null }.reduce { a, b -> a + b }
    }

    public fun setPlaybookState(playbook: Playbook, active: Boolean) {
        updatePlaybooks(
            playbooks.map {
                if (it.uuid == playbook.uuid) {
                    it.copy(active = active)
                } else {
                    it
                }
            }
        )
    }

    public fun openWindow() {
        this.windows = windows + WindowDataModel(this)
    }

    public fun closeWindow(window: WindowDataModel) {
        this.windows = windows - window
    }
}
