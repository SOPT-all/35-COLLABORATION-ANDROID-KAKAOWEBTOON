package com.example.kakaowebtoon.presentation.util

import androidx.compose.foundation.clickable
import androidx.compose.foundation.interaction.MutableInteractionSource
import androidx.compose.foundation.layout.size
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.composed
import androidx.compose.ui.unit.dp

inline fun Modifier.noRippleClickable(
    crossinline onClick: () -> Unit = {}
): Modifier = composed {
    this.clickable(
        indication = null,
        interactionSource = remember { MutableInteractionSource() }
    ) {
        onClick()
    }
}


inline fun Modifier.showIf(condition: Boolean): Modifier {
    return if (condition) this else Modifier.size(0.dp)
}
