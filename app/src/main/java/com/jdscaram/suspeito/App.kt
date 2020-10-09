package com.jdscaram.suspeito

import android.app.Application
import com.orhanobut.hawk.Hawk
import com.jdscaram.suspeito.di.cacheModule
import com.jdscaram.suspeito.di.coroutinesModule
import com.jdscaram.suspeito.di.dataSourceModule
import com.jdscaram.suspeito.di.repositoryModule
import com.jdscaram.suspeito.di.useCaseModule
import com.jdscaram.suspeito.di.viewModelModule
import kotlinx.coroutines.ExperimentalCoroutinesApi
import org.koin.android.ext.koin.androidContext
import org.koin.core.context.startKoin

@ExperimentalCoroutinesApi
class App : Application() {

    override fun onCreate() {
        super.onCreate()

        Hawk.init(applicationContext).build()

        startKoin {
            androidContext(this@App)
            modules(
                coroutinesModule,
                cacheModule,
                dataSourceModule,
                repositoryModule,
                useCaseModule,
                viewModelModule
            )
        }
    }
}
