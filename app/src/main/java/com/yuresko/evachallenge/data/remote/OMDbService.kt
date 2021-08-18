package com.yuresko.evachallenge.data.remote

import androidx.annotation.IntRange
import com.yuresko.evachallenge.data.models.ResponseMovieDetail
import com.yuresko.evachallenge.data.models.ResponseSearchMovie
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Query

interface OMDbService {

    @GET("?type=movie")
    suspend fun getSearchResultData(
        @Query(value = "s") searchTitle: String,
        @Query(value = "apiKey") apiKey: String,
        @Query(value = "page") @IntRange(from = 1) page: Int = 1
    ): Response<ResponseSearchMovie>

    @GET("?plot=full")
    suspend fun getMovieDetailData(
        @Query(value = "t") title: String,
        @Query(value = "apiKey") apiKey: String
    ): Response<ResponseMovieDetail>
}