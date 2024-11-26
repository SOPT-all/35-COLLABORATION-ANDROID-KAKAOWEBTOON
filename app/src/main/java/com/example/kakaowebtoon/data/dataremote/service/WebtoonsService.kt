package com.example.kakaowebtoon.data.dataremote.service

import com.example.kakaowebtoon.data.dataremote.model.response.DailyWebtoonResponseDto
import com.example.kakaowebtoon.data.dataremote.model.response.WebtoonsResponseDto
import retrofit2.http.GET
import retrofit2.http.Query

interface WebtoonsService {
    @GET("/api/v1/webtoons/search")
    suspend fun searchWebtoons(
        @Query("title") title: String
    ): WebtoonsResponseDto

    @GET("/api/v1/webtoons/recent")
    suspend fun recentWebtoons(): WebtoonsResponseDto

    @GET("/api/v1/webtoons")
    suspend fun getDailyWebtoons(
        @Query("day") day: String
    ): DailyWebtoonResponseDto
}
