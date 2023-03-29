package com.example.umte_projekt.data.enum

import androidx.annotation.StringRes
import cz.uhk.umte.R

enum class TypeOperation(@StringRes val nameRes: Int) {
    AddItem(R.string.form_screen_select_operationType_addItem),
    AddItemPiece(R.string.form_screen_select_operationType_addItemPiece),
    RemoveItemPiece(R.string.form_screen_select__operationType_removeItemPiece)
}

