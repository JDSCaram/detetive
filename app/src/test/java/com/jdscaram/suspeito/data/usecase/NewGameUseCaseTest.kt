package com.jdscaram.suspeito.data.usecase

import com.jdscaram.suspeito.data.repository.GameCardsRepository
import com.jdscaram.suspeito.domain.usecases.NewGameUseCase
import io.mockk.Runs
import io.mockk.every
import io.mockk.just
import io.mockk.mockk
import io.mockk.verify
import org.junit.Test

class NewGameUseCaseTest {

    private val gameCardsRepository: GameCardsRepository = mockk()
    private val subject = NewGameUseCase(gameCardsRepository)

    @Test
    fun invoke_callRepository() {
        mock()

        subject.invoke()

        verify(exactly = 1) { gameCardsRepository.newGame() }
    }

    private fun mock() {
        every { gameCardsRepository.newGame() } just Runs
    }
}
