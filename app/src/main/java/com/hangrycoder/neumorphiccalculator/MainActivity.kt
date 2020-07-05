package com.hangrycoder.neumorphiccalculator

import android.graphics.drawable.Drawable
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.compose.Composable
import androidx.ui.core.ContentScale
import androidx.ui.core.Modifier
import androidx.ui.core.clip
import androidx.ui.core.setContent
import androidx.ui.foundation.Image
import androidx.ui.foundation.Text
import androidx.ui.foundation.shape.corner.RoundedCornerShape
import androidx.ui.layout.*
import androidx.ui.layout.ColumnScope.weight
import androidx.ui.material.*
import androidx.ui.res.imageResource
import androidx.ui.res.vectorResource
import androidx.ui.tooling.preview.Preview
import androidx.ui.unit.dp
import com.hangrycoder.neumorphiccalculator.ui.NeumorphicCalculatorTheme
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
    }
}

@Composable
fun Toolbar() {
    TopAppBar(title = {
        Text(text = "Calculator",
                color = lightGrey,
                style = MaterialTheme.typography.h4)
    }, backgroundColor = darkGrey,
            elevation = 0.dp)
}

@Composable
fun DigitalInputContainer(resId: Int) {
    val imageModifier = Modifier
            .padding(16.dp)
            .preferredHeight(150.dp)
            .fillMaxWidth()
            .clip(shape = RoundedCornerShape(8.dp))

    val image = vectorResource(resId)
    Image(image,
            modifier = imageModifier,
            contentScale = ContentScale.Crop)
}

@Preview(showBackground = true)
@Composable
fun DefaultPreview() {
    MyApp {
        MyScreenContent()
    }
}