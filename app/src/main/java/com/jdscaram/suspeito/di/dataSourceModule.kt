package com.jdscaram.suspeito.di

import com.jdscaram.suspeito.data.datasource.CardDataSource
import com.jdscaram.suspeito.data.datasource.impl.CardsLocalDataSource
import kotlinx.coroutines.ExperimentalCoroutinesApi
import org.koin.core.qualifier.named
import org.koin.dsl.module

@ExperimentalCoroutinesApi
val dataSourceModule = module {
    single<CardDataSource> { CardsLocalDataSource(get(named(CacheNames.CARDS))) }
}
