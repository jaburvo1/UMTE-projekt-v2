package com.example.umte_projekt.ui.basic.form


import android.content.Context
import androidx.compose.foundation.layout.*
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.ui.Alignment
import cz.uhk.umte.R
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext

import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.text.input.VisualTransformation
import androidx.compose.ui.unit.dp
import com.example.umte_projekt.ui.async.FormLoginScreenModel

import android.content.Intent
import com.example.umte_projekt.data.remote.service.LoginServiceAPI
import com.example.umte_projekt.data.repository.LoginRepoziotry


@Composable
 fun FormLoginScreen () {
    val context = LocalContext.current
    val inputEmail = remember { mutableStateOf("") }
    val inputPassword = remember { mutableStateOf("") }
    var passwordVisibility: Boolean by remember { mutableStateOf(false) }
    //val user: FormLoginScreenModel
    val roleUser: Int
    Row(
        modifier = Modifier
            .padding(16.dp),

        verticalAlignment = Alignment.CenterVertically
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


        Button(onClick = btnLogin(inputEmail.value,inputPassword.value)) {
            Text(text = context.getString(R.string.form_screen_btnClearFromLogin))
        }
    }




}

fun btnLogin(email: String, password: String, context: Context ): () -> Unit {
///????????

    val loginServiceAPI:LoginServiceAPI
    val loginRepoziotry: LoginRepoziotry = LoginRepoziotry(loginServiceAPI)
    val user: FormLoginScreenModel = FormLoginScreenModel(loginServiceAPI,loginRepoziotry)
    val roleUser = user.fetchLoginUser(email, password).toString().toInt()
    if(roleUser == 1){

    }
    else{
        if(roleUser == 2){
            context.startActivity(Intent(context, FormDepotActivity::class.java))


        }
        else{
            if(roleUser == 3){

            }
            else{
                //zobrazit alert dialog
            }
        }
    }
}












