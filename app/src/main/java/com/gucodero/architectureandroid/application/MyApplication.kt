package com.gucodero.architectureandroid.application

import android.app.Application
import org.koin.core.context.startKoin

class MyApplication: Application() {

    override fun onCreate() {
        super.onCreate()
        initKoin()
    }

    private fun initKoin(){
        startKoin {

        }
    }

}