package com.example.kakaowebtoon.presentation.ui.home.component

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.itemsIndexed
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.kakaowebtoon.presentation.type.HomeGenreType
import com.example.kakaowebtoon.presentation.util.noRippleClickable
import com.example.kakaowebtoon.ui.theme.KakaoWebtoonTheme

@Composable
fun HomeGenreTabRow(
    onTabClick: (HomeGenreType) -> Unit = {},
    modifier: Modifier = Modifier,
    genreList: List<HomeGenreType> = HomeGenreType.entries
) {
    var selectedGenre by remember { mutableStateOf(genreList.first()) }

    LazyRow(
        modifier = modifier.padding(top = 8.dp)
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
                    .noRippleClickable {
                        selectedGenre = genreType
                        onTabClick(genreType)
                    },
                genre = genreType.genre,
                selected = selectedGenre == genreType // 현재 선택된 탭인지 확인
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
        modifier = modifier
            .clip(RoundedCornerShape(8.dp))
            .background(
                if (selected) {
                    KakaoWebtoonTheme.colors.yellow1
                } else {
                    KakaoWebtoonTheme.colors.black2
                }
            )
            .padding(vertical = 8.dp, horizontal = 12.dp)
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
            onTabClick = {}
        )
    }
}
