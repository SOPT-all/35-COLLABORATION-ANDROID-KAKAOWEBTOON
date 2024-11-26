package com.example.kakaowebtoon.domain.usecase

import com.example.kakaowebtoon.domain.model.WebtoonCard
import com.example.kakaowebtoon.domain.repository.WebtoonsRepository
import javax.inject.Inject

class GetDailyWebtoonUseCase @Inject constructor(
    private val webtoonsRepository: WebtoonsRepository
) {
    suspend operator fun invoke(
        day: String
    ): Result<List<WebtoonCard>> = webtoonsRepository.getDailyWebtoons(day = day)
}
