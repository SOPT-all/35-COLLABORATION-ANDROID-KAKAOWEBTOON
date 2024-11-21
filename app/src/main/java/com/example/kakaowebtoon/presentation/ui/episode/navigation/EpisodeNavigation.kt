package com.example.kakaowebtoon.presentation.ui.episode.navigation

import androidx.compose.foundation.layout.PaddingValues
import androidx.navigation.NavController
import androidx.navigation.NavGraphBuilder
import androidx.navigation.compose.composable
import com.example.kakaowebtoon.presentation.model.Route
import com.example.kakaowebtoon.presentation.ui.episode.EpisodeRoute

fun NavController.navigateEpisode() {
    navigate(route = Route.Episode)
}

fun NavGraphBuilder.episodeNavGraph(
    padding: PaddingValues,
    popUpBackStack: () -> Unit
) {
    composable<Route.Episode> {
        EpisodeRoute(
            padding = padding,
            popUpBackStack = popUpBackStack
        )
    }
}
