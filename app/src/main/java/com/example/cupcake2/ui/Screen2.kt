package com.example.cupcake2.ui

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedButton
import androidx.compose.material3.RadioButton
import androidx.compose.material3.Text
import androidx.compose.material3.surfaceColorAtElevation
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp


@Composable
fun Screen2(
    onCancelButtonClicked: () -> Unit,
    onNextButtonClicked: () -> Unit,
    options: List<String>,
    onSelectionChanged: (Any?) -> Unit,
    subtotal: String
){

    var selectedValue by rememberSaveable { mutableStateOf("") }
    Column(
        modifier = Modifier.fillMaxSize(),
        verticalArrangement = Arrangement.SpaceBetween
    ){
        Column(

        ) {
            options.forEach{ item ->
                Row(
                    verticalAlignment = Alignment.CenterVertically,
                    modifier = Modifier
                        .fillMaxWidth()
                        .clickable {
                        selectedValue = item
                        onSelectionChanged(item)

                    }

                    ) {
                    RadioButton(
                        selected = selectedValue == item,
                        onClick = {
                            selectedValue = item
                            onSelectionChanged(item)

                        }
                    )
                    Text(item)

                }
            }

            HorizontalDivider(
                modifier = Modifier.padding(bottom = 1.dp),
                thickness = 1.dp
            )
            Text(
                "Subtotal $subtotal",
                modifier = Modifier
                    .align(Alignment.End)
                    .padding(16.dp),
                style = MaterialTheme.typography.titleLarge

            )


        }
        
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(16.dp),
            horizontalArrangement = Arrangement.spacedBy(16.dp),
            verticalAlignment = Alignment.Bottom

        ) {
            OutlinedButton(
                modifier = Modifier.weight(1f),
                onClick = onCancelButtonClicked
            ) {
                Text("Cancel")
            }
            Button(
                modifier = Modifier.weight(1f),
                onClick = onNextButtonClicked,
                enabled = selectedValue.isNotEmpty()
            ) {
                Text("Next")
            }
        }

    }
}

@Preview
@Composable
fun Screen2Preview() {
    Screen2(
        onCancelButtonClicked = {},
        onNextButtonClicked = { },
        options = listOf("option1", "Option 2", "Option 3"),
        onSelectionChanged = {  },
        subtotal = "0"
    )
}