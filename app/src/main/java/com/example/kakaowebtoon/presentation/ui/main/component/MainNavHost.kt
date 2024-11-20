package com.example.kakaowebtoon.presentation.ui.main.component

import androidx.compose.animation.EnterTransition
import androidx.compose.animation.ExitTransition
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.compose.NavHost
import com.example.kakaowebtoon.presentation.ui.episode.navigation.episodeNavGraph
import com.example.kakaowebtoon.presentation.ui.gift.navigation.giftNavGraph
import com.example.kakaowebtoon.presentation.ui.home.navigation.homeNavGraph
import com.example.kakaowebtoon.presentation.ui.main.MainNavigator
import com.example.kakaowebtoon.presentation.ui.rank.navigation.rankNavGraph
import com.example.kakaowebtoon.presentation.ui.search.navigation.searchNavGraph
import com.example.kakaowebtoon.presentation.ui.storage.navigation.storageNavGraph
import com.example.kakaowebtoon.ui.theme.KakaoWebtoonTheme

@Composable
fun MainNavHost(
    navigator: MainNavigator,
    padding: PaddingValues
) {
    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(KakaoWebtoonTheme.colors.black3)
    ) {
        NavHost(
            navController = navigator.navController,
            startDestination = navigator.startDestination,
            enterTransition = { EnterTransition.None },
            exitTransition = { ExitTransition.None },
            popEnterTransition = { EnterTransition.None },
            popExitTransition = { ExitTransition.None }
        ) {
            homeNavGraph(
                padding = padding,
                onNavigateToSearch = navigator::navigateSearch
            )

            // Dummy NavGraph
            rankNavGraph(padding = padding)

            // Dummy NavGraph
            giftNavGraph(padding = padding)

            // TODO: Storage NavGraph
            storageNavGraph(padding = padding)

            // TODO: Search NavGraph
            searchNavGraph(
                padding = padding,
                popUpBackStack = navigator::popBackStack
            )

            // TODO: Episode NavGraph
            episodeNavGraph(padding = padding)
        }
    }
}
