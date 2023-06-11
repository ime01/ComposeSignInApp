package com.example.composesigninapp.screens

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.composesigninapp.R
import com.example.composesigninapp.components.HeadingTextComponent
import com.example.composesigninapp.mainapp.JCAuthApp
import com.example.composesigninapp.navigation.JCAuthAppRouter
import com.example.composesigninapp.navigation.Screen
import com.example.composesigninapp.navigation.SystemBackButtonHandler
import com.example.composesigninapp.ui.theme.ComposeSignInAppTheme
import java.io.StringReader


@Composable
fun TermsAndConditionScreen(){

    Surface(modifier = Modifier
        .fillMaxSize()
        .background(color = Color.White)
        .padding(16.dp)) {

        HeadingTextComponent(value = stringResource(id = R.string.terms_and_conditions_header))

        SystemBackButtonHandler {
            JCAuthAppRouter.navigate(Screen.SignupScreen)
        }

    }

}

@Preview
@Composable
fun GreetingPreview() {
    TermsAndConditionScreen()
}