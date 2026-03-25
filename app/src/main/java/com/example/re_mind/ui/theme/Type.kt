package com.example.re_mind.ui.theme

import androidx.compose.material3.Typography
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.sp

// Set of Material typography styles to start with
val reMindTypography =
    Typography(
        headlineLarge =
            TextStyle(
                fontFamily = poppinsFontFamily,
                fontWeight = FontWeight.Bold,
                fontSize = 24.sp,
            ),
        headlineMedium =
            TextStyle(
                fontFamily = poppinsFontFamily,
                fontWeight = FontWeight.Bold,
                fontSize = 22.sp,
            ),
        headlineSmall =
            TextStyle(
                fontFamily = poppinsFontFamily,
                fontWeight = FontWeight.Bold,
                fontSize = 20.sp,
            ),
        titleLarge =
            TextStyle(
                fontFamily = poppinsFontFamily,
                fontWeight = FontWeight.Bold,
                fontSize = 18.sp,
            ),
        bodyLarge =
            TextStyle(
                fontFamily = poppinsFontFamily,
                fontWeight = FontWeight.Normal,
                fontSize = 16.sp,
                lineHeight = 24.sp,
                letterSpacing = 0.5.sp,
            ),
        bodyMedium =
            TextStyle(
                fontFamily = poppinsFontFamily,
                fontWeight = FontWeight.Normal,
                fontSize = 14.sp,
            ),
        bodySmall =
            TextStyle(
                fontFamily = poppinsFontFamily,
                fontWeight = FontWeight.Normal,
                fontSize = 14.sp,
            ),
        labelLarge =
            TextStyle(
                fontFamily = poppinsFontFamily,
                fontWeight = FontWeight.Normal,
                fontSize = 12.sp,
            ),
        labelMedium =
            TextStyle(
                fontFamily = poppinsFontFamily,
                fontWeight = FontWeight.Normal,
                fontSize = 10.sp,
            ),
        labelSmall =
            TextStyle(
                fontFamily = poppinsFontFamily,
                fontWeight = FontWeight.Normal,
                fontSize = 8.sp,
            ),
    )