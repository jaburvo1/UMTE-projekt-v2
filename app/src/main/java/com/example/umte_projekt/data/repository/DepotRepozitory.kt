package com.example.umte_projekt.data.repository

import com.example.umte_projekt.data.remote.service.DepotServiceAPI

class DepotRepozitory(
    private val depotService: DepotServiceAPI
) :BaseRepository() {
  suspend  fun fetchAddItem(typePart:String, subtypePart:String, namePart:String, parametrsPart:String,
                            manufacturePart:String, countPart:Int){
        depotService.fetchAddItem(typePart, subtypePart, namePart, parametrsPart, manufacturePart, countPart)
    }
    suspend fun fetchAddItemPiece(namePart:String, countPart:Int){
        depotService.fetchAddItemPiece(namePart, countPart)
    }
    suspend fun fetchRemoveItemPiece(namePart:String, countPart:Int){
        depotService.fetchRemoveItemPiece(namePart, countPart)
    }
    suspend fun fetchDepot(){
        depotService.fetchDepot()
    }

    suspend fun addItemRepozitory(typePart:String, subtypePart:String, namePart:String, parametrsPart:String,
                                  manufacturePart:String, countPart:Int)
    {
        if((typePart.equals(""))||(subtypePart.equals(""))||(namePart.equals(""))||(parametrsPart.equals(""))||
            (manufacturePart.equals(""))||(countPart<=0)){

        }
        else{
            fetchAddItem(typePart,subtypePart,namePart,parametrsPart,manufacturePart,countPart)
        }
    }
    suspend fun addItemPieceRepozitory(namePart: String, countPart: Int){

               return fetchAddItemPiece(namePart, countPart)
    }
    suspend fun removeItemPieceRepozitory(namePart: String, countPart: Int){

              return  fetchRemoveItemPiece(namePart,countPart)

        }
    }
