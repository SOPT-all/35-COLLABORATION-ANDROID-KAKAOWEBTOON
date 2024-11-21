package com.example.kakaowebtoon.presentation.ui.gift.navigation

import androidx.compose.foundation.layout.PaddingValues
import androidx.navigation.NavController
import androidx.navigation.NavGraphBuilder
import androidx.navigation.NavOptions
import androidx.navigation.compose.composable
import com.example.kakaowebtoon.presentation.model.Route
import com.example.kakaowebtoon.presentation.ui.gift.GiftRoute

fun NavController.navigateGift(navOptions: NavOptions) {
    navigate(
        route = Route.Gift,
        navOptions = navOptions
    )
}

fun NavGraphBuilder.giftNavGraph(
    padding: PaddingValues,
    onNavigateToEpisode: () -> Unit
) {
    composable<Route.Gift> {
        GiftRoute(
            padding = padding,
            onNavigateToEpisode = onNavigateToEpisode
        )
    }
}
