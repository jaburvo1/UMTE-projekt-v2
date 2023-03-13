package com.example.umte_projekt.data.model.response

@kotlinx.serialization.Serializable
data class LoginUser(
    @SerialName("role")
    val role: Int
)
