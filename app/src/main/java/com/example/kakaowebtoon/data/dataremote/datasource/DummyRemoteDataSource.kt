package com.example.kakaowebtoon.data.dataremote.datasource

import com.example.kakaowebtoon.data.dataremote.model.response.DummyResponseDto

interface DummyRemoteDataSource {
    suspend fun funName(): List<DummyResponseDto>
}
