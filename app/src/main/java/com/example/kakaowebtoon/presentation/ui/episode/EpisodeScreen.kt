package com.example.kakaowebtoon.presentation.ui.episode

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.hilt.navigation.compose.hiltViewModel
import com.example.kakaowebtoon.ui.theme.KakaoWebtoonColors
import com.example.kakaowebtoon.ui.theme.KakaoWebtoonTheme
import com.example.kakaowebtoon.ui.theme.defaultKakaoWebtoonColors

@Composable
fun EpisodeRoute(
    padding: PaddingValues,
    popUpBackStack: () -> Unit,
    modifier: Modifier = Modifier,
    viewModel: EpisodeViewModel = hiltViewModel()
) {
    EpisodeScreen(
        modifier = modifier.padding(padding),
        popUpBackStack = popUpBackStack,
        viewModel = viewModel
    )
}

@Composable
fun EpisodeScreen(
    popUpBackStack: () -> Unit,
    modifier: Modifier = Modifier,
    viewModel: EpisodeViewModel = hiltViewModel()
) {
    Column(
        modifier = modifier
            .fillMaxSize()
            .background(color = KakaoWebtoonTheme.colors.black3)
    ) {
        Text(
            text = "EpisodeScreen 입니다",
            color = KakaoWebtoonTheme.colors.white
        )
    }
}

@Preview
@Composable
private fun MainScreenPreview() {
    EpisodeScreen(popUpBackStack = {})
}
