package com.example.umte_projekt.ui

import android.content.Context
import android.content.Intent
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.material.Button
import androidx.compose.material.Icon
import androidx.compose.material.Text
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import com.example.umte_projekt.data.repository.LoginRepoziotry
import com.example.umte_projekt.ui.async.DepotHomeScreenModel
import com.example.umte_projekt.ui.async.FormLoginScreenModel
import com.example.umte_projekt.ui.basic.form.FormDepotActivity
import com.example.umte_projekt.ui.basic.form.FormLoginActivity
import com.example.umte_projekt.ui.basic.lazylist.PartLazyListActivity
import org.koin.androidx.compose.getViewModel
import com.example.umte_projekt.ui.btnLogout as btnLogout


@Composable
fun DepotHomeScreen (
    viewModel: DepotHomeScreenModel = getViewModel(),
    parentController: NavHostController
) {

    val context = LocalContext.current

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp)
            .background(Color.Cyan)
            .padding(16.dp)
            .background(Color.Red),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text(text = "UMTE-projekt")


        Button(onClick = {
            context.startActivity(Intent(context, FormDepotActivity::class.java))
        }) {
            Icon(Icons.Default.Home, contentDescription = "")
            Text(text = "Formulář")
        }

        Button(onClick = {
            context.startActivity(Intent(context, PartLazyListActivity::class.java))
        }) {
            Icon(Icons.Default.List, contentDescription = "")
            Text(text = "Seznam dílů")
        }

        Button(onClick= { btnLogout(context, viewModel) })
         {
            Icon(Icons.Default.Lock, contentDescription = "")
            Text(text = "Odhlásit")
        }
    }
    }
 fun btnLogout(context: Context, viewModel: DepotHomeScreenModel) {

     val roleUser = viewModel.fetchLogOutUser().toString().toInt()
     if(roleUser==0){
         context.startActivity(Intent(context, FormLoginActivity::class.java))
     }
     else{
         //alert chyba odhlášení
     }
 }
