package com.stilllynnthecloset.outsideusnothing.android

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Divider
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.ExperimentalComposeUiApi
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalConfiguration
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.DpSize
import androidx.compose.ui.unit.dp
import com.stilllynnthecloset.outsideusnothing.MainDataModel
import com.stilllynnthecloset.outsideusnothing.applicationContents
import com.stilllynnthecloset.outsideusnothing.theme.LynnTheme
import com.stilllynnthecloset.outsideusnothing.theme.appWindowTitleBar

@ExperimentalComposeUiApi
@ExperimentalFoundationApi
@ExperimentalMaterial3Api
class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            Content()
        }
    }
}

@Preview(showBackground = true)
@ExperimentalComposeUiApi
@ExperimentalFoundationApi
@ExperimentalMaterial3Api
@Composable
fun Content() {
    val dataModel = remember { MainDataModel() }
    val platform = remember { PlatformAndroid() }

    LynnTheme(dataModel.isDarkTheme) {
        Surface(
            modifier = Modifier.fillMaxSize(),
        ) {
            Column {
                val configuration = LocalConfiguration.current

                val screenWidth = configuration.screenWidthDp.dp
                val screenHeight = configuration.screenHeightDp.dp

                appWindowTitleBar(
                    currentIsDarkTheme = dataModel.isDarkTheme,
                    onDarkThemeChanged = dataModel::updateIsDarkTheme,
                    platform = platform,
                )
                Divider(thickness = 1.dp)

                applicationContents(
                    windowSize = DpSize(screenWidth, screenHeight),
                    dataModel = dataModel,
                    windowDataModel = dataModel.windows.first(),
                    platform = platform,
                )
            }
        }
    }
}
