package com.example.umte_projekt.ui.basic.lazylist

import android.annotation.SuppressLint
import android.app.Activity
import android.content.Context
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.unit.dp
import com.example.umte_projekt.base.State
import com.example.umte_projekt.ui.async.PartLazyListScreenModel
import cz.uhk.umte.R
import org.koin.androidx.compose.getViewModel


@Composable
fun PartLazyListScreen(
    viewModel: PartLazyListScreenModel = getViewModel(),
) {

    val context = LocalContext.current
    val parts =  viewModel.depot.collectAsState()
    val state = viewModel.state.collectAsState()
    LaunchedEffect(Unit) {
        viewModel.fetchDepotParts();
    }


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

                PartsView(parts as androidx.compose.runtime.State<List<String>>, context)
                }

        }

    }

}
@SuppressLint("UnusedMaterialScaffoldPaddingParameter")
@Composable
fun PartsView(
    parts: androidx.compose.runtime.State<List<String>>, context:Context,
) {

    Scaffold(topBar = {
        TopAppBar(
            title = {
                Text(text = context.getString(R.string.form_screen_lazyList))
            },
            navigationIcon = {
                IconButton(onClick = { (context as Activity).finish() }) {
                    Icon(Icons.Default.ArrowBack, contentDescription = "")
                }
            },
            elevation = 8.dp,
            backgroundColor = Color.Blue,
            contentColor = Color.White
        )
    }
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
                        }
                    }
                }
            }
        }
    }

}









