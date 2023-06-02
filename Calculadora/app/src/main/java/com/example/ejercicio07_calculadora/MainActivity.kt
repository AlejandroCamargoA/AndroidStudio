package com.example.ejercicio07_calculadora

import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import kotlin.math.sqrt

class MainActivity : AppCompatActivity() {
    lateinit var lblPantalla : TextView;
    lateinit var btn0: Button;
    lateinit var btn1: Button;
    lateinit var btn2: Button;
    lateinit var btn3: Button;
    lateinit var btn4: Button;
    lateinit var btn5: Button;
    lateinit var btn6: Button;
    lateinit var btn7: Button;
    lateinit var btn8: Button;
    lateinit var btn9: Button;
    lateinit var btnLimpiar: Button;
    lateinit var btnPunto: Button;
    lateinit var btnMasMenos: Button;
    lateinit var btnSuma: Button;
    lateinit var btnResta: Button;
    lateinit var btnMultiplicacion: Button;
    lateinit var btnDivision: Button;
    lateinit var btnRaiz: Button;
    lateinit var btnInversa: Button;
    lateinit var btnPorcentaje: Button;

    lateinit var btnIgual: Button;

    var num1:Double = 0.0
    var num2:Double = 0.0
    var operacion: Int = 0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        lblPantalla = findViewById(R.id.lblPantalla);
        btn0 = findViewById(R.id.btn0);
        btn1 = findViewById(R.id.btn1);
        btn2 = findViewById(R.id.btn2);
        btn3 = findViewById(R.id.btn3);
        btn4 = findViewById(R.id.btn4);
        btn5 = findViewById(R.id.btn5);
        btn6 = findViewById(R.id.btn6);
        btn7 = findViewById(R.id.btn7);
        btn8 = findViewById(R.id.btn8);
        btn9 = findViewById(R.id.btn9);
        btnLimpiar = findViewById(R.id.btnLimpiar)
        btnPunto = findViewById(R.id.btnPunto)
        btnMasMenos = findViewById(R.id.btnMasMenos)
        btnSuma = findViewById(R.id.btnSuma)
        btnResta = findViewById(R.id.btnResta)
        btnMultiplicacion = findViewById(R.id.btnMultiplicacion)
        btnDivision = findViewById(R.id.btnDivison)
        btnRaiz = findViewById(R.id.btnRaiz)
        btnInversa = findViewById(R.id.btnInversa)
        btnPorcentaje = findViewById(R.id.btnPorcentaje)

        btnIgual = findViewById(R.id.btnIgual)

        btn0.setOnClickListener{ agregarNum("0") }
        btn1.setOnClickListener{ agregarNum("1") }
        btn2.setOnClickListener{ agregarNum("2") }
        btn3.setOnClickListener{ agregarNum("3") }
        btn4.setOnClickListener{ agregarNum("4") }
        btn5.setOnClickListener{ agregarNum("5") }
        btn6.setOnClickListener{ agregarNum("6") }
        btn7.setOnClickListener{ agregarNum("7") }
        btn8.setOnClickListener{ agregarNum("8") }
        btn9.setOnClickListener{ agregarNum("9") }

        btnLimpiar.setOnClickListener{ limpiar() }

        btnPunto.setOnClickListener{ agregarPunto() }

        btnMasMenos.setOnClickListener{ cambiarSigno() }

        btnSuma.setOnClickListener { Operacion(1) }
        btnResta.setOnClickListener{ Operacion(2) }
        btnMultiplicacion.setOnClickListener{ Operacion(3) }
        btnDivision.setOnClickListener{ Operacion(4) }

        btnIgual.setOnClickListener(View.OnClickListener {
            val texto = lblPantalla.text
            var res: Double
            num2 = texto.toString().toDouble()
            when (operacion){
                1 -> {
                    res = (num1 + num2)
                    lblPantalla.text = res.toString()
                }
                2 -> {
                    res = (num1 - num2)
                    lblPantalla.text = res.toString()
                }
                3 -> {
                    res = (num1 * num2)
                    lblPantalla.text = res.toString()
                }
                4 -> {
                    if (num2 == 0.0){
                        lblPantalla.text = "No se puede dividir entre cero"
                    }else{
                        res = (num1 / num2)
                        lblPantalla.text = res.toString()
                    }
                }
            }
        })

        btnRaiz.setOnClickListener( View.OnClickListener {
            var aux: Double = lblPantalla.text.toString().toDouble()
            if (aux >= 0){
                var raiz: Double = sqrt(aux)
                lblPantalla.text = raiz.toString()
            }
        })

        btnInversa.setOnClickListener( View.OnClickListener {
            var aux: Double = lblPantalla.text.toString().toDouble()
            var inverso: Double = aux * 0.5
            lblPantalla.text = inverso.toString()
        })

        btnPorcentaje.setOnClickListener(View.OnClickListener {

        })
    }
    private fun Operacion(op:Int) {
        val texto = lblPantalla.text
        num1 = texto.toString().toDouble()
        limpiar()
        operacion = op
    }

    private fun limpiar() {
        lblPantalla.text = "0"
    }

    private fun cambiarSigno() {
        val texto = lblPantalla.text
        val existe = '-' in texto

        if(!(texto == "0")){
            if (existe){
                lblPantalla.text = texto.substring(1)
            }else{
                lblPantalla.text = "-"+"$texto"
            }
        }
    }

    private fun agregarPunto() {
        val texto = lblPantalla.text
        val existe = '.' in texto

        if (!existe){
            lblPantalla.text = "$texto"+"."
        }
    }

    private fun agregarNum(num:String) {
        val texto = lblPantalla.text
        if (texto == "0" || texto == "No se puede dividir entre cero"){
            lblPantalla.text = "$num"
        }else{
            lblPantalla.text = "$texto"+"$num"
        }
    }
}