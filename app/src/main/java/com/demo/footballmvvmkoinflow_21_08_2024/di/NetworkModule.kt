package com.demo.footballmvvmkoinflow_21_08_2024.di

import com.demo.footballmvvmkoinflow_21_08_2024.network.ApiService
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import org.koin.dsl.module
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

var networkModule = module {
    single { provideRetrofit(okHttpClient = get()) }
    factory { provideOkHttpClient(httpLoggingInterceptor = get()) }
    factory { provideApiService(retrofit = get()) }
    factory { HttpLoggingInterceptor() }
}

fun provideRetrofit(okHttpClient: OkHttpClient) :Retrofit = Retrofit.Builder()
    .baseUrl("https://api.football-data.org/")
    .addConverterFactory(GsonConverterFactory.create())
    .client(okHttpClient)
    .build()

fun provideOkHttpClient(httpLoggingInterceptor: HttpLoggingInterceptor):OkHttpClient =
    OkHttpClient.Builder()
    .addInterceptor(httpLoggingInterceptor.setLevel(HttpLoggingInterceptor.Level.BODY))
    .build()

fun provideApiService(retrofit: Retrofit):ApiService = retrofit.create(ApiService::class.java)