package com.application

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        var almacenarLogIn: Button = findViewById(R.id.buttonIngresar)
        var usuarioLogIn: EditText = findViewById(R.id.userLogIn)
        var passwordLogIn: EditText = findViewById(R.id.passwordLogin)

        val registerbtn: TextView = findViewById(R.id.pantallaRegistro)
        registerbtn.setOnClickListener{
            val intent: Intent = Intent(this, RegisterActivity::class.java)
            startActivity(intent)
        }

        almacenarLogIn.setOnClickListener{
            val intent2: Intent = Intent(this, InicioActivity::class.java)
            startActivity(intent2)
        }
    }

    private fun validar(): Boolean {

        return true
    }

}