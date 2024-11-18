package com.example.kakaowebtoon.data.dataremote.model.response

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class DummyResponseDto(
    @SerialName("dummy")
    val dummy: String,
)
