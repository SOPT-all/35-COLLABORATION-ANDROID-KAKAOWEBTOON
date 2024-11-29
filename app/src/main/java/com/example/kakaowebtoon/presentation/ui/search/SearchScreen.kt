package com.example.kakaowebtoon.presentation.ui.search

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.res.vectorResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import com.example.kakaowebtoon.R
import com.example.kakaowebtoon.domain.model.WebtoonCard
import com.example.kakaowebtoon.presentation.ui.component.card.KakaoWebtoonCard
import com.example.kakaowebtoon.presentation.ui.search.component.SearchTextField
import com.example.kakaowebtoon.presentation.ui.search.component.SearchViewIndicator
import com.example.kakaowebtoon.presentation.util.Search.EPISODE_TITLE
import com.example.kakaowebtoon.presentation.util.noRippleClickable
import com.example.kakaowebtoon.ui.theme.KakaoWebtoonTheme

@Composable
fun SearchRoute(
    padding: PaddingValues,
    popUpBackStack: () -> Unit,
    modifier: Modifier = Modifier,
    viewModel: SearchViewModel = hiltViewModel(),
    onNavigateToEpisode: () -> Unit = {}
) {
    val webtoonCards by viewModel.webtoonSearchList.collectAsState()
    val webtoonDummyCards by viewModel.webtoonDummyList.collectAsState()
    val searchText by viewModel.searchText.collectAsState()

    SearchScreen(
        searchCount = webtoonCards.size,
        popUpBackStack = popUpBackStack,
        webtoonCards = webtoonCards,
        webtoonDummyCards = webtoonDummyCards,
        searchText = searchText,
        onSearchTextChange = viewModel::updateSearchText,
        modifier = modifier.padding(padding),
        onNavigateToEpisode = onNavigateToEpisode
    )
}

@Composable
fun SearchScreen(
    searchCount: Int,
    popUpBackStack: () -> Unit,
    webtoonCards: List<WebtoonCard>,
    webtoonDummyCards: List<WebtoonCard>,
    searchText: String,
    onSearchTextChange: (String) -> Unit,
    modifier: Modifier = Modifier,
    onNavigateToEpisode: () -> Unit = {}
) {
    Column(
        modifier = modifier
            .fillMaxSize()
            .background(color = KakaoWebtoonTheme.colors.black3)
    ) {
        Spacer(modifier = Modifier.height(30.dp))
        SearchTextField(
            value = searchText,
            onValueChange = onSearchTextChange,
            placeholder = stringResource(R.string.search_text_field_placeholder),
            popUpBackStack = popUpBackStack
        )
        Spacer(modifier = Modifier.height(9.dp))
        SearchViewIndicator()
        Spacer(modifier = Modifier.height(13.dp))
        LazyColumn(
            modifier = Modifier
                .fillMaxSize()
                .padding(horizontal = 10.dp)
        ) {
            item {
                Row(
                    modifier = Modifier
                        .fillMaxWidth()
                ) {
                    Text(
                        text = stringResource(R.string.search_first_webtoon_list, searchCount),
                        style = KakaoWebtoonTheme.typography.body1Regular,
                        color = KakaoWebtoonTheme.colors.white
                    )
                    Spacer(modifier = Modifier.weight(1f))
                    Text(
                        text = stringResource(R.string.search_filtering_popularity),
                        style = KakaoWebtoonTheme.typography.body1Regular,
                        color = KakaoWebtoonTheme.colors.white
                    )
                    Icon(
                        imageVector = ImageVector.vectorResource(R.drawable.ic_search_arrow_under_white_18),
                        tint = KakaoWebtoonTheme.colors.white,
                        contentDescription = stringResource(R.string.search_under_arrow_icon_description)
                    )
                }
            }
            item {
                Spacer(modifier = Modifier.height(10.dp))
            }

            items(webtoonCards) { card ->
                KakaoWebtoonCard(
                    card,
                    modifier = Modifier.noRippleClickable {
                        if (card.title == EPISODE_TITLE) {
                            onNavigateToEpisode()
                        } else {
                            Unit
                        }
                    }
                )
                Spacer(modifier = Modifier.height(13.dp))
            }

            item {
                Spacer(modifier = Modifier.height(16.dp))
                Text(
                    text = stringResource(R.string.search_recommend_webtoon_list),
                    style = KakaoWebtoonTheme.typography.body1Regular,
                    color = KakaoWebtoonTheme.colors.white
                )
                Spacer(modifier = Modifier.height(13.dp))
            }

            items(webtoonDummyCards) { card ->
                KakaoWebtoonCard(card)
                Spacer(modifier = Modifier.height(13.dp))
            }
        }
    }
}

@Preview
@Composable
private fun SearchScreenPreview() {
//    SearchScreen(popUpBackStack = {})
}
