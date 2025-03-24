package com.example.jetpackcomposeinstagram.tutorial

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

@Composable
fun AreaCirculo(){
    Column (
        modifier = Modifier.fillMaxSize(),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        var radio by remember { mutableStateOf("") }
        var longitud by remember { mutableStateOf("") }
        var area by remember { mutableStateOf("") }

        OutlinedTextField(
            value = radio,
            onValueChange = {radio = it},
            label = {
                Text("Radio en Centimetros")
            },
            modifier = Modifier
                .fillMaxWidth()
                .padding(10.dp),
            singleLine = true
        )

        Button(
            onClick = {
                longitud = (kotlin.math.PI * 2 * radio.toDouble() ).toString()
                area = (kotlin.math.PI * radio.toDouble() ).toString()
            },
            modifier = Modifier.padding(10.dp)
        ) {
           Text("Calcular")
        }

        Text(
            text = "Longitud de la circunferencia : " +longitud,
            color = Color.Blue,
            fontSize = 20.sp,
            fontWeight = FontWeight.Bold,
            modifier = Modifier.padding(10.dp)
        )

        Spacer(modifier = Modifier.padding(10.dp))

        Text(
            text = "Area de la circunferencia : " +area,
            color = Color.Blue,
            fontSize = 20.sp,
            fontWeight = FontWeight.Bold,
            modifier = Modifier.padding(10.dp)
        )
    }
}