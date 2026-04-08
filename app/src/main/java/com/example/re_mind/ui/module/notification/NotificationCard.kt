package com.example.re_mind.ui.module.notification

import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.re_mind.R
import com.example.re_mind.ui.theme.MtcAppTheme.Color.Companion.Shades100
import com.example.re_mind.ui.theme.MtcAppTheme.Color.Companion.Shades50
import com.example.re_mind.ui.theme.MtcAppTheme.Text.Companion.paragraph2

@Composable
fun NotificationCard(text: String) {
    Card(
        modifier = Modifier.padding(horizontal = 18.dp),
        colors = CardDefaults.cardColors(containerColor = Shades50),
        elevation = CardDefaults.cardElevation(defaultElevation = 5.dp)
    ) {
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(15.dp)
        ) {
            Icon(
                modifier = Modifier.size(34.dp),
                painter = painterResource(R.drawable.ic_item_notification),
                contentDescription = "Icon Notification Card",
                tint = Color.Unspecified
            )
            Spacer(modifier = Modifier.size(15.dp))
            Text(
                text = text,
                style = paragraph2,
                color = Shades100
            )
        }
    }
}

@Preview
@Composable
fun NotificationCardPreview() {
    NotificationCard(
        text = "Tugas “Membuat Wireframe” harus dikumpulkan pada malam ini tanggal 22 Maret 2023"
    )
}