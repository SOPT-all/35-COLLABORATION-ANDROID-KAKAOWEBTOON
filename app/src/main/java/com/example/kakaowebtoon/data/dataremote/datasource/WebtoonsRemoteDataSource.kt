package com.example.kakaowebtoon.data.dataremote.datasource

import com.example.kakaowebtoon.data.dataremote.model.response.DailyWebtoonResponseDto
import com.example.kakaowebtoon.data.dataremote.model.response.WebtoonsResponseDto

interface WebtoonsRemoteDataSource {
    suspend fun searchWebtoons(title: String): WebtoonsResponseDto

    suspend fun recentWebtoons(): WebtoonsResponseDto

    suspend fun getDailyWebtoons(day: String): DailyWebtoonResponseDto
}
