package com.demo.footballmvvmkoinflow_21_08_2024.di

import com.demo.footballmvvmkoinflow_21_08_2024.repository.FootballRepository
import com.demo.footballmvvmkoinflow_21_08_2024.viewmodel.FootballViewModel
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module

var dataModule = module {
    factory { FootballRepository(apiService = get())  }
}

var viewmodelModule = module {
    viewModel {
        FootballViewModel(footballRepository = get())
    }
}