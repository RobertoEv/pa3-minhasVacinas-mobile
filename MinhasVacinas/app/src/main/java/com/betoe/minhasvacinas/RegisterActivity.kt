package com.betoe.minhasvacinas

import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_register.*

class RegisterActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_register)

        registerSaveButton.setOnClickListener {

            var validator = validateFields()

        }

        registerCancelButton.setOnClickListener {
            var loginIntent = Intent(this, LoginActivity::class.java)
            startActivity(loginIntent)
        }
    }

    

    fun verifyBlankSpaces(): Boolean {
        var errorMessage: String = "Por favor, preencher: "
        val name = registerNameId?.text.toString().trim()
        val email = registerEmailId?.text.toString().trim()
        val confirmEmail = registerConfirmEmailId?.text.toString().trim()
        val password = registerPasswordId?.text.toString().trim()
        val confirmPassword = registerConfirmPasswordId?.text.toString().trim()
        var validator = true

        if (name.isNullOrBlank()) {
            errorMessage = errorMessage + "\nNome"
            validator = false
        }
        if (email.isNullOrBlank()) {
            errorMessage = errorMessage + "\nEmail"
            validator = false
        }
        if (confirmEmail.isNullOrBlank()) {
            errorMessage = errorMessage + "\nConfirmar Email"
            validator = false
        }
        if (password.isNullOrBlank()) {
            errorMessage = errorMessage + "\nSenha"
            validator = false
        }
        if (confirmPassword.isNullOrBlank()) {
            errorMessage = errorMessage + "\nConfirmar Senha"
            validator = false
        }

        if (validator == false) {
            Toast.makeText(this, errorMessage, Toast.LENGTH_LONG).show()
        }

        return validator

    }
}
