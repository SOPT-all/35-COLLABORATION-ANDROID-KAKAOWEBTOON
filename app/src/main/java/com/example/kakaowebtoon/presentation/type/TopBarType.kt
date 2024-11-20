package com.example.kakaowebtoon.presentation.type

import androidx.annotation.DrawableRes
import androidx.annotation.StringRes
import com.example.kakaowebtoon.R

enum class TopBarType(
    @DrawableRes val firstIconResId: Int,
    @DrawableRes val secondIconResId: Int,
    @DrawableRes val thirdIconResId: Int,
    @StringRes val storageTitleResId: Int? = null,
    @DrawableRes val mainImageResId: Int? = null,
    val firstIconStartPadding: Int = 0,
    val secondIconEndPadding: Int = 0,
    val thirdIconEndPadding: Int = 0,
    val firstIconOnClick: (() -> Unit)? = null,
    val secondIconOnClick: (() -> Unit)? = null
) {
    Home(
        firstIconResId = R.drawable.ic_topbar_coin,
        secondIconResId = R.drawable.ic_topbar_search,
        thirdIconResId = R.drawable.ic_topbar_menu,
        mainImageResId = R.drawable.ic_topbar_logo,
        firstIconStartPadding = 5,
        secondIconOnClick = {
            // TODO: 검색화면으로 이동
        }
    ),
    Episode(
        firstIconResId = R.drawable.ic_episode_arrow_left,
        secondIconResId = R.drawable.ic_topbar_heart,
        thirdIconResId = R.drawable.ic_episode_see_more,
        firstIconStartPadding = 12,
        secondIconEndPadding = 3,
        thirdIconEndPadding = 8,
        firstIconOnClick = {
            // TODO: 뒤로가기
        }
    ),
    Storage(
        firstIconResId = R.drawable.ic_topbar_coin,
        secondIconResId = R.drawable.ic_topbar_search,
        thirdIconResId = R.drawable.ic_topbar_menu,
        storageTitleResId = R.string.storage_title,
        firstIconStartPadding = 5,
        secondIconOnClick = {
            // TODO: 검색화면으로 이동
        }
    )
}
