package com.example.umte_projekt.ui.basic.form

import android.app.Activity
import android.content.Context
import android.content.Intent
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material.icons.filled.Home
import androidx.compose.runtime.*
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
import androidx.compose.ui.window.DialogProperties
import com.example.umte_projekt.data.enum.TypeOperation
import com.example.umte_projekt.ui.async.FormDepotScreenModel
import com.example.umte_projekt.ui.readerQR.BarcodeAnalyserActivity
import com.example.umte_projekt.ui.views.RadioText
import cz.uhk.umte.R
import org.koin.androidx.compose.getViewModel


@Composable
fun FormDepotScreen(
    viewModel: FormDepotScreenModel = getViewModel(),
) {
    val context = LocalContext.current
    val inputNamePart = remember { mutableStateOf("") }
    val inputTypePart = remember { mutableStateOf("") }
    val inputSubtypePart = remember { mutableStateOf("") }
    val inputParametrsPart = remember { mutableStateOf("") }
    val inputManufacturePart = remember { mutableStateOf("") }
    val inputCountPart = remember { mutableStateOf("") }

    val status = viewModel.depot.collectAsState()

    val operatinoTypeSelection = remember { mutableStateOf("") }
    var openDialogForm = remember { mutableStateOf(false)  }
    var openDialogTypeOperation = remember { mutableStateOf(false)  }
    openDialogTypeOperation.value = false



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

        if (openDialogForm.value == true) {
            AlertDialog(
                onDismissRequest = {
                    // Dismiss the dialog when the user clicks outside the dialog or on the back
                    // button. If you want to disable that functionality, simply use an empty
                    // onCloseRequest.


                    openDialogForm.value = false
                    val properties = DialogProperties()
                },
                title = {
                    Text(text = "info spracování pozadavku")
                },
                text = {
                    Text(status.value.toString())
                },
                confirmButton = {
                    Button(

                        onClick = {
                            openDialogForm.value = !openDialogForm.value
                            inputNamePart.value =""
                            inputTypePart.value =""
                            inputSubtypePart.value =""
                            inputParametrsPart.value =""
                            inputManufacturePart.value =""
                            inputCountPart.value =""


                        }) {
                        Text("ok")
                    }
                }
            )
        }
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


            Button(onClick = { sendData(context, viewModel, inputNamePart.value, inputCountPart.value, inputTypePart.value, inputSubtypePart.value, inputParametrsPart.value, inputManufacturePart.value,operatinoTypeSelection)
            openDialogForm.value=true}) {
                Text(text = context.getString(R.string.form_screen_btnOk))
            }

            Button(onClick = {
                inputNamePart.value =""
                inputTypePart.value =""
                inputSubtypePart.value =""
                inputParametrsPart.value =""
                inputManufacturePart.value =""
                inputCountPart.value =""
            }) {
                Text(text = context.getString(R.string.form_screen_btnClear))
            }

            Button(onClick = {btnReadQR(context)}) {
                Text(text = context.getString(R.string.form_screen_btnQRreader))
            }

            }
        }
        it
    }

}

fun btnReadQR(context: Context)  {
context.startActivity(Intent(context, BarcodeAnalyserActivity::class.java))
}



fun sendData(
    context: Context,
    viewModel: FormDepotScreenModel,
    namePart: String,
    countPartString: String,
    typePart: String,
    subtpyPart: String,
    parametrsPart: String,
    manufacturePart: String,
    operatinoTypeSelection: MutableState<String>
) {
    var countPart:Int
    if(countPartString!="")
    {
        countPart = countPartString.toInt()
    }
    else{
        countPart = 0
    }


    if(operatinoTypeSelection.value ==context.getString(R.string.form_screen_select_operationType_addItem)){
        viewModel.fetchAddItem(typePart,subtpyPart,namePart,parametrsPart,manufacturePart,countPart)
    }
    else{
        if(operatinoTypeSelection.value ==context.getString(R.string.form_screen_select_operationType_addItemPiece))
        {
            viewModel.fetchAddItemPiece(namePart, countPart )
        }
        else{
            if(operatinoTypeSelection.value ==context.getString(R.string.form_screen_select__operationType_removeItemPiece)){
                viewModel.fetchRemoveItemPiece(namePart, countPart)
            }
            else{
                viewModel.fetchDefault()

            }
        }
    }



    }



