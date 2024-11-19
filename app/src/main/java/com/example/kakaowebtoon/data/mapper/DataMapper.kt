package com.example.kakaowebtoon.data.mapper

import com.example.kakaowebtoon.data.dataremote.model.response.DummyResponseDto
import com.example.kakaowebtoon.domain.model.DummyData

fun DummyResponseDto.toDomainModel(): DummyData {
    return DummyData(
        description = this.dummy + "입니다 "
    )
}
