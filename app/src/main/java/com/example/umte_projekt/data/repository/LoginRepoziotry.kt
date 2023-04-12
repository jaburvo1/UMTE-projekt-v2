package com.example.umte_projekt.data.repository


import android.annotation.SuppressLint
import com.example.umte_projekt.data.remote.service.LoginServiceAPI
import kotlinx.coroutines.runBlocking
import java.util.*



class LoginRepoziotry(
    private val loginServiceAPI: LoginServiceAPI)
    : BaseRepository() {
    var role: Int = 0


    @SuppressLint("SuspiciousIndentation")
    suspend fun loginRepozitory(email: String, password: String): Int {
        if ((email.equals("")) || (password.equals("")) || (email.equals(" ")) || (password.equals(" "))) {
            role = -2;
        } else {
            val loginUserRespponse = fetchLogin(email, password)
            if (loginUserRespponse != null) {
                role = loginUserRespponse
            }

        }
        return role
    }

    suspend fun fetchLogin(email: String, password: String): Int? {
        return loginServiceAPI.fetchLogin(email, password) //zde spadne


    }

    suspend fun fetchLogout(): Int? {
        return loginServiceAPI.fetchLogout()
    }

    fun logoutRepozitory(): Int {

        if (role != 0) {
            runBlocking {
                val loginUserRespponse = fetchLogout()
                if (loginUserRespponse != null) {
                    role = loginUserRespponse

                } else {
                    role
                }

            }
        }
        return role
    }
}






