package com.example.kakaowebtoon.data.dataremote.service

import com.example.kakaowebtoon.data.dataremote.model.response.DummyResponseDto
import retrofit2.http.POST

interface DummyService {
    @POST("/API")
    suspend fun funName(): List<DummyResponseDto>
}

