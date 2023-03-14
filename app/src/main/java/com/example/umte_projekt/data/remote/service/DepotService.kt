package com.example.umte_projekt.data.remote.service

import retrofit2.http.GET
import retrofit2.http.POST
import retrofit2.http.Path

interface DepotService {
    @POST("/addItem")
    suspend fun fetchAddItem(

       @Path("druhDilu") typePart:String,  @Path("typDilu")subtypePart:String,
       @Path("nazevdilu") namePart:String,  @Path("parametryDilu")parametrsPart:String,
       @Path("vyrobceDilu") manufacturePart:String,
       @Path("pocetKusu") countPart:Int

    ):String

    @POST("/addItemPiece")
    suspend fun fetchAddItemPiece(
        @Path("nazevdilu") namePart:String, @Path("pocetKusu") countPart:Int

    ):String

    @POST("/removeItemPiece")
    suspend fun fetchRemoveItemPiece(
        @Path("nazevdilu") namePart:String, @Path("pocetKusu") countPart:Int

    ):String

    @GET("/sklad")
    suspend fun fetchDepot(

    ):List<String>

}