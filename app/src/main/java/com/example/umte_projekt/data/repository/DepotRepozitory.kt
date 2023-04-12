package com.example.umte_projekt.data.repository

import com.example.umte_projekt.data.model.response.PartDepotStatus
import com.example.umte_projekt.data.remote.service.DepotServiceAPI

class DepotRepozitory(
    private val depotService: DepotServiceAPI
) :BaseRepository() {
  suspend  fun fetchAddItem(typePart:String, subtypePart:String, namePart:String, parametrsPart:String,
                            manufacturePart:String, countPart:Int): PartDepotStatus?{
       return depotService.fetchAddItem(typePart, subtypePart, namePart, parametrsPart, manufacturePart, countPart)
    }
    suspend fun fetchAddItemPiece(namePart:String, countPart:Int) :PartDepotStatus?{
       return depotService.fetchAddItemPiece(namePart, countPart)
    }
    suspend fun fetchRemoveItemPiece(namePart:String, countPart:Int): String {
        //return depotService.fetchRemoveItemPiece(namePart, countPart)
       var statusTexts : Map<String, String>
       var statusText :String
       val response = depotService.fetchRemoveItemPiece(namePart, countPart)
       if(response!=null) {
           statusTexts = response
           statusText = statusTexts.getValue("response")
       }
        else{

           statusText = "Nastala chyba"
    }
        return statusText
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
    suspend fun addItemPieceRepozitory(namePart: String, countPart: Int): String?{

               return fetchAddItemPiece(namePart, countPart).toString()
    }
    suspend fun removeItemPieceRepozitory(namePart: String, countPart: Int):String?{

              return  fetchRemoveItemPiece(namePart,countPart).toString()

    }
    }
