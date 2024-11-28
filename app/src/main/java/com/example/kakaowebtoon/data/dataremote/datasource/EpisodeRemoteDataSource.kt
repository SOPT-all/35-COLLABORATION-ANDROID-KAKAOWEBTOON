package com.example.kakaowebtoon.data.dataremote.datasource

import com.example.kakaowebtoon.data.dataremote.model.response.EpisodeDetailResponseDto
import com.example.kakaowebtoon.data.dataremote.model.response.EpisodesResponseDto

interface EpisodeRemoteDataSource {
    suspend fun episodeDetail(webtoonId: Int): EpisodeDetailResponseDto
    suspend fun episodes(webtoonId: Int): EpisodesResponseDto
}
