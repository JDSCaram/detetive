package com.jdscaram.suspeito.data.usecase

import com.jdscaram.suspeito.data.repository.GameCardsRepository
import com.jdscaram.suspeito.domain.usecases.UpdateCardUseCase
import com.jdscaram.suspeito.factory.GameCardTestFactory
import io.mockk.Runs
import io.mockk.every
import io.mockk.just
import io.mockk.mockk
import io.mockk.verify
import org.junit.Test

class UpdateCardUseCaseTest {

    private val gameCardsRepository: GameCardsRepository = mockk()
    private val subject = UpdateCardUseCase(gameCardsRepository)

    @Test
    fun invoke_callRepository() {
        val gameCard = GameCardTestFactory.randomCard()
        mock()

        subject.invoke(gameCard)

        verify(exactly = 1) { gameCardsRepository.updateCard(gameCard) }
    }

    private fun mock() {
        every { gameCardsRepository.updateCard(any()) } just Runs
    }
}
