package com.jdscaram.suspeito.domain.usecases

import com.jdscaram.suspeito.data.repository.GameCardsRepository

class NewGameUseCase constructor(
    private val gameCardsRepository: GameCardsRepository,
) {

    operator fun invoke() {
        gameCardsRepository.newGame()
    }
}
