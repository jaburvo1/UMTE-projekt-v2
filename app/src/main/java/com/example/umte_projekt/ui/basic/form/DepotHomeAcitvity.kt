package com.example.umte_projekt.ui.basic.form

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import com.example.umte_projekt.ui.DepotHomeScreen


class DepotHomeAcitvity : ComponentActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContent {
            DepotHomeScreen()
        }
    }

}


