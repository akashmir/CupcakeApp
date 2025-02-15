package com.example.cupcake2.ui

import android.icu.text.NumberFormat
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import java.text.SimpleDateFormat
import java.util.Calendar
import java.util.Locale

import androidx.lifecycle.ViewModel
import com.example.cupcake2.AppData.flavors
import com.example.cupcake2.OrderUiState
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.update

class AppViewModel : ViewModel() {

    private val _uiState = MutableStateFlow(OrderUiState(pickupOptions = pickupOptions()))
    val uiState: StateFlow<OrderUiState> = _uiState.asStateFlow()



    fun setQuantity(numberCupcakes: Int?) {
        if (numberCupcakes != null) {
            _uiState.update { currentState ->
                currentState.copy(
                    quantity = numberCupcakes,
                    price = calculatePrice(numberCupcakes)


                )
            }
        }

    }

    private fun calculatePrice(quantity: Any? = _uiState.value.quantity, ): String {


        val calculatedPrice = quantity.toString().toInt() * 0.00

        val formattedPrice = NumberFormat.getCurrencyInstance().format(calculatedPrice)
        return formattedPrice
    }

    fun setFlavor(it: String, numberCupcakes: Any?) {
       if(it == "Vanilla") {
           val calculatedPrice = numberCupcakes.toString().toInt() * 2.00 +2.00

           val formattedPrice = NumberFormat.getCurrencyInstance().format(calculatedPrice)
          // val currentPrice = calculatePrice()
          // val newPrice = currentPrice + 2.00

            _uiState.update { currentState ->
                currentState.copy(
                    flavor = it,
                    price = formattedPrice
                )

            }
        }
        else{
           val calculatedPrice = numberCupcakes.toString().toInt() * 2.00
           val formattedPrice = NumberFormat.getCurrencyInstance().format(calculatedPrice)
           _uiState.update { currentState ->
               currentState.copy(
                   flavor = it,
                   price = formattedPrice
               )

           }
        }

    }
    fun setDate(it : String) {
        _uiState.update { currentState ->
            currentState.copy(
                date = it,


                )
        }
    }




    private fun pickupOptions(): List<String> {
        val dateOptions = mutableListOf<String>()
        val formatter = SimpleDateFormat("E MMM d", Locale.getDefault())
        val calendar = Calendar.getInstance()
        // add current date and the following 3 dates.
        repeat(4) {
            dateOptions.add(formatter.format(calendar.time))
            calendar.add(Calendar.DATE, 1)
        }
        return dateOptions
    }


    fun resetOrder() {
        _uiState.value = OrderUiState(pickupOptions = pickupOptions())
    }

}




