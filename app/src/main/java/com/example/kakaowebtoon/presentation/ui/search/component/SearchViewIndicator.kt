package com.example.kakaowebtoon.presentation.ui.search.component

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.IntrinsicSize
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.kakaowebtoon.presentation.type.IndicatorType
import com.example.kakaowebtoon.presentation.util.noRippleClickable
import com.example.kakaowebtoon.ui.theme.defaultKakaoWebtoonColors

@Composable
fun SearchViewIndicator(
    modifier: Modifier = Modifier,
    indicatorType: IndicatorType = IndicatorType.Search
) {
    var selectedIndex by remember { mutableIntStateOf(0) }

    Row(
        modifier = modifier
            .fillMaxWidth()
            .height(IntrinsicSize.Min)
    ) {
        indicatorType.contentsList.forEachIndexed { index, content ->
            Column(
                modifier = Modifier
                    .weight(1f)
                    .noRippleClickable { selectedIndex = index },
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                Spacer(modifier = Modifier.height(indicatorType.spacerHeight))
                Text(
                    text = content,
                    style = indicatorType.typoStyle,
                    color = if (selectedIndex == index) indicatorType.selectedFontColor else indicatorType.unSelectedFontColor
                )
                Spacer(modifier = Modifier.height(indicatorType.spacerHeight))

                Box(
                    modifier = Modifier
                        .padding(
                            top = if (selectedIndex == index) 0.dp else 1.dp
                        )
                        .height(if (selectedIndex == index) 3.dp else 2.dp)
                        .fillMaxWidth()
                        .background(
                            color = if (selectedIndex == index) indicatorType.indicatorColor else defaultKakaoWebtoonColors.darkGrey7
                        )
                )
            }
        }
    }
}

@Preview
@Composable
private fun SearchIndicatorPreview() {
    Column(modifier = Modifier.background(color = defaultKakaoWebtoonColors.black3)) {
        SearchViewIndicator()
    }
}
