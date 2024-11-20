package com.example.kakaowebtoon.presentation.ui.home

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.hilt.navigation.compose.hiltViewModel
import com.example.kakaowebtoon.ui.theme.KakaoWebtoonTheme

@Composable
fun HomeRoute(
    padding: PaddingValues,
    onNavigateToSearch: () -> Unit,
    modifier: Modifier = Modifier,
    viewModel: HomeViewModel = hiltViewModel()
) {
    HomeScreen(
        modifier = modifier.padding(padding),
        onNavigateToSearch = onNavigateToSearch
    )
}

@Composable
fun HomeScreen(
    onNavigateToSearch: () -> Unit,
    modifier: Modifier = Modifier
) {
    Column(
        modifier = modifier
            .fillMaxSize()
    ) {
        Text(
            text = "HomeScreen 입니다",
            color = KakaoWebtoonTheme.colors.white
        )
    }
}

@Preview
@Composable
private fun HomeScreenPreview() {
    HomeRoute(
        padding = PaddingValues(),
        onNavigateToSearch = {}
    )
}
