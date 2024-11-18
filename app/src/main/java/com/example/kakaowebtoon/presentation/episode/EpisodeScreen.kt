package com.example.kakaowebtoon.presentation.episode

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.hilt.navigation.compose.hiltViewModel

@Composable
fun EpisodeScreen(
    modifier: Modifier = Modifier,
    viewModel: EpisodeViewModel = hiltViewModel(),
) {
    Column(
        modifier = modifier
            .fillMaxSize()
            .background(color = Color.White),
    ) {
        Text(text = "EpisodeScreen 입니다")
    }
}

@Preview
@Composable
private fun MainScreenPreview() {
    EpisodeScreen()
}