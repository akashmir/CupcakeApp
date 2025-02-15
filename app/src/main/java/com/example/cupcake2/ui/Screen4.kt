package com.example.cupcake2.ui


import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.Divider
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedButton
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier

import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp

import com.example.cupcake2.OrderUiState



@Composable
fun Screen4(
    onCancelButtonClicked: () -> Unit,
    orderUiState: OrderUiState,
) {


    Column (
        verticalArrangement = Arrangement.SpaceBetween
    ){
        Column(
            Modifier
                .fillMaxSize()
                .padding(16.dp),
            verticalArrangement = Arrangement.spacedBy(8.dp)


        ) {
            Text(text = "QUANTITY")
            Text(
                text = "${orderUiState.quantity} Cupcakes",
                fontWeight = FontWeight.Bold
            )
            Divider(thickness = 2.dp)
            Spacer(modifier = Modifier.height(8.dp))
            Text(text = "FLAVOR")
            Text(
                text = orderUiState.flavor,
                fontWeight = FontWeight.Bold
            )
            Divider(thickness = 2.dp)
            Spacer(modifier = Modifier.height(8.dp))
            Text(text = "PICKUP DATE")
            Text(
                text = orderUiState.date,
                fontWeight = FontWeight.Bold
            )
            Divider(thickness = 2.dp)
            Spacer(modifier = Modifier.height(8.dp))
            Text(
                "SUBTOTAL",
                style = MaterialTheme.typography.headlineSmall,
                fontWeight = FontWeight.Bold,
                modifier = Modifier.align(Alignment.End)

            )
            Text(
                orderUiState.price,
                style = MaterialTheme.typography.headlineSmall,
                fontWeight = FontWeight.Bold,
                modifier = Modifier
                    .align(Alignment.End)
                    .padding(top = 8.dp, bottom = 16.dp, end = 16.dp)
            )
            Spacer(modifier = Modifier.height(150.dp))
            Column(

                verticalArrangement = Arrangement.spacedBy(8.dp)

            ) {
                Button(
                    onClick = {


                    },
                    modifier = Modifier.fillMaxWidth(),


                    ) {
                    Text("Print Order")
                }
                OutlinedButton(
                    onClick = onCancelButtonClicked,
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(top = 8.dp),


                    ) {
                    Text(
                        "Cancel",
                        color = MaterialTheme.colorScheme.error,

                    )

                }
            }


        }
    }

}



