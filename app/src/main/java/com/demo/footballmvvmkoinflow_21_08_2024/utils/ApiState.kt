package com.demo.footballmvvmkoinflow_21_08_2024.utils

import com.demo.footballmvvmkoinflow_21_08_2024.model.Football

sealed class ApiState {

    class Success(var data:Football):ApiState()
    class Failure(var msg:Throwable):ApiState()
    object Loading:ApiState()
    object Empty:ApiState()
}