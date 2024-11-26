package com.example.kakaowebtoon.data.dataremote.model.response

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class DailyWebtoonResponseDto(
    @SerialName("status") val status: Int,
    @SerialName("data") val data: DailyWebtoonData
)

@Serializable
data class DailyWebtoonData(
    @SerialName("webtoons") val webtoons: List<DailyWebtoon>
)

@Serializable
data class DailyWebtoon(
    @SerialName("id") val id: Long,
    @SerialName("title") val title: String,
    @SerialName("image") val image: String
)
