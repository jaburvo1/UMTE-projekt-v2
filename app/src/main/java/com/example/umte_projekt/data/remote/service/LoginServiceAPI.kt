package com.example.umte_projekt.data.remote.service


import retrofit2.http.*


interface LoginServiceAPI {

    @FormUrlEncoded
    @POST("loginApp")
    suspend fun fetchLogin(
        @Field("userEmail") email: String, @Field("userPassword") password: String
    ):String?

    @GET("logoutApp")
    suspend fun fetchLogout(
    ):Int?
}