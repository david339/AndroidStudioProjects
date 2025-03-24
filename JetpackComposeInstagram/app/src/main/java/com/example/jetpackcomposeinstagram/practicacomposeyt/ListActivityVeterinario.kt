package com.example.jetpackcomposeinstagram.practicacomposeyt

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedButton
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.jetpackcomposeinstagram.practicacomposeyt.ui.theme.JetpackComposeInstagramTheme

class ListActivityVeterinario : ComponentActivity() {
    val datos: List<String> = listOf(
        "Razas",
        "Entrenamiento",
        "Alimentación",
        "Belleza",
        "Reproducción",
        "Salud",
        "Noticias"
    )

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            JetpackComposeInstagramTheme {
                ListaDeCaracteristicas(datos)
            }
        }
    }
}

@Composable
fun ListaDeCaracteristicas(datos: List<String>) {

    LazyColumn(
        //con el contenPadding hacemos un padding en toda la lista, para que no este
        //muy junto de la pantalla
        contentPadding = PaddingValues(all = 25.dp),
        //Separa los items en 5 dp
        verticalArrangement = Arrangement.spacedBy(5.dp)
    ) {
        items(datos) { item ->
            ListItemRow(item)
        }
    }
}

@Composable
fun ListItemRow(item: String) {
    Box(
        modifier = Modifier
            .fillMaxWidth()
            .clip(shape = MaterialTheme.shapes.small)
            .background(color = MaterialTheme.colorScheme.secondary)
            .padding(horizontal = 16.dp, vertical = 10.dp)
    )
    {
        Row {
            Text(
                text = item, modifier = Modifier
                    .weight(1f)
                    .fillMaxWidth()
            )
            OutlinedButton(
                onClick = {}
            ) {
                Text(
                    text = "Más...",
                    color = Color.White,
                    fontWeight = FontWeight.Bold,
                    fontSize = 16.sp
                )
            }
        }

    }
}

