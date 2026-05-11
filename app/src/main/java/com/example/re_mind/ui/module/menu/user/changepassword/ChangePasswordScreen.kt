package com.example.re_mind.ui.module.menu.user.changepassword

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
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
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.window.Dialog
import com.example.re_mind.ui.components.CustomButton
import com.example.re_mind.ui.components.CustomDialog
import com.example.re_mind.ui.components.CustomTextField
import com.example.re_mind.ui.module.auth.ActionBar
import com.example.re_mind.ui.theme.MtcAppTheme.Color.Companion.Primary500
import com.example.re_mind.ui.theme.MtcAppTheme.Color.Companion.Shades50

@Composable
fun ChangePasswordScreen(
    navigateBack: () -> Unit
) {
    var oldPassword by remember { mutableStateOf("") }
    var newPassword by remember { mutableStateOf("") }
    var confirmationPassword by remember { mutableStateOf("") }

    var showSuccessDialog by remember { mutableStateOf(false) }

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
            Box(
                modifier = Modifier
                    .padding(innerPadding)
                    .fillMaxSize()
            ) {
                Column(horizontalAlignment = Alignment.CenterHorizontally) {
                    Spacer(modifier = Modifier.height(15.dp))
                    ActionBar(
                        onClick = navigateBack,
                        title = "Ubah Password"
                    )
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
                                .padding(bottom = 50.dp),
                            horizontalAlignment = Alignment.CenterHorizontally
                        ) {
                            Spacer(modifier = Modifier.size(55.dp))
                            CustomTextField(
                                placeholder = "Password Lama",
                                value = oldPassword,
                                onValueChange = { oldPassword = it },
                                isPassword = true
                            )
                            Spacer(modifier = Modifier.size(25.dp))
                            CustomTextField(
                                placeholder = "Password Baru",
                                value = newPassword,
                                onValueChange = { newPassword = it },
                                isPassword = true
                            )
                            Spacer(modifier = Modifier.size(25.dp))
                            CustomTextField(
                                placeholder = "Konfirmasi Password Baru",
                                value = confirmationPassword,
                                onValueChange = { confirmationPassword = it },
                                isPassword = true
                            )
                            Spacer(modifier = Modifier.weight(1f))
                            CustomButton(
                                text = "Simpan",
                                onClick = { showSuccessDialog = true }
                            )
                        }

                        if (showSuccessDialog) {
                            Dialog(
                                onDismissRequest = {
                                    showSuccessDialog = false
                                    navigateBack()
                                }
                            ) {
                                CustomDialog(
                                    onDismiss = {
                                        showSuccessDialog = false
                                        navigateBack()
                                    },
                                    isSuccess = true,
                                    text = "Passwordmu telah berhasil diubah"
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
fun ChangePasswordScreenPreview() {
    ChangePasswordScreen(navigateBack = {})
}