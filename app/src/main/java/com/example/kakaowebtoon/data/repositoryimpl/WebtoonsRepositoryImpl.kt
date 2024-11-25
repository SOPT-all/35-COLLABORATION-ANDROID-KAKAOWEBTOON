package com.example.kakaowebtoon.data.repositoryimpl

import com.example.kakaowebtoon.data.dataremote.datasource.WebtoonsRemoteDataSource
import com.example.kakaowebtoon.data.dataremote.model.response.WebtoonsResponseDto
import com.example.kakaowebtoon.domain.repository.WebtoonsRepository
import jakarta.inject.Inject

class WebtoonsRepositoryImpl @Inject constructor(
    private val webtoonsRemoteDataSource: WebtoonsRemoteDataSource
) : WebtoonsRepository {
    override suspend fun searchWebtoons(title: String): Result<WebtoonsResponseDto> = runCatching {
        webtoonsRemoteDataSource.searchWebtoons(title = title)
    }

    override suspend fun recentWebtoons(): Result<WebtoonsResponseDto> = runCatching {
        webtoonsRemoteDataSource.recentWebtoons()
    }
}
