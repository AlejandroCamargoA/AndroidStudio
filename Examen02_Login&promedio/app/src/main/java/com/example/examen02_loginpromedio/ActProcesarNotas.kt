package com.example.examen02_loginpromedio

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.EditText

class ActProcesarNotas : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_act_procesar_notas)
    }

    fun CalcularPromedio(view: View){
        val txtNombre = findViewById<EditText>(R.id.txtNombre)
        val txtNota1 = findViewById<EditText>(R.id.txtNota1)
        val txtNota2 = findViewById<EditText>(R.id.txtNota2)
        val txtNota3 = findViewById<EditText>(R.id.txtNota3)

        var Nombre : String = txtNombre.text.toString()
        var Nota1 : String = txtNota1.text.toString()
        var Nota2 : String = txtNota2.text.toString()
        var Nota3 : String = txtNota3.text.toString()

        val intento = Intent(this, ActFinal::class.java)
        intento.putExtra("nombre", Nombre)
        intento.putExtra("nota1", Nota1)
        intento.putExtra("nota2", Nota2)
        intento.putExtra("nota3", Nota3)

        startActivity(intento)
    }
}