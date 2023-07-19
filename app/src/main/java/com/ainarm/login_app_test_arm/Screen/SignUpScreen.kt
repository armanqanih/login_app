package com.ainarm.login_app_test_arm.Screen

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.ainarm.login_app_test_arm.R
import com.ainarm.login_app_test_arm.screenback.PostOfficeAppRouter
import com.ainarm.login_app_test_arm.screenback.Screen

@Composable
fun SignUpScreen() {
    Box(
        modifier = Modifier.fillMaxSize(),
        contentAlignment = Alignment.Center
    ) {

        Surface(
            modifier = Modifier
                .fillMaxSize()
                .padding(28.dp)
        ) {
            Column(modifier = Modifier.fillMaxSize()) {
             NormalTextComponent(value = "Hey there")
                Spacer(modifier = Modifier.height(10.dp))
             CreateText(value = "Create New Account")
                Spacer(modifier = Modifier.height(30.dp))
                MyTextFieldComponent(
                    labelValue = "first Name",
                    painterResource(id =R.drawable.profile),
                    onTextChanged = {
                    }
                    )

                MyTextFieldComponent(
                    labelValue = "Last Name",
                    painterResource(id =R.drawable.profile),
                    onTextChanged = {
                    }
                    )

                MyTextFieldComponent(
                    labelValue = "Emile",
                    painterResource(id =R.drawable.message),
                    onTextChanged = {
                    }
                    )
                PasswordTextFieldComponent(
                    labelValue = "Password",
                    painterResource = painterResource(id = R.drawable.ic_lock),
                    onTextSelected = {

                    })

                ChickBoxComponents(value = "terms and conditions",
                    onTextSelected ={
                         PostOfficeAppRouter.navigateTo(Screen.TermsAndConditionsScreen)
                    } )

                Spacer(modifier = Modifier.height(50.dp))
                ButtonComponent(value = "Register")

                Spacer(modifier = Modifier.height(20.dp))
                DividerTextComponents()
                Spacer(modifier = Modifier.height(20.dp))
                ClicapleLoginTextComponent(trytologin = true,onTextSelected = {
                    PostOfficeAppRouter.navigateTo(Screen.LoginScreen)
                })

            }
        }
    }
}



@Preview
@Composable
fun sighnupPrivew(){
    SignUpScreen()
}