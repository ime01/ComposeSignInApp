package com.example.composesigninapp.mainapp

import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import com.example.composesigninapp.screens.SignUpScreen


@Composable
fun JCAuthApp(){

    Surface(modifier = Modifier.fillMaxSize(), color = Color.White) {
        SignUpScreen()

    }
}