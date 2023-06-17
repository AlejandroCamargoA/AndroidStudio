package com.example.ejercicio08_activity2

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }
    fun enviarDatos(view: View){
        val intento = Intent(this, actDestino::class.java)
        intento.putExtra("nombre", "Juan")
        intento.putExtra("apPaterno", "Perez")
        intento.putExtra("apMaterno", "Lopez")
        intento.putExtra("edad", "33")
        startActivity(intento)
    }
}