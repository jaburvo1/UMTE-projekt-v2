package com.example.umte_projekt.data.repository

import com.example.umte_projekt.data.model.response.AllPartDepot
import com.example.umte_projekt.data.remote.service.DepotServiceAPI
import kotlinx.serialization.decodeFromString
import kotlinx.serialization.json.Json

class DepotRepozitory(
    private val depotService: DepotServiceAPI
) :BaseRepository() {
  suspend  fun fetchAddItem(typePart:String, subtypePart:String, namePart:String, parametrsPart:String,
                            manufacturePart:String, countPart:Int): String{
       //return depotService.fetchAddItem(typePart, subtypePart, namePart, parametrsPart, manufacturePart, countPart)
      var statusTexts : Map<String, String>
      var statusText :String
      val response = depotService.fetchAddItem(typePart, subtypePart, namePart, parametrsPart, manufacturePart, countPart)
      if(response!=null) {
          statusTexts = response
          statusText = statusTexts.getValue("response")
      }
      else{

          statusText = "Nastala chyba"
      }
      return statusText

    }
    suspend fun fetchAddItemPiece(namePart:String, countPart:Int) : String {
       //return depotService.fetchAddItemPiece(namePart, countPart)
        var statusTexts : Map<String, String>
        var statusText :String
        val response = depotService.fetchAddItemPiece(namePart, countPart)
        if(response!=null) {
            statusTexts = response
            statusText = statusTexts.getValue("response")
        }
        else{

            statusText = "Nastala chyba"
        }
        return statusText

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
    suspend fun fetchDepot(): List<AllPartDepot> {
       val partsListPomString: AllPartDepot? = depotService.fetchDepot()
        var parts = ArrayList<AllPartDepot>()
        if(partsListPomString!=null) {
            parts = Json.decodeFromString<List<AllPartDepot>>(partsListPomString.toString()) as ArrayList<AllPartDepot>
        }
      /*  else
        {
            parts


        }*/
        return parts
    }

    suspend fun addItemRepozitory(typePart:String, subtypePart:String, namePart:String, parametrsPart:String,
                                  manufacturePart:String, countPart:Int): String?
    { var status:String
        if((typePart.equals(""))||(subtypePart.equals(""))||(namePart.equals(""))||(parametrsPart.equals(""))||
            (manufacturePart.equals(""))||(countPart<=0)){
            status = "Nevyplněny všechny údaje po vložení nového druhu dílu"
        }
        else{
         status  = fetchAddItem(typePart,subtypePart,namePart,parametrsPart,manufacturePart,countPart)
        }
       return status
    }
    suspend fun addItemPieceRepozitory(namePart: String, countPart: Int): String?{
        var status:String
        if((namePart=="")||(namePart==" ")||(countPart<=0))
            {
            status = "Nevyplnení nazev dílu, nebo počet kusu"
            }
            else{
               status =  fetchAddItemPiece(namePart, countPart)
        }
               //return fetchAddItemPiece(namePart, countPart).toString()
        return status
    }
    suspend fun removeItemPieceRepozitory(namePart: String, countPart: Int):String?{
        var status:String
        if((namePart=="")||(namePart==" ")||(countPart<=0))
        {
            status = "Nevyplnení nazev dílu, nebo počet kusu"
        }
        else{
            status =  fetchRemoveItemPiece(namePart,countPart)
        }
              //return  fetchRemoveItemPiece(namePart,countPart).toString()
        return status

    }
    suspend fun depotPart(){
        fetchDepot()
    }
     fun default():String?{

       var status = "Nevybrán typ operace co se mám porvést"
        return status;
    }
    }
