package com.application

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.Toast


class RegisterActivity : AppCompatActivity() {

    lateinit var usuario: EditText
    lateinit var email: EditText
    lateinit var password: EditText
    lateinit var confirmPassword: EditText
    var almacenaDatos: Button = findViewById(R.id.regresarLogin)

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_register)

        //conexion con la parte grafica
        usuario = findViewById(R.id.user_Register)
        email = findViewById(R.id.email_Register)
        password = findViewById(R.id.password_Register)
        confirmPassword = findViewById(R.id.confirmPassRegister)

        //almacenar de forma bolatil
        val usuarioAgregar = usuario.text.toString().trim()
        val contrasenaAgregar = password.text.toString().trim()
        val emailAgregar = email.text.toString().trim()
        val confirmAgregar = confirmPassword.text.toString().trim()

        //funcion validadora
        ValidarForm(usuarioAgregar, contrasenaAgregar, confirmAgregar, emailAgregar)

    }

    fun ValidarForm(usuario: String, password: String, confirmPassword: String, email: String) {

        //expresiones regulares para validar
        val regexPassword = "[a-z0-9]{5,8}-([A-Z]{1,3})\$".toRegex()
        val regexUsuario = "[A-Za-z0-9]{8,12}\$".toRegex()
        val regexEmail = "^[a-zA-Z0-9._%+-]+@gmail\\.com\$\n".toRegex()

        //validar el match de las expresines
        val validadarPassword = regexPassword.matches(password)
        val validarUsuario = regexUsuario.matches(usuario)
        val validarCorreo = regexEmail.matches(email)

        if (!validadarPassword) {
            mostrarToast("Se necesita 6 caracteres y una letra Mayuscula")
        } else
            if (!validarUsuario) {
                mostrarToast("Se necesita mas de 8 caracteres")
            } else if (password == confirmPassword) {
                mostrarToast("Contraseñas no coincicen")
            } else if (!validarCorreo) {
                mostrarToast("Error en email")
            } else {
                mostrarToast("Registro Completado")
            }

    }

    private fun mostrarToast(mensaje: String) {
        // Texto a reutilizar
        Toast.makeText(applicationContext, mensaje, Toast.LENGTH_SHORT).show()
    }

}