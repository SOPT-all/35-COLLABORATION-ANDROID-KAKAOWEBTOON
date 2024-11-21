package com.example.kakaowebtoon.presentation.ui.episode.component

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.res.vectorResource
import androidx.compose.ui.unit.dp
import com.example.kakaowebtoon.R
import com.example.kakaowebtoon.ui.theme.KakaoWebtoonTheme

@Composable
fun EpisodeRow(
    totalCount: Int,
    modifier: Modifier = Modifier
) {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .padding(start = 17.dp, end = 15.dp),
        horizontalArrangement = Arrangement.SpaceBetween
    ) {
        Text(
            text = stringResource(R.string.episode_total_count, totalCount),
            style = KakaoWebtoonTheme.typography.caption2Medium,
            color = KakaoWebtoonTheme.colors.white
        )

        Row(
            verticalAlignment = Alignment.CenterVertically
        ) {
            Icon(
                imageVector = ImageVector.vectorResource(R.drawable.ic_episode_list),
                contentDescription = null,
                tint = KakaoWebtoonTheme.colors.white
            )
            Text(
                text = stringResource(R.string.episode_list_view),
                style = KakaoWebtoonTheme.typography.body3Regular,
                color = KakaoWebtoonTheme.colors.white
            )
            Spacer(Modifier.width(8.dp))

            Icon(
                imageVector = ImageVector.vectorResource(R.drawable.ic_episode_arrow_updown),
                contentDescription = null,
                tint = KakaoWebtoonTheme.colors.white
            )
            Text(
                text = stringResource(R.string.episode_order),
                style = KakaoWebtoonTheme.typography.body3Regular,
                color = KakaoWebtoonTheme.colors.white
            )
        }
    }
}