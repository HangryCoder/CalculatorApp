package com.hangrycoder.neumorphiccalculator

import android.os.Bundle
import android.widget.ImageView
import androidx.appcompat.app.AppCompatActivity
import androidx.compose.Composable
import androidx.ui.core.*
import androidx.ui.foundation.Image
import androidx.ui.foundation.Text
import androidx.ui.foundation.isSystemInDarkTheme
import androidx.ui.foundation.shape.corner.RoundedCornerShape
import androidx.ui.layout.*
import androidx.ui.layout.ColumnScope.weight
import androidx.ui.material.*
import androidx.ui.res.vectorResource
import androidx.ui.text.style.TextAlign
import androidx.ui.tooling.preview.Preview
import androidx.ui.unit.dp
import androidx.ui.viewinterop.AndroidView
import com.hangrycoder.neumorphiccalculator.ui.*
import soup.neumorphism.NeumorphButton

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            MyApp {
                MyScreenContent()
            }
        }
    }
}

@Composable
fun MyApp(content: @Composable() () -> Unit) {
    NeumorphicCalculatorTheme {
        Surface(color = if (isSystemInDarkTheme()) darkGrey else lightBlue) {
            content()
        }
    }
}

@Composable
fun MyScreenContent() {
    Column(modifier = Modifier.weight(1f)) {
        Toolbar()
        CalculatorMainContent()
    }
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

@Composable
fun CalculatorMainContent() {
    Column(modifier = Modifier.weight(1f)) {
        DigitalInputContainer()
        CalculatorButtonsContainer()
    }
}

@Composable
fun DigitalInputContainer() {
    Stack(modifier = Modifier.padding(16.dp, 24.dp).weight(0.25f)) {
        AndroidView(resId = R.layout.layout_digital_input_container, postInflationCallback = {
            it.findViewById<ImageView>(R.id.imageView)
                .setImageResource(R.drawable.ic_digital_input_container)
        })

        Text(
            text = "100 + 25 + 25 + 100",
            modifier = Modifier.gravity(Alignment.TopEnd)
                .padding(0.dp, 32.dp, 32.dp, 0.dp),
            color = darkGrey,
            style = MaterialTheme.typography.h5
        )

        Text(
            text = "=",
            modifier = Modifier.gravity(Alignment.BottomStart)
                .padding(32.dp, 0.dp, 0.dp, 32.dp),
            color = darkGrey,
            style = MaterialTheme.typography.h2
        )

        Text(
            text = "250",
            modifier = Modifier.gravity(Alignment.BottomEnd)
                .padding(0.dp, 0.dp, 32.dp, 32.dp),
            color = darkGrey,
            style = MaterialTheme.typography.h2
        )
    }

}

@Composable
fun CalculatorButtonsContainer() {
    val calculatorButtonsContainerModifier = Modifier
        .weight(0.75f)
        .fillMaxSize()

    Row(modifier = calculatorButtonsContainerModifier) {
        CalculatorDigitsContainer()
    }
}

@Composable
fun CalculatorDigitsContainer() {
    Column {
        DigitsPanel()
    }
}

@Composable()
fun OperationsButtonBackground(gravityModifier: Modifier, index: Int) {
    var spaceModifier: Modifier

    if (index == 1 || index == 6 || index == 11) {
        spaceModifier = Modifier
            .plus(gravityModifier)
            .plus(
                when (index) {
                    1 -> Modifier
                        .clip(RoundedCornerShape(100.dp, 0.dp, 0.dp, 100.dp))
                    11 -> Modifier
                        .clip(RoundedCornerShape(0.dp, 100.dp, 100.dp, 0.dp))
                    else -> Modifier
                }
            )
            .fillMaxWidth()
            .preferredHeight(72.dp)
    } else {
        spaceModifier = Modifier
            .fillMaxSize()

        if (index == 16) {
            spaceModifier =
                Modifier
                    .clip(RoundedCornerShape(100.dp, 100.dp, 0.dp, 0.dp))
                    .fillMaxSize()
        } else if (index == 20) {
            spaceModifier = Modifier
                .clip(RoundedCornerShape(0.dp, 0.dp, 100.dp, 100.dp))
                .fillMaxSize()
        }
    }

    Divider(
        modifier = spaceModifier,
        color = if (isSystemInDarkTheme()) darkerGrey else lighterBlueGrey
    )
}

@Composable()
fun DigitsPanel() {
    val digitsPanelModifier = Modifier
        .fillMaxSize()

    Row(modifier = digitsPanelModifier) {
        Utils.getCalculatorButtons().forEach { buttonRow ->
            Column(modifier = Modifier.weight(1f)) {
                buttonRow.forEach { button ->
                    if (button.type == ButtonType.DIGITS) {
                        DigitItem(text = button.text)
                    } else {
                        FunctionalItem(button)
                    }
                }
            }
        }
    }
}


@Composable
fun DigitItem(text: String) {
    Stack(modifier = Modifier.weight(0.33f)) {
        AndroidView(resId = R.layout.layout_neumorphic_digit_item,
            postInflationCallback = {
                val neumorphButton = it.findViewById<NeumorphButton>(R.id.button)
                neumorphButton.text = text
            })
    }
}

@Composable
fun FunctionalItem(button: Button) {
    var stackModifier: Modifier
    val index = button.id

    if (index == 1 || index == 6 || index == 11) {
        stackModifier = Modifier
            .padding(0.dp, 16.dp)
            .weight(0.33f).fillMaxSize()
        if (index == 1) {
            stackModifier =
                Modifier
                    .padding(16.dp, 16.dp, 0.dp, 16.dp)
                    .weight(0.33f).fillMaxSize()
        } else if (index == 11) {
            stackModifier =
                Modifier
                    .padding(0.dp, 16.dp, 8.dp, 16.dp)
                    .weight(0.33f).fillMaxSize()
        }
    } else {
        stackModifier = Modifier
            .padding(8.dp, 0.dp, 0.dp, 0.dp)
            .preferredWidth(72.dp)
            .weight(0.33f).fillMaxSize()
        if (index == 16) {
            stackModifier =
                Modifier
                    .padding(8.dp, 16.dp, 0.dp, 0.dp)
                    .preferredWidth(72.dp)
                    .weight(0.33f).fillMaxSize()
        } else if (index == 20) {
            stackModifier = Modifier
                .padding(8.dp, 0.dp, 0.dp, 30.dp)
                .preferredHeight(72.dp)
                .preferredWidth(72.dp)
            //.weight(0.33f).fillMaxSize()
        }
    }


    Stack(modifier = stackModifier) {
        val textModifier = Modifier.gravity(Alignment.Center)

        val operationsButtonModifier = Modifier.gravity(Alignment.Center)
        OperationsButtonBackground(operationsButtonModifier, index)

        if (index == 20) {
            val fabIcon = vectorResource(id = R.drawable.ic_fab)
            val fabModifier = Modifier.gravity(Alignment.Center)
                .fillMaxSize()
                .aspectRatio(1f)
            Image(fabIcon, modifier = fabModifier)
        }

        if (index == 6) {
            val clearIcon = vectorResource(id = R.drawable.ic_clear)
            val clearIconModifier = Modifier.gravity(Alignment.Center)
                .height(25.dp)
                .aspectRatio(1f)
            Image(clearIcon, modifier = clearIconModifier)
        } else {
            val style =
                if (index == 1 || index == 6 || index == 11) {
                    MaterialTheme.typography.body1
                } else {
                    MaterialTheme.typography.h3
                }

            Text(
                text = button.text,
                textAlign = TextAlign.Center,
                modifier = textModifier,
                color = lightBrightGrey,
                style = style
            )
        }
    }
}

@Preview(showBackground = true)
@Composable
fun DefaultPreview() {
    MyApp {
        MyScreenContent()
    }
}