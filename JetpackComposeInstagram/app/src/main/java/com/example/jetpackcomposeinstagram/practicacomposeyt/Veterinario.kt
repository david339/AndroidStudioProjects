package com.example.jetpackcomposeinstagram.practicacomposeyt

import android.content.Intent
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.material3.OutlinedButton
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.jetpackcomposeinstagram.R

@Composable
fun Veterinario() {
    val context = LocalContext.current
    Column(
        modifier = Modifier.fillMaxSize(),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {
        Image(
            painter = painterResource(id = R.drawable.veterinario),
            contentDescription = "Logo"
        )
        Text(
            text = "Mascota Feliz",
            color = Color.Blue,
            fontSize = 48.sp
        )
        Text(text = "Bienvenido, usuario")

       Row {
           OutlinedButton(
               onClick = {
                   context.startActivity(Intent(context, ListActivityVeterinario::class.java))
               }
           ) {
               Text("Tu mascota")
           }
           Spacer(Modifier.width(10.dp))
           OutlinedButton(onClick = {}) { Text("Contenido")}
       }
    }
}