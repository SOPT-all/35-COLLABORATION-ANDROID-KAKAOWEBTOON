package com.example.kakaowebtoon.presentation.ui.main

import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.navigation.NavDestination
import androidx.navigation.NavHostController
import androidx.navigation.compose.currentBackStackEntryAsState
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navOptions
import com.example.kakaowebtoon.presentation.model.Route
import com.example.kakaowebtoon.presentation.type.MainBottomNavType
import com.example.kakaowebtoon.presentation.ui.episode.navigation.navigateEpisode
import com.example.kakaowebtoon.presentation.ui.gift.navigation.navigateGift
import com.example.kakaowebtoon.presentation.ui.home.navigation.navigateHome
import com.example.kakaowebtoon.presentation.ui.rank.navigation.navigateRank
import com.example.kakaowebtoon.presentation.ui.search.navigation.navigateSearch
import com.example.kakaowebtoon.presentation.ui.storage.navigation.navigateStorage

class MainNavigator(
    val navController: NavHostController
) {
    private val currentDestination: NavDestination?
        @Composable get() = navController
            .currentBackStackEntryAsState().value?.destination

    val startDestination = MainBottomNavType.HOME.route

    val currentTab: MainBottomNavType?
        @Composable get() = MainBottomNavType.find {
            currentDestination?.route == it::class.qualifiedName
        }

    fun navigate(mainNavigationBarItemType: MainBottomNavType) {
        val navOptions = navOptions {
            popUpTo(0) {
                saveState = true
            }
            launchSingleTop = true
            restoreState = true
        }

        when (mainNavigationBarItemType) {
            MainBottomNavType.HOME -> navController.navigateHome(navOptions)
            MainBottomNavType.RANK -> navController.navigateRank(navOptions)
            MainBottomNavType.GIFT -> navController.navigateGift(navOptions)
            MainBottomNavType.STORAGE -> navController.navigateStorage(navOptions)
        }
    }

    // TODO: Search Navigation
    fun navigateSearch() {
        navController.navigateSearch()
    }

    // TODO: Episode Navigation
    fun navigateEpisode() {
        navController.navigateEpisode()
    }

    private fun popBackStack() {
        navController.popBackStack()
    }

    fun popBackStackIfNotHome() {
        if (!isSameCurrentDestination<Route.Home>()) {
            popBackStack()
        }
    }

    private inline fun <reified T : Route> isSameCurrentDestination(): Boolean =
        navController.currentDestination?.route == T::class.qualifiedName

    @Composable
    fun showBottomBar(): Boolean = MainBottomNavType.contains {
        currentDestination?.route == it::class.qualifiedName
    }
}

@Composable
fun rememberMainNavigator(
    navHostController: NavHostController = rememberNavController()
): MainNavigator = remember(navHostController) {
    MainNavigator(navController = navHostController)
}
