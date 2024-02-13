package com.lnoxx.animeapp.jikanAPI

import com.lnoxx.animeapp.jikanAPI.jikanDataClasses.AnimeDataResponse
import com.lnoxx.animeapp.jikanAPI.jikanDataClasses.AnimeTopResponse
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query

interface JikanAPI {
    @GET("top/anime")
    suspend fun getTopAnime(@Query("filter") filter: String): AnimeTopResponse
    @GET("anime/{id}/full")
    suspend fun getFullAnimeInfo(@Path("id") id: Int): AnimeDataResponse
}