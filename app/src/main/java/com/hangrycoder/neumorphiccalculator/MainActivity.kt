package com.hangrycoder.neumorphiccalculator

import android.graphics.drawable.Drawable
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.compose.Composable
import androidx.ui.core.Modifier
import androidx.ui.core.setContent
import androidx.ui.foundation.Image
import androidx.ui.foundation.Text
import androidx.ui.layout.Column
import androidx.ui.layout.ColumnScope.weight
import androidx.ui.layout.padding
import androidx.ui.material.*
import androidx.ui.res.imageResource
import androidx.ui.tooling.preview.Preview
import androidx.ui.unit.dp
import com.hangrycoder.neumorphiccalculator.ui.NeumorphicCalculatorTheme
import com.hangrycoder.neumorphiccalculator.ui.darkBlue
import com.hangrycoder.neumorphiccalculator.ui.darkGrey
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
        content()
    }
}

@Composable
fun MyScreenContent() {
    Column(modifier = Modifier.weight(1f)) {
        Toolbar()
        DigitalInputContainer(resId = R.drawable.ic_digital_input_container)
    }
}

@Composable
fun Toolbar() {
    TopAppBar(title = {
        Text(text = "Calculator",
                color = lightGrey,
                style = MaterialTheme.typography.h4)
    }, backgroundColor = darkGrey)
}

@Composable
fun DigitalInputContainer(resId: Int) {
    val image = imageResource(resId)
    Image(image)
}

@Composable
fun Greeting(name: String) {
    Text(text = "Hello $name!",
            modifier = Modifier.padding(24.dp),
            style = MaterialTheme.typography.body1)
}

@Preview(showBackground = true)
@Composable
fun DefaultPreview() {
    MyApp {
        MyScreenContent()
    }
}