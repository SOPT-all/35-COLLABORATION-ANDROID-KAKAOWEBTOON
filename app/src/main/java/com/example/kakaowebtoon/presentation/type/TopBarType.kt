package com.example.kakaowebtoon.presentation.type

import com.example.kakaowebtoon.R

enum class TopBarType(
    val firstIcon: Int,
    val secondIcon: Int,
    val thirdIcon: Int,
    val storageTitle: Int? = null,
    val mainImage: Int? = null,
    val firstIconClick: (() -> Unit)? = null,
    val secondIconClick: (() -> Unit)? = null
) {
    Home(
        firstIcon = R.drawable.ic_topbar_coin,
        secondIcon = R.drawable.ic_topbar_search,
        thirdIcon = R.drawable.ic_topbar_menu,
        mainImage = R.drawable.ic_topbar_logo,
        secondIconClick = {
            // TODO: 검색화면으로 이동
        }
    ),
    Episode(
        firstIcon = R.drawable.ic_episode_arrow_left,
        secondIcon = R.drawable.ic_episode_heart,
        thirdIcon = R.drawable.ic_episode_see_more,
        firstIconClick = {
            // TODO: 뒤로가기
        }
    ),
    Storage(
        firstIcon = R.drawable.ic_topbar_coin,
        secondIcon = R.drawable.ic_topbar_search,
        thirdIcon = R.drawable.ic_topbar_menu,
        storageTitle = R.string.storage_title,
        secondIconClick = {
            // TODO: 검색화면으로 이동
        }
    )
}