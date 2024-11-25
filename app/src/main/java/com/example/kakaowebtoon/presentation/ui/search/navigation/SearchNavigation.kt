package com.example.kakaowebtoon.presentation.ui.search.navigation

import androidx.compose.foundation.layout.PaddingValues
import androidx.navigation.NavController
import androidx.navigation.NavGraphBuilder
import androidx.navigation.compose.composable
import com.example.kakaowebtoon.presentation.model.Route
import com.example.kakaowebtoon.presentation.ui.search.SearchRoute

fun NavController.navigateSearch() {
    navigate(route = Route.Search)
}

fun NavGraphBuilder.searchNavGraph(
    padding: PaddingValues,
    popUpBackStack: () -> Unit
) {
    composable<Route.Search> {
        SearchRoute(
            padding = padding,
            popUpBackStack = popUpBackStack
        )
    }
}
