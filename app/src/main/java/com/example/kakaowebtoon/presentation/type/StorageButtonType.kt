package com.example.kakaowebtoon.presentation.type

import androidx.annotation.DrawableRes
import androidx.annotation.StringRes
import androidx.compose.ui.graphics.Color
import com.example.kakaowebtoon.R
import com.example.kakaowebtoon.ui.theme.defaultKakaoWebtoonColors

enum class StorageButtonType(
    @DrawableRes val iconResId: Int,
    @StringRes val textRes: Int,
    val backgroundColor: Color = defaultKakaoWebtoonColors.black2,
    val contentColor: Color = defaultKakaoWebtoonColors.grey5
) {
    SORT(
        iconResId = R.drawable.ic_storage_expandarrow,
        textRes = R.string.storage_button_sort
    ),
    EDIT(
        iconResId = R.drawable.ic_storage_trash,
        textRes = R.string.storage_button_edit
    )
}
