package com.jdscaram.suspeito.factory

import com.jdscaram.suspeito.domain.model.Card
import com.jdscaram.suspeito.domain.model.GameCard
import com.jdscaram.suspeito.domain.model.Location

object GameCardTestFactory {

    fun newGameCards() = listOf(
        GameCard(card = Card.DINING_ROOM),
        GameCard(card = Card.KITCHEN),
        GameCard(card = Card.BUTLER),
        GameCard(card = Card.CHEF),
        GameCard(card = Card.BEDSIDE_LAMP),
        GameCard(card = Card.GUN),
    )

    fun runningGameCards() = newGameCards().map {
        it.copy(location = Location.values().random())
    }

    fun randomCard() = runningGameCards().random()
}
