package com.example.kakaowebtoon.presentation.ui.rank.navigation

import androidx.compose.foundation.layout.PaddingValues
import androidx.navigation.NavController
import androidx.navigation.NavGraphBuilder
import androidx.navigation.NavOptions
import androidx.navigation.compose.composable
import com.example.kakaowebtoon.presentation.model.Route
import com.example.kakaowebtoon.presentation.ui.rank.RankRoute

fun NavController.navigateRank(navOptions: NavOptions) {
    navigate(
        route = Route.Rank,
        navOptions = navOptions
    )
}

fun NavGraphBuilder.rankNavGraph(
    padding: PaddingValues
) {
    composable<Route.Rank> {
        RankRoute(padding = padding)
    }
}
