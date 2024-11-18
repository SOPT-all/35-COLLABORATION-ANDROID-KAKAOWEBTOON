package com.example.kakaowebtoon.ui.theme

import androidx.compose.runtime.Immutable
import androidx.compose.runtime.staticCompositionLocalOf
import androidx.compose.ui.graphics.Color

val Red = Color(0xFFF63639)
val Yellow1 = Color(0xFFF8D447)
val Yellow2 = Color(0xFFFCD300)
val Blue = Color(0xFF4FBAFF)

val White = Color(0xFFFFFFFF)
val White50 = Color(0x80FFFFFF)
val Transparent = Color(0x00FFFFFF)

val Grey1 = Color(0xFFD0D0D0)
val Grey2 = Color(0xFF999999)
val Grey3 = Color(0xFF8A8A8A)
val Grey4 = Color(0xFF818181)
val Grey5 = Color(0xFF777777)
val Grey6 = Color(0xFF747474)

val DarkGrey1 = Color(0x005F5F5F)
val DarkGrey2 = Color(0x005C5C5C)
val DarkGrey3 = Color(0x00515151)
val DarkGrey4 = Color(0x004C4C4C)
val DarkGrey5 = Color(0x00444444)
val DarkGrey6 = Color(0x003D3D3D)
val DarkGrey7 = Color(0x00333333)

val Black1 = Color(0x00222222)
val Black2 = Color(0x001E1E1E)
val Black3 = Color(0x00121212)
val Black4 = Color(0x00000000)


@Immutable
data class KakaoWebtoonColors(
    // primary
    val red: Color,
    val yellow1: Color,
    val yellow2: Color,
    val blue: Color,

    // grayscale
    val white: Color,
    val white50: Color,
    val transparent: Color,

    val grey1: Color,
    val grey2: Color,
    val grey3: Color,
    val grey4: Color,
    val grey5: Color,
    val grey6: Color,

    val darkGrey1: Color,
    val darkGrey2: Color,
    val darkGrey3: Color,
    val darkGrey4: Color,
    val darkGrey5: Color,
    val darkGrey6: Color,
    val darkGrey7: Color,

    val black1: Color,
    val black2: Color,
    val black3: Color,
    val black4: Color
)

val defaultKakaoWebtoonColors = KakaoWebtoonColors(
    // primary
    red = Red,
    yellow1 = Yellow1,
    yellow2 = Yellow2,
    blue = Blue,

    // grayscale
    white = White,
    white50 = White50,
    transparent = Transparent,

    grey1 = Grey1,
    grey2 = Grey2,
    grey3 = Grey3,
    grey4 = Grey4,
    grey5 = Grey5,
    grey6 = Grey6,

    darkGrey1 = DarkGrey1,
    darkGrey2 = DarkGrey2,
    darkGrey3 = DarkGrey3,
    darkGrey4 = DarkGrey4,
    darkGrey5 = DarkGrey5,
    darkGrey6 = DarkGrey6,
    darkGrey7 = DarkGrey7,

    black1 = Black1,
    black2 = Black2,
    black3 = Black3,
    black4 = Black4
)

val LocalKakaoWebtoonColors = staticCompositionLocalOf { defaultKakaoWebtoonColors }