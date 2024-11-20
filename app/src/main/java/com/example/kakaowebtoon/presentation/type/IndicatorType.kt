package com.example.kakaowebtoon.presentation.type

import androidx.annotation.ColorRes
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import com.example.kakaowebtoon.domain.model.EpisodeViewIndicatorContents
import com.example.kakaowebtoon.domain.model.MainViewIndicatorContents
import com.example.kakaowebtoon.domain.model.SearchViewIndicatorContents
import com.example.kakaowebtoon.domain.model.StorageViewIndicatorContents
import com.example.kakaowebtoon.ui.theme.defaultKakaoWebtoonColors
import com.example.kakaowebtoon.ui.theme.defaultKakaoWebtoonTypography
import kotlinx.collections.immutable.persistentListOf

enum class IndicatorType(
    val contentsList: List<String>,
    val typoStyle: TextStyle,
    val spaceBy: Dp,
    val spacerHeight: Dp = 4.dp,
    @ColorRes val indicatorColor: Color = defaultKakaoWebtoonColors.yellow1,
    @ColorRes val selectedFontColor: Color = defaultKakaoWebtoonColors.white,
    @ColorRes val unSelectedFontColor: Color = defaultKakaoWebtoonColors.darkGrey5
) {
    MAIN(
        contentsList = persistentListOf(
            MainViewIndicatorContents.NEW.contents,
            MainViewIndicatorContents.MONDAY.contents,
            MainViewIndicatorContents.TUESDAY.contents,
            MainViewIndicatorContents.WEDNESDAY.contents,
            MainViewIndicatorContents.THURSDAY.contents,
            MainViewIndicatorContents.FRIDAY.contents,
            MainViewIndicatorContents.SATURDAY.contents,
            MainViewIndicatorContents.SUNDAY.contents,
            MainViewIndicatorContents.COMPLETE.contents
        ),
        typoStyle = defaultKakaoWebtoonTypography.body2Regular,
        spaceBy = 4.dp,
        selectedFontColor = defaultKakaoWebtoonColors.yellow1,
        unSelectedFontColor = defaultKakaoWebtoonColors.grey5
    ),
    Episode(
        contentsList = persistentListOf(
            EpisodeViewIndicatorContents.EPISODES.contents,
            EpisodeViewIndicatorContents.DETAILS.contents,
            EpisodeViewIndicatorContents.TICKETS.contents,
            EpisodeViewIndicatorContents.COMMENTS.contents
        ),
        typoStyle = defaultKakaoWebtoonTypography.title4SemiBold,
        spaceBy = 25.dp,
        indicatorColor = defaultKakaoWebtoonColors.yellow2,
        selectedFontColor = defaultKakaoWebtoonColors.yellow2,
        unSelectedFontColor = defaultKakaoWebtoonColors.grey3
    ),
    Storage(
        contentsList = persistentListOf(
            StorageViewIndicatorContents.RECENTLY_VIEWED.contents,
            StorageViewIndicatorContents.FAVORITES.contents,
            StorageViewIndicatorContents.PURCHASED.contents,
            StorageViewIndicatorContents.DOWNLOADED.contents,
            StorageViewIndicatorContents.COMMENTS.contents
        ),
        typoStyle = defaultKakaoWebtoonTypography.body2Regular,
        spaceBy = 18.dp,
        spacerHeight = 0.dp,
        indicatorColor = defaultKakaoWebtoonColors.yellow2,
        selectedFontColor = defaultKakaoWebtoonColors.white
    ),
    Search(
        contentsList = persistentListOf(
            SearchViewIndicatorContents.ALL.contents,
            SearchViewIndicatorContents.FREE.contents,
            SearchViewIndicatorContents.FREE_LATER.contents
        ),
        typoStyle = defaultKakaoWebtoonTypography.title2SemiBold,
        spaceBy = 0.dp,
        spacerHeight = 11.dp,
        indicatorColor = defaultKakaoWebtoonColors.yellow2,
        selectedFontColor = defaultKakaoWebtoonColors.white,
        unSelectedFontColor = defaultKakaoWebtoonColors.grey4
    )
}
