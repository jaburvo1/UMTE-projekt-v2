package com.example.umte_projekt.ui.basic.form


import android.content.Context
import android.content.Intent
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material.Button
import androidx.compose.material.IconButton
import androidx.compose.material.Text
import androidx.compose.material.TextField
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.text.input.VisualTransformation
import androidx.compose.ui.unit.dp
import com.example.umte_projekt.ui.async.FormLoginScreenModel
import cz.uhk.umte.R
import org.koin.androidx.compose.getViewModel


@Composable
 fun FormLoginScreen (
    viewModel: FormLoginScreenModel = getViewModel()
 ) {
    val context = LocalContext.current
    val inputEmail = remember { mutableStateOf("") }
    val inputPassword = remember { mutableStateOf("") }
    var passwordVisibility: Boolean by remember { mutableStateOf(false) }
    val userRole = viewModel.loginUser.collectAsState()
    if(userRole.value == 1){
        context.startActivity(Intent(context, FormDepotActivity::class.java))

    }
    Column(
        modifier = Modifier
            .padding(16.dp)
            .fillMaxSize(),
        horizontalAlignment = Alignment.CenterHorizontally

    ) {
        TextField(
            modifier = Modifier.fillMaxWidth(),
            value = inputEmail.value,
            onValueChange = { text ->
                inputEmail.value = text

            },
            label = {
                Text(text = context.getString(R.string.form_screen_userName))
            }
        )


        TextField(
            value = inputPassword.value,
            visualTransformation = if (passwordVisibility) VisualTransformation.None else PasswordVisualTransformation(),
            leadingIcon = {
                IconButton(onClick = {
                    passwordVisibility = !passwordVisibility
                }) {
                    //Icon(imageVector = vectorResource(id = R.drawable.ic_icons_watch_count_24))
                }
            },
            onValueChange = { text ->
                inputPassword.value = text

            }
        )


        Button(onClick = { btnLogin(inputEmail.value,inputPassword.value, context, viewModel) }) {
            Text(text = context.getString(R.string.form_screen_btnLogin))
        }

        Button(onClick = {
            inputEmail.value=""
            inputPassword.value=""
        }) {
            Text(text = context.getString(R.string.form_screen_btnClear))
        }
    }




}

fun btnLogin(email: String, password: String, context: Context,  viewModel:FormLoginScreenModel) {

   viewModel.fetchLoginUser(email, password)

    }













