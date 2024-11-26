package com.example.kakaowebtoon.domain.model

data class WebtoonCard(
    val id: Long = 0L,
    val imageUrl: String,
    val title: String,
    val promotion: String,
    val author: String,
    val genre: String
)
