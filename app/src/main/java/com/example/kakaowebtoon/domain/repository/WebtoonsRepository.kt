package com.example.kakaowebtoon.domain.repository

import com.example.kakaowebtoon.data.dataremote.model.response.WebtoonsResponseDto

interface WebtoonsRepository {
    suspend fun searchWebtoons(title: String): Result<WebtoonsResponseDto>

    suspend fun recentWebtoons(): Result<WebtoonsResponseDto>
}
