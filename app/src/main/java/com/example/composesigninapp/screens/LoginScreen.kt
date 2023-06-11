package com.example.composesigninapp.screens

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.composesigninapp.R
import com.example.composesigninapp.components.ButtonComponent
import com.example.composesigninapp.components.ClickableLoginComponent
import com.example.composesigninapp.components.DividerTextComponent
import com.example.composesigninapp.components.HeadingTextComponent
import com.example.composesigninapp.components.NormalTextComponent
import com.example.composesigninapp.components.PasswordTextFieldComponent
import com.example.composesigninapp.components.UnderLinedTextComponent
import com.example.composesigninapp.components.UserTextFieldComponent
import com.example.composesigninapp.navigation.JCAuthAppRouter
import com.example.composesigninapp.navigation.Screen
import com.example.composesigninapp.navigation.SystemBackButtonHandler


@Composable
fun LoginScreen(){
    Surface(
        color = Color.White,
        modifier = Modifier
            .fillMaxSize()
            .background(Color.White)
            .padding(28.dp)) {



        Column {


            NormalTextComponent(value = stringResource(R.string.login))

            HeadingTextComponent(value = stringResource(R.string.welcome_back))

            Spacer(modifier = Modifier.height(40.dp))

            UserTextFieldComponent(
                labelValue = stringResource(id = R.string.email), painterResource(
                    id = R.drawable.message
                )
            )

            Spacer(modifier = Modifier.height(20.dp))

            PasswordTextFieldComponent(
                labelValue = stringResource(id = R.string.password), painterResource(
                    id = R.drawable.lock
                )
            )

            Spacer(modifier = Modifier.height(40.dp))
            UnderLinedTextComponent(value = stringResource(id = R.string.forgot_password))

            Spacer(modifier = Modifier.height(20.dp))
            ButtonComponent(value = stringResource(id = R.string.login))

            Spacer(modifier = Modifier.height(20.dp))
            DividerTextComponent()

            ClickableLoginComponent(tryingToLogin = false, onTextSelected = {
                JCAuthAppRouter.navigate(Screen.SignupScreen)
            })





        }

        SystemBackButtonHandler {
            JCAuthAppRouter.navigate(Screen.SignupScreen)
        }
    }


}

@Preview
@Composable
fun LoginScreenPreview(){

    LoginScreen()
}