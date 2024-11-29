package com.example.kakaowebtoon.data.mapper

import com.example.kakaowebtoon.data.dataremote.model.response.DailyWebtoon
import com.example.kakaowebtoon.domain.model.WebtoonCard

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
