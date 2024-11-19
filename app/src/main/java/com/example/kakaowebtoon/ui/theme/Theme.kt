package com.example.kakaowebtoon.ui.theme

import android.app.Activity
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.runtime.CompositionLocalProvider
import androidx.compose.runtime.ReadOnlyComposable
import androidx.compose.runtime.SideEffect
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.toArgb
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
        get() = KakaoWebtoonTypography
}

@Composable
fun ProvideKakaoWebttonColorsAndTypography(
    colors: KakaoWebtoonColors,
    content: @Composable () -> Unit
) {
    CompositionLocalProvider(
        LocalKakaoWebtoonColors provides colors,
        content = content
    )
}

@Composable
fun KakaoWebtoonTheme(
    backgroundColor: Color = defaultKakaoWebtoonColors.white,
    content: @Composable () -> Unit
) {
    ProvideKakaoWebttonColorsAndTypography(colors = defaultKakaoWebtoonColors) {
        val view = LocalView.current
        if (!view.isInEditMode) {
            SideEffect {
                (view.context as Activity).window.run {
                    statusBarColor = backgroundColor.toArgb()
                    WindowCompat.getInsetsController(this, view).isAppearanceLightStatusBars = true
                }
            }
        }
        MaterialTheme(
            typography = Typography,
            content = content
        )
    }
}
