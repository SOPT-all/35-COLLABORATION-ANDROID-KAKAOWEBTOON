package com.example.kakaowebtoon.presentation.ui.main.component

import androidx.compose.animation.AnimatedVisibility
import androidx.compose.foundation.interaction.MutableInteractionSource
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.RowScope
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.selection.selectable
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.res.vectorResource
import androidx.compose.ui.semantics.Role
import androidx.compose.ui.text.PlatformTextStyle
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.kakaowebtoon.presentation.type.MainBottomNavType
import com.example.kakaowebtoon.ui.theme.KakaoWebtoonTheme
import kotlinx.collections.immutable.PersistentList
import kotlinx.collections.immutable.toPersistentList

@Composable
fun MainBottomNavBar(
    visible: Boolean,
    tabs: PersistentList<MainBottomNavType>,
    currentTab: MainBottomNavType?,
    onTabSelected: (MainBottomNavType) -> Unit,
    modifier: Modifier = Modifier
) {
    AnimatedVisibility(visible) {
        Row(
            modifier = modifier
                .fillMaxWidth()
                .padding(horizontal = 22.dp)
                .height(43.dp),
            horizontalArrangement = Arrangement.spacedBy(28.dp)
        ) {
            tabs.forEach { tab ->
                MainBottomNavBarItem(
                    tab = tab,
                    selected = tab == currentTab,
                    onTabClick = { onTabSelected(tab) }
                )
            }
        }
    }
}

@Composable
private fun RowScope.MainBottomNavBarItem(
    tab: MainBottomNavType,
    selected: Boolean,
    onTabClick: () -> Unit,
    modifier: Modifier = Modifier
) {
    val itemColor = if (selected) KakaoWebtoonTheme.colors.yellow2 else KakaoWebtoonTheme.colors.darkGrey1

    Column(
        modifier = modifier
            .fillMaxHeight()
            .align(Alignment.CenterVertically)
            .weight(1f)
            .selectable(
                selected = selected,
                role = Role.Tab,
                onClick = onTabClick,
                indication = null,
                interactionSource = remember { MutableInteractionSource() }
            ),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {
        Icon(
            imageVector = ImageVector.vectorResource(tab.iconResId),
            contentDescription = stringResource(tab.labelResId),
            tint = itemColor
        )
        Spacer(modifier = Modifier.height(1.dp))
        Text(
            text = stringResource(tab.labelResId),
            color = itemColor,
            style = KakaoWebtoonTheme.typography.body5Regular.copy(
                platformStyle = PlatformTextStyle(
                    includeFontPadding = false
                )
            )
        )
    }
}

@Preview
@Composable
private fun BottomNavBarPreview() {
    KakaoWebtoonTheme {
        MainBottomNavBar(
            visible = true,
            tabs = MainBottomNavType.entries.toPersistentList(),
            currentTab = MainBottomNavType.HOME,
            onTabSelected = {}
        )
    }
}
