package com.example.umte_projekt.ui.async

import android.util.Log
import com.example.umte_projekt.base.BaseViewModel
import com.example.umte_projekt.data.repository.LoginRepoziotry
import kotlinx.coroutines.CancellationException
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow

class AnotherUserScreenModel(
    private val loginRepoziotry: LoginRepoziotry
): BaseViewModel()
  {
      private val _loginUser = MutableStateFlow<Int>(1)
      val loginUser = _loginUser.asStateFlow()

      fun fetchLogoutUser() = launch(

          block = {
              try {

                  loginRepoziotry.logoutRepozitory().also {
                      _loginUser.emit(it) //zde spadne
                  }
              }catch (ce: CancellationException) {
                  // You can ignore or log this exception
              } catch (e: Exception) {
                  // Here it's better to at least log the exception
                  Log.e("TAG","Coroutine error", e)
              }
          }
      )
}