package com.example.umte_projekt.data.remote.service

import com.example.umte_projekt.data.model.response.LoginUser
import retrofit2.http.GET
import retrofit2.http.POST
import retrofit2.http.Path


interface LoginServiceAPI {

    @POST("/loginApp")
    suspend fun fetchLogin(
        @Path("userEmail") email: String, @Path("userPassword") password: String
    ): Int

    @GET("/logoutApp")
    suspend fun fetchLogout(
    ):Int
}