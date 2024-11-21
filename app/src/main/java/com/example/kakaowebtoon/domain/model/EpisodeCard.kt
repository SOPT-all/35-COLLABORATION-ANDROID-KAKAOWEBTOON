package com.example.kakaowebtoon.domain.model

import java.util.Date

data class EpisodeCard(
    val imageUrl: String,
    val index: Int,
    val title: String,
    val status: Int,
    val date: String,
    val dayUntilFree: Int
)
