package com.example.kakaowebtoon.presentation.ui.episode

import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.WindowInsets
import androidx.compose.foundation.layout.asPaddingValues
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.systemBars
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.lazy.rememberLazyListState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import com.example.kakaowebtoon.R
import com.example.kakaowebtoon.domain.model.EpisodeCard
import com.example.kakaowebtoon.domain.model.WebtoonDetail
import com.example.kakaowebtoon.presentation.type.IndicatorType
import com.example.kakaowebtoon.presentation.type.TopBarType
import com.example.kakaowebtoon.presentation.ui.component.KakaoWebtoonTopBar
import com.example.kakaowebtoon.presentation.ui.component.indicator.KakaoWebtoonIIndicator
import com.example.kakaowebtoon.presentation.ui.episode.component.EpisodeDetail
import com.example.kakaowebtoon.presentation.ui.episode.component.EpisodeDetailCard
import com.example.kakaowebtoon.presentation.ui.episode.component.EpisodeRow
import com.example.kakaowebtoon.ui.theme.KakaoWebtoonTheme
import kotlinx.coroutines.launch

@Composable
fun EpisodeRoute(
    padding: PaddingValues,
    popUpBackStack: () -> Unit,
    modifier: Modifier = Modifier,
    viewModel: EpisodeViewModel = hiltViewModel()
) {
    val webtoonDetail by viewModel.webtoonDetail.collectAsStateWithLifecycle()
    val episodeDummyCards by viewModel.episodeDummyList.collectAsStateWithLifecycle()
    val largestIndexEpisode by viewModel.largestIndexEpisode.collectAsStateWithLifecycle()

    EpisodeScreen(
        popUpBackStack = popUpBackStack,
        webtoonDetail = webtoonDetail,
        episodeDummyCards = episodeDummyCards,
        largestIndexEpisode = largestIndexEpisode,
        modifier = modifier.padding(padding)
    )
}

@OptIn(ExperimentalFoundationApi::class)
@Composable
fun EpisodeScreen(
    popUpBackStack: () -> Unit,
    webtoonDetail: WebtoonDetail?,
    episodeDummyCards: List<EpisodeCard>,
    largestIndexEpisode: EpisodeCard?,
    modifier: Modifier = Modifier
) {
    val lazyListState = rememberLazyListState()
    val coroutineScope = rememberCoroutineScope()
    val EPISODE_CARD_PER_ROW = 3

    Box(
        modifier = modifier
            .fillMaxSize()
            .background(KakaoWebtoonTheme.colors.black3)
            .padding(WindowInsets.systemBars.asPaddingValues())
    ) {
        Column(
            modifier = Modifier.fillMaxSize()
        ) {
            KakaoWebtoonTopBar(
                modifier = Modifier
                    .fillMaxWidth()
                    .background(KakaoWebtoonTheme.colors.black3),
                topBarType = TopBarType.Episode,
                firstIconOnClick = popUpBackStack
            )

            LazyColumn(
                modifier = Modifier
                    .weight(1f)
                    .fillMaxWidth(),
                state = lazyListState
            ) {
                item {
                    webtoonDetail?.let { detail ->
                        EpisodeDetail(detail)
                    }
                    Spacer(Modifier.height(20.dp))
                }

                stickyHeader {
                    KakaoWebtoonIIndicator(
                        modifier = Modifier
                            .background(KakaoWebtoonTheme.colors.black3)
                            .padding(horizontal = 93.dp),
                        indicatorType = IndicatorType.Episode
                    )
                }

                item {
                    Spacer(Modifier.height(14.dp))
                    EpisodeRow(episodeDummyCards.size)
                    Spacer(Modifier.height(10.dp))
                }

                items(episodeDummyCards.chunked(EPISODE_CARD_PER_ROW)) { index ->
                    Row(
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(horizontal = 10.dp),
                        horizontalArrangement = Arrangement.spacedBy(1.dp)
                    ) {
                        for (card in index) {
                            EpisodeDetailCard(
                                card = card,
                                modifier = Modifier
                                    .weight(1f)
                            )
                        }

                        repeat(EPISODE_CARD_PER_ROW - index.size) {
                            Spacer(modifier = Modifier.weight(1f))
                        }
                    }
                }

                item {
                    Button(
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(10.dp),
                        colors = ButtonDefaults.buttonColors(KakaoWebtoonTheme.colors.darkGrey6),
                        shape = RoundedCornerShape(6.dp),
                        onClick = {
                            coroutineScope.launch {
                                lazyListState.scrollToItem(0)
                            }
                        }
                    ) {
                        Text(
                            text = stringResource(R.string.episode_go_top),
                            style = KakaoWebtoonTheme.typography.title4SemiBold,
                            color = KakaoWebtoonTheme.colors.white
                        )
                    }
                }
            }

            Column(
                modifier = Modifier
                    .fillMaxWidth()
                    .background(color = KakaoWebtoonTheme.colors.white, shape = RoundedCornerShape(topStart = 12.dp, topEnd = 12.dp))
                    .padding(top = 13.dp, bottom = 7.dp),
                verticalArrangement = Arrangement.Center,
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                Text(
                    text = stringResource(R.string.episode_banner_button_continue),
                    style = KakaoWebtoonTheme.typography.title2SemiBold,
                    color = KakaoWebtoonTheme.colors.black3,
                    modifier = Modifier.padding(bottom = 2.dp)
                )

                largestIndexEpisode?.let { episode ->
                    Text(
                        text = stringResource(
                            R.string.episode_card_title,
                            episode.index,
                            episode.title
                        ),
                        style = KakaoWebtoonTheme.typography.body3Regular,
                        color = KakaoWebtoonTheme.colors.grey4
                    )
                }
            }
        }
    }
}
