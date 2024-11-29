package com.example.kakaowebtoon.presentation.ui.home

import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.itemsIndexed
import androidx.compose.foundation.lazy.rememberLazyListState
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.onGloballyPositioned
import androidx.compose.ui.platform.LocalDensity
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import com.example.kakaowebtoon.R
import com.example.kakaowebtoon.domain.model.WebtoonCard
import com.example.kakaowebtoon.presentation.type.HomeGenreType
import com.example.kakaowebtoon.presentation.type.IndicatorType
import com.example.kakaowebtoon.presentation.type.TopBarType
import com.example.kakaowebtoon.presentation.ui.component.KakaoWebtoonTopBar
import com.example.kakaowebtoon.presentation.ui.component.indicator.KakaoWebtoonIIndicator
import com.example.kakaowebtoon.presentation.ui.home.component.HomeBanner
import com.example.kakaowebtoon.presentation.ui.home.component.HomeCardEmptyView
import com.example.kakaowebtoon.presentation.ui.home.component.HomeCardView
import com.example.kakaowebtoon.presentation.ui.home.component.HomeFilterTextButton
import com.example.kakaowebtoon.presentation.ui.home.component.HomeFooter
import com.example.kakaowebtoon.presentation.ui.home.component.HomeGenreTabRow
import com.example.kakaowebtoon.presentation.util.HomeFilter
import com.example.kakaowebtoon.ui.theme.KakaoWebtoonTheme

@Composable
fun HomeRoute(
    padding: PaddingValues,
    onNavigateToSearch: () -> Unit,
    modifier: Modifier = Modifier,
    viewModel: HomeViewModel = hiltViewModel()
) {
    val webtoonList by viewModel.webtoonList.collectAsStateWithLifecycle()
    val selectedDay by viewModel.selectedDay.collectAsStateWithLifecycle()
    val selectedGenreType by viewModel.selectedGenreType.collectAsStateWithLifecycle()

    LaunchedEffect(webtoonList) {
        if (webtoonList.isEmpty()) {
            viewModel.getWebtoonList(selectedDay)
        }
    }

    HomeScreen(
        webtoonList = webtoonList,
        selectedGenreType = selectedGenreType,
        onSelectGenreType = viewModel::onSelectGenreTab,
        selectedDay = selectedDay,
        onSelectedDay = viewModel::onSelectDayTab,
        onNavigateToSearch = onNavigateToSearch,
        modifier = modifier.padding(padding)
    )
}

@OptIn(ExperimentalFoundationApi::class)
@Composable
fun HomeScreen(
    webtoonList: List<WebtoonCard>,
    selectedGenreType: HomeGenreType,
    onSelectGenreType: (HomeGenreType) -> Unit,
    selectedDay: Int,
    onSelectedDay: (Int) -> Unit,
    onNavigateToSearch: () -> Unit,
    modifier: Modifier = Modifier
) {
    val state = rememberLazyListState()
    var homeCardHeight by remember { mutableStateOf(0) }

    LazyColumn(
        modifier = modifier,
        state = state
    ) {
        item {
            Spacer(modifier = Modifier.height(24.dp))
            KakaoWebtoonTopBar(
                topBarType = TopBarType.Home,
                secondIconOnClick = onNavigateToSearch
            )
            HomeBanner(
                onBannerClick = {
                    // TODO: Banner 클릭 (추후) 추가
                }
            )
        }

        stickyHeader {
            Column(
                modifier = Modifier
                    .fillMaxWidth()
                    .background(KakaoWebtoonTheme.colors.black3)
            ) {
                Spacer(modifier = Modifier.height(8.dp))
                KakaoWebtoonIIndicator(
                    modifier = Modifier.padding(horizontal = 47.dp),
                    selectedIndex = selectedDay,
                    onIndexSelected = onSelectedDay,
                    indicatorType = IndicatorType.MAIN
                )
                HomeGenreTabRow(
                    modifier = Modifier.fillMaxWidth(),
                    genreList = HomeGenreType.entries,
                    selectedGenre = selectedGenreType,
                    onTabClick = onSelectGenreType
                )
                Spacer(modifier = Modifier.height(7.dp))
                Row(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(horizontal = 10.dp),
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    Text(
                        modifier = Modifier.padding(vertical = 3.5.dp, horizontal = 4.dp),
                        text = stringResource(R.string.home_content_total_count, webtoonList.size),
                        style = KakaoWebtoonTheme.typography.body6Regular,
                        color = KakaoWebtoonTheme.colors.white
                    )
                    Spacer(modifier = Modifier.weight(1f))
                    HomeFilterTextButton(HomeFilter.POPULAR)
                    HomeFilterTextButton(HomeFilter.ALL)
                }
                Spacer(modifier = Modifier.height(8.dp))
            }
        }

        itemsIndexed(
            items = webtoonList.chunked(3),
            key = { index, _ -> index },
            contentType = { _, item -> item }
        ) { index, urlChunk ->
            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .wrapContentHeight()
                    .padding(horizontal = 10.dp)
                    .padding(
                        bottom = if (index == webtoonList.chunked(3).lastIndex) 4.dp else 2.dp
                    ),
                verticalAlignment = Alignment.CenterVertically,
                horizontalArrangement = Arrangement.spacedBy(2.dp)
            ) {
                urlChunk.forEach { urlItem ->
                    HomeCardView(
                        modifier = Modifier
                            .weight(1f)
                            .onGloballyPositioned {
                                homeCardHeight = it.size.height
                            },
                        imageUrl = urlItem.imageUrl
                    )
                }
                repeat(3 - urlChunk.size) {
                    HomeCardEmptyView(
                        modifier = Modifier
                            .weight(1f)
                            .height(
                                with(LocalDensity.current) {
                                    homeCardHeight.toDp()
                                }
                            )
                    )
                }
            }
        }

        item {
            Spacer(modifier = Modifier.height(4.dp))
            Image(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(horizontal = 10.dp),
                painter = painterResource(id = R.drawable.img_home_ad),
                contentDescription = null
            )
            Spacer(modifier = Modifier.height(48.dp))
            HomeFooter(
                modifier = Modifier.fillMaxWidth()
            )
            Spacer(modifier = Modifier.height(64.dp))
        }
    }
}

@Preview
@Composable
private fun HomeScreenPreview() {
    HomeRoute(
        padding = PaddingValues(),
        onNavigateToSearch = {}
    )
}
