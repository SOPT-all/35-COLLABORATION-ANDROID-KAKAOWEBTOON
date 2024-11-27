package com.example.kakaowebtoon.domain.repository

import com.example.kakaowebtoon.data.dataremote.model.response.EpisodeDetailResponseDto
import com.example.kakaowebtoon.data.dataremote.model.response.EpisodesResponseDto

interface EpisodeRepository {
    suspend fun episodeDetail(webtoonId: Int): Result<EpisodeDetailResponseDto>
    suspend fun episodes(webtoonId: Int): Result<EpisodesResponseDto>
}
