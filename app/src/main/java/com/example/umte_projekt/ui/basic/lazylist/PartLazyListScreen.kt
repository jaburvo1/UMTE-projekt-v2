package com.example.umte_projekt.ui.basic.lazylist

import androidx.compose.runtime.Composable
import com.example.umte_projekt.ui.async.PartLazyListScreenModel
import org.koin.androidx.compose.getViewModel


@Composable
fun PartLazyListScreen(
    viewModel: PartLazyListScreenModel = getViewModel(),
) {
  val parts =  viewModel.fetchDepotParts()


/*
    items(listParts()) { aLlPartsDepot ->
        Box(
            modifier = Modifier.padding(16.dp)
        ) {
            Card(
                modifier = Modifier.fillMaxWidth()
            ) {
                Row(
                    modifier = Modifier
                        .background(Color.Green)
                        .padding(16.dp)
                ) {
                    Text(text = human.name)
                    Spacer(modifier = Modifier.width(4.dp))
                    Text(text = human.surname)
                }
            }
        }
    }*/
}
    /*
fun listParts(): List<ALlPartsDepot> {



    return list
}



*/