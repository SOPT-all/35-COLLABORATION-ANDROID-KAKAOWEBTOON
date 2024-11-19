package com.example.kakaowebtoon.presentation.ui.main

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import com.example.kakaowebtoon.ui.theme.KakaoWebtoonTheme
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()

        setContent {
            val navigator: MainNavigator = rememberMainNavigator()
            KakaoWebtoonTheme {
                MainScreen(
                    navigator = navigator
                )
            }
        }
    }
}
