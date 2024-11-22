package com.example.kakaowebtoon.presentation.ui.home.component

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.res.vectorResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.kakaowebtoon.R
import com.example.kakaowebtoon.presentation.util.noRippleClickable
import com.example.kakaowebtoon.ui.theme.KakaoWebtoonTheme

@Composable
fun HomeBanner(
    onBannerClick: () -> Unit,
    modifier: Modifier = Modifier
) {
    Box(
        modifier = modifier
            .padding(top = 4.dp)
            .padding(horizontal = 10.dp),
        contentAlignment = Alignment.BottomCenter
    ) {
        Image(
            modifier = Modifier.fillMaxWidth(),
            painter = painterResource(R.drawable.img_home_banner_background),
            contentDescription = stringResource(R.string.home_banner),
            contentScale = ContentScale.FillWidth
        )
        Image(
            painter = painterResource(R.drawable.img_home_banner_character),
            contentDescription = stringResource(R.string.home_banner),
        )
        HomeBannerButton(
            // TODO: 추후 Banner 관련 기능 디벨롭 시 구현
            modifier = Modifier.noRippleClickable(onBannerClick)
        )
    }
}

@Composable
private fun HomeBannerButton(
    modifier: Modifier = Modifier
) {
    Row(
        modifier = modifier
            .clip(RoundedCornerShape(0.dp, 0.dp, 12.dp, 12.dp))
            .background(KakaoWebtoonTheme.colors.blue)
            .padding(10.dp),
        verticalAlignment = Alignment.CenterVertically
    ) {
        Text(
            modifier = Modifier.padding(end = 4.dp),
            text = stringResource(R.string.home_banner_button_title),
            style = KakaoWebtoonTheme.typography.body2Regular,
            color = KakaoWebtoonTheme.colors.white
        )
        Text(
            text = stringResource(R.string.home_banner_button_episode),
            style = KakaoWebtoonTheme.typography.body2Regular,
            color = KakaoWebtoonTheme.colors.white
        )
        Spacer(modifier = Modifier.weight(1f))
        Row(
            verticalAlignment = Alignment.CenterVertically
        ) {
            Text(
                text = stringResource(R.string.home_banner_button_continue),
                style = KakaoWebtoonTheme.typography.body6Regular,
                color = KakaoWebtoonTheme.colors.white
            )
            Icon(
                modifier = Modifier.padding(4.dp, 1.dp, 5.dp, 1.dp),
                imageVector = ImageVector.vectorResource(R.drawable.ic_home_arrow_right),
                contentDescription = stringResource(R.string.home_banner_button_continue),
                tint = KakaoWebtoonTheme.colors.white
            )
        }
    }
}

@Preview
@Composable
private fun HomeBannerPreview() {
    KakaoWebtoonTheme {
        HomeBanner(onBannerClick = {})
    }
}