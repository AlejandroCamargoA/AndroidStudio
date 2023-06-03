package com.example.ejercicio07_calculadora

import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import kotlin.math.sqrt

class MainActivity : AppCompatActivity() {

    //Declaracion de variables globales
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

    //Declaracion de variables globales auxiliares
    var num1:Double = 0.0
    var num2:Double = 0.0
    var operacion: Int = 0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        //Agregar objetos a las variables
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

        //Listener para distintas acciones en los botones
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
        btnPorcentaje.setOnClickListener{ Operacion(5) }

        //Boton igual, calcular dependiendo las operaciones
        btnIgual.setOnClickListener(View.OnClickListener {
            val texto = lblPantalla.text
            var res: Double
            num2 = texto.toString().toDouble()
            when (operacion){
                //Suma
                1 -> {
                    res = (num1 + num2)
                    lblPantalla.text = res.toString()
                }
                //Resta
                2 -> {
                    res = (num1 - num2)
                    lblPantalla.text = res.toString()
                }
                //Multiplicacion
                3 -> {
                    res = (num1 * num2)
                    lblPantalla.text = res.toString()
                }
                //Division
                4 -> {
                    //Condicional para evitar la division entre 0
                    if (num2 == 0.0){
                        lblPantalla.text = "No se puede dividir entre cero"
                    }else{
                        res = (num1 / num2)
                        lblPantalla.text = res.toString()
                    }
                }
                //Operacion Porcentaje
                5 -> {
                    res = (num1 * num2)/100
                    lblPantalla.text = res.toString()
                }
            }
        })

        //Calcular Raiz
        btnRaiz.setOnClickListener( View.OnClickListener {
            var aux: Double = lblPantalla.text.toString().toDouble()
            if (aux >= 0){
                var raiz: Double = sqrt(aux)
                lblPantalla.text = raiz.toString()
            }
        })

        //Calcular Inversa
        btnInversa.setOnClickListener( View.OnClickListener {
            var aux: Double = lblPantalla.text.toString().toDouble()
            //Condicional para evitar operacion inversa entre 0
            if (aux == 0.0){
                lblPantalla.text = "No se puede dividir entre cero"
            }else{
                var inverso: Double = 1 / aux
                lblPantalla.text = inverso.toString()
            }
        })

    }

    //Asignar valor a num1 y definir tipo de operacion
    private fun Operacion(op:Int) {
        val texto = lblPantalla.text
        num1 = texto.toString().toDouble()
        limpiar()
        operacion = op
    }

    //Funcion limpiar label
    private fun limpiar() {
        lblPantalla.text = "0"
    }

    //Funcion para cambiar de signo
    private fun cambiarSigno() {
        val texto = lblPantalla.text
        val existe = '-' in texto

        //Condicional para evitar el punto en el valor 0
        if(!(texto == "0")){
            if (existe){
                lblPantalla.text = texto.substring(1)
            }else{
                lblPantalla.text = "-"+"$texto"
            }
        }
    }

    //Funcion para agregar el punto
    private fun agregarPunto() {
        val texto = lblPantalla.text
        val existe = '.' in texto

        //Funcion para evitar repetir el "." si ya existe
        if (!existe){
            lblPantalla.text = "$texto"+"."
        }
    }

    //Funcion para agregar numeros al label
    private fun agregarNum(num:String) {
        val texto = lblPantalla.text

        //Condicional para reemplazar el mensaje de alerta de la divicion entre 0
        if (texto == "0" || texto == "No se puede dividir entre cero"){
            lblPantalla.text = "$num"
        }else{
            lblPantalla.text = "$texto"+"$num"
        }
    }
}