package com.synapsistech.todoapp

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.activity.viewModels
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Surface
import androidx.compose.ui.Modifier
import com.synapsistech.todoapp.addtasks.ui.TasksScreen
import com.synapsistech.todoapp.addtasks.ui.TasksViewModel
import com.synapsistech.todoapp.ui.theme.TodoAppTheme
import dagger.hilt.android.AndroidEntryPoint



@AndroidEntryPoint
class MainActivity : ComponentActivity() {

    private  val tasksViewModel:TasksViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            TodoAppTheme {
                Surface(
                    modifier = Modifier.fillMaxSize()
                ) {
                    TasksScreen(tasksViewModel)
                }
            }
        }
    }
}

