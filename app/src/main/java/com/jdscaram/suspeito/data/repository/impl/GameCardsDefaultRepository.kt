package com.jdscaram.suspeito.data.repository.impl

import com.jdscaram.suspeito.data.datasource.CardDataSource
import com.jdscaram.suspeito.data.repository.GameCardsRepository
import com.jdscaram.suspeito.domain.model.GameCard
import kotlinx.coroutines.flow.Flow

class GameCardsDefaultRepository constructor(
    private val cardDataSource: CardDataSource,
) : GameCardsRepository {

    override val cardsStream: Flow<List<GameCard>>
        get() = cardDataSource.cardsStream

    override fun newGame() =
        cardDataSource.newGame()

    override fun getCards(): List<GameCard> =
        cardDataSource.getCards()

    override fun updateCard(card: GameCard) =
        cardDataSource.updateCard(card)
}
