package com.example.ejercicio08_activity2

import android.annotation.SuppressLint
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.EditText

class actDestino : AppCompatActivity() {
    @SuppressLint("MissingInflatedId")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_act_destino)

        val bundle = intent.extras
        val nombre = bundle?.getString("nombre")
        val apPaterno = bundle?.getString("apPaterno")
        val apMaterno = bundle?.getString("apMaterno")
        val edad = bundle?.getString("edad")

        val txtNombre = findViewById<EditText>(R.id.txtNombre)
        val txtApPaterno = findViewById<EditText>(R.id.txtApPaterno)
        val txtApMaterno = findViewById<EditText>(R.id.txtApMaterno)
        val txtEdad = findViewById<EditText>(R.id.txtEdad)

        txtNombre.setText(nombre)
        txtApPaterno.setText(apPaterno)
        txtApMaterno.setText(apMaterno)
        txtEdad.setText(edad)
    }
}