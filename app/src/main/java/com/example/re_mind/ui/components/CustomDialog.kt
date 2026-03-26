package com.example.re_mind.ui.components

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.re_mind.R
import com.example.re_mind.ui.theme.MtcAppTheme.Color.Companion.Neutral500
import com.example.re_mind.ui.theme.MtcAppTheme.Color.Companion.Shades100
import com.example.re_mind.ui.theme.MtcAppTheme.Text.Companion.heading6Bold
import com.example.re_mind.ui.theme.MtcAppTheme.Text.Companion.paragraph2

@Composable
fun CustomDialog(
    onDismiss: () -> Unit,
    isSuccess: Boolean,
    text: String
) {
    Card(colors = CardDefaults.cardColors(containerColor = Color.White)) {
        Box(
            modifier = Modifier.padding(horizontal = 20.dp, vertical = 12.dp),
        ) {
            IconButton(
                modifier = Modifier.size(24.dp),
                onClick = onDismiss,
            ) {
                Icon(
                    modifier = Modifier.size(18.dp),
                    painter = painterResource(R.drawable.ic_close_dialog),
                    tint = Neutral500,
                    contentDescription = "Icon Close Dialog"
                )
            }
            Column(
                modifier = Modifier.padding(horizontal = 30.dp),
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                Image(
                    modifier = Modifier.size(100.dp),
                    painter = painterResource(
                        id = 
                            if (isSuccess) R.drawable.ic_success
                            else R.drawable.ic_fail
                    ),
                    contentDescription = "Icon Dialog"
                )
                Spacer(modifier = Modifier.height(20.dp))
                Text(
                    text =
                        if (isSuccess) "BERHASIL!"
                        else "GAGAL!",
                    color = Shades100,
                    style = heading6Bold
                )
                Text(
                    text = text,
                    color = Neutral500,
                    style = paragraph2
                )
            }
        }
    }
}

@Preview
@Composable
fun CustomDialogPreview() {
    CustomDialog(
        onDismiss = {},
        isSuccess = false,
        text = "Email atau password tidak sesuai"
    )
}