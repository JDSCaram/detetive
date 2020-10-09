package com.jdscaram.suspeito.data.repository

import com.jdscaram.suspeito.domain.model.GameCard
import kotlinx.coroutines.flow.Flow

interface GameCardsRepository {

    val cardsStream: Flow<List<GameCard>>

    fun newGame()
    fun getCards(): List<GameCard>
    fun updateCard(card: GameCard)
}
