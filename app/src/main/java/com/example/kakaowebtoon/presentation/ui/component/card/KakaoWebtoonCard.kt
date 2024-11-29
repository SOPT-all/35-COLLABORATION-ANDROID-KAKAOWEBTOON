package com.example.kakaowebtoon.presentation.ui.component.card

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.IntrinsicSize
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.aspectRatio
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.width
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalConfiguration
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.vectorResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import coil.compose.AsyncImage
import com.example.kakaowebtoon.R
import com.example.kakaowebtoon.domain.model.WebtoonCard
import com.example.kakaowebtoon.domain.util.Promotion
import com.example.kakaowebtoon.presentation.ui.component.tags.KakaoWebtoonClockTag
import com.example.kakaowebtoon.presentation.ui.component.tags.KakaoWebtoonFreeLaterTag
import com.example.kakaowebtoon.presentation.ui.component.tags.KakaoWebtoonFreeTag
import com.example.kakaowebtoon.presentation.ui.component.tags.KakaoWebtoonGenreTag
import com.example.kakaowebtoon.presentation.ui.component.tags.KakaoWebtoonUpTag
import com.example.kakaowebtoon.ui.theme.defaultKakaoWebtoonColors
import com.example.kakaowebtoon.ui.theme.defaultKakaoWebtoonTypography

@Composable
fun KakaoWebtoonCard(
    card: WebtoonCard,
    modifier: Modifier = Modifier
) {
    Row(
        modifier = modifier
            .height(IntrinsicSize.Min)
    ) {
        if (card.imageUrl.contains("dummy")) {
            when (card.imageUrl) {
                "dummy1" -> Image(
                    painter = painterResource(R.drawable.img_dummy_card1),
                    contentDescription = null,
                    contentScale = ContentScale.Crop,
                    modifier = Modifier
                        .width(LocalConfiguration.current.screenWidthDp.dp * (150f / 360f))
                        .aspectRatio(150f / 95f)
                )

                "dummy2" -> Image(
                    painter = painterResource(R.drawable.img_dummy_card2),
                    contentDescription = null,
                    contentScale = ContentScale.Crop,
                    modifier = Modifier
                        .width(LocalConfiguration.current.screenWidthDp.dp * (150f / 360f))
                        .aspectRatio(150f / 95f)
                )
            }

        } else if (card.imageUrl.isNotEmpty()) {
            AsyncImage(
                model = card.imageUrl,
                contentDescription = null,
                contentScale = ContentScale.Crop,
                modifier = Modifier
                    .width(LocalConfiguration.current.screenWidthDp.dp * (150f / 360f))
                    .aspectRatio(150f / 95f)
            )
        } else {
            Image(
                imageVector = ImageVector.vectorResource(R.drawable.img_empty_webtoon_card),
                contentDescription = null,
                contentScale = ContentScale.Crop,
                modifier = Modifier
                    .width(LocalConfiguration.current.screenWidthDp.dp * (150f / 360f))
                    .aspectRatio(150f / 95f)
            )
        }

        Spacer(modifier = modifier.width(12.dp))

        Column {
            Spacer(modifier = modifier.height(8.dp))
            Row {
                when (card.promotion) {
                    Promotion.FREE -> KakaoWebtoonFreeTag()
                    Promotion.FREE_LATER -> KakaoWebtoonFreeLaterTag()
                    Promotion.CLOCK -> KakaoWebtoonClockTag()
                    Promotion.UP -> KakaoWebtoonUpTag()
                }
                Spacer(modifier = modifier.width(3.dp))
                KakaoWebtoonGenreTag(card.genre)
            }
            Spacer(modifier = modifier.height(6.dp))
            Text(
                text = card.title,
                style = defaultKakaoWebtoonTypography.caption1Bold,
                color = defaultKakaoWebtoonColors.white
            )
            Spacer(modifier = modifier.weight(1f))

            Text(
                text = card.author,
                style = defaultKakaoWebtoonTypography.caption3Light,
                color = defaultKakaoWebtoonColors.grey4
            )
        }
    }
}

@Preview
@Composable
private fun KakaoWebtoonCardPreview() {
    KakaoWebtoonCard(
        WebtoonCard(
            imageUrl = "https://i.ibb.co/JrRcFQ9/img-storage-toon01.png",
            title = "어쿠스틱 라이프",
            promotion = "연재 무료",
            genre = "# 로맨스",
            author = "난다"
        )
    )
}
