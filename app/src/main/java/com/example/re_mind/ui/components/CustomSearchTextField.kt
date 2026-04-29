package com.example.re_mind.ui.components

import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Icon
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.re_mind.R
import com.example.re_mind.ui.theme.MtcAppTheme.Color.Companion.Neutral500
import com.example.re_mind.ui.theme.MtcAppTheme.Color.Companion.Primary50
import com.example.re_mind.ui.theme.MtcAppTheme.Color.Companion.Primary500
import com.example.re_mind.ui.theme.MtcAppTheme.Color.Companion.Shades50
import com.example.re_mind.ui.theme.MtcAppTheme.Text.Companion.paragraph2

@Composable
fun CustomSearchTextField(
    modifier: Modifier,
    value: String,
    onValueChange: (String) -> Unit
) {
    OutlinedTextField(
        modifier = modifier,
        value = value,
        onValueChange = onValueChange,
        shape = RoundedCornerShape(5.dp),
        singleLine = true,
        placeholder = {
            Text(
                text = "Cari Tugas",
                color = Neutral500,
                style = paragraph2
            )
        },
        trailingIcon = {
            Icon(
                modifier = Modifier.size(18.dp),
                painter = painterResource(R.drawable.ic_search),
                contentDescription = "Icon Search",
                tint = Neutral500
            )
        },
        colors = TextFieldDefaults.colors(
            focusedContainerColor = Shades50,
            unfocusedContainerColor = Shades50,

            // Border (outline)
            focusedIndicatorColor = Primary500,
            unfocusedIndicatorColor = Primary50
        )
    )
}

@Preview
@Composable
fun CustomSearchTextFieldPreview() {
    CustomSearchTextField(
        modifier = Modifier,
        value = "",
        onValueChange = {}
    )
}