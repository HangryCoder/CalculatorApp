package com.hangrycoder.neumorphiccalculator.ui

import androidx.ui.material.Typography
import androidx.ui.text.TextStyle
import androidx.ui.text.font.*
import androidx.ui.unit.sp
import com.hangrycoder.neumorphiccalculator.R

// Set of Material typography styles to start with
val typography = Typography(
        body1 = TextStyle(
                fontFamily = FontFamily.Default,
                fontWeight = FontWeight.Normal,
                fontSize = 16.sp
        )/*,
        button = TextStyle(
                fontFamily = FontFamily.Default,
                fontWeight = FontWeight.W500,
                fontSize = 14.sp
        ),
        caption = TextStyle(
                fontFamily = FontFamily.Default,
                fontWeight = FontWeight.Normal,
                fontSize = 12.sp
        )*/,
        h4 = TextStyle(
                fontFamily = fontFamily(font(
                        resId = R.font.googlesans_bold
                )),
                fontWeight = FontWeight.Normal,
                fontSize = 24.sp
        ),

        h5 = TextStyle(
                fontFamily = fontFamily(font(
                        resId = R.font.digital_7
                )),
                fontWeight = FontWeight.Normal,
                fontSize = 20.sp
        ),

        h2 = TextStyle(
                fontFamily = fontFamily(font(
                        resId = R.font.digital_7
                )),
                fontWeight = FontWeight.Normal,
                fontSize = 36.sp
        ),
        h3 = TextStyle(
                fontFamily = fontFamily(font(
                        resId = R.font.googlesans_regular
                )),
                fontSize = 26.sp
        )

)