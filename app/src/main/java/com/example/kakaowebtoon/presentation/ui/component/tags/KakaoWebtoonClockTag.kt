package com.example.kakaowebtoon.presentation.ui.component.tags

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.res.vectorResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.kakaowebtoon.R
import com.example.kakaowebtoon.ui.theme.defaultKakaoWebtoonColors

@Composable
fun KakaoWebtoonClockTag(modifier: Modifier = Modifier) {
    Image(
        imageVector = ImageVector.vectorResource(id = R.drawable.ic_chip_clock),
        contentDescription = null,
        modifier = modifier

            .background(color = defaultKakaoWebtoonColors.yellow2, shape = RoundedCornerShape(5.dp))
            .padding(2.dp)
    )

}

@Preview
@Composable
private fun KakaoWebtoonFreeLaterTagPreview() {
    KakaoWebtoonClockTag()
}
