package com.example.kakaowebtoon.presentation.storage

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
fun StorageScreen(
    modifier: Modifier = Modifier,
    viewModel: StorageViewModel = hiltViewModel()
) {
    Column(
        modifier = modifier
            .fillMaxSize()
            .background(color = Color.White)
    ) {
        Text(text = "MainScreen 입니다")
    }
}

@Preview
@Composable
private fun MainScreenPreview() {
    StorageScreen()
}
