package com.example.umte_projekt.data.repository

import android.annotation.SuppressLint
import com.example.umte_projekt.data.model.response.LoginUser
import com.example.umte_projekt.data.remote.service.LoginServiceAPI
import kotlinx.coroutines.runBlocking
import java.util.*

class LoginRepoziotry(
    private val loginServiceAPI: LoginServiceAPI)
    : BaseRepository() {
    var role: Int = 0




      @SuppressLint("SuspiciousIndentation")
      suspend fun loginRepozitory(email:String, password:String):Int{
        if((email.equals(""))||(password.equals(""))||(email.equals(" "))||(password.equals(" "))){
            role = -1;
        }
        else{
              val loginUserRespponse = fetchLogin(email, password) // zde chyba
                if(loginUserRespponse != null){
                    role =  LoginUser.toString().toInt()
                }

        }
        return role
    }

  suspend  fun fetchLogin(email: String, password: String):Int? {
          return loginServiceAPI.fetchLogin(email, password)?.toIntOrNull() //zde spadne

    }

    suspend fun fetchLogout(): Int?{
        return loginServiceAPI.fetchLogout()
    }

    fun logoutRepozitory():Int {

        if (role != 0) {
            runBlocking {
                val loginUserRespponse = fetchLogout()
                if (loginUserRespponse != null) {
                    role = LoginUser.toString().toInt()
                }
                role = LoginUser.toString().toInt()
            }
        }
        return this.role
    }
}




