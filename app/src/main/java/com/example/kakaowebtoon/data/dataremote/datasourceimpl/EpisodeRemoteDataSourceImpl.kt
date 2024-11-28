package com.example.kakaowebtoon.data.dataremote.datasourceimpl

import com.example.kakaowebtoon.data.dataremote.datasource.EpisodeRemoteDataSource
import com.example.kakaowebtoon.data.dataremote.model.response.EpisodeDetailResponseDto
import com.example.kakaowebtoon.data.dataremote.model.response.EpisodesResponseDto
import com.example.kakaowebtoon.data.dataremote.service.EpisodeService
import javax.inject.Inject

class EpisodeRemoteDataSourceImpl @Inject constructor(
    private val service: EpisodeService
) : EpisodeRemoteDataSource {
    override suspend fun episodeDetail(webtoonId: Int): EpisodeDetailResponseDto =
        service.episodeDetail(webtoonId)

    override suspend fun episodes(webtoonId: Int): EpisodesResponseDto =
        service.episodes(webtoonId)
}
