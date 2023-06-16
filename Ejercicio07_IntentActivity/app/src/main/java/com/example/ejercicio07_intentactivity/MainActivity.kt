package com.example.ejercicio07_intentactivity

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.EditText

const val MENSAJE_EXTRA = "com.example.ejercicio07_intentactivity.MESSAGE"

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }
    fun llamarActividad(view: View){
        //Declarar variables val recogidas del xml
        val txtUsuario = findViewById<EditText>(R.id.txtUsuario)
        val txtClave = findViewById<EditText>(R.id.txtClave)

        //Asignar valores a variables propias
        var Usuario: String = txtUsuario.text.toString()
        var Clave: String = txtClave.text.toString()

        //Condicional para comparar credenciales
        if(Usuario == "admin" && Clave == "1234"){
            //Llamar a la otra actividad
            val intent = Intent(this, actSecundario::class.java).apply {
                putExtra(MENSAJE_EXTRA, Usuario)
            }
            startActivity(intent)
        }
    }
}