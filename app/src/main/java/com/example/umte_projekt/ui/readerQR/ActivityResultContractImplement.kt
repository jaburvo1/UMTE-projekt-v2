package com.example.umte_projekt.ui.readerQR

import android.app.Activity
import android.content.Context
import android.content.Intent
import androidx.activity.result.contract.ActivityResultContract

class ActivityResultContractImplement : ActivityResultContract<String, String?>() {

    override fun createIntent(context: Context, input: String): Intent {
        val intent = Intent(context, BarcodeAnalyserActivity::class.java)
        intent.putExtra(INPUT_DATA, input)
        return intent
    }

    override fun parseResult(resultCode: Int, intent: Intent?): String? {
        return when (resultCode) {
            Activity.RESULT_OK -> intent?.getStringExtra(DATA)
            else -> null
        }
    }

    companion object{
        val DATA = "data"
        val INPUT_DATA = "input_data"
    }

}
