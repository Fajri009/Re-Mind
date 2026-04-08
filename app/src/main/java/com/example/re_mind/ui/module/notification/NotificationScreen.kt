package com.example.re_mind.ui.module.notification

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.CenterAlignedTopAppBar
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.re_mind.R
import com.example.re_mind.ui.theme.MtcAppTheme.Color.Companion.Shades100
import com.example.re_mind.ui.theme.MtcAppTheme.Color.Companion.Shades50
import com.example.re_mind.ui.theme.MtcAppTheme.Text.Companion.heading6SemiBold

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun NotificationScreen(navigateBack: () -> Unit) {
    Scaffold(
        containerColor = Shades50,
        topBar = {
            CenterAlignedTopAppBar(
                modifier = Modifier.shadow(elevation = 4.dp),
                colors = TopAppBarDefaults.centerAlignedTopAppBarColors(containerColor = Shades50),
                title = {
                    Text(
                        text = "Notifikasi",
                        style = heading6SemiBold
                    )
                },
                navigationIcon ={
                    IconButton(
                        onClick = navigateBack
                    ) {
                        Icon(
                            modifier = Modifier.size(24.dp),
                            painter = painterResource(R.drawable.ic_default_arrow_left),
                            contentDescription = "Icon Back",
                            tint = Shades100
                        )
                    }
                }
            )
        }
    ) { innerPadding ->
        Column(modifier = Modifier.padding(innerPadding)) {
            Spacer(modifier = Modifier.size(30.dp))
            NotificationCard(
                text = "Tugas “Membuat Wireframe” harus dikumpulkan pada malam ini tanggal 22 Maret 2023"
            )
        }
    }
}

@Preview
@Composable
fun NotificationScreenPreview() {
    NotificationScreen(navigateBack = {})
}