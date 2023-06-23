package com.example.ejercicio09_ejercicioactivity01

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
    fun enviarUsuario(view: View){
        val txtUsuario = findViewById<EditText>(R.id.txtUsuario)
        var usuario : String = txtUsuario.text.toString()

        val intento = Intent(this, MainActivity2::class.java)
        intento.putExtra("usuario", usuario)
        startActivity(intento)
    }
}