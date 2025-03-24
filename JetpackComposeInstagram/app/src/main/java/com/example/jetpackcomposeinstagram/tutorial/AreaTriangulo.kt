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
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import kotlin.math.sin

@Composable
fun AreaTriangulo() {
    Column(
        modifier = Modifier.fillMaxSize(),
        verticalArrangement = Arrangement.Center
    ) {
        var altura by remember { mutableStateOf("") }
        var base by remember { mutableStateOf("") }
        var area by remember { mutableStateOf("") }

        OutlinedTextField(
            value = altura,
            onValueChange = { altura = it },
            label = {
                Text("Altura en centimetros :")
            },
            modifier = Modifier
                .fillMaxWidth()
                .padding(10.dp),
            singleLine = true
        )

        OutlinedTextField(
            value = base,
            onValueChange = { base = it },
            label = {
                Text("Base en centimetros :")
            },
            modifier = Modifier
                .fillMaxWidth()
                .padding(10.dp),
            singleLine = true
        )

        Button(
            onClick = {
                area = (altura.toDouble() * base.toDouble() / 2.0).toString()
            },
            modifier = Modifier.padding(10.dp)
        ) {
            Text(text = "Calcular")
        }

        Text(
            text = "Area del Triangulo : "+area,
            color = Color.Green,
            modifier = Modifier.padding(10.dp),
            fontSize = 32.sp
        )
    }
}