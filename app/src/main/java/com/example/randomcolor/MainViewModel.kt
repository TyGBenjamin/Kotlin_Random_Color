package com.example.randomcolor

import androidx.compose.ui.graphics.Color
import androidx.lifecycle.ViewModel
import java.util.Random
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow

class MainViewModel : ViewModel() {
    private val _color = MutableStateFlow(Color.White)
    val color: StateFlow<Color> get() = _color



    fun randomColor(): Color {
        val random = Random()
        _color.value = Color(alpha = 255, red = random.nextInt(256), blue = random.nextInt(256), green = random.nextInt(256))
        println("randomcolor")
        return _color.value


    }
//    fun runRandomColor(){
//        randomColor()
//
//    }

    fun reset() :  Color {
        println("RESETING COLOR")
      _color.value = Color.White
        return _color.value
    }
}
