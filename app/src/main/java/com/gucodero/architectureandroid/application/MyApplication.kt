package com.gucodero.architectureandroid.application

import android.app.Application
import com.gucodero.data.di.dataModule
import com.gucodero.domain.di.domainModule
import org.koin.android.ext.koin.androidContext
import org.koin.core.context.loadKoinModules
import org.koin.core.context.startKoin

class MyApplication: Application() {

    override fun onCreate() {
        super.onCreate()
        initKoin()
    }

    private fun initKoin(){
        startKoin {
            androidContext(this@MyApplication)
            loadKoinModules(listOf(domainModule, dataModule))
        }
    }

}