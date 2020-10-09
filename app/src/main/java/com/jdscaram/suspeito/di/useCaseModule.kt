package com.jdscaram.suspeito.di

import com.jdscaram.suspeito.data.usecase.GetCardsUseCase
import com.jdscaram.suspeito.data.usecase.GetGameCardUseCase
import com.jdscaram.suspeito.domain.usecases.NewGameUseCase
import com.jdscaram.suspeito.domain.usecases.UpdateCardUseCase
import org.koin.dsl.module

val useCaseModule = module {
    factory { GetCardsUseCase(get()) }
    factory { NewGameUseCase(get()) }
    factory { UpdateCardUseCase(get()) }
    factory { GetGameCardUseCase(get()) }
}
