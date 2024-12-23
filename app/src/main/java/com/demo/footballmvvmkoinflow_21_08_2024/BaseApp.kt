package com.demo.footballmvvmkoinflow_21_08_2024

import android.app.Application
import com.demo.footballmvvmkoinflow_21_08_2024.di.LoadAllModules
import org.koin.core.context.startKoin

class BaseApp:Application() {
    override fun onCreate() {
        super.onCreate()

        startKoin {
            LoadAllModules.init()
        }
    }
}