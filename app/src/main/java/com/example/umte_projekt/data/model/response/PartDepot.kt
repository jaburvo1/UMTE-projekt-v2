package com.example.umte_projekt.data.model.response

import kotlinx.serialization.SerialName


@kotlinx.serialization.Serializable
data class PartDepotStatus (
    @SerialName("statusText")
    val status:String
        )


@kotlinx.serialization.Serializable
data class AllPartDepot(
    @SerialName("namePart")
    val  namePart: String,
    @SerialName("typePart")
    val typePart: String,
    @SerialName("subtypePart")
    val subtypePart: String,
    @SerialName("parametrsPart")
    val parametrsPart: String,
    @SerialName("manufacturePart")
    val manufacturePart: String,
    @SerialName("countPart")
    val countPart: Int

)
@kotlinx.serialization.Serializable
data class ALlPartsDepot(
    @SerialName("partListJson")
    val parts: List<ALlPartsDepot>
)