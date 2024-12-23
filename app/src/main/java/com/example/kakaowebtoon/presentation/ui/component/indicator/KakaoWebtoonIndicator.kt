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
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.kakaowebtoon.presentation.type.IndicatorType
import com.example.kakaowebtoon.presentation.util.noRippleClickable
import com.example.kakaowebtoon.presentation.util.showIf
import com.example.kakaowebtoon.ui.theme.defaultKakaoWebtoonColors

@Composable
fun KakaoWebtoonIIndicator(
    indicatorType: IndicatorType,
    modifier: Modifier = Modifier,
    selectedIndex: Int = 0,
    onIndexSelected: (Int) -> Unit = { }
) {
    Row(
        modifier = modifier
            .fillMaxWidth(),
        horizontalArrangement = Arrangement.SpaceBetween,
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
                        onIndexSelected(index)
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
                        .background(indicatorType.indicatorColor, shape = RoundedCornerShape(5.dp))
                        .showIf(selectedIndex == index)
                )
            }
        }
    }
}

@Preview
@Composable
private fun BaseIndicatorPreview() {
    Column(modifier = Modifier.background(color = defaultKakaoWebtoonColors.black3)) {
        KakaoWebtoonIIndicator(
            modifier = Modifier.padding(horizontal = 47.dp),
            indicatorType = IndicatorType.MAIN
        )
        KakaoWebtoonIIndicator(
            modifier = Modifier.padding(horizontal = 93.dp),
            indicatorType = IndicatorType.Episode
        )
        KakaoWebtoonIIndicator(
            modifier = Modifier.padding(horizontal = 17.dp),
            indicatorType = IndicatorType.Storage
        )
    }
}
