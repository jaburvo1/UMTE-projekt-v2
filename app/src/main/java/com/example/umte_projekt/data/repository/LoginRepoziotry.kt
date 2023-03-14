package com.example.umte_projekt.data.repository

import com.example.umte_projekt.data.remote.service.LoginService

class LoginRepoziotry (
    private val loginService: LoginService
): BaseRepository() {

    suspend fun fetchLogin(email:String, password:String) =
        loginService.fetchLogin(email, password)

    suspend fun fetchLogout() =
        loginService.fetchLogout()


    suspend fun loginRepozitory(email:String, password:String){
        if((email.equals(""))||(password.equals(""))){

        }
        else{
            fetchLogin(email, password)
        }
    }

    suspend fun logoutRepozitory(role:Int){
        if(role!=0){
            fetchLogout()
        }
    }

    }

