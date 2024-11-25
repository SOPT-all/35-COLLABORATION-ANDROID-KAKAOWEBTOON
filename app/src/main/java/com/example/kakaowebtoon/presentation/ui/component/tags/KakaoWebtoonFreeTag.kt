package com.example.kakaowebtoon.presentation.ui.component.tags

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.kakaowebtoon.R
import com.example.kakaowebtoon.ui.theme.KakaoWebtoonTheme

@Composable
fun KakaoWebtoonFreeTag(modifier: Modifier = Modifier) {
    Text(
        text = stringResource(R.string.webtoon_promotion_free),
        style = KakaoWebtoonTheme.typography.caption4ExtraBold,
        modifier = modifier
            .background(color = KakaoWebtoonTheme.colors.yellow1, shape = RoundedCornerShape(5.dp))
            .padding(horizontal = 4.dp, vertical = 2.dp),
        color = KakaoWebtoonTheme.colors.black4
    )
}

@Preview
@Composable
private fun KakaoWebtoonFreeTagPreview() {
    KakaoWebtoonFreeTag()
}
