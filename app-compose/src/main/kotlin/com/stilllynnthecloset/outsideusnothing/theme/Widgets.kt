@file:OptIn(ExperimentalMaterial3Api::class, ExperimentalMaterial3Api::class)

package com.stilllynnthecloset.outsideusnothing.theme

import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.Image
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.IntrinsicSize
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.RowScope
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.LazyListState
import androidx.compose.foundation.lazy.rememberLazyListState
import androidx.compose.material3.Divider
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.NavigationBar
import androidx.compose.material3.NavigationBarItem
import androidx.compose.material3.NavigationRail
import androidx.compose.material3.NavigationRailItem
import androidx.compose.material3.OutlinedButton
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Alignment.Companion.Center
import androidx.compose.ui.Alignment.Companion.CenterHorizontally
import androidx.compose.ui.Alignment.Companion.CenterVertically
import androidx.compose.ui.Alignment.Companion.Start
import androidx.compose.ui.Alignment.Companion.TopStart
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.ColorFilter
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.DpSize
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.stilllynnthecloset.outsideusnothing.Platform

public val appBarHeight: Dp = 64.dp

@Composable
@ExperimentalFoundationApi
public fun appWindowTitleBar(
    currentIsDarkTheme: Boolean,
    onDarkThemeChanged: (Boolean) -> Unit,
    onOpenWindow: (() -> Unit)? = null,
    platform: Platform,
): Unit =
    Box(
        modifier = Modifier
            .fillMaxWidth()
            .height(appBarHeight),
    ) {
        Row(
            verticalAlignment = CenterVertically,
            modifier = Modifier.align(Alignment.CenterStart),
        ) {
            Text(
                text = "Outside us, Nothing",
                fontSize = 20.sp,
                modifier = Modifier
                    .padding(start = 26.dp, end = 6.dp),
            )

            Spacer(
                modifier = Modifier
                    .weight(1.0f),
            )

            if (onOpenWindow != null) {
                Image(
                    painter = platform.imagePainter.getPainter(ImageReference.Add),
                    contentDescription = "Open New Window",
                    colorFilter = ColorFilter.tint(MaterialTheme.colorScheme.onSurface),
                    modifier = Modifier
                        .padding(end = 16.dp)
                        .width(26.dp)
                        .clickable { onOpenWindow() },
                )
            }

            Image(
                painter = platform.imagePainter.getPainter(if (currentIsDarkTheme) ImageReference.LightMode else ImageReference.DarkMode),
                contentDescription = "Toggle Dark Mode",
                colorFilter = ColorFilter.tint(MaterialTheme.colorScheme.onSurface),
                modifier = Modifier
                    .padding(end = 16.dp)
                    .width(26.dp)
                    .clickable {
                        onDarkThemeChanged(!currentIsDarkTheme)
                    },
            )
        }
    }

private val inputHeight = 64.dp

@Composable
public fun textInputWidget(
    value: String,
    label: String,
    modifier: Modifier,
    onValueChange: (String) -> Unit,
) {
    TextField(
        value = value,
        singleLine = true,
        label = {
            Text(
                text = label,
                color = MaterialTheme.colorScheme.onSurface,
                fontWeight = FontWeight.Light,
            )
        },
        onValueChange = onValueChange,
        modifier = modifier
            .height(inputHeight)
            .border(
                1.dp,
                MaterialTheme.colorScheme.outline,
                MaterialTheme.shapes.small,
            ),
        shape = MaterialTheme.shapes.small,
        colors = TextFieldDefaults.textFieldColors(
            containerColor = Color.Transparent,
            focusedIndicatorColor = Color.Transparent,
            unfocusedIndicatorColor = Color.Transparent,
            disabledIndicatorColor = Color.Transparent,
        ),
    )
}

@Composable
public fun longInputWidget(
    value: Long?,
    label: String,
    modifier: Modifier,
    onValueChange: (Long?) -> Unit,
) {
    TextField(
        value = value?.toString() ?: "",
        singleLine = true,
        label = {
            Text(
                text = label,
                color = MaterialTheme.colorScheme.onSurface,
                fontWeight = FontWeight.Light,
            )
        },
        onValueChange = { onValueChange(it.filter { char -> char.isDigit() || char == '-' }.toLongOrNull()) },
        modifier = modifier
            .height(inputHeight)
            .border(
                1.dp,
                MaterialTheme.colorScheme.outline,
                MaterialTheme.shapes.small,
            ),
        shape = MaterialTheme.shapes.small,
        colors = TextFieldDefaults.textFieldColors(
            containerColor = Color.Transparent,
            focusedIndicatorColor = Color.Transparent,
            unfocusedIndicatorColor = Color.Transparent,
            disabledIndicatorColor = Color.Transparent,
        ),
    )
}

@Composable
public fun outlinedButton(
    onClick: () -> Unit,
    modifier: Modifier = Modifier,
    enabled: Boolean = true,
    content: @Composable RowScope.() -> Unit,
): Unit = OutlinedButton(
    onClick = onClick,
    modifier = modifier
        .height(inputHeight),
    enabled = enabled,
    content = content,
)

@Composable
public fun imageButton(
    onClick: () -> Unit,
    modifier: Modifier = Modifier,
    enabled: Boolean = true,
    imageReference: ImageReference,
    contentDescription: String,
    platform: Platform,
): Unit = OutlinedButton(
    onClick = onClick,
    modifier = modifier
        .height(inputHeight),
    enabled = enabled,
    shape = MaterialTheme.shapes.small,
    content = {
        Image(
            painter = platform.imagePainter.getPainter(imageReference),
            colorFilter = ColorFilter.tint(MaterialTheme.colorScheme.onSurface),
            contentDescription = contentDescription,
            modifier = Modifier
                .width(24.dp)
                .align(CenterVertically),
        )
    },
)

@Composable
public fun backButton(
    onClick: () -> Unit,
    modifier: Modifier = Modifier,
    platform: Platform,
) {
    Box(
        modifier = modifier
            .clickable { onClick() },
    ) {
        Image(
            painter = platform.imagePainter.getPainter(ImageReference.ChevronLeft),
            colorFilter = ColorFilter.tint(MaterialTheme.colorScheme.onSurface),
            contentDescription = "Back",
            modifier = Modifier
                .size(32.dp)
                .align(Center),
        )
    }
}

@Composable
public fun horizontalDivider() {
    Divider(thickness = 1.dp)
}

public abstract class TableColumn<T> {
    public abstract fun getTitle(): String
    public abstract fun getValue(data: T): String
}

public data class VerticallyCombinedColumn<T> constructor(val rows: List<TableColumn<T>>) : TableColumn<T>() {
    override fun getTitle(): String = rows.joinToString(separator = "\n") { it.getTitle() }

    override fun getValue(data: T): String = rows.joinToString(separator = "\n") { it.getValue(data) }
}

public data class HorizontallyCombinedColumn<T> constructor(val columns: List<TableColumn<T>>) : TableColumn<T>() {
    override fun getTitle(): String = columns.joinToString(separator = " ") { it.getTitle() }

    override fun getValue(data: T): String = columns.joinToString(separator = " ") { it.getValue(data) }
}

@Composable
public fun <T> resultsTable(
    columns: List<TableColumn<T>>,
    results: List<T>,
    lazyListState: LazyListState = rememberLazyListState(),
    platform: Platform,
    onClick: (T) -> Unit,
) {
    headerRow(columns.map { it.getTitle() }, platform)
    if (results.isEmpty()) {
        Box(
            modifier = Modifier
                .fillMaxHeight()
                .fillMaxWidth(),
        ) {
            Text(
                text = "No Results",
                modifier = Modifier
                    .align(Alignment.Center),
            )
        }
    } else {
        LazyColumn(
            state = lazyListState,
        ) {
            items(results.size) {
                val result = results[it]
                resultRow(columns.map { column -> column.getValue(result) }, platform, onClick = { onClick(result) })
            }
        }
    }
}

@Composable
private fun headerRow(titles: List<String>, platform: Platform) {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .wrapContentHeight()
            .padding(
                start = 16.dp,
                end = 16.dp,
            )
            .height(IntrinsicSize.Max),
    ) {
        titles.forEach { title ->
            TableHeader(text = title)
        }

        // Draw an invisible image to make sure the weights are the same as in the result rows.
        Image(
            painter = platform.imagePainter.getPainter(ImageReference.ChevronRight),
            contentDescription = "",
            modifier = Modifier.height(24.dp),
            alpha = 0.0f,
        )
    }
    horizontalDivider()
}

@Composable
private fun RowScope.TableHeader(
    text: String,
) {
    Text(
        text = text,
        fontWeight = FontWeight.Light,
        modifier = Modifier
            .weight(1f)
            .align(CenterVertically)
            .padding(8.dp),
        style = TextStyle(fontWeight = FontWeight.Bold),
    )
}

@Composable
private fun resultRow(cells: List<String>, platform: Platform, onClick: () -> Unit) {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .wrapContentHeight()
            .clickable(onClick = onClick)
            .padding(
                start = 16.dp,
                end = 16.dp,
            )
            .height(IntrinsicSize.Max),
    ) {
        cells.forEach { cell ->
            TableCell(text = cell)
        }
        Image(
            painter = platform.imagePainter.getPainter(ImageReference.ChevronRight),
            colorFilter = ColorFilter.tint(MaterialTheme.colorScheme.onSurface),
            contentDescription = "View Details",
            modifier = Modifier
                .height(24.dp)
                .align(CenterVertically),
        )
    }
    horizontalDivider()
}

@Composable
private fun RowScope.TableCell(
    text: String,
) {
    Text(
        text = text,
        modifier = Modifier
            .weight(1f)
            .align(CenterVertically)
            .padding(8.dp),
    )
}

public interface NavigationTab {
    public val description: String
    public val imageReference: ImageReference
    public val label: String
}

@Composable
public fun <T : NavigationTab> navigationContainer(
    windowSize: DpSize,
    currentTab: T?,
    tabs: List<T>,
    isThereBackButton: Boolean,
    onNavigationClick: (T) -> Unit,
    onBackClick: () -> Unit,
    platform: Platform,
    content: @Composable (bottomPadding: Dp) -> Unit,
) {
    if (windowSize.width > 800.dp) {
        Box {
            navigationRailContainer(
                currentTab = currentTab,
                tabs = tabs,
                onNavigationClick = onNavigationClick,
                content = content,
                platform = platform,
            )
            if (isThereBackButton) {
                backButton(
                    onClick = onBackClick,
                    modifier = Modifier
                        .size(navBarSize)
                        .align(TopStart),
                    platform = platform,
                )
            }
        }
    } else {
        Column {
            if (isThereBackButton) {
                backButton(
                    onClick = onBackClick,
                    modifier = Modifier
                        .size(navBarSize)
                        .align(Start),
                    platform = platform,
                )
            }
            navigationBarContainer(
                currentTab = currentTab,
                tabs = tabs,
                onClick = onNavigationClick,
                content = content,
                platform = platform,
            )
        }
    }
}

public val navBarSize: Dp = 80.dp

@Composable
public fun <T : NavigationTab> navigationRailContainer(
    currentTab: T?,
    tabs: List<T>,
    onNavigationClick: (T) -> Unit,
    content: @Composable (bottomPadding: Dp) -> Unit,
    platform: Platform,
) {
    Row {
        NavigationRail(
            containerColor = MaterialTheme.colorScheme.surfaceVariant,
            modifier = Modifier
                .width(navBarSize)
                .fillMaxHeight(),
        ) {
            Spacer(Modifier.weight(1f))
            tabs.forEach { tab ->
                val isSelected = currentTab?.description == tab.description
                NavigationRailItem(
                    selected = isSelected,
                    modifier = Modifier.padding(top = 8.dp, bottom = 8.dp),
                    onClick = { onNavigationClick(tab) },
                    icon = {
                        Image(
                            painter = platform.imagePainter.getPainter(tab.imageReference),
                            colorFilter = ColorFilter.tint(
                                if (isSelected) MaterialTheme.colorScheme.onSecondaryContainer else MaterialTheme.colorScheme.onSurfaceVariant,
                            ),
                            contentDescription = "Open ${tab.label}",
                            modifier = Modifier
                                .height(24.dp)
                                .width(24.dp)
                                .align(CenterHorizontally),
                        )
                    },
                    label = {
                        Text(text = tab.label)
                    },
                )
            }
            Spacer(Modifier.weight(1f))
        }
        content(0.dp)
    }
}

@Composable
public fun <T : NavigationTab> navigationBarContainer(
    currentTab: T?,
    tabs: List<T>,
    onClick: (T) -> Unit,
    content: @Composable (bottomPadding: Dp) -> Unit,
    platform: Platform,
) {
    Scaffold(
        containerColor = MaterialTheme.colorScheme.surface,
        bottomBar = {
            NavigationBar(
                modifier = Modifier
                    .height(navBarSize)
                    .fillMaxWidth(),
            ) {
                tabs.forEach { tab ->
                    val isSelected = currentTab?.description == tab.description
                    NavigationBarItem(
                        selected = isSelected,
                        onClick = { onClick(tab) },
                        icon = {
                            Icon(
                                painter = platform.imagePainter.getPainter(tab.imageReference),
                                tint = if (isSelected) MaterialTheme.colorScheme.onSecondaryContainer else MaterialTheme.colorScheme.onSurfaceVariant,
                                contentDescription = "Open ${tab.label}",
                                modifier = Modifier
                                    .height(24.dp)
                                    .width(24.dp),
                            )
                        },
                        label = {
                            Text(
                                text = tab.label,
                            )
                        },
                    )
                }
            }
        },
    ) {
        content(navBarSize)
    }
}

@Composable
public fun incrementInput(
    label: String,
    modifier: Modifier,
    value: Long?,
    onValueChange: (Long?) -> Unit,
    platform: Platform,
) {
    Row(modifier = modifier) {
        imageButton(
            onClick = {
                value?.let { onValueChange(it - 1L) }
            },
            imageReference = ImageReference.Remove,
            contentDescription = "Decrement Counter",
            modifier = Modifier,
            platform = platform,
        )
        longInputWidget(
            value,
            label,
            modifier = Modifier
                .width(200.dp)
                .padding(horizontal = 4.dp),
            onValueChange = {
                onValueChange(it)
            },
        )
        imageButton(
            onClick = {
                value?.let { onValueChange(it + 1L) }
            },
            imageReference = ImageReference.Add,
            contentDescription = "Increment Counter",
            modifier = Modifier,
            platform = platform,
        )
    }
}

@Composable
public fun text(
    text: String,
    modifier: Modifier,
) {
    Text(
        text = text,
        color = MaterialTheme.colorScheme.onSurface,
        fontSize = 20.sp,
        modifier = modifier,
    )
}
