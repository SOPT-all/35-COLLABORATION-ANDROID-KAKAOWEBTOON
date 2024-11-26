package com.example.kakaowebtoon.data.dataremote.model.response

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class DayWebtoonsResponseDto(
    @SerialName("status") val status: Int,
    @SerialName("data") val data: DayWebtoonsData
)

@Serializable
data class DayWebtoonsData(
    @SerialName("webtoons") val webtoons: List<DayWebtoon>
)

@Serializable
data class DayWebtoon(
    @SerialName("id") val id: Int,
    @SerialName("title") val title: String,
    @SerialName("image") val image: String
)
