package com.example.umte_projekt.ui.basic.form

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent

class FromLoginActivity :  ComponentActivity(){
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            FormLoginScreen()

        }

    }
}