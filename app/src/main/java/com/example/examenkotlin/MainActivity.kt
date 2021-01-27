package com.example.examenkotlin

import android.content.Intent
import android.os.Bundle
import android.view.View
import android.widget.ArrayAdapter
import android.widget.Spinner
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)


        var sucesiones= arrayOf("Fibonacci","Replicas","Binario")
        var suceAdaptador = ArrayAdapter<CharSequence>(this, android.R.layout.simple_spinner_dropdown_item, sucesiones)
        suceAdaptador.setDropDownViewResource(android.R.layout.simple_spinner_item)
        spinner.adapter = suceAdaptador

        if(num1==null){
            Toast.makeText(this, "Debe ingresar un numero", Toast.LENGTH_SHORT).show()
        }
        button.setOnClickListener{

            val suce = spinner.selectedItem.toString()
            val Resulc= obtenersuce(suce)


               val intent= Intent(this@MainActivity, MainActivity2::class.java)
                val b : Bundle = Bundle()
                b.putString( "datos", Resulc)
                intent.putExtras(b)
                startActivity(intent)


        }
    }

     fun obtenersuce(suce:String ): String {
        var resule = " "
        val valor1 = num1.text.toString().toInt()
        if (spinner.selectedItem == "Fibonacci") {
            val num2 = valor1
            var A = 0
            var B = 0
            var C = 1
            for (i in 0..num2) {
                //System.out.print(A+", ");
                resule = "$resule $A, "
                A = C + B
                C = B
                B = A
            }
        } else if (spinner.selectedItem == "Replicas") {
            val num2 = valor1
            var a = 1
            var b = 1
            for (i in 1..num2) {
                //System.out.print(a+", ");
                resule = "$resule $a, "
                if (b < a) {
                    b = b + 1
                } else {
                    b = 1
                    a++
                }
            }
        }
        else if (spinner.selectedItem == "Binario"){
        val num2 = valor1
        var a = 1
        var b = 1
        var Le = 1
        for (i in 1..num2) {
            // System.out.print(Le+", ");
            resule = "$resule $Le, "
            if (b < a) {
                b = b + 1
            } else {
                b = 1
                a++
                Le = if (Le == 0) {
                    1
                } else {
                    0
                }
            }
        }
    }
        return resule


}

}




