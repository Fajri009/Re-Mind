package com.example.re_mind.ui.module.task

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.navigationBarsPadding
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.Scaffold
import androidx.compose.material3.SmallFloatingActionButton
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.onGloballyPositioned
import androidx.compose.ui.platform.LocalDensity
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.compose.rememberNavController
import com.example.re_mind.R
import com.example.re_mind.ReMindNavigationActions
import com.example.re_mind.ui.components.CustomNavBar
import com.example.re_mind.ui.components.CustomSearchTextField
import com.example.re_mind.ui.components.navList
import com.example.re_mind.ui.module.dashboard.ActivityCard
import com.example.re_mind.ui.theme.MtcAppTheme.Color.Companion.Primary50
import com.example.re_mind.ui.theme.MtcAppTheme.Color.Companion.Primary500
import com.example.re_mind.ui.theme.MtcAppTheme.Color.Companion.Shades100
import com.example.re_mind.ui.theme.MtcAppTheme.Color.Companion.Shades50
import com.example.re_mind.ui.theme.MtcAppTheme.Text.Companion.heading5Bold
import com.example.re_mind.ui.theme.MtcAppTheme.Text.Companion.paragraph3

@Composable
fun TaskScreen(
    navActions: ReMindNavigationActions,
    navRoutes: List<String>
) {
    var searchTask by remember { mutableStateOf("") }
    var selectedTab by remember { mutableIntStateOf(0) }

    var navBarHeight by remember{ mutableStateOf(0.dp) }
    val density = LocalDensity.current

    val tabs = listOf("Semua", "Berlangsung", "Terlambat", "Selesai")

    Box(modifier = Modifier.fillMaxSize()) {
        Scaffold(containerColor = Color.White) { paddingValues ->
            Column(
                modifier = Modifier
                    .padding(paddingValues)
                    .fillMaxSize()
                    .verticalScroll(rememberScrollState())
                    .navigationBarsPadding()
                    .padding(start = 25.dp, end = 25.dp, top = 20.dp, bottom = 45.dp)
            ) {
                Card(modifier = Modifier.fillMaxWidth()) {
                    Box(
                        modifier = Modifier
                            .fillMaxWidth()
                            .background(
                                brush = Brush.horizontalGradient(
                                    colorStops = arrayOf(
                                        0.0f to Primary500,
                                        0.99f to Primary50,
                                        1.0f to Primary50
                                    )
                                )
                            )
                    ) {
                        Row(
                            modifier = Modifier
                                .fillMaxWidth()
                                .padding(horizontal = 20.dp, vertical = 10.dp),
                            horizontalArrangement = Arrangement.SpaceBetween,
                            verticalAlignment = Alignment.CenterVertically
                        ) {
                            Text(
                                text = "SELESAIKAN\nTUGASMU!",
                                style = heading5Bold,
                                color = Shades50
                            )
                            Image(
                                painter = painterResource(R.drawable.ill_task),
                                contentDescription = "Illustration Task"
                            )
                        }
                    }
                }
                Spacer(modifier = Modifier.size(20.dp))
                Row {
                    CustomSearchTextField(
                        modifier = Modifier.weight(0.8f),
                        value = searchTask,
                        onValueChange = { searchTask = it }
                    )
                    Spacer(modifier = Modifier.size(23.dp))
                    Card(
                        shape = RoundedCornerShape(7.dp),
                        colors = CardDefaults.cardColors(containerColor = Primary500)
                    ) {
                        Column(
                            modifier = Modifier
                                .padding(7.dp)
                                .fillMaxHeight()
                        ) {
                            Icon(
                                modifier = Modifier
                                    .size(24.dp),
                                painter = painterResource(R.drawable.ic_filter),
                                contentDescription = "Icon Filter",
                                tint = Shades50
                            )
                        }
                    }
                }
                Spacer(modifier = Modifier.size(30.dp))
                Row(
                    modifier = Modifier
                        .fillMaxWidth()
                        .background(Shades50),
                    horizontalArrangement = Arrangement.SpaceBetween,
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    tabs.forEachIndexed { index, title ->
                        val isSelected = selectedTab == index

                        Text(
                            modifier = Modifier
                                .background(
                                    shape = RoundedCornerShape(20.dp),
                                    color = 
                                        if (isSelected) Primary500
                                        else Color.Transparent
                                )
                                .padding(
                                    vertical =
                                        if (isSelected) 10.dp
                                        else 0.dp,
                                    horizontal =
                                        if (isSelected) 20.dp
                                        else 0.dp
                                )
                                .clickable {
                                    selectedTab = index
                                },
                            text = title,
                            style = paragraph3,
                            color =
                                if (isSelected) Shades50
                                else Shades100
                        )
                    }
                }
//                TabRow(
//                    selectedTabIndex = selectedTab,
//                    containerColor = Shades50,
//                    indicator = {}
//                ) {
//                    tabs.forEachIndexed { index, title ->
//                        val isSelected = selectedTab == index
//
//                        Tab(
//                            selected = isSelected,
//                            onClick = { selectedTab = index },
//                            modifier = Modifier.height(32.dp),
//                            text = {
//                                Text(
//                                    modifier = Modifier
//                                        .background(
//                                            shape = RoundedCornerShape(20.dp),
//                                            color =
//                                                if (isSelected) Primary500
//                                                else Color.Transparent
//                                        )
//                                        .padding(horizontal = 20.dp, vertical = 10.dp),
//                                    text = title,
//                                    style = paragraph3,
//                                    color =
//                                        if (isSelected) Shades50
//                                        else Shades100
//                                )
//                            }
//                        )
//                    }
//                }
                Spacer(modifier = Modifier.size(30.dp))
                ActivityCard(
                    status = "Terlambat",
                    title = "Brainstorming",
                    description = "PM diminta untuk membuat wireframe dari aplikasi yang sudah didesain sebelumnya"
                )
            }
        }
        SmallFloatingActionButton(
            modifier = Modifier
                .align(Alignment.BottomCenter)
                .offset(x = 150.dp)
                .padding(bottom = navBarHeight + 10.dp),
            onClick = {},
            shape = CircleShape,
            containerColor = Primary500,
            contentColor = Shades50
        ) {
            Icon(
                imageVector = Icons.Default.Add,
                contentDescription = "Floating Action Button"
            )
        }
        CustomNavBar(
            modifier = Modifier
                .align(Alignment.BottomCenter)
                .onGloballyPositioned { coordinates ->
                    navBarHeight = with(density) { coordinates.size.height.toDp() }
                },
            list = navList,
            defaultSelectedIndex = 1,
            onItemClick = { index ->
                navActions.navigateTo(navRoutes[index])
            }
        )
    }
}

@Preview
@Composable
fun TaskScreenPreview() {
    val fakeNavActions = ReMindNavigationActions(
        navController = rememberNavController()
    )

    TaskScreen(
        navRoutes = listOf(""),
        navActions = fakeNavActions
    )
}