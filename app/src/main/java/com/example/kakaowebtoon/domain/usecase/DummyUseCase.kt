package com.example.kakaowebtoon.domain.usecase

import com.example.kakaowebtoon.domain.repository.DummyRepository
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class DummyUseCase @Inject constructor(
    private val dummyRepository: DummyRepository
) {
    suspend operator fun invoke() = dummyRepository.funName()
}
