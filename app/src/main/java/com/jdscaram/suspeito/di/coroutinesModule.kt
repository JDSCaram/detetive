package com.jdscaram.suspeito.di

import com.jdscaram.suspeito.core.DefaultDispatcherProvider
import com.jdscaram.suspeito.core.DispatcherProvider
import org.koin.dsl.module

val coroutinesModule = module {
    factory<DispatcherProvider> { DefaultDispatcherProvider }
}
