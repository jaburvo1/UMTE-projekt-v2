package com.example.umte_projekt.ui.basic.lazylist

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent

class PartLazyListActivity :ComponentActivity () {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContent {
            PartLazyListScreen()



        }
    }

}