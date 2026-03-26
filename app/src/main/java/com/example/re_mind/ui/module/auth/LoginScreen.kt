package com.example.re_mind.ui.module.auth

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Scaffold
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
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.window.Dialog
import com.example.re_mind.R
import com.example.re_mind.ui.components.CustomButton
import com.example.re_mind.ui.components.CustomDialog
import com.example.re_mind.ui.components.CustomTextField
import com.example.re_mind.ui.module.component.ActionBar
import com.example.re_mind.ui.theme.MtcAppTheme.Color.Companion.Primary500
import com.example.re_mind.ui.theme.MtcAppTheme.Color.Companion.Shades50

@Composable
fun LoginScreen(navigateBack: () -> Unit) {
    var email by remember { mutableStateOf("") }
    var password by remember { mutableStateOf("") }

    var showErrorDialog by remember { mutableStateOf(false) }

    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(
                brush = Brush.verticalGradient(
                    colorStops = arrayOf(
                        0.0f to Primary500,
                        0.6f to Shades50,
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
                    .fillMaxSize(),
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                Spacer(modifier = Modifier.height(15.dp))
                ActionBar(onClick = navigateBack)
                Image(
                    modifier = Modifier.size(295.dp),
                    painter = painterResource(R.drawable.ill_auth),
                    contentDescription = "Illustration Authentication"
                )
                Spacer(modifier = Modifier.height(36.dp))
                Box(
                    modifier = Modifier
                        .fillMaxSize()
                        .background(
                            color = Shades50,
                            shape = RoundedCornerShape(topStart = 50.dp, topEnd = 50.dp)
                        )
                        .padding(horizontal = 30.dp, vertical = 30.dp)
                ) {
                    Column(modifier = Modifier.fillMaxSize()) {
                        CustomTextField(
                            placeholder = "Email",
                            value = email,
                            onValueChange = { email = it }
                        )
                        Spacer(modifier = Modifier.height(15.dp))
                        CustomTextField(
                            placeholder = "Password",
                            isPassword = true,
                            value = password,
                            onValueChange = { password = it }
                        )
                        Spacer(modifier = Modifier.height(36.dp))
                        CustomButton(
                            enabled = !(email.isEmpty() || password.isEmpty()),
                            text = "Masuk",
                            onClick = {
                                // Kalau Ada Error
//                                showErrorDialog = true

                                // Kalau Sukses
                            }
                        )
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
fun LoginScreenPreview() {
    LoginScreen {}
}