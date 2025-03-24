package com.synapsistech.firstapp.imccalculator

import android.content.Intent
import android.icu.text.DecimalFormat
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.cardview.widget.CardView
import androidx.core.content.ContextCompat
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.google.android.material.floatingactionbutton.FloatingActionButton
import com.google.android.material.slider.RangeSlider
import com.synapsistech.firstapp.R

class ImcCalculatorActivity : AppCompatActivity() {

    private var isMaleSelected:Boolean = true
    private var isFemaleSelected:Boolean = false
    private var currentWeight:Int = 60
    private var currentAge:Int = 30
    private var currentHeight:Int = 120

    private lateinit var viewMale:CardView
    private lateinit var viewFemale:CardView
    private lateinit var tvHeight:TextView
    private lateinit var rsHeight:RangeSlider
    private lateinit var btnSubtractWeight:FloatingActionButton
    private lateinit var btnPlusWeight:FloatingActionButton
    private lateinit var tvWeight:TextView
    private lateinit var btnSubtractAge:FloatingActionButton
    private lateinit var btnPlusAge:FloatingActionButton
    private lateinit var tvAge:TextView
    private lateinit var btnCalculate:Button

    //Todos pueden acceder a el, como el componente static en java
    companion object{
        const val IMC_KYE = "IMC_RESULT"
    }


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_imc_calculator)

        // aris divide las funciones en partes para que tengan mejor sintonia entre ellas
        //podemos tomar como futura estructura para apps basicas este tipo de funiciones
        //con el fin de hacer mas compacta la funcionalidad del programa y el entendimiento del mismo

        initComponents()
        initListeners()
        initUI()
    }

    private fun initUI() {
        setGenderColor()
        setWeight()
        setAge()
    }

    private fun initListeners() {
        viewMale.setOnClickListener{
            changeGender()
            setGenderColor()
        }
        viewFemale.setOnClickListener{
            changeGender()
            setGenderColor()
        }
        rsHeight.addOnChangeListener{
            _, value, _ ->
            val df = DecimalFormat("#.##")
            currentHeight = df.format(value).toInt()
            tvHeight.text = "$currentHeight cm"
        }

        btnPlusWeight.setOnClickListener{
            currentWeight += 1
            setWeight()
        }
        btnSubtractWeight.setOnClickListener {
            currentWeight -= 1
            setWeight()
        }
        btnSubtractAge.setOnClickListener {
            currentAge -=1
            setAge()
        }
        btnPlusAge.setOnClickListener {
            currentAge +=1
            setAge()
        }

        btnCalculate.setOnClickListener {
            val result = calculateIMC()
            navigateToResult(result)
        }
    }

    private fun navigateToResult(result: Double) {
        val intent = Intent(this, ResultIMCActivity::class.java)
        intent.putExtra(IMC_KYE, result)
        startActivity(intent)
    }

    private fun calculateIMC():Double {
        val df = DecimalFormat("#.##")
        val imc = currentWeight / ((currentHeight.toDouble()/100) * (currentHeight.toDouble()/100))
        return df.format(imc).toDouble()
        //Log.i("aris", "El imc es $result")
    }

    private fun setAge() {
        tvAge.text = currentAge.toString()
    }

    private fun setWeight() {
        tvWeight.text = currentWeight.toString()
    }

    private fun initComponents() {
        viewMale = findViewById(R.id.viewMale)
        viewFemale = findViewById(R.id.viewFemale)
        tvHeight = findViewById(R.id.tvHeight)
        rsHeight = findViewById(R.id.rsHeight)
        btnPlusWeight = findViewById(R.id.btnPlusWeight)
        btnSubtractWeight = findViewById(R.id.btnSubtractWeight)
        tvWeight = findViewById(R.id.tvWeight)
        btnPlusAge = findViewById(R.id.btnPlusAge)
        btnSubtractAge = findViewById(R.id.btnSubtractAge)
        tvAge = findViewById(R.id.tvAge)
        btnCalculate = findViewById(R.id.btnCalculate)
    }

    private fun changeGender(){
        isMaleSelected = !isMaleSelected
        isFemaleSelected = !isFemaleSelected
    }

    private fun setGenderColor(){
        viewMale.setCardBackgroundColor(getBackgroundColor(isMaleSelected))
        viewFemale.setCardBackgroundColor(getBackgroundColor(isFemaleSelected))
    }

    private fun getBackgroundColor(isSelectedComponent:Boolean): Int{

        val colorReference = if(isSelectedComponent){
            R.color.background_component_selected_imc
        }else{
            R.color.background_component_imc
        }
        return ContextCompat.getColor(this, colorReference)
    }
}