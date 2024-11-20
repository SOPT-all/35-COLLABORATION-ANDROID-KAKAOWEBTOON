package com.example.kakaowebtoon.presentation.ui.component.card

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.IntrinsicSize
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.width
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import coil.compose.AsyncImage
import com.example.kakaowebtoon.domain.model.WebtoonCard
import com.example.kakaowebtoon.domain.util.Promotion
import com.example.kakaowebtoon.presentation.ui.component.tags.KakaoWebtoonClockTag
import com.example.kakaowebtoon.presentation.ui.component.tags.KakaoWebtoonFreeLaterTag
import com.example.kakaowebtoon.presentation.ui.component.tags.KakaoWebtoonFreeTag
import com.example.kakaowebtoon.presentation.ui.component.tags.KakaoWebtoonGenreTag
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

        AsyncImage(
            model = card.imageUrl,
            contentDescription = null,
        )
        Spacer(modifier = modifier.width(12.dp))

        Column {
            Spacer(modifier = modifier.height(8.dp))
            Row {
                when (card.promotion) {
                    Promotion.FREE -> KakaoWebtoonFreeTag()
                    Promotion.FREE_LATER -> KakaoWebtoonFreeLaterTag()
                    Promotion.CLOCK -> KakaoWebtoonClockTag()
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
