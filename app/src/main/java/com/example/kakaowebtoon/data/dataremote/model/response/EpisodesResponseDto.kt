package com.example.kakaowebtoon.data.dataremote.model.response

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class EpisodesResponseDto(
    @SerialName("status")
    val status: Int,
    @SerialName("data")
    val data: EpisodesData
)

@Serializable
data class EpisodesData(
    @SerialName("episodes")
    val episodes: List<Episode>
)

@Serializable
data class Episode(
    @SerialName("turn")
    val turn: Int,
    @SerialName("image")
    val image: String,
    @SerialName("title")
    val title: String,
    @SerialName("status")
    val status: Int,
    @SerialName("date")
    val date: String,
    @SerialName("dayUntilFree")
    val dayUntilFree: Int
)