package com.example.re_mind.ui.module.dashboard

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.re_mind.R
import com.example.re_mind.ui.theme.MtcAppTheme.Color.Companion.Error500
import com.example.re_mind.ui.theme.MtcAppTheme.Color.Companion.Neutral500
import com.example.re_mind.ui.theme.MtcAppTheme.Color.Companion.Secondary500
import com.example.re_mind.ui.theme.MtcAppTheme.Color.Companion.Shades100
import com.example.re_mind.ui.theme.MtcAppTheme.Color.Companion.Shades50
import com.example.re_mind.ui.theme.MtcAppTheme.Color.Companion.Success500
import com.example.re_mind.ui.theme.MtcAppTheme.Text.Companion.paragraph1SemiBold
import com.example.re_mind.ui.theme.MtcAppTheme.Text.Companion.paragraph2
import com.example.re_mind.ui.theme.MtcAppTheme.Text.Companion.paragraph3

@Composable
fun ActivityCard(
    status: String,
    title: String,
    description: String
) {
    Box {
        Card(
            modifier = Modifier.matchParentSize(),
            colors = CardDefaults.cardColors(
                containerColor =
                    when (status) {
                        "Berlangsung" -> Secondary500
                        "Terlambat" -> Error500
                        else -> Success500
                    }
            )
        ){}
        Card(
            modifier = Modifier.padding(start = 10.dp),
            shape = RoundedCornerShape(topEnd = 10.dp, bottomEnd = 10.dp),
            colors = CardDefaults.cardColors(containerColor = Shades50),
            elevation = CardDefaults.cardElevation(defaultElevation = 3.dp)
        ) {
            Column(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(20.dp)
            ) {
                Text(
                    modifier = Modifier
                        .align(Alignment.End)
                        .background(
                            shape = RoundedCornerShape(20.dp),
                            color =
                                when (status) {
                                    "Berlangsung" -> Secondary500
                                    "Terlambat" -> Error500
                                    else -> Success500
                                }
                        )
                        .padding(horizontal = 15.dp, vertical = 5.dp),
                    text = status,
                    color =
                        if (status == "Terlambat") Shades50
                        else Shades100,
                    style = paragraph3
                )
                Spacer(modifier = Modifier.size(10.dp))
                Text(
                    text = title,
                    style = paragraph1SemiBold
                )
                Spacer(modifier = Modifier.size(20.dp))
                Text(
                    text = description,
                    style = paragraph2
                )
                Spacer(modifier = Modifier.size(20.dp))
                Row(verticalAlignment = Alignment.CenterVertically) {
                    Icon(
                        modifier = Modifier.size(24.dp),
                        painter = painterResource(R.drawable.ic_clock),
                        contentDescription = "Icon Clock",
                        tint = Neutral500
                    )
                    Spacer(modifier = Modifier.size(8.dp))
                    Text(
                        text = "22 Maret 2023",
                        color = Neutral500,
                        style = paragraph2
                    )
                    Spacer(modifier = Modifier.weight(1f))
                    Icon(
                        modifier = Modifier.size(24.dp),
                        painter = painterResource(R.drawable.ic_arrow_down),
                        contentDescription = "Icon Clock",
                        tint = Neutral500
                    )
                }
            }
        }
    }
}

@Preview
@Composable
fun ActivityItemPreview() {
    ActivityCard(
        status = "Terlambat",
        title = "Brainstorming",
        description = "PM diminta untuk membuat wireframe dari aplikasi yang sudah didesain sebelumnya"
    )
}