package com.example.kakaowebtoon.data.dataremote.datasourceimpl

import com.example.kakaowebtoon.data.dataremote.datasource.WebtoonsRemoteDataSource
import com.example.kakaowebtoon.data.dataremote.model.response.DailyWebtoonResponseDto
import com.example.kakaowebtoon.data.dataremote.model.response.WebtoonsResponseDto
import com.example.kakaowebtoon.data.dataremote.service.WebtoonsService
import javax.inject.Inject

class WebtoonsRemoteDataSourceImpl @Inject constructor(
    private val service: WebtoonsService
) : WebtoonsRemoteDataSource {
    override suspend fun searchWebtoons(title: String): WebtoonsResponseDto =
        service.searchWebtoons(title = title)

    override suspend fun recentWebtoons(): WebtoonsResponseDto = service.recentWebtoons()

    override suspend fun getDailyWebtoons(
        day: String
    ): DailyWebtoonResponseDto = service.getDailyWebtoons(day = day)
}
