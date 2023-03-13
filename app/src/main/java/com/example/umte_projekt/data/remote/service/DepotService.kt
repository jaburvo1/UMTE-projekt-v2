package com.example.umte_projekt.data.remote.service

interface DepotService {
    @POST("/addItem")
    suspend fun fetchAddItem(

    ):String

    @POST("/addItemPiece")
    suspend fun fetchAddItemPiece(

    ):String

    @POST("/removeItemPiece")
    suspend fun fetchRemoveItemPiece(

    ):String

    @GET("/sklad")
    suspend fun fetchDepot(

    ):List<String>

}