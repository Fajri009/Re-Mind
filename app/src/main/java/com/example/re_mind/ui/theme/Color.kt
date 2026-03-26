package com.example.re_mind.ui.theme

import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.sp

class MtcAppTheme {
    class Color {
        companion object {
            // Primary
            val Primary50 = Color(0xFF9F85ED)
            val Primary300 = Color(0xFF7F5CE7)
            val Primary500 = Color(0xFF5F33E1)
            val Primary700 = Color(0xFF4C29B4)
            val Primary900 = Color(0xFF391F87)

            // Secondary
            val Secondary50 = Color(0xFFC1EBFF)
            val Secondary300 = Color(0xFFACE5FF)
            val Secondary500 = Color(0xFF97DEFF)
            val Secondary700 = Color(0xFF88C8E6)
            val Secondary900 = Color(0xFF79B2CC)

            // Neutral
            val Neutral50 = Color(0xFFF3F1FF)
            val Neutral100 = Color(0xFFEAE7ED)
            val Neutral200 = Color(0xFFD0D0D0)
            val Neutral300 = Color(0xFFBDBDBD)
            val Neutral400 = Color(0xFFAAAAAA)
            val Neutral500 = Color(0xFF909090)

            // Success
            val Success50 = Color(0xFFAFFCB6)
            val Success300 = Color(0xFF94FB9E)
            val Success500 = Color(0xFF79FA86)
            val Success700 = Color(0xFF61C86B)
            val Success900 = Color(0xFF499650)

            // Warning
            val Warning50 = Color(0xFFFFE090)
            val Warning300 = Color(0xFFFFD56B)
            val Warning500 = Color(0xFFFFD059)
            val Warning700 = Color(0xFFFFCB46)
            val Warning900 = Color(0xFFE6B73F)

            // Error
            val Error50 = Color(0xFFE56969)
            val Error300 = Color(0xFFE15757)
            val Error500 = Color(0xFFDE4444)
            val Error700 = Color(0xFFC83D3D)
            val Error900 = Color(0xFFB23636)

            // Shades
            val Shades50 = Color(0xFFFFFFFF)
            val Shades100 = Color(0xFF101010)
        }
    }

    class Text {
        companion object {
            // Normal
            val heading1 =
                TextStyle(
                    fontFamily = poppinsFontFamily,
                    fontWeight = FontWeight.Normal,
                    fontSize = 53.sp
                )

            val heading2 =
                TextStyle(
                    fontFamily = poppinsFontFamily,
                    fontWeight = FontWeight.Normal,
                    fontSize = 43.sp
                )

            val heading3 =
                TextStyle(
                    fontFamily = poppinsFontFamily,
                    fontWeight = FontWeight.Normal,
                    fontSize = 34.sp
                )

            val heading4 =
                TextStyle(
                    fontFamily = poppinsFontFamily,
                    fontWeight = FontWeight.Normal,
                    fontSize = 27.sp
                )

            val heading5 =
                TextStyle(
                    fontFamily = poppinsFontFamily,
                    fontWeight = FontWeight.Normal,
                    fontSize = 22.sp
                )

            val heading6 =
                TextStyle(
                    fontFamily = poppinsFontFamily,
                    fontWeight = FontWeight.Normal,
                    fontSize = 18.sp
                )

            val paragraph1 =
                TextStyle(
                    fontFamily = poppinsFontFamily,
                    fontWeight = FontWeight.Normal,
                    fontSize = 14.sp
                )

            val paragraph2 =
                TextStyle(
                    fontFamily = poppinsFontFamily,
                    fontWeight = FontWeight.Normal,
                    fontSize = 12.sp
                )

            val paragraph3 =
                TextStyle(
                    fontFamily = poppinsFontFamily,
                    fontWeight = FontWeight.Normal,
                    fontSize = 10.sp
                )

            // SemiBold
            val heading1SemiBold =
                TextStyle(
                    fontFamily = poppinsFontFamily,
                    fontWeight = FontWeight.SemiBold,
                    fontSize = 53.sp
                )

            val heading2SemiBold =
                TextStyle(
                    fontFamily = poppinsFontFamily,
                    fontWeight = FontWeight.SemiBold,
                    fontSize = 43.sp
                )

            val heading3SemiBold =
                TextStyle(
                    fontFamily = poppinsFontFamily,
                    fontWeight = FontWeight.SemiBold,
                    fontSize = 34.sp
                )

            val heading4SemiBold =
                TextStyle(
                    fontFamily = poppinsFontFamily,
                    fontWeight = FontWeight.SemiBold,
                    fontSize = 27.sp
                )

            val heading5SemiBold =
                TextStyle(
                    fontFamily = poppinsFontFamily,
                    fontWeight = FontWeight.SemiBold,
                    fontSize = 22.sp
                )

            val heading6SemiBold =
                TextStyle(
                    fontFamily = poppinsFontFamily,
                    fontWeight = FontWeight.SemiBold,
                    fontSize = 18.sp
                )

            val paragraph1SemiBold =
                TextStyle(
                    fontFamily = poppinsFontFamily,
                    fontWeight = FontWeight.SemiBold,
                    fontSize = 14.sp
                )

            val paragraph2SemiBold =
                TextStyle(
                    fontFamily = poppinsFontFamily,
                    fontWeight = FontWeight.SemiBold,
                    fontSize = 12.sp
                )

            val paragraph3SemiBold =
                TextStyle(
                    fontFamily = poppinsFontFamily,
                    fontWeight = FontWeight.SemiBold,
                    fontSize = 10.sp
                )

            // Bold
            val heading1Bold =
                TextStyle(
                    fontFamily = poppinsFontFamily,
                    fontWeight = FontWeight.Bold,
                    fontSize = 53.sp
                )

            val heading2Bold =
                TextStyle(
                    fontFamily = poppinsFontFamily,
                    fontWeight = FontWeight.Bold,
                    fontSize = 43.sp
                )

            val heading3Bold =
                TextStyle(
                    fontFamily = poppinsFontFamily,
                    fontWeight = FontWeight.Bold,
                    fontSize = 34.sp
                )

            val heading4Bold =
                TextStyle(
                    fontFamily = poppinsFontFamily,
                    fontWeight = FontWeight.Bold,
                    fontSize = 27.sp
                )

            val heading5Bold =
                TextStyle(
                    fontFamily = poppinsFontFamily,
                    fontWeight = FontWeight.Bold,
                    fontSize = 22.sp
                )

            val heading6Bold =
                TextStyle(
                    fontFamily = poppinsFontFamily,
                    fontWeight = FontWeight.Bold,
                    fontSize = 18.sp
                )

            val paragraph1Bold =
                TextStyle(
                    fontFamily = poppinsFontFamily,
                    fontWeight = FontWeight.Bold,
                    fontSize = 14.sp
                )

            val paragraph2Bold =
                TextStyle(
                    fontFamily = poppinsFontFamily,
                    fontWeight = FontWeight.Bold,
                    fontSize = 12.sp
                )

            val paragraph3Bold =
                TextStyle(
                    fontFamily = poppinsFontFamily,
                    fontWeight = FontWeight.Bold,
                    fontSize = 10.sp
                )
        }
    }
}