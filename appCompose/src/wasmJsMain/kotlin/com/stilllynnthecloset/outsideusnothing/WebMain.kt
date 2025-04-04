package com.stilllynnthecloset.outsideusnothing

import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.Surface
import androidx.compose.runtime.remember
import androidx.compose.ui.ExperimentalComposeUiApi
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalWindowInfo
import androidx.compose.ui.unit.DpSize
import androidx.compose.ui.unit.dp
import androidx.compose.ui.window.ComposeViewport
import com.stilllynnthecloset.outsideusnothing.theme.LynnTheme
import com.stilllynnthecloset.outsideusnothing.theme.appWindowTitleBar
import kotlinx.browser.document

@OptIn(ExperimentalComposeUiApi::class, ExperimentalFoundationApi::class)
public fun main() {
    ComposeViewport(document.body!!) {
        val configuration = LocalWindowInfo.current.containerSize

        val screenWidth = configuration.width.dp
        val screenHeight = configuration.height.dp
        val persistence = remember { Persistence() }
        val dataModel = remember { MainDataModel(persistence) }

        LynnTheme(dataModel.isDarkTheme) {
            Surface(
                modifier = Modifier.fillMaxSize(),
            ) {
                Column {
                    appWindowTitleBar(
                        currentIsDarkTheme = dataModel.isDarkTheme,
                        onDarkThemeChanged = dataModel::updateIsDarkTheme,
                        onOpenWindow = null,
                    )

                    HorizontalDivider(thickness = 1.dp)

                    applicationContents(
                        windowSize = DpSize(screenWidth, screenHeight),
                        dataModel = dataModel,
                        windowViewModel = dataModel.windows.first(),
                    )
                }
            }
        }
    }
}