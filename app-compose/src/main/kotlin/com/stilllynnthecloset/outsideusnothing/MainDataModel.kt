package com.stilllynnthecloset.outsideusnothing

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue

public class MainDataModel constructor() {
    public var isDarkTheme: Boolean by mutableStateOf(true)
        private set

    public var windows: List<WindowDataModel> by mutableStateOf(listOf(WindowDataModel()))
        private set

    public fun updateIsDarkTheme(isDarkTheme: Boolean) {
        this.isDarkTheme = isDarkTheme
    }

    public fun openWindow() {
        this.windows = windows + WindowDataModel()
    }

    public fun closeWindow(window: WindowDataModel) {
        this.windows = windows - window
    }
}
