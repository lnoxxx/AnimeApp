package com.lnoxx.animeapp.jikanAPI

import com.lnoxx.animeapp.jikanAPI.jikanDataClasses.AnimeTopResponse
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class JikanMainClass {
    private val loggingInterceptor = HttpLoggingInterceptor()
    init {
        loggingInterceptor.level = HttpLoggingInterceptor.Level.BODY
    }
    private val client = OkHttpClient.Builder().addInterceptor(loggingInterceptor).build()
    private val retrofit = Retrofit.Builder()
        .baseUrl("https://api.jikan.moe/v4/")
        .client(client)
        .addConverterFactory(GsonConverterFactory.create())
        .build()
    private val jikanAPI = retrofit.create(JikanAPI::class.java)

    suspend fun getAnimeTop(filter: String): AnimeTopResponse{
        return jikanAPI.getTopAnime(filter)
    }
}