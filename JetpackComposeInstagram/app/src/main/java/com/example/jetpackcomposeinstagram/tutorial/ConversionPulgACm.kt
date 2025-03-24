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
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

@Composable
fun ConversionPulgACm() {
    Column(modifier = Modifier.padding(30.dp)) {
        Text(
            text = "Conversión de pulgada a cm",
            textAlign = TextAlign.Center,
            color = Color.Green,
            fontWeight = FontWeight.Bold,
            fontSize = 32.sp
        )
    }
    Column(
        modifier = Modifier.fillMaxSize().padding(20.dp),
        verticalArrangement = Arrangement.Center
    ) {
        val const_pulgada: Double = 2.54
        var medida_pulgada by remember { mutableStateOf("") }
        var resultado_cm by remember { mutableStateOf("") }

        //Edit text para ingresar el valor de la medida en pulgadas

        OutlinedTextField(
            value = medida_pulgada,
            onValueChange = { medida_pulgada = it },
            label = {
                Text("Medida en pulgadas")
            },
            modifier = Modifier
                .fillMaxWidth()
                .padding(10.dp),
            singleLine = true
        )

        Button(
            onClick = {
                resultado_cm = (medida_pulgada.toDouble() * const_pulgada).toString()
            },
            modifier = Modifier.padding(10.dp)
        ) {
            Text(text = "Calcular")
        }

        Text(
            text = "De Pulgadas : " + medida_pulgada + " a centimetros : " + resultado_cm,
            color = Color.Blue,
            modifier = Modifier.padding(10.dp)
        )
    }
}