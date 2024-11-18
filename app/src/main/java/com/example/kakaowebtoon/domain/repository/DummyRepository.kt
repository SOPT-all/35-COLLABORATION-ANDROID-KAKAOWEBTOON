package com.example.kakaowebtoon.domain.repository

import com.example.kakaowebtoon.domain.model.DummyDataClass

interface DummyRepository {
    suspend fun funName(): Result<List<DummyDataClass>>
}

