package com.jdscaram.suspeito.ui.main

import com.jdscaram.suspeito.domain.model.GameCard
import com.jdscaram.suspeito.domain.model.Type

sealed class MainViewAction {
    object NewGame : MainViewAction()
    object ConfirmNewGame : MainViewAction()
    class ChangeTab(val newTab: Type) : MainViewAction()
    class EditCard(val card: GameCard) : MainViewAction()
}
