package com.example.kakaowebtoon.data.repositoryimpl

import com.example.kakaowebtoon.data.dataremote.datasource.EpisodeRemoteDataSource
import com.example.kakaowebtoon.data.dataremote.model.response.EpisodeDetailResponseDto
import com.example.kakaowebtoon.data.dataremote.model.response.EpisodesResponseDto
import com.example.kakaowebtoon.domain.repository.EpisodeRepository
import javax.inject.Inject

class EpisodeRepositoryImpl @Inject constructor(
    private val episodeRemoteDataSource: EpisodeRemoteDataSource
) : EpisodeRepository {
    override suspend fun episodeDetail(webtoonId: Int): Result<EpisodeDetailResponseDto> = runCatching {
        episodeRemoteDataSource.episodeDetail(webtoonId)
    }

    override suspend fun episodes(webtoonId: Int): Result<EpisodesResponseDto> = runCatching {
        episodeRemoteDataSource.episodes(webtoonId)
    }
}
