package com.example.kakaowebtoon.domain.repository

import com.example.kakaowebtoon.domain.model.DummyData

interface DummyRepository {
    suspend fun funName(): Result<List<DummyData>>
}
