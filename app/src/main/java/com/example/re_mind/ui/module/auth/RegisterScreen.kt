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
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.style.TextDecoration
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.window.Dialog
import com.example.re_mind.R
import com.example.re_mind.ui.components.CustomButton
import com.example.re_mind.ui.components.CustomDialog
import com.example.re_mind.ui.components.CustomTextField
import com.example.re_mind.ui.theme.MtcAppTheme.Color.Companion.Primary500
import com.example.re_mind.ui.theme.MtcAppTheme.Color.Companion.Secondary900
import com.example.re_mind.ui.theme.MtcAppTheme.Color.Companion.Shades100
import com.example.re_mind.ui.theme.MtcAppTheme.Color.Companion.Shades50
import com.example.re_mind.ui.theme.MtcAppTheme.Text.Companion.paragraph1
import com.example.re_mind.ui.theme.MtcAppTheme.Text.Companion.paragraph1SemiBold

@Composable
fun RegisterScreen(
    navigateBack: () -> Unit,
    navigateLogin: () -> Unit
) {
    var email by remember { mutableStateOf("") }
    var username by remember { mutableStateOf("") }
    var password by remember { mutableStateOf("") }
    var confirmationPassword by remember { mutableStateOf("") }

    var showErrorDialog by remember { mutableStateOf(false) }

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
        ) { paddingValues ->
            Column(
                modifier = Modifier
                    .padding(paddingValues)
                    .fillMaxWidth()
                    .verticalScroll(rememberScrollState()),
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                Spacer(modifier = Modifier.height(15.dp))
                ActionBar(onClick = navigateBack)
                Spacer(modifier = Modifier.height(15.dp))
                Image(
                    modifier = Modifier.size(140.dp),
                    painter = painterResource(R.drawable.ill_auth),
                    contentDescription = "Illustration Authentication"
                )
                Spacer(modifier = Modifier.height(17.dp))
                Box(
                    modifier = Modifier
                        .fillMaxSize()
                        .background(
                            color = Shades50,
                            shape = RoundedCornerShape(topStart = 50.dp, topEnd = 50.dp)
                        )
                        .padding(32.dp)
                ) {
                    Column(modifier = Modifier.fillMaxWidth()) {
                        CustomTextField(
                            placeholder = "Email",
                            value = email,
                            onValueChange = { email = it }
                        )
                        Spacer(modifier = Modifier.height(15.dp))
                        CustomTextField(
                            placeholder = "Username",
                            value = username,
                            onValueChange = { username = it }
                        )
                        Spacer(modifier = Modifier.height(15.dp))
                        CustomTextField(
                            placeholder = "Password",
                            value = password,
                            onValueChange = { password = it }
                        )
                        Spacer(modifier = Modifier.height(15.dp))
                        CustomTextField(
                            placeholder = "Konfirmasi Password",
                            value = confirmationPassword,
                            onValueChange = { confirmationPassword = it }
                        )
                        Spacer(modifier = Modifier.height(24.dp))
                        CustomButton(
                            enabled = !(email.isEmpty() || username.isEmpty() || password.isEmpty() || confirmationPassword.isEmpty()),
                            text = "Daftar",
                            onClick = {}
                        )
                        Spacer(modifier = Modifier.height(15.dp))
                        Row(
                            modifier = Modifier.fillMaxWidth(),
                            horizontalArrangement = Arrangement.Center
                        ) {
                            Text(
                                text = "Sudah punya akun?",
                                style = paragraph1,
                                color = Shades100
                            )
                            Spacer(modifier = Modifier.width(5.dp))
                            Text(
                                modifier = Modifier.clickable(
                                    enabled = true,
                                    onClick = navigateLogin
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

            if (showErrorDialog) {
                Dialog(
                    onDismissRequest = { showErrorDialog = false }
                ) {
                    CustomDialog(
                        onDismiss = { showErrorDialog = false },
                        isSuccess = false,
                        text = "Email atau password tidak sesuai"
                    )
                }
            }
        }
    }
}

@Preview
@Composable
fun RegisterScreenPreview() {
    RegisterScreen({}, {})
}