package com.example.kakaowebtoon.ui.theme

import androidx.compose.material3.Typography
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.sp
import com.example.kakaowebtoon.R

// Set of Material typography styles to start with
val Typography = Typography(
    bodyLarge = TextStyle(
        fontFamily = FontFamily.Default,
        fontWeight = FontWeight.Normal,
        fontSize = 16.sp,
        lineHeight = 24.sp,
        letterSpacing = 0.5.sp
    )
)

data class KakaoTypography(
    val head1SemiBold: TextStyle,
    val head2Bold: TextStyle,
    val title1ExtraBold: TextStyle,
    val title2SemiBold: TextStyle,
    val title3SemiBold: TextStyle,
    val title4SemiBold: TextStyle,
    val body1Regular: TextStyle,
    val body2Regular: TextStyle,
    val body3Regular: TextStyle,
    val body4SemiBold: TextStyle,
    val body5Regular: TextStyle,
    val body6Regular: TextStyle,
    val caption1Bold: TextStyle,
    val caption2Medium: TextStyle,
    val caption3Light: TextStyle,
    val caption4SemiBold: TextStyle
)

val KakaoWebtoonTypography = KakaoTypography(
    // Head
    head1SemiBold = TextStyle(
        fontFamily = FontFamily(Font(R.font.roboto_bold)),
        fontWeight = FontWeight.SemiBold,
        fontSize = 20.sp,
        lineHeight = 23.sp,
        letterSpacing = (-0.4).sp
    ),
    head2Bold = TextStyle(
        fontFamily = FontFamily(Font(R.font.roboto_bold)),
        fontWeight = FontWeight.Bold,
        fontSize = 16.sp,
        lineHeight = 23.sp,
        letterSpacing = (-0.32).sp
    ),

// Title
    title1ExtraBold = TextStyle(
        fontFamily = FontFamily(Font(R.font.roboto_bold)),
        fontWeight = FontWeight.ExtraBold,
        fontSize = 16.sp,
        lineHeight = 23.sp,
        letterSpacing = (-0.32).sp
    ),
    title2SemiBold = TextStyle(
        fontFamily = FontFamily(Font(R.font.roboto_bold)),
        fontWeight = FontWeight.SemiBold,
        fontSize = 15.sp,
        lineHeight = 18.sp,
        letterSpacing = 0.sp
    ),
    title3SemiBold = TextStyle(
        fontFamily = FontFamily(Font(R.font.roboto_bold)),
        fontWeight = FontWeight.SemiBold,
        fontSize = 14.sp,
        lineHeight = 16.sp,
        letterSpacing = (-0.28).sp
    ),
    title4SemiBold = TextStyle(
        fontFamily = FontFamily(Font(R.font.roboto_bold)),
        fontWeight = FontWeight.SemiBold,
        fontSize = 12.sp,
        lineHeight = 14.sp,
        letterSpacing = (-0.24).sp
    ),

// Body
    body1Regular = TextStyle(
        fontFamily = FontFamily(Font(R.font.roboto_regular)),
        fontWeight = FontWeight.Normal,
        fontSize = 13.sp,
        lineHeight = (15.6).sp,
        letterSpacing = (-0.13).sp
    ),
    body2Regular = TextStyle(
        fontFamily = FontFamily(Font(R.font.roboto_regular)),
        fontWeight = FontWeight.Normal,
        fontSize = 12.sp,
        lineHeight = (14.4).sp,
        letterSpacing = (-0.12).sp
    ),
    body3Regular = TextStyle(
        fontFamily = FontFamily(Font(R.font.roboto_regular)),
        fontWeight = FontWeight.Normal,
        fontSize = 11.sp,
        lineHeight = (13).sp,
        letterSpacing = (-0.22).sp
    ),
    body4SemiBold = TextStyle(
        fontFamily = FontFamily(Font(R.font.roboto_bold)),
        fontWeight = FontWeight.SemiBold,
        fontSize = 10.sp,
        lineHeight = 13.sp,
        letterSpacing = (-0.2).sp
    ),
    body5Regular = TextStyle(
        fontFamily = FontFamily(Font(R.font.roboto_regular)),
        fontWeight = FontWeight.Normal,
        fontSize = 10.sp,
        lineHeight = (13).sp,
        letterSpacing = (-0.2).sp
    ),
    body6Regular = TextStyle(
        fontFamily = FontFamily(Font(R.font.roboto_regular)),
        fontWeight = FontWeight.Normal,
        fontSize = 10.sp,
        lineHeight = (13).sp,
        letterSpacing = (0).sp
    ),

// Caption
    caption1Bold = TextStyle(
        fontFamily = FontFamily(Font(R.font.roboto_bold)),
        fontWeight = FontWeight.Bold,
        fontSize = 17.sp,
        lineHeight = (20.4).sp,
        letterSpacing = (-0.17).sp
    ),
    caption2Medium = TextStyle(
        fontFamily = FontFamily(Font(R.font.roboto_medium)),
        fontWeight = FontWeight.Medium,
        fontSize = 10.sp,
        lineHeight = (12).sp,
        letterSpacing = (-0.2).sp
    ),
    caption3Light = TextStyle(
        fontFamily = FontFamily(Font(R.font.roboto_light)),
        fontWeight = FontWeight.Light,
        fontSize = 10.sp,
        lineHeight = (12).sp,
        letterSpacing = (-0.1).sp
    ),
    caption4SemiBold = TextStyle(
        fontFamily = FontFamily(Font(R.font.roboto_bold)),
        fontWeight = FontWeight.SemiBold,
        fontSize = 8.sp,
        lineHeight = (12).sp,
        letterSpacing = (-0.1).sp
    )
)