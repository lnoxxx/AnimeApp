package com.lnoxx.animeapp.jikanAPI

import com.lnoxx.animeapp.jikanAPI.jikanDataClasses.AnimeTopResponse
import retrofit2.http.GET
import retrofit2.http.Query

interface JikanAPI {
    @GET("top/anime")
    suspend fun getTopAnime(@Query("filter") filter: String): AnimeTopResponse
}