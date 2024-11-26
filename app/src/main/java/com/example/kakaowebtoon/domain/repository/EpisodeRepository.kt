package com.example.kakaowebtoon.domain.repository

import com.example.kakaowebtoon.data.dataremote.model.response.EpisodeDetailResponseDto

interface EpisodeRepository {
    suspend fun episodeDetail(webtoonId: Int): Result<EpisodeDetailResponseDto>
}
