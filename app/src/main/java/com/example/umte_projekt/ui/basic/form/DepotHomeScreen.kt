package com.example.umte_projekt.ui.basic.form

import android.content.Intent
import androidx.compose.foundation.layout.Column
import androidx.compose.material.AlertDialog
import androidx.compose.material.Button
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.platform.LocalContext
import com.example.umte_projekt.ui.async.DepotHomeScreenModel
import com.example.umte_projekt.ui.basic.lazylist.PartLazyListActivity
import cz.uhk.umte.R
import org.koin.androidx.compose.getViewModel


@Composable
fun DepotHomeScreen(
    viewModel: DepotHomeScreenModel = getViewModel()
) {
    val context = LocalContext.current
    val userRolePom = viewModel.loginUser.collectAsState()
    val openDialogLogout= remember { mutableStateOf(false)  }
    if(userRolePom.value==0){
        context.startActivity(Intent(context, FormLoginActivity::class.java))
        openDialogLogout.value = false
    }
    else{
        if(userRolePom.value==2)
        openDialogLogout.value = false
        else{
            openDialogLogout.value = true
        }
    }

    if (openDialogLogout.value) {
        AlertDialog(
            onDismissRequest = {
                // Dismiss the dialog when the user clicks outside the dialog or on the back
                // button. If you want to disable that functionality, simply use an empty
                // onCloseRequest.


                //openDialogLogout.value = false
                //val properties = DialogProperties()
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
    Column (

            ){
        Button(onClick = {context.startActivity(Intent(context, FormDepotActivity::class.java))}) {
            Text(text = context.getString(R.string.home_depot_screen_btnFromDepot))
        }
        Button(onClick = {context.startActivity(Intent(context, PartLazyListActivity::class.java))}) {
            Text(text = context.getString(R.string.home_depot_screen_btnListParts))
        }

        Button(onClick = { btnLogout(viewModel) }) {
            Text(text = context.getString(R.string.btnLogOut))
        }

        }

    }

fun btnLogout(viewModel: DepotHomeScreenModel) {
    viewModel.fetchLogOutUser()
}









