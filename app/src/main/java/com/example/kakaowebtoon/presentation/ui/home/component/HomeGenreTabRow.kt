package com.example.kakaowebtoon.presentation.ui.home.component

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.itemsIndexed
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.kakaowebtoon.presentation.type.HomeGenreType
import com.example.kakaowebtoon.presentation.util.noRippleClickable
import com.example.kakaowebtoon.presentation.util.roundedBackgroundWithPadding
import com.example.kakaowebtoon.ui.theme.KakaoWebtoonTheme

@Composable
fun HomeGenreTabRow(
    genreList: List<HomeGenreType>,
    selectedGenre: HomeGenreType,
    onTabClick: (HomeGenreType) -> Unit,
    modifier: Modifier = Modifier
) {
    LazyRow(
        modifier = modifier.padding(top = 8.dp),
        horizontalArrangement = Arrangement.SpaceEvenly
    ) {
        itemsIndexed(
            items = HomeGenreType.entries,
            key = { index, _ -> index },
            contentType = { _, item -> item }
        ) { index, genreType ->
            HomeGenreTabRowItem(
                modifier = Modifier
                    .padding(
                        start = if (index == 0) 10.dp else 4.dp,
                        end = if (index == genreList.lastIndex) 10.dp else 0.dp
                    )
                    .noRippleClickable { onTabClick(genreType) },
                genre = genreType.genre,
                selected = selectedGenre == genreType
            )
        }
    }
}

@Composable
fun HomeGenreTabRowItem(
    genre: String,
    selected: Boolean,
    modifier: Modifier = Modifier
) {
    Box(
        modifier = modifier.roundedBackgroundWithPadding(
            backgroundColor = if (selected) KakaoWebtoonTheme.colors.yellow1 else KakaoWebtoonTheme.colors.black2,
            cornerRadius = 8.dp,
            padding = PaddingValues(
                vertical = 8.dp,
                horizontal = 12.dp
            )
        )
    ) {
        Text(
            text = genre,
            style = if (selected) KakaoWebtoonTheme.typography.body4SemiBold else KakaoWebtoonTheme.typography.body6Regular,
            color = if (selected) KakaoWebtoonTheme.colors.black3 else KakaoWebtoonTheme.colors.grey6
        )
    }
}

@Preview
@Composable
private fun HomeGenreTabRowPreview() {
    KakaoWebtoonTheme {
        HomeGenreTabRow(
            genreList = HomeGenreType.entries,
            selectedGenre = HomeGenreType.ALL,
            onTabClick = {}
        )
    }
}
