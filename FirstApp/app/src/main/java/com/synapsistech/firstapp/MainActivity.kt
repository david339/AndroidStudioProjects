package com.synapsistech.firstapp

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import com.synapsistech.firstapp.appsaludo.SaludApp
import com.synapsistech.firstapp.calculadorajavaapp.CalculadoraActivity
import com.synapsistech.firstapp.imccalculator.ImcCalculatorActivity
import com.synapsistech.firstapp.todoapp.TodoAppActivity


class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)


        //creamos los liseners que al ser presionados los botones
        //navegamos entre pantallas

        val btnSaludApp = findViewById<Button>(R.id.btnSaludApp)
        val btnIMCApp = findViewById<Button>(R.id.btnIMCApp)
        val btnTODOApp = findViewById<Button>(R.id.btnTODOApp)
        val btnCalculadoraApp = findViewById<Button>(R.id.btnCalculadoraApp)

        btnSaludApp.setOnClickListener { navigateToSaludApp() }
        btnIMCApp.setOnClickListener{ navigateToIMCCalculator() }
        btnTODOApp.setOnClickListener { navigateToTODOApp() }
        btnCalculadoraApp.setOnClickListener { navigateToCalculadoraApp() }
    }

    private fun navigateToCalculadoraApp() {
        val intent = Intent(this, CalculadoraActivity::class.java)
        startActivity(intent)
    }


    private fun navigateToTODOApp() {
        val intent = Intent(this, TodoAppActivity::class.java)
        startActivity(intent)
    }

    private fun navigateToIMCCalculator() {
        val intent = Intent(this, ImcCalculatorActivity::class.java)
        startActivity(intent)
    }

    //private se usa para que esa funcion solo se use en esta clase
    //El intent como variable nos ayuda a navegar entre pantallas mandandole un this y la clase

    private fun navigateToSaludApp() {
        val intent = Intent(this, SaludApp::class.java)
        startActivity(intent)
    }


}