package com.example.kakaowebtoon.data.mapper

import com.example.kakaowebtoon.data.dataremote.model.response.DummyResponseDto
import com.example.kakaowebtoon.domain.model.DummyDataClass

fun DummyResponseDto.toDomainModel(): DummyDataClass {
    return DummyDataClass(
        description = this.dummy + "입니다 "
    )
}