package com.example.ejercicio01_notas

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import java.math.RoundingMode
import java.text.DecimalFormat

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val btnProm: Button = findViewById(R.id.btnProm)
        btnProm.setOnClickListener{ calcularProm() }

        val btnMax: Button = findViewById(R.id.btnMax)
        btnMax.setOnClickListener{ calcularMayor() }

        val btnMin: Button = findViewById(R.id.btnMin)
        btnMin.setOnClickListener{ calcularMenor() }
    }

    private fun calcularProm() {
        nada()
        val red = DecimalFormat("#.##")
        red.roundingMode = RoundingMode.DOWN

        val nota1:EditText = findViewById(R.id.txtNota01)
        val nota2:EditText = findViewById(R.id.txtNota02)
        val nota3:EditText = findViewById(R.id.txtNota03)
        val nota4:EditText = findViewById(R.id.txtNota04)

        val n1:Double = nota1.text.toString().toDouble()
        val n2:Double = nota2.text.toString().toDouble()
        val n3:Double = nota3.text.toString().toDouble()
        val n4:Double = nota4.text.toString().toDouble()

        val prom:Double = (n1 + n2 + n3 + n4) / 4

        val promR = red.format(prom)

        val txtProm:TextView = findViewById(R.id.txtProm)
        txtProm.text = "El promedio es: $promR"
    }

    private fun calcularMayor() {
        val nota1:EditText = findViewById(R.id.txtNota01)
        val nota2:EditText = findViewById(R.id.txtNota02)
        val nota3:EditText = findViewById(R.id.txtNota03)
        val nota4:EditText = findViewById(R.id.txtNota04)

        val n1:Double = nota1.text.toString().toDouble()
        val n2:Double = nota2.text.toString().toDouble()
        val n3:Double = nota3.text.toString().toDouble()
        val n4:Double = nota4.text.toString().toDouble()

        var mayor:Double = 0.0

        val lista: List<Double> = listOf(n1, n2, n3, n4)

        for (i in lista.indices){
            if (lista[i] > mayor){
                mayor = lista[i]
            }
        }

        val txtMayor:TextView = findViewById(R.id.txtMax)
        txtMayor.text = "El numero mayor es: $mayor"
    }

    private fun calcularMenor() {
        val nota1:EditText = findViewById(R.id.txtNota01)
        val nota2:EditText = findViewById(R.id.txtNota02)
        val nota3:EditText = findViewById(R.id.txtNota03)
        val nota4:EditText = findViewById(R.id.txtNota04)

        val n1:Double = nota1.text.toString().toDouble()
        val n2:Double = nota2.text.toString().toDouble()
        val n3:Double = nota3.text.toString().toDouble()
        val n4:Double = nota4.text.toString().toDouble()

        var menor:Double = n1

        val lista: List<Double> = listOf(n1, n2, n3, n4)

        for (i in lista.indices){
            if (lista[i] < menor){
                menor = lista[i]
            }
        }

        val txtMayor:TextView = findViewById(R.id.txtMin)
        txtMayor.text = "El numero menor es: $menor"
    }
    private fun nada() {
        print("nada")
    }
}