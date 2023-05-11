package com.stilllynnthecloset.outsideusnothing.desktop

import androidx.compose.desktop.ui.tooling.preview.Preview
import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.window.WindowDraggableArea
import androidx.compose.material3.Divider
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Surface
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.ExperimentalComposeUiApi
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.DpSize
import androidx.compose.ui.unit.dp
import androidx.compose.ui.window.Window
import androidx.compose.ui.window.WindowPlacement
import androidx.compose.ui.window.WindowPosition
import androidx.compose.ui.window.WindowState
import androidx.compose.ui.window.application
import com.stilllynnthecloset.outsideusnothing.MainDataModel
import com.stilllynnthecloset.outsideusnothing.WindowDataModel
import com.stilllynnthecloset.outsideusnothing.applicationContents
import com.stilllynnthecloset.outsideusnothing.theme.LynnTheme
import com.stilllynnthecloset.outsideusnothing.theme.appWindowTitleBar

@Preview
@ExperimentalComposeUiApi
@ExperimentalFoundationApi
@ExperimentalMaterial3Api
public fun main() {
    application {
        val windowStates = remember { mutableMapOf<WindowDataModel, WindowState>() }
        val platform = remember { PlatformDesktop() }
        val dataModel = remember { MainDataModel(platform) }
        dataModel.windows.forEach { window ->
            val windowState = windowStates[window] ?: WindowState(
                placement = WindowPlacement.Floating,
                size = DpSize(640.dp, 1080.dp),
                position = WindowPosition.Aligned(Alignment.BottomStart),
            ).also { windowStates[window] = it }
            Window(
                onCloseRequest = {
                    dataModel.closeWindow(window)
                    windowStates.remove(window)
                    if (dataModel.windows.isEmpty()) {
                        exitApplication()
                    }
                },
                state = windowState,
                title = "Outside us, Nothing",
            ) {
                LynnTheme(dataModel.isDarkTheme) {
                    Surface(
                        modifier = Modifier.fillMaxSize(),
                    ) {
                        Column {
                            WindowDraggableArea {
                                appWindowTitleBar(
                                    currentIsDarkTheme = dataModel.isDarkTheme,
                                    onDarkThemeChanged = dataModel::updateIsDarkTheme,
                                    onOpenWindow = dataModel::openWindow,
                                    platform = platform,
                                )
                            }
                            Divider(thickness = 1.dp)

                            applicationContents(
                                windowSize = windowState.size,
                                dataModel = dataModel,
                                windowDataModel = window,
                                platform = platform,
                            )
                        }
                    }
                }
            }
        }
    }
}
