package com.hangrycoder.neumorphiccalculator.ui

import androidx.compose.Composable
import androidx.ui.foundation.isSystemInDarkTheme
import androidx.ui.material.MaterialTheme
import androidx.ui.material.darkColorPalette
import androidx.ui.material.lightColorPalette

private val DarkColorPalette = darkColorPalette(
    primary = darkGrey,
    primaryVariant = darkGrey,
    secondary = teal200
)

private val LightColorPalette = lightColorPalette(
    primary = lightBlue,
    primaryVariant = lightBlue,
    secondary = teal200,
    background = lightBlue
)

@Composable
fun NeumorphicCalculatorTheme(
    darkTheme: Boolean = isSystemInDarkTheme(),
    content: @Composable() () -> Unit
) {
    val colors = if (darkTheme) {
        DarkColorPalette
    } else {
        LightColorPalette
    }

    MaterialTheme(
        colors = colors,
        typography = typography,
        shapes = shapes,
        content = content
    )
}