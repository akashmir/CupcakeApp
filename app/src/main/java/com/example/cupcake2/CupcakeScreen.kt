package com.example.cupcake2

import android.content.Context
import android.content.Intent
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.platform.LocalContext
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.cupcake2.ui.AppViewModel
import com.example.cupcake2.ui.Screen1
import com.example.cupcake2.ui.Screen2
import com.example.cupcake2.ui.Screen4


@Composable
fun CupcakeScreen(
    appViewModel: AppViewModel = viewModel(),
    navController: NavHostController = rememberNavController()
)

{
  val uiState by appViewModel.uiState.collectAsState()


  NavHost(
      navController = navController,
      startDestination = "screen1",

      
  ){
    composable(route = "screen1" ) {
       Screen1(
           onNextButtonClicked = {

                   appViewModel.setQuantity(it as Int?)
                   navController.navigate("screen2")

           }
       )
    }
    composable(route = "screen2") {
        val context = LocalContext.current
        Screen2(
            subtotal = uiState.price,
            onCancelButtonClicked = { navController.navigate("screen1") },
            onNextButtonClicked = { navController.navigate("screen3") },
            onSelectionChanged = { item -> appViewModel.setFlavor(
                item.toString(),
                numberCupcakes = uiState.quantity
            ) },
            options = AppData.flavors.map { id ->  context.resources.getString(id) }
        )
    }
      composable(route = "screen3") {
          Screen2(
              onCancelButtonClicked = { navController.navigate("screen1") },
              onNextButtonClicked = { navController.navigate("screen4") },
              options = uiState.pickupOptions,
              onSelectionChanged = { appViewModel.setDate(it.toString()) },
              subtotal = uiState.price,
          )
      }
      composable(route = "screen4") {
          val context = LocalContext.current
          Screen4(

              onCancelButtonClicked = {
                  navController.navigate("screen1")
                  appViewModel.resetOrder()
              },
              orderUiState = uiState,

          )
      }



  }

}


