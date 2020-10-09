package com.jdscaram.suspeito.domain.usecases

import com.jdscaram.suspeito.data.repository.GameCardsRepository
import com.jdscaram.suspeito.domain.model.GameCard

class UpdateCardUseCase constructor(
    private val gameCardsRepository: GameCardsRepository,
) {

    operator fun invoke(card: GameCard) {
        gameCardsRepository.updateCard(card)
    }
}
