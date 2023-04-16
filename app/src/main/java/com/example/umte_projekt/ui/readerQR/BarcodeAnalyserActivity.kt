package com.example.umte_projekt.ui.readerQR

import android.annotation.SuppressLint
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent

class BarcodeAnalyserActivity  : ComponentActivity() {
    @SuppressLint("UnsafeOptInUsageError")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
                        BarcodeAnalyserScreen()

                    }
                }

        }
