package com.betoe.minhasvacinas

import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_forgot_password.*

class ForgotPasswordActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_forgot_password)

        forgotPasswordConfirmButton.setOnClickListener {
            verifyBlankSpaces()
        }

        forgotPasswordCancelButton.setOnClickListener {
            var loginIntent = Intent(this, LoginActivity::class.java)
            startActivity(loginIntent)

        }


    }

    fun verifyBlankSpaces() {

        val email = forgotPasswordEmailId?.text.toString().trim()
        if (email.isNullOrBlank()){
            Toast.makeText(this, "Por favor preencha o email", Toast.LENGTH_LONG).show()
        }
    }
}
