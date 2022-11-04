package com.example.randomcolor

import androidx.compose.runtime.MutableState
import androidx.compose.ui.graphics.Color
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import java.util.*
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.collectLatest
import kotlinx.coroutines.launch

class MainViewModel : ViewModel() {
    private val _color = MutableStateFlow(Color.White)
    val color: StateFlow<Color> get() = _color

//     var color = (Color.White)
//    val randomBackground = randomColor()
//    val color: StateFlow<Color> get() = _color
//    val color = _color.asStateFlow().value
//    val color = viewModelScope.launch {  _color.collectLatest { it -> println("it") }}

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

    fun reset() {
        _color.value = Color.White
    }
}
