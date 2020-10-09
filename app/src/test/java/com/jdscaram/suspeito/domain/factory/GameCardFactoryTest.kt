package com.jdscaram.suspeito.domain.factory

import com.jdscaram.suspeito.domain.model.Card
import io.mockk.unmockkObject
import org.junit.Assert.assertEquals
import org.junit.Before
import org.junit.Test

class GameCardFactoryTest {

    @Before
    fun setUp() {
        unmockkObject(GameCardFactory)
    }

    @Test
    fun make_generateGameCardForAllCards() {
        val expectedResult = Card.values().toSet()

        val result = GameCardFactory.make().map { it.card }.toSet()

        assertEquals(expectedResult, result)
    }
}
