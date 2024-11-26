package com.example.kakaowebtoon.domain.usecase

import com.example.kakaowebtoon.domain.repository.WebtoonsRepository
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class SearchWebtoonsUseCase @Inject constructor(
    private val webtoonsRepository: WebtoonsRepository
) {
    suspend operator fun invoke(title: String) = webtoonsRepository.searchWebtoons(title = title)
}
