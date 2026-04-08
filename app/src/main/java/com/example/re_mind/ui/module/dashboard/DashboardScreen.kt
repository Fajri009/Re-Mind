package com.example.re_mind.ui.module.dashboard

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.re_mind.R
import com.example.re_mind.ui.theme.MtcAppTheme.Color.Companion.Shades50
import com.example.re_mind.ui.theme.MtcAppTheme.Color.Companion.Primary300
import com.example.re_mind.ui.theme.MtcAppTheme.Color.Companion.Primary50
import com.example.re_mind.ui.theme.MtcAppTheme.Color.Companion.Primary500
import com.example.re_mind.ui.theme.MtcAppTheme.Color.Companion.Shades100
import com.example.re_mind.ui.theme.MtcAppTheme.Text.Companion.heading1Bold
import com.example.re_mind.ui.theme.MtcAppTheme.Text.Companion.heading3SemiBold
import com.example.re_mind.ui.theme.MtcAppTheme.Text.Companion.heading5SemiBold
import com.example.re_mind.ui.theme.MtcAppTheme.Text.Companion.heading6Bold
import com.example.re_mind.ui.theme.MtcAppTheme.Text.Companion.paragraph1
import com.example.re_mind.ui.theme.MtcAppTheme.Text.Companion.paragraph1SemiBold
import com.example.re_mind.ui.theme.MtcAppTheme.Text.Companion.paragraph2
import com.example.re_mind.ui.theme.MtcAppTheme.Text.Companion.paragraph3

@Composable
fun DashboardScreen(navigateNotification: () -> Unit) {
    Scaffold(containerColor = Color.White) { paddingValues ->
        Column(
            modifier = Modifier
                .padding(paddingValues)
                .fillMaxSize()
                .verticalScroll(rememberScrollState())
                .padding(horizontal = 25.dp, vertical = 20.dp)
        ) {
            Row(
                modifier = Modifier.fillMaxWidth(),
                verticalAlignment = Alignment.CenterVertically
            ) {
                Image(
                    modifier = Modifier.size(24.dp),
                    painter = painterResource(id = R.drawable.ic_app_dark),
                    contentDescription = "Icon App Dark"
                )
                Spacer(modifier = Modifier.width(15.dp))
                Text(
                    text = "Re-Mind",
                    style = heading6Bold,
                    color = Primary300
                )
                Spacer(modifier = Modifier.weight(1f))
                IconButton(
                    modifier = Modifier.size(24.dp),
                    onClick = navigateNotification
                ) {
                    Icon(
                        painter = painterResource(id = R.drawable.ic_notification),
                        contentDescription = "Icon Notification"
                    )
                }
            }
            Spacer(modifier = Modifier.size(25.dp))
            Row(verticalAlignment = Alignment.CenterVertically) {
                Image(
                    modifier = Modifier
                        .size(60.dp)
                        .clip(CircleShape),
                    painter = painterResource(id = R.drawable.ic_launcher_background),
                    contentDescription = "Profile Picture",
                    contentScale = ContentScale.Crop
                )
                Spacer(modifier = Modifier.size(15.dp))
                Column(
                    modifier = Modifier.fillMaxHeight(),
                    verticalArrangement = Arrangement.Center
                ) {
                    Text(
                        text = "Hi, Jessica",
                        style = paragraph1SemiBold
                    )
                    Text(
                        text = "Selamat pagi !",
                        style = paragraph2
                    )
                }
            }
            Spacer(modifier = Modifier.size(30.dp))
            Text(
                text = "Tugas",
                style = heading5SemiBold
            )
            Spacer(modifier = Modifier.size(16.dp))
            Card(
                modifier = Modifier.fillMaxWidth(),
                shape = RoundedCornerShape(11.dp),
                colors = CardDefaults.cardColors(containerColor = Primary500),
            ) {
                Row(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(horizontal = 17.dp),
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    Column {
                        Text(
                            text = "Selesaikan",
                            style = paragraph1,
                            color = Shades50
                        )
                        Text(
                            text = "10",
                            style = heading1Bold,
                            color = Shades50
                        )
                        Text(
                            text = "Tugas Hari Ini",
                            style = paragraph1,
                            color = Shades50
                        )
                    }
                    Spacer(modifier = Modifier.weight(1f))
                    Image(
                        modifier = Modifier.size(150.dp),
                        painter = painterResource(id = R.drawable.ill_dashboard),
                        contentDescription = "Illustration Dashboard"
                    )
                }
            }
            Spacer(modifier = Modifier.size(17.dp))
            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.SpaceBetween
            ) {
                CardProgress(
                    modifier = Modifier.weight(1f),
                    text = "Berlangsung",
                    value = 10,
                    ongoing = true
                )
                Spacer(modifier = Modifier.size(14.dp))
                CardProgress(
                    modifier = Modifier.weight(1f),
                    text = "Selesai",
                    value = 10,
                    ongoing = false
                )
            }
            Spacer(modifier = Modifier.size(30.dp))
            Text(
                text = "Aktivitas",
                style = heading5SemiBold
            )
            Spacer(modifier = Modifier.size(20.dp))
            ActivityCard(
                status = "Terlambat",
                title = "Brainstorming",
                description = "PM diminta untuk membuat wireframe dari aplikasi yang sudah didesain sebelumnya"
            )
        }
    }
}

@Composable
fun CardProgress(
    modifier: Modifier,
    text: String,
    value: Int,
    ongoing: Boolean
) {
    Card(
        modifier = modifier,
        colors =
            if (ongoing) {
                CardDefaults.cardColors(
                    containerColor = Primary300,
                    contentColor = Shades50
                )
            } else {
                CardDefaults.cardColors(
                    containerColor = Primary50,
                    contentColor = Shades100
                )
            }
    ) {
        Column(
            modifier = Modifier.fillMaxWidth().padding(vertical = 20.dp),
            horizontalAlignment =  Alignment.CenterHorizontally
        ) {
            Text(
                text = value.toString(),
                style = heading3SemiBold
            )
            Text(
                text = text,
                style = paragraph3
            )
        }
    }
}

@Preview
@Composable
fun DashboardScreenPreview() {
    DashboardScreen(navigateNotification = {})
}