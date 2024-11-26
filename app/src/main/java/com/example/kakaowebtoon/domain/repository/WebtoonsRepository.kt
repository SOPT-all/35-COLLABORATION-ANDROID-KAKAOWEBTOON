package com.example.kakaowebtoon.domain.repository

import com.example.kakaowebtoon.data.dataremote.model.response.WebtoonsResponseDto
import com.example.kakaowebtoon.domain.model.WebtoonCard

interface WebtoonsRepository {
    suspend fun searchWebtoons(title: String): Result<WebtoonsResponseDto>

    suspend fun recentWebtoons(): Result<WebtoonsResponseDto>

    suspend fun getDailyWebtoons(day: String): Result<List<WebtoonCard>>
}
