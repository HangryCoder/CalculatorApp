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
    //.padding(16.dp, 0.dp, 16.dp, 24.dp)

    Row(modifier = calculatorButtonsContainerModifier) {
        CalculatorDigitsContainer()
        // CalculatorFunctionalButtons()
    }
}

@Composable
fun CalculatorDigitsContainer() {
    val calculatorDigitsContainerModifier = Modifier
        // .weight(0.81f)
        .padding(0.dp, 0.dp, 16.dp, 0.dp)

    Column(modifier = calculatorDigitsContainerModifier) {
        //  FunctionalButtonsVertical()
        DigitsPanel()
    }
}

private val operationsRow = listOf("AC", "<-", "%")

@Composable
fun FunctionalButtonsVertical() {
    val calculatorFunctionalModifier = Modifier
        .fillMaxWidth()
        .weight(0.12f)

    Stack(modifier = calculatorFunctionalModifier) {
        //OperationsButtonBackground()

        Row(modifier = Modifier.fillMaxSize()) {
            operationsRow.forEach { text ->
                Stack(modifier = Modifier.weight(0.33f).fillMaxSize()) {

                    if (text == operationsRow[1]) {

                        val clearIcon = vectorResource(id = R.drawable.ic_clear)
                        val clearIconModifier = Modifier.gravity(Alignment.Center)
                            .height(25.dp)
                            .aspectRatio(1f)
                        Image(clearIcon, modifier = clearIconModifier)

                    } else {
                        val textModifier = Modifier.gravity(Alignment.Center)
                        Text(
                            text = text,
                            textAlign = TextAlign.Center,
                            modifier = textModifier,
                            color = lightBrightGrey,
                            style = MaterialTheme.typography.h6
                        )
                    }
                }
            }
        }
    }
}

@Composable()
fun OperationsButtonBackground(index: Int) {
    var spaceModifier = Modifier
        .fillMaxSize()

    if (index == 1 || index == 6 || index == 11) {
        spaceModifier = Modifier
            //.padding(0.dp, 16.dp)
            .fillMaxSize()
        if (index == 1) {
            spaceModifier =
                Modifier
                    .clip(RoundedCornerShape(100.dp, 0.dp, 0.dp, 100.dp))
                    //.padding(16.dp, 16.dp, 0.dp, 16.dp)
                    .fillMaxSize()
        } else if (index == 11) {
            spaceModifier =
                Modifier
                    .clip(RoundedCornerShape(0.dp, 100.dp, 100.dp, 0.dp))
                    //.padding(16.dp, 16.dp, 0.dp, 16.dp)
                    .fillMaxSize()

        }
    } else {
        spaceModifier = Modifier
            //.padding(0.dp, 16.dp)
            .fillMaxSize()

        if (index == 16) {
            spaceModifier =
                Modifier
                    .clip(RoundedCornerShape(100.dp, 100.dp, 0.dp, 0.dp))
                    //.padding(16.dp, 16.dp, 0.dp, 16.dp)
                    .fillMaxSize()
        } else if (index == 20) {
            Modifier
                .clip(RoundedCornerShape(0.dp, 0.dp, 100.dp, 100.dp))
                //.padding(16.dp, 16.dp, 0.dp, 16.dp)
                .fillMaxSize()
        }
    }

    Divider(
        modifier = spaceModifier,
        color = if (isSystemInDarkTheme()) darkerGrey else lighterBlueGrey
    )
}

/*private val digitsColumns = listOf(
    listOf("1", "4", "7", "."),
    listOf("2", "5", "8", "0"),
    listOf("3", "6", "9", "( )")
)*/

private val digitsColumns = listOf(
    listOf("AC", "1", "4", "7", "."),
    listOf("<-", "2", "5", "8", "0"),
    listOf("%", "3", "6", "9", "( )"),
    listOf("÷", "×", "-", "+", "=")
)

@Composable()
fun DigitsPanel() {
    val digitsPanelModifier = Modifier
        // .weight(0.88f)
        //.padding(0.dp, 16.dp, 0.dp, 0.dp)
        .fillMaxSize()

    /* Row(modifier = digitsPanelModifier) {
         digitsColumns.forEach { digitColumn ->
             Column(modifier = Modifier.weight(1f)) {
                 digitColumn.forEach { text ->
                     DigitItem(text = text)
                 }
             }
         }
     }*/

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

private val operationsColumn = listOf("÷", "×", "-", "+", "=")

@Composable
fun CalculatorFunctionalButtons() {
    val calculatorFunctionalModifier = Modifier
        .fillMaxHeight()
        .weight(0.19f)

    Stack(modifier = calculatorFunctionalModifier) {
        //OperationsButtonBackground()

        val fabIcon = vectorResource(id = R.drawable.ic_fab)
        val fabModifier = Modifier.gravity(Alignment.BottomCenter)
            .fillMaxWidth()
            .aspectRatio(1f)
        Image(fabIcon, modifier = fabModifier)


        Column(modifier = Modifier.fillMaxSize()) {
            operationsColumn.forEach { text ->
                //FunctionalItem(text)
            }
        }
    }
}

@Composable
fun FunctionalItem(button: Button) {
    /* Stack(modifier = Modifier.weight(0.25f).fillMaxSize()) {
         val textModifier = Modifier.gravity(Alignment.Center)

         Text(
             text = text,
             textAlign = TextAlign.Center,
             modifier = textModifier,
             color = lightBrightGrey,
             style = MaterialTheme.typography.h3
         )
     }*/

    Stack(modifier = Modifier.weight(0.33f).fillMaxSize()) {
        val textModifier = Modifier.gravity(Alignment.Center)

        OperationsButtonBackground(button.id)

        if (button.text == "=") {
            val fabIcon = vectorResource(id = R.drawable.ic_fab)
            val fabModifier = Modifier.gravity(Alignment.Center)
                .fillMaxSize()
                .aspectRatio(1f)
            Image(fabIcon, modifier = fabModifier)
        }

        Text(
            text = button.text,
            textAlign = TextAlign.Center,
            modifier = textModifier,
            color = lightBrightGrey,
            style = MaterialTheme.typography.h3
        )
    }
}

@Preview(showBackground = true)
@Composable
fun DefaultPreview() {
    MyApp {
        MyScreenContent()
    }
}