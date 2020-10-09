package com.jdscaram.suspeito.components

import androidx.compose.foundation.Icon
import androidx.compose.foundation.Text
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.preferredHeight
import androidx.compose.material.Divider
import androidx.compose.material.DropdownMenu
import androidx.compose.material.DropdownMenuItem
import androidx.compose.material.MaterialTheme
import androidx.compose.material.TopAppBar
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.outlined.ArrowBack
import androidx.compose.material.icons.outlined.MoreVert
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import androidx.ui.tooling.preview.Preview
import com.jdscaram.suspeito.R
import com.jdscaram.suspeito.components.theme.DetectiveTheme
import com.jdscaram.suspeito.core.ext.compose.ComposableFn
import com.jdscaram.suspeito.core.ext.compose.ComposableRowFn
import com.jdscaram.suspeito.core.ext.func.Callback0

@Composable
fun DetectiveAppBar(
    modifier: Modifier = Modifier,
    title: String? = null,
    showBackButton: Boolean = false,
    showMenuButton: Boolean = false,
    showDivider: Boolean = true,
    onBackPress: Callback0 = {},
    onNewGame: Callback0 = {},
) {
    val backButtonView: ComposableFn = { BackButton(onClick = onBackPress) }

    val actionsView: ComposableRowFn = {
        AppBarMenu(
            onNewGame = onNewGame,
            showMenuButton = showMenuButton
        )
    }

    val titleView: ComposableFn = {
        val finalTitle = title ?: stringResource(id = R.string.app_name)
        Text(text = finalTitle)
    }

    Column {
        TopAppBar(
            modifier = modifier,
            elevation = 4.dp,
            backgroundColor = MaterialTheme.colors.primary,
            contentColor = MaterialTheme.colors.onPrimary,
            actions = actionsView,
            title = titleView,
            navigationIcon = backButtonView.takeIf { showBackButton }
        )

        if (showDivider) {
            Divider()
        }
    }
}

@Composable
fun MenuIcon(onClick: () -> Unit) {
    Icon(
        asset = Icons.Outlined.MoreVert,
        modifier = Modifier
            .clickable(onClick = onClick)
            .padding(horizontal = 12.dp, vertical = 16.dp)
            .preferredHeight(24.dp)
    )
}

@Composable
fun BackButton(onClick: () -> Unit) {
    Icon(
        asset = Icons.Outlined.ArrowBack,
        modifier = Modifier
            .clickable(onClick = onClick)
            .padding(16.dp)
    )
}

@Composable
fun AppBarMenu(
    showMenuButton: Boolean = false,
    onNewGame: () -> Unit,
) {
    if (showMenuButton) {
        val (isMenuOpen, setMenuState) = remember { mutableStateOf(false) }
        val toggleMenu = { setMenuState(isMenuOpen.not()) }

        DropdownMenu(
            toggle = { MenuIcon(onClick = toggleMenu) },
            expanded = isMenuOpen,
            onDismissRequest = { setMenuState(false) }
        ) {
            DropdownMenuItem(
                onClick = {
                    toggleMenu()
                    onNewGame()
                }
            ) {
                Text(text = "New Game")
            }
        }
    }
}

@Composable
@Preview
fun PreviewAppBar() {
    DetectiveTheme {
        DetectiveAppBar(
            title = "Detetive",
            showBackButton = true,
            showMenuButton = true
        )
    }
}
