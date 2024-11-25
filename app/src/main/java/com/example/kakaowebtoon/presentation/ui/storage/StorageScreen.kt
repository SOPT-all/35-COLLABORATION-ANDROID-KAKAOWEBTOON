package com.example.kakaowebtoon.presentation.ui.storage

import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import com.example.kakaowebtoon.domain.model.WebtoonCard
import com.example.kakaowebtoon.presentation.type.IndicatorType
import com.example.kakaowebtoon.presentation.type.StorageButtonType
import com.example.kakaowebtoon.presentation.type.TopBarType
import com.example.kakaowebtoon.presentation.ui.component.KakaoWebtoonTopBar
import com.example.kakaowebtoon.presentation.ui.component.card.KakaoWebtoonCard
import com.example.kakaowebtoon.presentation.ui.component.indicator.KakaoWebtoonIIndicator
import com.example.kakaowebtoon.presentation.ui.storage.component.StorageButton
import com.example.kakaowebtoon.ui.theme.defaultKakaoWebtoonColors

@Composable
fun StorageRoute(
    padding: PaddingValues,
    onNavigateToSearch: () -> Unit,
    modifier: Modifier = Modifier,
    viewModel: StorageViewModel = hiltViewModel()
) {
    val recentWebtoonCards by viewModel.recentWebtoonList.collectAsState()

    StorageScreen(
        recentWebtoonCards = recentWebtoonCards,
        onNavigateToSearch = onNavigateToSearch,
        modifier = modifier.padding(padding)
    )
}

@OptIn(ExperimentalFoundationApi::class)
@Composable
fun StorageScreen(
    recentWebtoonCards: List<WebtoonCard>,
    onNavigateToSearch: () -> Unit,
    modifier: Modifier = Modifier
) {
    Box(
        modifier = modifier
            .fillMaxSize()
            .background(defaultKakaoWebtoonColors.black3)
    ) {
        LazyColumn(
            modifier = Modifier.fillMaxSize()
        ) {
            item {
                KakaoWebtoonTopBar(
                    topBarType = TopBarType.Storage,
                    secondIconOnClick = onNavigateToSearch
                )
            }
            stickyHeader {
                Column(
                    modifier = Modifier
                        .background(defaultKakaoWebtoonColors.black3)
                        .padding(top = 5.dp, bottom = 10.dp)
                ) {
                    KakaoWebtoonIIndicator(
                        modifier = Modifier.padding(horizontal = 17.dp),
                        indicatorType = IndicatorType.Storage
                    )
                    Spacer(modifier = Modifier.height(3.dp))
                    Row(
                        modifier = Modifier.padding(horizontal = 10.dp)
                    ) {
                        StorageButton(
                            storageButtonType = StorageButtonType.SORT,
                            modifier = Modifier.weight(1f)
                        )
                        Spacer(modifier = Modifier.width(10.dp))
                        StorageButton(
                            storageButtonType = StorageButtonType.EDIT,
                            modifier = Modifier.weight(1f)
                        )
                    }
                }
            }
            items(recentWebtoonCards) { card ->
                Column(modifier = Modifier.padding(horizontal = 10.dp)) {
                    KakaoWebtoonCard(card)
                    Spacer(modifier = Modifier.height(10.dp))
                }
            }
        }
    }
}

@Preview
@Composable
private fun SearchScreenPreview() {
//    StorageScreen(onNavigateToSearch = {})
}
