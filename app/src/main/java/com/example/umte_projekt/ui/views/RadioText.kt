package com.example.umte_projekt.ui.views


import androidx.compose.foundation.layout.Row
import androidx.compose.material.RadioButton
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.MutableState
import androidx.compose.ui.Alignment

@Composable
fun RadioText(label: String, operatinoTypeSelection: MutableState<String>) {
    Row(
        verticalAlignment = Alignment.CenterVertically
    ) {
        RadioButton(selected = operatinoTypeSelection.value == label, onClick = { operatinoTypeSelection.value = label })
        Text(text = label)
    }
}
