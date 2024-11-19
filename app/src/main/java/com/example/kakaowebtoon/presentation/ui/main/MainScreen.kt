package com.example.kakaowebtoon.presentation.ui.main

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.hilt.navigation.compose.hiltViewModel
import com.example.kakaowebtoon.presentation.ui.home.HomeViewModel
import com.example.kakaowebtoon.ui.theme.defaultKakaoWebtoonColors

@Composable
fun MainScreen(
    modifier: Modifier = Modifier,
    viewModel: HomeViewModel = hiltViewModel()
) {
    Column(
        modifier = modifier
            .fillMaxSize()
            .background(color = defaultKakaoWebtoonColors.black3)
    ) {
        Text(text = "MainScreen 입니다", color = defaultKakaoWebtoonColors.white)
    }
}

@Preview
@Composable
private fun MainScreenPreview() {
    MainScreen()
}
