package com.example.kakaowebtoon.presentation.ui.episode

import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import com.example.kakaowebtoon.domain.model.WebtoonDetail
import com.example.kakaowebtoon.presentation.type.IndicatorType
import com.example.kakaowebtoon.presentation.type.TopBarType
import com.example.kakaowebtoon.presentation.ui.component.KakaoWebtoonTopBar
import com.example.kakaowebtoon.presentation.ui.component.indicator.KakaoWebtoonIIndicator
import com.example.kakaowebtoon.presentation.ui.episode.component.EpisodeDetail
import com.example.kakaowebtoon.presentation.ui.episode.component.EpisodeRow
import com.example.kakaowebtoon.ui.theme.KakaoWebtoonColors
import com.example.kakaowebtoon.ui.theme.KakaoWebtoonTheme
import com.example.kakaowebtoon.ui.theme.defaultKakaoWebtoonColors

@Composable
fun EpisodeRoute(
    padding: PaddingValues,
    popUpBackStack: () -> Unit,
    modifier: Modifier = Modifier,
    viewModel: EpisodeViewModel = hiltViewModel()
) {
    EpisodeScreen(
        modifier = modifier.padding(padding),
        popUpBackStack = popUpBackStack,
        viewModel = viewModel
    )
}

@OptIn(ExperimentalFoundationApi::class)
@Composable
fun EpisodeScreen(
    popUpBackStack: () -> Unit,
    modifier: Modifier = Modifier,
    viewModel: EpisodeViewModel = hiltViewModel()
) {
    val webtoonDetail by viewModel.webtoonDetail.collectAsState()

    Box(
        modifier = modifier
            .fillMaxSize()
            .background(KakaoWebtoonTheme.colors.black3)
    ) {
        LazyColumn(
            modifier = Modifier.fillMaxSize()
        ) {
            item {
                KakaoWebtoonTopBar(
                    topBarType = TopBarType.Episode,
                    firstIconOnClick = popUpBackStack
                )
            }

            item {
                webtoonDetail?.let { detail ->
                    EpisodeDetail(detail)
                }
                Spacer(Modifier.height(20.dp))
            }

            stickyHeader {
                KakaoWebtoonIIndicator(
                    modifier = Modifier.padding(horizontal = 93.dp),
                    indicatorType = IndicatorType.Episode
                )
            }

            item {
                Spacer(Modifier.height(14.dp))
                EpisodeRow(298)
            }
        }
    }
}

@Preview
@Composable
private fun EpisodeScreenPreview() {
    EpisodeScreen(popUpBackStack = {})
}