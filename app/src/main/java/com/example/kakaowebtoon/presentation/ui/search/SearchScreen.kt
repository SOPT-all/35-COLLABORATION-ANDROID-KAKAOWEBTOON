package com.example.kakaowebtoon.presentation.ui.search

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import com.example.kakaowebtoon.presentation.ui.search.component.SearchTextField
import com.example.kakaowebtoon.ui.theme.defaultKakaoWebtoonColors

@Composable
fun SearchScreen(
    modifier: Modifier = Modifier,
//    viewModel: SearchViewModel = hiltViewModel()
) {
    Column(
        modifier = modifier
            .fillMaxSize()
            .background(color = defaultKakaoWebtoonColors.black3)
    ) {
        val text = remember { mutableStateOf("") }
        Spacer(modifier = modifier.height(30.dp))
        SearchTextField(
            value = text.value,
            onValueChange = { text.value = it },
            placeholder = "작품, 작가, 장르를 입력하세요"
        )
    }
}

@Preview
@Composable
private fun MainScreenPreview() {
    SearchScreen()
}
