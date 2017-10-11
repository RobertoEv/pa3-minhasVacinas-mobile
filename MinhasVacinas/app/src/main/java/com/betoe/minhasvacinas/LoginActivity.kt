package com.betoe.minhasvacinas

import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_login.*

class LoginActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)

        loginSignInButtonId.setOnClickListener {
            verifyBlankSpaces()
        }

        loginSignUpButton.setOnClickListener {
            var signUpIntent = Intent(this, RegisterActivity::class.java)
            startActivity(signUpIntent)
        }
    }

    fun verifyBlankSpaces() {
        var errorMessage: String = "Por favor, preencher: "
        val email = loginEmailId?.text.toString().trim()
        val password = loginPasswordId?.text.toString().trim()
        var validator = true

        if (email.isNullOrBlank()){
            errorMessage = errorMessage + "\nEmail"
            validator = false
        }

        if (password.isNullOrBlank()){
            errorMessage = errorMessage + "\nSenha"
            validator = false
        }

        if (validator == false) {
            Toast.makeText(this, errorMessage, Toast.LENGTH_LONG).show()
        }
    }
}
