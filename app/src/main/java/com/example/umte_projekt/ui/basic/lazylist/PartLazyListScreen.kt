package com.example.umte_projekt.ui.basic.lazylist

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.Button
import androidx.compose.material.Card
import androidx.compose.material.CircularProgressIndicator
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.example.umte_projekt.base.State
import com.example.umte_projekt.ui.async.PartLazyListScreenModel
import org.koin.androidx.compose.getViewModel


@Composable
fun PartLazyListScreen(
    viewModel: PartLazyListScreenModel = getViewModel(),
) {
    val parts =  viewModel.depot.collectAsState()
    val state = viewModel.state.collectAsState()
    Text(parts.value.toString())
    when (val result = state.value) {
        State.None, State.Loading -> {
            CircularProgressIndicator()
        }
        is State.Failure -> {
            Column {
                Text(text = "Chyba - ${result.throwable.localizedMessage}")
                Button(onClick = { viewModel.fetchDepotParts() }) {
                    Text("Zkusit znovu")
                }
            }

        }
        is State.Success -> {
            if(parts!=null){

                PartsView(parts as androidx.compose.runtime.State<List<String>>)
                }

        }

    }

}
@Composable
fun PartsView(
    parts: androidx.compose.runtime.State<List<String>>,
) {
    LazyColumn(
        modifier = Modifier.fillMaxSize()
    ) {
        items(parts.value) { part ->
            Box(
                modifier = Modifier
                    .padding(16.dp)

            ) {
                Card(
                    modifier = Modifier.fillMaxWidth()
                ) {
                    Row(
                        modifier = Modifier
                            .padding(16.dp)
                    ) {
                        Text(text = part)
                        Spacer(modifier = Modifier.width(4.dp))
                        //Text(text = "Flight num: ${rocketLaunch.flightNumber}")
                    }
                }
            }
        }
    }

}








