package com.example.jetpackcomposeinstagram.tutorial

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Menu
import androidx.compose.material3.DropdownMenu
import androidx.compose.material3.DropdownMenuItem
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import com.example.jetpackcomposeinstagram.R
import com.example.jetpackcomposeinstagram.tutorial.ui.theme.JetpackComposeInstagramTheme

class EjerciciosBookActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            JetpackComposeInstagramTheme {
                MyApp()
            }
        }
    }
}

data class TabInfo(val title: String, val icon: Painter)

@Composable
fun MyApp() {
    var selectedTabIndex by remember { mutableStateOf(0) }
    //val tabs = listOf("Screen1","Screen2","Screen3")
    var expanded by remember { mutableStateOf(false) }

    val tabs = listOf(
        TabInfo("Esfera", painterResource(id = R.drawable.circle_24)),
        TabInfo("Cubo", painterResource(id = R.drawable.cube_24)),
        TabInfo("Cilindro", painterResource(id = R.drawable.cylinder)),
        TabInfo("Temperatura", painterResource(id = R.drawable.temperature_24))
    )

    when (selectedTabIndex) {
        0 -> ScreenEsfera()
        1 -> ScreenCilindro()
        2 -> ScreenCubo()
        3 -> ConversionDeTemperatura()
    }

    Box(
        modifier = Modifier
            .fillMaxSize()
            .wrapContentSize(Alignment.TopEnd)
            .padding(15.dp)
    ) {
        IconButton(onClick = { expanded = true }) {
            Icon(Icons.Default.Menu, contentDescription = "Localized description")
        }
        DropdownMenu(
            expanded = expanded,
            onDismissRequest = { expanded = false }
        ) {
            tabs.forEachIndexed { index, tabInfo ->
                DropdownMenuItem(
                    text = { Text(text = tabInfo.title) },
                    onClick = { selectedTabIndex = index },
                    leadingIcon = {
                        Icon(
                            painter = tabInfo.icon,
                            contentDescription = null
                        )
                    }
                )
            }
        }
    }

}
