package com.example.ejercicio05_baskara

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import java.math.RoundingMode
import java.text.DecimalFormat
import kotlin.math.sqrt

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val btnResultado:Button = findViewById(R.id.btnCalcular)
        btnResultado.setOnClickListener{ calcular() }
    }

    private fun calcular() {
        val red = DecimalFormat("#.##")
        red.roundingMode = RoundingMode.DOWN

        val coefA:EditText = findViewById(R.id.txtCoefA)
        val coefB:EditText = findViewById(R.id.txtCoefB)
        val coefC:EditText = findViewById(R.id.txtCoefC)

        var cA:Double = coefA.text.toString().toDouble()
        var cB:Double = coefB.text.toString().toDouble()
        var cC:Double = coefC.text.toString().toDouble()

        val aux:Double = (Math.pow(cB,2.0)) - 4*cA*cC;

        var r1 = (-cB + (Math.sqrt(aux)))/2*cA
        var r2 = (-cB - (Math.sqrt(aux)))/2*cA

        val resultado:TextView = findViewById(R.id.txtViewResultado)
        resultado.text = "La raiz del polinomio es: $r1 y $r2"
    }
}