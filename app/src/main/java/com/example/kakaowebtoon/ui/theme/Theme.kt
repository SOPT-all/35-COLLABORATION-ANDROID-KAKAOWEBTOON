package com.example.kakaowebtoon.ui.theme

import android.app.Activity
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.runtime.CompositionLocalProvider
import androidx.compose.runtime.ReadOnlyComposable
import androidx.compose.runtime.SideEffect
import androidx.compose.ui.platform.LocalView
import androidx.core.view.WindowCompat

object KakaoWebtoonTheme {
    val colors: KakaoWebtoonColors
        @Composable
        @ReadOnlyComposable
        get() = LocalKakaoWebtoonColors.current

    val typography: KakaoTypography
        @Composable
        @ReadOnlyComposable
        get() = LocalKakaoWebtoonTypography.current
}

@Composable
fun ProvideKakaoWebttonColorsAndTypography(
    colors: KakaoWebtoonColors,
    typography: KakaoTypography,
    content: @Composable () -> Unit
) {
    CompositionLocalProvider(
        LocalKakaoWebtoonColors provides colors,
        LocalKakaoWebtoonTypography provides typography,
        content = content
    )
}

@Composable
fun KakaoWebtoonTheme(
    content: @Composable () -> Unit
) {
    ProvideKakaoWebttonColorsAndTypography(
        colors = defaultKakaoWebtoonColors,
        typography = defaultKakaoWebtoonTypography
    ) {
        val view = LocalView.current
        if (!view.isInEditMode) {
            SideEffect {
                (view.context as Activity).window.run {
                    WindowCompat.getInsetsController(this, view).isAppearanceLightStatusBars = false
                }
            }
        }
        MaterialTheme(
            typography = Typography,
            content = content
        )
    }
}
