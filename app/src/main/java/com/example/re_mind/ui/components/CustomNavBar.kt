package com.example.re_mind.ui.components

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.navigationBarsPadding
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Icon
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.re_mind.R
import com.example.re_mind.ui.theme.MtcAppTheme.Color.Companion.Primary300
import com.example.re_mind.ui.theme.MtcAppTheme.Color.Companion.Primary500
import com.example.re_mind.ui.theme.MtcAppTheme.Color.Companion.Shades50

val navList = listOf(
    R.drawable.ic_home,
    R.drawable.ic_task,
    R.drawable.ic_perform,
    R.drawable.ic_user
)

@Composable
fun CustomNavBar(
    modifier: Modifier,
    defaultSelectedIndex: Int = 0,
    list: List<Int>,
    onItemClick: (Int) -> Unit
) {
    var selectedIndex by remember { mutableIntStateOf(defaultSelectedIndex) }

    Surface(
        modifier = modifier
            .fillMaxWidth()
            .navigationBarsPadding()
            .padding(20.dp),
        shape = RoundedCornerShape(10.dp),
        color = Primary500,
    ) {
        Box(
            modifier = Modifier
                .fillMaxWidth()
                .height(56.dp)
                .background(
                    color = Primary500,
                    shape = RoundedCornerShape(10.dp)
                ),
            contentAlignment = Alignment.Center
        ) {
            Row(
                verticalAlignment = Alignment.CenterVertically,
                modifier = Modifier.fillMaxSize()
            ) {
                list.forEachIndexed { index, icon ->
                    Box(
                        modifier = Modifier
                            .fillMaxHeight()
                            .weight(1f)
                            .clickable(
                                enabled = selectedIndex != index,
                                onClick = {
                                    selectedIndex = index
                                    onItemClick(index)
                                }
                            ),
                        contentAlignment = Alignment.Center
                    ) {
                        Column(horizontalAlignment = Alignment.CenterHorizontally) {
                            Icon(
                                modifier = Modifier.size(18.dp),
                                painter = painterResource(icon),
                                contentDescription = "Icon Nav Screen",
                                tint =
                                    if (selectedIndex == index) Primary300
                                    else Shades50
                            )
                            Spacer(modifier = Modifier.size(2.dp))
                            if (selectedIndex == index) {
                                Icon(
                                    modifier = Modifier.size(5.dp),
                                    painter = painterResource(R.drawable.ic_dot),
                                    contentDescription = "Icon Dot",
                                    tint = Primary300
                                )
                            }
                        }
                    }
                }
            }
        }
    }
}

@Preview
@Composable
fun CustomNavBarPreview() {
    CustomNavBar(
        modifier = Modifier,
        list = navList,
        onItemClick = {}
    )
}