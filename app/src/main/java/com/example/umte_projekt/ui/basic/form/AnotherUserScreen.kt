package com.example.umte_projekt.ui.basic.form

import android.content.Context
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material.Button
import androidx.compose.material.Icon
import androidx.compose.material.Text
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Lock
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
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
    var userRole = userRolePom.value
    if(userRole <= 0){
        //context.startActivity(Intent(context, FormDepotActivity:class.java))
    }
    else{
///alelr
    }

    Column(
        modifier = Modifier
            .padding(16.dp)
            .fillMaxSize(),
        horizontalAlignment = Alignment.CenterHorizontally

    ) {
        Text(text = "Por uživatele v této roli není aplikace iplementována")

        Button(onClick= { btnLogoutAnodher(context, viewModel)})
        {
            Icon(Icons.Default.Lock, contentDescription = "")
            Text(text = "Odhlásit")
        }
    }
}

fun btnLogoutAnodher(context: Context, viewModel: AnotherUserScreenModel) {

    viewModel.fetchLogoutUser()

}