package com.example.umte_projekt.ui.basic.form


import android.content.Context
import android.content.Intent
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.text.input.VisualTransformation
import androidx.compose.ui.unit.dp
import androidx.compose.ui.window.DialogProperties
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
    val userRolePom = viewModel.loginUser.collectAsState()

    var openDialog1 = remember { mutableStateOf(false)  }
    var openDialog2 = remember { mutableStateOf(false)  }

    openDialog1.value = false
    openDialog2.value = false

    if(userRolePom.value == 2){

        //context.startActivity(Intent(context, FormDDepotHomeAcitvityepotActivity::class.java))
        context.startActivity(Intent(context, DepotHomeAcitvity::class.java))

    }
    else{
        if((userRolePom.value == 1)|| (userRolePom.value == 3)){
            context.startActivity(Intent(context, AnotherUserActivity::class.java))
        }
        else {
            if(userRolePom.value == -1) {
                openDialog1.value = true
            }
            else{
                if(userRolePom.value == -2) {
                    openDialog2.value = true
                }
                else{
                    openDialog1.value = false
                    openDialog2.value = false



                }


            }
        }
        }

    if (openDialog1.value == true) {
        AlertDialog(
            onDismissRequest = {
                // Dismiss the dialog when the user clicks outside the dialog or on the back
                // button. If you want to disable that functionality, simply use an empty
                // onCloseRequest.


               openDialog1.value = false
               val properties = DialogProperties()
            },
            title = {
                Text(text = "Chyba přihlášení")
            },
            text = {
                Text("Špatně zadaný email, nebo heslo, nebo neexistujcí uživatel ")
            },
            confirmButton = {
                Button(

                    onClick = {
                        viewModel.setRole(0);
                        //openDialog1.value = !openDialog1.value


                    }) {
                    Text("ok")
                }
            }
        )
    }
    if (openDialog2.value==true) {
        AlertDialog(
            onDismissRequest = {
                // Dismiss the dialog when the user clicks outside the dialog or on the back
                // button. If you want to disable that functionality, simply use an empty
                // onCloseRequest.


                openDialog2.value = false
                val properties = DialogProperties()
            },
            title = {
                Text(text = "Chyba přihlášení")
            },
            text = {
                Text("Nevyplněné příhlašovací údaje email a heslo.")
            },
            confirmButton = {
                Button(

                    onClick = {
                        //openDialog2.value = !openDialog2.value
                        viewModel.setRole(0);



                    }) {
                    Text("ok")
                }
            }
        )
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













