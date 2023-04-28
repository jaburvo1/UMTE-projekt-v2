package com.example.umte_projekt.ui.async

import android.util.Log
import com.example.umte_projekt.base.BaseViewModel
import com.example.umte_projekt.data.repository.LoginRepoziotry
import kotlinx.coroutines.CancellationException
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow


class FormLoginScreenModel(

   private val loginRepoziotry:LoginRepoziotry

): BaseViewModel()

{

    private val _loginUser = MutableStateFlow<Int>(0)
    val loginUser = _loginUser.asStateFlow()


    fun fetchLoginUser(email:String, password:String) = launch(

        block = {
            try {
               loginRepoziotry.loginRepozitory(email, password).also {
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

    fun setRole(role:Int) = launch(
        block = {
            _loginUser.emit(role)
        }
    )
    }
