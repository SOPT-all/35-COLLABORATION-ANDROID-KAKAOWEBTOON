package com.example.kakaowebtoon.data.dataremote.datasourceimpl

import com.example.kakaowebtoon.data.dataremote.datasource.DummyRemoteDataSource
import com.example.kakaowebtoon.data.dataremote.model.response.DummyResponseDto
import com.example.kakaowebtoon.data.dataremote.service.DummyService
import javax.inject.Inject

class DummyRemoteDataSourceImpl @Inject constructor(
    private val service: DummyService
) : DummyRemoteDataSource {
    override suspend fun funName(): List<DummyResponseDto> = service.funName()
}
