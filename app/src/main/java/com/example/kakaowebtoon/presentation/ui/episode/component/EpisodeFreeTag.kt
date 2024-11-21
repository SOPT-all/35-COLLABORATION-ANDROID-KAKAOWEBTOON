package com.example.kakaowebtoon.presentation.ui.episode.component

import androidx.compose.foundation.background
import androidx.compose.foundation.border
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
fun EpisodeFreeTag(
    modifier: Modifier = Modifier
) {
    Text(
        text = stringResource(R.string.episode_free_tag),
        style = KakaoWebtoonTheme.typography.caption4ExtraBold,
        color = KakaoWebtoonTheme.colors.black3,
        modifier= modifier
            .background(
                color = KakaoWebtoonTheme.colors.white,
                shape = RoundedCornerShape(6.dp)
                )
            .border(
                width = 1.dp,
                color = KakaoWebtoonTheme.colors.grey1,
                shape = RoundedCornerShape(6.dp)
            )
            .padding(horizontal = 4.dp, vertical = 2.dp)
    )
}

@Preview
@Composable
fun EpisodeFreeTagPreview(){
    EpisodeFreeTag()
}