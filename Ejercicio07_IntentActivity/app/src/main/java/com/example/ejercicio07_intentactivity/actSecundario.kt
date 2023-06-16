package com.example.ejercicio07_intentactivity

import android.annotation.SuppressLint
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.TextView
import org.w3c.dom.Text

class actSecundario : AppCompatActivity() {
    @SuppressLint("MissingInflatedId")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_act_secundario)
        //Obtener el mensaje extra que viene del otro formulario
        val Mensaje = intent.getStringExtra(MENSAJE_EXTRA)
        val lblMensaje = findViewById<TextView>(R.id.lblMensaje).apply {
            text = Mensaje
        }
    }
}