package com.example.kakaowebtoon.presentation.ui.storage.component

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.width
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.kakaowebtoon.presentation.type.StorageButtonType
import com.example.kakaowebtoon.presentation.util.roundedBackgroundWithPadding

@Composable
fun StorageButton(storageButtonType: StorageButtonType, modifier: Modifier = Modifier) {
    Row(
        horizontalArrangement = Arrangement.Center,
        verticalAlignment = Alignment.CenterVertically,
        modifier = modifier
            .roundedBackgroundWithPadding(
                backgroundColor = storageButtonType.backgroundColor,
                cornerRadius = 5.dp,
                padding = PaddingValues(vertical = 9.dp)
            )
    ) {
        Icon(
            painter = painterResource(storageButtonType.iconResId),
            contentDescription = null,
            tint = storageButtonType.contentColor
        )
        Spacer(modifier = Modifier.width(5.dp))
        Text(stringResource(storageButtonType.textRes), color = storageButtonType.contentColor)
    }
}

@Preview
@Composable
private fun StorageButtonPreview() {
    StorageButton(StorageButtonType.SORT)
    StorageButton(StorageButtonType.EDIT)
}
