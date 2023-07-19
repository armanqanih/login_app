package com.ainarm.login_app_test_arm.Screen

import androidx.compose.foundation.layout.*
import androidx.compose.material.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.ainarm.login_app_test_arm.R
import com.ainarm.login_app_test_arm.screenback.Pagechange
import com.ainarm.login_app_test_arm.screenback.PostOfficeAppRouter
import com.ainarm.login_app_test_arm.screenback.Screen


@Composable
fun LoginScreen(){

    Surface(
        modifier = Modifier
            .fillMaxSize()
            .padding(28.dp)
    ) {
        Column(modifier = Modifier.fillMaxSize()) {
            NormalTextComponent(value = "hey there,")
            CreateText(value = "Wellcome Back")
            Spacer(modifier = Modifier.height(20.dp))

            MyTextFieldComponent(
                labelValue = "Emil",
                painterResource = painterResource(id = R.drawable.message) ,
                onTextChanged = {

                })
            PasswordTextFieldComponent(
                labelValue =" Password " ,
                painterResource = painterResource(id = R.drawable.ic_lock)
                , onTextSelected ={} )

            Spacer(modifier = Modifier.height(10.dp))

            UnderLineTextComponent(value = "forget you password?")

            Spacer(modifier = Modifier.height(100.dp))

            ButtonComponent(value = "Login")

            Spacer(modifier = Modifier.height(20.dp))
            DividerTextComponents()
            Spacer(modifier = Modifier.height(20.dp))

            ClicapleLoginTextComponent(trytologin = false,onTextSelected = {
                PostOfficeAppRouter.navigateTo(Screen.SignUpScreen)
            })

            Pagechange {
                PostOfficeAppRouter.navigateTo(Screen.SignUpScreen)
            }

        }
    }

}

@Preview
@Composable
fun loginPriview(){
    LoginScreen()
}