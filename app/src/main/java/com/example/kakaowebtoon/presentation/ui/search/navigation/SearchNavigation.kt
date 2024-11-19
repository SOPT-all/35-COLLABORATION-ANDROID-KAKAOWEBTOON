package com.example.kakaowebtoon.presentation.ui.search.navigation

import androidx.compose.foundation.layout.PaddingValues
import androidx.navigation.NavController
import androidx.navigation.NavGraphBuilder
import androidx.navigation.compose.composable
import com.example.kakaowebtoon.presentation.model.Route

fun NavController.navigateSearch() {
    navigate(route = Route.Search)
}

fun NavGraphBuilder.searchNavGraph(
    padding: PaddingValues
) {
    composable<Route.Search> {
//        TODO: Route 마무리
//        SearchRoute(
//            padding = padding
//        )
    }
}
