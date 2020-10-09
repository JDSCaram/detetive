package com.jdscaram.suspeito.di

import com.jdscaram.suspeito.data.repository.GameCardsRepository
import com.jdscaram.suspeito.data.repository.impl.GameCardsDefaultRepository
import org.koin.dsl.module

val repositoryModule = module {
    factory<GameCardsRepository> { GameCardsDefaultRepository(get()) }
}
