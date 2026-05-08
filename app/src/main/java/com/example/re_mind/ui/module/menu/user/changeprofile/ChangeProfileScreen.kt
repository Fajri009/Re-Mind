package com.example.re_mind.ui.module.menu.user.changeprofile

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
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
import com.example.re_mind.ui.module.auth.ActionBar
import com.example.re_mind.ui.theme.MtcAppTheme.Color.Companion.Primary300
import com.example.re_mind.ui.theme.MtcAppTheme.Color.Companion.Primary500
import com.example.re_mind.ui.theme.MtcAppTheme.Color.Companion.Shades50

@Composable
fun ChangeProfileScreen(
    navigateBack: () -> Unit
) {
    var email by remember { mutableStateOf("") }
    var username by remember { mutableStateOf("") }
    var date by remember { mutableStateOf("") }

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
                        title = "Ubah Profil"
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
                            Spacer(modifier = Modifier.size(30.dp))
                            CustomTextField(
                                placeholder = "Email",
                                value = email,
                                onValueChange = { email = it }
                            )
                            Spacer(modifier = Modifier.size(20.dp))
                            CustomTextField(
                                placeholder = "Username",
                                value = username,
                                onValueChange = { username = it }
                            )
                            Spacer(modifier = Modifier.size(20.dp))
                            CustomTextField(
                                placeholder = "Tanggal Lahir",
                                value = date,
                                onValueChange = { date = it }
                            )
                            Spacer(modifier = Modifier.weight(1f))
                            CustomButton(
                                text = "Simpan",
                                onClick = { showSuccessDialog = true }
                            )
                        }
                    }
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
                            text = "Data profilmu telah berhasil diubah"
                        )
                    }
                }
            }
        }
    }
}

@Preview
@Composable
fun ChangeProfileScreenPreview() {
    ChangeProfileScreen(navigateBack = {})
}