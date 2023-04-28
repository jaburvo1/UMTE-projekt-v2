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
      val statusTexts : Map<String, String>
      val statusText :String
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
        val statusTexts : Map<String, String>
        val statusText :String
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
       val statusTexts : Map<String, String>
       val statusText :String
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
    suspend fun fetchDepot():ArrayList<String> {
       val partsListJson = depotService.fetchDepot()
        val parts: java.util.ArrayList<AllPartDepot>
        val partsDepotString :ArrayList<String> = ArrayList()
        if(partsListJson!=null) {
            parts = Json.decodeFromString<List<AllPartDepot>>(partsListJson) as ArrayList<AllPartDepot>
           for ( part in parts){
               val partString = "nazev dilu: "+part.namePart+" druh dilu: "+part.typePart+" typ dilu: "+part.subtypePart +" parametry dilu: "+ part.parametrsPart +" vyrobce dilu: "+ part.manufacturePart +" pocet diliu: "+part.countPart
                partsDepotString.add(partString)
            }
        }
        return partsDepotString
    }

    suspend fun addItemRepozitory(typePart:String, subtypePart:String, namePart:String, parametrsPart:String,
                                  manufacturePart:String, countPart:Int): String?
    { val status:String
        if((typePart == "")||(subtypePart == "")||(namePart == "")||(parametrsPart == "")||
            (manufacturePart == "")||(countPart<=0)){
            status = "Nevyplněny všechny údaje po vložení nového druhu dílu"
        }
        else{
         status  = fetchAddItem(typePart,subtypePart,namePart,parametrsPart,manufacturePart,countPart)
        }
       return status
    }
    suspend fun addItemPieceRepozitory(namePart: String, countPart: Int): String?{
        val status:String
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
        val status:String
        if((namePart=="")||(namePart==" ")||(countPart<=0))
        {
            status = "Nevyplnení nazev dílu, nebo počet kusu"
        }
        else{
            status =  fetchRemoveItemPiece(namePart,countPart)
        }
        return status

    }
    suspend fun depotPart(){
        fetchDepot()
    }
     fun default():String{

       val status = "Nevybrán typ operace co se mám porvést"
        return status;
    }
    }
