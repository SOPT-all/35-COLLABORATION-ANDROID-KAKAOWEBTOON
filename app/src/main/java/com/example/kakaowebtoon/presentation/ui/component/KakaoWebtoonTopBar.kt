package com.example.kakaowebtoon.presentation.ui.component

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.res.vectorResource
import androidx.compose.ui.unit.dp
import com.example.kakaowebtoon.presentation.type.TopBarType
import com.example.kakaowebtoon.presentation.util.noRippleClickable
import com.example.kakaowebtoon.ui.theme.defaultKakaoWebtoonColors
import com.example.kakaowebtoon.ui.theme.defaultKakaoWebtoonTypography

@Composable
fun KakaoWebtoonTopBar(
    topBarType: TopBarType,
    modifier: Modifier = Modifier
) {
    Row(
        modifier = modifier
            .fillMaxWidth()
            .padding(8.dp),
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.SpaceBetween
    ) {
        Icon(
            imageVector = ImageVector.vectorResource(topBarType.firstIconResId),
            contentDescription = null,
            modifier = Modifier
                .noRippleClickable {
                    topBarType.firstIconOnClick?.invoke()
                }
        )

        Box(
            modifier = Modifier.weight(1f),
            contentAlignment = Alignment.Center
        ) {
            if (topBarType.storageTitleResId != null) {
                Text(
                    text = stringResource(topBarType.storageTitleResId),
                    color = defaultKakaoWebtoonColors.white,
                    style = defaultKakaoWebtoonTypography.head2Bold
                )
            } else if (topBarType.mainImageResId != null) {
                Icon(
                    imageVector = ImageVector.vectorResource(topBarType.mainImageResId),
                    contentDescription = null,
                    modifier =
                )
            }
        }
    }
}