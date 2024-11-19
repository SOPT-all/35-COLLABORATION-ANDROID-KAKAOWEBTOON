package com.example.kakaowebtoon.presentation.component

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import kotlinx.collections.immutable.persistentListOf

@Composable
fun Indicator(contentsList: List<String>, modifier: Modifier = Modifier) {
    Row(
        modifier = modifier.fillMaxWidth(),
        horizontalArrangement = Arrangement.spacedBy(4.dp)
    ) {
        contentsList.forEach { content ->
            Text(text = content, style = TextStyle())
        }
    }
}

@Preview
@Composable
private fun BaseIndicatorPreview() {
    val contentsList = persistentListOf("월", "화", "수")
    Indicator(contentsList = contentsList)
}
