package com.example.kakaowebtoon.presentation.ui.rank

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.example.kakaowebtoon.ui.theme.KakaoWebtoonTheme

@Composable
fun RankRoute(
    padding: PaddingValues
) {
    RankScreen(modifier = Modifier.padding(padding))
}

@Composable
fun RankScreen(
    modifier: Modifier = Modifier
) {
    Column(modifier = modifier) {
        Text(
            text = "RankScreen 입니다",
            color = KakaoWebtoonTheme.colors.white
        )
    }
}

@Preview
@Composable
private fun RankScreenPreview() {
    RankRoute(padding = PaddingValues())
}
