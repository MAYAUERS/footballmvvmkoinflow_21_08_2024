package com.demo.footballmvvmkoinflow_21_08_2024.di

import org.koin.core.context.loadKoinModules

object LoadAllModules {
    fun init() = loadKoinModules(listOf(networkModule, dataModule, viewmodelModule))
}