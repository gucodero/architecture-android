package com.gucodero.architectureandroid.application

import android.app.Application
import com.gucodero.architectureandroid.test.main.MainViewModel
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.core.context.loadKoinModules
import org.koin.core.context.startKoin
import org.koin.dsl.module

class MyApplication: Application() {

    override fun onCreate() {
        super.onCreate()
        initKoin()
    }

    private fun initKoin(){
        startKoin {
            loadKoinModules(module { viewModel { MainViewModel() } })
        }
    }

}