package com.example.umte_projekt.ui.basic.dialog

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.AlertDialog
import androidx.compose.material.Button
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color


@Composable
fun AlertScreen (){
    val dialogShown = remember { mutableStateOf(false) }

    if (dialogShown.value) {
        AlertDialog(
            buttons = {
                Button(onClick = { dialogShown.value = false }) {
                    Text(text = "OK")
                }
            },
            title = {
                Text(text = "Dilog title")
            },
            text = {
                Text(text = "Dilog text")
            },
            onDismissRequest = {
                dialogShown.value = false
            }
        )
    }

    Column(
    horizontalAlignment = Alignment.CenterHorizontally,
    verticalArrangement = Arrangement.Center,
    modifier = Modifier
    .fillMaxSize()
    .background(Color.Cyan)
    ) {
        Button(onClick = { dialogShown.value = true }) {
            Text("Otevři dialog")
        }

    }

}
