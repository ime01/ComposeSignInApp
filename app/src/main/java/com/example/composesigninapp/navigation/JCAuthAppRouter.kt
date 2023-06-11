package com.example.composesigninapp.navigation

import androidx.compose.runtime.MutableState
import androidx.compose.runtime.mutableStateOf


sealed class Screen(){

    object SignupScreen : Screen()
    object TermsAndConditionsScreen : Screen()
    object LoginScreen : Screen()
}

object JCAuthAppRouter{

    val currentScreen: MutableState<Screen> = mutableStateOf(Screen.SignupScreen)

    fun navigate(destination:Screen){
        currentScreen.value = destination
    }


}