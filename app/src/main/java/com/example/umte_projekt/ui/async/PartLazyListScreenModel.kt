package com.example.umte_projekt.ui.async

import android.util.Log
import com.example.umte_projekt.base.BaseViewModel
import com.example.umte_projekt.data.repository.DepotRepozitory
import kotlinx.coroutines.CancellationException
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow

class PartLazyListScreenModel(
    private val depotRepoziotry: DepotRepozitory

) : BaseViewModel() {
    private val _depotFlow = MutableStateFlow<List<String>?>(emptyList())
    val depot = _depotFlow.asStateFlow()









    fun fetchDepotParts() = launch(
        block = {
            try {

                _depotFlow.emit(depotRepoziotry.fetchDepot())
            }catch (ce: CancellationException) {
                // You can ignore or log this exception
               // val test = 1
            } catch (e: Exception) {
                // Here it's better to at least log the exception
                Log.e("TAG","Coroutine error", e)
            }
        }
    )
}