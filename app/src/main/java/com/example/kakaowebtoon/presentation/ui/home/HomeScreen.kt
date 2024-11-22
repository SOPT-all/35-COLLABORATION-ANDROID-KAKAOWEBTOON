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
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.itemsIndexed
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import com.example.kakaowebtoon.R
import com.example.kakaowebtoon.presentation.type.IndicatorType
import com.example.kakaowebtoon.presentation.type.TopBarType
import com.example.kakaowebtoon.presentation.ui.component.KakaoWebtoonIIndicator
import com.example.kakaowebtoon.presentation.ui.component.KakaoWebtoonTopBar
import com.example.kakaowebtoon.presentation.ui.home.component.HomeBanner
import com.example.kakaowebtoon.presentation.ui.home.component.HomeCardEmptyView
import com.example.kakaowebtoon.presentation.ui.home.component.HomeCardView
import com.example.kakaowebtoon.presentation.ui.home.component.HomeFilterTextButton
import com.example.kakaowebtoon.presentation.ui.home.component.HomeFooter
import com.example.kakaowebtoon.presentation.ui.home.component.HomeGenreTabRow
import com.example.kakaowebtoon.ui.theme.KakaoWebtoonTheme

// TODO: merge 후 Constraints.kt 파일에 추가 예정
object HomeFilter {
    const val POPULAR = "인기순"
    const val ALL = "전체"
}

@Composable
fun HomeRoute(
    padding: PaddingValues,
    onNavigateToSearch: () -> Unit,
    modifier: Modifier = Modifier,
    viewModel: HomeViewModel = hiltViewModel()
) {
    val webtoonList by viewModel.webtoonList.collectAsStateWithLifecycle()

    // TODO: API 연동 필요
    LaunchedEffect(webtoonList) {
        if (webtoonList.isEmpty()) {
            viewModel.getWebtoonList()
        }
    }

    HomeScreen(
        webtoonList = webtoonList,
        modifier = modifier.padding(padding),
        onNavigateToSearch = onNavigateToSearch
    )
}

@OptIn(ExperimentalFoundationApi::class)
@Composable
fun HomeScreen(
    webtoonList: List<String>,
    onNavigateToSearch: () -> Unit,
    modifier: Modifier = Modifier
) {
    LazyColumn(
        modifier = modifier
    ) {
        item {
            KakaoWebtoonTopBar(TopBarType.Home)
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
                KakaoWebtoonIIndicator(
                    modifier = Modifier.padding(top = 8.dp),
                    indicatorType = IndicatorType.MAIN
                )
                HomeGenreTabRow(
                    modifier = Modifier.padding(bottom = 7.dp)
                )
                Row(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(horizontal = 10.dp)
                        .padding(bottom = 8.dp),
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    Text(
                        modifier = Modifier.padding(vertical = 3.5.dp, horizontal = 4.dp),
                        text = stringResource(R.string.home_content_total_count, 28),
                        style = KakaoWebtoonTheme.typography.body6Regular,
                        color = KakaoWebtoonTheme.colors.white
                    )
                    Spacer(modifier = Modifier.weight(1f))
                    HomeFilterTextButton(HomeFilter.POPULAR)
                    HomeFilterTextButton(HomeFilter.ALL)
                }
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
                    .padding(horizontal = 10.dp)
                    .padding(
                        bottom = if (index == webtoonList.chunked(3).lastIndex) 4.dp else 2.dp
                    ),
                verticalAlignment = Alignment.CenterVertically,
                horizontalArrangement = Arrangement.spacedBy(2.dp)
            ) {
                urlChunk.forEach { url ->
                    HomeCardView(
                        modifier = Modifier.weight(1f),
                        imageUrl = url
                    )
                }
                repeat(3 - urlChunk.size) {
                    HomeCardEmptyView(
                        modifier = Modifier.weight(1f)
                    )
                }
            }
        }

        item {
            Image(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(top = 4.dp)
                    .padding(horizontal = 10.dp),
                painter = painterResource(id = R.drawable.img_home_ad),
                contentDescription = null
            )
            HomeFooter(
                modifier = Modifier
                    .padding(top = 48.dp, bottom = 64.dp)
                    .fillMaxWidth()
            )
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
