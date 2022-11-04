package com.example.randomcolor

import androidx.activity.viewModels
import androidx.compose.ui.graphics.Color
import androidx.lifecycle.ViewModel
import org.junit.jupiter.api.Assertions
import org.junit.jupiter.api.DisplayName
import org.junit.jupiter.api.Test

class MainViewModelTest : ViewModel() {


    private val random = MainClass()

    @Test
    @DisplayName
        (" Test if random color gets returned as white color ")
    fun requirement1() {
        //Given
        val background = Color.White

        //When
        val color = random.reset()

        //Then
        Assertions.assertEquals( background, color)

    }
}
