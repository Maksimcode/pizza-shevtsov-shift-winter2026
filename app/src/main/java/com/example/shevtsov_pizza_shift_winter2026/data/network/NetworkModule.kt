package com.example.shevtsov_pizza_shift_winter2026.data.network

import com.example.shevtsov_pizza_shift_winter2026.data.api.PizzaApiService
import com.example.shevtsov_pizza_shift_winter2026.data.repository.PizzaRepositoryImpl
import com.example.shevtsov_pizza_shift_winter2026.domain.repository.PizzaRepository
import com.example.shevtsov_pizza_shift_winter2026.domain.usecase.GetPizzasUseCase
import com.google.gson.Gson
import com.google.gson.GsonBuilder
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import java.util.concurrent.TimeUnit

private const val BASE_URL = "https://shift-intensive.ru/api/pizza/"
private const val CONNECT_TIMEOUT = 10L
private const val WRITE_TIMEOUT = 10L
private const val READ_TIMEOUT = 10L

object NetworkModule {

    private val gson: Gson = GsonBuilder()
        .setLenient()
        .create()

    private val httpLoggingInterceptor = HttpLoggingInterceptor().apply {
        level = HttpLoggingInterceptor.Level.BODY
    }

    private val okHttpClient = OkHttpClient.Builder()
        .addInterceptor(httpLoggingInterceptor)
        .connectTimeout(CONNECT_TIMEOUT, TimeUnit.SECONDS)
        .readTimeout(READ_TIMEOUT, TimeUnit.SECONDS)
        .writeTimeout(WRITE_TIMEOUT, TimeUnit.SECONDS)
        .build()

    val retrofit: Retrofit = Retrofit.Builder()
        .client(okHttpClient)
        .baseUrl(BASE_URL)
        .addConverterFactory(GsonConverterFactory.create(gson))
        .build()

    private val pizzaApi: PizzaApiService = retrofit.create(PizzaApiService::class.java)
    private val pizzaRepository: PizzaRepository = PizzaRepositoryImpl(pizzaApi)
    val getPizzasUseCase = GetPizzasUseCase(pizzaRepository)
}
