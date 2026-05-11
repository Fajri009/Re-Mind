package com.example.re_mind.ui.module.menu.user

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.compose.rememberNavController
import com.example.re_mind.R
import com.example.re_mind.ReMindNavigationActions
import com.example.re_mind.ui.components.CustomNavBar
import com.example.re_mind.ui.components.navList
import com.example.re_mind.ui.module.auth.ActionBar
import com.example.re_mind.ui.theme.MtcAppTheme.Color.Companion.Neutral100
import com.example.re_mind.ui.theme.MtcAppTheme.Color.Companion.Neutral500
import com.example.re_mind.ui.theme.MtcAppTheme.Color.Companion.Primary300
import com.example.re_mind.ui.theme.MtcAppTheme.Color.Companion.Primary500
import com.example.re_mind.ui.theme.MtcAppTheme.Color.Companion.Shades50
import com.example.re_mind.ui.theme.MtcAppTheme.Text.Companion.paragraph1Bold
import com.example.re_mind.ui.theme.MtcAppTheme.Text.Companion.paragraph2
import com.example.re_mind.ui.theme.MtcAppTheme.Text.Companion.paragraph3

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun ProfileScreen(
    navActions: ReMindNavigationActions,
    navRoutes: List<String>,
    navigateStart: () -> Unit,
    navigateChangeProfile: () -> Unit,
    navigateChangePassword: () -> Unit
) {
    Box(
        modifier = Modifier
            .background(
                brush = Brush.verticalGradient(
                    colorStops = arrayOf(
                        0.0f to Primary500,
                        0.4f to Shades50,
                        1.0f to Shades50
                    )
                )
            )
    ) {
        Scaffold(
            containerColor = Color.Transparent
        ) { innerPadding ->
            Column(
                modifier = Modifier
                    .padding(innerPadding)
                    .fillMaxWidth(),
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                Spacer(modifier = Modifier.height(15.dp))
                ActionBar(title = "Profil")
                Spacer(modifier = Modifier.size(85.dp))
                Box(
                    modifier = Modifier
                        .fillMaxSize()
                        .background(
                            color = Shades50,
                            shape = RoundedCornerShape(topStart = 50.dp, topEnd = 50.dp)
                        )
                        .padding(horizontal = 32.dp)
                ) {
                    Column(
                        modifier = Modifier
                            .fillMaxWidth()
                            .offset(y = (-50).dp),
                        horizontalAlignment = Alignment.CenterHorizontally
                    ) {
                        Image(
                            modifier = Modifier
                                .size(100.dp)
                                .border(
                                    width = 1.dp,
                                    color = Primary300,
                                    shape = CircleShape
                                )
                                .clip(CircleShape),
                            painter = painterResource(id = R.drawable.ic_launcher_background),
                            contentDescription = "Foto Profil"
                        )
                        Spacer(modifier = Modifier.size(15.dp))
                        Text(
                            text = "Jessica Dunn",
                            style = paragraph1Bold
                        )
                        Spacer(modifier = Modifier.size(5.dp))
                        Text(
                            text = "Jessica Dunn",
                            style = paragraph3,
                            color = Neutral500
                        )
                        Spacer(modifier = Modifier.size(60.dp))
                        ProfileCard(
                            onClick = navigateChangeProfile,
                            icon = R.drawable.ic_change_profile,
                            title = "Ubah Profil"
                        )
                        ProfileCard(
                            onClick = navigateChangePassword,
                            icon = R.drawable.ic_change_password,
                            title = "Ubah Password"
                        )
                        ProfileCard(
                            onClick = navigateStart,
                            icon = R.drawable.ic_logout,
                            title = "Keluar"
                        )
                        HorizontalDivider(
                            modifier = Modifier.fillMaxWidth(),
                            thickness = 1.dp,
                            color = Neutral100
                        )
                    }
                }
            }
        }
        CustomNavBar(
            modifier = Modifier
                .align(Alignment.BottomCenter),
            list = navList,
            defaultSelectedIndex = 3,
            onItemClick = { index ->
                navActions.navigateTo(navRoutes[index])
            }
        )
    }
}

@Composable
fun ProfileCard(
    onClick: () -> Unit,
    icon: Int,
    title: String
) {
    Column(
        modifier = Modifier
            .clickable { onClick() }
            .padding(bottom = 20.dp)
    ) {
        HorizontalDivider(
            modifier = Modifier.fillMaxWidth(),
            thickness = 1.dp,
            color = Neutral100
        )
        Spacer(modifier = Modifier.height(20.dp))
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(horizontal = 10.dp),
            verticalAlignment = Alignment.CenterVertically
        ) {
            IconButton(
                onClick = {},
                modifier = Modifier
                    .background(color = Primary500, CircleShape)
                    .size(28.dp)
            ) {
                Icon(
                    modifier = Modifier.size(14.dp),
                    painter = painterResource(id = icon),
                    contentDescription = "Icon Profil Card",
                    tint = Shades50
                )
            }
            Spacer(modifier = Modifier.width(15.dp))
            Text(
                text = title,
                style = paragraph2
            )
            Spacer(modifier = Modifier.weight(1f))
            Icon(
                painter = painterResource(id = R.drawable.ic_next_arrow),
                contentDescription = "Icon Next Arrow"
            )
        }
    }
}

@Preview
@Composable
fun ProfileCardPreview() {
    Surface(color = Color.White) {
        ProfileCard(
            icon = R.drawable.ic_change_profile,
            title = "Ubah Profil",
            onClick = {}
        )
    }
}

@Preview
@Composable
fun ProfileScreenPreview() {
    val fakeNavActions = ReMindNavigationActions(
        navController = rememberNavController()
    )

    ProfileScreen(
        navRoutes = listOf(""),
        navActions = fakeNavActions,
        navigateStart = {},
        navigateChangeProfile = {},
        navigateChangePassword = {}
    )
}