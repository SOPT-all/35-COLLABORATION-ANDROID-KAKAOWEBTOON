package com.example.kakaowebtoon.presentation.ui.home.navigation

import androidx.compose.foundation.layout.PaddingValues
import androidx.navigation.NavController
import androidx.navigation.NavGraphBuilder
import androidx.navigation.NavOptions
import androidx.navigation.compose.composable
import com.example.kakaowebtoon.presentation.model.Route
import com.example.kakaowebtoon.presentation.ui.home.HomeRoute

fun NavController.navigateHome(navOptions: NavOptions) {
    navigate(
        route = Route.Home,
        navOptions = navOptions
    )
}

fun NavGraphBuilder.homeNavGraph(
    padding: PaddingValues,
    onNavigateToSearch: () -> Unit
) {
    composable<Route.Home> {
        HomeRoute(
            padding = padding,
            onNavigateToSearch = onNavigateToSearch
        )
    }
}
