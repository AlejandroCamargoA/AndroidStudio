package com.example.ejercicio10_ejercicioactivity02

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.EditText

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }
    fun EnviarCoeficientes(view: View){
        val coefA = findViewById<EditText>(R.id.txtCoeficienteA)
        val coefB = findViewById<EditText>(R.id.txtCoeficienteB)
        val coefC = findViewById<EditText>(R.id.txtCoeficienteC)

        var a = coefA.text.toString()
        var b = coefB.text.toString()
        var c = coefC.text.toString()

        val intento = Intent(this, actSegundo::class.java)
        intento.putExtra("coefA", a)
        intento.putExtra("coefB", b)
        intento.putExtra("coefC", c)

        startActivity(intento)
    }
}