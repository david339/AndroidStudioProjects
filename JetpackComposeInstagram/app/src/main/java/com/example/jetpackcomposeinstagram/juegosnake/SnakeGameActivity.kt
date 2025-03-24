package com.example.jetpackcomposeinstagram.juegosnake

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.Canvas
import androidx.compose.foundation.background
import androidx.compose.foundation.gestures.detectTapGestures
import androidx.compose.foundation.layout.*
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import kotlinx.coroutines.delay
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.input.pointer.pointerInput
import androidx.compose.ui.unit.IntOffset
import androidx.compose.ui.unit.sp
import kotlin.random.Random

class SnakeGameActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            SnakeGame()
        }
    }
}


@Composable
fun SnakeGame() {
    // Tamaño de la cuadrícula
    val gridSize = 20
    val cellSize = 20.dp

    // Estado del juego
    var snake by remember { mutableStateOf(listOf(IntOffset(5, 5))) }
    var direction by remember { mutableStateOf(IntOffset(1, 0)) }
    var food by remember { mutableStateOf(IntOffset(10, 10)) }
    var gameOver by remember { mutableStateOf(false) }
    var score by remember { mutableStateOf(0) }

    // Función para reiniciar el juego
    fun resetGame() {
        snake = listOf(IntOffset(5, 5))
        direction = IntOffset(1, 0)
        food = IntOffset(Random.nextInt(gridSize), Random.nextInt(gridSize))
        gameOver = false
        score = 0
    }

    // Función para mover la serpiente
    LaunchedEffect(Unit) {
        while (!gameOver) {
            delay(200) // Velocidad del juego
            val newHead = snake.first() + direction
            if (newHead.x < 0 || newHead.y < 0 || newHead.x >= gridSize || newHead.y >= gridSize || snake.contains(newHead)) {
                gameOver = true
            } else {
                snake = listOf(newHead) + if (newHead == food) {
                    food = IntOffset(Random.nextInt(gridSize), Random.nextInt(gridSize))
                    score += 1
                    snake
                } else {
                    snake.dropLast(1)
                }
            }
        }
    }

    // Manejo de gestos táctiles (swipe)
    val onSwipe: (IntOffset) -> Unit = { newDirection ->
        direction = newDirection
    }

    // Interfaz del juego
    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(Color.Black)
            .padding(16.dp),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        // Puntuación
        Text(
            text = "Puntuación: $score",
            color = Color.White,
            fontSize = 20.sp,
            modifier = Modifier.padding(bottom = 16.dp)
        )

        // Canvas para el juego
        Box(
            modifier = Modifier
                .size(cellSize * gridSize)
                .pointerInput(Unit) {
                    detectTapGestures { offset ->
                        val centerX = size.width / 2
                        val centerY = size.height / 2
                        when {
                            offset.x < centerX && offset.y < centerY -> onSwipe(IntOffset(-1, 0)) // Izquierda
                            offset.x > centerX && offset.y < centerY -> onSwipe(IntOffset(1, 0))  // Derecha
                            offset.x < centerX && offset.y > centerY -> onSwipe(IntOffset(0, 1))   // Abajo
                            offset.x > centerX && offset.y > centerY -> onSwipe(IntOffset(0, -1))  // Arriba
                        }
                    }
                }
        ) {
            Canvas(modifier = Modifier.fillMaxSize()) {
                // Dibujar la serpiente
                snake.forEach { segment ->
                    drawRect(
                        color = Color.Green,
                        topLeft = Offset(segment.x * cellSize.toPx(), segment.y * cellSize.toPx()),
                        size = androidx.compose.ui.geometry.Size(cellSize.toPx(), cellSize.toPx())
                    )
                }

                // Dibujar la comida
                drawRect(
                    color = Color.Red,
                    topLeft = Offset(food.x * cellSize.toPx(), food.y * cellSize.toPx()),
                    size = androidx.compose.ui.geometry.Size(cellSize.toPx(), cellSize.toPx())
                )
            }
        }

        // Mensaje de Game Over y botón de reinicio
        if (gameOver) {
            Text(
                text = "¡Game Over!",
                color = Color.Red,
                fontSize = 24.sp,
                modifier = Modifier.padding(top = 16.dp)
            )
            Button(
                onClick = { resetGame() },
                modifier = Modifier.padding(top = 16.dp)
            ) {
                Text(text = "Reiniciar")
            }
        }
    }
}