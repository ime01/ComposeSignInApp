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
import androidx.compose.ui.unit.dp
import com.example.composesigninapp.R
import com.example.composesigninapp.components.HeadingTextComponent
import com.example.composesigninapp.components.NormalTextComponent
import com.example.composesigninapp.components.PasswordTextFieldComponent
import com.example.composesigninapp.components.UserTextFieldComponent

@Composable
fun SignUpScreen(){

    Surface(
        color = Color.White,
        modifier = Modifier
            .fillMaxSize()
            .background(Color.White)
            .padding(28.dp)) {


        Column (
            modifier = Modifier.fillMaxSize()){

            NormalTextComponent(value = stringResource(R.string.hey_there))

            HeadingTextComponent(value = stringResource(R.string.create_an_account))

            Spacer(modifier = Modifier.height(20.dp))

            UserTextFieldComponent(labelValue = stringResource(id = R.string.firstname), painterResource(
                id = R.drawable.profile
            ))

            Spacer(modifier = Modifier.height(8.dp))

            UserTextFieldComponent(labelValue = stringResource(id = R.string.lastname), painterResource(
                id = R.drawable.profile))

            Spacer(modifier = Modifier.height(8.dp))

            UserTextFieldComponent(labelValue = stringResource(id = R.string.email), painterResource(
                id = R.drawable.message))

            Spacer(modifier = Modifier.height(8.dp))

            PasswordTextFieldComponent(labelValue = stringResource(id = R.string.password), painterResource(
                id = R.drawable.ic_lock))



        }



    }


}