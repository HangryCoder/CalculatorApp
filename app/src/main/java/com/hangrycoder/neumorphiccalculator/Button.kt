package com.hangrycoder.neumorphiccalculator

data class Button(val id: Int, val text: String,val type: ButtonType = ButtonType.DIGITS)

enum class ButtonType {
    DIGITS,
    OPERATION
}