package com.example.umte_projekt.ui.async

import com.example.umte_projekt.base.BaseViewModel
import com.example.umte_projekt.data.repository.LoginRepoziotry
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow

class DepotHomeScreenModel(
    private val loginRepoziotry: LoginRepoziotry
): BaseViewModel()
{

    private val _loginUser = MutableStateFlow<Int>(2)
    val loginUser = _loginUser.asStateFlow()

    fun fetchLogOutUser() = launch(
        block = {

            loginRepoziotry.logoutRepozitory().also{
                _loginUser.emit(it)
            }
        }
    )


}