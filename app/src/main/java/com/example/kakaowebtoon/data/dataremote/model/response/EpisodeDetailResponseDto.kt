package com.example.kakaowebtoon.data.dataremote.model.response

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class EpisodeDetailResponseDto(
    @SerialName("status")
    val status: Int,
    @SerialName("data")
    val data: EpisodeDetailData
)

@Serializable
data class EpisodeDetailData(
    @SerialName("title")
    val title: String,
    @SerialName("author")
    val author: String,
    @SerialName("genre")
    val genre: String,
    @SerialName("viewCount")
    val viewCount: Int,
    @SerialName("heartCount")
    val heartCount: Int,
    @SerialName("image")
    val image: String,
    @SerialName("coupon")
    val coupon: Int,
    @SerialName("promotion")
    val promotion: String
)
