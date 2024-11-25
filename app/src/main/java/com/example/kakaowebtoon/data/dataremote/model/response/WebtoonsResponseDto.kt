package com.example.kakaowebtoon.data.dataremote.model.response

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class WebtoonsResponseDto(
    @SerialName("status") val status: Int,
    @SerialName("data") val data: WebtoonsData
)

@Serializable
data class WebtoonsData(
    @SerialName("webtoons") val webtoons: List<Webtoon>
)

@Serializable
data class Webtoon(
    @SerialName("title") val title: String,
    @SerialName("author") val author: String,
    @SerialName("image") val image: String?,
    @SerialName("genre") val genre: String,
    @SerialName("promotion") val promotion: String
)
