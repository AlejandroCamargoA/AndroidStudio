package com.example.examen02_loginpromedio

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
    fun IniciarSesion(view: View){
        val txtUsuario = findViewById<EditText>(R.id.txtUsuario)
        val txtClave = findViewById<EditText>(R.id.txtClave)

        var Usuario: String = txtUsuario.text.toString()
        var Clave: String = txtClave.text.toString()

        if(Usuario == "admin" && Clave == "1234"){
            val intento = Intent(this, ActProcesarNotas::class.java)
            startActivity(intento)
        }
    }
}