package com.example.kakaowebtoon.data.dataremote.datasource

import com.example.kakaowebtoon.data.dataremote.model.response.EpisodeDetailResponseDto

interface EpisodeRemoteDataSource {
    suspend fun episodeDetail(webtoonId: Int): EpisodeDetailResponseDto
}
