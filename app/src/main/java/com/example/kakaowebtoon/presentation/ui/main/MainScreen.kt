package com.example.kakaowebtoon.presentation.ui.main

import androidx.compose.foundation.layout.navigationBarsPadding
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.example.kakaowebtoon.presentation.type.MainBottomNavType
import com.example.kakaowebtoon.presentation.ui.main.component.MainBottomNavBar
import com.example.kakaowebtoon.presentation.ui.main.component.MainNavHost
import com.example.kakaowebtoon.ui.theme.KakaoWebtoonTheme
import kotlinx.collections.immutable.toPersistentList

@Composable
fun MainScreen(
    navigator: MainNavigator = rememberMainNavigator()
) {
    Scaffold(
        modifier = Modifier,
        containerColor = KakaoWebtoonTheme.colors.black3,
        bottomBar = {
            MainBottomNavBar(
                modifier = Modifier.navigationBarsPadding(),
                visible = navigator.showBottomBar(),
                tabs = MainBottomNavType.entries.toPersistentList(),
                currentTab = navigator.currentTab,
                onTabSelected = { navigator.navigate(it) }
            )
        }
    ) { innerPadding ->
        MainNavHost(
            navigator = navigator,
            padding = innerPadding
        )
    }
}

@Preview
@Composable
private fun MainScreenPreview() {
    MainScreen()
}
