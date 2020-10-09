package com.jdscaram.suspeito.data.usecase

import com.jdscaram.suspeito.data.repository.GameCardsRepository
import com.jdscaram.suspeito.domain.model.Card
import com.jdscaram.suspeito.domain.model.GameCard

class GetGameCardUseCase constructor(
    private val gameCardsRepository: GameCardsRepository,
) {

    operator fun invoke(card: Card): GameCard? =
        gameCardsRepository.getCards().find { it.card == card }
}
