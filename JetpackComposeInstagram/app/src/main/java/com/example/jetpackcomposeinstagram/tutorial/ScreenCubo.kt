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
import kotlin.math.pow

@Composable
fun ScreenCubo() {
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
            var area_total by remember { mutableStateOf("") }
            var volumen_cubo by remember { mutableStateOf("") }
            var arista by remember { mutableStateOf("") }

            Text(
                text = "Cálculo del área y volumen de un cubo",
                fontSize = 20.sp,
                fontWeight = FontWeight.Bold,
                modifier = Modifier.padding(10.dp)
            )

            OutlinedTextField(
                value = arista,
                onValueChange = { arista = it },
                label = {
                    Text("Introducir arista del cubo en centimetros ")
                },
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(10.dp),
                singleLine = true
            )

            Button(
                onClick = {
                    area_total = (6 * arista.toDouble().pow(2.0)).toString()
                    volumen_cubo = (arista.toDouble().pow(3.0)).toString()
                },
                modifier = Modifier.padding(10.dp)
            ) {
                Text(text = "Calcular")
            }

            Text(
                text = "Área del cubo de arista $arista :"+area_total,
                fontSize = 16.sp,
                fontWeight = FontWeight.Light,
                modifier = Modifier.padding(10.dp)
            )

            Text(
                text = "Volumen del cubo de arista $arista :"+volumen_cubo,
                fontSize = 16.sp,
                fontWeight = FontWeight.Light,
                modifier = Modifier.padding(10.dp)
            )
        }
    }
}