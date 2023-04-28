package com.example.umte_projekt.ui.basic.form

import android.content.Intent
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material.AlertDialog
import androidx.compose.material.Button
import androidx.compose.material.Icon
import androidx.compose.material.Text
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Lock
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.unit.dp
import com.example.umte_projekt.ui.async.AnotherUserScreenModel
import org.koin.androidx.compose.getViewModel


@Composable
fun AnotherUserScreen(
    viewModel: AnotherUserScreenModel = getViewModel()
) {
    val context = LocalContext.current
    val userRolePom = viewModel.loginUser.collectAsState()
    val openDialogLogout= remember { mutableStateOf(false)  }
   if(userRolePom.value==0){
       context.startActivity(Intent(context, FormLoginActivity::class.java))
       openDialogLogout.value = false
   }
   else{
        if((userRolePom.value==3)||(userRolePom.value==1))
           openDialogLogout.value = false
       else{
           openDialogLogout.value = true
       }
   }
    if (openDialogLogout.value) {
        AlertDialog(
            onDismissRequest = {
            },
            title = {
                Text(text = "Chyba odhlášení")
            },
            text = {
                Text("Uživatel ne odhlášen ")
            },
            confirmButton = {
                Button(

                    onClick = {

                        openDialogLogout.value = ! openDialogLogout.value


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
        Text(text = "Pro uživatele v této roli není aplikace iplementována")

        Button(onClick= {  btnLogoutAnodher(viewModel)})
        {
            Icon(Icons.Default.Lock, contentDescription = "")
            Text(text = "Odhlásit")
        }
    }
}


fun btnLogoutAnodher(viewModel: AnotherUserScreenModel) {
 viewModel.fetchLogoutUser()
}
