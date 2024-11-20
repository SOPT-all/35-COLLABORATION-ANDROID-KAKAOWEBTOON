package com.example.kakaowebtoon.presentation.ui.component.indicator

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.IntrinsicSize
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.layout.wrapContentWidth
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.kakaowebtoon.presentation.type.IndicatorType
import com.example.kakaowebtoon.presentation.util.noRippleClickable
import com.example.kakaowebtoon.ui.theme.defaultKakaoWebtoonColors

@Composable
fun KakaoWebtoonIIndicator(
    indicatorType: IndicatorType,
    modifier: Modifier = Modifier
) {
    var selectedIndex by remember { mutableIntStateOf(0) }
    Row(
        modifier = modifier
            .fillMaxWidth(),
        horizontalArrangement = Arrangement.Center,
        verticalAlignment = Alignment.CenterVertically
    ) {
        Row(
            horizontalArrangement = Arrangement.spacedBy(indicatorType.spaceBy),
            verticalAlignment = Alignment.CenterVertically
        ) {
            indicatorType.contentsList.forEachIndexed { index, content ->
                Column(
                    horizontalAlignment = Alignment.CenterHorizontally,
                    modifier = Modifier
                        .wrapContentWidth()
                        .width(IntrinsicSize.Max)
                        .padding(horizontal = 7.dp, vertical = 4.dp)
                        .noRippleClickable {
                            selectedIndex = index
                        }
                ) {
                    Text(
                        text = content,
                        style = indicatorType.typoStyle,
                        color = if (selectedIndex == index) {
                            indicatorType.selectedFontColor
                        } else {
                            indicatorType.unSelectedFontColor
                        }
                    )
                    Spacer(modifier = Modifier.height(indicatorType.spacerHeight))
                    Box(
                        modifier = Modifier
                            .height(2.dp)
                            .fillMaxWidth()
                            .background(
                                color = if (selectedIndex == index) {
                                    indicatorType.indicatorColor
                                } else {
                                    Color.Transparent
                                }
                            )
                    )
                }
            }
        }
    }
}

@Preview
@Composable
private fun BaseIndicatorPreview() {
    Column(modifier = Modifier.background(color = defaultKakaoWebtoonColors.black3)) {
        KakaoWebtoonIIndicator(indicatorType = IndicatorType.MAIN)
        KakaoWebtoonIIndicator(indicatorType = IndicatorType.Episode)
        KakaoWebtoonIIndicator(indicatorType = IndicatorType.Storage)
    }
}
