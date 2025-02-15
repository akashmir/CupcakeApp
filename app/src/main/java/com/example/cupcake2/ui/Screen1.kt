package com.example.cupcake2.ui

import androidx.annotation.StringRes
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.cupcake2.AppData.quantityOptions
import com.example.cupcake2.R


@Composable
fun Screen1(
    onNextButtonClicked: (Any?) -> Unit
){
       Column(
           modifier = Modifier.fillMaxSize(),
           verticalArrangement = Arrangement.Center,
           horizontalAlignment = Alignment.CenterHorizontally
       ) {
           Image(
               painter = painterResource(id = R.drawable.cupcake),
               contentDescription = null,
               //modifier = Modifier.height(300.dp)
           )
           Text(
               text = "Order cupcake",
               style = MaterialTheme.typography.headlineMedium,
               modifier = Modifier.padding(top = 16.dp)
               )
           Spacer(modifier = Modifier.height(150.dp))
           Column(

               modifier = Modifier
                   .fillMaxWidth()
                   .padding(16.dp),
               verticalArrangement = Arrangement.Bottom,
               horizontalAlignment = Alignment.CenterHorizontally

            ){
              quantityOptions.forEach{ item->
//                  Button(
//                       onClick = onNextButtonClicked ,
//                       modifier = Modifier
//                           .fillMaxWidth()
//                           .padding(6.dp)
//
//                   ) {
//                       Text(
//                           text = stringResource(item.first)
//                       )
//                   }
                  SetQuantityButton(
                      idLabel = item.first,
                      onClick = { onNextButtonClicked(item.second) }
                  )
               }
           }
       }

}

@Composable
fun SetQuantityButton(
    @StringRes idLabel: Int,
    onClick : () -> Unit
){
    Button(
        onClick = onClick,
        modifier = Modifier
            .fillMaxWidth()
            .padding(6.dp)
    ) {
        Text(
            text = stringResource(idLabel)
        )
    }
}

@Preview
@Composable
fun PreviewScreen1(){
    Screen1(
        onNextButtonClicked = {}
    )
}

