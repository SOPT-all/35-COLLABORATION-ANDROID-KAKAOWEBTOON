package com.example.kakaowebtoon.presentation.ui.episode.component

import androidx.compose.foundation.Canvas
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.graphicsLayer
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import coil.compose.AsyncImage
import com.example.kakaowebtoon.R
import com.example.kakaowebtoon.domain.model.EpisodeCard
import com.example.kakaowebtoon.ui.theme.KakaoWebtoonTheme
import java.time.LocalDate
import java.time.format.DateTimeFormatter

@Composable
fun EpisodeDetailCard(
    card: EpisodeCard,
    modifier: Modifier = Modifier
) {
    val whiteColor = KakaoWebtoonTheme.colors.white
    val white50Color = KakaoWebtoonTheme.colors.white50

    val today = LocalDate.now()
    val cardDate = LocalDate.parse(card.date, DateTimeFormatter.ofPattern("yy.MM.dd"))

    Column(
        modifier = modifier
    ) {
        Box(
            modifier = Modifier.fillMaxWidth()
        ) {
            AsyncImage(
                model = card.imageUrl,
                contentDescription = null,
                modifier = Modifier
                    .graphicsLayer(
                        alpha = if (card.status != 0) {
                            0.5f
                        } else {
                            1f
                        }
                    ),
                contentScale = ContentScale.Crop
            )

            if (card.status in 1..10) {
                Canvas(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(start = 3.dp, end = 4.dp, bottom = 3.dp)
                        .height(4.dp)
                        .align(Alignment.BottomCenter)
                ) {
                    drawRoundRect(
                        color = whiteColor,
                        size = size.copy(width = size.width * (card.status / 10f)),
                        cornerRadius = androidx.compose.ui.geometry.CornerRadius(10.dp.toPx())
                    )
                    drawRoundRect(
                        color = white50Color,
                        size = size.copy(width = size.width),
                        cornerRadius = androidx.compose.ui.geometry.CornerRadius(10.dp.toPx())
                    )
                }
            }

            if (cardDate.isBefore(today)) {
                EpisodeFreeTag(
                    modifier = Modifier
                        .padding(start = 1.dp, top = 2.dp)
                        .align(Alignment.TopStart)
                )
            }
        }

        Column(
            modifier = Modifier
                .fillMaxWidth()
                .background(
                    color = if (card.status != 0) {
                        KakaoWebtoonTheme.colors.darkGrey3
                    } else {
                        KakaoWebtoonTheme.colors.black3
                    },
                    shape = RoundedCornerShape(bottomStart = 6.dp, bottomEnd = 6.dp)
                )
                .padding(top = 10.dp, bottom = 7.dp)
        ) {
            Text(
                text = if (card.index == 0) {
                    card.title
                } else {
                    stringResource(R.string.episode_card_title, card.index, card.title)
                },
                style = KakaoWebtoonTheme.typography.body3Regular,
                color = KakaoWebtoonTheme.colors.white,
                modifier = Modifier.padding(start = 6.dp),
                maxLines = 1,
                overflow = TextOverflow.Ellipsis
            )
            Spacer(Modifier.height(3.dp))

            Text(
                text = if(card.dayUntilFree !=0){
                    stringResource(R.string.episode_date_free, card.dayUntilFree)
                }else{
                    card.date
                },
                style = KakaoWebtoonTheme.typography.body3Regular,
                color = KakaoWebtoonTheme.colors.grey3,
                modifier = Modifier.padding(start = 6.dp)
            )
        }
    }
}

@Preview
@Composable
private fun EpisodeCardPreview() {
    EpisodeDetailCard(
        EpisodeCard(
            imageUrl = "https://i.ibb.co/xCF0VNF/img-storage-toon07.png",
            index = 3,
            title = "예고",
            status = 0,
            date = "24.10.24",
            dayUntilFree = 7
        )
    )
}