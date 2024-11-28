package com.example.kakaowebtoon.domain.usecase

import com.example.kakaowebtoon.domain.repository.EpisodeRepository
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class EpisodesUseCase @Inject constructor(
    private val episodeRepository: EpisodeRepository
) {
    suspend operator fun invoke(webtoonId: Int) = episodeRepository.episodes(webtoonId)
}
