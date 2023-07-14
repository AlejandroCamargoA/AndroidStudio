package com.example.examen02_loginpromedio

import android.annotation.SuppressLint
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.EditText
import javax.microedition.khronos.egl.EGLDisplay

class ActFinal : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_act_final)

        val bundle = intent.extras
        val nombre = bundle?.getString("nombre").toString()
        val nota1 = bundle?.getString("nota1").toString().toInt()
        val nota2 = bundle?.getString("nota2").toString().toInt()
        val nota3 = bundle?.getString("nota3").toString().toInt()

        val txtNombreFinal = findViewById<EditText>(R.id.txtNombreFinal)
        val txtPromedioFinal = findViewById<EditText>(R.id.txtPromedioFinal)
        val txtEstadoFinal = findViewById<EditText>(R.id.txtEstadoFinal)

        var menor = nota1

        if (nota2 < menor){
            menor = nota2
        }
        if (nota3 < menor){
            menor = nota3
        }

        var promedio = (nota1 + nota2 + nota3 - menor) / 2

        var estado = ""

        if(promedio <= 9){
            estado = "Reprobado"
        }
        else if(promedio <= 12){
            estado = "Desaprobado"
        }
        else if(promedio <= 20){
            estado = "Aprobado"
        }

        txtNombreFinal.setText(nombre)
        txtPromedioFinal.setText(promedio.toString())
        txtEstadoFinal.setText(estado)

    }
}