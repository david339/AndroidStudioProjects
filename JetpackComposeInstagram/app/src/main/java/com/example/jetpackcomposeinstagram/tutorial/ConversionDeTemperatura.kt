package com.example.jetpackcomposeinstagram.tutorial

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
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
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

@Composable
fun ConversionDeTemperatura() {
    Column(modifier = Modifier.padding(20.dp)) {
        Text(
            text = "Conversión Celsius a Fahrenheit y Kelvin",
            fontSize = 20.sp,
            textAlign = TextAlign.Center,
            fontWeight = FontWeight.Bold
        )
    }
    Column(modifier = Modifier.fillMaxSize(), verticalArrangement = Arrangement.Center) {
        var celsius by remember { mutableStateOf("") }
        var farhrenheit by remember { mutableStateOf("") }
        var kelvin by remember { mutableStateOf("") }

        OutlinedTextField(
            value = celsius,
            onValueChange = { celsius = it },
            label = {
                Text("Temperatura en grados Celsius ")
            },
            modifier = Modifier
                .fillMaxWidth()
                .padding(10.dp),
            singleLine = true
        )

        Button(
            onClick = {
                farhrenheit = ((celsius.toDouble() * 9.0 / 5.0) + 32).toString()
                kelvin = (celsius.toDouble() +273.15).toString()
            },
            modifier = Modifier.padding(10.dp)
        ) {
            Text(text = "Calcular")
        }

        Text(
            text = "Temperatura en Farhenheit: "+farhrenheit,
            fontSize = 16.sp,
            fontWeight = FontWeight.ExtraBold,
            modifier = Modifier.padding(10.dp)
        )

        Text(
            text = "Temperatura en Kelvin: "+kelvin,
            fontSize = 16.sp,
            fontWeight = FontWeight.ExtraBold,
            modifier = Modifier.padding(10.dp)
        )
    }
}