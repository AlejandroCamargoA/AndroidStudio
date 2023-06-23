package com.example.ejercicio09_ejercicioactivity01

import android.annotation.SuppressLint
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.EditText
import android.widget.TextView

class MainActivity2 : AppCompatActivity() {
    @SuppressLint("MissingInflatedId")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main2)
        val bundle = intent.extras
        val usuario = bundle?.getString("usuario")
        var nivelAcceso : String = ""

        val txtUsuario = findViewById<TextView>(R.id.txtUsuarioNombre)
        val txtNivelAcceso = findViewById<TextView>(R.id.txtNivelAcceso)

        if (usuario == "admin"){
            nivelAcceso = "Administrador"
        }
        else if (usuario == "Cajero1" || usuario == "Cajero2"){
            nivelAcceso = "Caja"
        }
        else if (usuario == "Vendedor1" || usuario == "Vendedor2"){
            nivelAcceso = "Ventas"
        }
        else if (usuario == "Contador"){
            nivelAcceso = "Contabilidad"
        }
        else if (usuario == "soporte"){
            nivelAcceso = "Mantenimiento"
        }
        else{
            nivelAcceso = "Usuario no Registrado"
        }

        txtUsuario.text = usuario
        txtNivelAcceso.text = nivelAcceso
    }
}