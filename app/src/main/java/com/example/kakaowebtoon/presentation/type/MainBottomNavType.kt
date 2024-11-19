package com.example.kakaowebtoon.presentation.type

import androidx.annotation.DrawableRes
import androidx.annotation.StringRes
import androidx.compose.runtime.Composable
import com.example.kakaowebtoon.R
import com.example.kakaowebtoon.presentation.model.Route

enum class MainBottomNavType(
    @DrawableRes val iconResId: Int,
    @StringRes val labelResId: Int,
    val route: Route
) {
    HOME(
        iconResId = R.drawable.ic_bottom_nav_timetable_activate,
        labelResId = R.string.bottom_navigation_bar_item_home,
        route = Route.Home
    ),
    RANK(
        iconResId = R.drawable.ic_bottom_nav_rank_activate,
        labelResId = R.string.bottom_navigation_bar_item_rank,
        route = Route.Rank
    ),
    GIFT(
        iconResId = R.drawable.ic_bottom_nav_gift_activate,
        labelResId = R.string.bottom_navigation_bar_item_gift,
        route = Route.Gift
    ),
    STORAGE(
        iconResId = R.drawable.ic_bottom_nav_storage_activate,
        labelResId = R.string.bottom_navigation_bar_item_storage,
        route = Route.Storage
    );

    companion object {
        @Composable
        fun find(predicate: @Composable (Route) -> Boolean): MainBottomNavType? {
            return entries.find { predicate(it.route) }
        }

        @Composable
        fun contains(predicate: @Composable (Route) -> Boolean): Boolean {
            return entries.map { it.route }.any { predicate(it) }
        }
    }
}
