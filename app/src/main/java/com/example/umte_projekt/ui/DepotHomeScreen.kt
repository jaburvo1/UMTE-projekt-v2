package com.example.umte_projekt.ui

import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.example.umte_projekt.ui.basic.form.FormDepotScreen
import com.example.umte_projekt.ui.basic.lazylist.PartLazyListScreen


@Composable
fun DepotHomeScreen(
    controller: NavHostController
) {
    // HomeScreen()

    NavHost(navController = controller, startDestination = DestinationHome) {

        composable(
            route = FormDepot,
        ) {
            FormDepotScreen()
        }

        composable(
            route = ListDepot
        ) {
            PartLazyListScreen()
        }
    }

}




private const val DestinationHome = "home"
private val FormDepot = "depot-form"
private val ListDepot = "part-list"
