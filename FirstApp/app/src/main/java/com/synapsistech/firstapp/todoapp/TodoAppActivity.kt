package com.synapsistech.firstapp.todoapp

import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.recyclerview.widget.RecyclerView
import com.synapsistech.firstapp.R

class TodoAppActivity : AppCompatActivity() {

    private lateinit var rvCategories: RecyclerView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_todo_app)
        initComponent()
        initUI()

    }

    private fun initUI() {

    }

    private fun initComponent(){
        rvCategories = findViewById(R.id.rvCategories)
    }

}