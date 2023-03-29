package com.example.umte_projekt.data.repository

import android.annotation.SuppressLint
import com.example.umte_projekt.data.model.response.LoginUser

import com.example.umte_projekt.data.remote.service.LoginServiceAPI
import kotlinx.coroutines.runBlocking

class LoginRepoziotry(
    private val loginServiceAPI: LoginServiceAPI)
    : BaseRepository() {
    var role: Int = 0




      @SuppressLint("SuspiciousIndentation")
      fun loginRepozitory(email:String, password:String):Int{
        if((email.equals(""))||(password.equals(""))){
            role = -1;
        }
        else{
            runBlocking {
              val loginUserRespponse = fetchLogin(email, password).toString().toInt()
                if(loginUserRespponse != null){
                    role =  LoginUser.toString().toInt()
                }
            }

        }
        return role
    }

  suspend  fun fetchLogin(email: String, password: String):Int? {
      return loginServiceAPI.fetchLogin(email, password)
    }

    suspend fun fetchLogout(): Int{
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




