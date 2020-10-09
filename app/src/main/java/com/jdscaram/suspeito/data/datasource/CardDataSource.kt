package com.jdscaram.suspeito.data.datasource

import com.jdscaram.suspeito.domain.model.GameCard
import kotlinx.coroutines.flow.Flow

interface CardDataSource {
    val cardsStream: Flow<List<GameCard>>

    fun newGame()
    fun getCards(): List<GameCard>
    fun updateCard(updatedCard: GameCard)
}
