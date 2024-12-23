package com.demo.footballmvvmkoinflow_21_08_2024.viewmodel

import androidx.lifecycle.ViewModel
import com.demo.footballmvvmkoinflow_21_08_2024.repository.FootballRepository
import com.demo.footballmvvmkoinflow_21_08_2024.utils.ApiState
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.catch
import kotlinx.coroutines.flow.map
import kotlinx.coroutines.flow.onStart

class FootballViewModel(private val footballRepository: FootballRepository):ViewModel() {

    var footballFlow:Flow<ApiState> = footballRepository.getFootballData().map {
        ApiState.Success(it)
    }.catch { ApiState.Failure(it)
    }.onStart { ApiState.Loading }
}