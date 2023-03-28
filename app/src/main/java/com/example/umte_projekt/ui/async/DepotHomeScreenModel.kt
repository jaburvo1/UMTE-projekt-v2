package com.example.umte_projekt.ui.async

import android.view.Choreographer.VsyncCallback
import com.example.umte_projekt.base.BaseViewModel
import com.example.umte_projekt.data.model.response.LoginUser
import com.example.umte_projekt.data.remote.service.LoginServiceAPI
import com.example.umte_projekt.data.repository.LoginRepoziotry
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow

class DepotHomeScreenModel(
    // private val email: String,
    //private val password: String,
    private val spaceLoginServiceAPI: LoginServiceAPI,
    private val loginRepoziotry: LoginRepoziotry
): BaseViewModel()
{

    private val _loginUser = MutableStateFlow<Int>(0)
    val loginUser = _loginUser.asStateFlow()

    /* init {
         fetchLoginUser(email, password )
     }*/

    fun fetchLogOutUser() = launch(
        block = {

            loginRepoziotry.logoutRepozitory().also{
                _loginUser.emit(it)
            }
        }
    )


}