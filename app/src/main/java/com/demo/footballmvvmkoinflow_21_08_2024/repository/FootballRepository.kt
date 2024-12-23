package com.demo.footballmvvmkoinflow_21_08_2024.repository

import com.demo.footballmvvmkoinflow_21_08_2024.model.Football
import com.demo.footballmvvmkoinflow_21_08_2024.network.ApiService
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.flowOn

class FootballRepository(private var apiService: ApiService) {

    fun getFootballData() : Flow<Football> = flow {
        var result = apiService.getFootball()
        emit(result)
    }.flowOn(Dispatchers.IO)
}