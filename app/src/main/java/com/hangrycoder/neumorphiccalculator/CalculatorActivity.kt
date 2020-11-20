package com.hangrycoder.neumorphiccalculator

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.compose.Composable
import androidx.ui.core.Modifier
import androidx.ui.core.setContent
import androidx.ui.foundation.Text
import androidx.ui.foundation.isSystemInDarkTheme
import androidx.ui.layout.padding
import androidx.ui.material.MaterialTheme
import androidx.ui.material.Surface
import androidx.ui.material.TopAppBar
import androidx.ui.tooling.preview.Preview
import androidx.ui.unit.dp
import com.hangrycoder.neumorphiccalculator.ui.*

class CalculatorActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            CalculatorApp {
                CalculatorScreen()
            }
        }
    }

    @Composable
    fun CalculatorApp(content: @Composable() () -> Unit) {
        NeumorphicCalculatorTheme {
            Surface(color = if (isSystemInDarkTheme()) darkGrey else lightBlue) {
                content()
            }
        }
    }

    @Preview(showBackground = true)
    @Composable
    fun DefaultPreview() {
        CalculatorApp {
            CalculatorScreen()
        }
    }

    @Composable
    fun CalculatorScreen() {
        Toolbar()
    }

    @Composable
    fun Toolbar() {
        TopAppBar(
            title = {
                Text(
                    text = "Calculator",
                    color = if (isSystemInDarkTheme()) lightGrey else darkBlue,
                    modifier = Modifier.padding(0.dp, 16.dp),
                    style = MaterialTheme.typography.h4
                )
            }, backgroundColor = if (isSystemInDarkTheme()) darkGrey else lightBlue,
            elevation = 0.dp
        )
    }

}