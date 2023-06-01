package com.example.ejercicio02_areatriangulo

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.TextView

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val btnCalcular:Button = findViewById(R.id.btnCalcular)
        btnCalcular.setOnClickListener{ calcularArea() }
    }

    private fun calcularArea() {
        val base:EditText = findViewById(R.id.txtBase)
        val altura:EditText = findViewById(R.id.txtAltura)

        var b:Double = base.text.toString().toDouble()
        var a:Double = base.text.toString().toDouble()

        var area:Double = (b * a) /2

        val resultado:TextView = findViewById(R.id.txtArea)
        resultado.text = "El Area del triangulo es: $area"
    }
}