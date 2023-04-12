package com.example.umte_projekt.data.remote.service

import com.example.umte_projekt.data.model.response.AllPartDepot
import com.example.umte_projekt.data.model.response.PartDepotStatus
import retrofit2.http.*

interface DepotServiceAPI {
    @FormUrlEncoded
    @POST("addItemApp")
    suspend fun fetchAddItem(

        @Field("druhDilu") typePart:String,  @Field("typDilu")subtypePart:String,
        @Field("nazevdilu") namePart:String,  @Field("parametryDilu")parametrsPart:String,
        @Field("vyrobceDilu") manufacturePart:String,
        @Field("pocetKusu") countPart:Int

    ): PartDepotStatus?

    @FormUrlEncoded
    @POST("addItemPieceApp")
    suspend fun fetchAddItemPiece(
        @Field("nazevdilu") namePart:String, @Field("pocetKusu") countPart:Int

    ):PartDepotStatus?
    @FormUrlEncoded
    @POST("removeItemPieceApp")
    suspend fun fetchRemoveItemPiece(
        @Field("nazevdilu") namePart:String, @Field("pocetKusu") countPart:Int

    ): Map<String, String>?

    @GET("/sklad")
    suspend fun fetchDepot(

    ):List<AllPartDepot>?//???

}