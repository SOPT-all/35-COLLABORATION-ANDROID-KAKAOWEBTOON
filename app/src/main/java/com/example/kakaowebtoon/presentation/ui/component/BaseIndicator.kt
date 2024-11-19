package com.example.kakaowebtoon.presentation.ui.component

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.example.kakaowebtoon.presentation.type.IndicatorType

@Composable
fun Indicator(
    indicatorType: IndicatorType,
    modifier: Modifier = Modifier
) {
    Row(
        modifier = modifier.fillMaxWidth(),
        horizontalArrangement = Arrangement.spacedBy(indicatorType.spaceBy)
    ) {
        indicatorType.contentsList.forEach { content ->
            Text(
                text = content,
                style = indicatorType.typoStyle,
                color = indicatorType.selectedFontColor
            )
        }
    }
}

@Preview
@Composable
private fun BaseIndicatorPreview() {
    Indicator(indicatorType = IndicatorType.MAIN)
}
