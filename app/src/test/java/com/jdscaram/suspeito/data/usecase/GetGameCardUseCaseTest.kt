package com.jdscaram.suspeito.data.usecase

import com.jdscaram.suspeito.data.repository.GameCardsRepository
import com.jdscaram.suspeito.domain.model.Card
import com.jdscaram.suspeito.domain.model.GameCard
import io.mockk.every
import io.mockk.mockk
import io.mockk.verify
import org.junit.Assert.assertEquals
import org.junit.Assert.assertNull
import org.junit.Test

class GetGameCardUseCaseTest {
    private val gameCardsRepository: GameCardsRepository = mockk()
    private val subject = GetGameCardUseCase(gameCardsRepository)

    @Test
    fun invoke_getCardsFromRepository() {
        mock()

        subject.invoke(Card.values().random())

        verify { gameCardsRepository.getCards() }
    }

    @Test
    fun invoke_withExistingCard_returnsIt() {
        val card = Card.values().random()
        val expectedResult = GameCard(card = card)
        mock(cards = listOf(expectedResult))

        val result = subject.invoke(card)

        assertEquals(expectedResult, result)
    }

    @Test
    fun invoke_withNotExistingCard_returnsNull() {
        mock(cards = listOf(GameCard(card = Card.GUN)))

        val result = subject.invoke(Card.BALCONY)

        assertNull(result)
    }

    private fun mock(
        cards: List<GameCard> = emptyList(),
    ) {
        every { gameCardsRepository.getCards() } returns cards
    }
}
