package com.example.re_mind.ui.module.auth

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.style.TextDecoration
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.re_mind.R
import com.example.re_mind.ui.components.CustomButton
import com.example.re_mind.ui.theme.MtcAppTheme.Color.Companion.Primary500
import com.example.re_mind.ui.theme.MtcAppTheme.Color.Companion.Secondary900
import com.example.re_mind.ui.theme.MtcAppTheme.Color.Companion.Shades100
import com.example.re_mind.ui.theme.MtcAppTheme.Color.Companion.Shades50
import com.example.re_mind.ui.theme.MtcAppTheme.Text.Companion.heading2Bold
import com.example.re_mind.ui.theme.MtcAppTheme.Text.Companion.paragraph1
import com.example.re_mind.ui.theme.MtcAppTheme.Text.Companion.paragraph1SemiBold

@Composable
fun StartScreen(
    navigateLogin: () -> Unit,
    navigateRegister: () -> Unit
) {
    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(
                brush = Brush.verticalGradient(
                    colorStops = arrayOf(
                        0.0f to Primary500,
                        0.7f to Shades50,
                        1.0f to Shades50
                    )
                )
            )
    ) {
        Scaffold(
            containerColor = Color.Transparent
        ) { paddingValues ->
            Column(
                modifier = Modifier
                    .padding(paddingValues)
                    .fillMaxSize()
                    .padding(horizontal = 30.dp),
                verticalArrangement = Arrangement.Center,
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                Row(
                    modifier = Modifier.fillMaxWidth(),
                    verticalAlignment = Alignment.CenterVertically,
                    horizontalArrangement = Arrangement.Center
                ) {
                    Image(
                        modifier = Modifier.size(72.dp),
                        painter = painterResource(id = R.drawable.ic_app),
                        contentDescription = "Icon App"
                    )
                    Spacer(modifier = Modifier.width(15.dp))
                    Text(
                        text = "Re-Mind",
                        style = heading2Bold,
                        color = Shades50
                    )
                }
                Spacer(modifier = Modifier.height(15.dp))
                Image(
                    modifier = Modifier.size(295.dp),
                    painter = painterResource(id = R.drawable.ill_auth),
                    contentDescription = "Illustration Authentication"
                )
                Spacer(modifier = Modifier.height(125.dp))
                CustomButton(text = "Daftar") { navigateLogin() }
                Spacer(modifier = Modifier.height(15.dp))
                Row {
                    Text(
                        text = "Sudah punya akun?",
                        color = Shades100,
                        style = paragraph1
                    )
                    Spacer(modifier = Modifier.width(5.dp))
                    Text(
                        modifier = Modifier.clickable(
                            enabled = true,
                            onClick = navigateRegister
                        ),
                        text = "Masuk",
                        color = Secondary900,
                        textDecoration = TextDecoration.Underline,
                        style = paragraph1SemiBold
                    )
                }
            }
        }
    }
}

@Preview
@Composable
fun StartScreenPreview() {
    StartScreen({}, {})
}