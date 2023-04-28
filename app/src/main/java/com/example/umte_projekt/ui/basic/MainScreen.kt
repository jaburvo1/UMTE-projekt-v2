package com.example.umte_projekt.ui.basic

import android.content.Intent
import androidx.compose.runtime.Composable
import androidx.compose.ui.platform.LocalContext
import com.example.umte_projekt.ui.basic.form.FormLoginActivity

@Composable
fun MainScreen(){
    val context = LocalContext.current
    context.startActivity(Intent(context, FormLoginActivity::class.java))
}