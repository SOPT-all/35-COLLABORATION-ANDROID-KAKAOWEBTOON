package com.example.kakaowebtoon.presentation.ui.episode.component

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.res.vectorResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import coil.compose.AsyncImage
import com.example.kakaowebtoon.R
import com.example.kakaowebtoon.domain.model.WebtoonDetail
import com.example.kakaowebtoon.domain.util.Promotion
import com.example.kakaowebtoon.presentation.ui.component.tags.KakaoWebtoonClockTag
import com.example.kakaowebtoon.presentation.ui.component.tags.KakaoWebtoonFreeLaterTag
import com.example.kakaowebtoon.presentation.ui.component.tags.KakaoWebtoonFreeTag
import com.example.kakaowebtoon.presentation.ui.component.tags.KakaoWebtoonGenreTag
import com.example.kakaowebtoon.presentation.ui.component.tags.KakaoWebtoonUpTag
import com.example.kakaowebtoon.ui.theme.KakaoWebtoonTheme

@Composable
fun EpisodeDetail(
    detail: WebtoonDetail,
    modifier: Modifier = Modifier
) {
    Column(
        modifier = modifier.fillMaxWidth(),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Box(
            modifier = Modifier.fillMaxWidth()
        ) {
            AsyncImage(
                model = detail.imageUrl,
                contentDescription = null,
                modifier = Modifier
                    .fillMaxSize()
                    .padding(horizontal = 10.dp),
                contentScale = ContentScale.Crop
            )

            Column(
                modifier = Modifier
                    .padding(start = 17.dp, top = 39.dp)
            ) {
                when (detail.promotion) {
                    Promotion.FREE -> KakaoWebtoonFreeTag()
                    Promotion.FREE_LATER -> KakaoWebtoonFreeLaterTag()
                    Promotion.CLOCK -> KakaoWebtoonClockTag()
                    Promotion.UP -> KakaoWebtoonUpTag()
                }
                Spacer(Modifier.height(4.dp))

                KakaoWebtoonGenreTag(stringResource(R.string.episode_coupon_count, detail.coupon))
            }
        }
        Spacer(Modifier.height(18.dp))

        Text(
            text = detail.title,
            style = KakaoWebtoonTheme.typography.head1SemiBold,
            color = KakaoWebtoonTheme.colors.white
        )
        Spacer(Modifier.height(3.dp))

        Text(
            text = detail.author,
            style = KakaoWebtoonTheme.typography.body3Regular,
            color = KakaoWebtoonTheme.colors.grey3
        )
        Spacer(Modifier.height(2.dp))

        Row(
            verticalAlignment = Alignment.Bottom
        ) {
            Icon(
                imageVector = ImageVector.vectorResource(R.drawable.ic_episode_genre),
                contentDescription = null,
                tint = KakaoWebtoonTheme.colors.grey3
            )
            Text(
                text = detail.genre,
                style = KakaoWebtoonTheme.typography.body3Regular,
                color = KakaoWebtoonTheme.colors.grey3
            )
            Spacer(Modifier.width(5.dp))

            Icon(
                imageVector = ImageVector.vectorResource(R.drawable.ic_episode_view),
                contentDescription = null,
                tint = KakaoWebtoonTheme.colors.grey3
            )
            Text(
                text = formatCount(detail.viewCount),
                style = KakaoWebtoonTheme.typography.body3Regular,
                color = KakaoWebtoonTheme.colors.grey3
            )
            Spacer(Modifier.width(6.dp))

            Icon(
                imageVector = ImageVector.vectorResource(R.drawable.ic_episode_good),
                contentDescription = null,
                tint = KakaoWebtoonTheme.colors.grey3
            )
            Text(
                text = formatCount(detail.heartCount),
                style = KakaoWebtoonTheme.typography.body3Regular,
                color = KakaoWebtoonTheme.colors.grey3
            )
        }
    }
}

fun formatCount(count: Int): String {
    return when {
        count >= 100000000 -> String.format("%.1f억", count / 100000000.0)
        count >= 10000 -> String.format("%.1f만", count / 10000.0)
        else -> count.toString()
    }
}

@Preview
@Composable
private fun EpisodeDetailPreview() {
    EpisodeDetail(
        WebtoonDetail(
            imageUrl = "https://i.ibb.co/JrRcFQ9/img-storage-toon01.png",
            title = "어쿠스틱 라이프",
            author = "난다",
            genre = "코믹/일상",
            viewCount = 270000000,
            heartCount = 2007000,
            coupon = 10,
            promotion = "연재 무료"
        )
    )
}
