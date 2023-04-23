package com.example.umte_projekt.ui.basic.form

import android.Manifest
import android.annotation.SuppressLint
import android.app.Activity
import android.content.Context
import android.content.Intent
import android.content.pm.PackageManager
import android.os.Build
import android.widget.Toast
import androidx.activity.compose.ManagedActivityResultLauncher
import androidx.activity.compose.rememberLauncherForActivityResult
import androidx.activity.result.contract.ActivityResultContracts
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.foundation.verticalScroll
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
import androidx.core.app.ActivityCompat
import com.example.umte_projekt.data.enum.TypeOperation
import com.example.umte_projekt.ui.async.FormDepotScreenModel
import com.example.umte_projekt.ui.readerQR.ActivityResultContractImplement
import com.example.umte_projekt.ui.views.RadioText
import cz.uhk.umte.R
import org.koin.androidx.compose.getViewModel


@SuppressLint("UnusedMaterialScaffoldPaddingParameter")
@Composable
fun FormDepotScreen(
    viewModel: FormDepotScreenModel = getViewModel(),
)  {
    val context = LocalContext.current
    val inputNamePart = remember { mutableStateOf("") }
    val inputTypePart = remember { mutableStateOf("") }
    val inputSubtypePart = remember { mutableStateOf("") }
    val inputParametrsPart = remember { mutableStateOf("") }
    val inputManufacturePart = remember { mutableStateOf("") }
    val inputCountPart = remember { mutableStateOf("") }

    val status = viewModel.depot.collectAsState()

    val operatinoTypeSelection = remember { mutableStateOf("") }
    val openDialogForm = remember { mutableStateOf(false)  }
    val openDialogTypeOperation = remember { mutableStateOf(false)  }
    val scrollState = rememberScrollState()
    openDialogTypeOperation.value = false

    val permissionGranted = remember { mutableStateOf(isNotificationGranted(context)) }

    val launcher = rememberLauncherForActivityResult(
        contract = ActivityResultContracts.RequestPermission(),
        onResult = { isGranted ->
            if (isGranted) {
                Toast.makeText(context, "Povoleni udeleno", Toast.LENGTH_SHORT).show()
            } else {
                Toast.makeText(context, "Povoleni NEUDELENO", Toast.LENGTH_SHORT).show()
            }

            permissionGranted.value = isGranted
        }
    )

   requestCameraPermission(context, launcher)


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

        if (openDialogForm.value) {
            AlertDialog(
                onDismissRequest = {
                    // Dismiss the dialog when the user clicks outside the dialog or on the back
                    // button. If you want to disable that functionality, simply use an empty
                    // onCloseRequest.


                    openDialogForm.value = false
                    DialogProperties()
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
                            inputNamePart.value = ""
                            inputTypePart.value = ""
                            inputSubtypePart.value = ""
                            inputParametrsPart.value = ""
                            inputManufacturePart.value = ""
                            inputCountPart.value = ""


                        }) {
                        Text("ok")
                    }
                }
            )
        }
        
       Column(// or whatever your parent composable is
            modifier = Modifier
                .verticalScroll(rememberScrollState()).fillMaxSize()
        ) {
            Column(
                modifier = Modifier
                    .padding(16.dp)
                    .wrapContentHeight(),
                horizontalAlignment = Alignment.CenterHorizontally

            ) {
                Row(
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    Icon(imageVector = Icons.Default.Home, contentDescription = "")
                    Image(
                        painter = painterResource(R.drawable.ic_launcher_foreground),
                        contentDescription = ""
                    )
                    Text(
                        text = context.getString(R.string.form_screen_formDepot), style = TextStyle(
                            fontWeight = FontWeight.Normal,
                            fontSize = 24.sp,
                            letterSpacing = 0.sp
                        )
                    )
                }
                
                Spacer(modifier = Modifier.height(500.dp))

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
                    RadioText(
                        label = context.getString(TypeOperation.AddItem.nameRes),
                        operatinoTypeSelection
                    )
                    RadioText(
                        label = context.getString(TypeOperation.AddItemPiece.nameRes),
                        operatinoTypeSelection
                    )
                    RadioText(
                        label = context.getString(TypeOperation.RemoveItemPiece.nameRes),
                        operatinoTypeSelection
                    )


                }

                Spacer(modifier = Modifier.weight(1f))

                Row {


                    Button(onClick = {
                        sendData(
                            context,
                            viewModel,
                            inputNamePart.value,
                            inputCountPart.value,
                            inputTypePart.value,
                            inputSubtypePart.value,
                            inputParametrsPart.value,
                            inputManufacturePart.value,
                            operatinoTypeSelection
                        )
                        openDialogForm.value = true
                    }) {
                        Text(text = context.getString(R.string.form_screen_btnOk))
                    }

                    Button(onClick = {
                        inputNamePart.value = ""
                        inputTypePart.value = ""
                        inputSubtypePart.value = ""
                        inputParametrsPart.value = ""
                        inputManufacturePart.value = ""
                        inputCountPart.value = ""
                    }) {
                        Text(text = context.getString(R.string.form_screen_btnClear))
                    }

                    Button(onClick = { btnReadQR(context) }) {
                        Text(text = context.getString(R.string.form_screen_btnQRreader))
                    }

                }
            }
            it
        }
    }

}

fun requestCameraPermission(context: Context, launcher: ManagedActivityResultLauncher<String, Boolean>)
    {
        if (isNotificationGranted(context)) return

        launcher.launch(Manifest.permission.CAMERA)
    }


fun isNotificationGranted(context: Context): Boolean {
           return if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.TIRAMISU) {
               ActivityCompat.checkSelfPermission(
                 context,
                Manifest.permission.POST_NOTIFICATIONS
            ) == PackageManager.PERMISSION_GRANTED
           } else {
               TODO("VERSION.SDK_INT < TIRAMISU")
           }
}

fun btnReadQR(context: Context): ArrayList<String> {
   val activityResult  = ActivityResultContractImplement()
 val intent: Intent = activityResult.createIntent(context,"")
  val textString: String? =   activityResult.parseResult(1, intent)

   var  partValues = ArrayList<String>()
    if(textString!=null){
            partValues = textString.split(";") as ArrayList<String>
    }
    else{
            partValues.toMutableList().add("Chyba nacteni dat")

    }
    return partValues
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
    val countPart:Int
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



