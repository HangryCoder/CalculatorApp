package com.hangrycoder.neumorphiccalculator

object Utils {

    /*
    * private val buttonsColumns = listOf(
    listOf("AC", "1", "4", "7", "."),
    listOf("<-", "2", "5", "8", "0"),
    listOf("%", "3", "6", "9", "( )"),
    listOf("÷", "×", "-", "+", "=")
)*/

    fun getCalculatorButtons() {

        val calculatorButtons = ArrayList<Button>()

        var button = Button(id = 1, text = "AC", type = ButtonType.OPERATION)
        calculatorButtons.add(button)
        button = Button(id = 2, text = "<-", type = ButtonType.OPERATION)
        calculatorButtons.add(button)
        button = Button(id = 3, text = "%", type = ButtonType.OPERATION)
        calculatorButtons.add(button)
        button = Button(id = 4, text = "÷", type = ButtonType.OPERATION)
        calculatorButtons.add(button)

        button = Button(id = 5, text = "1", type = ButtonType.DIGITS)
        calculatorButtons.add(button)
        button = Button(id = 6, text = "2", type = ButtonType.DIGITS)
        calculatorButtons.add(button)
        button = Button(id = 7, text = "3", type = ButtonType.DIGITS)
        calculatorButtons.add(button)
        button = Button(id = 8, text = "×", type = ButtonType.OPERATION)
        calculatorButtons.add(button)


        button = Button(id = 9, text = "4", type = ButtonType.DIGITS)
        calculatorButtons.add(button)
        button = Button(id = 10, text = "5", type = ButtonType.DIGITS)
        calculatorButtons.add(button)
        button = Button(id = 11, text = "6", type = ButtonType.DIGITS)
        calculatorButtons.add(button)
        button = Button(id = 12, text = "-", type = ButtonType.OPERATION)
        calculatorButtons.add(button)

        button = Button(id = 13, text = "7", type = ButtonType.DIGITS)
        calculatorButtons.add(button)
        button = Button(id = 14, text = "8", type = ButtonType.DIGITS)
        calculatorButtons.add(button)
        button = Button(id = 15, text = "9", type = ButtonType.DIGITS)
        calculatorButtons.add(button)
        button = Button(id = 16, text = "+", type = ButtonType.OPERATION)
        calculatorButtons.add(button)


        button = Button(id = 17, text = ".", type = ButtonType.DIGITS)
        calculatorButtons.add(button)
        button = Button(id = 18, text = "0", type = ButtonType.DIGITS)
        calculatorButtons.add(button)
        button = Button(id = 19, text = "( )", type = ButtonType.DIGITS)
        calculatorButtons.add(button)
        button = Button(id = 20, text = "=", type = ButtonType.OPERATION)
        calculatorButtons.add(button)

    }
}