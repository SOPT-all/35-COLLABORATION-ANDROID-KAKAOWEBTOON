package com.example.kakaowebtoon.data.mapper

import com.example.kakaowebtoon.data.dataremote.model.response.DailyWebtoon
import com.example.kakaowebtoon.data.dataremote.model.response.DummyResponseDto
import com.example.kakaowebtoon.domain.model.DummyData
import com.example.kakaowebtoon.domain.model.WebtoonCard

fun DummyResponseDto.toDomainModel(): DummyData {
    return DummyData(
        description = this.dummy + "입니다 "
    )
}

fun DailyWebtoon.toDomainModel(): WebtoonCard {
    return WebtoonCard(
        id = id,
        imageUrl = image,
        title = title,
        promotion = "",
        author = "",
        genre = ""
    )
}