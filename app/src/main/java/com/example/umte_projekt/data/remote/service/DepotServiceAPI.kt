package com.example.umte_projekt.data.remote.service

import retrofit2.http.*

interface DepotServiceAPI {
    @FormUrlEncoded
    @POST("addItemApp")
    suspend fun fetchAddItem(

        @Field("druhDilu") typePart:String,  @Field("typDilu")subtypePart:String,
        @Field("nazevdilu") namePart:String,  @Field("parametryDilu")parametrsPart:String,
        @Field("vyrobceDilu") manufacturePart:String,
        @Field("pocetKusu") countPart:Int

    ): Map<String, String>?

    @FormUrlEncoded
    @POST("addItemPieceApp")
    suspend fun fetchAddItemPiece(
        @Field("nazevdilu") namePart:String, @Field("pocetKusu") countPart:Int

    ):Map<String, String>?
    @FormUrlEncoded
    @POST("removeItemPieceApp")
    suspend fun fetchRemoveItemPiece(
        @Field("nazevdilu") namePart:String, @Field("pocetKusu") countPart:Int

    ): Map<String, String>?

    @GET("/depotPartsApp")
    suspend fun fetchDepot(

    ): String?

}