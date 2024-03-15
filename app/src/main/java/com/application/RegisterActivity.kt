package com.application

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity


class RegisterActivity : AppCompatActivity() {

    lateinit var usuario: EditText
    lateinit var email: EditText
    lateinit var password: EditText
    lateinit var confirmPassword: EditText
    lateinit var almacenaDatos: Button  // Mover la inicialización aquí

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_register)

        // Conexión con la parte gráfica
        usuario = findViewById(R.id.user_Register)
        email = findViewById(R.id.email_Register)
        password = findViewById(R.id.password_Register)
        confirmPassword = findViewById(R.id.confirmPassRegister)
        almacenaDatos = findViewById(R.id.regresarLogin)  // Inicializar aquí

        almacenaDatos.setOnClickListener {
            val usuarioAgregar = usuario.text.toString().trim()
            val contrasenaAgregar = password.text.toString().trim()
            val emailAgregar = email.text.toString().trim()
            val confirmAgregar = confirmPassword.text.toString().trim()

            ValidarForm(usuarioAgregar, contrasenaAgregar, confirmAgregar, emailAgregar)
        }
    }

    fun ValidarForm(usuario: String, password: String, confirmPassword: String, email: String) {
        val regexPassword = "^(?=.*[A-Z]).{6,}\$".toRegex()
        val regexUsuario = "[A-Za-z0-9]{8}\$".toRegex()
        val regexEmail = "^[a-zA-Z0-9._%+-]+@gmail\\.com\$".toRegex()

        val validarPassword = regexPassword.matches(password)
        val validarUsuario = regexUsuario.matches(usuario)
        val validarCorreo = regexEmail.matches(email)

        if (!validarPassword) {
            mostrarToast("Se necesita 6 caracteres y al menos una letra mayúscula en la contraseña.")
        } else if (!validarUsuario) {
            mostrarToast("El usuario debe tener exactamente 8 caracteres alfanuméricos.")
        } else if (password != confirmPassword) {
            mostrarToast("Las contraseñas no coinciden.")
        } else if (!validarCorreo) {
            mostrarToast("El formato del correo electrónico es inválido.")
        } else {
            mostrarToast("Registro completado.")
            val intent = Intent(this@RegisterActivity, MainActivity::class.java)
            startActivity(intent)
        }
    }

    private fun mostrarToast(mensaje: String) {
        // Texto a reutilizar
        Toast.makeText(applicationContext, mensaje, Toast.LENGTH_SHORT).show()
    }
}
