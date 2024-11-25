package com.example.kakaowebtoon.presentation.ui.component.tags

import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.IntrinsicSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.kakaowebtoon.ui.theme.KakaoWebtoonTheme

@Composable
fun KakaoWebtoonGenreTag(genre: String, modifier: Modifier = Modifier) {
    Text(
        text = genre,
        color = KakaoWebtoonTheme.colors.white,
        style = KakaoWebtoonTheme.typography.caption4ExtraBold,
        modifier = modifier
            .background(color = KakaoWebtoonTheme.colors.black4, shape = RoundedCornerShape(5.dp))
            .border(
                width = 1.dp,
                color = KakaoWebtoonTheme.colors.grey4,
                shape = RoundedCornerShape(5.dp)
            )
            .padding(vertical = 2.dp, horizontal = 4.dp)
            .height(IntrinsicSize.Min)
    )
}

@Preview
@Composable
private fun KakaoWebtoonGenreTagPreview() {
    KakaoWebtoonGenreTag("#로맨스")
}
