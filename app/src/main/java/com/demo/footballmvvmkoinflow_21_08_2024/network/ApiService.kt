package com.demo.footballmvvmkoinflow_21_08_2024.network

import com.demo.footballmvvmkoinflow_21_08_2024.model.Football
import retrofit2.http.GET

interface ApiService {

   //http://api.football-data.org/v4/competitions/

        @GET("v4/competitions/")
        suspend fun getFootball():Football
}