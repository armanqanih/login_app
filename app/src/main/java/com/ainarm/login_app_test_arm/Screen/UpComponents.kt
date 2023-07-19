package com.ainarm.login_app_test_arm.Screen

import android.util.Log
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.ClickableText
import androidx.compose.foundation.text.KeyboardActions
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Visibility
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.platform.LocalFocusManager
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.SpanStyle
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.buildAnnotatedString
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.text.input.VisualTransformation
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.style.TextDecoration
import androidx.compose.ui.text.withStyle
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.ainarm.login_app_test_arm.ui.theme.GrayColor
import com.ainarm.login_app_test_arm.ui.theme.Primary
import com.ainarm.login_app_test_arm.ui.theme.Secondary
import com.ainarm.login_app_test_arm.ui.theme.TextColor
import java.sql.RowId


@Composable
fun NormalTextComponent(value:String) {
    Text(
        text = value,
        modifier = Modifier
            .fillMaxWidth()
            ,
        style = TextStyle(
            fontSize = 18.sp,
            fontWeight = FontWeight.Normal
        ), color = Color.Gray,
        textAlign = TextAlign.Center
    )
}

@Composable
fun CreateText(value:String) {
    Text(
        text = value,
        modifier = Modifier
            .fillMaxWidth(),
        style = TextStyle(
            fontSize = 30.sp,
            fontWeight = FontWeight.Bold
        ), color = Color.Black,
        textAlign = TextAlign.Center
    )
}


@Composable
fun MyTextFieldComponent(
    labelValue: String, painterResource: Painter,
    onTextChanged: (String) -> Unit,
    errorStatus: Boolean = false
) {

    val textValue = remember {
        mutableStateOf("")
    }
    val localFocusManager = LocalFocusManager.current

    OutlinedTextField(
        modifier = Modifier
            .fillMaxWidth()
        ,
        label = { Text(text = labelValue) },
        colors = TextFieldDefaults.outlinedTextFieldColors(
            focusedBorderColor = Color.Transparent,
            focusedLabelColor = Color.Transparent,
            cursorColor = Color.Transparent,
            backgroundColor = Color.Transparent
        ),
        keyboardOptions = KeyboardOptions(imeAction = ImeAction.Next),
        singleLine = true,
        maxLines = 1,
        value = textValue.value,
        onValueChange = {
            textValue.value = it
            onTextChanged(it)
        },
        leadingIcon = {
            Icon(painter = painterResource, contentDescription = "")
        },
        isError = !errorStatus
    )
}

@Composable
fun PasswordTextFieldComponent(
    labelValue: String, painterResource: Painter,
    onTextSelected: (String) -> Unit,
    errorStatus: Boolean = false
) {

    val localFocusManager = LocalFocusManager.current
    val password = remember {
        mutableStateOf("")
    }

    val passwordVisible = remember {
        mutableStateOf(false)
    }

    OutlinedTextField(
        modifier = Modifier
            .fillMaxWidth()
        ,
        label = { Text(text = labelValue) },
        colors = TextFieldDefaults.outlinedTextFieldColors(
            focusedBorderColor = Color.Transparent,
            focusedLabelColor = Color.Transparent,
            cursorColor = Color.Transparent,
            backgroundColor = Color.Transparent
        ),
        keyboardOptions = KeyboardOptions(
            keyboardType = KeyboardType.Password,
            imeAction = ImeAction.Done
        ),
        singleLine = true,
        keyboardActions = KeyboardActions {
            localFocusManager.clearFocus()
        },
        maxLines = 1,
        value = password.value,
        onValueChange = {
            password.value = it
            onTextSelected(it)
        },
        leadingIcon = {
            Icon(painter = painterResource, contentDescription = "")
        },
        trailingIcon = {

            val iconImage = if (passwordVisible.value) {
                Icons.Filled.Visibility
            } else {
                Icons.Filled.Visibility
            }

            val description = if (passwordVisible.value) {
                "hide password"
            } else {
                 "Show password"
            }

            IconButton(onClick = { passwordVisible.value = !passwordVisible.value }) {
                Icon(imageVector = iconImage, contentDescription = description)
            }

        },
        visualTransformation = if (passwordVisible.value) VisualTransformation.None else PasswordVisualTransformation(),
        isError = !errorStatus
    )
}


@Composable
fun ChickBoxComponents(value:String,onTextSelected: (String) -> Unit){
    Row(modifier = Modifier
        .fillMaxWidth()
        .height(56.dp), verticalAlignment = Alignment.CenterVertically
    ) {
        val chickState = remember {
            mutableStateOf(false)
        }

        Checkbox(checked = chickState.value,
            onCheckedChange ={
                chickState.value != chickState.value
            })
        ClicapleTextComponent(value = value, onTextSelected)
    }
}
@Composable
fun ClicapleTextComponent(value: String,onTextSelected: (String) -> Unit){
    val initialText = "By continuing you accept our "
    val privacePoliceText = " Privace Police "
    val and = " and "
    val termsandcondistionText = " terms of use "

    val annotationString = buildAnnotatedString {
        append(initialText)
        withStyle(style = SpanStyle(color = Color.Black, fontWeight = FontWeight.Bold)){
            pushStringAnnotation(tag = privacePoliceText,
                annotation = privacePoliceText)
            append(privacePoliceText)
        }
        append(and)

        withStyle(style = SpanStyle(color = Color.Black, fontWeight = FontWeight.Bold)){
            pushStringAnnotation(tag = termsandcondistionText,
                annotation = termsandcondistionText)
            append(termsandcondistionText )
        }

    }
    ClickableText(text = annotationString, onClick = { offset ->

        annotationString.getStringAnnotations(offset, offset)
            .firstOrNull()?.also { span ->
                Log.d("ClickableTextComponent", "{${span.item}}")

                if ((span.item == termsandcondistionText) || (span.item == privacePoliceText)) {
                    onTextSelected(span.item)
                }
            }

    })
}

@Composable
fun ButtonComponent(value: String){
    Button(onClick = { /*TODO*/ },
    modifier = Modifier
        .fillMaxWidth()
        .height(48.dp)
       , contentPadding = PaddingValues()
       , colors = ButtonDefaults.buttonColors(Color.Transparent)
    , shape = RoundedCornerShape(50.dp)
        ) {
          Box(
              modifier = Modifier
                  .fillMaxWidth()
                  .height(48.dp)
                  .background(
                      brush = Brush.horizontalGradient(listOf(Secondary, Primary)),
                      shape = RoundedCornerShape(50.dp)
                  ),
              contentAlignment = Alignment.Center
          ) {
            Text(text = value,
            fontWeight = FontWeight.Bold,
                fontSize = 18.sp,
                color = Color.White
                )
          }
    }
}

@Composable
fun DividerTextComponents(){
    Row(modifier = Modifier.fillMaxWidth()
    , verticalAlignment = Alignment.CenterVertically
    ){
        Divider(
            modifier = Modifier
                .fillMaxWidth()
                .weight(1f),
            color = GrayColor,
            thickness = 1.dp
        )

        Text(text = " or ", fontSize = 14.sp, color = TextColor)

        Divider(
            modifier = Modifier
                .fillMaxWidth()
                .weight(1f),
            color = GrayColor,
            thickness = 1.dp
        )
    }
}

@Composable
fun ClicapleLoginTextComponent(trytologin:Boolean= true,onTextSelected: (String) -> Unit){
    val initialText =if (trytologin) " Already have an account? " else "Dont have an account?"
    val LoginText = if (trytologin)" Login " else "Register"

    val annotationString = buildAnnotatedString {
        append(initialText)
        withStyle(style = SpanStyle(color = Color.Black, fontWeight = FontWeight.Bold)){
            pushStringAnnotation(tag = LoginText,
                annotation = LoginText)
            append(LoginText)
        }


    }
    ClickableText(
        modifier = Modifier
            .fillMaxWidth(),
        style = TextStyle(
            fontSize = 14.sp,
            fontWeight = FontWeight.Normal,
            textAlign = TextAlign.Center
        ),text = annotationString, onClick = { offset ->

        annotationString.getStringAnnotations(offset, offset)
            .firstOrNull()?.also { span ->
                Log.d("ClickableTextComponent", "{${span.item}}")

                if ((span.item == LoginText)){
                    onTextSelected(span.item)
                }
            }

    })
}

@Composable
fun UnderLineTextComponent(value:String) {
    Text(
        text = value,
        modifier = Modifier
            .fillMaxWidth()
        ,
        style = TextStyle(
            fontSize = 18.sp,
            fontWeight = FontWeight.Normal
        ), color = Color.Gray,
        textAlign = TextAlign.Center,
        textDecoration = TextDecoration.Underline
    )
}

