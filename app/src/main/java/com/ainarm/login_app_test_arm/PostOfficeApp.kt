package com.ainarm.login_app_test_arm

import androidx.compose.animation.Crossfade
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import com.ainarm.login_app_test_arm.Screen.LoginScreen
import com.ainarm.login_app_test_arm.Screen.SignUpScreen
import com.ainarm.login_app_test_arm.Screen.TermsAndConditionsScreen
import com.ainarm.login_app_test_arm.screenback.PostOfficeAppRouter
import com.ainarm.login_app_test_arm.screenback.Screen


@Composable
fun PostOffecApp(){
    Surface(
        modifier = Modifier.fillMaxSize(),
        color = Color.White
    ) {

        Crossfade(targetState = PostOfficeAppRouter.currentScreen) { currentState->
            when(currentState.value){
                Screen.HomeScreen -> TODO()
                Screen.LoginScreen -> {
                    LoginScreen()
                }
                Screen.SignUpScreen -> {
                    SignUpScreen()
                }
                Screen.TermsAndConditionsScreen -> {
                    TermsAndConditionsScreen()
                }
            }
        }

    }
}