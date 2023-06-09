package com.example.umte_projekt.ui.async

import android.util.Log
import com.example.umte_projekt.base.BaseViewModel
import com.example.umte_projekt.data.repository.DepotRepozitory
import kotlinx.coroutines.CancellationException
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow

class FormDepotScreenModel(
    private val depotRepoziotry: DepotRepozitory

) : BaseViewModel() {
    private val _depotRepoziotry = MutableStateFlow<String?>("")
    val depot = _depotRepoziotry.asStateFlow()



    fun fetchAddItem(typePart:String, subtypePart:String, namePart:String, parametrsPart:String,manufacturePart:String,
                     countPart:Int) = launch(
        block = {
            try {

                        depotRepoziotry.addItemRepozitory(typePart, subtypePart, namePart, parametrsPart,manufacturePart, countPart ).also { it ->
                            _depotRepoziotry.emit(it)
                        }
            }catch (ce: CancellationException) {
                // You can ignore or log this exception
            } catch (e: Exception) {
                // Here it's better to at least log the exception
                Log.e("TAG","Coroutine error", e)
            }
        }
    )

    fun fetchAddItemPiece(namePart:String, countPart:Int) = launch(
        block = {
            try {

                    depotRepoziotry.addItemPieceRepozitory(namePart, countPart).also { it ->
                       _depotRepoziotry.emit(it)
                    }
        }catch (ce: CancellationException) {
        // You can ignore or log this exception
    } catch (e: Exception) {
        // Here it's better to at least log the exception
        Log.e("TAG","Coroutine error", e)
    }
}
    )


            fun fetchRemoveItemPiece(namePart:String, countPart:Int) = launch(
                block = {


                            depotRepoziotry.removeItemPieceRepozitory(namePart, countPart).also {
                            _depotRepoziotry.emit(it)
                            }
                    }
            )

    fun fetchDefault()=launch(
        block = {


            depotRepoziotry.default().also {
                _depotRepoziotry.emit(it)
            }
        }
    )
}







