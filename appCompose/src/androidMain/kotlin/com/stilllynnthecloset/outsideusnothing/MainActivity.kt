package com.stilllynnthecloset.outsideusnothing

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.ExperimentalComposeUiApi
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalConfiguration
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.DpSize
import androidx.compose.ui.unit.dp
import com.stilllynnthecloset.outsideusnothing.theme.LynnTheme
import com.stilllynnthecloset.outsideusnothing.theme.appWindowTitleBar

@ExperimentalComposeUiApi
@ExperimentalFoundationApi
@ExperimentalMaterial3Api
public class MainActivity : ComponentActivity() {
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
public fun Content() {
    val persistence = remember { Persistence() }
    val dataModel = remember { MainDataModel(persistence) }

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
