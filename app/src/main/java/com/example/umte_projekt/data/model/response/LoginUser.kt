package com.example.umte_projekt.data.model.response

import kotlinx.serialization.SerialName

class LoginUser {
    @kotlinx.serialization.Serializable
    data class LoginUser(
        @SerialName("role")
        val role: Int
    )
}


