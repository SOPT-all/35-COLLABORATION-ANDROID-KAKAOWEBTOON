package com.example.kakaowebtoon.presentation.ui.home.component

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Icon
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.res.vectorResource
import androidx.compose.ui.tooling.preview.Preview
import com.example.kakaowebtoon.R
import com.example.kakaowebtoon.ui.theme.KakaoWebtoonTheme

@Composable
fun HomeCardEmptyView(
    modifier: Modifier = Modifier
) {
    Box(
        modifier = modifier
            .fillMaxSize()
            .background(KakaoWebtoonTheme.colors.black1),
        contentAlignment = Alignment.Center
    ) {
        Icon(
            imageVector = ImageVector.vectorResource(R.drawable.ic_home_card_logo),
            contentDescription = null,
            tint = KakaoWebtoonTheme.colors.darkGrey4
        )
    }
}

@Preview
@Composable
private fun HomeCardEmptyViewPreview() {
    KakaoWebtoonTheme {
        HomeCardEmptyView()
    }
}
