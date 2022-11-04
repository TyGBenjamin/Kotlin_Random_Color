package com.example.randomcolor

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.viewModels
import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.combinedClickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.foundation.layout.wrapContentWidth
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Button
import androidx.compose.material.ButtonDefaults
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.randomcolor.ui.theme.RandomColorTheme
import java.util.*


class MainActivity : ComponentActivity() {
    private val mainViewModel by viewModels<MainViewModel>()

    override fun onCreate(savedInstanceState: Bundle?) {

        super.onCreate(savedInstanceState)
        setContent {
            RandomColorTheme {
                val color : Color by mainViewModel.color.collectAsState()
                val randomColor: Color = mainViewModel.randomColor()
                var value = mainViewModel.color.collectAsState().value
                var lastValue = value.let { it -> it }

                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = value
                ) {
                RandomButton(generateColor = mainViewModel::randomColor)
                }
            }
        }
    }
}

@OptIn(ExperimentalFoundationApi::class)
@Composable
fun RandomButton(generateColor: ()-> Color){

        Box(
            modifier = Modifier
                .wrapContentWidth()
                .wrapContentHeight()
                .combinedClickable(
                    onClick = {

                        println("button has been clicked")
                    },
                    onLongClick = { println("Long click done") }

                )
        ) {
            Column(
                modifier = Modifier.padding(start = 30.dp),
                verticalArrangement = Arrangement.Center,
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                Button(
                    onClick = {generateColor()
                        println("button has been clicked")
                    },
                    shape = RoundedCornerShape(Constants.roundCornerInt),
                    colors = ButtonDefaults.buttonColors(
                        backgroundColor = Color.Black,
                        contentColor = Color.White
                    )
                ) {
                    Text(text = "Click")
                }

            }
        }
    }

@Composable
fun PlaceHolder(mainViewModel: MainViewModel){
    Surface(
        modifier = Modifier.fillMaxSize(),
        color = mainViewModel.randomColor()
    ) {
        RandomButton(generateColor = mainViewModel::randomColor)
    }
}


@Preview(showBackground = true)
@Composable
fun DefaultPreview() {
    RandomColorTheme {
    }
}

class MainClass{
    fun randomColor(): Color {
        val random = Random()
        return Color(255, random.nextInt(256), random.nextInt(256), random.nextInt(256))
    }

    fun reset(): Color {
       var color = Color.White
        return color
    }
}
