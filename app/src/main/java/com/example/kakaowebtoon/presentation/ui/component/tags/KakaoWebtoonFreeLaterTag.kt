package com.example.kakaowebtoon.presentation.ui.component.tags

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.res.vectorResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.kakaowebtoon.R
import com.example.kakaowebtoon.ui.theme.KakaoWebtoonTheme

@Composable
fun KakaoWebtoonFreeLaterTag(modifier: Modifier = Modifier) {
    Row(modifier = modifier, verticalAlignment = Alignment.CenterVertically) {
        Image(
            imageVector = ImageVector.vectorResource(R.drawable.ic_chip_clock),
            contentDescription = null,
            modifier = Modifier
                .background(
                    color = KakaoWebtoonTheme.colors.yellow2,
                    shape = RoundedCornerShape(topStart = 5.dp, bottomStart = 5.dp)
                )
                .padding(2.dp)
        )
        Text(
            text = "3다무",
            style = KakaoWebtoonTheme.typography.caption4ExtraBold,
            color = KakaoWebtoonTheme.colors.black4,
            modifier = Modifier
                .background(
                    color = KakaoWebtoonTheme.colors.white,
                    shape = RoundedCornerShape(topEnd = 5.dp, bottomEnd = 5.dp)
                )
                .padding(vertical = 1.dp, horizontal = 3.dp)
                .wrapContentHeight(Alignment.CenterVertically)

        )
    }
}

@Preview
@Composable
private fun KakaoWebtoonFreeLaterTagDetailDetail() {
    KakaoWebtoonFreeLaterTag()
}
