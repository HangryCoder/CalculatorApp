package com.hangrycoder.neumorphiccalculator

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.compose.Composable
import androidx.ui.core.*
import androidx.ui.foundation.Image
import androidx.ui.foundation.Text
import androidx.ui.foundation.shape.corner.CircleShape
import androidx.ui.foundation.shape.corner.RoundedCornerShape
import androidx.ui.layout.*
import androidx.ui.layout.ColumnScope.weight
import androidx.ui.material.*
import androidx.ui.res.imageResource
import androidx.ui.res.vectorResource
import androidx.ui.text.style.TextAlign
import androidx.ui.tooling.preview.Preview
import androidx.ui.unit.dp
import com.hangrycoder.neumorphiccalculator.ui.*

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
        Surface(color = darkGrey) {
            content()
        }
    }
}

@Composable
fun MyScreenContent() {
    Column(modifier = Modifier.weight(1f)) {
        Toolbar()
        DigitalInputContainer(resId = R.drawable.ic_digital_input_container)
        CalculatorButtonsContainer()
    }
}

@Composable
fun Toolbar() {
    TopAppBar(title = {
        Text(text = "Calculator",
                color = lightGrey,
                modifier = Modifier.padding(0.dp, 16.dp),
                style = MaterialTheme.typography.h4)
    }, backgroundColor = darkGrey,
            elevation = 0.dp)
}

@Composable
fun DigitalInputContainer(resId: Int) {
    Stack(modifier = Modifier.padding(16.dp, 24.dp)) {
        val imageModifier = Modifier
                .preferredHeight(130.dp)
                .fillMaxWidth()
                .clip(shape = RoundedCornerShape(8.dp))

        val image = vectorResource(resId)
        Image(image,
                modifier = imageModifier,
                contentScale = ContentScale.Crop)

        Text(text = "100 + 25 + 25 + 100",
                modifier = Modifier.gravity(Alignment.TopEnd)
                        .padding(0.dp, 24.dp, 24.dp, 0.dp),
                color = darkGrey,
                style = MaterialTheme.typography.h5
        )

        Text(text = "=",
                modifier = Modifier.gravity(Alignment.BottomStart)
                        .padding(24.dp, 0.dp, 0.dp, 24.dp),
                color = darkGrey,
                style = MaterialTheme.typography.h2
        )

        Text(text = "250",
                modifier = Modifier.gravity(Alignment.BottomEnd)
                        .padding(0.dp, 0.dp, 24.dp, 24.dp),
                color = darkGrey,
                style = MaterialTheme.typography.h2
        )
    }

}

@Composable
fun CalculatorButtonsContainer() {
    val calculatorButtonsContainerModifier = Modifier
            .fillMaxSize()
            .padding(16.dp, 0.dp, 16.dp, 24.dp)

    Row(modifier = calculatorButtonsContainerModifier) {
        CalculatorDigitsContainer()
        CalculatorFunctionalButtons()
    }
}

@Composable
fun CalculatorDigitsContainer() {
    val calculatorDigitsContainerModifier = Modifier
            .weight(0.82f)
            .padding(0.dp, 0.dp, 16.dp, 0.dp)

    Column(modifier = calculatorDigitsContainerModifier) {
        EmptySpace()
        DigitsPanel()
    }
}

@Composable
fun EmptySpace() {
    val spaceModifier = Modifier
            .weight(0.1f)
            .clip(RoundedCornerShape(32.dp))
    Divider(modifier = spaceModifier, color = darkerGrey)
}

private val digitsColumns = listOf(
        listOf("1", "4", "7", "."),
        listOf("2", "5", "8", "0"),
        listOf("3", "6", "9", "00")
)

@Composable()
fun DigitsPanel() {
    val digitsPanelModifier = Modifier
            .weight(0.9f)
            .padding(0.dp, 16.dp, 0.dp, 0.dp)
            .fillMaxSize()

    Row(modifier = digitsPanelModifier) {
        digitsColumns.forEach { digitColumn ->
            Column(modifier = Modifier.weight(1f)) {
                digitColumn.forEach { text ->
                    DigitItem(text = text)
                }
            }
        }
    }
}

@Composable
fun DigitItem(text: String) {
    Stack(modifier = Modifier.weight(0.33f)) {
        val imageBackgroundModifier = Modifier
                .gravity(Alignment.Center)
                .padding(16.dp, 20.dp, 0.dp, 0.dp)
                .fillMaxWidth()

        val imageBackground = imageResource(id = R.drawable.digit_item_background)
        Image(imageBackground, modifier = imageBackgroundModifier)

        val imageForegroundModifier = Modifier
                .gravity(Alignment.Center)
                .fillMaxWidth()

        val imageForeground = imageResource(id = R.drawable.digit_item_foreground)
        Image(imageForeground, modifier = imageForegroundModifier)

        Text(text = text, textAlign = TextAlign.Center,
                modifier = Modifier.gravity(Alignment.Center),
                color = lightBrightGrey,
                style = MaterialTheme.typography.h3)
    }
}

private val operationsColumn = listOf("÷", "×", "-", "+", "=")

@Composable
fun CalculatorFunctionalButtons() {
    val calculatorFunctionalModifier = Modifier
            .fillMaxHeight()
            .weight(0.18f)

    Stack(modifier = calculatorFunctionalModifier) {
        val spaceModifier = Modifier
                .fillMaxSize()
                .clip(RoundedCornerShape(32.dp))

        Divider(modifier = spaceModifier, color = darkerGrey)

        val fabModifier = Modifier.gravity(Alignment.BottomCenter)
                .fillMaxWidth()
                .aspectRatio(1f)
        val fabIcon = vectorResource(id = R.drawable.ic_fab)
        Image(fabIcon, modifier = fabModifier)

        Column(modifier = Modifier.fillMaxSize()) {
            operationsColumn.forEach { operationColumn ->
                Row(modifier = Modifier.weight(1f)) {
                    operationColumn.forEach { text ->
                        FunctionalItem(text.toString())
                    }
                }
            }
        }
    }
}

@Composable
fun FunctionalItem(text: String) {
    Stack(modifier = Modifier.weight(0.25f).fillMaxSize()) {
        val textModifier = Modifier.gravity(Alignment.Center)

        Text(text = text,
                textAlign = TextAlign.Center,
                modifier = textModifier,
                color = lightBrightGrey,
                style = MaterialTheme.typography.h3)
    }
}

@Preview(showBackground = true)
@Composable
fun DefaultPreview() {
    MyApp {
        MyScreenContent()
    }
}