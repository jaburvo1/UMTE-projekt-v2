package com.example.umte_projekt.ui

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
import com.example.umte_projekt.ui.basic.form.FormDepotActivity
import com.example.umte_projekt.ui.basic.lazylist.PartLazyListActivity
import com.example.umte_projekt.ui.btnLogout as btnLogout


suspend fun btnLogout() {
    val user:LoginRepoziotry = LoginRepoziotry(null)
    user.logoutRepozitory()
}

@Composable
fun DepotHomeScreen (
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

        Button(onClick= { btnLogout() })
         {
            Icon(Icons.Default.Lock, contentDescription = "")
            Text(text = "Odhlásit")
        }
    }
    }

