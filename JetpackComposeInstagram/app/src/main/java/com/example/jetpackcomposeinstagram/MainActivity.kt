package com.example.jetpackcomposeinstagram

import android.content.Intent
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material3.Button
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.unit.dp
import com.example.jetpackcomposeinstagram.descuentosapp.DescuentosAppActivity
import com.example.jetpackcomposeinstagram.juegosnake.SnakeGameActivity
import com.example.jetpackcomposeinstagram.logininstagram.LoginInstagramActivity
import com.example.jetpackcomposeinstagram.practicacomposeyt.LoginVeterinario
import com.example.jetpackcomposeinstagram.tutorial.EjerciciosBookActivity
import com.example.jetpackcomposeinstagram.ui.theme.JetpackComposeInstagramTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            JetpackComposeInstagramTheme {
                Surface(modifier = Modifier.fillMaxSize()) {
                    //val name = "Android"
                    Inicio()
                }
            }
        }
    }
}



@Composable
fun Inicio(){
    val context = LocalContext.current
    LazyColumn(
        contentPadding = PaddingValues(all = 25.dp),
        verticalArrangement = Arrangement.spacedBy(5.dp)
    ) {
        item {
            Button(
                onClick = {
                    context.startActivity(Intent(context, LoginVeterinario::class.java))
                },
                modifier = Modifier.fillMaxWidth()
            ) {
                Text("VeterinarioApp")
            }
        }
        item {
            Button(
                onClick = {
                    context.startActivity(Intent(context, LoginInstagramActivity::class.java))
                },
                modifier = Modifier.fillMaxWidth()
            ) {
                Text("LoginInstagram")
            }
        }
        item {
            Button(
                onClick = {
                    context.startActivity(Intent(context, EjerciciosBookActivity::class.java))
                },
                modifier = Modifier.fillMaxWidth()
            ) {
                Text("EjerciciosBook APP")
            }
        }
        item {
            Button(
                onClick = {
                    context.startActivity(Intent(context, DescuentosAppActivity::class.java))
                },
                modifier = Modifier.fillMaxWidth()
            ) {
                Text("DescuentosApp")
            }
        }
        item {
            Button(
                onClick = {
                    context.startActivity(Intent(context, SnakeGameActivity::class.java))
                },
                modifier = Modifier.fillMaxWidth()
            ) {
                Text("SnakeGame")
            }
        }
    }
}