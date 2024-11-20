package com.example.kakaowebtoon.presentation.model

import kotlinx.serialization.Serializable

sealed interface Route {
    @Serializable
    data object Home : Route

    @Serializable
    data object Rank : Route

    @Serializable
    data object Gift : Route

    @Serializable
    data object Storage : Route

    @Serializable
    data object Search : Route

    @Serializable
    data object Episode : Route
}
