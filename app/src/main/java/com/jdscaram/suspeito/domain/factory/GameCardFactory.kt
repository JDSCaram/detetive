package com.jdscaram.suspeito.domain.factory

import com.jdscaram.suspeito.domain.model.Card
import com.jdscaram.suspeito.domain.model.GameCard

object GameCardFactory {

    fun make(): List<GameCard> = Card.values().map {
        GameCard(card = it)
    }
}
