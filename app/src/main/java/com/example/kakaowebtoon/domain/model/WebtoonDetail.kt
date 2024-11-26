package com.example.kakaowebtoon.domain.model

data class WebtoonDetail(
    val imageUrl: String,
    val title: String,
    val author: String,
    val genre: String,
    val viewCount: Int,
    val heartCount: Int,
    val coupon: Int,
    val promotion: String
)
