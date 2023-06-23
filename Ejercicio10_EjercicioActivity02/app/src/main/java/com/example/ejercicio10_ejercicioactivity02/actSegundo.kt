package com.example.ejercicio10_ejercicioactivity02

import android.annotation.SuppressLint
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.TextView

class actSegundo : AppCompatActivity() {
    @SuppressLint("MissingInflatedId")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_act_segundo)

        val txtRes1 = findViewById<TextView>(R.id.lblRes1)
        val txtRes2 = findViewById<TextView>(R.id.lblRes2)

        val bundle = intent.extras
        val a = bundle?.getString("coefA").toString().toDouble()
        val b = bundle?.getString("coefB").toString().toDouble()
        val c = bundle?.getString("coefC").toString().toDouble()

        val txtObservacion = findViewById<TextView>(R.id.lblObservacion)

        var aux : Double = (Math.pow(b, 2.toDouble())) - 4*a*c
        var res1 = (-b + (Math.sqrt(aux)))/2*1
        var res2 = (-b - (Math.sqrt(aux)))/2*1

        if ( a == 0.0 || b < 0){
            txtObservacion.text = "El coeficiente (a) es 0, ya no es una funcion cuadratica"
        }
        else{
            txtObservacion.text = "Sin observaciones"
        }

        txtRes1.text = res1.toString()
        txtRes2.text = res2.toString()

    }
}