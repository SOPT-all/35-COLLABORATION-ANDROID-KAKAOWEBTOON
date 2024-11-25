package com.example.kakaowebtoon.presentation.ui.component.tags

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.kakaowebtoon.ui.theme.defaultKakaoWebtoonColors
import com.example.kakaowebtoon.ui.theme.defaultKakaoWebtoonTypography

@Composable
fun KakaoWebtoonUpTag(modifier: Modifier = Modifier) {
    Text(
        text = "UP",
        style = defaultKakaoWebtoonTypography.caption4ExtraBold,
        color = defaultKakaoWebtoonColors.white,
        modifier = modifier
            .background(color = defaultKakaoWebtoonColors.red, shape = RoundedCornerShape(5.dp))
            .padding(2.dp)
    )
}

@Preview
@Composable
private fun KakaoWebtoonUpTagPreview() {
    KakaoWebtoonUpTag()
}
