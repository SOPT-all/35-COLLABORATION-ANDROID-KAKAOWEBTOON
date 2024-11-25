package com.example.kakaowebtoon.presentation.ui.component.tags

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.kakaowebtoon.ui.theme.KakaoWebtoonTheme

@Composable
fun KakaoWebtoonUpTag(modifier: Modifier = Modifier) {
    Text(
        text = "UP",
        style = KakaoWebtoonTheme.typography.caption4ExtraBold,
        color = KakaoWebtoonTheme.colors.white,
        modifier = modifier
            .background(color = KakaoWebtoonTheme.colors.red, shape = RoundedCornerShape(5.dp))
            .padding(2.dp)
    )
}

@Preview
@Composable
private fun KakaoWebtoonUpTagPreview() {
    KakaoWebtoonUpTag()
}
