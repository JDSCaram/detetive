package com.jdscaram.suspeito.data.usecase

import com.jdscaram.suspeito.data.repository.GameCardsRepository
import com.jdscaram.suspeito.domain.model.GameCard
import kotlinx.coroutines.flow.Flow

class GetCardsUseCase constructor(
    private val gameCardsRepository: GameCardsRepository,
) {

    operator fun invoke(): Flow<List<GameCard>> {
        if (gameCardsRepository.getCards().isEmpty()) {
            gameCardsRepository.newGame()
        }

        return gameCardsRepository.cardsStream
    }
}
