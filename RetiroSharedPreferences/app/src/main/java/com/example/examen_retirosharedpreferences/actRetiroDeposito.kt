package com.example.examen_retirosharedpreferences

import android.content.SharedPreferences
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast

class actRetiroDeposito : AppCompatActivity() {

    private lateinit var sharedPreferences: SharedPreferences
    private val PREFS_NAME = "MisPreferencias"
    private val SALDO_KEY = "saldo"

    private var saldoActual: Float = 0f

    private lateinit var tvSaldoActual: TextView
    private lateinit var etAccion: EditText
    private lateinit var btnDepositar: Button
    private lateinit var btnRetirar: Button
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_act_retiro_deposito)

        sharedPreferences = getSharedPreferences(PREFS_NAME, MODE_PRIVATE)
        saldoActual = sharedPreferences.getFloat(SALDO_KEY, 0f)

        tvSaldoActual = findViewById(R.id.tvSaldoActual)
        etAccion = findViewById(R.id.etAccion)
        btnDepositar = findViewById(R.id.btnDepositar)
        btnRetirar = findViewById(R.id.btnRetirar)

        actualizarSaldoTextView()

        btnDepositar.setOnClickListener {
            val montoDepositoString = etAccion.text.toString()
            if (montoDepositoString.isNotEmpty()) {
                val montoDeposito = montoDepositoString.toFloat()
                saldoActual += montoDeposito
                guardarSaldo()
                actualizarSaldoTextView()
                etAccion.text.clear()
            }
        }

        btnRetirar.setOnClickListener {
            val montoRetiroString = etAccion.text.toString()
            if (montoRetiroString.isNotEmpty()) {
                val montoRetiro = montoRetiroString.toFloat()
                if (montoRetiro <= saldoActual && saldoActual - montoRetiro >= 0) {
                    saldoActual -= montoRetiro
                    guardarSaldo()
                    actualizarSaldoTextView()
                    etAccion.text.clear()
                } else {
                    Toast.makeText(this, "Monto de retiro inválido", Toast.LENGTH_SHORT).show()
                }
            }
        }

    }

    private fun guardarSaldo() {
        val editor = sharedPreferences.edit()
        editor.putFloat(SALDO_KEY, saldoActual)
        editor.apply()
    }

    private fun actualizarSaldoTextView() {
        tvSaldoActual.text = "Saldo actual: " + saldoActual + " S/."
    }

}