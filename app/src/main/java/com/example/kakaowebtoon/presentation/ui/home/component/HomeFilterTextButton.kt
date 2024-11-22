package com.example.kakaowebtoon.presentation.ui.home.component

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.res.vectorResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.kakaowebtoon.R
import com.example.kakaowebtoon.ui.theme.KakaoWebtoonTheme

@Composable
fun HomeFilterTextButton(
    title: String,
    modifier: Modifier = Modifier
) {
    Row(
        modifier = modifier.padding(
            vertical = 3.5.dp,
            horizontal = 4.dp
        ),
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.spacedBy(4.dp)
    ) {
        Text(
            text = title,
            style = KakaoWebtoonTheme.typography.body6Regular,
            color = KakaoWebtoonTheme.colors.white
        )
        Icon(
            imageVector = ImageVector.vectorResource(R.drawable.ic_home_arrow_bottom_white_12),
            contentDescription = null,
            tint = KakaoWebtoonTheme.colors.white
        )
    }
}

@Preview
@Composable
private fun HomeFilterTextButtonPreview() {
    KakaoWebtoonTheme {
        HomeFilterTextButton(
            title = ""
        )
    }
}
