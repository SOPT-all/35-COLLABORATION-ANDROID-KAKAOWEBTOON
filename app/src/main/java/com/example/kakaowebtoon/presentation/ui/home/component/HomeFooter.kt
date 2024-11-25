package com.example.kakaowebtoon.presentation.ui.home.component

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.res.vectorResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.kakaowebtoon.R
import com.example.kakaowebtoon.ui.theme.KakaoWebtoonTheme

@Composable
fun HomeFooter(
    modifier: Modifier = Modifier
) {
    val footerItems = listOf(
        stringResource(R.string.home_footer_private_policy),
        stringResource(R.string.home_footer_terms_of_use),
        stringResource(R.string.home_footer_customer_service),
        stringResource(R.string.home_footer_business_information)
    )
    Column(
        modifier = modifier,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Row(
            modifier = Modifier.padding(2.dp),
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.spacedBy(4.dp)
        ) {
            footerItems.forEachIndexed { index, item ->
                Text(
                    text = item,
                    style = KakaoWebtoonTheme.typography.body4SemiBold,
                    color = KakaoWebtoonTheme.colors.grey2
                )
                if (index != footerItems.lastIndex) {
                    Icon(
                        imageVector = ImageVector.vectorResource(R.drawable.ic_home_vertical_line),
                        contentDescription = null,
                        tint = KakaoWebtoonTheme.colors.grey5
                    )
                }
            }
        }
        Text(
            text = stringResource(R.string.home_footer_copyright),
            style = KakaoWebtoonTheme.typography.body5Regular,
            color = KakaoWebtoonTheme.colors.darkGrey5
        )
    }
}

@Preview
@Composable
private fun HomeFooterPreview() {
    KakaoWebtoonTheme {
        HomeFooter()
    }
}
