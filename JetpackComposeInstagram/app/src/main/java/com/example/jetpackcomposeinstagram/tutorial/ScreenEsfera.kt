package com.example.jetpackcomposeinstagram.tutorial

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.rememberScrollState
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
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import kotlin.math.PI
import kotlin.math.pow

@Composable
fun ScreenEsfera() {
    Column(
        modifier = Modifier.fillMaxSize(),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {
        val scroll = rememberScrollState(0)
        Column(
            modifier = Modifier.fillMaxSize(),
            verticalArrangement = Arrangement.Center
        ) {
            var volumen by remember { mutableStateOf("") }
            var radio by remember { mutableStateOf("") }


            Text(
                text = "Cálculo del volumen de una esfera dado su radio",
                fontSize = 20.sp,
                fontWeight = FontWeight.Bold,
                modifier = Modifier.padding(10.dp)
            )


            OutlinedTextField(
                value = radio,
                onValueChange = { radio = it },
                label = {
                    Text("Introducir el radio de la esfera en centimetros")
                },
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(10.dp),
                singleLine = true
            )

            Button(
                onClick = {
                    volumen = (4.0 * PI * radio.toDouble().pow(3.0) / 3.0).toString()
                },
                modifier = Modifier.padding(10.dp)
            ) {
                Text(text = "Calcular")
            }

            Text(
                text = "Volumen de la esfera de radio $radio : "+ volumen,
                fontSize = 16.sp,
                fontWeight = FontWeight.Light,
                modifier = Modifier.padding(10.dp)
            )

        }
    }
}