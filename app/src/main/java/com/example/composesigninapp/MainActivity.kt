package com.example.composesigninapp

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.animation.Crossfade
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.example.composesigninapp.mainapp.JCAuthApp
import com.example.composesigninapp.navigation.JCAuthAppRouter
import com.example.composesigninapp.navigation.Screen
import com.example.composesigninapp.screens.LoginScreen
import com.example.composesigninapp.screens.SignUpScreen
import com.example.composesigninapp.screens.TermsAndConditionScreen
import com.example.composesigninapp.ui.theme.ComposeSignInAppTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            ComposeSignInAppTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {


                    Crossfade(targetState = JCAuthAppRouter.currentScreen) { currentState->

                        when(currentState.value){

                            is Screen.SignupScreen->{
                                SignUpScreen()
                            }

                            is Screen.TermsAndConditionsScreen->{
                                TermsAndConditionScreen()
                            }

                            is Screen.LoginScreen->{
                                LoginScreen()
                            }

                        }
                    }

                }
            }
        }
    }
}



@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    ComposeSignInAppTheme {
        JCAuthApp()
    }
}