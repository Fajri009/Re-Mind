package com.example.re_mind.ui.module.component

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.re_mind.R
import com.example.re_mind.ui.theme.MtcAppTheme.Color.Companion.Shades50
import com.example.re_mind.ui.theme.MtcAppTheme.Text.Companion.heading6Bold

@Composable
fun ActionBar(onClick: () -> Unit) {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .padding(horizontal = 30.dp),
        verticalAlignment = Alignment.CenterVertically
    ) {
        IconButton(
            onClick = onClick
        ) {
            Icon(
                painter = painterResource(R.drawable.ic_default_arrow_left),
                contentDescription = "Icon Back",
                tint = Shades50
            )
        }
        Spacer(modifier = Modifier.width(15.dp))
        Image(
            modifier = Modifier.size(24.dp),
            painter = painterResource(R.drawable.ic_app),
            contentDescription = "Icon App"
        )
        Spacer(modifier = Modifier.width(15.dp))
        Text(
            text = "Re-Mind",
            style = heading6Bold,
            color = Shades50
        )
    }
}

@Preview
@Composable
fun ActionBarPreview() {
    ActionBar {}
}