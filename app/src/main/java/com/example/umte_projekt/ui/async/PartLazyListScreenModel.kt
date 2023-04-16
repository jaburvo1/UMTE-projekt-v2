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
    private val _depotRepoziotry = MutableStateFlow<String?>("")
    val depot = _depotRepoziotry.asStateFlow()

    fun fetchDepotParts() = launch(
        block = {
            try {
                depotRepoziotry.fetchDepot()
            }catch (ce: CancellationException) {
                // You can ignore or log this exception
            } catch (e: Exception) {
                // Here it's better to at least log the exception
                Log.e("TAG","Coroutine error", e)
            }
        }
    )
}