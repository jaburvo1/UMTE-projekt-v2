package com.example.umte_projekt.data.remote.service

import com.example.umte_projekt.data.model.response.AllPartDepot
import com.example.umte_projekt.data.model.response.PartDepot
import retrofit2.http.GET
import retrofit2.http.Multipart
import retrofit2.http.POST
import retrofit2.http.Path

interface DepotServiceAPI {
    @Multipart
    @POST("addItem")
    suspend fun fetchAddItem(

       @Path("druhDilu") typePart:String,  @Path("typDilu")subtypePart:String,
       @Path("nazevdilu") namePart:String,  @Path("parametryDilu")parametrsPart:String,
       @Path("vyrobceDilu") manufacturePart:String,
       @Path("pocetKusu") countPart:Int

    ):PartDepot?

    @Multipart
    @POST("addItemPiece")
    suspend fun fetchAddItemPiece(
        @Path("nazevdilu") namePart:String, @Path("pocetKusu") countPart:Int

    ):PartDepot?
    @Multipart
    @POST("removeItemPiece")
    suspend fun fetchRemoveItemPiece(
        @Path("nazevdilu") namePart:String, @Path("pocetKusu") countPart:Int

    ):PartDepot?

    @GET("/sklad")
    suspend fun fetchDepot(

    ):List<AllPartDepot>?//???

}