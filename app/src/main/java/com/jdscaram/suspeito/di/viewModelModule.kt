package com.jdscaram.suspeito.di

import com.jdscaram.suspeito.ui.edit.EditViewModel
import com.jdscaram.suspeito.ui.main.MainViewModel
import org.koin.android.viewmodel.dsl.viewModel
import org.koin.dsl.module

val viewModelModule = module {
    viewModel { MainViewModel(get(), get(), get()) }
    viewModel { EditViewModel(get(), get()) }
}
