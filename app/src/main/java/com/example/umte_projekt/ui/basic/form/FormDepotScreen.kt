package com.example.umte_projekt.ui.basic.form

import android.app.Activity
import android.content.Context
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material.icons.filled.Home
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.umte_projekt.data.enum.TypeOperation
import com.example.umte_projekt.ui.async.FormDepotScreenModel
import com.example.umte_projekt.ui.views.RadioText
import cz.uhk.umte.R
import org.koin.androidx.compose.getViewModel


@Composable
fun FormDepotScreen(
    viewModel: FormDepotScreenModel = getViewModel()
) {
    val context = LocalContext.current
    val inputNamePart = remember { mutableStateOf("") }
    val inputTypePart = remember { mutableStateOf("") }
    val inputSubtypePart = remember { mutableStateOf("") }
    val inputParametrsPart = remember { mutableStateOf("") }
    val inputManufacturePart = remember { mutableStateOf("") }
    val inputCountPart = remember { mutableStateOf("") }

    val operatinoTypeSelection = remember { mutableStateOf("") }


    Scaffold(topBar = {
        TopAppBar(
            title = {
                Text(text = context.getString(R.string.form_screen_formDepot))
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
        Column(
            modifier = Modifier
                .padding(16.dp)
                .fillMaxSize(),
            horizontalAlignment = Alignment.CenterHorizontally

        ) {
            Row(
                verticalAlignment = Alignment.CenterVertically
            ) {
                Icon(imageVector = Icons.Default.Home, contentDescription = "")
                Image(painter = painterResource(R.drawable.ic_launcher_foreground), contentDescription = "")
                Text(
                    text = context.getString(R.string.form_screen_formDepot), style = TextStyle(
                        fontWeight = FontWeight.Normal,
                        fontSize = 24.sp,
                        letterSpacing = 0.sp
                    )
                )
            }

            TextField(
                modifier = Modifier.fillMaxWidth(),
                value = inputNamePart.value,
                onValueChange = { text ->
                    inputNamePart.value = text
                },
                label = {
                    Text(text = context.getString(R.string.form_screen_namePart))
                }
            )

            Spacer(modifier = Modifier.height(20.dp))

            TextField(
                value = inputTypePart.value,
                onValueChange = { text ->
                    inputTypePart.value = text
                },
                label = {
                    Text(text = context.getString(R.string.form_screen_typePart))
                },
                keyboardOptions = KeyboardOptions(
                    keyboardType = KeyboardType.Text
                )
            )

            TextField(
                value = inputSubtypePart.value,
                onValueChange = { text ->
                    inputSubtypePart.value = text
                },
                label = {
                    Text(text = context.getString(R.string.form_screen_subtypePart))
                },
                keyboardOptions = KeyboardOptions(
                    keyboardType = KeyboardType.Text
                )
            )

            TextField(
                value = inputParametrsPart.value,
                onValueChange = { text ->
                    inputParametrsPart.value = text
                },
                label = {
                    Text(text = context.getString(R.string.form_screen_typePart))
                },
                keyboardOptions = KeyboardOptions(
                    keyboardType = KeyboardType.Text
                )
            )

            TextField(
                value = inputManufacturePart.value,
                onValueChange = { text ->
                    inputManufacturePart.value = text
                },
                label = {
                    Text(text = context.getString(R.string.form_screen_manufacturePart))
                },
                keyboardOptions = KeyboardOptions(
                    keyboardType = KeyboardType.Text
                )
            )

            TextField(
                value = inputCountPart.value,
                onValueChange = { text ->
                    inputCountPart.value = text
                },
                label = {
                    Text(text = context.getString(R.string.form_screen_countPart))
                },
                keyboardOptions = KeyboardOptions(
                    keyboardType = KeyboardType.Number
                )
            )



            Spacer(modifier = Modifier.weight(0.5f))

            Row {
                RadioText(label = context.getString(TypeOperation.AddItem.nameRes), operatinoTypeSelection)
                RadioText(label = context.getString(TypeOperation.AddItemPiece.nameRes), operatinoTypeSelection)
                RadioText(label = context.getString(TypeOperation.RemoveItemPiece.nameRes), operatinoTypeSelection)
            }

            Spacer(modifier = Modifier.weight(1f))

        Row() {


            Button(onClick = { sendData(context, viewModel, inputNamePart.value, inputCountPart.value)}) {
                Text(text = context.getString(R.string.form_screen_btnOk))
            }
            /*
            Button(onClick = ) {
                Text(text = context.getString(R.string.form_screen_btnClear))
            }

             */
            }
        }
        it
    }
}

fun sendData(context: Context, viewModel: FormDepotScreenModel, namePeart: String, countPart: String) {
// výber z radioButon
    var typeOpearationAddItem = context.getString(TypeOperation.AddItem.nameRes)
    var addItem = typeOpearationAddItem.toBoolean()

    var typeOpearationAddItemPiece = context.getString(TypeOperation.AddItemPiece.nameRes)
    var addItemPiece = typeOpearationAddItemPiece.toBoolean()

    var typeOpearationRemoveItemPiece = context.getString(TypeOperation.RemoveItemPiece.nameRes)
    var removeItemPiece = typeOpearationRemoveItemPiece.toBoolean()

    var status: String = ""



if(addItem  == true) {

}else{
    if(addItemPiece== true){
        status = viewModel.fetchAddItemPiece(namePart = namePeart, countPart = countPart.toInt()).toString()
    }else{
        if (removeItemPiece == true){
            status = viewModel.fetchRemoveItemPiece(namePart = namePeart, countPart = countPart.toInt()).toString()

        }else{
            status = "  Není nevybrana žádná akce"
        }
    }
}
    // alert text satus

}
