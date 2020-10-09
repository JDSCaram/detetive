package com.jdscaram.suspeito.containers

import androidx.compose.animation.Crossfade
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.ui.tooling.preview.Preview
import com.jdscaram.suspeito.components.DetectiveAppBar
import com.jdscaram.suspeito.components.DetectiveTabBar
import com.jdscaram.suspeito.components.card.CardList
import com.jdscaram.suspeito.components.theme.DetectiveTheme
import com.jdscaram.suspeito.core.ext.func.Callback0
import com.jdscaram.suspeito.core.ext.func.Callback1
import com.jdscaram.suspeito.domain.model.GameCard
import com.jdscaram.suspeito.domain.model.Type
import com.jdscaram.suspeito.ui.main.MainViewAction
import com.jdscaram.suspeito.ui.main.MainViewModel

@Composable
fun MainContainer(viewModel: MainViewModel) = DetectiveTheme {
    val viewState by viewModel.state.collectAsState()
    MainContent(
        selectedTab = viewState.selectedTab,
        cards = viewState.cards,
        setTab = { viewModel.dispatch(MainViewAction.ChangeTab(it)) },
        onCardClick = { viewModel.dispatch(MainViewAction.EditCard(it)) },
        onNewGame = { viewModel.dispatch(MainViewAction.NewGame) }
    )
}

@Composable
fun MainContent(
    selectedTab: Type = Type.CHARACTER,
    cards: List<GameCard> = emptyList(),
    setTab: Callback1<Type> = {},
    onCardClick: Callback1<GameCard> = {},
    onNewGame: Callback0 = {},
) {
    Scaffold(
        topBar = {
            Column(Modifier.fillMaxWidth()) {
                DetectiveAppBar(
                    showMenuButton = true,
                    showDivider = false,
                    onNewGame = onNewGame
                )
                DetectiveTabBar(
                    selectedTab = selectedTab,
                    onTabSelected = setTab
                )
            }
        },
    ) {
        Crossfade(current = selectedTab) {
            CardList(
                cards = cards,
                onCardClick = onCardClick
            )
        }
    }
}

@Preview
@Composable
fun PreviewGreeting() {
    DetectiveTheme {
        MainContent()
    }
}
