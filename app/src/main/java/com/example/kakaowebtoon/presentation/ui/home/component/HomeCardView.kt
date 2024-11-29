package com.example.kakaowebtoon.presentation.ui.home.component

import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import coil.compose.AsyncImage
import com.example.kakaowebtoon.ui.theme.KakaoWebtoonTheme

@Composable
fun HomeCardView(
    imageUrl: String,
    modifier: Modifier = Modifier
) {
    AsyncImage(
        modifier = modifier.clip(RoundedCornerShape(8.dp)),
        model = imageUrl,
        contentDescription = null,
        contentScale = ContentScale.FillWidth
    )
}

@Preview
@Composable
private fun HomeCardViewPreview() {
    KakaoWebtoonTheme {
        HomeCardView(
            imageUrl = ""
        )
    }
}
