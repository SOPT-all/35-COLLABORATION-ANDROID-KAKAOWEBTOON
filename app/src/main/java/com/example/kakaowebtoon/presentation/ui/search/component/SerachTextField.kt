package com.example.kakaowebtoon.presentation.ui.search.component

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.BasicTextField
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.SolidColor
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.kakaowebtoon.R
import com.example.kakaowebtoon.presentation.util.noRippleClickable
import com.example.kakaowebtoon.presentation.util.showIf
import com.example.kakaowebtoon.ui.theme.defaultKakaoWebtoonColors
import com.example.kakaowebtoon.ui.theme.defaultKakaoWebtoonTypography

@Composable
fun SearchTextField(
    value: String,
    onValueChange: (String) -> Unit,
    placeholder: String,
    modifier: Modifier = Modifier,
    maxLength: Int = 20
) {
    Row(
        modifier = modifier.fillMaxWidth().padding(horizontal = 6.dp),
        verticalAlignment = Alignment.CenterVertically

    ) {
        Row(
            modifier = modifier
                .weight(1f)
                .background(
                    color = defaultKakaoWebtoonColors.black1,
                    shape = RoundedCornerShape(6.dp)
                )
                .padding(vertical = 7.dp, horizontal = 12.dp),
            verticalAlignment = Alignment.CenterVertically
        ) {
            BasicTextField(
                value = value,
                onValueChange = {
                    if (it.length <= maxLength) {
                        onValueChange(it)
                    }
                },
                textStyle = defaultKakaoWebtoonTypography.title2SemiBold.copy(
                    color = defaultKakaoWebtoonColors.white
                ),
                maxLines = 1,
                cursorBrush = SolidColor(if (value.isEmpty()) defaultKakaoWebtoonColors.grey6 else defaultKakaoWebtoonColors.white),
                decorationBox = { innerTextField ->
                    if (value.isEmpty()) {
                        Text(
                            text = placeholder,
                            style = defaultKakaoWebtoonTypography.title4SemiBold,
                            color = defaultKakaoWebtoonColors.grey6
                        )
                    }
                    innerTextField()
                }
            )

            Spacer(modifier = modifier.weight(1f))
            Image(
                painter = painterResource(R.drawable.ic_search_subtraction),
                contentDescription = null,
                modifier = Modifier
                    .noRippleClickable { onValueChange("") }
                    .showIf(value.isNotEmpty())
            )
        }
        Icon(
            painter = painterResource(R.drawable.ic_search_close),
            contentDescription = "Search View Close Icon",
            tint = defaultKakaoWebtoonColors.white,
            modifier = modifier.noRippleClickable { }
        )
    }
}

@Preview
@Composable
fun CustomBasicTextFieldPreview() {
    val text = remember { mutableStateOf("") }

    SearchTextField(
        value = text.value,
        onValueChange = { text.value = it },
        placeholder = "작품, 작가, 장르를 입력하세요"
    )
}
