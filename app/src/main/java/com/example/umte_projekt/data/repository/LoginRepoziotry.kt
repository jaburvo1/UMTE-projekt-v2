package com.example.umte_projekt.data.repository

import com.example.umte_projekt.data.remote.service.LoginService

class LoginRepoziotry (
    private val loginService: LoginService
): BaseRepository() {

    suspend fun fetchLogin() =
        loginService.fetchLogin()

    suspend fun fetchRocketDetail() =
        loginService.fetchLogout()
    }

}

