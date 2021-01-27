package com.example.examenkotlin

import android.content.Intent
import android.os.Bundle
import android.view.View
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import kotlinx.android.synthetic.main.activity_main2.*

class MainActivity2 : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main2)


        // var bundle = intent.extras
//         tv1.text = bundle?.getString("datos") ?:


        val valo = intent.getStringExtra("datos")

        tv1.text = "Su serie  es: $valo"

        button2.setOnClickListener {

            val intents= Intent(this@MainActivity2, MainActivity::class.java)
              startActivity(intents)

        }

    }
}