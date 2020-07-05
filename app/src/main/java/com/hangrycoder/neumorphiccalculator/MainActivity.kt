package com.hangrycoder.neumorphiccalculator

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.compose.Composable
import androidx.ui.core.*
import androidx.ui.foundation.Image
import androidx.ui.foundation.Text
import androidx.ui.foundation.shape.corner.RoundedCornerShape
import androidx.ui.layout.*
import androidx.ui.layout.ColumnScope.weight
import androidx.ui.material.*
import androidx.ui.res.vectorResource
import androidx.ui.tooling.preview.Preview
import androidx.ui.unit.dp
import com.hangrycoder.neumorphiccalculator.ui.NeumorphicCalculatorTheme
import com.hangrycoder.neumorphiccalculator.ui.darkGrey
import com.hangrycoder.neumorphiccalculator.ui.darkerGrey
import com.hangrycoder.neumorphiccalculator.ui.lightGrey

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
        //CalculatorButtonsContainer()
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
            .padding(16.dp, 0.dp, 16.dp, 24.dp)

    Column(modifier = calculatorButtonsContainerModifier) {
        EmptySpace()
    }
}

@Composable
fun CalculatorDigitsContainer() {
    //Column(modifier = Modifier.aspectRatio(0.6f)) {
        EmptySpace()
        CalculatorDigits()
    //}
}

@Composable
fun EmptySpace() {
    val spaceModifier = Modifier
            .aspectRatio(0.2f)
            .clip(RoundedCornerShape(16.dp))
    Surface(modifier = spaceModifier, color = darkerGrey) {

    }
}

@Composable
fun CalculatorDigits() {
    Surface(modifier = Modifier.aspectRatio(0.8f)) {
        Text(text = "CalculatorDigits")
    }
}

@Composable
fun CalculatorFunctionalButtons() {
    Surface(modifier = Modifier.aspectRatio(0.4f)) {
        Text(text = "CalculatorFunctionalButtons")
    }
}

@Preview(showBackground = true)
@Composable
fun DefaultPreview() {
    MyApp {
        MyScreenContent()
    }
}