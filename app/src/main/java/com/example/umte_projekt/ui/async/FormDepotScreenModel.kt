package com.example.umte_projekt.ui.async

import com.example.umte_projekt.base.BaseViewModel
import com.example.umte_projekt.data.model.response.PartDepot
import com.example.umte_projekt.data.remote.service.LoginServiceAPI
import com.example.umte_projekt.data.repository.DepotRepozitory
import com.example.umte_projekt.data.repository.LoginRepoziotry
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow

class FormDepotScreenModel(
    private val depotRepoziotry: DepotRepozitory

) : BaseViewModel() {
    private val _depotRepoziotry = MutableStateFlow<List<PartDepot>>(emptyList())
    val depot = _depotRepoziotry.asStateFlow()

    init {
        
    }

  /*  fun fetchAddItemPiece(namePart:String, countPart:Int) = launch(
        block = {

            if (namePart.equals("")) {

            } else {
                if (countPart <= 0) {

                } else { 
                    depotRepoziotry.addItemPieceRepozitory(namePart, countPart).also {
                       _depotRepoziotry.emit(it)
                    }

                }
            }
        }
    )


            fun fetchRemoveItemPiece(namePart:String, countPart:Int) = launch(
                block = {

                    if (namePart.equals("")) {

                    } else {
                        if (countPart <= 0) {

                        } else {
                            depotRepoziotry.removeItemPieceRepozitory(namePart, countPart).also {
                               _depotRepoziotry.emit(it)
                            }

                        }
                    }
                }
            )


}*/



}
