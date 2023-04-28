package com.example.umte_projekt.data.model.response

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable
import kotlinx.serialization.builtins.ListSerializer
import kotlinx.serialization.json.JsonTransformingSerializer


@kotlinx.serialization.Serializable
data class PartDepotStatus (
    @SerialName("statusText")
    val status:String
        )


@kotlinx.serialization.Serializable
data class AllPartDepot(
    @SerialName("id")
    val id :Int,
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
    val countPart: Int,
    @SerialName("idSkald")
    val idSklad: Int

)

@Serializable
data class ALlPartsDepot(
    @Serializable(with = PartListSerializer::class)
    val parts : List<AllPartDepot>
)

object  PartListSerializer  :  JsonTransformingSerializer<List<AllPartDepot>>( ListSerializer ( AllPartDepot.serializer ()))