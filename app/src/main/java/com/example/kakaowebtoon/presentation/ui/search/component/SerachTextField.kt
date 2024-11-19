package com.example.kakaowebtoon.presentation.ui.search.component

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.BasicTextField
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.SolidColor
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.kakaowebtoon.ui.theme.defaultKakaoWebtoonColors
import com.example.kakaowebtoon.ui.theme.defaultKakaoWebtoonTypography

@Composable
fun SearchTextField(
    value: String,
    onValueChange: (String) -> Unit,
    placeholder: String,
    modifier: Modifier = Modifier
) {
    Box(
        modifier = modifier
            .fillMaxWidth()
            .background(
                color = defaultKakaoWebtoonColors.black1,
                shape = RoundedCornerShape(6.dp)
            )
            .padding(vertical = 7.dp, horizontal = 12.dp)
    ) {
        BasicTextField(
            value = value,
            onValueChange = onValueChange,
            textStyle = defaultKakaoWebtoonTypography.title2SemiBold.copy(
                color = defaultKakaoWebtoonColors.white
            ),
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
            },
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
        placeholder = "작품, 작가, 장르를 입력하세요",
        modifier = Modifier.fillMaxWidth()
    )
}