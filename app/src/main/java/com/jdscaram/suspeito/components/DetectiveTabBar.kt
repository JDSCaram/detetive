package com.jdscaram.suspeito.components

import androidx.compose.foundation.Text
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.preferredHeight
import androidx.compose.foundation.layout.preferredWidth
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Tab
import androidx.compose.material.TabConstants.defaultTabIndicatorOffset
import androidx.compose.material.TabPosition
import androidx.compose.material.TabRow
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import androidx.ui.tooling.preview.Preview
import com.jdscaram.suspeito.components.theme.DetectiveTheme
import com.jdscaram.suspeito.core.ext.compose.TypedComposableFn
import com.jdscaram.suspeito.core.ext.func.Callback1
import com.jdscaram.suspeito.domain.model.Type

@Composable
fun DetectiveTabBar(
    modifier: Modifier = Modifier,
    selectedTab: Type,
    onTabSelected: Callback1<Type>,
) {
    val types = listOf(Type.CHARACTER, Type.PLACE, Type.WEAPON)
    val selectedIndex = types.indexOf(selectedTab)

    val indicator: TypedComposableFn<List<TabPosition>> = { tabPositions ->
        DetectiveTabBarIndicator(
            Modifier.defaultTabIndicatorOffset(tabPositions[selectedIndex])
        )
    }

    TabRow(
        selectedTabIndex = selectedIndex,
        modifier = modifier,
        indicator = indicator,
    ) {
        types.forEachIndexed { index, type ->
            Tab(
                selected = index == selectedIndex,
                onClick = { onTabSelected(type) },
                text = {
                    Text(
                        text = stringResource(id = type.title),
                        maxLines = 1
                    )
                }
            )
        }
    }
}

@Composable
fun DetectiveTabBarIndicator(
    modifier: Modifier = Modifier
) {
    Spacer(
        modifier.preferredWidth(112.dp)
            .preferredHeight(4.dp)
            .background(
                MaterialTheme.colors.secondary,
                RoundedCornerShape(topLeftPercent = 25, topRightPercent = 25)
            )
    )
}

@Composable
@Preview
fun PreviewDetectiveTabBar() {
    DetectiveTheme {
        DetectiveTabBar(
            selectedTab = Type.CHARACTER,
            onTabSelected = {}
        )
    }
}
