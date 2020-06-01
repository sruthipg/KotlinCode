package com.example.whiterabittest

import android.app.Application
import com.example.whiterabittest.db.UserDataBase
import com.example.whiterabittest.network.MyApi
import com.example.whiterabittest.network.NetworkConnectionInterceptor
import com.example.whiterabittest.repository.HomeRepository
import com.example.whiterabittest.viewmodel.HomeViewModelFactory
import org.kodein.di.Kodein
import org.kodein.di.KodeinAware
import org.kodein.di.android.x.androidXModule
import org.kodein.di.generic.bind
import org.kodein.di.generic.instance
import org.kodein.di.generic.provider
import org.kodein.di.generic.singleton

class MyApp : Application(), KodeinAware {

    override val kodein = Kodein.lazy {
        import(androidXModule(this@MyApp))

        bind() from singleton { NetworkConnectionInterceptor(instance()) }
        bind() from singleton { MyApi(instance()) }
        bind() from singleton { UserDataBase(instance()) }
        bind() from singleton { HomeRepository(instance(), instance()) }
        bind() from provider { HomeViewModelFactory(instance()) }
    }
}