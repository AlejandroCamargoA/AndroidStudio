package com.example.examen_retirosharedpreferences

import android.content.Intent
import android.content.SharedPreferences
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText

class MainActivity : AppCompatActivity() {

    private lateinit var sharedPreferences: SharedPreferences
    private val PREFS_NAME = "MisPreferencias"
    private val SALDO_KEY = "saldo"

    private lateinit var btnAbrirCuenta: Button
    private lateinit var etSaldoInicial: EditText

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        sharedPreferences = getSharedPreferences(PREFS_NAME, MODE_PRIVATE)
        btnAbrirCuenta = findViewById(R.id.btnAbrirCuenta)
        etSaldoInicial = findViewById(R.id.etSaldoInicial)

        btnAbrirCuenta.setOnClickListener {
            val saldoInicialString = etSaldoInicial.text.toString()
            if (saldoInicialString.isNotEmpty()) {
                val saldoInicial = saldoInicialString.toFloat()

                val editor = sharedPreferences.edit()
                editor.putFloat(SALDO_KEY, saldoInicial)
                editor.apply()

                val intent = Intent(this@MainActivity, actRetiroDeposito::class.java)
                startActivity(intent)
            }
        }

    }
}