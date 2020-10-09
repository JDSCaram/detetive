package com.jdscaram.suspeito.ui.main

import com.jdscaram.suspeito.domain.model.Card

sealed class MainAction {
    class EditCard(val card: Card) : MainAction()
    object ConfirmNewGame : MainAction()
}
