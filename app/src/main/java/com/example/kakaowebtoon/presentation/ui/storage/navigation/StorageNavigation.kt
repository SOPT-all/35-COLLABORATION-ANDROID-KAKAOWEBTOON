package com.example.kakaowebtoon.presentation.ui.storage.navigation

import androidx.compose.foundation.layout.PaddingValues
import androidx.navigation.NavController
import androidx.navigation.NavGraphBuilder
import androidx.navigation.NavOptions
import androidx.navigation.compose.composable
import com.example.kakaowebtoon.presentation.model.Route

fun NavController.navigateStorage(navOptions: NavOptions) {
    navigate(
        route = Route.Storage,
        navOptions = navOptions
    )
}

fun NavGraphBuilder.storageNavGraph(
    padding: PaddingValues
) {
    composable<Route.Storage> {
//        TODO: Route 마무리
//        StorageRoute(
//            padding = padding
//        )
    }
}
