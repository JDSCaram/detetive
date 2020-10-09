package com.jdscaram.suspeito.ui.main

import com.jdscaram.suspeito.domain.model.GameCard
import com.jdscaram.suspeito.domain.model.Type

class MainViewState(
    val selectedTab: Type = Type.CHARACTER,
    val cards: List<GameCard> = emptyList(),
)
