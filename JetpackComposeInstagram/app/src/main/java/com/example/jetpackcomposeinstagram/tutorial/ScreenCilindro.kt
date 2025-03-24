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
import kotlin.math.sin

@Composable
fun ScreenCilindro() {
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

            var area_base by remember { mutableStateOf("") }
            var area_lateral by remember { mutableStateOf("") }
            var area by remember { mutableStateOf("") }
            var volumen by remember { mutableStateOf("") }
            var radio by remember { mutableStateOf("") }
            var altura by remember { mutableStateOf("") }

            Text(
                text = "Cálculo del área y volumen de un cilindro ",
                fontSize = 20.sp,
                fontWeight = FontWeight.Bold,
                modifier = Modifier.padding(10.dp)
            )

            OutlinedTextField(
                value = radio,
                onValueChange = { radio = it },
                label = {
                    Text("Introducir el radio del cilindro en centimetros ")
                },
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(10.dp),
                singleLine = true
            )

            OutlinedTextField(
                value = altura,
                onValueChange = { altura = it },
                label = {
                    Text("Introducir el altura del cilindro en centimetros ")
                },
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(10.dp),
                singleLine = true
            )

            Button(
                onClick = {
                    area_base = (2 * PI * radio.toDouble().pow(2.0)).toString()
                    area_lateral = (2 * PI * radio.toDouble() * altura.toDouble()).toString()
                    area = (area_base.toDouble() + area_lateral.toDouble()).toString()
                    volumen = (PI * radio.toDouble().pow(2.0) * altura.toDouble()).toString()
                },
                modifier = Modifier.padding(10.dp)
            ) {
                Text(text = "Calcular")
            }

            Text(
                text = "Área del cilindro de radio $radio y altura $altura : " + area,
                fontSize = 16.sp,
                fontWeight = FontWeight.Light,
                modifier = Modifier.padding(10.dp)
            )

            Text(
                text = "Volumen del cilindro de radio $radio y altura $altura : " + volumen,
                fontSize = 16.sp,
                fontWeight = FontWeight.Light,
                modifier = Modifier.padding(10.dp)
            )
        }
    }
}