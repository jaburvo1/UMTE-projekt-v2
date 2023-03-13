package com.example.umte_projekt.data.remote.service

import android.provider.ContactsContract.CommonDataKinds.Email


interface LoginService {

    @POST("/loginApp")
    suspend fun fetchLogin(
        @Path("userEmail") email:  String, @Path("userPassword") pasword:String
    ): Int ?

    @GET("/logoutApp")
    suspend fun fetchLogout(
    ): Int ?
}